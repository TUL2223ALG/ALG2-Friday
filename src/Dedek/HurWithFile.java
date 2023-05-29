package Dedek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HurWithFile {

    public static HuricaneList LoadHursFromFile() throws FileNotFoundException, IOException {

        String path = System.getProperty("user.dir");
        String FileSeparator = System.getProperty("file.separator");
        String nameOfFile = "HurricaneData.txt";
        String folder = "data";
        File pathFolder = new File(path, folder);
        path = pathFolder.getAbsolutePath();

        path = path + FileSeparator + nameOfFile;
        System.out.println(path);

        String line;
        String[] parts;
        Huricane huricane;
        File HuriFile = new File(path);

        HuricaneList hurList = new HuricaneList();
        try ( BufferedReader Br = new BufferedReader(new FileReader(HuriFile))) {
//            try{
            while ((line = Br.readLine()) != null) {
                System.out.println(line);
                parts = line.split(("[\t]"));
                huricane = new Huricane(Integer.parseInt(parts[0]),
                        parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
                hurList.addHuricane(huricane);
            }
            return hurList;

//            String name = "Erin";
//            boolean end = true;
//            do{
//            try {
//                hurList.getHuricaneByName(name);
//            } catch (IllegalArgumentException e) {
//                        System.out.println(e.getMessage());
//                        end = false;
//                    }
//            } while(!end);
        }
    }

    public static void SaveToTxtFile(String nameOfFile, HuricaneList hurList) throws IOException {
        String path = System.getProperty("user.dir");
        String FileSeparator = System.getProperty("file.separator");
        String folder = "data";
        File pathFolder = new File(path, folder);
        path = pathFolder.getAbsolutePath();

        path = path + FileSeparator + nameOfFile;
        String output = "";

        try ( BufferedWriter Wr = new BufferedWriter(new FileWriter(path))) {
            for (Huricane hur : hurList) {
                output += hur.getName() + hur.getYear() + hur.getCategoryByPresure(hur.getSpeed()) + "\n";
            }
            Wr.write(output);
        }
    }
}
