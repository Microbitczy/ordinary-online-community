package cn.hiczy.auth.service.impl;

import cn.hiczy.pojo.authtication.TUser;
import cn.hiczy.auth.mapper.TUserMapper;
import cn.hiczy.auth.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author czy77
 * @since 2020-08-09
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
