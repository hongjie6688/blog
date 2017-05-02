package com.hj.blog.model.persistent;

import com.hj.blog.common.utils.ValidateUtils;
import lombok.Data;

@Data
public class BlogConfig extends BaseModel {

    private Integer webUserId;

    private String introduction;

    private String address;

    private String blogTitle; // 博客标题

    public Integer getWebUserId() {
        return webUserId;
    }

    public void setWebUserId(Integer webUserId) {
        this.webUserId = webUserId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogSubTitle() {
        return blogSubTitle;
    }

    public void setBlogSubTitle(String blogSubTitle) {
        this.blogSubTitle = blogSubTitle;
    }

    private String blogSubTitle; // 博客子标题

    public void init(WebUser webUser) {
        ValidateUtils.required(webUser);
        ValidateUtils.required(webUser.getId());
        ValidateUtils.required(webUser.getUsername());
        this.webUserId = webUser.getId();
        this.address = "/" + webUser.getUsername();
        this.blogTitle = webUser.getUsername() + "的个人博客";
        this.blogSubTitle = "一直走在编程的路上";
        this.introduction = "我是" + webUser.getUsername();
    }

}