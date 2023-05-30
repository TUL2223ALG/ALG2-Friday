package dedek;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HuricaneList {

    private List<Huricane> huricaneList;

    public HuricaneList() {
        this.huricaneList = new List<Huricane>(); //JV List je interface nejde z neho robit objekt, musi byt implementacia napr ArrayList, LinkedList ... 
    }

    public void addHuricane(Huricane huricane) {
        huricaneList.add(huricane);
    }

    public Huricane getHuricaneByName(String name) {
        for (Huricane hur : huricaneList) {
            if (hur.getName() == name) { //JV pouziva sa metoda equals pre Stringy
                return hur;
            }
        }
        throw new IllegalArgumentException("Hurikán s takovým jménem se v souboru nenachází");
    }

    @Override
    public String toString() {
        String fReturn = "";
        for (Huricane hur : huricaneList) {
            fReturn += hur.toString() + "\n";
        }
        return fReturn;
    }

    public String toStringBetweenYears(int year1, int year2) {
        String fReturn = "";
        for (Huricane hur : huricaneList) {
            if (hur.getYear() > year1 && hur.getYear() < year2) {
                fReturn += hur.toString() + "\n";
            }
        }
        return fReturn;
    }
    
     public void compareByName() {
        Collections.sort(huricaneList,  -> h1.getName.compareTo(h2.getName);
}

    public void comparedBySpeed() {
        Collections.sort(huricaneList, new Comparator<Huricane>{
    

    public int compare(Hurricane h1, Hurricane h2) {
        if (h1.getSpeed() > h2.getSpeed()) {
            return 1;
        } else if (h1.getSpeed() == h2.getSpeed()) {
            return 0;
        } else {
            return -1;
        }
    }
}
}
 
}




