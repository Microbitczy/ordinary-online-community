package cn.hiczy.pojo.post.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章评论表
 * </p>
 *
 * @author czy77
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TComment implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论所属文章id
     */
    private Long articleId;

    /**
     * 评论用户id
     */
    private Long userId;

    /**
     * 评论者名称
     */
    private String userName;

    /**
     * 评论者头像url
     */
    private String userAvatar;

    /**
     * 被回复用户id
     */
    private Long repliedUserId;

    /**
     * 被回复用户的名称
     */
    private String repliedUsername;

    /**
     * 被回复用户的头像
     */
    private String repliedUserAvatar;

    /**
     * 父级评论id 如果是一级评论(直接评论文章)则为-1
     */
    private Long rootId;

    /**
     * 发表时间
     */
    private LocalDateTime createdTime;

    /**
     * 是否被删除
     */
    private Integer isDeleted;


}
