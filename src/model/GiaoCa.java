/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author kn134
 */
public class GiaoCa {
    private String idgiaoca;
    private String maca;
    private Date thoidiembatdau;
    private Date thoidiemketthuc;
    private double tienbandau;
    private double tiendoanhthu;
    private double tiencchuyenkhoan;
    private double tienmat;
    private double tongtiencahienco;
    private double tienchuthu;
    private double tienphatsinh;
    private String ghichu;
    private Nhanvien nhanvien;

    public GiaoCa() {
    }

    public GiaoCa(String idgiaoca, String maca, Date thoidiembatdau, Date thoidiemketthuc, double tienbandau, double tiendoanhthu, double tiencchuyenkhoan, double tienmat, double tongtiencahienco, double tienchuthu, double tienphatsinh, String ghichu, Nhanvien nhanvien) {
        this.idgiaoca = idgiaoca;
        this.maca = maca;
        this.thoidiembatdau = thoidiembatdau;
        this.thoidiemketthuc = thoidiemketthuc;
        this.tienbandau = tienbandau;
        this.tiendoanhthu = tiendoanhthu;
        this.tiencchuyenkhoan = tiencchuyenkhoan;
        this.tienmat = tienmat;
        this.tongtiencahienco = tongtiencahienco;
        this.tienchuthu = tienchuthu;
        this.tienphatsinh = tienphatsinh;
        this.ghichu = ghichu;
        this.nhanvien = nhanvien;
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

    public Date getThoidiembatdau() {
        return thoidiembatdau;
    }

    public void setThoidiembatdau(Date thoidiembatdau) {
        this.thoidiembatdau = thoidiembatdau;
    }

    public Date getThoidiemketthuc() {
        return thoidiemketthuc;
    }

    public void setThoidiemketthuc(Date thoidiemketthuc) {
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

    public double getTiencchuyenkhoan() {
        return tiencchuyenkhoan;
    }

    public void setTiencchuyenkhoan(double tiencchuyenkhoan) {
        this.tiencchuyenkhoan = tiencchuyenkhoan;
    }

    public double getTienmat() {
        return tienmat;
    }

    public void setTienmat(double tienmat) {
        this.tienmat = tienmat;
    }

    public double getTongtiencahienco() {
        return tongtiencahienco;
    }

    public void setTongtiencahienco(double tongtiencahienco) {
        this.tongtiencahienco = tongtiencahienco;
    }

    public double getTienchuthu() {
        return tienchuthu;
    }

    public void setTienchuthu(double tienchuthu) {
        this.tienchuthu = tienchuthu;
    }

    public double getTienphatsinh() {
        return tienphatsinh;
    }

    public void setTienphatsinh(double tienphatsinh) {
        this.tienphatsinh = tienphatsinh;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    @Override
    public String toString() {
        return "GiaoCa{" + "idgiaoca=" + idgiaoca + ", maca=" + maca + ", thoidiembatdau=" + thoidiembatdau + ", thoidiemketthuc=" + thoidiemketthuc + ", tienbandau=" + tienbandau + ", tiendoanhthu=" + tiendoanhthu + ", tiencchuyenkhoan=" + tiencchuyenkhoan + ", tienmat=" + tienmat + ", tongtiencahienco=" + tongtiencahienco + ", tienchuthu=" + tienchuthu + ", tienphatsinh=" + tienphatsinh + ", ghichu=" + ghichu + ", nhanvien=" + nhanvien + '}';
    }
    
}
