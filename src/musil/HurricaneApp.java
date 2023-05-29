package musil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HurricaneApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String FILE_SEPARATOR = System.getProperty("file.separator");
        String dataPath = ("data" + FILE_SEPARATOR + "HurricaneData.txt");
        File file = new File(dataPath);
        Hurricane[] hrs = new Hurricane[156];
        while(true) {
            System.out.println("1) Informace o hurikánech od roku X do roku Y");
            System.out.println("2) Kategorie a ryhlost hurikánu s vybraným jménem");
            System.out.println("3) Hurikány setříděny dle rychlosti");
            System.out.println("4) Zápis do textového souboru");
            System.out.println("5) Zápis do binárního souboru");
            hrs.Hurricane.addHurricane(file);
            switch(sc.nextInt()) {
                case (1) -> hrs.xToY();
                case (2) -> hrs.infoByName();
                case (3) -> hrs.sortBySpeed();
                case (4) -> hrs.writeToTxt();
                case (5) -> hrs.writeToBin();
            }
        }
        
    }
}
