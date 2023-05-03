package week05a07_competition;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CompetitionWithFilesApp {

    public static void main(String[] args) {
        Competition comp = new Competition("Jiz50", 900, 4);
        String FILE_SEPARATOR = System.getProperty("file.separator");
        try{ 
            comp.loadRegistrationsFromFile("data" + FILE_SEPARATOR + "registrace.txt");
            comp.setCommonStartTimeRunner();
            System.out.println(comp.startList());
            
            comp.loadFinishFromFile("data" + FILE_SEPARATOR + "cil.txt");
            System.out.println(comp.resultsList());
            File result = new File("data" + FILE_SEPARATOR + "vysledky.txt");
            comp.saveResultsToFile(result);
            File resultB = new File("data" + FILE_SEPARATOR + "vysledky.dat");
            comp.saveResultToBinaryFile(resultB);
            //kontrolni vypis binarniho souboru
            checkBinaryResultsFile(resultB);
        
        }catch(IOException e){
            System.out.println("Problem se souborem");
        }catch(IllegalArgumentException e){
            System.out.println("Data v souborech nejsou validni");
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void checkBinaryResultsFile(File resultB) throws IOException{
        try(DataInputStream in = new DataInputStream(new FileInputStream(resultB))){
            //jmeno bezce jako UTFString, na 8B jako long je cas behu v sekundach
            while(true){
                try{
                    System.out.print(in.readUTF() + " ");
                    System.out.println(in.readLong());
                }catch(EOFException e){
                    break;
                }
            }
        }
    }
    
}
