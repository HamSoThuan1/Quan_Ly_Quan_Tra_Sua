/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author thang
 */
public class KhuyenMai {

    private String IdKM;
    private String MaKM;
    private String TenKM;
    private Date NgayBD;
    private Date NgayKT;
    private String LoaiKM;
    private int Giatri;
    private int Trangthai;

    public KhuyenMai() {
    }

    public KhuyenMai(String IdKM, String MaKM, String TenKM, Date NgayBD, Date NgayKT, String LoaiKM, int Giatri, int Trangthai) {
        this.IdKM = IdKM;
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.LoaiKM = LoaiKM;
        this.Giatri = Giatri;
        this.Trangthai = Trangthai;
    }

    public KhuyenMai(String MaKM, String TenKM, Date NgayBD, Date NgayKT, String LoaiKM, int Giatri, int Trangthai) {
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.LoaiKM = LoaiKM;
        this.Giatri = Giatri;
        this.Trangthai = Trangthai;
    }

    public String getIdKM() {
        return IdKM;
    }

    public void setIdKM(String IdKM) {
        this.IdKM = IdKM;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }

    public Date getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }

    public String getLoaiKM() {
        return LoaiKM;
    }

    public void setLoaiKM(String LoaiKM) {
        this.LoaiKM = LoaiKM;
    }

    public int getGiatri() {
        return Giatri;
    }

    public void setGiatri(int Giatri) {
        this.Giatri = Giatri;
    }

    public int getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(int Trangthai) {
        this.Trangthai = Trangthai;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "IdKM=" + IdKM + ", MaKM=" + MaKM + ", TenKM=" + TenKM + ", NgayBD=" + NgayBD + ", NgayKT=" + NgayKT + ", LoaiKM=" + LoaiKM + ", Giatri=" + Giatri + ", Trangthai=" + Trangthai + '}';
    }

}
