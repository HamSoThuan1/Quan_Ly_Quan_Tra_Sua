/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Combosanpham;
import viewModel.SanPhamViewModel;

/**
 *
 * @author QUANGMINH
 */
public interface Combo_Sanpham_service {
    List<Combosanpham>getallCBSP();
    List<Combosanpham>getCBSPbyma(String ma);
    Combosanpham getCBSPbyID(String ma);
    SanPhamViewModel getspbyma(String ma);
    int add(Combosanpham cb);
    int delete(Combosanpham cb);
    int update(Combosanpham cb);
}
