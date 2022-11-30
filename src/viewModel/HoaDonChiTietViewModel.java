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

    private String idHoaDonCT;
    private String maSP;
    private String tenSP;
    private String tenSize;
    private double donGia;
    private int soLuong;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(String idHoaDonCT, String maSP, String tenSP, String tenSize, double donGia, int soLuong) {
        this.idHoaDonCT = idHoaDonCT;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.tenSize = tenSize;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public HoaDonChiTietViewModel(String maSP, String tenSP, String tenSize, double donGia, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.tenSize = tenSize;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getIdHoaDonCT() {
        return idHoaDonCT;
    }

    public void setIdHoaDonCT(String idHoaDonCT) {
        this.idHoaDonCT = idHoaDonCT;
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

    @Override
    public String toString() {
        return "HoaDonChiTietViewModel{" + "idHoaDonCT=" + idHoaDonCT + ", maSP=" + maSP + ", tenSP=" + tenSP + ", tenSize=" + tenSize + ", donGia=" + donGia + ", soLuong=" + soLuong + '}';
    }


}
