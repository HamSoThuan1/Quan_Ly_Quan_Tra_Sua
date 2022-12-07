/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hung2
 */
public class SanPham {

    private String idSanPham;
    private LoaiSanPham idLoaiSP;
    private Size idSize;
    private String maSP;
    private String tenSP;
    private double donGia;
    private String hinhAnh;
    private String moTa;
    private int trangThai;

    public SanPham() {
    }

    public SanPham(String idSanPham, String maSP, String tenSP, double donGia, String hinhAnh, String moTa, int trangThai) {
        this.idSanPham = idSanPham;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.hinhAnh = hinhAnh;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }
    
    public SanPham(String idSanPham, LoaiSanPham idLoaiSP, Size idSize, String maSP, String tenSP, double donGia, String hinhAnh, String moTa, int trangThai) {
        this.idSanPham = idSanPham;
        this.idLoaiSP = idLoaiSP;
        this.idSize = idSize;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.hinhAnh = hinhAnh;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }
    
    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public LoaiSanPham getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(LoaiSanPham idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    public Size getIdSize() {
        return idSize;
    }

    public void setIdSize(Size idSize) {
        this.idSize = idSize;
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

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "idSanPham=" + idSanPham + ", idLoaiSP=" + idLoaiSP + ", idSize=" + idSize + ", maSP=" + maSP + ", tenSP=" + tenSP + ", donGia=" + donGia + ", hinhAnh=" + hinhAnh + ", moTa=" + moTa + ", trangThai=" + trangThai + '}';
    }


}
