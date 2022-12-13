/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import model.KhuyenMai;
import repository.Khuyenmai_repository;
import service.KhuyenMai_service;

/**
 *
 * @author thang
 */
public class KhuyenMai_serviceimpl implements KhuyenMai_service{
    Khuyenmai_repository KMrepo = new Khuyenmai_repository();
    
    @Override
    public List<KhuyenMai> getAllKM() {
        return this.KMrepo.getAllKM();
    }

    @Override
    public KhuyenMai getKMByMa(String mak) {
        return this.KMrepo.getKMByMa(mak);
    }

    @Override
    public int add(KhuyenMai km) {
        return this.KMrepo.add(km);
    }

    @Override
    public int update(KhuyenMai km) {
        return this.KMrepo.update(km);
    }

    @Override
    public int delete(KhuyenMai km) {
        return this.KMrepo.delete(km);
    }

    @Override
    public List<KhuyenMai> getKMByMaKM(String makm) {
        return this.KMrepo.getKMByHinhThuc(makm);
    }

    @Override
    public List<KhuyenMai> getKMByTrangthai(int i) {
        return this.KMrepo.getKMByTrangThai(i);
    }

    @Override
    public List<KhuyenMai> getKMByTen(String ten) {
        return this.KMrepo.getKMByTen(ten);
    }

    
    
}
