/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.Nhanvien;
import java.util.List;

/**
 *
 * @author QUANGMINH
 */
public interface nhanvien_service {
    public List<Nhanvien> GetallNV();
    public Nhanvien getNVbyma(String manv);
    public Nhanvien getNVbyten(String ten);
    public List<Nhanvien> getNVbytenabc(String tenK);
    public int add(Nhanvien nv);
    public int delete (Nhanvien nv);
    public int update(Nhanvien nv);

    public Nhanvien getNVByMaVaMatKhau(String maNV, String matKhau);

    public Nhanvien getNVbyid(String idnv);
}
