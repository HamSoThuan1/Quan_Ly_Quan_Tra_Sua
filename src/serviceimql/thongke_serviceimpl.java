/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import model.thongke;
import repository.thongke_repositoty;
import service.thongke_service;

/**
 *
 * @author QUANGMINH
 */
public class thongke_serviceimpl implements thongke_service{
            thongke_repositoty tk= new thongke_repositoty();
    @Override
    public List<thongke> getallthongke() {
        return tk.getallthongke();
    }

    @Override
    public List<thongke> getthongketheothang(String thang, String nam) {
        return tk.getthongketheothang(thang, nam);
    }

    @Override
    public List<thongke> getthongketheonam(String nam) {
        return tk.getthongketheonam(nam);
    }
    
}
