package com.yi.entity;

import java.util.Date;

public class TbTeacher {
    private String tecid;

    private Integer roleId;

    private String tecname;

    private String tecpassword;

    private String role;

    private Integer tecage;

    private String tecsex;

    private String tecmajor;

    private String phone;

    private String email;

    private String qq;

    private Date registertime;

    private String address;

    private String tecintroduce;

    private Integer integral;

    private Integer state;

    public String getTecid() {
        return tecid;
    }

    public void setTecid(String tecid) {
        this.tecid = tecid == null ? null : tecid.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getTecname() {
        return tecname;
    }

    public void setTecname(String tecname) {
        this.tecname = tecname == null ? null : tecname.trim();
    }

    public String getTecpassword() {
        return tecpassword;
    }

    public void setTecpassword(String tecpassword) {
        this.tecpassword = tecpassword == null ? null : tecpassword.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Integer getTecage() {
        return tecage;
    }

    public void setTecage(Integer tecage) {
        this.tecage = tecage;
    }

    public String getTecsex() {
        return tecsex;
    }

    public void setTecsex(String tecsex) {
        this.tecsex = tecsex == null ? null : tecsex.trim();
    }

    public String getTecmajor() {
        return tecmajor;
    }

    public void setTecmajor(String tecmajor) {
        this.tecmajor = tecmajor == null ? null : tecmajor.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTecintroduce() {
        return tecintroduce;
    }

    public void setTecintroduce(String tecintroduce) {
        this.tecintroduce = tecintroduce == null ? null : tecintroduce.trim();
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}