/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Nhanvien;
import entity.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.concurrent.ForkJoinTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QUANGMINH
 */
public class Nhanvien_repository {
    
    public static List<Nhanvien> getallNV(){
    List<Nhanvien> listnv = new ArrayList<>();
    ResultSet rs;
    String sql ="select MaNV,HoTenNV,SoDT,GioiTinh,NgaySinh,Email,DiaChi,MatKhau,TrangThai,CHUCVU.TenCV from NHANVIEN join CHUCVU on NHANVIEN.IdChucVu=CHUCVU.IdChucVu";
    rs=JDBC_Helper.selectTongQuat(sql);
        try {
            while(rs.next()){
            String ma=rs.getString(1);
            String hoten=rs.getString(2);
            String sodt=rs.getString(3);
            String gioitinh=rs.getString(4);
            String ngaysinh=rs.getString(5);
            String email=rs.getString(6);
            String diachi=rs.getString(7);
            String matkhau = rs.getString(8);
            int trangthai=rs.getInt(9);
            String chucvu=rs.getString(10);
            Nhanvien nv = new Nhanvien(ma, hoten, sodt, gioitinh, ngaysinh, email, diachi, matkhau,trangthai, chucvu);
            listnv.add(nv);
            }
            return listnv;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static Nhanvien getNVbyma(String maNV){
    Nhanvien nv=null;
    ResultSet rs;
    String sql ="select MaNV,HoTenNV,SoDT,GioiTinh,NgaySinh,Email,DiaChi,MatKhau,TrangThai,CHUCVU.TenCV from NHANVIEN join CHUCVU on NHANVIEN.IdChucVu=CHUCVU.IdChucVu where MaNV=?";
    rs=JDBC_Helper.selectTongQuat(sql,maNV);
        try {
            while(rs.next()){
            String ma=rs.getString(1);
            String hoten=rs.getString(2);
            String sodt=rs.getString(3);
            String gioitinh=rs.getString(4);
            String ngaysinh=rs.getString(5);
            String email=rs.getString(6);
            String diachi=rs.getString(7);
            String matkhau = rs.getString(8);
            int trangthai=rs.getInt(9);
            String chucvu=rs.getString(10);
            nv = new Nhanvien(ma, hoten, sodt, gioitinh, ngaysinh, email, diachi, matkhau,trangthai, chucvu);
           
            }
            return nv;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static int add(Nhanvien nv){
    String sql="declare @idmacv uniqueidentifier set @idmacv = (select IdChucVu from CHUCVU where TenCV=?)\n" +
"insert into NHANVIEN (MaNV,HoTenNV,SoDT,GioiTinh,NgaySinh,email,DiaChi,MatKhau,TrangThai,IdChucVu) \n" +
"values (?,?,?,?,?,?,?,?,?,@idmacv)";
    return JDBC_Helper.updateTongQuat(sql,nv.getChucvu(),nv.getMaNV(),nv.getHotenNv(),nv.getSoDt(),nv.getGioitinh(),nv.getNgaysinh(),nv.getEmail(),nv.getDiachi(),nv.getMatkhau(),nv.getTrangthai());
    }
    public static int delete (Nhanvien nv){
    String sql="delete from NHANVIEN where MaNV=?";
    return JDBC_Helper.updateTongQuat(sql,nv.getMaNV());
    }
     public static int upfate(Nhanvien nv){
    String sql="declare @idmacv uniqueidentifier set @idmacv = (select idchucvu from CHUCVU where TenCV=?)"
            + "update NHANVIEN set MaNV=?,HoTenNV=?,SoDT=?,GioiTinh=?,NgaySinh=?,email=?,DiaChi=?,MatKhau=?,TrangThai=?,IdChucVu=@idmacv where MaNV=?";
    return JDBC_Helper.updateTongQuat(sql,nv.getChucvu(),nv.getMaNV(),nv.getHotenNv(),nv.getSoDt(),nv.getGioitinh(),nv.getNgaysinh(),nv.getEmail(),nv.getDiachi(),nv.getMatkhau(),nv.getTrangthai(),nv.getMaNV());
    }
    public static void main(String[] args) {
        List<Nhanvien> list = new ArrayList<>();
        list=getallNV();
        for (Nhanvien x : list) {
            System.out.println(x.toString());
        }
    }
}

