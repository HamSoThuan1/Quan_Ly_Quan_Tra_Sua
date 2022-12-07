/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import model.thongke;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QUANGMINH
 */
public class thongke_repositoty {
    public static List<thongke> getallthongke(){
    List<thongke> listtk = new ArrayList<>();
    ResultSet rs;
    String sql="select MaHD,NgayTao,TongTien,TrangThai from HOADON";
    rs=JDBC_Helper.selectTongQuat(sql);
        try {
            while(rs.next()){
            String mahd=rs.getString(1);
            Date ngaytao=rs.getDate(2);
            double tongtien=rs.getDouble(3);
            int trangthai=rs.getInt(4);
            thongke tk = new thongke(mahd, ngaytao, tongtien, trangthai);
            listtk.add(tk);
            }
            return listtk;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static List<thongke> getthongketheothang(String thang,String nam){
    List<thongke> listtk = new ArrayList<>();
    ResultSet rs;
    String sql="select MaHD,NgayTao,TongTien,TrangThai from HOADON where month(NgayTao)=? and YEAR(NgayTao)=?";
    rs=JDBC_Helper.selectTongQuat(sql,thang,nam);
        try {
            while(rs.next()){
            String mahd=rs.getString(1);
            Date ngaytao=rs.getDate(2);
            double tongtien=rs.getDouble(3);
            int trangthai=rs.getInt(4);
            thongke tk = new thongke(mahd, ngaytao, tongtien, trangthai);
            listtk.add(tk);
            }
            return listtk;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static List<thongke> getthongketheonam(String nam){
    List<thongke> listtk = new ArrayList<>();
    ResultSet rs;
    String sql="select MaHD,NgayTao,TongTien,TrangThai from HOADON where YEAR(NgayTao)=?";
    rs=JDBC_Helper.selectTongQuat(sql,nam);
        try {
            while(rs.next()){
            String mahd=rs.getString(1);
            Date ngaytao=rs.getDate(2);
            double tongtien=rs.getDouble(3);
            int trangthai=rs.getInt(4);
            thongke tk = new thongke(mahd, ngaytao, tongtien, trangthai);
            listtk.add(tk);
            }
            return listtk;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static void main(String[] args) {
         List<thongke>list= getthongketheonam("2022");
         for (thongke x : list) {
             System.out.println(x.toString());
        }
    }
}
