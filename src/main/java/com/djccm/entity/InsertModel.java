package com.djccm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
public class InsertModel implements Serializable {
    private String historyid;
    private String rechargeid;
    private String tradeno;
    private String orderid;
    private String orderno;
    private String userid;
    private String name;
    private String mobilephone;
    private String companyid;
    private String shopid;
    private String shopname;
    private int type;
    private Double rechargeamount;
    private Double presentamount;
    private Double payamount;
    private Double orderamount;
    private Double givenamount;
    private Double feeamount;
    private int paytype;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String paytime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String giventime;
    private int paystatus;

    private String defid;
    private Double cashbalance;
    private Double presentbalance;
    private Double totalbalance;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String lastmodify;

    public String getHistoryid() {
        return historyid;
    }

    public void setHistoryid(String historyid) {
        this.historyid = historyid;
    }

    public String getRechargeid() {
        return rechargeid;
    }

    public void setRechargeid(String rechargeid) {
        this.rechargeid = rechargeid;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Double getRechargeamount() {
        return rechargeamount;
    }

    public void setRechargeamount(Double rechargeamount) {
        this.rechargeamount = rechargeamount;
    }

    public Double getPresentamount() {
        return presentamount;
    }

    public void setPresentamount(Double presentamount) {
        this.presentamount = presentamount;
    }

    public Double getPayamount() {
        return payamount;
    }

    public void setPayamount(Double payamount) {
        this.payamount = payamount;
    }

    public Double getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(Double orderamount) {
        this.orderamount = orderamount;
    }

    public Double getGivenamount() {
        return givenamount;
    }

    public void setGivenamount(Double givenamount) {
        this.givenamount = givenamount;
    }

    public Double getFeeamount() {
        return feeamount;
    }

    public void setFeeamount(Double feeamount) {
        this.feeamount = feeamount;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getGiventime() {
        return giventime;
    }

    public void setGiventime(String giventime) {
        this.giventime = giventime;
    }

    public int getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(int paystatus) {
        this.paystatus = paystatus;
    }

    public String getDefid() {
        return defid;
    }

    public void setDefid(String defid) {
        this.defid = defid;
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
