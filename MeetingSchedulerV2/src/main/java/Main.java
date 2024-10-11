import entity.Day;
import entity.Room;
import entity.Time;
import entity.User;
import enums.Frequency;
import service.MeetingScheduler;
import service.RoomService;
import service.UserService;
import strategy.DefaultRoomAssignmentStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main{

    static MeetingScheduler meetingScheduler;
    static RoomService roomService;
    static UserService userService;

    public static void initialize(){
        meetingScheduler = MeetingScheduler.getInstance();
        userService = UserService.getInstance();
        roomService = RoomService.getInstance();
    }

    public static void main(String[] args) throws Exception{
      initialize();
      User suyash = userService.addUser("Suyash", "s@gmail.com", "9XXXXXXXX");
      User a = userService.addUser("A", "a@gmail.com", "87XXXXXXX");
      User b = userService.addUser("B", "b@gmail.com", "77XXXXXXX");
      User c = userService.addUser("C", "c@gmail.com", "67XXXXXXX");
      Room one = roomService.addRoom(5,2,1);
      Room two =roomService.addRoom(2,2,2);
      Room three =roomService.addRoom(5,2,3);
      List<User> participants = new ArrayList<>();
      participants.add(a);
      participants.add(b);

      meetingScheduler.setMeeting(one, new Day(2024,10,11), null, new Time(15,30),
              new Time(16,0), suyash, Frequency.ONCE, participants);

      userService.getUserAvailability("2", new Day(2024,10,11),
              new Time(15,30), new Time(16,00) );

      Room room = roomService.getAvailableRoom(new Day(2024,10,11), new Time(15,45), new Time(16,30),
              3, new DefaultRoomAssignmentStrategy());


    }


}
