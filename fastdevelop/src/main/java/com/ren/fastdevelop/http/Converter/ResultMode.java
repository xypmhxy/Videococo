package com.ren.fastdevelop.http.Converter;

/**
 * Created by Ren on 2017/9/26
 */

public class ResultMode {
    private String codeKey;
    private String code;
    private String msgKey;
    public ResultMode(){}

    public ResultMode(String codeKey, String code, String msgKey) {
        this.codeKey = codeKey;
        this.code = code;
        this.msgKey = msgKey;
    }

    public String getCodeKey() {
        return codeKey;
    }

    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsgKey() {
        return msgKey;
    }

    public void setMsgKey(String msgKey) {
        this.msgKey = msgKey;
    }
}
