/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hj.blog.common.bean;

import com.hj.blog.common.web.JsonHandlerExceptionResolver;
import com.hj.blog.common.exception.BusinessException;
import com.hj.blog.common.web.JsonHandlerMethodReturnValueHandler;
import lombok.Data;

/**
 * 标识返回的是Json数据
 *
 * @author Xiaolong Zuo
 * @since 1.0.0
 *
 * @see JsonHandlerExceptionResolver
 * @see JsonHandlerMethodReturnValueHandler
 */
@Data
public class JsonResponse {

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private String message;

    private Object data;

    public JsonResponse(Exception exception) {
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            this.code = businessException.getCode();
            this.message = businessException.getMessage();
        } else {
            this.code = 500;
            this.message = "系统发生错误，请联系管理员";
        }

    }

    public JsonResponse(Object data) {
        this.code = 200;
        this.message = "请求成功";
        this.data = data;
    }

    public boolean success() {
        return this.code == 200;
    }

    public boolean authorizationError() {
        return this.code == 401;
    }

}
