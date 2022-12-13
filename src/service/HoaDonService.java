/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.HoaDon;
import viewModel.HoaDonViewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public interface HoaDonService {

    List<HoaDon> getAllHoaDon();

    public int add(HoaDonViewModel hd);

    String update(HoaDon hd, String idHoaDon);

    public HoaDon getHoaDonByMaHD(String maHD);

    public int update(String maHD, String ghichu);

    public int updateHD(HoaDon hd);

    List<HoaDon> timKiemcbo(int trangthai);

    List<HoaDon> getlocTheothang(String thang);

    List<HoaDon> getlocTheoNam(String nam);
}
