package cn.hiczy.pojo.authtication;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author czy77
 * @since 2020-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TRolePermission implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 权限id
     */
    private Integer permissionId;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;


}
