/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author 84337
 */
public class KhachHang {
    private String makh;
    private String tenkh;
    private boolean gioitinh;
    private Date ngaysinh;
    private String sodt;
    private String diachi;
    private String ghichu;
    private int trangthai;

    public KhachHang() {
    }

    public KhachHang(String makh, String tenkh, boolean gioitinh, Date ngaysinh, String sodt, String diachi, String ghichu, int trangthai) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sodt = sodt;
        this.diachi = diachi;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
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

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
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
        return "KhachHang{" + "makh=" + makh + ", tenkh=" + tenkh + ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh + ", sodt=" + sodt + ", diachi=" + diachi + ", ghichu=" + ghichu + ", trangthai=" + trangthai + '}';
    }
    
}
