/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import model.Combosanpham;
import repository.Combosp_repository;
import service.Combo_Sanpham_service;
import viewModel.SanPhamViewModel;

/**
 *
 * @author QUANGMINH
 */
public class Combosp_servieimpl implements Combo_Sanpham_service{
        Combosp_repository cbsp = new Combosp_repository();
    @Override
    public List<Combosanpham> getallCBSP() {
        return cbsp.getallCBSP();
    }

    @Override
    public List<Combosanpham> getCBSPbyma(String ma) {
        return cbsp.getCBSPbyma(ma);
    }

    @Override
    public SanPhamViewModel getspbyma(String ma) {
        return cbsp.getspbyma(ma);
    }

    @Override
    public int add(Combosanpham cb) {
        return cbsp.add(cb);
    }

    @Override
    public int delete(Combosanpham cb) {
        return cbsp.delete(cb);
    }

    @Override
    public int update(Combosanpham cb) {
         return cbsp.update(cb);
    }

    @Override
    public Combosanpham getCBSPbyID(String ma) {
        return cbsp.getCBSPbyID(ma);
    }
    
}
