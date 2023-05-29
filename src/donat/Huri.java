/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donat;
import java.lang.Iterable;
/**
 *
 * @author ondrej.donat
 */
public class Huri {
    private int year;
    private String month;
    private double pressure;
    private int speed;
    private String name;
    
    public Huri(int year,String month, double pressure, int speed, String name){
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
                
    }
    public int getYear(){
        return year;
    }
    public double getPressure(){
        return pressure;
    }
    public int getSpeed(){
        return speed;
    }
    public String getName(){
        return name;
    }
    public double getSpeedInKm(){
        return 1.852*(double)speed;
    }
    public int Category(){
        double speed = getSpeedInKm();
        int k = 0;
        if (speed >= 74 && speed <= 153){
            k = 1;
        }
        else if (speed >= 154 && speed <= 177){
            k = 2;
        }
        else if (speed >= 178 && speed <= 208){
            k = 3;
        }
        else if (speed >= 252){
            k = 4;
        }
        return k;
    }
    public int numHuri(){
        int numberOfHuri = 0;
        for(int y:year){
        if (this.year == y){
            numberOfHuri++;
        }
        }
        return numberOfHuri;
    }
    
    
    
    
}
