/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.util.Date;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class HoaDonViewModel {

    private String maHD;
    private Date ngayTao;
    private int trangThai;
    private String idNhanVien;
    private String idKhachHang;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String maHD, Date ngayTao, int trangThai, String idNhanVien) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.idNhanVien = idNhanVien;
    }

    public HoaDonViewModel(String maHD, Date ngayTao, int trangThai, String idNhanVien, String idKhachHang) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel{" + "maHD=" + maHD + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + ", idNhanVien=" + idNhanVien + ", idKhachHang=" + idKhachHang + '}';
    }


}
