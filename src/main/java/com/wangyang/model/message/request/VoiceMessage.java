package com.wangyang.model.message.request;

/**
 * Created by wy on 2016/8/4.
 */
public class VoiceMessage extends BaseMessage {

    // 语音消息媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
