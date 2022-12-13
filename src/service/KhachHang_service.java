/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.KhachHang;

/**
 *
 * @author 84337
 */
public interface KhachHang_service {

    public List<KhachHang> GetallKH();

    public List<KhachHang> GetKHbyma(String makh);

    String deleteKH(String Makh);

    String updateKH(KhachHang kh, String makh);

    String add(KhachHang kh);

    public KhachHang getKHByID(String idkhachhang);

    List<KhachHang> searchByname(String ten);

    List<KhachHang> searchBysdt(String sdt);

    public KhachHang getKhachHangByMa(String makh);
}
