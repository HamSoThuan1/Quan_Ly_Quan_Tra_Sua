/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import model.GiaoCa;
import repository.GiaoCaRepository;
import repository.Nhanvien_repository;
import service.GiaoCa_service;
import viewModel.GiaoCaViewModel;

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
    
}
