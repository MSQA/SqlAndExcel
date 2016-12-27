package com.djccm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
public class CcrechargeInfo implements Serializable {
    private String rechargeid;
    private String defid;
    private String userid;
    private String companyid;
    private Double cashbalance;
    private Double presentbalance;
    private Double totalbalance;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String lastmodify;

    public String getRechargeid() {
        return rechargeid;
    }

    public void setRechargeid(String rechargeid) {
        this.rechargeid = rechargeid;
    }

    public String getDefid() {
        return defid;
    }

    public void setDefid(String defid) {
        this.defid = defid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public Double getCashbalance() {
        return cashbalance;
    }

    public void setCashbalance(Double cashbalance) {
        this.cashbalance = cashbalance;
    }

    public Double getPresentbalance() {
        return presentbalance;
    }

    public void setPresentbalance(Double presentbalance) {
        this.presentbalance = presentbalance;
    }

    public Double getTotalbalance() {
        return totalbalance;
    }

    public void setTotalbalance(Double totalbalance) {
        this.totalbalance = totalbalance;
    }

    public String getLastmodify() {
        return lastmodify;
    }

    public void setLastmodify(String lastmodify) {
        this.lastmodify = lastmodify;
    }
}
