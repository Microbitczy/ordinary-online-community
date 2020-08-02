package cn.hiczy.api.controller;

import cn.hiczy.feign.service.CategoryFeignService;
import cn.hiczy.pojo.common.CommonResult;
import cn.hiczy.pojo.post.entity.TCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/****************************************************************************
 * Copyright 2020 czy77/czy_git@163.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************
 */
@RestController
@RequestMapping("test")
@Api(tags = "swagger测试",value = "hello")
public class CategroyFeignTestController {

    @Resource
    private CategoryFeignService categoryFeignService;

    @ApiOperation("返回分类")
    @GetMapping
    public CommonResult<TCategory> test() {
        return categoryFeignService.category(1L);
    }

}
