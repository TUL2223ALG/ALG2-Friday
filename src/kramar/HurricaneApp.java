package kramar;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ul
 */
public class HurricaneApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String FILE_SEPARATOR = System.getProperty("file.separator");

        int menuSelect = -1;

        try {
            HurricaneList hlist = new HurricaneList(new File("data" + FILE_SEPARATOR + "HurricaneData.txt"));
            //System.out.println(hlist.toString());
            try {
                while (menuSelect != 0) {
                    printMenu();
                    menuSelect = sc.nextInt();
                    sc.nextLine();
                    try {
                    switch (menuSelect) {
                        case 0:
                            System.out.println("Konec.");
                            break;
                        case 1:
                            System.out.println("Zadej prosim rozsah roku, v jakem chces vypsat data o hurikanech (napr.: 2001 2011): ");
                            System.out.println(hlist.getInfoInYearRange(sc.nextInt(), sc.nextInt()));
                            break;
                        case 2:
                            getByName(hlist);
                            break;
                        case 3:
                            System.out.println(hlist.sortBySpeed());
                            break;
                        case 4:
                            hlist.sortByNameWriteToFile(new File("data" + FILE_SEPARATOR + "HurricaneDataSortedByName.txt"));
                            break;
//                        case 5:
//                            hlist.writeToBinary(new File("data" + FILE_SEPARATOR + "HurricaneDataBin.dat"));
//                            break;
                        default:
                            throw new AssertionError();
                    }
                    } catch (AssertionError e){ //JV Vo finalnom kode nepouzivajte Assetions
                        System.out.println("Prosim zadavej pouze uvedena cisla.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Zadej prosim vstup ve spravnem formatu.");
            }
        } catch (IOException e) {
            System.out.println("Nepodarilo se nacist data z databaze."); //JV i zapis vyhazuje tuto vyjimku
        }
    }

    static void printMenu() {
        System.out.println("\nDATABAZE HURIKANU");
        System.out.println("Zadejte");
        System.out.println(" 0 pro ukonceni programu");
        System.out.println(" 1 pro vypsani vsech hurikanu v rozmezi roku");
        System.out.println(" 2 pro vypsani Saffir-Simpsonovy skaly a rychlosti konkretniho hurikanu");
        System.out.println(" 3 pro vypsani vsech hurikanu setridenych podle rychlosti");
        System.out.println(" 4 pro ulozeni databaze do textoveho souboru");
    }

    static void getByName(HurricaneList hlist) {
        System.out.println("Zadej prosim jmeno hurikanu (napr.: Erin): ");
        String name = sc.nextLine();
        while (!hlist.containstHurricane(name) && !"0".equals(name)) {
            System.out.println("Jmeno nenalezeno.");
            System.out.println("Zadej jmeno znova (Pokud si to neprejes, zadej 0): ");
            name = sc.nextLine();
        }
        if (!"0".equals(name)) {
            System.out.println(hlist.getInfoByName(name));
        }
    }
}
