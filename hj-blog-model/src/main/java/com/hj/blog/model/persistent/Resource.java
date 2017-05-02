package com.hj.blog.model.persistent;

import lombok.Data;

@Data
public class Resource extends BaseModel {

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    private String resourcePath;

    private Integer resourceType;

}