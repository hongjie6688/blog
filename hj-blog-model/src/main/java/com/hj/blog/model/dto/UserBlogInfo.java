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
package com.hj.blog.model.dto;

import com.hj.blog.common.orm.DropDownPage;
import com.hj.blog.model.persistent.BlogConfig;
import com.hj.blog.model.persistent.UserArticle;
import com.hj.blog.model.persistent.WebUser;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户博客信息
 *
 * @author linjiedeng
 * @author youboren
 * @date 16/5/14 下午6:38
 * @since 1.0.0
 */

@Data
public class UserBlogInfo implements Serializable {

    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public BlogConfig getBlogConfig() {
        return blogConfig;
    }

    public void setBlogConfig(BlogConfig blogConfig) {
        this.blogConfig = blogConfig;
    }

    public List<UserArticle> getUserArticleList() {
        return userArticleList;
    }

    public void setUserArticleList(List<UserArticle> userArticleList) {
        this.userArticleList = userArticleList;
    }

    public List<UserArticle> getUserHotestArticleList() {
        return userHotestArticleList;
    }

    public void setUserHotestArticleList(List<UserArticle> userHotestArticleList) {
        this.userHotestArticleList = userHotestArticleList;
    }

    public DropDownPage getUserArticlePage() {
        return userArticlePage;
    }

    public void setUserArticlePage(DropDownPage userArticlePage) {
        this.userArticlePage = userArticlePage;
    }

    private WebUser webUser; // 用户（注入对象的时候，不要带密码跟盐这两个字段的值）

    private BlogConfig blogConfig; // 博客配置

    private List<UserArticle> userArticleList;// 用户文章列表

    private List<UserArticle> userHotestArticleList;// 用户最热文章列表

    private DropDownPage userArticlePage;//用户文章分页

}
