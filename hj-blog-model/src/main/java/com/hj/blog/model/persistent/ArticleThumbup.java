package com.hj.blog.model.persistent;

import lombok.Data;

@Data
public class ArticleThumbup extends BaseModel {

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    private Integer articleId;

    private String ipAddress;

}