/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hj.web.controller;

import com.hj.blog.common.bean.JsonResponse;
import com.hj.blog.common.cache.SingletonCache;
import com.hj.blog.model.persistent.UserArticle;
import com.hj.blog.service.UserArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author 郭松涛
 * @date 2016/6/10 8:23
 * @since 1.0.0
 */
@Controller
@RequestMapping("/HomePage")
public class HomePageController extends AbstractWebController {

    @Autowired
    private UserArticleService userArticleService;

    /**
     * 当访问错误的时候，跳转到默认的主页
     *
     * @return
     */
    @RequestMapping("/Index")
    public String index(@RequestParam(required = false) Integer categoryId) {
        JsonResponse homeArticleDTO = new JsonResponse(userArticleService.getMainPageArticles(null, 1, categoryId));
        JsonResponse articleCharts = new JsonResponse((Map<String, UserArticle>) SingletonCache.instance().get("charts-category-" + categoryId));
        ;
        if (homeArticleDTO.success()) {
            setModelAttribute("homeArticleDTO", homeArticleDTO.getData());
        }
        if (articleCharts.success()) {
            setModelAttribute("articleCharts", articleCharts.getData());
        }
        return "/index/index";
    }

    @RequestMapping("/Articles")
    public void getArticles(Integer categoryId, String offset, Integer size) {
        JsonResponse jsonResponse =  new JsonResponse(userArticleService.getMainPageArticles(offset, size, categoryId));
        if (jsonResponse.success()) {
            renderJson(jsonResponse.getData());
        } else {
            renderJson("error");
        }
    }

}
