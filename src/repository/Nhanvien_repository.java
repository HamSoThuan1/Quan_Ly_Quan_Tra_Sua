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
import java.util.Date;
import java.util.concurrent.ForkJoinTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QUANGMINH
 */
public class Nhanvien_repository {

    public static List<Nhanvien> getallNV() {
        List<Nhanvien> listnv = new ArrayList<>();
        ResultSet rs;
        String sql = "select * from NHANVIEN ";
        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString(2);
                String hoten = rs.getString(3);
                String sodt = rs.getString(4);
                String gioitinh = rs.getString(5);
                Date ngaysinh = rs.getDate(6);
                String email = rs.getString(7);
                String diachi = rs.getString(8);
                String chucvu = rs.getString(9);
                String matkhau = rs.getString(10);
                int trangthai = rs.getInt(11);

                Nhanvien nv = new Nhanvien(ma, hoten, sodt, gioitinh, ngaysinh, email, diachi, chucvu, matkhau, trangthai);
                listnv.add(nv);
            }
            return listnv;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static Nhanvien getNVbyma(String maNV) {
        Nhanvien nv = null;
        ResultSet rs;
        String sql = "select * from NHANVIEN where MaNV=? ";
        rs = JDBC_Helper.selectTongQuat(sql, maNV);
        try {
            while (rs.next()) {
                String ma = rs.getString(2);
                String hoten = rs.getString(3);
                String sodt = rs.getString(4);
                String gioitinh = rs.getString(5);
                Date ngaysinh = rs.getDate(6);
                String email = rs.getString(7);
                String diachi = rs.getString(8);
                String chucvu = rs.getString(9);
                String matkhau = rs.getString(10);
                int trangthai = rs.getInt(11);
                nv = new Nhanvien(ma, hoten, sodt, gioitinh, ngaysinh, email, diachi, chucvu, matkhau, trangthai);
            }
            return nv;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static int add(Nhanvien nv) {
        String sql = "insert into NHANVIEN (MaNV,HoTenNV,SoDT,GioiTinh,NgaySinh,email,DiaChi,MatKhau,TrangThai,ChucVu) values (?,?,?,?,?,?,?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, nv.getMaNV(), nv.getHotenNv(), nv.getSoDt(), nv.getGioitinh(), nv.getNgaysinh(), nv.getEmail(), nv.getDiachi(), nv.getMatkhau(), nv.getTrangthai(), nv.getChucvu());
    }

    public static int delete(Nhanvien nv) {
        String sql = "delete from NHANVIEN where MaNV=?";
        return JDBC_Helper.updateTongQuat(sql, nv.getMaNV());
    }

    public static int upfate(Nhanvien nv) {
        String sql = "update NHANVIEN set MaNV=?,HoTenNV=?,SoDT=?,GioiTinh=?,NgaySinh=?,email=?,DiaChi=?,MatKhau=?,TrangThai=?,ChucVu=? where MaNV=?";
        return JDBC_Helper.updateTongQuat(sql, nv.getMaNV(), nv.getHotenNv(), nv.getSoDt(), nv.getGioitinh(), nv.getNgaysinh(), nv.getEmail(), nv.getDiachi(), nv.getMatkhau(), nv.getTrangthai(), nv.getChucvu(), nv.getMaNV());
    }

    public static void main(String[] args) {

        List<Nhanvien> list = new Nhanvien_repository().getallNV();

        for (Nhanvien x : list) {
            System.out.println(x.toString());
        }
    }
}
