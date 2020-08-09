package cn.hiczy.feign.service;

import cn.hiczy.feign.service.fallback.CategoryFeignServiceFallback;
import cn.hiczy.pojo.common.CommonResult;
import cn.hiczy.pojo.post.TCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
@FeignClient(value = "post-service/category",fallback = CategoryFeignServiceFallback.class)
public interface CategoryFeignService  {

    @GetMapping("{id}")
    CommonResult<TCategory> category(@PathVariable Long id);

}
