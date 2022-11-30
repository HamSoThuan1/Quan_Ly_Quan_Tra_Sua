/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import model.Topping;
import repository.Topping_reponsitory;
import service.ToppingService;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class ToppingServiceImpl implements ToppingService{
    
    Topping_reponsitory topping = new Topping_reponsitory();

    @Override
    public List<Topping> getAllToppings() {
        return topping.getAllToppings();
    }

    @Override
    public String addTopping(Topping t) {
        boolean add = topping.addTopping(t);
        if(add){
            return"Thêm thành công";
        }else{
            return"Thêm thất bại";
        }
    }

    @Override
    public String deleteTopping(String ma) {
        boolean delete = topping.deleteTopping(ma);
        if(delete){
            return"Xóa thành công";
        }else{
            return"Xóa thất bại";
        }
    }

    @Override
    public String updateTopping(Topping t, String ma) {
        boolean update = topping.updateTopping(t, ma);
        if(update){
            return"Sửa thành công";
        }else{
            return"Sửa thất bại";
        }
    }
    
}
