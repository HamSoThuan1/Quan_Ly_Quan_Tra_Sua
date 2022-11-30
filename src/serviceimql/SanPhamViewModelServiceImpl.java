/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import repository.SanPhamViewModelRepository;
import viewModel.SanPhamViewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class SanPhamViewModelServiceImpl implements service.SanPhamViewModelService{
    
    SanPhamViewModelRepository sanPham = new SanPhamViewModelRepository();

    @Override
    public List<SanPhamViewModel> getAllSanPham() {
        return sanPham.getAllSanPham();
    }

    @Override
    public List<SanPhamViewModel> searchByName(String tenSP) {
        return sanPham.searchByName(tenSP);
    }

    @Override
    public List<SanPhamViewModel> getByLoaiSanPham(String tenLoaiSP) {
        return sanPham.getByLoaiSanPham(tenLoaiSP);
    }
    
}
