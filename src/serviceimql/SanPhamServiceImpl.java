/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.lang.reflect.Array;
import java.util.List;
import java.util.regex.Pattern;
import model.SanPham;
import repository.SanPhamRepository;
import service.SanPhamService;
import viewModel.SanPhamViewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class SanPhamServiceImpl implements SanPhamService {

    SanPhamRepository sanPham = new SanPhamRepository();

    private int valiDate(SanPham sp) {
//        if (sp.getDonGia() == 0) {
//            return 1;
//        }
//        if (sp.getDonGia() < 0) {
//            return 2;
//        }
        try {
            if (sp.getDonGia() == 0) {
                return 1;
            }
            if (sp.getDonGia() < 0) {
                return 2;
            }
        } catch (Exception e) {
            return 3;
        }
        return 0;
    }

    @Override
    public List<SanPham> getAll() {
        return sanPham.getAll();
    }

    @Override
    public String insert(SanPham sp) {
        if (sp.getMaSP().isEmpty()) {
            return "Mã SP trống";
        }
        if (sp.getTenSP().isEmpty()) {
            return "Tên SP trống";
        }
        if (sp.getHinhAnh().isEmpty()) {
            return "Hình ảnh trống";
        }
        if (sp.getMoTa().isEmpty()) {
            return "Mô tả trống";
        }
        if (valiDate(sp) == 1) {
            return "Đơn giá trống";
        }
        if (valiDate(sp) == 2) {
            return "Đơn giá lớn hon 0";
        }

        boolean insert = sanPham.insert(sp);
        if (insert) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(SanPham sp, String id) {
        boolean update = sanPham.update(sp, id);
        if (update) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = sanPham.delete(id);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public List<SanPham> searchByTen(String tenSP) {
        return sanPham.searchByTen(tenSP);
    }

    @Override
    public List<SanPhamViewModel> getAllSanPham() {
        return sanPham.getAllSanPham();
    }

}
