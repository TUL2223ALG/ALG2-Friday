/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package siddall;

import java.util.Comparator;

/**
 *
 * @author ul
 */
public class ComparatorByName implements Comparator<Hurricane> {

    @Override
    public int compare(Hurricane o1, Hurricane o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
