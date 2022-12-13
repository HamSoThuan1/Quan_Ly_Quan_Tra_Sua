/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.KhachHang;
import repository.KhachHang_repository;
import service.KhachHang_service;

/**
 *
 * @author 84337
 */
public class KhachHang_serviceimpl implements KhachHang_service {

    KhachHang_repository khrp = new KhachHang_repository();

    private int valiDate(KhachHang kh) {
        if (kh.getMakh().trim().length() == 0) {
            return 1;
        }
        if (kh.getTenkh().trim().length() == 0) {
            return 2;
        }
        if (kh.getSodt().trim().length() == 0) {
            return 3;
        }
        Pattern p = Pattern.compile("^[0-9]{10}$");
        if (p.matcher(kh.getSodt()).find()) {
            return 4;
        }
        if (kh.getDiachi().trim().length() == 0) {
            return 5;
        }
        Pattern pattern = Pattern.compile(" ");
        if(pattern.matcher(kh.getMakh()).find()){
            return 6;
        }
        return 0;
    }

    @Override
    public List<KhachHang> GetallKH() {
        return khrp.getallKH();
    }

    @Override
    public List<KhachHang> GetKHbyma(String makh) {
        return khrp.getKHbyma(makh);
    }

    public static void main(String[] args) {
        new KhachHang_serviceimpl().GetallKH();
    }

    @Override
    public String deleteKH(String Makh) {
        boolean delete = khrp.deleteSize(Makh);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String updateKH(KhachHang kh, String makh) {
        boolean update = khrp.updateKH(kh, makh);
        if (update) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String add(KhachHang kh) {
        if (valiDate(kh) == 1) {
            return "Mã khách hàng trống";
        }
        if (valiDate(kh) == 2) {
            return "Tên khách hàng trống";
        }
        if (valiDate(kh) == 3) {
            return "Số điện thoại không được để trống";
        }
        if (valiDate(kh) != 4) {
            return "số điện thoại phải là 10 số";
        }

        if (valiDate(kh) == 5) {
            return "Địa chỉ không được bỏ trống";
        }
        if(valiDate(kh) != 6){
            return "Không được để khoảng trống ở mã KH";
        }
        boolean add = khrp.add(kh);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public KhachHang getKHByID(String idkhachhang) {
        return khrp.getKHByID(idkhachhang);
    }

    @Override
    public List<KhachHang> searchByname(String ten) {
        return khrp.searchByname(ten);
    }

    @Override
    public List<KhachHang> searchBysdt(String sdt) {
        return khrp.searchBysdt(sdt);
    }

    @Override
    public KhachHang getKhachHangByMa(String makh) {
        return khrp.getKhachHangByMa(makh);
    }
}
