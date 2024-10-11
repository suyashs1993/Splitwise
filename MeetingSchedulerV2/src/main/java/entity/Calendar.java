package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {


    List<Meeting> meetingList;
    Map<String, List<Meeting>> dailyMeetingMap;


    public Calendar() {
        this.meetingList = new ArrayList<>();
        this.dailyMeetingMap = new HashMap<>();
    }

    public void addMeeting(Meeting meeting){
        meetingList.add(meeting);
        String dayString = meeting.getStartDay().getDayString();
        List<Meeting> dayMeetings = dailyMeetingMap.getOrDefault(dayString, new ArrayList<>());
        dayMeetings.add(meeting);
        dailyMeetingMap.put(dayString, dayMeetings);
    }

    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    public Map<String, List<Meeting>> getDailyMeetingMap() {
        return dailyMeetingMap;
    }

}
