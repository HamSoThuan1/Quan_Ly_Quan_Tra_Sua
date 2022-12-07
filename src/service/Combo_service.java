/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Combo;

/**
 *
 * @author QUANGMINH
 */
public interface Combo_service {
    List<Combo> getallCB();
    List<Combo> getLCBbyma(String ma);
    Combo GetCBnyma(String ma);
    int add(Combo cb);
    int delete(Combo cb);
    int update(Combo cb);
}
