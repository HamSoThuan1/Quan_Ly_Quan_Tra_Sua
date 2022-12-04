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
//    private SanPham idSanPham;
    private String idsanpham;
//    private HoaDon idHoaDon;
    private String idhoadon;
    private double donGia;
    private int soLuong;
    private double giaTopping;
    private int trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHoaDonCT, String idsanpham, String idhoadon, double donGia, int soLuong, double giaTopping, int trangThai) {
        this.idHoaDonCT = idHoaDonCT;
        this.idsanpham = idsanpham;
        this.idhoadon = idhoadon;
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

    public String getIdsanpham() {
        return idsanpham;
    }

    public void setIdsanpham(String idsanpham) {
        this.idsanpham = idsanpham;
    }

    public String getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(String idhoadon) {
        this.idhoadon = idhoadon;
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
        return "HoaDonChiTiet{" + "idHoaDonCT=" + idHoaDonCT + ", idsanpham=" + idsanpham + ", idhoadon=" + idhoadon + ", donGia=" + donGia + ", soLuong=" + soLuong + ", giaTopping=" + giaTopping + ", trangThai=" + trangThai + '}';
    }
    
}
