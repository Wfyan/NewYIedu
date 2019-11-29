package com.yi.dto;

public class KindInfoQueryCriteria {


    private String kindName;

    private Integer higherId;

    private Integer level;

    private Integer preKid;

    private Integer tranKid;

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
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

    public Integer getPreKid() {
        return preKid;
    }

    public void setPreKid(Integer preKid) {
        this.preKid = preKid;
    }

    public Integer getTranKid() {
        return tranKid;
    }

    public void setTranKid(Integer tranKid) {
        this.tranKid = tranKid;
    }
}
