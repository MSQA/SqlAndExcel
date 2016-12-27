package com.djccm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
public class PlatformAuthentiCation implements Serializable {
    private String platformAuthenticationID;
    private String personID;
    private String userName;
    private String password;
    private String passwordComplex;
    private int isValid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String modifyTime;
    private String platformAuthenticationType;
    private String customID;

    public String getPlatformAuthenticationID() {
        return platformAuthenticationID;
    }

    public void setPlatformAuthenticationID(String platformAuthenticationID) {
        this.platformAuthenticationID = platformAuthenticationID;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordComplex() {
        return passwordComplex;
    }

    public void setPasswordComplex(String passwordComplex) {
        this.passwordComplex = passwordComplex;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getPlatformAuthenticationType() {
        return platformAuthenticationType;
    }

    public void setPlatformAuthenticationType(String platformAuthenticationType) {
        this.platformAuthenticationType = platformAuthenticationType;
    }

    public String getCustomID() {
        return customID;
    }

    public void setCustomID(String customID) {
        this.customID = customID;
    }
}
