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
    
}
