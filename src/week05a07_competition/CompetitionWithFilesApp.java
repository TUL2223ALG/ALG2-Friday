/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week05a07_competition;

import java.io.IOException;

public class CompetitionWithFilesApp {

    public static void main(String[] args) {
        Competition comp = new Competition("Jiz50", 900, 4);
        String FILE_SEPARATOR = System.getProperty("file.separator");
        try{ 
            comp.loadRegistrationsFromFile("data" + FILE_SEPARATOR + "registrace.txt");
            comp.setCommonStartTimeRunner();
            System.out.println(comp.startList());
            //comp.loadFinishFromFile("data" + FILE_SEPARATOR + "cil.txt");
            System.out.println(comp.resultsList());
        
        }catch(IOException e){
            System.out.println("Problem se souborem");
        }
    }
    
}
