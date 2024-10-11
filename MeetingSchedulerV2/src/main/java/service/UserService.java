package service;

import entity.*;
import pojo.UserAvailabilty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class UserService {



    List<User> userList;

    private static UserService userServiceInstance;

    private MeetingService meetingService;

    private static AtomicLong userCounter;

    private UserService(){
        userList = new ArrayList<>();
        userCounter = new AtomicLong();
        meetingService = MeetingService.getInstance();
    }

    public static UserService getInstance(){
        if(userServiceInstance == null){
            userServiceInstance = new UserService();
        }
        return userServiceInstance;
    }

    public User addUser(String name, String email, String mobileNo){
        String userId = String.valueOf(userCounter.incrementAndGet());
        User user = new User(userId, name, email, mobileNo);
        userList.add(user);
        System.out.println(" User added with id "+user.getId());
        return user;
    }


    public UserAvailabilty getUserAvailability(String userId, Day day , Time startTime, Time endTime){
        List<Slots> slotList = new ArrayList<>();
        List<Meeting> userMeetings = meetingService.getMeetingsForUser(userId);
        boolean isAvailable = true;
        if(userMeetings == null){
            UserAvailabilty userAvailability = new UserAvailabilty(true, null);
            System.out.println(userAvailability);
            return userAvailability;
        }

        for(Meeting meeting : userMeetings){
            Slots slots = new Slots(meeting.getStartTime(), meeting.getEndTime());
            slotList.add(slots);
            if( meeting.getStartTime().isGreaterThan(endTime)  || meeting.getEndTime().isLesserThan(startTime)){
                continue;
            }else{
                isAvailable = false;
            }
        }
        UserAvailabilty userAvailability =  new UserAvailabilty(isAvailable, slotList);
        System.out.println(userAvailability.toString());
        return userAvailability;
    }

}
