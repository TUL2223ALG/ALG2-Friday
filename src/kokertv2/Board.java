/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kokertv2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jan.kokert
 */
public class Board {
    private ArrayList<Hurricane> board;
    private String name;
    
    public Board(String name) {
        this.board = new ArrayList<Hurricane>();
        this.name = name;
    }

    public ArrayList<Hurricane> getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }
    
    public void addHur(int year, String month, int pressure, int speed, String name){
        Hurricane h = new Hurricane(year, month, pressure, speed, name);
        board.add(h);
    }
    
    public void addHur(Hurricane h){
        board.add(h);
    }
    
    public String displayBoard(int from, int to){
        StringBuilder sb = new StringBuilder();
        for (Hurricane hurricane : board) {
            if (hurricane.getYear() >= from && hurricane.getYear() <= to){
               sb.append(hurricane).append("\n"); 
            }
        }
        return sb.toString();
    }
    
    public String findHurricane(String name){
        String s = "";
        for (Hurricane hurricane : board) {
            if(hurricane.getName().equals(name)){
                s = s + "Speed km/h: " + hurricane.speedToKmH() + " Category: " + hurricane.countCategory();
                return s;
            }
        }
        return s;
    }
    
    /*public int sortedBoardYear(){
        
    }*/
    
    /*public String displayBoard(){
        StringBuilder sb = new StringBuilder();
        for (Hurricane hurricane : board) {
            sb.append(hurricane).append("\n");
        }
        return sb.toString();
    }*/
    /*public String displayBoard(){
        StringBuilder sb = new StringBuilder();
        for (Hurricane hurricane : board) {
            sb.append(hurricane.getName()).append("\n");
        }
        return sb.toString();
    }*/
    
    public String loadFile(File f) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(f))){
            Hurricane temp = null;
            do{
                temp = Hurricane.loadFromFile(br);
                this.addHur(temp);
            }while(temp != null);
        }
        /*String radek = br.readLine();
        if (radek == null){
            return null;
        }
        do{
            radek = br.split("\t");
        } while(radek != null);
        return radek;*/
    }
    
}
