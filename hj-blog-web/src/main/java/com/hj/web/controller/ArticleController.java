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
import com.hj.blog.model.persistent.ArticleComment;
import com.hj.blog.model.persistent.UserArticle;
import com.hj.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;


/**
 * @author DeserveL
 * @date 2016/6/11 18:20
 * @since 1.0.0
 */
@Controller
@RequestMapping("/Article")
public class ArticleController extends AbstractWebController {

    @Autowired
    ArticleService articleService;

    /**
     * 查看文章详细
     *
     * @param articleId 文章id
     * @return
     */
    @RequestMapping(value = "/{articleId}")
    public String getArticleInfo(@PathVariable int articleId) {
        JsonResponse response = new JsonResponse(articleService.updateThumbupTimesAndGetArticleInfo(articleId));
        if (response.getCode() == 200) {
            setModelAttribute("result", response);
            return "article/article";
        }
        return "/index/index";
    }

    @RequestMapping(value = "/Write")
    public String writeIndex() {
        JsonResponse articleList = new JsonResponse(articleService.getArticlesByWebUserId(getWebUserId()));
        if (articleList.success()) {
            setModelAttribute("userArticles", articleList.getData());
        }
        return "/article/write";
    }

    @RequestMapping(value = "/Write/{articleId}")
    public void getArticleById(@PathVariable int articleId) {
        JsonResponse response = new JsonResponse(articleService.updateThumbupTimesAndGetArticleInfo(articleId));
        if (response.success()) {
            renderJson(response.getData());
        }
    }

    /**
     * 查看评论和每条评论前三条回复列表
     *
     * @param articleId 文章id
     * @param offset    分页开始头评论id
     * @param size      每次加载数
     */
    @RequestMapping(value = "/GetCommentInfo", method = RequestMethod.GET)
    public void getCommentInfo(int articleId, int offset, int size) {
        Map<String, String> params = new HashMap<>();
        params.put("articleId", articleId + "");
        params.put("offset", offset + "");
        params.put("size", size + "");
        JsonResponse response = new JsonResponse(articleService.getCommentInfo(articleId, offset, size));
        renderJson(response);
    }


    /**
     * 加载该条评论的更多回复
     *
     * @param commentId 评论id
     * @param offset    分页开始头评论id
     * @param size      每次加载数
     */
    @RequestMapping(value = "/GetMoreReComment", method = RequestMethod.GET)
    public void getMoreReComment(int commentId, int offset, int size) {
        Map<String, String> params = new HashMap<>();
        params.put("commentId", commentId + "");
        params.put("offset", offset + "");
        params.put("size", size + "");
        JsonResponse response = new JsonResponse(articleService.getReCommentInfo(commentId, offset, size));
        renderJson(response);
    }

    /**
     * 添加评论（回复）
     *
     * @param articleComment
     */
    @RequestMapping(value = "/AddComment", method = RequestMethod.POST)
    public void AddComment(ArticleComment articleComment) {
        JsonResponse response = new JsonResponse(articleService.insertArticleComment(articleComment, getWebUserId()));
        renderJson(response);
    }

    /**
     * 添加一次点赞
     *
     * @param articleId
     */
    @RequestMapping(value = "/AddThumbupTimes", method = RequestMethod.POST)
    public void addThumbupTimes(int articleId) {
        JsonResponse response = new JsonResponse(articleService.updateThumbupTimes(articleId, getRemoteIp()));
        renderJson(response);
    }

    /**
     * 增加一篇博文
     *
     * @param userArticle
     */
    @RequestMapping(value = "/Create", method = RequestMethod.POST)
    public void addUserArticle(UserArticle userArticle) {
        userArticle.setWebUserId(getWebUserId());
        JsonResponse response = new JsonResponse(articleService.insertUserArticle(userArticle));
        renderJson(response);
    }

    /**
     * 修改博文信息（标题、内容、状态）
     */
    @RequestMapping(value = "/Update", method = RequestMethod.POST)
    public void updateUserArticle(UserArticle userArticle) {
        JsonResponse response = new JsonResponse("");
        renderJson(response);
    }

    /**
     * 获取当前用户对应的文章
     */
    @RequestMapping(value = "/GetUserArticle", method = RequestMethod.GET)
    public void getUserArticle() {
        JsonResponse response =new JsonResponse(articleService.getArticlesByWebUserId(getWebUserId()));
        renderJson(response);
    }
}
