package cn.hiczy.protobuf.utils;


import cn.hiczy.entity.TMessageRecord;
import cn.hiczy.enums.MessageType;
import cn.hiczy.protobuf.MessageProto;
import cn.hiczy.protobuf.PlainMessageProto;

/**
 * Proto消息工具类
 */
public class ProtoMessageUtils {
    private ProtoMessageUtils(){}

    /**
     * 将 MessageProto.Message 转化为 TMessageRecord
     * @param message MessageProto.Message
     * @return TMessageRecord
     */
    public static TMessageRecord protoToBean(MessageProto.Message message){
        PlainMessageProto.PlainMessage plainMessage = message.getPlainMessage();
        TMessageRecord tMessageRecord = new TMessageRecord();
        tMessageRecord.setContent(plainMessage.getContent())
                .setCreateTime(plainMessage.getCreateTime())
                .setFromId(plainMessage.getFromId())
                .setToId(plainMessage.getToId())
                .setMessageType(plainMessage.getType().getNumber());
        return tMessageRecord;
    }


    /**
     * 将 TMessageRecord 转化为  PlainMessage
     * @param messageRecord TMessageRecord
     * @return  MessageProto.Message(PlainMessage)
     */
    public static MessageProto.Message beanToPlainMsg(TMessageRecord messageRecord){
        PlainMessageProto.PlainMessage plainMessage = PlainMessageProto.PlainMessage.newBuilder().setContent(messageRecord.getContent())
                .setCreateTime(messageRecord.getCreateTime())
                .setFromId(messageRecord.getFromId())
                .setToId(messageRecord.getToId())
                .setTypeValue(messageRecord.getMessageType())
                .build();

        return MessageProto.Message.newBuilder().setMId(messageRecord.getMId())
                .setPlainMessage(plainMessage).build();
    }


}
