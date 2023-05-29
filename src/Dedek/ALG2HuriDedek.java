package Dedek;

import java.io.IOException;
import java.util.Scanner;

public class ALG2HuriDedek {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String choice;
        boolean end = false;
        HuricaneList hurList = HurWithFile.LoadHursFromFile();
        do {
            System.out.println("Zadejte volbu:\n" + "1: Vypsat data v zadaném období\n"
                    + "2: Vypsat kategorii a rychlost daného hurikánu"
                    + "3: Vypsat informace o hurikánech (podle rychlostí)");
            choice = sc.next();

            switch (choice) {
                case "1":
                    System.out.println("Zadejte roky, mezi kterými chcete vypsat seznam hurikánů");
                    int year1 = sc.nextInt();
                    int year2 = sc.nextInt();
                    System.out.println(hurList.toStringBetweenYears(year1, year2));
                    break;
                case "2":
                    break;
                case "3":
                    hurList.comparedBySpeed();
                    System.out.println(hurList.toString());
                    break;
                case "4":
                    System.out.println("Zadejte název nového souboru");
                    String name = sc.next();
                    name += ".txt";
                    hurList.compareByName();
                    HurWithFile.SaveToTxtFile(name, hurList);
                    break;
                case "0":
                    end = true;break;
                default:
                    System.out.println("Neplatná volba");
                    break;
            }

        } while (!end);

    }
}
