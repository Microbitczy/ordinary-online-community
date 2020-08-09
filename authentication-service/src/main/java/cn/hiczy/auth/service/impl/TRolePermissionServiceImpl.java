package cn.hiczy.auth.service.impl;

import cn.hiczy.auth.mapper.TRolePermissionMapper;
import cn.hiczy.auth.service.ITRolePermissionService;
import cn.hiczy.pojo.authtication.TRolePermission;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @author czy77
 * @since 2020-08-09
 */
@Service
public class TRolePermissionServiceImpl extends ServiceImpl<TRolePermissionMapper, TRolePermission> implements ITRolePermissionService {

}
