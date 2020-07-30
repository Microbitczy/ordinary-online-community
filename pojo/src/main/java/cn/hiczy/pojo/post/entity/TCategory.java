package cn.hiczy.pojo.post.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章分类表
 * </p>
 *
 * @author czy77
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TCategory implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 分类名称
     */
    private String cateName;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 分类关注人数
     */
    private Long followers;

    /**
     * 分类下文章数量
     */
    private Long articleNum;

    /**
     * 分类描述
     */
    private String cateDesc;

    /**
     * 是否被删除
     */
    private Integer isDeleted;


}
