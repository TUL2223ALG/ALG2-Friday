package siddall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ul
 */
public class FileUtility {

    public static ArrayList<Hurricane> loadHurricaneFromFile(String pathToFile) {
        ArrayList<Hurricane> hurricanes = new ArrayList();
        File file = new File(pathToFile);
        try ( BufferedReader reader = new BufferedReader(new FileReader(file))) {
            if (!file.exists()) { //JV toto on otestuje za Vas a automaticky vynimku vyhodi
                throw new FileNotFoundException();
            } else {
                String line;
                String[] parts;
                int year;
                String month;
                int preassure;
                int speedKnot;
                String name;
                while ((line = reader.readLine()) != null) {
                    parts = line.split("[\t]+");
                    year = Integer.parseInt(parts[0]);
                    month = parts[1];
                    preassure = Integer.parseInt(parts[2]);
                    speedKnot = Integer.parseInt(parts[3]);
                    name = parts[4];
                    Hurricane hurricane = new Hurricane(year, month, preassure, speedKnot, name);
                    hurricanes.add(hurricane);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("A file with this path file" + pathToFile + " doesnt exist, please check and try again!");//JV sice vypisete hlasku, ale pokracuje dalej v programe
        } catch (IOException ex) {
            System.out.println("There was an severe error loading info from the file you provided. Please try again");
        }
        return hurricanes;
    }
    public static String getInfoOnTimePeriod(ArrayList<Hurricane> hurricanes, int fromYear, int toYear){
        for (Hurricane hurricane : hurricanes) {
            if (hurricane.getYear() >= fromYear && hurricane.getYear() <= toYear){
                System.out.println(hurricane.toString());   
            }
        }
        return null;
    }
    public static void writeIntoFile(ArrayList<Hurricane> hurricanes, String pathOfWhereToCreateFile) {
    File file = new File(pathOfWhereToCreateFile);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
           
            Collections.sort(hurricanes, new ComparatorByName());
            
            for (Hurricane hurricane : hurricanes) {
                writer.write("Jméno: " + hurricane.getName() + "\n"+ "Rok: " + hurricane.getYear()+ "\n" + "Kategorie: " + Hurricane.getSimpsonScale(hurricane) + "\n" + "\n"); 
                writer.newLine();
                
            } 
            writer.close(); //JV netreba, ked ste pouzil try with resources
    } catch (IOException ex) {
        System.out.println("There was an error writing info into file, please check: " + pathOfWhereToCreateFile);
    }
}
/*public static void writeIntoBinaryFile(ArrayList<Hurricane> hurricanes, String pathOfWhereToCreateFile) {
    //vím, že se musí přes data output stream, je to dost podobné, dole je místo writer.write trochu jiný příkaz, s UTF
    DataOutputStream
    File file = new File(pathOfWhereToCreateFile);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
           
            Collections.sort(hurricanes, new ComparatorByName());
            
            for (Hurricane hurricane : hurricanes) {
                writer.; 
                writer.newLine();
                writer.close();
            } 
    } catch (IOException ex) {
        System.out.println("There was an error writing info into file, please check: " + pathOfWhereToCreateFile);
    }
*/
}
