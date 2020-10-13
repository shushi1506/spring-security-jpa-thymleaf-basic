package com.shushi.spring.blog.models;

/**
 * @author anhbt 8/30/2018
 * com.shushi.spring.blog.models
 */
public class UserSSO {
    private String ten;
    private String email;
    private String tinhTrangHoatDong;

    public UserSSO() {
    }

    public UserSSO(String ten, String email, String tinhTrangHoatDong) {
        this.ten = ten;
        this.email = email;
        this.tinhTrangHoatDong = tinhTrangHoatDong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTinhTrangHoatDong() {
        return tinhTrangHoatDong;
    }

    public void setTinhTrangHoatDong(String tinhTrangHoatDong) {
        this.tinhTrangHoatDong = tinhTrangHoatDong;
    }

    @Override
    public String toString() {
        return "UserSSO{" +
                "ten='" + ten + '\'' +
                ", email='" + email + '\'' +
                ", tinhTrangHoatDong='" + tinhTrangHoatDong + '\'' +
                '}';
    }
}
