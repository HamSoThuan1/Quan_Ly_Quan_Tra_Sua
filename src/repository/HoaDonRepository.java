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
import model.thongke;
import viewModel.HoaDonViewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class HoaDonRepository {

    public static List<HoaDon> getAllHoaDon() {
        List<HoaDon> listHD = new ArrayList<>();
        ResultSet rs;
        String sql = "select *,CONVERT(int,SUBSTRING(MaHD,3,3)) as STT from HOADON order by STT";
        rs = JDBC_Helper.selectTongQuat(sql);
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
        rs = JDBC_Helper.selectTongQuat(sql);
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

    public static void main(String[] args) {
        List<HoaDon> listcheck = new ArrayList<>();
        listcheck = getAllHoaDon();
        for (HoaDon x : listcheck) {
            System.out.println(x.toString());
        }
    }

    public int add(HoaDonViewModel hd) {
        String sql = "insert into hoadon(mahd,ngaytao,trangthai,idnhanvien) values(?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, hd.getMaHD(), hd.getNgayTao(), hd.getTrangThai(), hd.getIdNhanVien());
    }

    public boolean update(HoaDon hd, String idHoaDon) {
        String query = "UPDATE [dbo].[HOADON]\n"
                + "   SET [MaHD] = ?\n"
                + "      ,[NgayTao] = ?\n"
                + "      ,[TongTien] = ?\n"
                + "      ,[TienApDungKM] = ?\n"
                + "      ,[TienKHThanhToan] = ?\n"
                + "      ,[NgayThanhToan] = ?\n"
                + "      ,[GhiChu] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[IdNhanVien] = ?\n"
                + "      ,[IdKM] = ?\n"
                + " WHERE <[IdHoaDon] = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hd.getMaHD());
            ps.setObject(2, hd.getNgayTao());
            ps.setObject(3, hd.getTongTien());
            ps.setObject(4, hd.getTienApDungKM());
            ps.setObject(5, hd.getTienKHThanhToan());
            ps.setObject(6, hd.getNgayThanhToan());
            ps.setObject(7, hd.getTrangThai());
            ps.setObject(8, hd.getIdnhanvien());
            ps.setObject(9, hd.getIdkm());
            ps.setObject(10, idHoaDon);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public HoaDon getHoaDonByMaHD(String maHD) {
        HoaDon hd = null;
        ResultSet rs;
        String sql = "select * from hoadon where mahd=?";
        rs = JDBC_Helper.selectTongQuat(sql, maHD);
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
                hd = new HoaDon(id, ma, ngaytao, tongtien, tienaodungkm, tienKHthanhtoan, ngaythanhtoan, ghichu, trangthai, idnhanvien, idkhachhang, idkhuyenmai);
            }
            return hd;
        } catch (Exception e) {
            return null;
        }
    }

    public int update(String maHD, String ghichu) {
        String sql = "UPDATE hoadon\n"
                + "SET ghichu = ?, TrangThai = 2 \n"
                + " WHERE maHD = ?";
        return JDBC_Helper.updateTongQuat(sql, ghichu, maHD);
    }

    public int updateHD(HoaDon hd) {
        String sql = "update HOADON set TongTien=?,TienApDungKM=?,TienKHThanhToan=?,NgayThanhToan=?,GhiChu=?,TrangThai=?,idkhachhang=? where MaHD=?";
        return JDBC_Helper.updateTongQuat(sql, hd.getTongTien(), hd.getTienApDungKM(), hd.getTienKHThanhToan(), hd.getNgayThanhToan(), hd.getGhiChu(), hd.getTrangThai(), hd.getIdkhachhang(), hd.getMaHD());
    }

    public List<HoaDon> timKiemcbo(int trangthai) {
        List<HoaDon> listHD = new ArrayList<>();
        String sql = "select *,CONVERT(int,SUBSTRING(MaHD,3,3)) as STT from HOADON where TrangThai = ? order by STT";
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql);) {
            pr.setObject(1, trangthai);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7),
                        rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
                listHD.add(hd);
            }
            return listHD;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getlocTheoThang(String thang) {
        List<HoaDon> listhd = new ArrayList<>();
        String sql = "select *,CONVERT(int,SUBSTRING(MaHD,3,3)) as STT\n"
                + "from HOADON\n"
                + "where month(NgayTao)=?\n"
                + "order by STT";
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql);) {
            pr.setObject(1, thang);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3), 
                        rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7), 
                        rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
                listhd.add(hd);
            }
            return listhd;
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<HoaDon> getlocTheoNam(String nam) {
        List<HoaDon> listhd = new ArrayList<>();
        String sql = "select *,CONVERT(int,SUBSTRING(MaHD,3,3)) as STT\n"
                + "from HOADON\n"
                + "where year(NgayTao)=?\n"
                + "order by STT";
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql);) {
            pr.setObject(1, nam);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3), 
                        rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), 
                        rs.getDate(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
                listhd.add(hd);
            }
            return listhd;
        } catch (SQLException ex) {
            return null;
        }
    }
}
