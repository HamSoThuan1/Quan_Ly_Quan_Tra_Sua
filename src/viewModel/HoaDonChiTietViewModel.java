/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class HoaDonChiTietViewModel {

    private String idSanPham;
    private String maSP;
    private String tenSP;
    private String tenSize;
    private String tenTopping;
    private double donGia;
    private double giaSize;
    private int soLuong;
    private double thanhTien;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(String idSanPham, String maSP, String tenSP, String tenSize, String tenTopping, double donGia, double giaSize, int soLuong, double thanhTien) {
        this.idSanPham = idSanPham;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.tenSize = tenSize;
        this.tenTopping = tenTopping;
        this.donGia = donGia;
        this.giaSize = giaSize;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public String getTenTopping() {
        return tenTopping;
    }

    public void setTenTopping(String tenTopping) {
        this.tenTopping = tenTopping;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getGiaSize() {
        return giaSize;
    }

    public void setGiaSize(double giaSize) {
        this.giaSize = giaSize;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "HoaDonChiTietViewModel{" + "idSanPham=" + idSanPham + ", maSP=" + maSP + ", tenSP=" + tenSP + ", tenSize=" + tenSize + ", tenTopping=" + tenTopping + ", donGia=" + donGia + ", giaSize=" + giaSize + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + '}';
    }

}
