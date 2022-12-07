/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import model.Combosanpham;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham;
import viewModel.SanPhamViewModel;

/**
 *
 * @author QUANGMINH
 */
public class Combosp_repository {
    public static List<Combosanpham> getallCBSP(){
        List<Combosanpham> listcbsp = new ArrayList<>();
        ResultSet rs;
        String sql = "select IdComboSP,COMBO.MaCombo,COMBO.TenCombo,LOAISP.TenLoaiSP,SANPHAM.MaSP,SANPHAM.TenSP,SIZE.TenSize,COMBO_SANPHAM.TrangThai from COMBO_SANPHAM join COMBO on COMBO_SANPHAM.IdCombo=COMBO.IdCombo\n" +
"							join SANPHAM on COMBO_SANPHAM.IdSanPham=SANPHAM.IdSanPham\n" +
"							join LOAISP on SANPHAM.IdLoaiSP=LOAISP.IdLoaiSP\n" +
"							join SIZE on SANPHAM.IdSize=SIZE.IdSize ORDER BY COMBO.MaCombo";
        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String id=rs.getString(1);
                String macb=rs.getString(2);
                String tencb=rs.getString(3);
                String tenloaisp=rs.getString(4);
                String masp=rs.getString(5);
                String tensp=rs.getString(6);
                String tensize=rs.getString(7);
                int trangthai=rs.getInt(8);

                Combosanpham cbsp= new Combosanpham(id,macb, tencb, tenloaisp, masp, tensp, tensize, trangthai);
                listcbsp.add(cbsp);
            }
            return listcbsp;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static List<Combosanpham> getCBSPbyma(String ma){
        List<Combosanpham> listcbsp = new ArrayList<>();
        ResultSet rs;
        String sql = "select IdComboSP,COMBO.MaCombo,COMBO.TenCombo,LOAISP.TenLoaiSP,SANPHAM.MaSP,SANPHAM.TenSP,SIZE.TenSize,COMBO_SANPHAM.TrangThai from COMBO_SANPHAM join COMBO on COMBO_SANPHAM.IdCombo=COMBO.IdCombo\n" +
"							join SANPHAM on COMBO_SANPHAM.IdSanPham=SANPHAM.IdSanPham\n" +
"							join LOAISP on SANPHAM.IdLoaiSP=LOAISP.IdLoaiSP\n" +
"							join SIZE on SANPHAM.IdSize=SIZE.IdSize where COMBO.MaCombo=?";
        rs = JDBC_Helper.selectTongQuat(sql,ma);
        try {
            while (rs.next()) {
                String id=rs.getString(1);
                String macb=rs.getString(2);
                String tencb=rs.getString(3);
                String tenloaisp=rs.getString(4);
                String masp=rs.getString(5);
                String tensp=rs.getString(6);
                String tensize=rs.getString(7);
                int trangthai=rs.getInt(8);

                Combosanpham cbsp= new Combosanpham(id,macb, tencb, tenloaisp, masp, tensp, tensize, trangthai);
                listcbsp.add(cbsp);
            }
            return listcbsp;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static Combosanpham getCBSPbyID(String ma){
       Combosanpham cbsp=null;
        ResultSet rs;
        String sql = "select IdComboSP,COMBO.MaCombo,COMBO.TenCombo,LOAISP.TenLoaiSP,SANPHAM.MaSP,SANPHAM.TenSP,SIZE.TenSize,COMBO_SANPHAM.TrangThai from COMBO_SANPHAM join COMBO on COMBO_SANPHAM.IdCombo=COMBO.IdCombo\n" +
"							join SANPHAM on COMBO_SANPHAM.IdSanPham=SANPHAM.IdSanPham\n" +
"							join LOAISP on SANPHAM.IdLoaiSP=LOAISP.IdLoaiSP\n" +
"							join SIZE on SANPHAM.IdSize=SIZE.IdSize where IdComboSP=?";
        rs = JDBC_Helper.selectTongQuat(sql,ma);
        try {
            while (rs.next()) {
                String id=rs.getString(1);
                String macb=rs.getString(2);
                String tencb=rs.getString(3);
                String tenloaisp=rs.getString(4);
                String masp=rs.getString(5);
                String tensp=rs.getString(6);
                String tensize=rs.getString(7);
                int trangthai=rs.getInt(8);

                cbsp= new Combosanpham(id,macb, tencb, tenloaisp, masp, tensp, tensize, trangthai);
                
            }
            return cbsp;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static SanPhamViewModel getspbyma(String ma){
        SanPhamViewModel sp=null;
        ResultSet rs;
        String sql="SELECT IdSanPham, MaSP, TenSP, TenLoaiSP, TenSize, DonGia, Gia,MoTa\n"
                + "FROM SANPHAM JOIN LOAISP ON SANPHAM.IdLoaiSP = LOAISP.IdLoaiSP\n"
                + "		JOIN SIZE ON SANPHAM.IdSize = SIZE.IdSize where masp=?";
        rs=JDBC_Helper.selectTongQuat(sql,ma);
        try {
            while(rs.next()){
             String idSanPham=rs.getString(1);
             String maSP=rs.getString(2);
             String tenSP=rs.getString(3);
             String loaiSP=rs.getString(4);
             String sizeSP=rs.getString(5);
             double donGia=rs.getDouble(6);
             double giaSize=rs.getDouble(7);
             String moTa=rs.getString(8);
             sp = new SanPhamViewModel(idSanPham, maSP, tenSP, loaiSP, sizeSP, donGia, giaSize, moTa);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Combosp_repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sp;
    }
    public static int add(Combosanpham cbsp){
    String sql="declare @idsp uniqueidentifier set @idsp =(select IdSanPham from SANPHAM where MaSP=?)\n" +
"declare @idcb uniqueidentifier set @idcb =(select IdCombo from COMBO where MaCombo=?)\n" +
"insert into COMBO_SANPHAM (IdSanPham,IdCombo,TrangThai) values(@idsp,@idcb,?)";
    return JDBC_Helper.updateTongQuat(sql, cbsp.getMasp(),cbsp.getMacb(),cbsp.getTrangthai());
    }
    public static int delete(Combosanpham cbsp){
    String sql= "delete from Combo_sanpham where IdComboSP=?";
    return JDBC_Helper.updateTongQuat(sql, cbsp.getID());
    }
    public static int update(Combosanpham cbsp){
    String sql="declare @idsp uniqueidentifier set @idsp =(select IdSanPham from SANPHAM where MaSP=?)\n" +
"declare @idcb uniqueidentifier set @idcb =(select IdCombo from COMBO where MaCombo=?)\n" +
"update COMBO_SANPHAM set IdSanPham=@idsp,IdCombo=@idcb,TrangThai=? where IdComboSP=? ";
    return JDBC_Helper.updateTongQuat(sql, cbsp.getMasp(),cbsp.getMacb(),cbsp.getTrangthai(),cbsp.getID());
    }
    public static void main(String[] args) {
        List<SanPhamViewModel>list = new ArrayList<>();
        SanPhamViewModel sp=getspbyma("SP01");
        list.add(sp);
        for (SanPhamViewModel x : list) {
            System.out.println(x.toString());
        }
    }
}
