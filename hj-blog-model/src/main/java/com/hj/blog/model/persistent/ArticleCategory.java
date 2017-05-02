package com.hj.blog.model.persistent;

import lombok.Data;

@Data
public class ArticleCategory extends BaseModel {

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}