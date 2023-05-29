package Nyc;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ul
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String FILE_SEPARATOR = System.getProperty("file.separator");

        String path1 = "data" + FILE_SEPARATOR + "HurricaneData.txt";
        String path2 = "data" + FILE_SEPARATOR + "HurricaneSavedData.txt";
        String path3 = "data" + FILE_SEPARATOR + "HurricaneBinData.dat";
        try {
            List<Hurricane> allHurricanes = Tools.loadHurricanesFromFile(path1); //JV mohla byt globalni promenna, nemusela se davat jako vstupni parametr do vsech metod
            Tools.saveHurricanesDataToFile(path2, allHurricanes);
            Tools.saveHurricanesDataToBinFile(path3, allHurricanes);

            Boolean end = false;
            int choice;
            do {
                System.out.println("Vyberte volbu.");
                System.out.println("1 - vypsani informaci o hurikanech v obdobi");
                System.out.println("2 - vypsani rychlosti hurikanu v km/h");
                System.out.println("3 - vypsani vsech hurikanu setridenych podle rychlosti");
                System.out.println("4 - kontrola binarniho souboru");
                System.out.println("0 - konec");

                choice = sc.nextInt();

                switch (choice) {
                    case 1 ->
                        choice1(allHurricanes);
                    case 2 ->
                        choice2(allHurricanes);
                    case 3 ->
                        choice3(allHurricanes);
                    case 4 ->
                        checkBinFile(path3);
                    case 0 ->
                        end = true;
                    default ->
                        System.out.println("Neplatna volba.");

                }

            } while (!end);
        } catch (IOException e) {
            System.out.println("Problem se souborem.");
        }

    }

    private static void choice1(List<Hurricane> allHurricanes) { //JV lepsi nazev pro metodu
        int startYear;
        int endYear;
        System.out.println("Zadejte pocatecni rok.");
        startYear = sc.nextInt();
        System.out.println("Zadejte koncovy rok.");
        endYear = sc.nextInt();
        for (Hurricane h : Tools.fromPeriod(allHurricanes, startYear, endYear)) {
            System.out.println("");
            System.out.println(h.toString());
            System.out.println("");
        }

    }

    private static void choice2(List<Hurricane> allHurricanes) {
        String name;
        boolean end = false;
        do {
            System.out.println("Zaddejte jmeno.");
            name = sc.next();
            List<Hurricane> founded = Tools.findHurricaneByName(name, allHurricanes);
            if (!founded.isEmpty()) {
                for (Hurricane h : founded) {
                    System.out.println("");
                    try {                        
                        System.out.print(Category.getCategory(h).getDescription());                        
                    } catch (IllegalArgumentException e) {
                        System.out.print(e.getMessage());
                    }
                    System.out.print(", " + h.getSpeedInKmH() + " km/h");
                    System.out.println("");                    
                    end = true;
                }
            } else {
                System.out.println("");
                System.out.println("Jmeno nenaezeno, zadejte znovu.");
                System.out.println("");
            }
        } while (!end);

    }
    
    private static void choice3(List<Hurricane> allHurricanes) {
        Collections.sort(allHurricanes);
        for (Hurricane h : allHurricanes) {
            System.out.println("");
            System.out.println(h.toString());
            System.out.println("");
        }
    }
    
    private static void checkBinFile (String path) throws IOException {
        File test = new File (path);
        try(DataInputStream in = new DataInputStream (new FileInputStream (test))) {
            while(true) {
                try{
                    System.out.println(in.readInt());
                }catch (EOFException e) {
                    break;
                }
            }
        }
        
    }
}
