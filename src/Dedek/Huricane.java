package Dedek;

public class Huricane {

    private long year;
    private String month;
    private int presure;
    private int speed;
    private String name;
    private String[] months = {"January", "February", "March", "April", "Mai", "June",
        "Jule", "August", "September", "October", "November", "December"};

    public Huricane(long Year, String month, int Presure, int speed, String name) {
        this.year = Year;
        setMonth(month);
        this.presure = Presure;
        this.speed = speed;
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public long getYear() {
        return year;
    }

    public int getPresure() {
        return presure;
    }

    public int getSpeed() {
        return speed;
    }
    
    public String getSpeedKmh(){
        return (speed + " km/h"); //JV chyba prepocet uzlov na km/h
    }

    public String getName() {
        return name;
    }

    public void setYear(long Year) {
        this.year = Year;
    }

    public void setMonth(String month) { //JV lepsie urobit napr. cez enum
        for (int i = 0; i < months.length; i++) {
            if (month.equals("" + months[i].charAt(0) + months[i].charAt(1) + months[i].charAt(2))) {
                this.month = months[i];
            }

        }
    }

    public void setPresure(int Presure) {
        this.presure = Presure;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return(getYear() + " " + getMonth() + " " + getPresure() + " " + getSpeed() + " " + getName());
    }
    
    public int getCategoryBySpeed(int speed){
        if(speed>=72 & speed<=95){
            return 1;
        } else if(speed>=96 & speed<=110){
            return 2;
        } else if(speed>=111 & speed<=129){
            return 3;
        } else if(speed>=130 & speed<=156){
            return 4;
        } else if(speed>=175){
            return 5;
        } else {
            return 0;
        }
        }
        public int getCategoryByPresure(int presure){ //JV toto bola speed
        if(presure>=119 & presure<=153){
            return 1;
        } else if(presure>=154 & presure<=177){
            return 2;
        } else if(presure>=178 & presure<=208){
            return 3;
        } else if(presure>=209 & presure<=251){
            return 4;
        } else if(presure>=252){
            return 5;
        } else{
            return 0;
        }
        }
    }


