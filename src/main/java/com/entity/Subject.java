package com.entity;

public class Subject {
    private Integer vsId;

    private String vsTitle;

    private Integer vsType;

    public Integer getVsId() {
        return vsId;
    }

    public void setVsId(Integer vsId) {
        this.vsId = vsId;
    }

    public String getVsTitle() {
        return vsTitle;
    }

    public void setVsTitle(String vsTitle) {
        this.vsTitle = vsTitle == null ? null : vsTitle.trim();
    }

    public Integer getVsType() {
        return vsType;
    }

    public void setVsType(Integer vsType) {
        this.vsType = vsType;
    }
}