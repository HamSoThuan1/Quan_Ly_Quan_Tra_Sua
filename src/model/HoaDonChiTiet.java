/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class HoaDonChiTiet {

    private String idHoaDonCT;
    private SanPham idSanPham;
    private HoaDon idHoaDon;
    private double donGia;
    private int soLuong;
    private double giaTopping;
    private int trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHoaDonCT, SanPham idSanPham, HoaDon idHoaDon, double donGia, int soLuong, double giaTopping, int trangThai) {
        this.idHoaDonCT = idHoaDonCT;
        this.idSanPham = idSanPham;
        this.idHoaDon = idHoaDon;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.giaTopping = giaTopping;
        this.trangThai = trangThai;
    }

    public String getIdHoaDonCT() {
        return idHoaDonCT;
    }

    public void setIdHoaDonCT(String idHoaDonCT) {
        this.idHoaDonCT = idHoaDonCT;
    }

    public SanPham getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(SanPham idSanPham) {
        this.idSanPham = idSanPham;
    }

    public HoaDon getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(HoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTopping() {
        return giaTopping;
    }

    public void setGiaTopping(double giaTopping) {
        this.giaTopping = giaTopping;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "idHoaDonCT=" + idHoaDonCT + ", idSanPham=" + idSanPham + ", idHoaDon=" + idHoaDon + ", donGia=" + donGia + ", soLuong=" + soLuong + ", giaTopping=" + giaTopping + ", trangThai=" + trangThai + '}';
    }

}
