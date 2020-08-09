package cn.hiczy.feign.service.fallback;

import cn.hiczy.feign.service.CategoryFeignService;
import cn.hiczy.pojo.common.CommonResult;
import cn.hiczy.pojo.enums.ResultEnum;
import cn.hiczy.pojo.post.TCategory;
import org.springframework.stereotype.Component;

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
@Component
public class CategoryFeignServiceFallback implements CategoryFeignService {
    private static CommonResult result = CommonResult.create(ResultEnum.TIME_OUT,null);

    @Override
    public CommonResult<TCategory> category(Long id) {
        return result;
    }
}
