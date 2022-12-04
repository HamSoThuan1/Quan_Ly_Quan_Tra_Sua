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
        String sql = "select MaKH,HoTenKH,GioiTinh,NgaySinh,SoDT,DiaChi,GhiChu,TrangThai  from KHACHHANG  ";
        rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                boolean gioitinh = rs.getBoolean(3);
                Timestamp ngaysinh = rs.getTimestamp(4);
                String sodt = rs.getString(5);
                String diachi = rs.getString(6);
                String ghichu = rs.getString(7);
                int trangthai = rs.getInt(8);
                KhachHang kh = new KhachHang(ma, ten, gioitinh, ngaysinh, sodt, diachi, ghichu, trangthai);
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
        String sql = "select MaKH,HoTenKH,GioiTinh,NgaySinh,SoDT,DiaChi,GhiChu,TrangThai from KHACHHANG where MaNV=? ";
        rs = JDBCHeper.excuteQuery(sql, makh);
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                boolean gioitinh = rs.getBoolean(3);
                Timestamp ngaysinh = rs.getTimestamp(4);
                String sodt = rs.getString(5);
                String diachi = rs.getString(6);
                String ghichu = rs.getString(7);
                int trangthai = rs.getInt(8);
                kh = new KhachHang(makh, ten, gioitinh, ngaysinh, sodt, diachi, ghichu, trangthai);
            }
            return (List<KhachHang>) kh;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteSize(String Ma) {
        String sql = "Delete from SIZE where MaSize = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setObject(1, Ma);
            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateKH(KhachHang kh, String makh) {
        String sql = "UPDATE [dbo].[KHACHHANG]\n"
                + "   SET [HoTenKH] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[SoDT] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[GhiChu] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE [MaKH] = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setObject(1, kh.getTenkh());
            pr.setObject(2, kh.isGioitinh());
            pr.setObject(3, kh.getNgaysinh());
            pr.setObject(4, kh.getSodt());
            pr.setObject(5, kh.getDiachi());
            pr.setObject(6, kh.getGhichu());
            pr.setObject(7, kh.getTrangthai());
            pr.setObject(8, makh);
            check = pr.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteKH(String Makh) {
        String sql = "Delete from khachhang where Makh = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setObject(1, Makh);
            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean add(KhachHang kh) {
        String sql = "Insert into KHACHHANG values MaKH = ?,HoTenKH = ?,GioiTinh = ?,NgaySinh = ?,SoDT = ?,Diachi= ?,Ghichu=?,TrangThai = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setObject(1, kh.getMakh());
            pr.setObject(2, kh.getTenkh());
            pr.setObject(3, kh.isGioitinh());
            pr.setObject(4, kh.getNgaysinh());
            pr.setObject(5, kh.getSodt());
            pr.setObject(6, kh.getDiachi());
            pr.setObject(7, kh.getGhichu());
            pr.setObject(8, kh.getTrangthai());
            check = pr.executeUpdate();
            

        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return check >0;
    }

    public static void main(String[] args) {
        getallKH();
    }

    public KhachHang getKHByID(String idkhachhang) {
        KhachHang kh = null;
        ResultSet rs;
        String sql = "select*from khachhang where idkhachhang=?";
        rs=JDBC_Helper.selectTongQuat(sql, idkhachhang);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String hoten = rs.getString(3);
                boolean gioitinh = rs.getBoolean(4);
                Timestamp ngaysinh = rs.getTimestamp(5);
                String sodt = rs.getString(6);
                String diachi = rs.getString(7);
                String ghichu = rs.getString(8);
                int trangthai = rs.getInt(9);
                kh = new KhachHang(id, ma, hoten, gioitinh, ngaysinh, sodt, diachi, ghichu, trangthai);
            }
            return kh;
        } catch (Exception e) {
            return null;
        }
    }

}
