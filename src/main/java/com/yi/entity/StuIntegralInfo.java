package com.yi.entity;

import java.util.Date;

public class StuIntegralInfo {
    private Integer inteId;

    private String stuid;

    private String otherName;

    private String otherValue;

    private Date getTime;

    private Integer state;

    public Integer getInteId() {
        return inteId;
    }

    public void setInteId(Integer inteId) {
        this.inteId = inteId;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName == null ? null : otherName.trim();
    }

    public String getOtherValue() {
        return otherValue;
    }

    public void setOtherValue(String otherValue) {
        this.otherValue = otherValue == null ? null : otherValue.trim();
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}