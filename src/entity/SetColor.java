/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author hung2
 */
public class SetColor {
    public void changeColorBtn (String chucNang, JLabel ...args){
        for(JLabel _lst : args){
            if(_lst.getText().equalsIgnoreCase(chucNang)){
                _lst.getParent().setBackground(new Color(125,220,125));
                continue;
            }
            _lst.getParent().setBackground(new Color(125,190,125));
        }
    }
}
