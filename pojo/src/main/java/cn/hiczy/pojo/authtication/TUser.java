package cn.hiczy.pojo.authtication;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author czy77
 * @since 2020-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 个人简介
     */
    private String bio;

    /**
     * 性别  1.男 0.女 -1.保密
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 用户状态 1.正常使用 2.被禁言 3.被封禁 4.已注销
     */
    private Integer state;

    /**
     * 粉丝数量
     */
    private Integer followers;

    /**
     * 关注的大佬的数量
     */
    private Integer following;

    /**
     * 拉黑的杠精数量
     */
    private Integer blockedNum;

    /**
     * 收藏的文章的数量
     */
    private Integer articleStarNum;

    /**
     * 用户所处角色当前经验值
     */
    private Integer nowExpr;

    /**
     * 注册时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;


}
