package com.ren.videococo.http;

/**
 * Created by Administrator on 2017/6/29 0029
 */

public class HttpResultForList<T> {
    private String resultCode;
    private String resultMsg;
    private String reqId;
    private String systemTime;
    private T contList;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }

    public T getContList() {
        return contList;
    }

    public void setContList(T contList) {
        this.contList = contList;
    }
}
