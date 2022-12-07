/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.List;
import model.Combo;
import repository.Combo_repository;
import service.Combo_service;

/**
 *
 * @author QUANGMINH
 */
public class Combo_serviceimpl implements Combo_service{
    Combo_repository cbrepos = new Combo_repository();

    @Override
    public List<Combo> getallCB() {
        return cbrepos.getallCB();
    }

    @Override
    public List<Combo> getLCBbyma(String ma) {
        return cbrepos.getLCBbyma(ma);
    }


    @Override
    public int add(Combo cb) {
        return cbrepos.add(cb);
    }

    @Override
    public int delete(Combo cb) {
        return cbrepos.delete(cb);
    }

    @Override
    public int update(Combo cb) {
        return cbrepos.update(cb);
    }

    @Override
    public Combo GetCBnyma(String ma) {
        return cbrepos.getCBbyma(ma);
    }
    
}
