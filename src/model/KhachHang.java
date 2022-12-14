/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.sql.*;

/**
 *
 * @author 84337
 */
public class KhachHang {

    private String idKhachHang;
    private String makh;
    private String tenkh;
    private boolean gioitinh;
    private String sodt;
    private String diachi;
    private String ghichu;
    private int trangthai;

    public KhachHang() {
    }

    public KhachHang(String idKhachHang, String makh, String tenkh, boolean gioitinh, String sodt, String diachi, String ghichu, int trangthai) {
        this.idKhachHang = idKhachHang;
        this.makh = makh;
        this.tenkh = tenkh;
        this.gioitinh = gioitinh;
        this.sodt = sodt;
        this.diachi = diachi;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "idKhachHang=" + idKhachHang + ", makh=" + makh + ", tenkh=" + tenkh + ", gioitinh=" + gioitinh + ", sodt=" + sodt + ", diachi=" + diachi + ", ghichu=" + ghichu + ", trangthai=" + trangthai + '}';
    }

}
