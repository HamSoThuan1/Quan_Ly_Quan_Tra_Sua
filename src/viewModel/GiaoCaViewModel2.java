/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.util.Date;

/**
 *
 * @author kn134
 */
public class GiaoCaViewModel2 {
    private String maca;
    private Date thoidiemketthuc;
    private double tiendoanhthu;
    private double tonghienco;
    private double tienchuthu;
    private double tienphatsinh;
    private String ghichu;

    public GiaoCaViewModel2() {
    }

    public GiaoCaViewModel2(String maca, Date thoidiemketthuc, double tiendoanhthu, double tonghienco, double tienchuthu, double tienphatsinh, String ghichu) {
        this.maca = maca;
        this.thoidiemketthuc = thoidiemketthuc;
        this.tiendoanhthu = tiendoanhthu;
        this.tonghienco = tonghienco;
        this.tienchuthu = tienchuthu;
        this.tienphatsinh = tienphatsinh;
        this.ghichu = ghichu;
    }

    public String getMaca() {
        return maca;
    }

    public void setMaca(String maca) {
        this.maca = maca;
    }

    public Date getThoidiemketthuc() {
        return thoidiemketthuc;
    }

    public void setThoidiemketthuc(Date thoidiemketthuc) {
        this.thoidiemketthuc = thoidiemketthuc;
    }

    public double getTiendoanhthu() {
        return tiendoanhthu;
    }

    public void setTiendoanhthu(double tiendoanhthu) {
        this.tiendoanhthu = tiendoanhthu;
    }

    public double getTonghienco() {
        return tonghienco;
    }

    public void setTonghienco(double tonghienco) {
        this.tonghienco = tonghienco;
    }

    public double getTienchuthu() {
        return tienchuthu;
    }

    public void setTienchuthu(double tienchuthu) {
        this.tienchuthu = tienchuthu;
    }

    public double getTienphatsinh() {
        return tienphatsinh;
    }

    public void setTienphatsinh(double tienphatsinh) {
        this.tienphatsinh = tienphatsinh;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return "GiaoCaViewModel2{" + "maca=" + maca + ", thoidiemketthuc=" + thoidiemketthuc + ", tiendoanhthu=" + tiendoanhthu + ", tonghienco=" + tonghienco + ", tienchuthu=" + tienchuthu + ", tienphatsinh=" + tienphatsinh + ", ghichu=" + ghichu + '}';
    }
    
}
