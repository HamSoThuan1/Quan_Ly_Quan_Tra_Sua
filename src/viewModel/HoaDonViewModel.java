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
    private String idHoaDon;
    private String maHD;
    private Date ngayTao;
    private String tenNV;
    private String tenKH;
    private int trangThai;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String idHoaDon, String maHD, Date ngayTao, String tenNV, String tenKH, int trangThai) {
        this.idHoaDon = idHoaDon;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.trangThai = trangThai;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
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

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel{" + "idHoaDon=" + idHoaDon + ", maHD=" + maHD + ", ngayTao=" + ngayTao + ", tenNV=" + tenNV + ", tenKH=" + tenKH + ", trangThai=" + trangThai + '}';
    }
    
}
