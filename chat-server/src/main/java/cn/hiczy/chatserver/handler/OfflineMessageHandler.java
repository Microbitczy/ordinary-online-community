package cn.hiczy.chatserver.handler;

import cn.hiczy.chatserver.mapper.TMessageRecordMapper;
import cn.hiczy.chatserver.mapper.TOfflineMessageMapper;
import cn.hiczy.protobuf.MessageProto;
import cn.hiczy.protobuf.entity.TMessageRecord;
import cn.hiczy.protobuf.entity.TOfflineMessage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
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


//    @Resource
//    private TMessageRecordMapper messageRecordMapper;

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
        MessageProto.Message message = (MessageProto.Message) msg;


        String jwt = message.getJwt();
        //从jwt中获取用户ID
        Long uid = 1L;


        //从离线消息数据库中查询是否有
        List<TOfflineMessage> offlineMsgList = offlineMessageMapper.selectList(new LambdaQueryWrapper<TOfflineMessage>().eq(TOfflineMessage::getToId, uid));
        offlineMsgIds = offlineMsgList.stream().map(TOfflineMessage::getMId).collect(Collectors.toSet());
        //如果没有离线消息
        if (ObjectUtils.isEmpty(offlineMsgList) && ObjectUtils.isEmpty(offlineMsgList)) {
            ctx.pipeline().remove(this);
            return;
        }

        //否则将离线消息的id存进redis


        //super.channelRead(ctx, msg);
    }

}
