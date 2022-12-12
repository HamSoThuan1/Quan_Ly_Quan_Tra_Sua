/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.thongke;

/**
 *
 * @author QUANGMINH
 */
public interface thongke_service {
    List<thongke> getallthongke();
    List<thongke> getthongketheongay();
    List<thongke> getthongketheothang();
    List<thongke> getthongketheonam();
    List<thongke> getthongkebythang(String thang,String nam);
    List<thongke> getthongkebynam(String nam);
}
