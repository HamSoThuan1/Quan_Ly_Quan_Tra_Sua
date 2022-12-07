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
    private double donGia;
//    private HoaDon idHoaDon;
    private int soluong;
    private double giaTopping;
    private int trangthai;
    private String idhoadon;
    private String idsanpham;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHoaDonCT, double donGia, int soluong, double giaTopping, int trangthai, String idhoadon, String idsanpham) {
        this.idHoaDonCT = idHoaDonCT;
        this.donGia = donGia;
        this.soluong = soluong;
        this.giaTopping = giaTopping;
        this.trangthai = trangthai;
        this.idhoadon = idhoadon;
        this.idsanpham = idsanpham;
    }

    public HoaDonChiTiet(double donGia, int soluong, double giaTopping, int trangthai, String idhoadon, String idsanpham) {
        this.donGia = donGia;
        this.soluong = soluong;
        this.giaTopping = giaTopping;
        this.trangthai = trangthai;
        this.idhoadon = idhoadon;
        this.idsanpham = idsanpham;
    }
    
    public String getIdHoaDonCT() {
        return idHoaDonCT;
    }

    public void setIdHoaDonCT(String idHoaDonCT) {
        this.idHoaDonCT = idHoaDonCT;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGiaTopping() {
        return giaTopping;
    }

    public void setGiaTopping(double giaTopping) {
        this.giaTopping = giaTopping;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(String idhoadon) {
        this.idhoadon = idhoadon;
    }

    public String getIdsanpham() {
        return idsanpham;
    }

    public void setIdsanpham(String idsanpham) {
        this.idsanpham = idsanpham;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "idHoaDonCT=" + idHoaDonCT + ", donGia=" + donGia + ", soluong=" + soluong + ", giaTopping=" + giaTopping + ", trangthai=" + trangthai + ", idhoadon=" + idhoadon + ", idsanpham=" + idsanpham + '}';
    }
    
}
