/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package week01_firstobjects;


public class PolynomTools {
    public static Polynom add(Polynom a,Polynom b){
        Polynom max = b;
        Polynom min = a;
        if (a.getDEGREE()>b.getDEGREE()) {
            max = a;
            min = b;           
        }
        double[] total = new double[max.getDEGREE()+1];
        for(int i = 0; i < min.getDEGREE() + 1; i++) {
            total[i] = max.getKOEF(i) + min.getKOEF(i);
        }
        for(int i = min.getDEGREE() + 1; i < max.getDEGREE() + 1; i++) {
            total[i] = max.getKOEF(i);
        }
        return new Polynom(total, true);
    }
}
