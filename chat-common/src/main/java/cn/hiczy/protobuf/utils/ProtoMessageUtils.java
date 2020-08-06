package cn.hiczy.protobuf.utils;


import cn.hiczy.entity.TMessageRecord;
import cn.hiczy.protobuf.MessageProto;
import cn.hiczy.protobuf.PlainMessageProto;

/**
 * Proto消息工具类
 */
public class ProtoMessageUtils {
    private ProtoMessageUtils(){}

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

    public static MessageProto.Message beanToProto(TMessageRecord messageRecord){
        MessageProto.Message build = MessageProto.Message.newBuilder().build();


        return null;
    }


}
