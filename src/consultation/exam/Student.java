/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package consultation.exam;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Student implements Comparable<Student>{
    private String name;
    private String surname;
    private String id;
    private int sumPoints;
    //private ArrayList<Integer> points;

    public Student(String name, String surname, String id, int sumPoints) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.sumPoints = sumPoints;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    public int getSumPoints() {
        return sumPoints;
    }
    
    public boolean successful(int minPoints){
        return sumPoints >= minPoints;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", surname=" + surname + ", id=" + id + ", sumPoints=" + sumPoints + '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getSurname().compareTo(o.getSurname());
    }
    
    
    
}
