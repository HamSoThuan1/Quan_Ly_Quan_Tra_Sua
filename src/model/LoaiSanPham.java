/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hung2
 */
public class LoaiSanPham {
    private String idLoaiSP;
    private String maLoaiSP;
    private String tenLoaiSP;
    private int trangThai;

    public LoaiSanPham() {
    }

    public LoaiSanPham(String idLoaiSP, String maLoaiSP, String tenLoaiSP, int trangThai) {
        this.idLoaiSP = idLoaiSP;
        this.maLoaiSP = maLoaiSP;
        this.tenLoaiSP = tenLoaiSP;
        this.trangThai = trangThai;
    }

    public String getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(String idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    public String getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "LoaiSanPham{" + "idLoaiSP=" + idLoaiSP + ", maLoaiSP=" + maLoaiSP + ", tenLoaiSP=" + tenLoaiSP + ", trangThai=" + trangThai + '}';
    }
    
    
}
