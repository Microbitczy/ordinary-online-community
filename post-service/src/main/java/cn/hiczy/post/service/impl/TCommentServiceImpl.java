package cn.hiczy.post.service.impl;

import cn.hiczy.pojo.post.entity.TComment;
import cn.hiczy.post.mapper.TCommentMapper;
import cn.hiczy.post.service.ITCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章评论表 服务实现类
 * </p>
 *
 * @author czy77
 * @since 2020-07-30
 */
@Service
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment> implements ITCommentService {

}
