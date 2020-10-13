package com.shushi.spring.blog;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author anhbt 6/20/2018
 * susu.teca.demo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    private String name;
    private String email;
    private String sdt;
    private String address;
    private Boolean sysShu;
    private Boolean sysShi;
    private String sysSelfService;
    private String sysMail;
    private String tinhTrangHoatDong;
    private String firstLogin;

    public UserInfo() {
    }

    public UserInfo(String name, String email, String sdt, String address, Boolean sysShu, Boolean sysShi, String sysSelfService, String sysMail, String tinhTrangHoatDong, String firstLogin) {
        this.name = name;
        this.email = email;
        this.sdt = sdt;
        this.address = address;
        this.sysShu = sysShu;
        this.sysShi = sysShi;
        this.sysSelfService = sysSelfService;
        this.sysMail = sysMail;
        this.tinhTrangHoatDong=tinhTrangHoatDong;
        this.firstLogin=firstLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSysShu() {
        return sysShu;
    }

    public void setSysShu(Boolean sysShu) {
        this.sysShu = sysShu;
    }

    public Boolean getSysShi() {
        return sysShi;
    }

    public void setSysShi(Boolean sysShi) {
        this.sysShi = sysShi;
    }

    public String getSysSelfService() {
        return sysSelfService;
    }

    public void setSysSelfService(String sysSelfService) {
        this.sysSelfService = sysSelfService;
    }

    public String getSysMail() {
        return sysMail;
    }

    public void setSysMail(String sysMail) {
        this.sysMail = sysMail;
    }

    public String getTinhTrangHoatDong() {
        return tinhTrangHoatDong;
    }

    public void setTinhTrangHoatDong(String tinhTrangHoatDong) {
        this.tinhTrangHoatDong = tinhTrangHoatDong;
    }

    public String getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(String firstLogin) {
        this.firstLogin = firstLogin;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sdt='" + sdt + '\'' +
                ", address='" + address + '\'' +
                ", sysShu=" + sysShu +
                ", sysShi=" + sysShi +
                ", sysSelfService='" + sysSelfService + '\'' +
                ", sysMail='" + sysMail + '\'' +
                ", tinhTrangHoatDong='" + tinhTrangHoatDong + '\'' +
                ", firstLogin='" + firstLogin + '\'' +
                '}';
    }
}
