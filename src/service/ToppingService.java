/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Topping;

/**
 *
 * @author Nguyen Thanh Hung
 */
public interface ToppingService {

    List<Topping> getAllToppings();

    String addTopping(Topping t);

    String deleteTopping(String ma);

    String updateTopping(Topping t, String ma);

    ArrayList<Topping> getListToppingDB();
}
