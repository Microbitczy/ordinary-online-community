package cn.hiczy.chatserver.handler;


import cn.hiczy.chatserver.mapper.TOfflineMessageMapper;
import cn.hiczy.common.utils.JwtUtils;
import cn.hiczy.protobuf.MessageProto;
import cn.hiczy.protobuf.MessageProto.Message;
import cn.hiczy.protobuf.MessageProto.Message.MessageType;
import cn.hiczy.protobuf.entity.TOfflineMessage;
import cn.hiczy.protobuf.utils.ProtoMessageUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.ibatis.ognl.ObjectElementsAccessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 离线消息处理器
 */
@ChannelHandler.Sharable
@Component
public class OfflineMessageHandler extends ChannelInboundHandlerAdapter {

    @Resource
    private TOfflineMessageMapper offlineMessageMapper;

    private Set<Long> offlineMsgIds = new HashSet<>();


    /**
     * 登录后处理离线消息
     * @param ctx ctx
     * @param msg msg
     * @throws Exception e
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message = (MessageProto.Message) msg;

        switch (message.getTypeValue()){
            //如果是离线消息请求
            case MessageType.OFFLINE_MSG_REQ_VALUE:
                handleOfflineMsgReq(message, ctx);
            //如果是离线消息响应
            case MessageType.OFFLINE_MSG_RCV_VALUE:
                handleOfflineMsgRcv(message,ctx);
                break;
            //如果是其他类型的消息传给SenderHandler处理
            default:
                //处理剩下的离线消息
                handleRemainOfflineMsg(ctx);
                ctx.fireChannelRead(msg);
        }
    }


    /**
     * 将没有收到客户端发来的接收响应(OFFLINE_MSG_RCV)的离线消息再一次发送给客户端
     * @param ctx ctx
     */
    private void handleRemainOfflineMsg(ChannelHandlerContext ctx) {
        if(ObjectUtils.isEmpty(offlineMsgIds))
           return;

        List<TOfflineMessage> tOfflineMessages = offlineMessageMapper.selectBatchIds(offlineMsgIds);
        tOfflineMessages.forEach(msg -> ctx.writeAndFlush(ProtoMessageUtils.convertToMessage(msg)));
    }


    /**
     * 处理离线消息请求
     * @param message
     */
    private void handleOfflineMsgReq(Message message, ChannelHandlerContext ctx) {

        String jwt = message.getJwt();
        //从jwt中获取用户ID
        Long userId = JwtUtils.getUserId(jwt);

        //从离线消息数据库中查询是否有当前用户的离线消息
        List<TOfflineMessage> offlineMsgList = offlineMessageMapper.selectList(new LambdaQueryWrapper<TOfflineMessage>().eq(TOfflineMessage::getToId, userId));
        offlineMsgIds = offlineMsgList.stream().map(TOfflineMessage::getMId).collect(Collectors.toSet());
        //如果没有离线消息 则移除这个handler
        if (ObjectUtils.isEmpty(offlineMsgList) && ObjectUtils.isEmpty(offlineMsgList)) {
            ctx.pipeline().remove(this);
            return;
        }

        //否则将离线消息的id存进redis

        //将离线消息输出给客户端
        for(TOfflineMessage offlineMessage : offlineMsgList){
            Message tmpMessage = ProtoMessageUtils.convertToMessage(offlineMessage);
            ctx.writeAndFlush(tmpMessage);
        }


    }

    /**
     * 处理离线消息接收响应
     * @param message
     */
    private void handleOfflineMsgRcv(Message message,ChannelHandlerContext ctx ){
        if(ObjectUtils.isEmpty(offlineMsgIds)){
            //TODO 返回失败响应
            return;
        }
        long mId = message.getMId();
        if(offlineMsgIds.contains(mId)){
            //将离线消息表中的离线信息 isDeleted 设为1
            offlineMessageMapper.deleteById(mId);
            //将mId 从set 中移除
            offlineMsgIds.remove(mId);
        }

        //如果客户端接收完所有的离线消息,移除离线消息处理器
        if(ObjectUtils.isEmpty(offlineMsgIds)){
            ctx.pipeline().remove(this);
        }
    }


}
