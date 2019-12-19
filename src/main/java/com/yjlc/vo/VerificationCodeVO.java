package com.yjlc.vo;

/**
 * Created by dashang001 on 2018/7/27.
 */
public class VerificationCodeVO {
    String phone;
    String code;
    String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}