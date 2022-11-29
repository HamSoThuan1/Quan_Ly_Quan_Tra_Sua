/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DBContext;
import entity.JDBCHeper;
import java.util.List;
import model.KhachHang;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author 84337
 */
public class KhachHang_repository {
    public static List<KhachHang> getallKH(){
    List<KhachHang> listkh = new ArrayList<>();
    ResultSet rs;
    String sql ="select * from Khachhang ";
    rs=JDBCHeper.excuteQuery(sql);
        try {
           while(rs.next()){
               String ma=rs.getString(1);
               String ten=rs.getString(2);
               boolean gioitinh=rs.getBoolean(3);
               Date ngaysinh=rs.getDate(4);
               String sodt=rs.getString(5);
               String diachi=rs.getString(6);
               String ghichu=rs.getString(7);
               int trangthai=rs.getInt(8);
               KhachHang kh= new KhachHang(ma, ten, gioitinh, ngaysinh, sodt, diachi, ghichu, trangthai);
               listkh.add(kh);
           }
           return listkh;
        } catch (Exception e) {
            return null;
        }
}
     public static List<KhachHang> getKHbyma(String makh){
    KhachHang kh=null;
    ResultSet rs;
    String sql ="select * from KHACHHANG where MaNV=? ";
    rs=JDBCHeper.excuteQuery(sql,makh);
         try {
             while (rs.next()) {                 
                 String ma=rs.getString(1);
                 String ten=rs.getString(2);
                 boolean gioitinh=rs.getBoolean(3);
                 Date ngaysinh=rs.getDate(4);
                 String sodt=rs.getString(5);
                 String diachi=rs.getString(6);
                 String ghichu=rs.getString(7);
                 int trangthai=rs.getInt(8);
                  kh= new KhachHang(makh, ten, gioitinh, ngaysinh, sodt, diachi, ghichu, trangthai);
             }
             return (List<KhachHang>) kh;
         } catch (Exception e) {
             return null;
         }
}
    
}
