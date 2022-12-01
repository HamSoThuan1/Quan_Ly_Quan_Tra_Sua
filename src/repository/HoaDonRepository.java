/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<HoaDon> getAll() {
        String query = "select * from HOADON";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<HoaDon> listHD = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Nhanvien nv = new Nhanvien(rs.getString(1));
                KhachHang kh = new KhachHang(rs.getString(2));
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getDouble(6),
                        rs.getDate(7), rs.getString(8), rs.getInt(9), nv, kh);
            }
            return listHD;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
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
        List<HoaDon> list = new HoaDonRepository().getAll();
        for (HoaDon hoaDon : list) {
            System.out.println(hoaDon.toString());
        }
    }

//    public int add(HoaDonViewModel hd) {
////        String sql = ""
//    }
}
