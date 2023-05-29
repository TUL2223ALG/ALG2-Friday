/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package siddall;

import java.util.ArrayList;

/**
 *
 * @author ul
 */
public class ALG2Huri_Siddall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String pathToFile = "D:\\netbeans\\ALG2Huri_Siddall\\Data\\HurricaneData.txt";
       String pathOfWhereToCreate ="D:\\netbeans\\ALG2Huri_Siddall\\Data\\outputTextFile.txt";
       ArrayList<Hurricane> hurricanes = FileUtility.loadHurricaneFromFile(pathToFile);   
       System.out.println(Hurricane.getInfoOnHurricane("Tanya", pathToFile));
       System.out.println(Hurricane.sortedHurricanesSpeed(hurricanes));
       FileUtility.writeIntoFile(hurricanes, pathOfWhereToCreate);
       System.out.println(FileUtility.getInfoOnTimePeriod(hurricanes, 1998, 2000));
    }
}
