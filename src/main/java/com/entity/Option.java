package com.entity;

public class Option {
    private Integer voId;

    private Integer vsId;

    private String voOption;

    private Integer voOrder;

    public Integer getVoId() {
        return voId;
    }

    public void setVoId(Integer voId) {
        this.voId = voId;
    }

    public Integer getVsId() {
        return vsId;
    }

    public void setVsId(Integer vsId) {
        this.vsId = vsId;
    }

    public String getVoOption() {
        return voOption;
    }

    public void setVoOption(String voOption) {
        this.voOption = voOption == null ? null : voOption.trim();
    }

    public Integer getVoOrder() {
        return voOrder;
    }

    public void setVoOrder(Integer voOrder) {
        this.voOrder = voOrder;
    }
}