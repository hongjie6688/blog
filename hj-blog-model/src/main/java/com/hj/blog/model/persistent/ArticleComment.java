package com.hj.blog.model.persistent;

import lombok.Data;

@Data
public class ArticleComment extends BaseModel {

    public Integer getWebUserId() {
        return webUserId;
    }

    public void setWebUserId(Integer webUserId) {
        this.webUserId = webUserId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(Integer replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public String getParentsCommentId() {
        return parentsCommentId;
    }

    public void setParentsCommentId(String parentsCommentId) {
        this.parentsCommentId = parentsCommentId;
    }

    private Integer webUserId;

    private Integer articleId;

    private String comment;

    private Integer replyCommentId;

    private String parentsCommentId; //父级评论路径

}