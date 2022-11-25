/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class Size {
    private String IdSize;
    private String MaSize;
    private String TenSize;
    private Double gia;
    private int trangThai;

    public Size() {
    }

    public Size(String IdSize, String MaSize, String TenSize, Double gia, int trangThai) {
        this.IdSize = IdSize;
        this.MaSize = MaSize;
        this.TenSize = TenSize;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public Size(String MaSize, String TenSize, Double gia, int trangThai) {
        this.MaSize = MaSize;
        this.TenSize = TenSize;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public String getIdSize() {
        return IdSize;
    }

    public void setIdSize(String IdSize) {
        this.IdSize = IdSize;
    }

    public String getMaSize() {
        return MaSize;
    }

    public void setMaSize(String MaSize) {
        this.MaSize = MaSize;
    }

    public String getTenSize() {
        return TenSize;
    }

    public void setTenSize(String TenSize) {
        this.TenSize = TenSize;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Size{" + "IdSize=" + IdSize + ", MaSize=" + MaSize + ", TenSize=" + TenSize + ", gia=" + gia + ", trangThai=" + trangThai + '}';
    }

    
   
    
}
