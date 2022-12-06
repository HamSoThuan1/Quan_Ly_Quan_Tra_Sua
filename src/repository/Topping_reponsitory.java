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

    public List<Topping> getAllToppings() {
        String sql = "select *, CAST(SUBSTRING(MaTopping, 3, 5) as int) as 'COT' \n"
                + "from TOPPING\n"
                + "order by COT asc";
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            List<Topping> toppings = new ArrayList<>();
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Topping t = new Topping(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
                toppings.add(t);
            }
            return toppings;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Topping> getListToppingDB() {
        ArrayList<Topping> listToppings = new ArrayList<>();
        String query = "select * from view_xemThongTinTopping";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Topping topping = new Topping();
                topping.setIdTopping(rs.getString(1));
                topping.setMaTopping(rs.getString(2));
                topping.setTenToping(rs.getString(3));
                topping.setGia(rs.getDouble(4));
                topping.setTrangThai(rs.getInt(5));
                listToppings.add(topping);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listToppings;
    }

    public boolean addTopping(Topping t) {
        String sql = "insert into TOPPING (MaTopping, TenTopping, Gia, TrangThai) values(?,?,?,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setObject(1, t.getMaTopping());
            pr.setObject(2, t.getTenToping());
            pr.setObject(3, t.getGia());
            pr.setObject(4, t.getTrangThai());
            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean deleteTopping(String ma) {
        String sql = "delete from TOPPING where MaTopping = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setObject(1, ma);
            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateTopping(Topping t, String ma) {
        String sql = "update TOPPING set TenTopping = ?, Gia = ?, TrangThai = ? where MaTopping = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setObject(1, t.getTenToping());
            pr.setObject(2, t.getGia());
            pr.setObject(3, t.getTrangThai());
            pr.setObject(4, ma);
            check = pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<Topping> list = new Topping_reponsitory().getAllToppings();
        for (Topping topping : list) {
            System.out.println(topping.toString());
        }
    }
}
