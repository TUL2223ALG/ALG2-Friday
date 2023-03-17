/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package week01_firstobjects;

import com.sun.source.tree.BreakTree;
import java.util.Arrays;

/**
 *
 * @author 
 */
public class Polynom {
    private double[] koef;
    
    //Override
    public String toString() {
        String polynom = "";
        for (int i = 0; i < koef.length; i++) {
            if(koef[i]!=0){
            polynom = String.format("%+.1fx^%d  ", koef[i], i) + polynom;
            }
            
        }
        return polynom;
    }
    
    //Konstruktor polynomu
    public Polynom(double[] koef, boolean isReversed) {
        //this.koef = koef;
        if (isReversed) {
            this.koef = Arrays.copyOf(koef, koef.length); //defenzivni kopie
        } else {
            int fieldLength = koef.length;
            double[] temp = new double[fieldLength];
            for (int i = 0; i < fieldLength; i++) {
                temp[i] = koef[fieldLength - 1 - i];
            }
            this.koef = temp;
        }
    }

    private Polynom(double [] koef) {
        this.koef = koef;
    }  
//    public Polynom(double [] normalKoef){
//        
//    }
//    
//    public Polynom(double [] reverseKoef){
//        
//    }
    
    //tovarni metoda factory method
    public static Polynom getInstanceFromNormal(double [] koef){
        int fieldLength = koef.length;
        double[] temp = new double[fieldLength];
        for (int i = 0; i < fieldLength; i++) {
            temp[i] = koef[fieldLength - 1 - i];
        }
        return new Polynom(temp); 
    }
    
    public static Polynom getInstanceFromReversed(double [] koef){
        double[] temp = Arrays.copyOf(koef, koef.length); //defenzivni kopie 
        return new Polynom(temp);
    }
    
    //Vrací stupeň polynomu jako celé číslo
    public int getDEGREE() {
        return koef.length - 1;
    }
    public Polynom derivate(){
        double[] temp = new double[koef.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (i+1) * koef[i + 1];
        }
        return new Polynom(temp, true);
    }
    
    public double getKOEF(int degree) {
        return koef[degree];
    }
    
}
