/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.Timestamp;
import java.util.Date;

/**
 *
 * @author kn134
 */
public class GiaoCa {
    private String idgiaoca;
    private String maca;
    private java.sql.Timestamp thoidiembatdau;
    private java.sql.Timestamp thoidiemketthuc;
    private double tienbandau;
    private double tiendoanhthu;
    private double tonghienco;
    private double tienphatsinh;
    private double tienchuthu;
    private String ghichu;
    private String idnhanvien;

    public GiaoCa() {
    }

    public GiaoCa(String idgiaoca, String maca, java.sql.Timestamp thoidiembatdau, java.sql.Timestamp thoidiemketthuc, double tienbandau, double tiendoanhthu, double tonghienco, double tienphatsinh, double tienchuthu, String ghichu, String idnhanvien) {
        this.idgiaoca = idgiaoca;
        this.maca = maca;
        this.thoidiembatdau = thoidiembatdau;
        this.thoidiemketthuc = thoidiemketthuc;
        this.tienbandau = tienbandau;
        this.tiendoanhthu = tiendoanhthu;
        this.tonghienco = tonghienco;
        this.tienphatsinh = tienphatsinh;
        this.tienchuthu = tienchuthu;
        this.ghichu = ghichu;
        this.idnhanvien = idnhanvien;
    }

    public String getIdgiaoca() {
        return idgiaoca;
    }

    public void setIdgiaoca(String idgiaoca) {
        this.idgiaoca = idgiaoca;
    }

    public String getMaca() {
        return maca;
    }

    public void setMaca(String maca) {
        this.maca = maca;
    }

    public java.sql.Timestamp getThoidiembatdau() {
        return thoidiembatdau;
    }

    public void setThoidiembatdau(java.sql.Timestamp thoidiembatdau) {
        this.thoidiembatdau = thoidiembatdau;
    }

    public java.sql.Timestamp getThoidiemketthuc() {
        return thoidiemketthuc;
    }

    public void setThoidiemketthuc(java.sql.Timestamp thoidiemketthuc) {
        this.thoidiemketthuc = thoidiemketthuc;
    }

    public double getTienbandau() {
        return tienbandau;
    }

    public void setTienbandau(double tienbandau) {
        this.tienbandau = tienbandau;
    }

    public double getTiendoanhthu() {
        return tiendoanhthu;
    }

    public void setTiendoanhthu(double tiendoanhthu) {
        this.tiendoanhthu = tiendoanhthu;
    }

    public double getTonghienco() {
        return tonghienco;
    }

    public void setTonghienco(double tonghienco) {
        this.tonghienco = tonghienco;
    }

    public double getTienphatsinh() {
        return tienphatsinh;
    }

    public void setTienphatsinh(double tienphatsinh) {
        this.tienphatsinh = tienphatsinh;
    }

    public double getTienchuthu() {
        return tienchuthu;
    }

    public void setTienchuthu(double tienchuthu) {
        this.tienchuthu = tienchuthu;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(String idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    @Override
    public String toString() {
        return "GiaoCa{" + "idgiaoca=" + idgiaoca + ", maca=" + maca + ", thoidiembatdau=" + thoidiembatdau + ", thoidiemketthuc=" + thoidiemketthuc + ", tienbandau=" + tienbandau + ", tiendoanhthu=" + tiendoanhthu + ", tonghienco=" + tonghienco + ", tienphatsinh=" + tienphatsinh + ", tienchuthu=" + tienchuthu + ", ghichu=" + ghichu + ", idnhanvien=" + idnhanvien + '}';
    }
    
}
