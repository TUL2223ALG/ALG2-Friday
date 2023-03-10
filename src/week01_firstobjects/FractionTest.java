
package week01_firstobjects;

public class FractionTest {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1,0);
        System.out.println(f1);
        Fraction f2 = new Fraction(1,3);
//        System.out.println(f.getCitatel());
//        System.out.println(f.getJmenovatel());
//        
//        System.out.println(f.toString());
//        System.out.println(f.toDouble());
        
        Fraction f3 =  FractionTools.addition(f1,f2);
        System.out.println(f3.toString());
          Fraction f4 =  FractionTools.subtraction(f1,f2);
        System.out.println(f4.toString());
          Fraction f5 =  FractionTools.division(f1,f2);
        System.out.println(f5.toString());
          Fraction f6 =  FractionTools.multiplication(f1,f2);
        System.out.println(f6.toString());
    }
    
    
}

