package com.wangyang.model.message.request;

/**
 * Created by wy on 2016/8/4.
 */
public class ImageMessage extends BaseMessage {

    // 图片链接
    private String PicUrl;
    // 图片消息媒体ID
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
