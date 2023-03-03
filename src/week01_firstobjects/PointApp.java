package week01_firstobjects;

public class PointApp {

    public static void main(String[] args) {
        double xA = 3;
        double yA = 4;
        double xB = 2;
        double yB = 1;
        
        //Point pointA = new Point();
        Point pointA = new Point(xA, yA);
        System.out.println(pointA.distance());
        
        Point pointC = new Point();
        System.out.println(pointC.distance());
    
        System.out.println(pointA.toString());
        //pointA.x = 7;
        
        System.out.println(pointA.getX());
        //pointA.setX(7);
    }
    
}
