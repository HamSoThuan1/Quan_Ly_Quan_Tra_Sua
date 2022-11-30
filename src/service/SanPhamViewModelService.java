/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewModel.SanPhamViewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public interface SanPhamViewModelService {

    List<SanPhamViewModel> getAllSanPham();
    
    List<SanPhamViewModel> searchByName(String tenSP);
    
    List<SanPhamViewModel> getByLoaiSanPham(String tenLoaiSP);
}
