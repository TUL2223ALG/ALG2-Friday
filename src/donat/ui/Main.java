/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package donat.ui;

import java.util.ArrayList;
import java.util.Scanner;
import donat.apps.InputExcepion;
import donat.apps.Zapocet;
import donat.apps.ZapocetReader;

/**
 *
 * @author ondrej.donat
 */

public class Main {
    
    /**
     * @param args the command line arguments
     */
    static ArrayList<Zapocet> ZapocetList;
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);    
    }
        boolean exit = false;
      do{
          mainMenu();
      while(exit == false){
          case():
          case 1: loadData();break;
          case 2: prehledZapoctu();break;
          case 3: narokNaZapocet();break;
          case 4: saveFile();break;
          case 0: exit = true;
          
      }      
            
      

    
    
        
    }

    private static void mainMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append("      Vysledky Zapoctu\n");
        builder.append("1 Nacteni souboru\n");
        builder.append("2 Prehled Zapoctu\n");
        builder.append("3 Narok na zapocet u studenta\n");
        builder.append("4 Ulozeni dat\n");
        builder.append("0 Konec Programu\n");
    }
    private static void loadData(){
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();
       
        System.out.println("chcete vypsat data? 0 pro ne 1 pro ano");
        int volba = sc.nextInt();
        ZapocetList = ZapocetReader.ReadCsvFile(fileName);
        if(volba == 1){
        ZapocetList.forEach((i)->{
            
            System.out.println(i);
        });
        mainMenu();
        }
        
    }
    private static void prehledZapoctu(){
        
    }
    //JV nedokoceno
}
