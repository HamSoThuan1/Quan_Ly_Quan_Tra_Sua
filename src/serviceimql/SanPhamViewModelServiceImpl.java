/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import model.SanPham;
import repository.SanPhamViewModelRepository;
import viewModel.SanPhamViewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class SanPhamViewModelServiceImpl implements service.SanPhamViewModelService{
    
    SanPhamViewModelRepository sanPhamre = new SanPhamViewModelRepository();

    @Override
    public List<SanPhamViewModel> getAllSanPham() {
        return sanPhamre.getAllSanPham();
    }

    @Override
    public List<SanPhamViewModel> searchByName(String tenSP) {
        return sanPhamre.searchByName(tenSP);
    }

    @Override
    public List<SanPhamViewModel> getByLoaiSanPham(String tenLoaiSP) {
        return sanPhamre.getByLoaiSanPham(tenLoaiSP);
    }

    public SanPham getSPByMa(String maSP) {
        return sanPhamre.getSPByMa(maSP);
    }
    
}
