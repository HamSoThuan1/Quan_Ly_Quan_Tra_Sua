/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Size;

/**
 *
 * @author Acer
 */
public interface Size_services {
    List<Size> getAllSizes();
    String addSize(Size si);
    String deleteSize(String Ma);
    String updateSize(Size si, String ma);
}
