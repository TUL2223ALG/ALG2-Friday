/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kramar;

import java.util.Comparator;

/**
 *
 * @author ul
 */
public class CompareByYear implements Comparator<Hurricane>{

    @Override
    public int compare(Hurricane o1, Hurricane o2) {
        if(o1.getYear() == o2.getYear()){ //JV pre integre staci return o1.getYear() - o2.getYear()
            return 0;
        } else if(o1.getYear() > o2.getYear()){
            return -1;
        } else return 1;
    }
    
}
