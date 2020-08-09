package cn.hiczy.retrieve.controller;



import cn.hiczy.feign.service.CategoryFeignService;
import cn.hiczy.pojo.common.CommonResult;
import cn.hiczy.pojo.post.TCategory;
import cn.hiczy.retrieve.service.ITCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 文章分类表 前端控制器
 * </p>
 *
 * @author czy77
 * @since 2020-07-30
 */
@RestController
@RequestMapping("/category")
public class TCategoryController implements CategoryFeignService {

    @Resource
    private ITCategoryService categoryService;


    @PostMapping
    public CommonResult category(@RequestBody TCategory category) {
        categoryService.save(category);
        return CommonResult.ok();
    }

    @GetMapping("{id}")
    @Override
    public CommonResult<TCategory> category(@PathVariable Long id) {
        TCategory category = categoryService.getById(1L);
        return CommonResult.ok(category);
    }

}

