package com.shushi.spring.blog.models;

import javax.persistence.*;

/**
 * @author anhbt 7/31/2018
 * com.shushi.spring.blog.models
 */
@Entity
@Table(name = "THIET_BI")
//@SqlResultSetMappings({
//        @SqlResultSetMapping(name="groupDetailsMapping",
//                classes={
//                        @ConstructorResult(
//                                targetClass=ListTest.class,
//                                columns={
//                                        @ColumnResult(name="ID",type=long.class),
//                                        @ColumnResult(name="SO_LUONG",type=Integer.class),
//                                        @ColumnResult(name="NHA_SAN_XUAT",type=String.class)
//                                }
//                        )
//                })
//})
//@NamedNativeQueries({
//        @NamedNativeQuery(
//                name="ThietBiEntity.queryPercent",
//                query="select tb.ID, tb.SO_LUONG,tb.NHA_SAN_XUAT from QLTB.THIET_BI tb ",
//                resultSetMapping="groupDetailsMapping"
//        )
//})
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "ThietBiEntity.procGetPercent",
                procedureName = "get_per_cent",
                resultClasses = ListTest.class,
                parameters = {
                        @StoredProcedureParameter(name = "p_recordset",mode = ParameterMode.REF_CURSOR, type = void.class) }),
        @NamedStoredProcedureQuery(name = "ThietBiEntity.procGetPercentXuatXu",
                procedureName = "get_per_cent_xuat_xu",
                resultClasses = ListByXuatXu.class,
                parameters = {
                        @StoredProcedureParameter(name = "p_recordset",mode = ParameterMode.REF_CURSOR, type = void.class) })
})
public class ThietBiEntity {
    private long id;
    private String maThietBi;
    private String maNhomThietBi;
    private String maLoaiThietBi;
    private String barCode;
    private String tenThietBi;
    private String maDvt;
    private Long hienTrang;
    private Integer soLuong;
    private String maQuocGia;
    private String nhaSanXuat;
    private String congDung;
    private Integer ngayMua;
    private Integer ngaySuDung;
    private Integer ngayNgungSuDung;
    private Integer ngayThanhLy;
    private String maNhanVien;
    private String maDonVi;
    private String maPhongBan;
    private String ghiChu;
    private String nguoiTao;
    private Long ngayTao;
    private Integer nguoiCapNhat;
    private Integer ngayCapNhat;
    private String donvicungcap;
    private Long baohanh;
    private String xuatXu;
    private String co;
    private String cq;
    private String phieuBaoHanh;
    private Integer ngayBatDauSuDung;
    private String lyDoTang;
    private String mucDich;
    private Long nguyenGia;
    private Short tyLeHaoMon;
    private String license;
    private String hopDong;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MA_THIET_BI")
    public String getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }

    @Basic
    @Column(name = "MA_NHOM_THIET_BI")
    public String getMaNhomThietBi() {
        return maNhomThietBi;
    }

    public void setMaNhomThietBi(String maNhomThietBi) {
        this.maNhomThietBi = maNhomThietBi;
    }

    @Basic
    @Column(name = "MA_LOAI_THIET_BI")
    public String getMaLoaiThietBi() {
        return maLoaiThietBi;
    }

    public void setMaLoaiThietBi(String maLoaiThietBi) {
        this.maLoaiThietBi = maLoaiThietBi;
    }

    @Basic
    @Column(name = "BAR_CODE")
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Basic
    @Column(name = "TEN_THIET_BI")
    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    @Basic
    @Column(name = "MA_DVT")
    public String getMaDvt() {
        return maDvt;
    }

    public void setMaDvt(String maDvt) {
        this.maDvt = maDvt;
    }

    @Basic
    @Column(name = "HIEN_TRANG")
    public Long getHienTrang() {
        return hienTrang;
    }

    public void setHienTrang(Long hienTrang) {
        this.hienTrang = hienTrang;
    }

    @Basic
    @Column(name = "SO_LUONG")
    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @Basic
    @Column(name = "MA_QUOC_GIA")
    public String getMaQuocGia() {
        return maQuocGia;
    }

    public void setMaQuocGia(String maQuocGia) {
        this.maQuocGia = maQuocGia;
    }

    @Basic
    @Column(name = "NHA_SAN_XUAT")
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Basic
    @Column(name = "CONG_DUNG")
    public String getCongDung() {
        return congDung;
    }

    public void setCongDung(String congDung) {
        this.congDung = congDung;
    }

    @Basic
    @Column(name = "NGAY_MUA")
    public Integer getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Integer ngayMua) {
        this.ngayMua = ngayMua;
    }

    @Basic
    @Column(name = "NGAY_SU_DUNG")
    public Integer getNgaySuDung() {
        return ngaySuDung;
    }

    public void setNgaySuDung(Integer ngaySuDung) {
        this.ngaySuDung = ngaySuDung;
    }

    @Basic
    @Column(name = "NGAY_NGUNG_SU_DUNG")
    public Integer getNgayNgungSuDung() {
        return ngayNgungSuDung;
    }

    public void setNgayNgungSuDung(Integer ngayNgungSuDung) {
        this.ngayNgungSuDung = ngayNgungSuDung;
    }

    @Basic
    @Column(name = "NGAY_THANH_LY")
    public Integer getNgayThanhLy() {
        return ngayThanhLy;
    }

    public void setNgayThanhLy(Integer ngayThanhLy) {
        this.ngayThanhLy = ngayThanhLy;
    }

    @Basic
    @Column(name = "MA_NHAN_VIEN")
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    @Basic
    @Column(name = "MA_DON_VI")
    public String getMaDonVi() {
        return maDonVi;
    }

    public void setMaDonVi(String maDonVi) {
        this.maDonVi = maDonVi;
    }

    @Basic
    @Column(name = "MA_PHONG_BAN")
    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    @Basic
    @Column(name = "GHI_CHU")
    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Basic
    @Column(name = "NGUOI_TAO")
    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    @Basic
    @Column(name = "NGAY_TAO")
    public Long getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Long ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Basic
    @Column(name = "NGUOI_CAP_NHAT")
    public Integer getNguoiCapNhat() {
        return nguoiCapNhat;
    }

    public void setNguoiCapNhat(Integer nguoiCapNhat) {
        this.nguoiCapNhat = nguoiCapNhat;
    }

    @Basic
    @Column(name = "NGAY_CAP_NHAT")
    public Integer getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Integer ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    @Basic
    @Column(name = "DONVICUNGCAP")
    public String getDonvicungcap() {
        return donvicungcap;
    }

    public void setDonvicungcap(String donvicungcap) {
        this.donvicungcap = donvicungcap;
    }

    @Basic
    @Column(name = "BAOHANH")
    public Long getBaohanh() {
        return baohanh;
    }

    public void setBaohanh(Long baohanh) {
        this.baohanh = baohanh;
    }

    @Basic
    @Column(name = "XUAT_XU")
    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    @Basic
    @Column(name = "CO")
    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    @Basic
    @Column(name = "CQ")
    public String getCq() {
        return cq;
    }

    public void setCq(String cq) {
        this.cq = cq;
    }

    @Basic
    @Column(name = "PHIEU_BAO_HANH")
    public String getPhieuBaoHanh() {
        return phieuBaoHanh;
    }

    public void setPhieuBaoHanh(String phieuBaoHanh) {
        this.phieuBaoHanh = phieuBaoHanh;
    }

    @Basic
    @Column(name = "NGAY_BAT_DAU_SU_DUNG")
    public Integer getNgayBatDauSuDung() {
        return ngayBatDauSuDung;
    }

    public void setNgayBatDauSuDung(Integer ngayBatDauSuDung) {
        this.ngayBatDauSuDung = ngayBatDauSuDung;
    }

    @Basic
    @Column(name = "LY_DO_TANG")
    public String getLyDoTang() {
        return lyDoTang;
    }

    public void setLyDoTang(String lyDoTang) {
        this.lyDoTang = lyDoTang;
    }

    @Basic
    @Column(name = "MUC_DICH")
    public String getMucDich() {
        return mucDich;
    }

    public void setMucDich(String mucDich) {
        this.mucDich = mucDich;
    }

    @Basic
    @Column(name = "NGUYEN_GIA")
    public Long getNguyenGia() {
        return nguyenGia;
    }

    public void setNguyenGia(Long nguyenGia) {
        this.nguyenGia = nguyenGia;
    }

    @Basic
    @Column(name = "TY_LE_HAO_MON")
    public Short getTyLeHaoMon() {
        return tyLeHaoMon;
    }

    public void setTyLeHaoMon(Short tyLeHaoMon) {
        this.tyLeHaoMon = tyLeHaoMon;
    }

    @Basic
    @Column(name = "LICENSE")
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Basic
    @Column(name = "HOP_DONG")
    public String getHopDong() {
        return hopDong;
    }

    public void setHopDong(String hopDong) {
        this.hopDong = hopDong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThietBiEntity that = (ThietBiEntity) o;

        if (id != that.id) return false;
        if (maThietBi != null ? !maThietBi.equals(that.maThietBi) : that.maThietBi != null) return false;
        if (maNhomThietBi != null ? !maNhomThietBi.equals(that.maNhomThietBi) : that.maNhomThietBi != null)
            return false;
        if (maLoaiThietBi != null ? !maLoaiThietBi.equals(that.maLoaiThietBi) : that.maLoaiThietBi != null)
            return false;
        if (barCode != null ? !barCode.equals(that.barCode) : that.barCode != null) return false;
        if (tenThietBi != null ? !tenThietBi.equals(that.tenThietBi) : that.tenThietBi != null) return false;
        if (maDvt != null ? !maDvt.equals(that.maDvt) : that.maDvt != null) return false;
        if (hienTrang != null ? !hienTrang.equals(that.hienTrang) : that.hienTrang != null) return false;
        if (soLuong != null ? !soLuong.equals(that.soLuong) : that.soLuong != null) return false;
        if (maQuocGia != null ? !maQuocGia.equals(that.maQuocGia) : that.maQuocGia != null) return false;
        if (nhaSanXuat != null ? !nhaSanXuat.equals(that.nhaSanXuat) : that.nhaSanXuat != null) return false;
        if (congDung != null ? !congDung.equals(that.congDung) : that.congDung != null) return false;
        if (ngayMua != null ? !ngayMua.equals(that.ngayMua) : that.ngayMua != null) return false;
        if (ngaySuDung != null ? !ngaySuDung.equals(that.ngaySuDung) : that.ngaySuDung != null) return false;
        if (ngayNgungSuDung != null ? !ngayNgungSuDung.equals(that.ngayNgungSuDung) : that.ngayNgungSuDung != null)
            return false;
        if (ngayThanhLy != null ? !ngayThanhLy.equals(that.ngayThanhLy) : that.ngayThanhLy != null) return false;
        if (maNhanVien != null ? !maNhanVien.equals(that.maNhanVien) : that.maNhanVien != null) return false;
        if (maDonVi != null ? !maDonVi.equals(that.maDonVi) : that.maDonVi != null) return false;
        if (maPhongBan != null ? !maPhongBan.equals(that.maPhongBan) : that.maPhongBan != null) return false;
        if (ghiChu != null ? !ghiChu.equals(that.ghiChu) : that.ghiChu != null) return false;
        if (nguoiTao != null ? !nguoiTao.equals(that.nguoiTao) : that.nguoiTao != null) return false;
        if (ngayTao != null ? !ngayTao.equals(that.ngayTao) : that.ngayTao != null) return false;
        if (nguoiCapNhat != null ? !nguoiCapNhat.equals(that.nguoiCapNhat) : that.nguoiCapNhat != null) return false;
        if (ngayCapNhat != null ? !ngayCapNhat.equals(that.ngayCapNhat) : that.ngayCapNhat != null) return false;
        if (donvicungcap != null ? !donvicungcap.equals(that.donvicungcap) : that.donvicungcap != null) return false;
        if (baohanh != null ? !baohanh.equals(that.baohanh) : that.baohanh != null) return false;
        if (xuatXu != null ? !xuatXu.equals(that.xuatXu) : that.xuatXu != null) return false;
        if (co != null ? !co.equals(that.co) : that.co != null) return false;
        if (cq != null ? !cq.equals(that.cq) : that.cq != null) return false;
        if (phieuBaoHanh != null ? !phieuBaoHanh.equals(that.phieuBaoHanh) : that.phieuBaoHanh != null) return false;
        if (ngayBatDauSuDung != null ? !ngayBatDauSuDung.equals(that.ngayBatDauSuDung) : that.ngayBatDauSuDung != null)
            return false;
        if (lyDoTang != null ? !lyDoTang.equals(that.lyDoTang) : that.lyDoTang != null) return false;
        if (mucDich != null ? !mucDich.equals(that.mucDich) : that.mucDich != null) return false;
        if (nguyenGia != null ? !nguyenGia.equals(that.nguyenGia) : that.nguyenGia != null) return false;
        if (tyLeHaoMon != null ? !tyLeHaoMon.equals(that.tyLeHaoMon) : that.tyLeHaoMon != null) return false;
        if (license != null ? !license.equals(that.license) : that.license != null) return false;
        if (hopDong != null ? !hopDong.equals(that.hopDong) : that.hopDong != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (maThietBi != null ? maThietBi.hashCode() : 0);
        result = 31 * result + (maNhomThietBi != null ? maNhomThietBi.hashCode() : 0);
        result = 31 * result + (maLoaiThietBi != null ? maLoaiThietBi.hashCode() : 0);
        result = 31 * result + (barCode != null ? barCode.hashCode() : 0);
        result = 31 * result + (tenThietBi != null ? tenThietBi.hashCode() : 0);
        result = 31 * result + (maDvt != null ? maDvt.hashCode() : 0);
        result = 31 * result + (hienTrang != null ? hienTrang.hashCode() : 0);
        result = 31 * result + (soLuong != null ? soLuong.hashCode() : 0);
        result = 31 * result + (maQuocGia != null ? maQuocGia.hashCode() : 0);
        result = 31 * result + (nhaSanXuat != null ? nhaSanXuat.hashCode() : 0);
        result = 31 * result + (congDung != null ? congDung.hashCode() : 0);
        result = 31 * result + (ngayMua != null ? ngayMua.hashCode() : 0);
        result = 31 * result + (ngaySuDung != null ? ngaySuDung.hashCode() : 0);
        result = 31 * result + (ngayNgungSuDung != null ? ngayNgungSuDung.hashCode() : 0);
        result = 31 * result + (ngayThanhLy != null ? ngayThanhLy.hashCode() : 0);
        result = 31 * result + (maNhanVien != null ? maNhanVien.hashCode() : 0);
        result = 31 * result + (maDonVi != null ? maDonVi.hashCode() : 0);
        result = 31 * result + (maPhongBan != null ? maPhongBan.hashCode() : 0);
        result = 31 * result + (ghiChu != null ? ghiChu.hashCode() : 0);
        result = 31 * result + (nguoiTao != null ? nguoiTao.hashCode() : 0);
        result = 31 * result + (ngayTao != null ? ngayTao.hashCode() : 0);
        result = 31 * result + (nguoiCapNhat != null ? nguoiCapNhat.hashCode() : 0);
        result = 31 * result + (ngayCapNhat != null ? ngayCapNhat.hashCode() : 0);
        result = 31 * result + (donvicungcap != null ? donvicungcap.hashCode() : 0);
        result = 31 * result + (baohanh != null ? baohanh.hashCode() : 0);
        result = 31 * result + (xuatXu != null ? xuatXu.hashCode() : 0);
        result = 31 * result + (co != null ? co.hashCode() : 0);
        result = 31 * result + (cq != null ? cq.hashCode() : 0);
        result = 31 * result + (phieuBaoHanh != null ? phieuBaoHanh.hashCode() : 0);
        result = 31 * result + (ngayBatDauSuDung != null ? ngayBatDauSuDung.hashCode() : 0);
        result = 31 * result + (lyDoTang != null ? lyDoTang.hashCode() : 0);
        result = 31 * result + (mucDich != null ? mucDich.hashCode() : 0);
        result = 31 * result + (nguyenGia != null ? nguyenGia.hashCode() : 0);
        result = 31 * result + (tyLeHaoMon != null ? tyLeHaoMon.hashCode() : 0);
        result = 31 * result + (license != null ? license.hashCode() : 0);
        result = 31 * result + (hopDong != null ? hopDong.hashCode() : 0);
        return result;
    }
}
