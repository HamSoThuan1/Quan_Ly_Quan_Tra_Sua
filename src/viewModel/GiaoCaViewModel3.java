/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

/**
 *
 * @author kn134
 */
public class GiaoCaViewModel3 {
    private double tienbandau;

    public GiaoCaViewModel3() {
    }

    public GiaoCaViewModel3(double tienbandau) {
        this.tienbandau = tienbandau;
    }

    public double getTienbandau() {
        return tienbandau;
    }

    public void setTienbandau(double tienbandau) {
        this.tienbandau = tienbandau;
    }

    @Override
    public String toString() {
        return "GiaoCaViewModel3{" + "tienbandau=" + tienbandau + '}';
    }
    
}
