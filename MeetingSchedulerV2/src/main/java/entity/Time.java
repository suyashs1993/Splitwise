package entity;

public class Time {

    public Time(int  hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    int hour;
    int minutes;

    public boolean isGreaterThan(Time time){
        if( this.hour > time.getHour() || this.getHour() == time.getHour() && this.getMinutes() > time.getMinutes() ){
            return true;
        }
        return false;
    }

    public boolean isLesserThan(Time time){
        if( this.hour < time.getHour() || this.getHour() == time.getHour() && this.getMinutes() < time.getMinutes() ){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(hour) + ":" +String.valueOf(minutes);
    }
}
