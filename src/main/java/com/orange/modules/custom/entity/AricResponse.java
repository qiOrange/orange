package com.orange.modules.custom.entity;

/**
 * 服务端向浏览器发送的消息
 */
public class AricResponse {

    private String responseMessage;

    public AricResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

}
