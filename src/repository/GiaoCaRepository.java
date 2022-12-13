/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.JDBC_Helper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import model.GiaoCa;
import model.Nhanvien;
import viewModel.GiaoCaViewModel;
import viewModel.GiaoCaViewModel1;
import viewModel.GiaoCaViewModel2;
import viewModel.GiaoCaViewModel3;

/**
 *
 * @author kn134
 */
public class GiaoCaRepository {

    public static List<GiaoCa> getAllGiaoCa() {
        List<GiaoCa> listgiaoca = new ArrayList<>();
        ResultSet rs;
        String sql = "select *,CONVERT(int,SUBSTRING(MaCa,3,3)) as STT from giaoca order by STT asc";
        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                java.sql.Timestamp tdbd = rs.getTimestamp(3);
                java.sql.Timestamp tdkt = rs.getTimestamp(4);
                double tbd = rs.getDouble(5);
                double tdt = rs.getDouble(6);
                double tps = rs.getDouble(7);
                double thc = rs.getDouble(8);
                double tct = rs.getDouble(9);
                String gc = rs.getString(10);
                String idnv = rs.getString(11);
//                String manv=rs.getString(14);
//                String hoten=rs.getString(15);
//                String sodt=rs.getString(16);
//                String gioitinh=rs.getString(17);
//                Date ngaysinh=rs.getDate(18);
//                String email=rs.getString(19);
//                String diachi=rs.getString(20);
//                String chucvu=rs.getString(21);
//                String matkhau = rs.getString(22);
//                int trangthai=rs.getInt(23);
//                Nhanvien nv = new Nhanvien(id, manv, hoten, sodt, gioitinh, ngaysinh, email, diachi, chucvu, matkhau, trangthai);
                GiaoCa giaoca = new GiaoCa(id, ma, tdbd, tdkt, tbd, tdt, tps, thc, tct, gc, idnv);
                listgiaoca.add(giaoca);
            }
            return listgiaoca;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<GiaoCaViewModel> getAllGiaoCaViewModel() {
        List<GiaoCaViewModel> listgcvm = new ArrayList<>();
        ResultSet rs;
        String sql = "select MaCa,thoidiembatdau,sotienbandau,idnhanvien from giaoca order by CONVERT(int,SUBSTRING(MaCa,3,3)) asc";
        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String maca = rs.getString(1);
                Timestamp tdbd = rs.getTimestamp(2);
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

    public int add(GiaoCaViewModel gcvm) {
        String sql = "insert into GIAOCA(MaCa,ThoiDiemBatDau,SoTienBanDau,IdNhanVien) values(?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, gcvm.getMaca(), gcvm.getThoigianbatdau(), gcvm.getTienbandau(), gcvm.getIdnhanvien());
    }

    public GiaoCaViewModel getGiaoCaByMa(String mac) {
        GiaoCaViewModel gcvm = null;
        ResultSet rs;
        String sql = "select MaCa,thoidiembatdau,sotienbandau,idnhanvien from giaoca where maca=?";
        rs = JDBC_Helper.selectTongQuat(sql, mac);
        try {
            while (rs.next()) {
                String maca = rs.getString(1);
//                java.sql.Timestamp tdbd = rs.getTimestamp(3);
//                java.sql.Timestamp tdkt = rs.getTimestamp(4);
                Timestamp tdbd = rs.getTimestamp(2);
                double tbd = rs.getDouble(3);
                String idnv = rs.getString(4);
                gcvm = new GiaoCaViewModel(maca, tdbd, tbd, idnv);
            }
            return gcvm;
        } catch (Exception ex) {
            return null;
        }
    }

    public int delete(String mac) {
        String sql = "delete from giaoca where maca=?";
        return JDBC_Helper.updateTongQuat(sql, mac);
    }

    public static GiaoCa getAllGiaoCaByMaCa(String mac) {
        GiaoCa gca = null;
        ResultSet rs;
        String sql = "select*from giaoca where maca=?";
        rs = JDBC_Helper.selectTongQuat(sql, mac);
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                Timestamp tdbd = rs.getTimestamp(3);
                Timestamp tdkt = rs.getTimestamp(4);
                double tbd = rs.getDouble(5);
                double tdt = rs.getDouble(6);
                double tps = rs.getDouble(7);
                double thc = rs.getDouble(8);
                double tct = rs.getDouble(9);
                String gc = rs.getString(10);
                String idnv = rs.getString(11);
                gca = new GiaoCa(id, ma, tdbd, tdkt, tbd, tdt, thc, tps, tct, gc, idnv);
            }
            return gca;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        List<GiaoCa> list = new GiaoCaRepository().getAllGiaoCa();
        for (GiaoCa x : list) {
            System.out.println(x.toString());
        }
    }

    public int add(GiaoCaViewModel1 gcvm) {
        String sql = "insert into GIAOCA(MaCa,ThoiDiemBatDau,SoTienBanDau,IdNhanVien) values(?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, gcvm.getMaca(), gcvm.getThoigianbatdau(), gcvm.getTienbandau(), gcvm.getIdnhanvien());
    }

    public GiaoCa getDoanhThuByThoiGianBatDau(Date dt) {
        GiaoCa gca = null;
        ResultSet rs;
        String sql = "select getdate(),SUM(TongTien) as doanhthu from HOADON where NgayTao > ? and NgayTao<GETDATE()";
        rs = JDBC_Helper.selectTongQuat(sql, dt);
        try {
            while (rs.next()) {
                Timestamp tg = rs.getTimestamp(1);
                double tt = rs.getDouble(2);
                gca= new GiaoCa(tg, tt);
            }return gca;
        } catch (Exception e) {
            return null;
        }
    }

    public int updateGC(GiaoCaViewModel2 gc) {
        String sql = "update GIAOCA set ThoiDiemKetThuc=?,TienDoanhThu=?,TienPhatSinh=?,TienHienCo=?,TienChuThu=?,GhiChu=? where maca=?";
        return  JDBC_Helper.updateTongQuat(sql, gc.getThoidiemketthuc(),gc.getTiendoanhthu(),gc.getTienphatsinh(),gc.getTonghienco(),gc.getTienchuthu(),gc.getGhichu(),gc.getMaca());
    }

    public GiaoCaViewModel3 getsotienbandau() {
        GiaoCaViewModel3 gc = null;
        ResultSet rs;
        String sql = "select Top 1 TienHienCo from giaoca order by CONVERT(int,SUBSTRING(MaCa,3,3)) desc";
        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                double tbd = rs.getDouble(1);
                gc = new GiaoCaViewModel3(tbd);
            }
            return gc;
        } catch (Exception e) {
            return null;
        }
    }
}
