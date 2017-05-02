package com.hj.blog.model.persistent;

import lombok.Data;

import java.util.Date;

@Data
public class UserArticle extends BaseModel {

    public static final int STATUS_DRAFT = 0;

    public static final int STATUS_PUBLISH = 1;

    public static final int STATUS_DELETE = 2;

    private Integer webUserId;

    private Integer categoryId;

    private Integer isMainPage;

    private Integer status;

    public Integer getWebUserId() {
        return webUserId;
    }

    public void setWebUserId(Integer webUserId) {
        this.webUserId = webUserId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getIsMainPage() {
        return isMainPage;
    }

    public void setIsMainPage(Integer isMainPage) {
        this.isMainPage = isMainPage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(Integer readTimes) {
        this.readTimes = readTimes;
    }

    public Integer getThumbupTimes() {
        return thumbupTimes;
    }

    public void setThumbupTimes(Integer thumbupTimes) {
        this.thumbupTimes = thumbupTimes;
    }

    public Integer getCommentTimes() {
        return commentTimes;
    }

    public void setCommentTimes(Integer commentTimes) {
        this.commentTimes = commentTimes;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    private String title;

    private String content;

    private Integer readTimes;

    private Integer thumbupTimes;

    private Integer commentTimes;// 评论次数

    private Date publishTime;

}