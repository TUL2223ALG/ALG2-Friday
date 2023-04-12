package week05_competition;

import java.util.Scanner;

public class CompetitionApp {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Zadej pocet zavodniku");
        int n = sc.nextInt();
        System.out.println("Zadej nazev zavodu a cas spolecneho startu v sekundach");
        String name = sc.next();
        long startTime = sc.nextLong();
        Competition Jiz50 = new Competition(name, startTime, n);
        System.out.println("Zadej jmena zavodniku postupne");
        String runnerName;
        for (int i = 0; i < n; i++) {
            runnerName = sc.next();
            Jiz50.addRunner(runnerName);
        }
        Jiz50.setCommonStartTimeRunner();
        System.out.println("Zadej jmena zavodniku a jejich casy dobehu");
        long runnerFinishTime;
        for (int i = 0; i < n; i++) {
            runnerName = sc.next();
            runnerFinishTime = sc.nextLong();
            Jiz50.setFinishTimeRunner(runnerName, runnerFinishTime);
        }
        Runner winner = Jiz50.getWinner();
        System.out.println("Zvitezil " + winner.getName() + " s casem " + winner.getRunningTime());
        
        
    }
    
}
