/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import model.KhachHang;
import repository.KhachHang_repository;
import service.KhachHang_service;

/**
 *
 * @author 84337
 */
public class KhachHang_serviceimpl implements KhachHang_service {
    KhachHang_repository khrp=new KhachHang_repository();

    @Override
    public List<KhachHang> GetallKH() {
        return khrp.getallKH();
    }

    @Override
    public List<KhachHang> GetKHbyma(String makh) {
        return khrp.getKHbyma(makh);
    }

    public static void main(String[] args) {
        new KhachHang_serviceimpl().GetallKH();
    }

    @Override
    public String deleteKH(String Makh) {
         boolean delete = khrp.deleteSize(Makh);
       if(delete){
           return "Xóa thành công";
       }else{
           return"Xóa thất bại";
       }
    }
    

    @Override
    public String updateKH(KhachHang kh, String makh) {
          boolean update = khrp.updateKH(kh, makh);
       if(update){
           return"Sửa thành công";
       }else{
           return"Sửa thất bại";
       }
    }

    @Override
    public String add(KhachHang kh) {
        boolean add = khrp.add(kh);
        if (add) {
            return " theem thanh cong";
            
        }else{
            return " them that bai";
        }
    }

    @Override
    public KhachHang getKHByID(String idkhachhang) {
        return khrp.getKHByID(idkhachhang);
    }  
}
