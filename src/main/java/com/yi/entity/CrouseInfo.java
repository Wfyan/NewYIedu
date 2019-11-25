package com.yi.entity;

import java.util.Date;

public class CrouseInfo {
    private Integer cid;

    private String tecid;

    private Integer kid;

    private String cname;

    private Float score;

    private Date addDay;

    private Integer crouseTime;

    private Double price;

    private Double integral;

    private String onchoose;

    private String crouseIntroduce;

    private String img;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTecid() {
        return tecid;
    }

    public void setTecid(String tecid) {
        this.tecid = tecid == null ? null : tecid.trim();
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Date getAddDay() {
        return addDay;
    }

    public void setAddDay(Date addDay) {
        this.addDay = addDay;
    }

    public Integer getCrouseTime() {
        return crouseTime;
    }

    public void setCrouseTime(Integer crouseTime) {
        this.crouseTime = crouseTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getIntegral() {
        return integral;
    }

    public void setIntegral(Double integral) {
        this.integral = integral;
    }

    public String getOnchoose() {
        return onchoose;
    }

    public void setOnchoose(String onchoose) {
        this.onchoose = onchoose == null ? null : onchoose.trim();
    }

    public String getCrouseIntroduce() {
        return crouseIntroduce;
    }

    public void setCrouseIntroduce(String crouseIntroduce) {
        this.crouseIntroduce = crouseIntroduce == null ? null : crouseIntroduce.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}