package com.hj.blog.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 错误码
 *
 * @author Bing Pei
 * @since 1.0.0
 */
@Data
public class ErrorCode  implements Serializable {

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {

        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /** 错误码 */
    private int errorCode;

    /** 错误信息 */
    private String errorMessage;

    public ErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
