package com.wangyang.model.message.request;

/**
 * Created by wy on 2016/8/4.
 */
public class VideoMessage extends BaseMessage {

    //视频消息媒体ID
    private String MediaId;
    //视频消息略缩图媒体ID
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
