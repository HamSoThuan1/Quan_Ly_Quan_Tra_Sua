/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DBContext;
import entity.JDBCHeper;
import entity.JDBC_Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.HoaDon;
import model.Nhanvien;
import model.KhachHang;
import viewModel.HoaDonViewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class HoaDonRepository {

//    public List<HoaDon> getAll() {
//        String query = "select * from HOADON";
//        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
//            List<HoaDon> listHD = new ArrayList<>();
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Nhanvien nv = new Nhanvien(rs.getString(1));
//                KhachHang kh = new KhachHang(rs.getString(2));
//                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3),
//                        rs.getDouble(4), rs.getDouble(5), rs.getDouble(6),
//                        rs.getDate(7), rs.getString(8), rs.getInt(9), nv, kh);
//            }
//            return listHD;
//        } catch (SQLException e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
    public static List<HoaDon> getAllHoaDon() {
        List<HoaDon> listHD = new ArrayList<>();
        ResultSet rs;
        String sql = "select *,CONVERT(int,SUBSTRING(MaHD,3,3)) as STT from HOADON order by STT";
        rs = JDBCHeper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                Timestamp ngaytao = rs.getTimestamp(3);
                double tongtien = rs.getDouble(4);
                double tienaodungkm = rs.getDouble(5);
                double tienKHthanhtoan = rs.getDouble(6);
                Timestamp ngaythanhtoan = rs.getTimestamp(7);
                String ghichu = rs.getString(8);
                int trangthai = rs.getInt(9);
                String idnhanvien = rs.getString(10);
                String idkhachhang = rs.getString(11);
                String idkhuyenmai = rs.getString(12);
                HoaDon hd = new HoaDon(id, ma, ngaytao, tongtien, tienaodungkm, tienKHthanhtoan, ngaythanhtoan, ghichu, trangthai, idnhanvien, idkhachhang, idkhuyenmai);
                listHD.add(hd);
            }
            return listHD;
        } catch (Exception e) {
            return null;
        }
    }
    public static List<HoaDonViewModel> getAllHDVM() {
        List<HoaDonViewModel> listhdvm = new ArrayList<>();
        ResultSet rs;
        String sql = "select mahD,ngaytao,trangthai,idnhanvien from HOADON";
        rs=JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                Date dt = rs.getDate(2);
                int tt = rs.getInt(3);
                String id = rs.getString(4);
                HoaDonViewModel hdvm = new HoaDonViewModel(ma, dt, tt, id);
                listhdvm.add(hdvm);
            }
            return listhdvm;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean insertHoaDon(HoaDonViewModel hd) {
        String query = "INSERT INTO [dbo].[HOADON]\n"
                + "           ([MaHD]\n"
                + "           ,[NgayTao]\n"
                + "           ,[TongTien]\n"
                + "           ,[TrangThai]\n"
                + "           ,[IdNhanVien]\n"
                + "           ,[IdKhachHang])\n"
                + "     VALUES(?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
//            ps.setObject(1, hd.getMaHD());
//            ps.setObject(2, hd.getNgayTao());
//            ps.setObject(3, hd.getTongTien());
//            ps.setObject(4, hd.getTrangThai());
//            ps.setObject(5, hd.getTenNV());
//            ps.setObject(6, hd.getTenKH());
//            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<HoaDon> list = new ArrayList<>();
        list=getAllHoaDon();
        for (HoaDon x : list) {
            System.out.println(x.toString());
        }
    }

    public int add(HoaDonViewModel hd) {
        String sql = "insert into hoadon(mahd,ngaytao,trangthai,idnhanvien) values(?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, hd.getMaHD(),hd.getNgayTao(),hd.getTrangThai(),hd.getIdNhanVien());
    }
}
