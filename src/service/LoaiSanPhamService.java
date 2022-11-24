/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.LoaiSanPham;

/**
 *
 * @author hung2
 */
public interface LoaiSanPhamService {

    List<LoaiSanPham> getAll();

    String insert(LoaiSanPham lsp);

    String update(LoaiSanPham lsp, String maLoaiSP);

    String delete(String maLoaiSP);
}
