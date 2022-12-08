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
import model.SanPham;
import model.LoaiSanPham;
import model.Size;
import viewModel.SanPhamViewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class SanPhamRepository {

    public List<SanPham> getAll() {
        String query = "SELECT IdSanPham, TenLoaiSP, TenSize, Gia, MaSP, TenSP, DonGia, HinhAnh, MoTa, SANPHAM.TrangThai\n"
                + "                FROM SANPHAM JOIN LOAISP ON SANPHAM.IdLoaiSP = LOAISP.IdLoaiSP\n"
                + "JOIN SIZE ON SANPHAM.IdSize = SIZE.IdSize";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<SanPham> listSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiSanPham lsp = new LoaiSanPham(rs.getString(2));
                Size size = new Size(rs.getString(3), rs.getDouble(4));
                SanPham sp = new SanPham(rs.getString(1), lsp, size,
                        rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getString(8), rs.getString(9), rs.getInt(10));
                listSP.add(sp);
            }
            return listSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insert(SanPham sp) {
        String query = "INSERT INTO [dbo].[SANPHAM]\n"
                + "           ([IdLoaiSP]\n"
                + "           ,[IdSize]\n"
                + "           ,[MaSP]\n"
                + "           ,[TenSP]\n"
                + "           ,[DonGia]\n"
                + "           ,[HinhAnh]\n"
                + "           ,[MoTa]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES(?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getIdLoaiSP().getIdLoaiSP());
            ps.setObject(2, sp.getIdSize().getIdSize());
            ps.setObject(3, sp.getMaSP());
            ps.setObject(4, sp.getTenSP());
            ps.setObject(5, sp.getDonGia());
            ps.setObject(6, sp.getHinhAnh());
            ps.setObject(7, sp.getMoTa());
            ps.setObject(8, sp.getTrangThai());
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(SanPham sp, String id) {
        String query = "UPDATE [dbo].[SANPHAM]\n"
                + "   SET [IdLoaiSP] = ?\n"
                + "      ,[IdSize] = ?\n"
                + "      ,[MaSP] = ?\n"
                + "      ,[TenSP] = ?\n"
                + "      ,[DonGia] = ?\n"
                + "      ,[HinhAnh] = ?\n"
                + "      ,[MoTa] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE [IdSanPham] = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getIdLoaiSP().getIdLoaiSP());
            ps.setObject(2, sp.getIdSize().getIdSize());
            ps.setObject(3, sp.getMaSP());
            ps.setObject(4, sp.getTenSP());
            ps.setObject(5, sp.getDonGia());
            ps.setObject(6, sp.getHinhAnh());
            ps.setObject(7, sp.getMoTa());
            ps.setObject(8, sp.getTrangThai());
            ps.setObject(9, id);
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[SANPHAM]\n"
                + "      WHERE [IdSanPham] = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<SanPham> searchByTen(String tenSP) {
        String query = "SELECT IdSanPham, TenLoaiSP, TenSize, Gia, MaSP, TenSP, DonGia, HinhAnh, MoTa, SANPHAM.TrangThai \n"
                + "FROM SANPHAM JOIN LOAISP ON SANPHAM.IdLoaiSP = LOAISP.IdLoaiSP\n"
                + "			JOIN SIZE ON SANPHAM.IdSize = SIZE.IdSize\n"
                + "WHERE TenSP like ?";
        List<SanPham> listSP = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, "%" + tenSP + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiSanPham lsp = new LoaiSanPham(rs.getString(2));
                Size size = new Size(rs.getString(3), rs.getDouble(4));
                SanPham sp = new SanPham(rs.getString(1), lsp, size,
                        rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getString(8), rs.getString(9), rs.getInt(10));
                listSP.add(sp);
            }
            return listSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<SanPham> list = new SanPhamRepository().getAll();
        for (SanPham sanPham : list) {
            System.out.println(sanPham.toString());
        }
    }
}
