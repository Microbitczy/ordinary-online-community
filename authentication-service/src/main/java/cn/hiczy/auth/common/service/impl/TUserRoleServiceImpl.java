package cn.hiczy.auth.common.service.impl;

import cn.hiczy.pojo.authtication.TUserRole;
import cn.hiczy.auth.common.mapper.TUserRoleMapper;
import cn.hiczy.auth.common.service.ITUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色中间表 服务实现类
 * </p>
 *
 * @author czy77
 * @since 2020-08-09
 */
@Service
public class TUserRoleServiceImpl extends ServiceImpl<TUserRoleMapper, TUserRole> implements ITUserRoleService {

}
