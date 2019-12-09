package com.yi.dto;

import com.yi.entity.TbReply;

import java.util.Date;
import java.util.List;

public class CommentReplyDto {
    private Integer comId;
    //课程ID
    private Integer cid;
    //学生姓名
    private String phone;

    private String content;

    private Date comTime;

    private Integer state;
    //回复列表
    List<TbReply> list;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getComTime() {
        return comTime;
    }

    public void setComTime(Date comTime) {
        this.comTime = comTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<TbReply> getList() {
        return list;
    }

    public void setList(List<TbReply> list) {
        this.list = list;
    }
}
