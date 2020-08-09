package cn.hiczy.pojo.authtication;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author czy77
 * @since 2020-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TRole implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 到达该角色等级需要多少经验
     */
    private Integer needExpr;

    /**
     * 下一等级角色id, 最高级/不能升级的角色为-1
     */
    private Integer nextRoleId;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;


}
