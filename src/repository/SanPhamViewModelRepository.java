/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DBContext;
import entity.JDBC_Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import viewModel.SanPhamViewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class SanPhamViewModelRepository {

    public List<SanPhamViewModel> getAllSanPham() {
        String query = "SELECT IdSanPham, MaSP, TenSP, TenLoaiSP, TenSize, DonGia, Gia, MoTa, CAST(SUBSTRING(MaSP, 3, 5) as int) as 'COT'\n"
                + "              FROM SANPHAM JOIN LOAISP ON SANPHAM.IdLoaiSP = LOAISP.IdLoaiSP\n"
                + "				JOIN SIZE ON SANPHAM.IdSize = SIZE.IdSize\n"
                + "				order by COT asc";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<SanPhamViewModel> listSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getString(8));
                listSP.add(sp);
            }
            return listSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPhamViewModel> searchByName(String tenSP) {
        String query = "SELECT IdSanPham, MaSP, TenSP, TenLoaiSP, TenSize, DonGia, Gia, MoTa \n"
                + "FROM SANPHAM JOIN LOAISP ON SANPHAM.IdLoaiSP = LOAISP.IdLoaiSP\n"
                + "            JOIN SIZE ON SANPHAM.IdSize = SIZE.IdSize\n"
                + "WHERE TenSP like ?";
        List<SanPhamViewModel> listSP = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + tenSP + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getString(8));
                listSP.add(sp);
            }
            return listSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SanPhamViewModel> getByLoaiSanPham(String tenLoaiSP) {
        String query = "SELECT IdSanPham, MaSP, TenSP, TenLoaiSP, TenSize, DonGia, Gia, MoTa \n"
                + "FROM SANPHAM JOIN LOAISP ON SANPHAM.IdLoaiSP = LOAISP.IdLoaiSP\n"
                + "            JOIN SIZE ON SANPHAM.IdSize = SIZE.IdSize\n"
                + "WHERE LOAISP.TenLoaiSP = ?";
        List<SanPhamViewModel> listSP = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tenLoaiSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamViewModel sp = new SanPhamViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getString(8));
                listSP.add(sp);
            }
            return listSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public SanPhamViewModel getspbyma(String ma) {
        String query = "SELECT IdSanPham, MaSP, TenSP, TenLoaiSP, TenSize, DonGia, Gia, MoTa \n"
                + "FROM SANPHAM JOIN LOAISP ON SANPHAM.IdLoaiSP = LOAISP.IdLoaiSP\n"
                + "            JOIN SIZE ON SANPHAM.IdSize = SIZE.IdSize\n"
                + "WHERE MaSP like ?";
        SanPhamViewModel sp=null;
        List<SanPhamViewModel> listSP = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp = new SanPhamViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getString(8));
                listSP.add(sp);
            }
            return sp;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<SanPhamViewModel> lists = new SanPhamViewModelRepository().getAllSanPham();
        for (SanPhamViewModel sp : lists) {
            System.out.println(sp.toString());
        }
    }

    public SanPham getSPByMa(String maSP) {
        SanPham sp = null;
        ResultSet rs;
        String sql = "select IdSanPham,MaSP,TenSP,DonGia,HinhAnh,MoTa,TrangThai from SANPHAM where masp = ?";
        rs=JDBC_Helper.selectTongQuat(sql, maSP);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
//                String idlsp = rs.getString(2);
//                String idsize = rs.getString(3);
                String ma = rs.getString(2);
                String tensp = rs.getString(3);
                double dongia = rs.getDouble(4);
                String hinhanh = rs.getString(5);
                String mota = rs.getString(6);
                int trangthai = rs.getInt(7);
                sp = new SanPham(id, ma, tensp, dongia, hinhanh, mota, trangthai);
            }
            return sp;
        } catch (Exception e) {
            return null;
        }
    }
}
