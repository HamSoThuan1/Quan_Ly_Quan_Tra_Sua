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

    
 
    
    
}
