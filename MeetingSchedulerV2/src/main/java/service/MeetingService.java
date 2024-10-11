package service;

import entity.*;
import enums.Frequency;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class MeetingService {


    private static AtomicLong meetingCounter;
    private static MeetingService meetingServiceInstance;

    private MeetingService(){
        meetingList = new ArrayList<>();
        dailyMeetingMap = new HashMap<>();
        userMeetingMap = new HashMap<>();
        meetingCounter = new AtomicLong();
    }

    public static MeetingService getInstance(){
        if(meetingServiceInstance == null){
            meetingServiceInstance= new MeetingService();
        }
        return meetingServiceInstance;
    }
    List<Meeting> meetingList;

    Map<String , List<Meeting>> dailyMeetingMap;

    Map<String, List<Meeting>> userMeetingMap;

    public Meeting addMeeting(Room room, Day startDay, Day endDay, Time startTime, Time endTime, User createdBy, Frequency frequency,
                              List<User> participants){

        String meetingId = String.valueOf(meetingCounter.incrementAndGet());
        participants.add(createdBy);
        Meeting meeting = new Meeting(meetingId, room, startDay, endDay, startTime, endTime, createdBy, frequency,
                 participants);
        meetingList.add(meeting);

        room.getCalendar().addMeeting(meeting);

        String dayString =  startDay.getDayString();

        List<Meeting> dayMeetings = dailyMeetingMap.getOrDefault(dayString, new ArrayList<>());
        dayMeetings.add(meeting);
        dailyMeetingMap.put(dayString, dayMeetings);

        for(User user : participants){
            List<Meeting> userMeetings = userMeetingMap.getOrDefault(user.getId(), new ArrayList<>());
            userMeetings.add(meeting);
            userMeetingMap.put(user.getId(), userMeetings);
        }

        return meeting;

    }

    public List<Meeting> getMeetingsForDay(Day day){
        String dayString =   day.getDayString();
        if(dailyMeetingMap.containsKey(dayString)){
            return dailyMeetingMap.get(dayString);
        }
        return null;
    }

    public List<Meeting> getMeetingsForUser(String userId){
        if(userMeetingMap.containsKey(userId)){
            return userMeetingMap.get(userId);
        }
        return null;

    }
}
