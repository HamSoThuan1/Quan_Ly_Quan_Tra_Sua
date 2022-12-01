/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import model.Nhanvien;
import java.util.List;
import repository.Nhanvien_repository;
import service.nhanvien_service;

/**
 *
 * @author QUANGMINH
 */
public class Nhanvien_serviceimpl implements nhanvien_service{
Nhanvien_repository nvrepos= new Nhanvien_repository();
    @Override
    public List<Nhanvien> GetallNV() {
        return nvrepos.getallNV();
    }

    @Override
    public Nhanvien getNVbyma(String manv) {
        return nvrepos.getNVbyma(manv);
    }

    @Override
    public int add(Nhanvien nv) {
        return nvrepos.add(nv);
    }

    @Override
    public int delete(Nhanvien nv) {
        return nvrepos.delete(nv);
    }

    @Override
    public int update(Nhanvien nv) {
        return nvrepos.upfate(nv);
    }

    @Override
    public Nhanvien getNVByMaVaMatKhau(String maNV, String matKhau) {
        return nvrepos.getNVByMaVaMatKhau(maNV,matKhau);
    }
    
}
