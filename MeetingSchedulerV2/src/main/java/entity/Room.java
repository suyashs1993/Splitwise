package entity;

public class Room {
    private final String id;
    private final Integer capacity;

    public String getId() {
        return id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getFloor() {
        return floor;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    private final Integer floor;

    private final Integer roomNo;

    private Calendar calendar;

    public Room(String id, Integer capacity, Integer floor, Integer roomNo) {
        this.id = id;
        this.capacity = capacity;
        this.floor = floor;
        this.roomNo = roomNo;
        this.calendar = new Calendar();
    }



}
