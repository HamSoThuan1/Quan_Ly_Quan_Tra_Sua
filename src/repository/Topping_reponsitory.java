/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Topping;

/**
 *
 * @author Acer
 */
public class Topping_reponsitory {
    public List<Topping> getAllToppings(){
        String sql = "select * from TOPPING";
        try (Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)){
            List<Topping> toppings = new ArrayList<>();
             ResultSet rs = pr.executeQuery();
             while(rs.next()){
                 Topping t = new Topping(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
                 toppings.add(t);
             }
             return toppings;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
