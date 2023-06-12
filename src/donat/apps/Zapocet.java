/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donat.apps;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author ondrej.donat
 */
//JV reprezentuje vic studenta
public class Zapocet implements Comparator { //JV zde nevhodne pouziti Comparatora
    private String name;
    private String surname;
    private String personalNumber;
    private ArrayList<String> result; //JV body jsou Integer
    public Zapocet(String name,String surname,String personalNumber,ArrayList<String> result){
        this.name = name;
        this.personalNumber = personalNumber;
        this.result = result;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public ArrayList<String> getResult() {
        return result;
    }
    public boolean getFinalResult(){
        int i = 0;
        int num = 0;
        boolean finalResult = false;
        while(i<result.size()){
            if(!result.get(i).equals("-")){
                num += Integer.parseInt(result.get(i));
            } 
        } if(num>=50){
            finalResult = true;
        }
        return finalResult; 
    }
    
        
      
    
    @Override
    public String toString() {
        return "name=" + name + ", surname=" + surname + ", personalNumber=" + personalNumber + ", result=" + result;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Zapocet k1 = (Zapocet) o1;
        Zapocet k2 = (Zapocet) o2;
        return k1.getSurname().compareTo(k2.getSurname());
    }
    
}
