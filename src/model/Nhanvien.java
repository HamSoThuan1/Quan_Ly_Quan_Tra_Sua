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
public class Nhanvien {
    private String ID;
    private String MaNV;
    private String HotenNv;
    private String SoDt;
    private String Gioitinh;
    private Date Ngaysinh;
    private String Email;
    private String Diachi;
    private String Chucvu;
    private String Matkhau;
    private int Trangthai;
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    

    public Nhanvien() {
    }

    public Nhanvien(String ID, String MaNV, String HotenNv, String SoDt, String Gioitinh, Date Ngaysinh, String Email, String Diachi, String Chucvu, String Matkhau, int Trangthai) {
        this.ID = ID;
        this.MaNV = MaNV;
        this.HotenNv = HotenNv;
        this.SoDt = SoDt;
        this.Gioitinh = Gioitinh;
        this.Ngaysinh = Ngaysinh;
        this.Email = Email;
        this.Diachi = Diachi;
        this.Chucvu = Chucvu;
        this.Matkhau = Matkhau;
        this.Trangthai = Trangthai;
    }

    public Nhanvien(String MaNV, String HotenNv, String SoDt, String Gioitinh, Date Ngaysinh, String Email, String Diachi, String Chucvu, String Matkhau, int Trangthai) {
        this.MaNV = MaNV;
        this.HotenNv = HotenNv;
        this.SoDt = SoDt;
        this.Gioitinh = Gioitinh;
        this.Ngaysinh = Ngaysinh;
        this.Email = Email;
        this.Diachi = Diachi;
        this.Chucvu = Chucvu;
        this.Matkhau = Matkhau;
        this.Trangthai = Trangthai;
    }
    
    

    

    

    @Override
    public String toString() {
        return "Nhanvien{" + "MaNV=" + MaNV + ", HotenNv=" + HotenNv + ", SoDt=" + SoDt + ", Gioitinh=" + Gioitinh + ", Ngaysinh=" + Ngaysinh + ", Email=" + Email + ", Diachi=" + Diachi + ", Matkhau=" + Matkhau + ", Trangthai=" + Trangthai + ", Chucvu=" + Chucvu + '}';
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHotenNv() {
        return HotenNv;
    }

    public void setHotenNv(String HotenNv) {
        this.HotenNv = HotenNv;
    }

    public String getSoDt() {
        return SoDt;
    }

    public void setSoDt(String SoDt) {
        this.SoDt = SoDt;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public Nhanvien(Date Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public int getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(int Trangthai) {
        this.Trangthai = Trangthai;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public void setChucvu(String Chucvu) {
        this.Chucvu = Chucvu;
    }

    public Date getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(Date Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }
    
    
}
