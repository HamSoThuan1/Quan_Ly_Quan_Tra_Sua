/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author kn134
 */
public class tes {
    public static void main(String[] args) {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");
        String formatted = current.format(formatter);
        System.out.println(formatted);
    }
}
