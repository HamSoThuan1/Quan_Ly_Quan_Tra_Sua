/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author kn134
 */
public class GiaoCaViewModel {
    private String maca;
    private Timestamp thoigianbatdau;
    private double tienbandau;
    private String idnhanvien;

    public GiaoCaViewModel() {
    }

    public GiaoCaViewModel(String maca, Timestamp thoigianbatdau, String idnhanvien) {
        this.maca = maca;
        this.thoigianbatdau = thoigianbatdau;
        this.idnhanvien = idnhanvien;
    }

    public GiaoCaViewModel(String maca, Timestamp thoigianbatdau, double tienbandau, String idnhanvien) {
        this.maca = maca;
        this.thoigianbatdau = thoigianbatdau;
        this.tienbandau = tienbandau;
        this.idnhanvien = idnhanvien;
    }

    public double getTienbandau() {
        return tienbandau;
    }

    public void setTienbandau(double tienbandau) {
        this.tienbandau = tienbandau;
    }
    

    public String getMaca() {
        return maca;
    }

    public void setMaca(String maca) {
        this.maca = maca;
    }

    public Timestamp getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(Timestamp thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public String getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(String idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    @Override
    public String toString() {
        return "GiaoCaViewModel{" + "maca=" + maca + ", thoigianbatdau=" + thoigianbatdau + ", tienbandau=" + tienbandau + ", idnhanvien=" + idnhanvien + '}';
    }
    
}
