package com.hj.blog.model.dto;

import com.hj.blog.model.persistent.ArticleComment;
import com.hj.blog.model.persistent.WebUser;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ArticleCommentAndReplyDTO implements Serializable {

    public Integer getReCommentCount() {
        return reCommentCount;
    }

    public void setReCommentCount(Integer reCommentCount) {
        this.reCommentCount = reCommentCount;
    }

    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public ArticleComment getArticleComment() {
        return articleComment;
    }

    public void setArticleComment(ArticleComment articleComment) {
        this.articleComment = articleComment;
    }

    public List<ArticleCommentDTO> getArticleCommentDTOList() {
        return articleCommentDTOList;
    }

    public void setArticleCommentDTOList(List<ArticleCommentDTO> articleCommentDTOList) {
        this.articleCommentDTOList = articleCommentDTOList;
    }

    private Integer reCommentCount; //回复条数

    private WebUser webUser; // 用户

    private ArticleComment articleComment; //评论内容

    private List<ArticleCommentDTO> articleCommentDTOList; //回复内容
}