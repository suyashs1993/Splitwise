package service;

import entity.*;
import exception.NoRoomAvailableException;
import strategy.RoomAssignmentStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class RoomService {


    List<Room> roomList;

    private static RoomService roomServiceInstance;

    private static AtomicLong roomCounter;

    private RoomService(){
       roomList = new ArrayList<>();
       roomCounter = new AtomicLong();
    }

    public static RoomService getInstance(){
        if(roomServiceInstance == null){
            roomServiceInstance = new RoomService();
        }
        return roomServiceInstance;
    }

    public Room addRoom(Integer capacity, Integer floor, Integer roomNo){
        String roomId = String.valueOf(roomCounter.incrementAndGet());
        Room room = new Room(roomId, capacity, floor, roomNo);
        roomList.add(room);
        System.out.println(" Room added with id "+room.getId());
        return room;
    }


    public Room getAvailableRoom(Day day , Time startTime, Time endTime, Integer numOfParticipants, RoomAssignmentStrategy roomAssignmentStrategy)
    throws NoRoomAvailableException{
        List<Room> availableRooms = getAvailableRoomsForMeeting(day, startTime, endTime, numOfParticipants);
        if(availableRooms.isEmpty()){
            throw  new NoRoomAvailableException("No room available at this time");
        }
        Room room = roomAssignmentStrategy.assignRoom(availableRooms);
        System.out.println("Room you can book meeting is" + room.getRoomNo());
        return room;
    }

    public  List<Room> getAvailableRoomsForMeeting(Day day , Time startTime, Time endTime, Integer numOfParticipants){
        List<Room> availableRooms = new ArrayList<>();
        String dayString = day.getDayString();
        for(Room room : roomList){
            Calendar roomCalendar = room.getCalendar();
            if(room.getCapacity() < numOfParticipants) continue;
            boolean isAvailable = true;
            Map<String, List<Meeting>> dailyMeetingMap = roomCalendar.getDailyMeetingMap();
            List<Meeting> meetings = dailyMeetingMap.getOrDefault(dayString, new ArrayList<>());
            for(Meeting meeting : meetings){
                if( meeting.getStartTime().isGreaterThan(endTime)  || meeting.getEndTime().isLesserThan(startTime)){
                    continue;
                }else{
                    isAvailable = false;
                    break;
                }
            }
            if(isAvailable){
                availableRooms.add(room);
            }
        }
        System.out.println(" Available rooms for given time are ");
        availableRooms.forEach(s->System.out.println(s.getId()));
        return availableRooms;

    }
}
