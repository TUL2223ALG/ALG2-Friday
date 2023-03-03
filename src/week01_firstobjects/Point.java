package week01_firstobjects;

/**
 * Represents a 2D point
 */
public class Point {
    //data - atributy, instancni promemme - vlastnosti, stavy
    private double x;
    private double y;
    
    //private double[] coord = new double[2];
    
    //konstruktor - metoda vytvari instanci a inicializuje
    public Point(double x, double y){
        this.x = x;
        this.y = y;
        //this.coord[0] = x;
        //this.coord[1] = y;
    }
    
    //pretizeny konstruktor overloaded
    public Point(){
       this(0,0); //volani predchoziho konstruktoru
       //this.x = 0;
       //this.y = 0; 
    }
    /*
    public Point(int x, int y){
        this.x = x+1;
        this.y = y+1;
    }
    */
    //instancni metody, ktere pracuji nad daty
    /**
     * Calculates distance from the origin 0,0
     * @return distance
     */
    public double distance(){
        //return Math.sqrt(this.x*x + y*y);
        return Math.hypot(x, y);
    }
    
    @Override
    public String toString(){
        return String.format("x = %.2f y = %.2f", x, y);
    }
    
    //getr
    public double getX(){
        return x;
    }
    
    /*
    //setr
    public void setX(double x){
        if(x > 0){
            this.x = x;
        }
    }
    */
}
