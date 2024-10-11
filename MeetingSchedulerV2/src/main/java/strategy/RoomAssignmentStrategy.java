package strategy;

import entity.Room;

import java.util.List;

public interface RoomAssignmentStrategy {

    public Room assignRoom(List<Room> roomList);
}
