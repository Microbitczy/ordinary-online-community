package cn.hiczy.post.service

import cn.hiczy.pojo.post.TCategory
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

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
@SpringBootTest
@RunWith(SpringRunner::class)
class ITCategoryServiceTest {

    @Resource
    lateinit var categoryService : ITCategoryService

    @Test
    fun saveTest(){
        var category = TCategory()
        //category.id = 1
        category.cateName = "测试分类2"
        category.articleNum = 0
        category.cateDesc = "~~!!!"
        category.followers = 0
        var save = categoryService.save(category)
        assert(save)
    }


}