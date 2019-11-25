package com.yi.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Grade {
    private Integer scid;

    private Integer cid;

    private String stuid;

    private Integer grades;

    private BigDecimal isdual;

    private Date addtime;

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    public Integer getGrades() {
        return grades;
    }

    public void setGrades(Integer grades) {
        this.grades = grades;
    }

    public BigDecimal getIsdual() {
        return isdual;
    }

    public void setIsdual(BigDecimal isdual) {
        this.isdual = isdual;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}