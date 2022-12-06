/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class Topping {

    private String idTopping;
    private String maTopping;
    private String tenToping;
    private Double gia;
    private int trangThai;

    public Topping() {
    }

    public Topping(String idTopping, String maTopping, String tenToping, Double gia, int trangThai) {
        this.idTopping = idTopping;
        this.maTopping = maTopping;
        this.tenToping = tenToping;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public Topping(String maTopping, String tenToping, Double gia, int trangThai) {
        this.maTopping = maTopping;
        this.tenToping = tenToping;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public String getIdTopping() {
        return idTopping;
    }

    public void setIdTopping(String idTopping) {
        this.idTopping = idTopping;
    }

    public String getMaTopping() {
        return maTopping;
    }

    public void setMaTopping(String maTopping) {
        this.maTopping = maTopping;
    }

    public String getTenToping() {
        return tenToping;
    }

    public void setTenToping(String tenToping) {
        this.tenToping = tenToping;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenToping + " (" + gia + ")";
    }

}
