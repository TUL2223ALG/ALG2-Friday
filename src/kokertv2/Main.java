/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kokertv2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jan.kokert
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hurricane h1 = new Hurricane(2000, "Aug", 950, 60, "A");
        Hurricane h2 = new Hurricane(2002, "Aug", 800, 100, "B");
        Hurricane h3 = new Hurricane(2005, "Feb", 850, 154, "C");
        System.out.println(h1.getName());
        Board b1 = new Board("MyBoard");
        System.out.println(b1.getName());
        b1.addHur(h1);
        b1.addHur(h2);
        b1.addHur(h3);
        System.out.println("Hurricanes from year:");
        int from = sc.nextInt();
        System.out.println("Hurricanes to year:");
        int to = sc.nextInt();
        System.out.println(b1.displayBoard(from, to));
        System.out.println("Type in name of the hurricane to find:");
        System.out.println(b1.findHurricane("B"));
        
    }
}
