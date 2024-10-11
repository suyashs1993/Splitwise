package entity;

import enums.Frequency;
import enums.MeetingStatus;

import java.util.List;

public class Meeting {

    private final String meetingId;

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    private  Time startTime;
    private  Time endTime;

    private MeetingStatus meetingStatus;

    public Meeting(String meetingId, Room room, Day startDay, Day endDay, Time startTime, Time endTime, User createdBy, Frequency frequency,
                   List<User> participants) {
        this.meetingId = meetingId;
        this.room = room;
        this.startDay = startDay;
        this.endDay = endDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdBy = createdBy;
        this.frequency = frequency;
        this.participants = participants;
        this.meetingStatus = MeetingStatus.ACTIVE;
    }

    private final Room room;
    private  Day startDay;
    private  Day endDay;
    private final User createdBy;
    private final Frequency frequency;
    private List<User> participants;

    public String getMeetingId() {
        return meetingId;
    }

    public Room getRoom() {
        return room;
    }

    public Day getStartDay() {
        return startDay;
    }

    public Day getEndDay() {
        return endDay;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void notifyUser(){
        for(User participant : participants){
            participant.sendNotification(this);
        }
    }


}
