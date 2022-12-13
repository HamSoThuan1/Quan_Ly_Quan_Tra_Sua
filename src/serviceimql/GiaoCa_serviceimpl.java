/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.Date;
import java.util.List;
import model.GiaoCa;
import repository.GiaoCaRepository;
import repository.Nhanvien_repository;
import service.GiaoCa_service;
import viewModel.GiaoCaViewModel;
import viewModel.GiaoCaViewModel1;
import viewModel.GiaoCaViewModel2;
import viewModel.GiaoCaViewModel3;

/**
 *
 * @author kn134
 */
public class GiaoCa_serviceimpl implements GiaoCa_service{
    GiaoCaRepository gcrepos= new GiaoCaRepository();

    @Override
    public List<GiaoCa> getAllGiaoCa() {
        return gcrepos.getAllGiaoCa();
    }

    @Override
    public int add(GiaoCaViewModel gcvm) {
        return gcrepos.add(gcvm);
    }

    @Override
    public List<GiaoCaViewModel> getAllGiaoCaViewModel() {
        return gcrepos.getAllGiaoCaViewModel();
    }

    @Override
    public GiaoCaViewModel getGiaoCaByMa(String mac) {
        return gcrepos.getGiaoCaByMa(mac);
    }

    @Override
    public int delete(String mac) {
        return gcrepos.delete(mac);
    }

    @Override
    public GiaoCa getAllGiaoCaByMaCa(String mac) {
        return gcrepos.getAllGiaoCaByMaCa(mac);
    }

    @Override
    public int add(GiaoCaViewModel1 gcvm) {
        return gcrepos.add(gcvm);
    }

    @Override
    public GiaoCa getDoanhThuByThoiGianBatDau(Date dt) {
        return gcrepos.getDoanhThuByThoiGianBatDau(dt);
    }

    @Override
    public int updateGC(GiaoCaViewModel2 gc) {
        return gcrepos.updateGC(gc);
    }

    @Override
    public GiaoCaViewModel3 getsotienbandau() {
        return gcrepos.getsotienbandau();
    }

    @Override
    public List<GiaoCa> getGCByTG(Date tu, Date den) {
        return gcrepos.getGCByTG(tu,den);
    }
    
}
