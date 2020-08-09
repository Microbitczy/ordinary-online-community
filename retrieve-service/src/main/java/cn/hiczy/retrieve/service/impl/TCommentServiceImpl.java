package cn.hiczy.retrieve.service.impl;

import cn.hiczy.pojo.post.TComment;
import cn.hiczy.retrieve.mapper.TCommentMapper;
import cn.hiczy.retrieve.service.ITCommentService;
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
