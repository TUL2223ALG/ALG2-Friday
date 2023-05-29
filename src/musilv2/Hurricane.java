package musilv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Hurricane {
        static Scanner sc = new Scanner(System.in);
        
        //data
        static int year;
        static int pressure;
        static int knots;
        //double kmh = 0;
        static String name;
        static String month;
        static Hurricane[] hrs;
        static int currentHurricanes = 0;

        //Constructor
        public Hurricane(int year, String month, int pressure, int knots, String name) {
            this.year = year;
            this.month = month;
            this.pressure = pressure;
            this.knots = knots;
            this.name = name;
            //this.kmh = knots*1.852;
        }
        
        //Getters
        public int getYEAR() {
            return this.year;
        }
        
        public int getPRESSURE() {
            return this.pressure;
        }
        
        public int getKNOTS() {
            return this.knots;
        }
        
        public String getNAME() {
            return this.name;
        }
        
        public String getMONTH() {
            return this.month;
        }
        
        public int getLATEST_YEAR() {
            int latestYear = 0;
            int currentYear;
            for(Hurricane r : hrs) {
                currentYear = r.getYEAR();
                if (currentYear > latestYear) {
                    latestYear = r.getYEAR();
                }
            }
            return latestYear;
        }
        
        public int getEARLIEST_YEAR() {
            int earliestYear = 0;
            int currentYear;
            for(Hurricane r : hrs) {
                currentYear = r.getYEAR();
                if (currentYear < earliestYear) {
                    earliestYear = r.getYEAR();
                }
            }
            return earliestYear;
        }
        
        @Override
        public String toString() {
            String s = (this.getYEAR() + " " + this.getMONTH() + " " + this.getPRESSURE() + " " + this.getKNOTS() + " " + this.getNAME() + "\n");
            return s;
        }
        
        //Coverts the speed in knots to speed in km/h
        public double knotsToKm(int knots) {
            return (knots*1.852);
        }
        
        
        //Determines the hurricane category based on speed in km/h
        public int hurricaneCategory() {
           double speed = knotsToKm(this.knots); 
            if (speed < 119) {
                return 0;
            } else if(speed < 177) {
                return 1;
            } else if (speed < 208) {
                return 2;
            } else if (speed < 251) {
                return 4;
            } else{
                return 5;
            }
                }
        
        public static void addHurricane(Hurricane r) {
            hrs[currentHurricanes] = r;
            currentHurricanes++;
        }
        
        //Creates an array of hurricanes from text files
        public static void loadHurricanesFromFile(File file) {
        try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        int year;
        String month;
        int pressure;
        int knots;
        String name;
        String data;
        String[] parts;
        //Vložit pole semka
        while ((data = br.readLine()) != null) {
            //Tu musí být line split, pak se k tomu vrátím 
            parts = data.split("[\t]+"); //Dejme tomu že by tohle fungovalo, teďka netuším jak to má být konkrétně správně
            year = Integer.parseInt(parts[0]); //Nutno přeparsovat
            pressure =  Integer.parseInt(parts[2]);
            knots = Integer.parseInt(parts[3]);
            name = parts[4];
            month = parts[1];
            Hurricane hr = new Hurricane(year, month, pressure, knots, name);
            addHurricane(hr);
        }
        br.close();
        } catch(IOException e) {
            System.out.println("Problém se souborem" + e.getMessage());
        }
        }
        
        //Prints all the information about all the hurricanes int the year of yearX to yearY
        public static void xToY() {
            int yearX = 0;
            int yearY = 0;
            while (true) {
            System.out.println("Zadejte prosím počáteční rok období");
            yearX = sc.nextInt();
            System.out.println("zadejte prosím konečný rok období");
            yearY = sc.nextInt();
                if(yearX < yearY) {
                    System.out.println("Neplatné období");
                } else {
                    break;
                }
            }
            for (Hurricane r : hrs) {
                int actualYear = r.getYEAR(); 
                if ((actualYear <= yearY) && (actualYear >= yearX)) {
                    System.out.println(r.toString());
                }
            }
        }
        
        //Gets the category and speed (in km/h) of the chosen hurricane (by name)
        public static void infoByName() {
            System.out.println("zadejte prosím jméno daného hurikánu");
            String hName = "";
            String currentHName;
            int end = 0;
            while (true) {
                hName = sc.next();
                for (Hurricane r : hrs) {
                    currentHName = r.getNAME();
                    if (currentHName.equalsIgnoreCase(hName)) {
                        System.out.println(r.hurricaneCategory() + r.knotsToKm(knots));
                        end = 1;
                        break;
                    }
                }
                if (end == 1) {
                    break;
                } else {
                    System.out.println("Bylo zadáno neplatné jméno hurikánu");
                }
            }
        }
        
        public static void sortbySpeed() {
            //Zde třídění, popřemýšlím později
        }
        
        public static Hurricane[] sortbyName() {
            //Budu se tvářit, že umím třídit dle jména (Obecně že umím třídit dle čehokoliv)
            Hurricane[] sortedHrs = null; //Budu se tvářit, že je to pole setříděných hurikánl dle jména
            return sortedHrs;
        }
        
        //Writes the desired information (name, year and category) into a .txt file
        public static void writeToTxt() {
            File file = new File("data" + ((String)System.getProperty("file.separator")) + "HurricanesSorted.txt");
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                Hurricane[] sorted = this.sortByName(); //Později si zjistím jak to sem šoupnout
                for (Hurricane r : sorted) {
                    bw.write(r.getNAME() + " " + r.getYEAR() + " " + r.hurricaneCategory() + "\n");
                }
                bw.close();
            }catch (IOException e){
                System.out.println("Problém se zápisem" + e.getMessage());
            }
        }
        
        //Writes the desired information (amount of hurricanes each year) into a binary file
        public static void writeToBin() {
            File file = new File("data" + ((String)System.getProperty("file.separator")) + "HurricanesAmount.bin");
            try {
                DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
                int hurricanesPerYear;
                int earliestYear = this.getEARLIEST_YEAR();//Později si zjistím jak to sem šoupnout
                int latestYear = this.getLATEST_YEAR();//Později si zjistím jak to sem šoupnout
                for(int i = latestYear; i <= latestYear; i++) {
                    hurricanesPerYear = 0;
                    for(Hurricane r : hrs) {
                        if (r.getYEAR() == i) {
                            hurricanesPerYear++;
                        }
                    }
                    out.writeInt(i);
                    out.writeBytes(" ");
                    out.writeInt(hurricanesPerYear);
                    out.writeBytes("\n");
                }
                out.close();
            } catch(IOException e) {
                System.out.println("Problém se zápisem" + e.getMessage());
            }
        }
        
        
        
        
}


       
