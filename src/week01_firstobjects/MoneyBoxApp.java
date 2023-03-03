package week01_firstobjects;

public class MoneyBoxApp {

    public static void main(String[] args) {
        String nameA = "Alice";
        String nameB = "Bob";
        int oneA = 10;
        int twoA = 5;
        int oneB = 2;
        int twoB = 4;
       
        MoneyBox moneyBoxAlice = new MoneyBox(oneA, twoA);
        MoneyBox moneyBoxBob = new MoneyBox(oneB, twoB);
        System.out.println("Alice vlastní: " + moneyBoxAlice.sumMoney());
        System.out.println("Bob vlastní: " + moneyBoxBob.sumMoney());
        System.out.println("Celkově tam je: " + (moneyBoxAlice.sumMoney()+moneyBoxBob.sumMoney()));
        
    } 
    
}
