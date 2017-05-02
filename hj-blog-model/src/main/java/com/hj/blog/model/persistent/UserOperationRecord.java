package com.hj.blog.model.persistent;

import lombok.Data;

@Data
public class UserOperationRecord extends BaseModel {

    public Integer getWebUserId() {
        return webUserId;
    }

    public void setWebUserId(Integer webUserId) {
        this.webUserId = webUserId;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    private Integer webUserId;

    private Integer operationType;

}