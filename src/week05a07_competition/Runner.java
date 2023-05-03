package week05a07_competition;

public class Runner implements Comparable<Runner> {
    private String name;
    private int dob = 2000;
    //private int fHours;
    //private int fMinutes;
    private long sTime = 0;
    private long fTime = 0; //pocet v sekundach
    private long runningTime = 0;

    public Runner(String name) {
        this.name = checkName(name);
    }
    
    public Runner(String name, int dob) {
        this.name = checkName(name);
        this.dob = dob;
    }
    
    private String checkName(String name){
        if(!(name.matches("[A-Z][a-z]*"))){
            throw new IllegalArgumentException(name + " nesplnuje, ze prvni pismeno je velke a pak muzou byt mala pismena");
        }
        return name;
    }

    public Runner(String name, int dob, long sTime) {
        this(name, dob);
        this.sTime = sTime;
    }
    
    public String getName() {
        return name;
    }

    public long getfTime() {
        return fTime;
    }

    public long getsTime() {
        return sTime;
    }

    public long getRunningTime() {
        return runningTime;
    }

    public void setsTime(long sTime) {
        this.sTime = sTime;
    }

    public void setfTime(long fTime) {
        this.fTime = fTime;
        this.runningTime = runningTime();
    }
    
    private long runningTime(){
        return fTime - sTime;
    }

    @Override
    public String toString() {
        return "Runner{" + "name=" + name + ", sTime=" + sTime + ", fTime=" + fTime + ", runningTime=" + runningTime + '}';
    }

    @Override
    public int compareTo(Runner o) {
     return (int)(this.runningTime - o.runningTime);
//     if(this.getRunningTime() > o.getRunningTime()){
//         return 1;
//     }else if (this.getRunningTime() > o.getRunningTime()){
//         return -1;
//     }
//     return 0;
    }
}