/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.KhuyenMai;

/**
 *
 * @author thang
 */
public interface KhuyenMai_service {
    public List<KhuyenMai> getAllKM();
    
    public KhuyenMai getKMByMa(String mak);
    
    public List<KhuyenMai> getKMByMaKM(String makm);
    
    public List<KhuyenMai> getKMByTrangthai(int i);
    
    public List<KhuyenMai> getKMByTen(String ten);
    
    public int add(KhuyenMai km);
    
    public int update(KhuyenMai km);
    
    public int delete(KhuyenMai km);
}
