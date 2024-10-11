package entity;

public class User{

    private final String id;
    private final String name;
    private final String email;
    private final String mobileNo;



    public User(String id, String name, String email, String mobileNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void sendNotification(Meeting meeting){
        System.out.println("Notification received for user" + name + " for meeting "+meeting.getMeetingId() + " in room "+
        meeting.getRoom().getRoomNo() + " on day " + meeting.getStartDay().getDayString() + " at time "+ meeting.getStartTime());
    }
    
}
