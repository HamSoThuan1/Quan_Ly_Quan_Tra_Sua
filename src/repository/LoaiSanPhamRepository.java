/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DBContext;
import java.util.List;
import model.LoaiSanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hung2
 */
public class LoaiSanPhamRepository {

    public List<LoaiSanPham> getAll() {
        String query = "SELECT *, CAST(SUBSTRING(LOAISP.MaLoaiSP, 4, 6) as int) as 'COT' \n"
                + "FROM LOAISP\n"
                + "ORDER BY COT asc";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<LoaiSanPham> listSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiSanPham lsp = new LoaiSanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                listSP.add(lsp);
            }
            return listSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean insert(LoaiSanPham lsp) {
        String query = "INSERT INTO [dbo].[LOAISP]\n"
                + "           ([MaLoaiSP]\n"
                + "           ,[TenLoaiSP]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES(?, ?, ?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, lsp.getMaLoaiSP());
            ps.setObject(2, lsp.getTenLoaiSP());
            ps.setObject(3, lsp.getTrangThai());
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(LoaiSanPham lsp, String maLoaiSP) {
        String query = "UPDATE [dbo].[LOAISP]\n"
                + "   SET [TenLoaiSP] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE [MaLoaiSP] = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, lsp.getTenLoaiSP());
            ps.setObject(2, lsp.getTrangThai());
            ps.setObject(3, maLoaiSP);
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String maLoaiSP) {
        String query = "DELETE FROM [dbo].[LOAISP]\n"
                + "      WHERE [MaLoaiSP] = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maLoaiSP);
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<LoaiSanPham> list = new LoaiSanPhamRepository().getAll();
        for (LoaiSanPham loaiSanPham : list) {
            System.out.println(loaiSanPham.toString());
        }
    }
}
