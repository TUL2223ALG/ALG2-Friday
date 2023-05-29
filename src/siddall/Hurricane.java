/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package siddall;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ul
 */
public class Hurricane {
    private int year;
    private String month;
    private int preassure;
    private int speedKnot;
    private String name;
    private ArrayList<Hurricane> hurricaneList; //JV Hurricane by mal obsahovat iba info o jednom hurikane

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("year: ").append(year).append("\n");
        sb.append("month: ").append(month).append("\n");
        sb.append("preassure:").append(preassure).append("\n");
        sb.append("speedKnot: ").append(speedKnot).append("\n");
        sb.append("name: ").append(name).append("\n").append("\n");
        return sb.toString();
    }

    public Hurricane(String name) {
        this.name = name;
    }

    public Hurricane(int speedKnot) {
        this.speedKnot = speedKnot;
    }

    public void getHurricaneList(ArrayList<Hurricane> hurricanes) {
        this.hurricaneList = hurricanes; //JV defenzivni kopie
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public int getPreassure() {
        return preassure;
    }

    public int getSpeedKnot() {
        return speedKnot;
    }

    public String getName() {
        return name;
    }

    public Hurricane(int year, String month, int preassure, int speedKnot, String name) {
        this.year = year;
        this.month = month;
        this.preassure = preassure;
        this.speedKnot = speedKnot;
        this.name = name;
    }

    public static double getSpeedInKmH(Hurricane hurricane) {
        return hurricane.getSpeedKnot() * 1.852;
    }

    public static int getSimpsonScale(Hurricane hurricane) {
        int Simpson = 0;
        double speed = Hurricane.getSpeedInKmH(hurricane);
        try {
            if ((speed >= 119) && speed <= 153) { //JV jednoduchsie, ked sa zacne < 119
                Simpson = 1;
                return Simpson;
            } else if ((speed >= 154) && speed <= 177) {
                Simpson = 2;
                return Simpson;
            } else if ((speed >= 178) && speed <= 208) {
                Simpson = 3;
                return Simpson;
            } else if ((speed >= 209) && speed <= 251) {
                Simpson = 4;
                return Simpson;
            } else if ((speed >= 252)) {
                Simpson = 5;
                return Simpson;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Your hurricane is outside of the Simpson scale");
        }
        return Simpson;
    }
    public static String getInfoOnHurricane(String name, String pathToFile){
        if(helperGetInfoOnHurricane(name, pathToFile) == null){
            return ("The hurricane with the name:" + name + " doesnt exist within the source data"); //JV lepsie vracat null, text si tam doplni UI
        } 
        return helperGetInfoOnHurricane(name, pathToFile);

    }
    //JV ked pouzivate same static metody, neprogramujete objektovo
    public static String helperGetInfoOnHurricane(String name, String pathToFile) {
       String hurricaneInfo;
        ArrayList<Hurricane> hurricanes = FileUtility.loadHurricaneFromFile(pathToFile); //JV je škoda nacitat to len kvoli tejto metode, nacitat raz a nech to pouzivaju vsetky ostatne metody
        
        for (Hurricane hurricane : hurricanes) {
            if(hurricane.getName().equalsIgnoreCase(name)) {
                hurricaneInfo = "Simpson scale:" + getSimpsonScale(hurricane) + "\n" + "Speed in km/h:" + getSpeedInKmH(hurricane) + "km/h";
                return hurricaneInfo;    
        }
    }
        return null;
    }
        

    public static String sortedHurricanesSpeed(ArrayList<Hurricane> hurricanes) {
        try {
            if (hurricanes != null) {
                for (Hurricane hurricane : hurricanes) {
                   Collections.sort(hurricanes, new ComparatorBySpeed());
                    return hurricanes.toString();
                }
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Your arrayList does not contain any information"); //JV sout pouzivajte len v UI
        }
        return null;
    }
}
