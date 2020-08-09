package cn.hiczy.pojo.authtication;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author czy77
 * @since 2020-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TPermission implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 权限id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 该权限下可以访问的url
     */
    private String url;


}
