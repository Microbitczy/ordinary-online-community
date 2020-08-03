package cn.hiczy.retrieve.service.impl;

import cn.hiczy.pojo.post.entity.TArticle;
import cn.hiczy.retrieve.mapper.TArticleMapper;
import cn.hiczy.retrieve.service.ITArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author czy77
 * @since 2020-07-30
 */
@Service
public class TArticleServiceImpl extends ServiceImpl<TArticleMapper, TArticle> implements ITArticleService {

}
