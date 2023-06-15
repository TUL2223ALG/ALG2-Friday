/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package consultation.ui;

import consultation.exam.Exam;
import java.awt.FileDialog;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author jana.vitvarova
 * data\ALG1-ulohy-01022023.csv
 */
public class ExamApp {

    public static Scanner sc = new Scanner(System.in);
    public static Exam todayExam;
    
    public static void main(String[] args) {
        boolean end = false;
        int choice;
        
        while (!end) {
            displayMenu();
            System.out.println("Zadej volbu:");
            choice = sc.nextInt();
            switch (choice) {
                case 1: 
                    try{
                        loadFile();
                        System.out.println("Soubor se povedlo nacist");
                        break;
                    }catch(IOException e){
                        System.out.println("Problem se souborem");
                        System.out.println(e.getMessage());
                    }
                case 2: examPreview();break;
                case 3: studentExamPreview();break;
                case 4: save();break;
                case 0: end = true;break;
                default: System.out.println("Neplatna volba");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. nacteni souboru");
        System.out.println("2. prehled zapoctu");
        System.out.println("3. prehled zapoctu studenta");
        System.out.println("4. ulozeni dat");
        System.out.println("0. konec");
    }

    private static void loadFile() throws IOException {
        System.out.println("Zadaj min pocet bodu na zapocet");
        int minPoints = sc.nextInt();
        System.out.println("Zadej cestu k souboru");
        String examPath = sc.next();
        File examFile = new File(examPath);
        todayExam = new Exam(examFile, minPoints);
        //System.out.println(todayExam.getSubject());
        todayExam.loadData();
        //System.out.println(todayExam.displayStudents());
    }

    private static void examPreview() {
        System.out.println(todayExam.displaySuccessfulStudents());
    }

    private static void studentExamPreview() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void save() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
    
    
    

}
