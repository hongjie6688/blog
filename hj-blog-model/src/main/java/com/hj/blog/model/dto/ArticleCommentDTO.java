package com.hj.blog.model.dto;

import com.hj.blog.model.persistent.ArticleComment;
import com.hj.blog.model.persistent.WebUser;
import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleCommentDTO  implements Serializable {

    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public WebUser getParentUser() {
        return parentUser;
    }

    public void setParentUser(WebUser parentUser) {
        this.parentUser = parentUser;
    }

    public ArticleComment getArticleComment() {
        return articleComment;
    }

    public void setArticleComment(ArticleComment articleComment) {
        this.articleComment = articleComment;
    }

    private WebUser webUser; // 用户

    private WebUser parentUser; // 用户

    private ArticleComment articleComment; //评论内容

}