package com.shushi.spring.blog.models;

/**
 * @author anhbt 7/7/2018
 * com.shushi.spring.blog.models
 */
public class Product {
    private long id;
    private String tenSanPham;
    private String maSanPham;
    private long soLuong;
    private String donVi;
    private String image;
    private long daBan;
    private String color;
    private String moTa;
    private long view;
    private long giaThanh;

    public Product() {
    }

    public Product(long id, String tenSanPham, String maSanPham, long soLuong, String donVi, String image, long daBan, String color, String moTa, long view, long giaThanh) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donVi = donVi;
        this.image = image;
        this.daBan = daBan;
        this.color = color;
        this.moTa = moTa;
        this.view = view;
        this.giaThanh = giaThanh;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(long soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getDaBan() {
        return daBan;
    }

    public void setDaBan(long daBan) {
        this.daBan = daBan;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public long getView() {
        return view;
    }

    public void setView(long view) {
        this.view = view;
    }

    public long getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(long giaThanh) {
        this.giaThanh = giaThanh;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", maSanPham='" + maSanPham + '\'' +
                ", soLuong=" + soLuong +
                ", donVi='" + donVi + '\'' +
                ", image='" + image + '\'' +
                ", daBan=" + daBan +
                ", color='" + color + '\'' +
                ", moTa='" + moTa + '\'' +
                ", view=" + view +
                ", giaThanh=" + giaThanh +
                '}';
    }
}
