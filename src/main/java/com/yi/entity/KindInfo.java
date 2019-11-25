package com.yi.entity;

public class KindInfo {
    private Integer kid;

    private String kindName;

    private Integer higherId;

    private Integer level;

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName == null ? null : kindName.trim();
    }

    public Integer getHigherId() {
        return higherId;
    }

    public void setHigherId(Integer higherId) {
        this.higherId = higherId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}