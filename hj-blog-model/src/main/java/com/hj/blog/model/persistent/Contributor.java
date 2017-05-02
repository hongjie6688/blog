package com.hj.blog.model.persistent;

import lombok.Data;

@Data
public class Contributor extends BaseModel {

    private String contributorName;

    private String personalUrl;

    public String getContributorName() {
        return contributorName;
    }

    public void setContributorName(String contributorName) {
        this.contributorName = contributorName;
    }

    public String getPersonalUrl() {
        return personalUrl;
    }

    public void setPersonalUrl(String personalUrl) {
        this.personalUrl = personalUrl;
    }
}