/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class SanPhamViewModel {
    private String idSanPham;
    private String maSP;
    private String tenSP;
    private String loaiSP;
    private String sizeSP;
    private double donGia;
    private double giaSize;
    private String moTa;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(String idSanPham, String maSP, String tenSP, String loaiSP, String sizeSP, double donGia, double giaSize, String moTa) {
        this.idSanPham = idSanPham;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.sizeSP = sizeSP;
        this.donGia = donGia;
        this.giaSize = giaSize;
        this.moTa = moTa;
    }

    public SanPhamViewModel(String idSanPham, String maSP, String tenSP, String loaiSP, String sizeSP, double donGia, String moTa) {
        this.idSanPham = idSanPham;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.sizeSP = sizeSP;
        this.donGia = donGia;
        this.moTa = moTa;
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

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getSizeSP() {
        return sizeSP;
    }

    public void setSizeSP(String sizeSP) {
        this.sizeSP = sizeSP;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "SanPhamViewModel{" + "idSanPham=" + idSanPham + ", maSP=" + maSP + ", tenSP=" + tenSP + ", loaiSP=" + loaiSP + ", sizeSP=" + sizeSP + ", donGia=" + donGia + ", giaSize=" + giaSize + ", moTa=" + moTa + '}';
    }
    
}
