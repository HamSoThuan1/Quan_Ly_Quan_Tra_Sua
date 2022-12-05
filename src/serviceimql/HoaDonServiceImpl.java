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
    public List<HoaDon> getAllHoaDon() {
        return hoaDon.getAllHoaDon();
    }

    @Override
    public int add(HoaDonViewModel hd) {
        return hoaDon.add(hd);
    }

    @Override
    public String update(HoaDon hd, String idHoaDon) {
        boolean update = hoaDon.update(hd, idHoaDon);
        if (update) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

}
