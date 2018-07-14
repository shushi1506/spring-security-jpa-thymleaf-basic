package com.shushi.spring.blog.models;

/**
 * @author anhbt 7/7/2018
 * com.shushi.spring.blog.models
 */
public class Order {
    private long id;
    private String hoTenKhachHang;
    private String sdt;
    private String dicChi;
    private long soLuongOrder;
    private long thanhTien;
    private long donGia;
    private int state;

    public Order() {
    }

    public Order(long id, String hoTenKhachHang, String sdt, String dicChi, long soLuongOrder, long thanhTien, long donGia, int state) {
        this.id = id;
        this.hoTenKhachHang = hoTenKhachHang;
        this.sdt = sdt;
        this.dicChi = dicChi;
        this.soLuongOrder = soLuongOrder;
        this.thanhTien = thanhTien;
        this.donGia = donGia;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHoTenKhachHang() {
        return hoTenKhachHang;
    }

    public void setHoTenKhachHang(String hoTenKhachHang) {
        this.hoTenKhachHang = hoTenKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDicChi() {
        return dicChi;
    }

    public void setDicChi(String dicChi) {
        this.dicChi = dicChi;
    }

    public long getSoLuongOrder() {
        return soLuongOrder;
    }

    public void setSoLuongOrder(long soLuongOrder) {
        this.soLuongOrder = soLuongOrder;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", hoTenKhachHang='" + hoTenKhachHang + '\'' +
                ", sdt='" + sdt + '\'' +
                ", dicChi='" + dicChi + '\'' +
                ", soLuongOrder=" + soLuongOrder +
                ", thanhTien=" + thanhTien +
                ", donGia=" + donGia +
                ", state=" + state +
                '}';
    }
}
