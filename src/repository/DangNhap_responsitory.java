/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DBContext;
import entity.JDBCHeper;
import model.Nhanvien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static repository.Nhanvien_repository.getallNV;

/**
 *
 * @author Acer
 */
public class DangNhap_responsitory {

    public static Nhanvien getOne(String maNV, String MatKhau) {
        String sql = "select * from NHANVIEN where MaNV = ? and MatKhau = ?";
        Nhanvien tk = null;
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setObject(1, maNV);
            pr.setObject(2, MatKhau);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
<<<<<<< HEAD
                Nhanvien nhanvien = new Nhanvien(rs.getString(1), null, null, null, null, null, null, null, rs.getString(2), 1);
               return nhanvien;
=======
                Nhanvien nv = new Nhanvien(rs.getString(1), null, null, null, null, null, null, rs.getString(2), 0, null);
                return nv;
>>>>>>> 7d262ec6e989c347cad291015863911bce8053ee
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateMatKhau(String maNV, String maKhau) {
        int row = 0;
        String sql = "update NHANVIEN set MatKhau = ? where MaNV = ?";
        row = JDBCHeper.excuteUpdate(sql, maKhau, maNV);
        return row;
    }
}
