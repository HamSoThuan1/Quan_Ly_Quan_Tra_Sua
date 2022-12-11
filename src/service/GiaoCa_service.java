/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.Date;
import java.util.List;
import model.GiaoCa;
import model.Nhanvien;
import viewModel.GiaoCaViewModel;
import viewModel.GiaoCaViewModel1;
import viewModel.GiaoCaViewModel2;

/**
 *
 * @author kn134
 */
public interface GiaoCa_service {

    public List<GiaoCa> getAllGiaoCa();

    public List<GiaoCaViewModel> getAllGiaoCaViewModel();

    public int add(GiaoCaViewModel gcvm);

    public GiaoCaViewModel getGiaoCaByMa(String mac);

    public int delete(String mac);

    public GiaoCa getAllGiaoCaByMaCa(String mac);

    public int add(GiaoCaViewModel1 gcvm);

    public GiaoCa getDoanhThuByThoiGianBatDau(Date dt);

    public int updateGC(GiaoCaViewModel2 gc);
}
