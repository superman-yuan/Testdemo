package com.yjlc.entity;

import java.util.Date;

public class bbsUser {
    private Integer uid;

    private String uName;

    private String uPassword;

    private String uEmail;

    private Date uBirthday;

    private Boolean uSex;

    private Integer uClass;

    private String uStatement;

    private Date uRegDate;

    private Byte uState;

    private Integer uPoint;

    private String uPhone;

    private String uLcon;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public Date getuBirthday() {
        return uBirthday;
    }

    public void setuBirthday(Date uBirthday) {
        this.uBirthday = uBirthday;
    }

    public Boolean getuSex() {
        return uSex;
    }

    public void setuSex(Boolean uSex) {
        this.uSex = uSex;
    }

    public Integer getuClass() {
        return uClass;
    }

    public void setuClass(Integer uClass) {
        this.uClass = uClass;
    }

    public String getuStatement() {
        return uStatement;
    }

    public void setuStatement(String uStatement) {
        this.uStatement = uStatement == null ? null : uStatement.trim();
    }

    public Date getuRegDate() {
        return uRegDate;
    }

    public void setuRegDate(Date uRegDate) {
        this.uRegDate = uRegDate;
    }

    public Byte getuState() {
        return uState;
    }

    public void setuState(Byte uState) {
        this.uState = uState;
    }

    public Integer getuPoint() {
        return uPoint;
    }

    public void setuPoint(Integer uPoint) {
        this.uPoint = uPoint;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public String getuLcon() {
        return uLcon;
    }

    public void setuLcon(String uLcon) {
        this.uLcon = uLcon == null ? null : uLcon.trim();
    }
}