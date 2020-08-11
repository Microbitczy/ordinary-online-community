package cn.hiczy.protobuf.utils;


import cn.hiczy.protobuf.MessageProto;
import cn.hiczy.protobuf.MessageProto.Message;
import cn.hiczy.protobuf.entity.*;
import cn.hiczy.protobuf.AuthResponseProto;
import cn.hiczy.protobuf.PlainMessageProto.PlainMessage;

/**
 * Proto消息工具类
 */
public class ProtoMessageUtils {
    private ProtoMessageUtils(){}

    /**
     * 将 Message 转化为 TMessageRecord
     * @param message Message
     * @return TMessageRecord
     */
    public static TMessageRecord convertToTMessageRecord(Message message){
        PlainMessage plainMessage = message.getPlainMessage();
        TMessageRecord tMessageRecord = new TMessageRecord();
        tMessageRecord.setContent(plainMessage.getContent())
                .setCreateTime(plainMessage.getCreateTime())
                .setFromId(plainMessage.getFromId())
                .setToId(plainMessage.getToId())
                .setMessageType(plainMessage.getType().getNumber());
        return tMessageRecord;
    }


    /**
     * 将 TMessageRecord 转化为  普通消息 PlainMessage
     * @param messageRecord TMessageRecord
     * @return  Message(PlainMessage)
     */
    public static Message convertToMessage(TMessageRecord messageRecord){
        PlainMessage plainMessage = PlainMessage.newBuilder().setContent(messageRecord.getContent())
                .setFromId(messageRecord.getFromId())
                .setToId(messageRecord.getToId())
                .setTypeValue(messageRecord.getMessageType())
                .build();

        return Message.newBuilder()
                .setMId(messageRecord.getMId())
                .setType(Message.MessageType.PLAIN)
                .setPlainMessage(plainMessage)
                .build();
    }


    /**
     * 创建认证响应
     * @return Message
     */
    public static Message createAuthRsp() {
        AuthResponseProto.AuthResponse authRsp = AuthResponseProto.AuthResponse.newBuilder()
                .setAuthUrl("localhost:8080")
                .setCode(AuthResponseProto.AuthResponse.ResponseCode.FAILED)
                .build();

        return Message.newBuilder().setAuthRsp(authRsp).build();
    }


    /**
     * 将离线消息实体类型(TOfflineMessage) 转换为 Message(MessageType 为 )
     * @param offlineMessage
     * @return
     */
    public static Message convertToMessage(TOfflineMessage offlineMessage){
        PlainMessage plainMessage = PlainMessage.newBuilder().setContent(offlineMessage.getContent())
                .setFromId(offlineMessage.getFromId())
                .setToId(offlineMessage.getToId())
                .setTypeValue(offlineMessage.getMessageType())
                .build();
        return Message.newBuilder()
                .setMId(offlineMessage.getMId())
                .setType(Message.MessageType.OFFLINE_MSG_RSP)
                .setPlainMessage(plainMessage)
                .build();

    }



}
