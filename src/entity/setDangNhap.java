/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import model.Nhanvien;

/**
 *
 * @author Acer
 */
public class setDangNhap {

    public static Nhanvien user = null;

    public static void clear() {
        setDangNhap.user = null;
    }

    public static boolean isLogin() {
        return setDangNhap.user != null;
    }

}
