package week05a07_competition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Competition {

    private String name;
    private long commonSTime = 0;
    private Runner[] runners;
    private int currentnRunners = 0;

    public Competition(String name, long commonSTime, int nRunners) {
        this.name = name;
        this.commonSTime = commonSTime;
        runners = new Runner[nRunners];
    }

    public Competition(String name, int nRunners) {
        this.name = name;
        runners = new Runner[nRunners];
    }

    public String getName() {
        return name;
    }

    public long getCommonSTime() {
        return commonSTime;
    }

    public void addRunner(Runner r) {
        runners[currentnRunners] = r;
        currentnRunners++;
    }

    public void addRunner(String name) {
        Runner r = new Runner(name);
        addRunner(r);
    }

    public Runner getWinner() {
        long minTime = Long.MAX_VALUE;
        long runnerTime;
        Runner winner = null;
        for (int i = 0; i < runners.length; i++) {
            runnerTime = runners[i].getRunningTime();
            if (runnerTime < minTime) {
                minTime = runnerTime;
                winner = runners[i];
            }
        }
        return winner;
    }

    public String startList() {
        Arrays.sort(runners, new ComparatorByName());
        String s = "";
        for (Runner r : runners) {
            s = s + " " + r.getName() + " " + r.getsTime() + "\n";
        }
        return s;
    }

    public String startListv1() {
        Arrays.sort(runners, new Comparator<Runner>() {
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
        Arrays.sort(runners, (Runner o1, Runner o2) -> o1.getName().compareTo(o2.getName()));
        
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
        Arrays.sort(runners,COMP_BY_NAME);
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
        Arrays.sort(runners);
        String s = "";
        for (Runner r : runners) {
            s = s + " " + r.getName() + " " + r.getRunningTime() + "\n";
        }
        return s;
    }
    
    public void loadRegistrationsFromFile(String registrationFile) throws IOException{
        File registrace = new File(registrationFile);
        try (BufferedReader br = new BufferedReader(new FileReader(registrace))){
            String line;
            String[] parts;
            String name;
            int dob;
            Runner r;
            while ((line = br.readLine()) != null){
                parts =  line.split(" +");
                name = parts[0];
                dob = Integer.parseInt(parts[1]);
                r = new Runner(name, dob);
                addRunner(r);
            }
        }
    }
}
