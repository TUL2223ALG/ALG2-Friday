package week01_firstobjects;

public class MoneyBox {
    
    private int one;
    private int two;
    
    
    public MoneyBox(int one, int two){
        this.one = one;
        this.two = two;
    }

    public MoneyBox(){
        this(0,0);
    }
    public int sumMoney(){
        return(one+2*two);
    }

}
