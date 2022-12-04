/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class HoaDon {

    private String idHoaDon;
    private String MaHD;
    private Timestamp ngayTao;
    private double tongTien;
    private double tienApDungKM;
    private double tienKHThanhToan;
    private Timestamp ngayThanhToan;
    private String ghiChu;
    private int trangThai;
    private String idnhanvien;
    private String idkhachhang;
    private String idkm;
//    private Nhanvien idNhanVien;
//    private KhachHang idKhachHang;
//    private KhuyenMai idKhuyenMai;

    public HoaDon() {
    }

    public HoaDon(String idHoaDon, String MaHD, Timestamp ngayTao, double tongTien, double tienApDungKM, double tienKHThanhToan, Timestamp ngayThanhToan, String ghiChu, int trangThai, String idnhanvien, String idkhachhang, String idkm) {
        this.idHoaDon = idHoaDon;
        this.MaHD = MaHD;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.tienApDungKM = tienApDungKM;
        this.tienKHThanhToan = tienKHThanhToan;
        this.ngayThanhToan = ngayThanhToan;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.idnhanvien = idnhanvien;
        this.idkhachhang = idkhachhang;
        this.idkm = idkm;
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

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Timestamp ngayTao) {
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

    public Timestamp getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Timestamp ngayThanhToan) {
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

    public String getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(String idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public String getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(String idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    public String getIdkm() {
        return idkm;
    }

    public void setIdkm(String idkm) {
        this.idkm = idkm;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "idHoaDon=" + idHoaDon + ", MaHD=" + MaHD + ", ngayTao=" + ngayTao + ", tongTien=" + tongTien + ", tienApDungKM=" + tienApDungKM + ", tienKHThanhToan=" + tienKHThanhToan + ", ngayThanhToan=" + ngayThanhToan + ", ghiChu=" + ghiChu + ", trangThai=" + trangThai + ", idnhanvien=" + idnhanvien + ", idkhachhang=" + idkhachhang + ", idkm=" + idkm + '}';
    }
    
}
