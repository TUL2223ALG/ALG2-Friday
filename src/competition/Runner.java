
package competition;

/**
 *
 * @author 
 */
public class Runner {
    private String name;
    //private int fHours;
    //private int fMinutes;
    private long sTime = 0;
    private long fTime = 0; //pocet sekundach
    private long runningTime = 0;

    public Runner(String name) {
        this.name = name;
    }

    public Runner(String name, long sTime) {
        this.name = name;
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
}