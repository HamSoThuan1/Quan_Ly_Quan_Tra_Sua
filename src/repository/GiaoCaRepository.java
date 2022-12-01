/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.JDBC_Helper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.GiaoCa;
import model.Nhanvien;
import viewModel.GiaoCaViewModel;

/**
 *
 * @author kn134
 */
public class GiaoCaRepository {
    public static List<GiaoCa> getAllGiaoCa(){
        List<GiaoCa> listgiaoca = new ArrayList<>();
        ResultSet rs;
        String sql = "select * from giaoca";
        rs=JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                String ma=rs.getString(2);
                Date tdbd = rs.getDate(3);
                Date tdkt = rs.getDate(4);
                double tbd = rs.getDouble(5);
                double tdt = rs.getDouble(6);
                double tck = rs.getDouble(7);
                double tm = rs.getDouble(8);
                double ttchc = rs.getDouble(9);
                double tct = rs.getDouble(10);
                double tps = rs.getDouble(11);
                String gc = rs.getString(12);
                
                String idnv = rs.getString(13);
                String manv=rs.getString(14);
                String hoten=rs.getString(15);
                String sodt=rs.getString(16);
                String gioitinh=rs.getString(17);
                Date ngaysinh=rs.getDate(18);
                String email=rs.getString(19);
                String diachi=rs.getString(20);
                String chucvu=rs.getString(21);
                String matkhau = rs.getString(22);
                int trangthai=rs.getInt(23);
                Nhanvien nv = new Nhanvien(id, manv, hoten, sodt, gioitinh, ngaysinh, email, diachi, chucvu, matkhau, trangthai);
                GiaoCa giaoca = new GiaoCa(diachi, ma, tdbd, tdkt, tbd, tdt, tck, tm, ttchc, tct, tps, gc, nv);
                listgiaoca.add(giaoca);
            }
            return listgiaoca;
        } catch (Exception e) {
            return null;
        }
    }
    public static List<GiaoCaViewModel> getAllGiaoCaViewModel(){
        List<GiaoCaViewModel> listgcvm = new ArrayList<>();
        ResultSet rs;
        String sql = "select MaCa,thoidiembatdau,sotienbandau,idnhanvien from giaoca order by CONVERT(int,SUBSTRING(MaCa,3,3)) asc";
        rs=JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String maca = rs.getString(1);
                Date tdbd = rs.getDate(2);
                double tbd = rs.getDouble(3);
                String idnv = rs.getString(4);
                GiaoCaViewModel gcvm = new GiaoCaViewModel(maca, tdbd, tbd, idnv);
                listgcvm.add(gcvm);
            }
            return listgcvm;
        } catch (Exception e) {
            return null;
        }
    }
    public static void main(String[] args) {
        List<GiaoCaViewModel> listgcvm = new ArrayList<>();
        listgcvm=getAllGiaoCaViewModel();
        for (GiaoCaViewModel x : listgcvm) {
            System.out.println(x.toString());
        }
    }

    public int add(GiaoCaViewModel gcvm) {
        String sql="insert into GIAOCA(MaCa,ThoiDiemBatDau,SoTienBanDau,IdNhanVien) values(?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql,gcvm.getMaca(),gcvm.getThoigianbatdau(),gcvm.getTienbandau(),gcvm.getIdnhanvien());
    }
}
