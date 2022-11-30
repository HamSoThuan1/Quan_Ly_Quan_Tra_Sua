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
    public List<HoaDonViewModel> getAll() {
        return hoaDon.getAll();
    }

    @Override
    public String insertHoaDon(HoaDon hd) {
        boolean insert = hoaDon.insertHoaDon(hd);
        if (insert) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

}
