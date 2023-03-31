package competition;

public class Competition {

    private String name;
    private long commonSTime = 0;
    Runner[] runners;
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
        String s = "";
        for (Runner r : runners) {
            s = s + " " + r.getName() + " " + r.getsTime();
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

}
