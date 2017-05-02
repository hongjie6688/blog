/*
 * Copyright 2016-2016 the original author or authors.
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

import com.hj.blog.common.bean.JsonResponse;
import com.hj.blog.model.persistent.MessageBox;
import com.hj.blog.service.MessageBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor iCodingStar
 * @date 2016/6/25 17:10
 * @since 1.0.0
 */
@Controller
@RequestMapping("/MessageBox")
public class MessageBoxController extends AbstractWebController {

    @Autowired
    private MessageBoxService messageBoxService;

    @RequestMapping("/HomePage")
    public String homePage() {
        return "message/message-list";
    }

    /***
     * 查看信息箱消息内容
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/Content", method = RequestMethod.GET)
    public void getMessageContent(@RequestParam("id") Integer id) {
        JsonResponse jsonResponse = new JsonResponse(messageBoxService.updateStatusAndGetContent(id));
        renderJson(jsonResponse);
    }

    /***
     * 分页参看消息列表
     *
     * @param currentPageNumber
     * @param pageSize
     * @param type
     * @param status
     */
    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public void getMessageList(@RequestParam(required = false) Integer currentPageNumber,
                               @RequestParam(required = false) Integer pageSize,
                               @RequestParam(required = false) Integer type,
                               @RequestParam(required = false) Integer status) {
        Map<String, String> params = new HashMap<>();
        if (!ObjectUtils.isEmpty(currentPageNumber)) {
            params.put("currentPageNumber", currentPageNumber + "");
        }
        if (!ObjectUtils.isEmpty(pageSize)) {
            params.put("pageSize", pageSize + "");
        }
        if (!ObjectUtils.isEmpty(type)) {
            params.put("type", type + "");
        }
        if (!ObjectUtils.isEmpty(status)) {
            params.put("status", status + "");
        }
        JsonResponse jsonResponse = new JsonResponse(messageBoxService.getMessagesByPage(currentPageNumber, pageSize, type, getWebUserId(), status));
        renderJson(jsonResponse);
    }

    /***
     * 发送短消息
     *
     * @param username   收件人
     * @param messageBox 短消息
     */
    @RequestMapping(value = "/Send", method = {RequestMethod.POST, RequestMethod.GET})
    public void sendMessage(String username, MessageBox messageBox) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("title", messageBox.getTitle());
        params.put("content", messageBox.getContent());
        messageBox.setSender(getWebUserId());
        renderJson(messageBoxService.insertMessage(username, messageBox));
    }

    /***
     * 修改短消息状态
     * 0:已读
     * 1:未读
     * 2:已删除
     *
     * @param username
     * @param messageBox
     */
    @RequestMapping(value = "/Update", method = {RequestMethod.POST, RequestMethod.GET})
    public void updateMessageStatus(String username, MessageBox messageBox) {
        JsonResponse jsonResponse = new JsonResponse(messageBoxService.updateMessageStatus(messageBox));
        renderJson(jsonResponse);
    }
}
