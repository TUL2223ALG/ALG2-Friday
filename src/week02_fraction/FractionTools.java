package week02_fraction;

public final class FractionTools {
    private FractionTools(){
        
    }
    
    public static Fraction addition(Fraction f1, Fraction f2){
        int jmenovatel = f1.getJmenovatel()*f2.getJmenovatel();
        int citatel = f1.getCitatel()*f2.getJmenovatel()+f2.getCitatel()*f1.getJmenovatel();
        Fraction fReturn = new Fraction(citatel,jmenovatel);
        return fReturn;
    }
    public static Fraction subtraction(Fraction f1, Fraction f2){
        int spolecnyJmenovatel = f1.getJmenovatel()*f2.getJmenovatel();
        int citatel = f1.getCitatel()*f2.getJmenovatel()-f2.getCitatel()*f1.getJmenovatel();
        Fraction fReturn = new Fraction(citatel,spolecnyJmenovatel);
        return fReturn;
    }
    public static Fraction division(Fraction f1, Fraction f2){
        int citatel = f1.getCitatel()*f2.getJmenovatel();
        int jmenovatel = f1.getJmenovatel()*f2.getCitatel();
        Fraction fReturn = new Fraction(citatel,jmenovatel);
        return fReturn;
    }
    public static Fraction multiplication(Fraction f1, Fraction f2){
        int citatel = f1.getCitatel()*f2.getCitatel();
        int jmenovatel = f1.getJmenovatel()*f2.getJmenovatel();
        Fraction fReturn = new Fraction(citatel,jmenovatel);
        return fReturn;
    }

}
