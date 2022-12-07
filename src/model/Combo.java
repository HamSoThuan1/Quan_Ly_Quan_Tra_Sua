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
public class Combo {
    private String idcb;
    private String macb;
    private String tencb;
    private double giacb;
    private int soluong;
    private Date ngaytao;
    private String ghichu;
    private int trangthai;

    public Combo(String idcb, String macb, String tencb, double giacb, int soluong, Date ngaytao, String ghichu, int trangthai) {
        this.idcb = idcb;
        this.macb = macb;
        this.tencb = tencb;
        this.giacb = giacb;
        this.soluong = soluong;
        this.ngaytao = ngaytao;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
    }

    public Combo() {
    }

    public Combo(String macb, String tencb, double giacb, int soluong, Date ngaytao, String ghichu, int trangthai) {
        this.macb = macb;
        this.tencb = tencb;
        this.giacb = giacb;
        this.soluong = soluong;
        this.ngaytao = ngaytao;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "Combo{" + "idcb=" + idcb + ", macb=" + macb + ", tencb=" + tencb + ", giacb=" + giacb + ", soluong=" + soluong + ", ngaytao=" + ngaytao + ", ghichu=" + ghichu + ", trangthai=" + trangthai + '}';
    }

    public String getIdcb() {
        return idcb;
    }

    public void setIdcb(String idcb) {
        this.idcb = idcb;
    }

    public String getMacb() {
        return macb;
    }

    public void setMacb(String macb) {
        this.macb = macb;
    }

    public String getTencb() {
        return tencb;
    }

    public void setTencb(String tencb) {
        this.tencb = tencb;
    }

    public double getGiacb() {
        return giacb;
    }

    public void setGiacb(double giacb) {
        this.giacb = giacb;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
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
    
}
