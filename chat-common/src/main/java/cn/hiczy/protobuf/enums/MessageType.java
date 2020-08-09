package cn.hiczy.protobuf.enums;

import lombok.AllArgsConstructor;

import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageType {

    TEXT(0,"普通文本消息"),
    PICTURE(1,"图片消息"),
    FILE(2,"文件消息"),
    VOICE(3,"语音消息");

    private Integer Code;

    private String desc;
}
