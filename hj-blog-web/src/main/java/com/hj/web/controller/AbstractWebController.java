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
package com.hj.web.controller;

import com.hj.blog.common.utils.JsonUtils;
import com.hj.blog.common.web.AbstractController;
import com.hj.blog.model.dto.WebUserDTO;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Boren You
 * @dateTime 2016/6/11 0:23
 * @since 1.0.0
 */
public abstract class AbstractWebController extends AbstractController {

    /**
     * 存放当前线程的HttpServletResponse对象
     */
    private static ThreadLocal<HttpServletResponse> httpServletResponseThreadLocal = new ThreadLocal<>();

    protected static final String TOKEN_ATTRIBUTE_NAME = "token";

    protected static final String USERNAME_ATTRIBUTE_NAME = "username";

    protected static final String NICKNAME_ATTRIBUTE_NAME = "nickname";

    protected static final String USERNAME_ATTRIBUTE_KEY = "username";

    protected static final String WEB_USER_ID_ATTRIBUTE_KEY = "webUserId";



    protected Integer getWebUserId() {
        return (Integer) getSessionAttribute(WEB_USER_ID_ATTRIBUTE_KEY);
    }

//    protected JsonResponse invokeApi(Api api) {
//        JsonResponse jsonResponse = blogSdk.invokeApi(getToken(), getRemoteIp(), api);
//        checkJsonResponse(jsonResponse);
//        return jsonResponse;
//    }
//
//    protected JsonResponse invokeApi(Api api, Object params) {
//        JsonResponse jsonResponse = blogSdk.invokeApi(getToken(), getRemoteIp(), api, ObjectUtils.objectToMap(params));
//        checkJsonResponse(jsonResponse);
//        return jsonResponse;
//    }
//
//    protected JsonResponse invokeApi(Api api, Map<String, String> params) {
//        JsonResponse jsonResponse = blogSdk.invokeApi(getToken(), getRemoteIp(), api, params);
//        checkJsonResponse(jsonResponse);
//        return jsonResponse;
//    }
//
//    protected JsonResponse invokeApi(Api api, String attachmentKey, Attachment[] attachments) {
//        JsonResponse jsonResponse = blogSdk.invokeApi(getToken(), getRemoteIp(), api, attachmentKey, attachments);
//        checkJsonResponse(jsonResponse);
//        return jsonResponse;
//    }
//
//    protected JsonResponse invokeApi(Api api, Map<String, String> params, String attachmentKey, Attachment[] attachments) {
//        JsonResponse jsonResponse = blogSdk.invokeApi(getToken(), getRemoteIp(), api, params, attachmentKey, attachments);
//        checkJsonResponse(jsonResponse);
//        return jsonResponse;
//    }
//
//    private void checkJsonResponse(JsonResponse jsonResponse) {
//        if (jsonResponse.authorizationError()) {
//            throw new AuthorizationException();
//        }
//    }

    /**
     * 绑定response对象
     *
     * @param response
     */
    @ModelAttribute
    protected void setThreadLocal(HttpServletResponse response) {
        httpServletResponseThreadLocal.set(response);
    }

    /**
     * 成功登录后处理session
     *
     * @param token
     */
    protected void loginSuccess(String token) {
        setSessionAttribute(TOKEN_ATTRIBUTE_NAME, token);
    }

    protected void afterLoginSuccess(WebUserDTO loginWebUser) {
        setSessionAttribute(USERNAME_ATTRIBUTE_NAME, loginWebUser.getUsername());
        setSessionAttribute(NICKNAME_ATTRIBUTE_NAME, loginWebUser.getNickname());
        setSessionAttribute(WEB_USER_ID_ATTRIBUTE_KEY, loginWebUser.getId());
    }

    /**
     * 成功注销后处理session
     */
    protected void logoutSuccess() {
        setSessionAttribute(USERNAME_ATTRIBUTE_NAME, null);
        setSessionAttribute(NICKNAME_ATTRIBUTE_NAME, null);
        setSessionAttribute(TOKEN_ATTRIBUTE_NAME, null);
    }

    /**
     * 获取用户的username
     *
     * @return
     */
    protected String getUsername() {
        return (String) getSessionAttribute(USERNAME_ATTRIBUTE_NAME);
    }

    /**
     * 获取用户的token
     *
     * @return
     */
    protected String getToken() {
        return (String) getSessionAttribute(TOKEN_ATTRIBUTE_NAME);
    }

    /**
     * 获取当前线程的HttpServletResponse对象
     *
     * @return 当前线程的HttpServletResponse对象
     */
    protected HttpServletResponse getResponse() {
        return httpServletResponseThreadLocal.get();
    }

    /**
     * 客户端返回JSON字符串
     *
     * @param object
     * @return
     */
    protected void renderJson(Object object) {
        renderText(JsonUtils.toJson(object), "application/json");
    }

    /**
     * 客户端返回字符串
     *
     * @param string
     * @return
     */
    protected void renderText(String string, String type) {
        try {
            HttpServletResponse response = getResponse();
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
