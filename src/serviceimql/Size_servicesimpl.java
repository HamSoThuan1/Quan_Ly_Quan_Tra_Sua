/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import model.Size;
import repository.Size_responsitory;
import service.Size_services;

/**
 *
 * @author Acer
 */
public class Size_servicesimpl implements Size_services{
    Size_responsitory size = new Size_responsitory();

    @Override
    public List<Size> getAllSizes() {
        return size.getAllSizes();  
    }

    @Override
    public String addSize(Size si) {
       boolean add = size.addSize(si);
       if(add){
           return"Thêm thành công";
       }else{
           return"Thêm thất bại";
       }
    }

    @Override
    public String deleteSize(String Ma) {
       boolean delete = size.deleteSize(Ma);
       if(delete){
           return "Xóa thành công";
       }else{
           return"Xóa thất bại";
       }
    }

    @Override
    public String updateSize(Size si, String ma) {
       boolean update = size.updateSize(si, ma);
       if(update){
           return"Sửa thành công";
       }else{
           return"Sửa thất bại";
       }
    }


   
    
}
