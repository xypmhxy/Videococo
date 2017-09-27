package com.ren.videococo.beans;

/**
 * Created by Ren on 2017/09/27 0027.
 * TODO
 */

public class ContList {
    private String contId;

    private String name;

    private String pic;

    private NodeInfo nodeInfo;

    private String link;

    private String linkType;

    private String cornerLabel;

    private String cornerLabelDesc;

    private String forwordType;

    private String videoType;

    private String duration;

    private String liveStatus;

    private String liveStartTime;

    private String praiseTimes;

    public void setContId(String contId) {
        this.contId = contId;
    }

    public String getContId() {
        return this.contId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return this.pic;
    }

    public void setNodeInfo(NodeInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    public NodeInfo getNodeInfo() {
        return this.nodeInfo;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public void setCornerLabel(String cornerLabel) {
        this.cornerLabel = cornerLabel;
    }

    public String getCornerLabel() {
        return this.cornerLabel;
    }

    public void setCornerLabelDesc(String cornerLabelDesc) {
        this.cornerLabelDesc = cornerLabelDesc;
    }

    public String getCornerLabelDesc() {
        return this.cornerLabelDesc;
    }

    public void setForwordType(String forwordType) {
        this.forwordType = forwordType;
    }

    public String getForwordType() {
        return this.forwordType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoType() {
        return this.videoType;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    public String getLiveStatus() {
        return this.liveStatus;
    }

    public void setLiveStartTime(String liveStartTime) {
        this.liveStartTime = liveStartTime;
    }

    public String getLiveStartTime() {
        return this.liveStartTime;
    }

    public void setPraiseTimes(String praiseTimes) {
        this.praiseTimes = praiseTimes;
    }

    public String getPraiseTimes() {
        return this.praiseTimes;
    }

}
