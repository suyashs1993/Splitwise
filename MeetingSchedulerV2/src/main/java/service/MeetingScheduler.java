package service;

import entity.*;
import enums.Frequency;
import pojo.UserAvailabilty;

import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {


    private static MeetingScheduler meetingSchedulerInstance;

    private MeetingService meetingService;


    private MeetingScheduler(){
        meetingService = MeetingService.getInstance();
    }

    public static MeetingScheduler getInstance(){
        if(meetingSchedulerInstance == null){
            meetingSchedulerInstance = new MeetingScheduler();
        }
        return meetingSchedulerInstance;
    }


    public void setMeeting(Room room, Day startDay, Day endDay, Time startTime, Time endTime, User createdBy, Frequency frequency,
                           List<User> participants){

       Meeting meeting = meetingService.addMeeting(room, startDay, endDay, startTime, endTime, createdBy, frequency,
                participants);

       meeting.notifyUser();
    }



}
