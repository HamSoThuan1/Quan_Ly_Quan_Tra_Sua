/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import javax.swing.JOptionPane;
import model.Nhanvien;
import repository.DangNhap_responsitory;
import service.DangNhap_services;

/**
 *
 * @author Acer
 */
public class DangNhap_servicesimpl implements DangNhap_services{
    DangNhap_responsitory dangNhap_responsitory = new DangNhap_responsitory();

    @Override
    public Nhanvien getOne(String maNV, String MatKhau) {
        return dangNhap_responsitory.getOne(maNV, MatKhau);
    }

    @Override
    public String updateMatKhau(String maNV, String maKhau) {
      int check = 0;
      check = dangNhap_responsitory.updateMatKhau(maNV, maKhau);
      if(check > 0){
          return "Đổi mật khẩu thành công";
      }else{
          return "Đổi mật khẩu thất bại";
      }
    }

  
}
