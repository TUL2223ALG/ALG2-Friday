
package nyc;

/**
 * Reprezents hurricane.
 * @author ul
 */
public class Hurricane implements Comparable <Hurricane>{
    
    private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;
    //JV mohl by mit objekt typu Category
    
    public Hurricane (int year, String month, int pressure, int speed, String name) {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
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
    
    
    
    public double getSpeedInKmH () {
        return (double)speed * 1.852;
    }
    
    @Override
    public String toString () {
        String text;
        text = "Rok: " + year + "\nMesic: " + month + "\nTlak v Mb: "
                + pressure + "\nRychlost v uzlech zahodinu: " + speed
                + "\nRychlost v km/h: " + getSpeedInKmH()
                + "\nJmeno: " + name;
        return text;
    }



    @Override
    public int compareTo(Hurricane o) {
        return this.speed - o.speed;
    }
    
}
