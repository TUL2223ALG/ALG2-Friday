/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package consultation.exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 
 */
public class Exam {
    private ArrayList<Student> students;
    private String subject = "";
    private LocalDate date = LocalDate.now();
    private File examFile;
    private int minPoints;

    public Exam(File examFile, int minPoints) {
        this.students = new ArrayList();
        this.minPoints = minPoints;
        this.examFile = examFile;
        setExamInfo();
    }
    
    private void setExamInfo(){
       String examFileName = examFile.getName();
       String[] parts = examFileName.split("-");
       String subject = parts[0];
       String date = parts[2];
       int year = Integer.parseInt(date.substring(4, 8));
       int month = Integer.parseInt(date.substring(2, 4));
       int day = Integer.parseInt(date.substring(0, 2));
       LocalDate dateObject = LocalDate.of(year, month, day);
       this.subject = subject;
       this.date = dateObject;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public void loadData() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader (examFile))){
            try{
                br.readLine(); //nacteni/preskoceni hlavicky
            }catch(NullPointerException e){
                throw new IOException("Uplne prazdny soubor");
            }
            String line, name, surname, id;
            Student s;
            String[] parts;
            int sumPoints;
            while((line = br.readLine()) != null){
                parts = line.split(",");
                name = parts[0];
                surname = parts[1];
                id = parts[2];
                sumPoints = 0;
                for(int i = 3; i < parts.length-1; i++){
                    if(!parts[i].equals("-")){
                        sumPoints += Integer.parseInt(parts[i]);
                    }
                }
                s = new Student(name, surname, id, sumPoints);
                students.add(s);
            }
            
        }
    }
    
    public String format(ArrayList<Student> stud){
        StringBuilder sb = new StringBuilder();
        for (Student student : stud) {
            sb.append(String.format("%20s %30s %10d %3s",
                     student.getId(),
                     student.getName() + " " + student.getSurname(),
                     student.getSumPoints(),
                    (student.successful(minPoints))? "ano":"ne"))
               .append("\n");
        }
        return sb.toString();
    }
    
    public String displayAllStudents(){
        return format(students);
    }
    
    public String displaySuccessfulStudents(){
        ArrayList<Student> successfulStudents = new ArrayList();
        for (Student student : students) {
            if(student.successful(minPoints)){
                successfulStudents.add(student);
            }
        }
        Collections.sort(successfulStudents);
        return format(successfulStudents);
    }
     
    
    
    
    
    
    
    
   
}
