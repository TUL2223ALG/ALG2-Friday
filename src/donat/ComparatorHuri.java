/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donat;

import java.io.IOException;
import java.util.Comparator;

/**
 *
 * @author ondrej.donat
 */
public class ComparatorHuri implements Comparator<Huri> {

    @Override
    public int compare(Huri o1, Huri o2) {  
        return o1.getSpeed();
    }
    
      
}
