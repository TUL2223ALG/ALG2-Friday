package week03_polynom;

public class PolynomTools {
    public static Polynom add(Polynom a,Polynom b){
        Polynom max = b;
        Polynom min = a;
        if (a.getDegree()>b.getDegree()) {
            max = a;
            min = b;           
        }
        double[] total = new double[max.getDegree()+1];
        for(int i = 0; i < min.getDegree() + 1; i++) {
            total[i] = max.getKoef(i) + min.getKoef(i);
        }
        for(int i = min.getDegree() + 1; i < max.getDegree() + 1; i++) {
            total[i] = max.getKoef(i);
        }
        return new Polynom(total, true);
    }
}
