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

    public List<HoaDonViewModel> getAll() {
        String query = "SELECT IdHoaDon, MaHD, NgayTao, HoTenNV, HoTenKH, HOADON.TrangThai\n"
                + "FROM HOADON JOIN NHANVIEN ON HOADON.IdNhanVien = NHANVIEN.IdNhanVien\n"
                + "			JOIN KHACHHANG ON HOADON.IdKhachHang = KHACHHANG.IdKhachHang";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<HoaDonViewModel> listHD = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModel hd = new HoaDonViewModel(rs.getString(1), rs.getString(2),
                        rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                listHD.add(hd);
            }
            return listHD;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insertHoaDon(HoaDon hd) {
        String query = "INSERT INTO [dbo].[HOADON]\n"
                + "           ([MaHD]\n"
                + "           ,[NgayTao]\n"
                + "            ,[GhiChu]\n"
                + "           ,[TrangThai]\n"
                + "           ,[IdNhanVien]\n"
                + "           ,[IdKhachHang])\n"
                + "     VALUES(?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, hd.getNgayTao());
            ps.setObject(3, hd.getTrangThai());
            ps.setObject(4, hd.getIdNhanVien().getHotenNv());
            ps.setObject(5, hd.getIdKhachHang().getTenkh());
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
