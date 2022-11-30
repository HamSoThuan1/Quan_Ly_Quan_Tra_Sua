/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.SanPham;
import viewModel.SanPhamViewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public interface SanPhamService {

    List<SanPham> getAll();

    String insert(SanPham sp);

    String update(SanPham sp, String id);

    String delete(String id);
    
    List<SanPham> searchByTen(String tenSP);
}
