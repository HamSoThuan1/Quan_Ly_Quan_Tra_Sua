/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceimql;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyen Thanh Hung
 */
public class Thu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile("^[0-9]+$");
        while (true) {            
            System.out.println("input txt: ");
            String txt = sc.nextLine();
            if(p.matcher(txt).find()){
                System.out.println("txt ok");
                break;
            }else{
                System.err.println("txt not ok");
            }
        }
    }
}
