/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.JDBC_Helper;
import entity.DBContext;
import entity.JDBCHeper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import viewModel.HoaDonChiTietViewModel;
import model.HoaDonChiTiet;
import model.LoaiSanPham;
import model.SanPham;
import model.Size;
import viewModel.HoaDonViewModel1;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class HoaDonChiTietRepository {

    public List<HoaDonViewModel1> getAll() {
        String sql = "select HOADONCHITIET.IdHoaDonCT,SANPHAM.MaSP, SANPHAM.TENSP,HOADON.TongTien,HOADONCHITIET.SoLuong,HOADONCHITIET.DonGia,HOADONCHITIET.GiaTopping,HOADONCHITIET.TrangThai from HOADONCHITIET\n"
                + "join HOADON on HOADONCHITIET.IdHoaDon = HOADON.IdHoaDon\n"
                + "join SANPHAM on HOADONCHITIET.IdSanPham = SANPHAM.IdSanPham";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            List<HoaDonViewModel1> listHDCt = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(2), rs.getString(3));
                HoaDon hd = new HoaDon(rs.getDouble(4));
                HoaDonViewModel1 hdct = new HoaDonViewModel1(rs.getString(1), sp, hd, 
                        rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getString(8));
                listHDCt.add(hdct);
            
            }
            return listHDCt;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public int addHDCT(HoaDonChiTiet hdct) {
        String sql = "INSERT INTO [dbo].[HOADONCHITIET]([DonGia],[SoLuong],[Giatopping],[TrangThai],[IdHoaDon],[IdSanPham])VALUES(?,?,?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, hdct.getDonGia(), hdct.getSoluong(), hdct.getGiaTopping(), hdct.getTrangthai(), hdct.getIdhoadon(), hdct.getIdsanpham());
    }
    
    public static void main(String[] args) {
        List<HoaDonViewModel1> list = new HoaDonChiTietRepository().getAll();
        for (HoaDonViewModel1 hoaDonViewModel1 : list) {
            System.out.println(hoaDonViewModel1.toString());
        }
    }

}
