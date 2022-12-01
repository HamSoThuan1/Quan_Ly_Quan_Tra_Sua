/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import model.HoaDon;
import repository.HoaDonRepository;
import service.HoaDonService;
import viewModel.HoaDonViewModel;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class HoaDonServiceImpl implements HoaDonService {

    HoaDonRepository hoaDon = new HoaDonRepository();


    @Override
    public String insertHoaDon(HoaDonViewModel hd) {
        boolean insert = hoaDon.insertHoaDon(hd);
        if (insert) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public List<HoaDon> getAll() {
        return hoaDon.getAll();
    }


}
