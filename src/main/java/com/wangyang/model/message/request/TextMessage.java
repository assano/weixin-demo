package com.wangyang.model.message.request;

/**
 * Created by wy on 2016/8/4.
 */
public class TextMessage extends BaseMessage {

    //消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
