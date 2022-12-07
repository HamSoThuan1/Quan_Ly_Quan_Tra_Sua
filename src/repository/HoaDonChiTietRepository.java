/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.JDBC_Helper;
import java.util.List;
import viewModel.HoaDonChiTietViewModel;
import model.HoaDonChiTiet;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class HoaDonChiTietRepository {
    public List<HoaDonChiTiet> getAll(){
        String query = "";
        return null;
    }

    public int addHDCT(HoaDonChiTiet hdct) {
        String sql = "INSERT INTO [dbo].[HOADONCHITIET]([DonGia],[SoLuong],[Giatopping],[TrangThai],[IdHoaDon],[IdSanPham])VALUES(?,?,?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, hdct.getDonGia(),hdct.getSoluong(),hdct.getGiaTopping(),hdct.getTrangthai(),hdct.getIdhoadon(),hdct.getIdsanpham());
    }
}
