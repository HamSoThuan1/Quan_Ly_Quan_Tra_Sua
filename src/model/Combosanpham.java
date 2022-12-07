/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author QUANGMINH
 */
public class Combosanpham {
    private String ID;
    private String macb;
    private String tencb;
    private String tenloaisp;
    private String masp;
    private String tensp;
    private String tensize;
    private int trangthai;

    public Combosanpham(String ID, String macb, String tencb, String tenloaisp, String masp, String tensp, String tensize, int trangthai) {
        this.ID = ID;
        this.macb = macb;
        this.tencb = tencb;
        this.tenloaisp = tenloaisp;
        this.masp = masp;
        this.tensp = tensp;
        this.tensize = tensize;
        this.trangthai = trangthai;
    }

    
    public Combosanpham(String macb, String tencb, String tenloaisp, String masp, String tensp, String tensize, int trangthai) {
        this.macb = macb;
        this.tencb = tencb;
        this.tenloaisp = tenloaisp;
        this.masp = masp;
        this.tensp = tensp;
        this.tensize = tensize;
        this.trangthai = trangthai;
    }

    public Combosanpham() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Combosanpham{" + "ID=" + ID + ", macb=" + macb + ", tencb=" + tencb + ", tenloaisp=" + tenloaisp + ", masp=" + masp + ", tensp=" + tensp + ", tensize=" + tensize + ", trangthai=" + trangthai + '}';
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

    public String getTenloaisp() {
        return tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {
        this.tenloaisp = tenloaisp;
    }

    public String getTensize() {
        return tensize;
    }

    public void setTensize(String tensize) {
        this.tensize = tensize;
    }

    
    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    
}
