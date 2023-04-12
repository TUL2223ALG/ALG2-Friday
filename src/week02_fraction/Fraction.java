package week02_fraction;

public class Fraction {

    private int jmenovatel;
    private int citatel;

    public Fraction(int citatel) {
        this.citatel = citatel;
        this.jmenovatel = 1;
    }

    public Fraction(int citatel, int jmenovatel) {
        if(jmenovatel == 0){
            throw new IllegalArgumentException("Jmenovatel nesmi byt 0");
        }
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;
        toDefault();
    }
    
    public Fraction(String x) {
        String[] parts = x.split("[ /]");
        this.citatel = Integer.parseInt(parts[0]);
        this.jmenovatel = Integer.parseInt(parts[1]);
        toDefault();
    }

    static int gcd(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);

        int min;
        if (a < b) {
            min = a;
        } else {
            min = b;
        }

        for (int i = min; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    private void toDefault() {
        int divisor = gcd(this.citatel, this.jmenovatel);
        this.citatel = this.citatel / divisor;
        this.jmenovatel = this.jmenovatel / divisor;

        if ((this.jmenovatel < 0 && this.citatel > 0)||(this.jmenovatel < 0 && this.citatel < 0)){
            this.jmenovatel *= -1;
            this.citatel *= -1;
        }
    }

    public int getCitatel() {
        return citatel;
    }

    public int getJmenovatel() {
        return jmenovatel;
    }

    @Override
    public String toString() {
        if(this.jmenovatel == 1){
            return (this.citatel+"");
        }
        return (this.citatel + "/" + this.jmenovatel);

    }
    
    public double toDouble(){
        return (double)this.citatel/this.jmenovatel;
    }
}
