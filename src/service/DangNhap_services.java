/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Nhanvien;

/**
 *
 * @author Acer
 */
public interface DangNhap_services{
   Nhanvien getOne(String maNV, String MatKhau);
   String updateMatKhau(String maNV, String maKhau );
}
