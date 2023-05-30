package nyc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ul
 */
public class Tools {
    //JV mohla to byt trida s atributem List<Hurricane> a nestatickymi metodami, ktere by toto pole nepotrebovali jako vstupni parametr
    public static List<Hurricane> loadHurricanesFromFile(String path) throws IOException {
        List<Hurricane> loadedHuri = new ArrayList();
        File source = new File(path);
        String line;
        String[] parts;
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            while ((line = br.readLine()) != null) {
                parts = line.split("\t");
                loadedHuri.add(new Hurricane(Integer.parseInt(parts[0]), parts[1],
                        Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                        parts[4]));
            }
        }
        return loadedHuri;
    }

    public static List<Hurricane> fromPeriod(List<Hurricane> fullList, int start, int finish) {
        List<Hurricane> period = new ArrayList();
        Collections.sort(fullList, new ComparatorByYear());
        for (Hurricane h : fullList) {
            if (h.getYear() >= start && h.getYear() <= finish) {
                period.add(h);
            }
        }
        return period;
    }

    public static List<Hurricane> findHurricaneByName(String name, List<Hurricane> allHurricanes) {
        List<Hurricane> foundHurricanes = new ArrayList();
        for (Hurricane h : allHurricanes) {
            if (name.equals(h.getName())) {
                foundHurricanes.add(h);
            }
        }
        return foundHurricanes;
    }

    public static void saveHurricanesDataToFile(String path, List<Hurricane> allHurricanes) throws IOException {
        File data = new File(path);
        Collections.sort(allHurricanes, new ComparatorByName());
        String text;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(data))) {
            for (Hurricane h : allHurricanes) {
                text = h.getName() + " " + h.getYear() + " ";
                try {
                    text = text + Category.getCategory(h).getDescription();
                } catch (IllegalArgumentException e) {
                    text = text + e.getMessage(); //JV promenna, ktera po ukonceni metody zmizí, stati se jeji obsah
                }
                bw.write(text);
                bw.newLine();
            }
        }
    }

    private static int[][] getNumberOfHurricanesInYear(List<Hurricane> allHurricanes) {
        Collections.sort(allHurricanes, new ComparatorByYear()); //JV pri pocitani se dalo vyuzit setridenosti podle roku
        List<Integer> years = new ArrayList();
        int[][] data;
        for (Hurricane h : allHurricanes) {
            if (!years.contains(h.getYear())) {
                years.add(h.getYear());
            }
        }
        data = new int[years.size()][2];
        int[] count = new int[years.size()];
        for (Hurricane h : allHurricanes) {
            count[years.indexOf(h.getYear())]++;
        }
        int index = 0;
        for (Integer i : years) {
            data[index][0] = i;
            data[index][1] = count[years.indexOf(i)];
            index++;
        }
        return data;
    }

    public static void saveHurricanesDataToBinFile(String path, List<Hurricane> allHurricanes) throws IOException {
        File data = new File(path);
        int[][] years = getNumberOfHurricanesInYear(allHurricanes);
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(data))) {
            for (int i = 0; i < years.length; i++) {
                for (int j = 0; j < years[i].length; j++) {
                    out.writeInt(years[i][j]); //JV zapsat rok a pocet
                }
            }
        }
    }

}
