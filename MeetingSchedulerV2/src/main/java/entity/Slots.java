package entity;

public class Slots {

    Time startTime;
    Time endTime;

    public Slots(Time startTime, Time endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public String toString(){
        return startTime.toString() + " - " + endTime.toString();
    }
}
