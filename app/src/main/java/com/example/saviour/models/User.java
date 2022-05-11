package com.example.saviour.models;

import java.io.Serializable;

public class User implements Serializable {

    private String fullName,mobileNo,email_Id,adhaar_no, Password,Bloodgrp, pin_code,Gender;

    public User() {

    }

    public User(String fullName, String mobileNo, String email_Id,String adhaar_no, String pin_code, String Password, String Bloodgrp, String Gender) {
        this.fullName = fullName;
        this.mobileNo = mobileNo;
        this.email_Id = email_Id;
        this.adhaar_no =adhaar_no;
        this.pin_code = pin_code;
        this.Password = Password;
        this.Bloodgrp = Bloodgrp;
        this.Gender = Gender;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email_Id;
    }

    public String getAdhaar_no() {
        return adhaar_no;
    }

    public String getBloodgrp() {
        return Bloodgrp;
    }

    public String getPinCode() {
        return pin_code;
    }

    public String getPassword() {
        return Password;
    }

    public String getGender() {
        return Gender;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmail(String email_Id) {
        this.email_Id = email_Id;
    }

    public void setAdhaar_no(String adhaar_no) {
        this.adhaar_no = adhaar_no;
    }

    public void setBloodgrp(String Bloodgrp) {
        this.Bloodgrp = Bloodgrp;
    }

    public void setPinCode(String pin_code) {
        this.pin_code = pin_code;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

}

