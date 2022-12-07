/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.JDBC_Helper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Combo;

/**
 *
 * @author QUANGMINH
 */
public class Combo_repository {

    public static List<Combo> getallCB() {
        List<Combo> listcb = new ArrayList<>();
        ResultSet rs;
        String sql = "select * from Combo ";
        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                double gia = rs.getDouble(4);
                int soluong = rs.getInt(5);
                Date ngaytao = rs.getDate(6);
                String ghichu = rs.getString(7);
                int trangthai = rs.getInt(8);

                Combo cb = new Combo(id, ma, ten, gia, soluong, ngaytao, ghichu, trangthai);
                listcb.add(cb);
            }
            return listcb;
        } catch (SQLException ex) {
            return null;
        }
    }
public static Combo getCBbyma(String macb) {
        Combo cb=null;
        ResultSet rs;
        String sql = "select * from Combo where macombo=?";
        rs = JDBC_Helper.selectTongQuat(sql, macb);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                double gia = rs.getDouble(4);
                int soluong = rs.getInt(5);
                Date ngaytao = rs.getDate(6);
                String ghichu = rs.getString(7);
                int trangthai = rs.getInt(8);

                 cb = new Combo(id, ma, ten, gia, soluong, ngaytao, ghichu, trangthai);
                
            }
            return cb;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static List<Combo> getLCBbyma(String macb) {
        List<Combo> listcb=new ArrayList<>();
        ResultSet rs;
        String sql = "select * from Combo where macombo=?";
        rs = JDBC_Helper.selectTongQuat(sql, macb);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                double gia = rs.getDouble(4);
                int soluong = rs.getInt(5);
                Date ngaytao = rs.getDate(6);
                String ghichu = rs.getString(7);
                int trangthai = rs.getInt(8);

                Combo cb = new Combo(id, ma, ten, gia, soluong, ngaytao, ghichu, trangthai);
                listcb.add(cb);
            }
            return listcb;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static int add(Combo cb) {
        String sql = "insert into COMBO (MaCombo,TenCombo,GiaCombo,SoLuong,NgayTao,GhiChu,TrangThai) values(?,?,?,?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, cb.getMacb(), cb.getTencb(), cb.getGiacb(), cb.getSoluong(), cb.getNgaytao(), cb.getGhichu(), cb.getTrangthai());
    }

    public static int delete(Combo cb) {
        String sql = "delete from combo where macombo=?";
        return JDBC_Helper.updateTongQuat(sql, cb.getMacb());
    }

    public static int update(Combo cb) {
        String sql = "update COMBO set MaCombo=?,TenCombo=?,GiaCombo=?,SoLuong=?,NgayTao=?,GhiChu=?,TrangThai=? where macombo=?";
        return JDBC_Helper.updateTongQuat(sql, cb.getMacb(), cb.getTencb(), cb.getGiacb(), cb.getSoluong(), cb.getNgaytao(), cb.getGhichu(), cb.getTrangthai(), cb.getMacb());
    }

    public static void main(String[] args) {
        
        
    }
}
