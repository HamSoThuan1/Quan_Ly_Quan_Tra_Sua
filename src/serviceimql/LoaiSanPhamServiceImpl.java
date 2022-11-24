/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import model.LoaiSanPham;
import repository.LoaiSanPhamRepository;
import service.LoaiSanPhamService;

/**
 *
 * @author hung2
 */
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {

    LoaiSanPhamRepository loaiSP = new LoaiSanPhamRepository();
    
    private int valiDate(LoaiSanPham lsp){
        if(lsp.getMaLoaiSP().trim().length() == 0){
            return 1;
        }
        if(lsp.getTenLoaiSP().trim().length() == 0){
            return 2;
        }
        return 0;
    }

    @Override
    public List<LoaiSanPham> getAll() {
        return loaiSP.getAll();
    }

    @Override
    public String insert(LoaiSanPham lsp) {
        if(valiDate(lsp) == 1){
            return "Mã loại sản phẩm trống";
        }
        if(valiDate(lsp) == 2){
            return "Tên loại sản phẩm trống";
        }
        boolean insert = loaiSP.insert(lsp);
        if (insert) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(LoaiSanPham lsp, String maLoaiSP) {
        boolean update = loaiSP.update(lsp, maLoaiSP);
        if (update) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String maLoaiSP) {
        boolean delete = loaiSP.delete(maLoaiSP);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

}
