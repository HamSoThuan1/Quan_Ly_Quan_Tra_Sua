/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DBContext;
import entity.JDBCHeper;
import entity.JDBC_Helper;
import java.util.List;
import model.KhachHang;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author 84337
 */
public class KhachHang_repository {

    public static List<KhachHang> getallKH() {
        List<KhachHang> listkh = new ArrayList<>();
        ResultSet rs;
        String sql = "select *, CAST(SUBSTRING(MaKH, 3, 6) as int) as 'COT'\n"
                + "from KHACHHANG\n"
                + "order by COT asc";
        rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String idKhachHang = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                boolean gioitinh = rs.getBoolean(4);
                String sodt = rs.getString(5);
                String diachi = rs.getString(6);
                String ghichu = rs.getString(7);
                int trangthai = rs.getInt(8);
                KhachHang kh = new KhachHang(idKhachHang, ma, ten, gioitinh, sodt, diachi, ghichu, trangthai);
                listkh.add(kh);
            }
            for (KhachHang khachHang : listkh) {
                System.out.println(khachHang.toString());
            }
            return listkh;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<KhachHang> getKHbyma(String makh) {
        KhachHang kh = null;
        ResultSet rs;
        String sql = "select * from KHACHHANG where MaKH = ? ";
        rs = JDBCHeper.excuteQuery(sql, makh);
        try {
            while (rs.next()) {
                String idKhachHang = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                boolean gioitinh = rs.getBoolean(4);
                String sodt = rs.getString(5);
                String diachi = rs.getString(6);
                String ghichu = rs.getString(7);
                int trangthai = rs.getInt(8);
                kh = new KhachHang(idKhachHang, makh, ten, gioitinh, sodt, diachi, ghichu, trangthai);
            }
            return (List<KhachHang>) kh;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteSize(String maKH) {
        String sql = "Delete from KHACHHANG where MaKH = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setObject(1, maKH);
            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateKH(KhachHang kh, String maKH) {
        String sql = "UPDATE [dbo].[KHACHHANG]\n"
                + "   SET [HoTenKH] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[SoDT] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[GhiChu] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE [MaKH] = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setObject(1, kh.getTenkh());
            pr.setObject(2, kh.isGioitinh());
            pr.setObject(4, kh.getSodt());
            pr.setObject(5, kh.getDiachi());
            pr.setObject(6, kh.getGhichu());
            pr.setObject(7, kh.getTrangthai());
            pr.setObject(8, maKH);
            check = pr.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean add(KhachHang kh) {
        String sql = "INSERT INTO [dbo].[KHACHHANG]\n"
                + "           ([MaKH]\n"
                + "           ,[HoTenKH]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[SoDT]\n"
                + "           ,[DiaChi]\n"
                + "           ,[GhiChu]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES(?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setObject(1, kh.getMakh());
            pr.setObject(2, kh.getTenkh());
            pr.setObject(3, kh.isGioitinh());
            pr.setObject(4, kh.getSodt());
            pr.setObject(5, kh.getDiachi());
            pr.setObject(6, kh.getGhichu());
            pr.setObject(7, kh.getTrangthai());
            check = pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        getallKH();
    }

    public KhachHang getKHByID(String idkhachhang) {
        KhachHang kh = null;
        ResultSet rs;
        String sql = "select*from khachhang where idkhachhang=?";
        rs = JDBC_Helper.selectTongQuat(sql, idkhachhang);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String hoten = rs.getString(3);
                boolean gioitinh = rs.getBoolean(4);
                String sodt = rs.getString(5);
                String diachi = rs.getString(6);
                String ghichu = rs.getString(7);
                int trangthai = rs.getInt(8);
                kh = new KhachHang(idkhachhang, ma, hoten, gioitinh, sodt, diachi, ghichu, trangthai);
            }
            return kh;
        } catch (Exception e) {
            return null;
        }
    }

}
