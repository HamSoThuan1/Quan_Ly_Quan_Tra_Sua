/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import model.HoaDonChiTiet;
import repository.HoaDonChiTietRepository;
import service.HoaDonChiTietService;

/**
 *
 * @author kn134
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService{
    HoaDonChiTietRepository hdctrepository = new HoaDonChiTietRepository();
    @Override
    public int addHDCT(HoaDonChiTiet hdct) {
        return  hdctrepository.addHDCT(hdct);
    }
    
}
