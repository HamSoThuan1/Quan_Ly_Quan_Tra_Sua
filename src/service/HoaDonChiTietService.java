/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.HoaDonChiTiet;
import viewModel.HoaDonViewModel1;

/**
 *
 * @author kn134
 */
public interface HoaDonChiTietService {

    List<HoaDonViewModel1> getAll();

    public int addHDCT(HoaDonChiTiet hdct);

}
