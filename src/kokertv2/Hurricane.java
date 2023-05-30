/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kokertv2;

/**
 *
 * @author jan.kokert
 */
public class Hurricane /*implements Comparable*/{
    private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;
    private int category;
    
    public Hurricane(int year, String month, int pressure, int speed, String name){
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public int getPressure() {
        return pressure;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
    
    public double speedToKmH(){
        double speedKmH = this.speed * 1.852;
        return speedKmH;
    }
    
    public int countCategory(){
        int category = 0;
        if (this.speed >= 74 && this.speed < 96){
            return 1;
        }
        if (this.speed >= 96 && this.speed < 111){
            return 2;
        }
        if (this.speed >= 111 && this.speed < 130){
            return 3;
        }
        if (this.speed >= 130 && this.speed < 157){
            return 4;
        }
        if (this.speed >= 157){
            return 5;
        }
        return category;
    }
    
    public Hurricane loadData(BufferedReader br)throws IOException{
        String radek = br.readLine();
        if(radek == null){
            return null;
        }
        String[] dataStr = radek.split(" ");
        
        return hurricane;
    }

    

    public int compareTo(Hurricane o) {
        return this.getSpeed() - o.getSpeed();
    }

    @Override
    public String toString() {
        return "Hurricane{" + "year=" + year + ", month=" + month + ", pressure=" + pressure + ", speed=" + speed + ", name=" + name + '}';
    }
}
