package com.entity;

public class User {
    private Integer vuUserId;

    private String vuUserName;

    private String vuPassword;

    private Integer vuStatus;

    public Integer getVuUserId() {
        return vuUserId;
    }

    public void setVuUserId(Integer vuUserId) {
        this.vuUserId = vuUserId;
    }

    public String getVuUserName() {
        return vuUserName;
    }

    public void setVuUserName(String vuUserName) {
        this.vuUserName = vuUserName;
    }

    public String getVuPassword() {
        return vuPassword;
    }

    public void setVuPassword(String vuPassword) {
        this.vuPassword = vuPassword;
    }

    public Integer getVuStatus(Integer vuStatus) {
        return this.vuStatus;
    }

    public void setVuStatus(Integer vuStatus) {
        this.vuStatus = vuStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "vuUserId=" + vuUserId +
                ", vuUserName='" + vuUserName + '\'' +
                ", vuPassword='" + vuPassword + '\'' +
                ", vuStatus=" + vuStatus +
                '}';
    }
}