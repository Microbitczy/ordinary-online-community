package cn.hiczy.auth.service.impl;

import cn.hiczy.auth.mapper.TPermissionMapper;
import cn.hiczy.auth.service.ITPermissionService;
import cn.hiczy.pojo.authtication.TPermission;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author czy77
 * @since 2020-08-09
 */
@Service
public class TPermissionServiceImpl extends ServiceImpl<TPermissionMapper, TPermission> implements ITPermissionService {

}
