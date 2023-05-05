package week05a07_competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompetitionWithArrayList {

    private String name;
    private long commonSTime = 0;
    private List<Runner> runners;
    private int currentnRunners = 0;
    
    //pretizeny konstruktor, ktery vola jiny konstruktor
    public CompetitionWithArrayList(String name, long commonSTime) {
        this(name);
        this.commonSTime = commonSTime;    
    }

    public CompetitionWithArrayList(String name) {
        this.name = name;
        runners = new ArrayList(); //vytvorit instanci
    }

    public String getName() {
        return name;
    }

    public long getCommonSTime() {
        return commonSTime;
    }

    public void addRunner(Runner r) {
        runners.add(r);
    }

    public void addRunner(String name) {
        Runner r = new Runner(name);
        addRunner(r);
    }

    public Runner getWinner() {
        long minTime = Long.MAX_VALUE;
        long runnerTime;
        Runner winner = null;
//        for (int i = 0; i < runners.size(); i++) {
//            runnerTime = runners.get(i).getRunningTime();
//            if (runnerTime < minTime) {
//                minTime = runnerTime;
//                winner = runners.get(i);
//            }
//        }
        //for each
        for (Runner r : runners) {
            runnerTime = r.getRunningTime();
            if (runnerTime < minTime) {
                minTime = runnerTime;
                winner = r;
            }
        }
        return winner;
    }

    public String startList() {
        Collections.sort(runners, new ComparatorByName()); //nova trida implementujici Comparator
        String s = "";
        for (Runner r : runners) {
            s = s + " " + r.getName() + " " + r.getsTime() + "\n";
        }
        return s;
    }

    public String startListv1() {
        Collections.sort(runners, new Comparator<Runner>() { //anonymni trida
            @Override
            public int compare(Runner o1, Runner o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        String s = "";
        for (Runner r : runners) {
            s = s + " " + r.getName() + " " + r.getsTime() + "\n";
        }
        return s;
    }

    public String startListv2() {
        Collections.sort(runners, (Runner o1, Runner o2) -> o1.getName().compareTo(o2.getName())); //lambda vyraz

        String s = "";
        for (Runner r : runners) {
            s = s + " " + r.getName() + " " + r.getsTime() + "\n";
        }
        return s;
    }

    public static Comparator<Runner> COMP_BY_NAME = new Comparator<Runner>() {
        @Override
        public int compare(Runner o1, Runner o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public String startListv3() {
        Collections.sort(runners, COMP_BY_NAME);
        String s = "";
        for (Runner r : runners) {
            s = s + " " + r.getName() + " " + r.getsTime() + "\n";
        }
        return s;
    }

    public void setFinishTimeRunner(String runnerName, long runnerFinishTime) {
        for (Runner r : runners) {
            if (r.getName().equals(runnerName)) {
                r.setfTime(runnerFinishTime);
                break;
            }
        }
    }

    public void setCommonStartTimeRunner() {
        for (Runner r : runners) {
            r.setsTime(commonSTime);
        }
    }

    public String resultsList() {
        Collections.sort(runners);
        String s = "";
        for (Runner r : runners) {
            s = s + " " + r.getName() + " " + r.getRunningTime() + "\n";
        }
        return s;
    }

    public void loadRegistrationsFromFile(String registrationFile) throws IOException {
        File registrace = new File(registrationFile);
        try ( BufferedReader br = new BufferedReader(new FileReader(registrace))) {
            String line;
            String[] parts;
            String name;
            int dob;
            Runner r;
            try{
                    while ((line = br.readLine()) != null) {
                        parts = line.split(" +");
                        name = parts[0];
                        dob = Integer.parseInt(parts[1]);
                        r = new Runner(name, dob);
                        addRunner(r);
                    }
            }catch(IllegalArgumentException e){
                throw new IllegalArgumentException("Problem je v souboru " + registrationFile + "\n " + e.getMessage()); 
            }

        }
    }

    public void loadFinishFromFile(String finishFile) throws IOException {
        File finish = new File(finishFile);
        try ( BufferedReader br = new BufferedReader(new FileReader(finish))) {
            String line;
            String[] parts;
            String name;
            long finishTime;
            while ((line = br.readLine()) != null) {
                parts = line.split("[,;]");
                name = parts[0];
                finishTime = Long.parseLong(parts[1]);
                setFinishTimeRunner(name, finishTime);
            }
        }
    }

    public void saveResultsToFile(File result) throws IOException {
        Collections.sort(runners); //compareTo je podle casu
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(result))) {
            for (Runner r : runners) {
                bw.write(r.getName() + " " + r.getRunningTime());
                bw.newLine();
            }
        }
    }

    public void saveResultToBinaryFile(File result) throws IOException {
        Collections.sort(runners);
        try ( DataOutputStream out = new DataOutputStream(new FileOutputStream(result))) {
            //int nameLength;
            for (Runner r : runners) {
//                nameLength = r.getName().length(); //pocet pismen jmena bezce
//                out.writeInt(nameLength); 
//                out.writeChars(r.getName());
////                for (int i = 0; i < nameLength; i++) {
////                    out.writeChar(r.getName().charAt(i));
////                }
                out.writeUTF(r.getName());
                out.writeLong(r.getRunningTime());
            }
        }
    }
    
 
    
    
}
