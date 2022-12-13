/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author QUANGMINH
 */
public class thongke {

    private String mahd;
    private Date ngaytao;
    private double tongtien;
    private int trangthai;

    public thongke() {
    }

    public thongke(String mahd, Date ngaytao, double tongtien, int trangthai) {
        this.mahd = mahd;
        this.ngaytao = ngaytao;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    @Override
    public String toString() {
        return "thongke{" + "mahd=" + mahd + ", ngaytao=" + ngaytao + ", tongtien=" + tongtien + ", trangthai=" + trangthai + '}';
    }

}
