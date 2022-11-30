/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class HoaDon {
    private String idHoaDon;
    private String MaHD;
    private Date ngayTao;
    private double tongTien;
    private double tienApDungKM;
    private double tienKHThanhToan;
    private Date ngayThanhToan;
    private String ghiChu;
    private int trangThai;
    private Nhanvien idNhanVien;
    private KhachHang idKhachHang;

    public HoaDon() {
    }

    public HoaDon(String idHoaDon, String MaHD, Date ngayTao, double tongTien, double tienApDungKM, double tienKHThanhToan, Date ngayThanhToan, String ghiChu, int trangThai, Nhanvien idNhanVien, KhachHang idKhachHang) {
        this.idHoaDon = idHoaDon;
        this.MaHD = MaHD;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.tienApDungKM = tienApDungKM;
        this.tienKHThanhToan = tienKHThanhToan;
        this.ngayThanhToan = ngayThanhToan;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
    }

    public HoaDon(String idHoaDon, String MaHD, Date ngayTao, int trangThai, Nhanvien idNhanVien, KhachHang idKhachHang) {
        this.idHoaDon = idHoaDon;
        this.MaHD = MaHD;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getTienApDungKM() {
        return tienApDungKM;
    }

    public void setTienApDungKM(double tienApDungKM) {
        this.tienApDungKM = tienApDungKM;
    }

    public double getTienKHThanhToan() {
        return tienKHThanhToan;
    }

    public void setTienKHThanhToan(double tienKHThanhToan) {
        this.tienKHThanhToan = tienKHThanhToan;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Nhanvien getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Nhanvien idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public KhachHang getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(KhachHang idKhachHang) {
        this.idKhachHang = idKhachHang;
    }
    
}
