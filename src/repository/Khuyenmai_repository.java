/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DBContext;
import entity.JDBC_Helper;
import java.lang.System.Logger.Level;
import java.util.List;
import model.KhuyenMai;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author thang
 */
public class Khuyenmai_repository {

    public static List<KhuyenMai> getAllKM() {
        ResultSet rs;
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "select * from KHUYENMAI";

        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                Date nbd = rs.getDate(4);
                Date nkt = rs.getDate(5);
                String htkm = rs.getString(6);
                int gtri = rs.getInt(7);
                int tt = rs.getInt(8);

                KhuyenMai km = new KhuyenMai(id, ma, ten, nbd, nkt, htkm, gtri, tt);
                listKM.add(km);
            }
            return listKM;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<KhuyenMai> getKMByHinhThuc(String makm) {
        ResultSet rs;
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "select MaKM, TenKM, NgayBatDau, NgayKetThuc, HinhThucKM, GiaTri, TrangThai from KHUYENMAI where HinhThucKM=?";

        rs = JDBC_Helper.selectTongQuat(sql, makm);
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                Date nbd = rs.getDate(3);
                Date nkt = rs.getDate(4);
                String htkm = rs.getString(5);
                int gtri = rs.getInt(6);
                int tt = rs.getInt(7);

                KhuyenMai km = new KhuyenMai(ma, ten, nbd, nkt, htkm, gtri, tt);
                listKM.add(km);
            }
            return listKM;
        } catch (Exception e) {
            return null;
        }
    }

    public static KhuyenMai getKMByMa(String mak) {
        ResultSet rs;
        KhuyenMai KM = null;
        String sql = "select MaKM, TenKM, NgayBatDau, NgayKetThuc, HinhThucKM, GiaTri, TrangThai from KHUYENMAI where MaKM=?";

        rs = JDBC_Helper.selectTongQuat(sql, mak);
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                Date nbd = rs.getDate(3);
                Date nkt = rs.getDate(4);
                String htkm = rs.getString(5);
                int gtri = rs.getInt(6);
                int tt = rs.getInt(7);

                KM = new KhuyenMai(ma, ten, nbd, nkt, htkm, gtri, tt);

            }
            return KM;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<KhuyenMai> getKMByMaK(String mak) {
        ResultSet rs;
        
        List<KhuyenMai> list = new ArrayList<>();
        String sql = "select MaKM, TenKM, NgayBatDau, NgayKetThuc, HinhThucKM, GiaTri, TrangThai from KHUYENMAI where MaKM like '%"+mak+"%'";

        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                Date nbd = rs.getDate(3);
                Date nkt = rs.getDate(4);
                String htkm = rs.getString(5);
                int gtri = rs.getInt(6);
                int tt = rs.getInt(7);

                KhuyenMai KM = new KhuyenMai(ma, ten, nbd, nkt, htkm, gtri, tt);
                list.add(KM);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<KhuyenMai> getKMByTen(String tenK) {
        ResultSet rs;
        
        List<KhuyenMai> list = new ArrayList<>();
        String sql = "select MaKM, TenKM, NgayBatDau, NgayKetThuc, HinhThucKM, GiaTri, TrangThai from KHUYENMAI where TenKM like '%"+tenK+"%'";

        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                Date nbd = rs.getDate(3);
                Date nkt = rs.getDate(4);
                String htkm = rs.getString(5);
                int gtri = rs.getInt(6);
                int tt = rs.getInt(7);

                KhuyenMai KM = new KhuyenMai(ma, ten, nbd, nkt, htkm, gtri, tt);
                list.add(KM);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public static int add(KhuyenMai km) {
        String sql = "insert into KHUYENMAI(MaKM, TenKM, NgayBatDau, NgayKetThuc, HinhThucKM, GiaTri, TrangThai) values (?,?,?,?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, km.getMaKM(), km.getTenKM(), km.getNgayBD(), km.getNgayKT(), km.getLoaiKM(), km.getGiatri(), km.getTrangthai());
    }

    public static int update(KhuyenMai km) {
        String sql = "update KHUYENMAI set MaKM=?, TenKM=?, NgayBatDau=?, NgayKetThuc=?, HinhThucKM=?, GiaTri=?, TrangThai=? where MaKM=?";
        return JDBC_Helper.updateTongQuat(sql, km.getMaKM(), km.getTenKM(), km.getNgayBD(), km.getNgayKT(), km.getLoaiKM(), km.getGiatri(), km.getTrangthai(), km.getMaKM());
    }

    public static int delete(KhuyenMai km) {
        String sql = "delete from KHUYENMAI where MaKM=?";
        return JDBC_Helper.updateTongQuat(sql, km.getMaKM());
    }

    public static List<KhuyenMai> getKMByTrangThai(int i) {
        ResultSet rs;
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "select MaKM, TenKM, NgayBatDau, NgayKetThuc, HinhThucKM, GiaTri, TrangThai from KHUYENMAI where TrangThai=?";

        rs = JDBC_Helper.selectTongQuat(sql, i);
        try {
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                Date nbd = rs.getDate(3);
                Date nkt = rs.getDate(4);
                String htkm = rs.getString(5);
                int gtri = rs.getInt(6);
                int tt = rs.getInt(7);

                KhuyenMai km = new KhuyenMai(ma, ten, nbd, nkt, htkm, gtri, tt);
                listKM.add(km);
            }
            return listKM;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
//        KhuyenMai km = getKMByTrangThai(0);
//        List<KhuyenMai> listC = new ArrayList<>();
//        listC.add(km);
        List<KhuyenMai> list = new Khuyenmai_repository().getKMByTrangThai(0);
        for (KhuyenMai khuyenMai : list) {
            System.out.println(khuyenMai.toString());
        }
    }
}
