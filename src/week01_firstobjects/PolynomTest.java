package week01_firstobjects;
public class PolynomTest {
    public static void main(String[] args) {
        double[] field1 = {2, 0, 4, -1};
        double[] field2 = {5, 3, 0};
                            
        Polynom test = new Polynom(field1, false);
        Polynom test2 = new Polynom(field2, false);
        System.out.println(test.getDEGREE());
        System.out.println(test);
        System.out.println(test.derivate());
        System.out.println(PolynomTools.add(test, test2));
        
        
        Polynom p1 = Polynom.getInstanceFromNormal(field2);
    }

}
