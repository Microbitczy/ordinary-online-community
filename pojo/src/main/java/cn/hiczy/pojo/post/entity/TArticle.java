package cn.hiczy.pojo.post.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author czy77
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TArticle implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 分类id
     */
    private Integer cateId;

    /**
     * 分类名称
     */
    private String cateName;

    /**
     * 是否原创
     */
    private Integer isOriginal;

    /**
     * 需要付费多少积分才能查看
     */
    private BigDecimal pointPrice;

    /**
     * 查看该文章需要的最低等级
     */
    private Integer needLevel;

    /**
     * 是否为悬赏贴
     */
    private Integer isReward;

    /**
     * 悬赏积分 悬赏贴 > 0 , 非悬赏贴为 0
     */
    private BigDecimal bonus;

    /**
     * 评论数
     */
    private Integer commentNum;

    /**
     * 访问量
     */
    private Integer viewedNum;

    /**
     * 点赞数
     */
    private Integer thumbsUpNum;

    /**
     * 举报数
     */
    private Integer tipOffNum;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 最后一次被访问的时间
     */
    private LocalDateTime lastViewedTime;

    /**
     * 作者最后一次更新时间
     */
    private LocalDateTime lastUpdatedTime;

    /**
     * 发表时间
     */
    private LocalDateTime createdTime;

    /**
     * 作者id
     */
    private Long userId;

    /**
     * 作者名称
     */
    private String userName;

    /**
     * 头像地址
     */
    private String avatar;


}
