/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donat.apps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ondrej.donat
 */
public class ZapocetReader {
    public static ArrayList<Zapocet> ReadCsvFile(String csvFileName){
        File file = new File(csvFileName);
        ArrayList<Zapocet> ZapocetList = new ArrayList<Zapocet>();
        String line;
        String[] splitBy;
        ArrayList<String> result = new ArrayList<String>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            
            while((line = reader.readLine())!=null){
                
                splitBy = line.split(",");
                if(!splitBy[1].equals("Příjmení")){//JV kazdeho radku se ptate jestli neni prvni - neefektivni
                    
                
                String name = splitBy[0];
                String surname = splitBy[1];
                String personalNumber = splitBy[2];
                for(int i=3;i<=splitBy.length;i++){ //JV posledni sloupec v souboru neobsahuje body
                    result.add(splitBy[i]);
                }
                Zapocet ZapocetData = new Zapocet(
                        name,
                        surname,
                        personalNumber,
                        result
                );
                ZapocetList.add(ZapocetData);
                }
            }
        }catch(IOException e){
            System.out.println("file not found");//JV sout pouzivat jen v UI
            e.printStackTrace(); //JV nevhodne osetreni vyjimky, vyhodi cerveny vypis, jak se chyba propagovala
        }
        return ZapocetList;
    }
}
