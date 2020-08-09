package cn.hiczy.retrieve.service.impl;

import cn.hiczy.pojo.post.TCategory;
import cn.hiczy.retrieve.mapper.TCategoryMapper;
import cn.hiczy.retrieve.service.ITCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章分类表 服务实现类
 * </p>
 *
 * @author czy77
 * @since 2020-07-30
 */
@Service
public class TCategoryServiceImpl extends ServiceImpl<TCategoryMapper, TCategory> implements ITCategoryService {

}
