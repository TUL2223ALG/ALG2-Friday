package week05a07_competition;

public class CompetitionTestApp {

    public static void main(String[] args) {
        Competition comp = new Competition("Jiz50", 900, 4);
        comp.addRunner("David");
        comp.addRunner("Bob");
        comp.addRunner("alice");
        comp.addRunner("Cyril");
        comp.setCommonStartTimeRunner();
        System.out.println(comp.startList());
        comp.setFinishTimeRunner("Bob", 1200);
        comp.setFinishTimeRunner("David", 1300);
        comp.setFinishTimeRunner("Cyril", 1400);
        comp.setFinishTimeRunner("Alice", 1500);
        System.out.println(comp.startList());
        System.out.println(comp.resultsList());
        
    }
    
}
