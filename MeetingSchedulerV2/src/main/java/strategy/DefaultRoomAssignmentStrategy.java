package strategy;

import entity.Room;

import java.util.List;

public class DefaultRoomAssignmentStrategy implements RoomAssignmentStrategy{
    @Override
    public Room assignRoom(List<Room> roomList) {
        return roomList.stream().findFirst().get();
    }
}
