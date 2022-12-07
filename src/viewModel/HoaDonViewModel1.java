/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import model.HoaDon;
import model.SanPham;

/**
 *
 * @author Acer
 */
public class HoaDonViewModel1 {

    private String idHoaDonCT;
    private SanPham idSanPham;
    private HoaDon idHoaDon;
    private int soLuong;
    private double donGia;
    private double giaTopping;
    private String trangThai;

    public HoaDonViewModel1() {
    }

    public HoaDonViewModel1(String idHoaDonCT, SanPham idSanPham, HoaDon idHoaDon, int soLuong, double donGia, double giaTopping, String trangThai) {
        this.idHoaDonCT = idHoaDonCT;
        this.idSanPham = idSanPham;
        this.idHoaDon = idHoaDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getGiaTopping() {
        return giaTopping;
    }

    public void setGiaTopping(double giaTopping) {
        this.giaTopping = giaTopping;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel1{" + "idHoaDonCT=" + idHoaDonCT + ", idSanPham=" + idSanPham + ", idHoaDon=" + idHoaDon + ", soLuong=" + soLuong + ", donGia=" + donGia + ", giaTopping=" + giaTopping + ", trangThai=" + trangThai + '}';
    }

}
