package cn.hiczy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TOfflineMessage {

    //消息id
    @TableId(value = "m_id",type = IdType.AUTO)
    private Long mId;

    //消息内容
    private String content;

    //发消息用户id
    private Long fromId;

    //接收消息用户id
    private Long toId;

    //消息类型
    private Integer messageType;

    //消息创建时间
    private Long createTime;

    //是否删除
    private Boolean isDeleted;

}
