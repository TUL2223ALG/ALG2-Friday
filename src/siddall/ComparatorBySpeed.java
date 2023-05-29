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
public class ComparatorBySpeed implements Comparator<Hurricane> {

//chtěl jsem ukázat, že to lze i tímto způsobem implementovat komparátor, ale jinak bych to dělal normálně viz ComparatorByName.java
    @Override
    public int compare(Hurricane o1, Hurricane o2) {
        if (o1.getSpeedKnot() > o2.getSpeedKnot()) {
            return 1;
        } else if (o1.getSpeedKnot() == o2.getSpeedKnot()) {
            return 0;
        } else {
            return -1;
        }
    }

}
