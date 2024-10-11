package pojo;

import entity.Slots;

import java.util.List;

public class UserAvailabilty {

    public UserAvailabilty(boolean isAvailable, List<Slots> slotsList) {
        this.isAvailable = isAvailable;
        this.slotsList = slotsList;
    }

    boolean isAvailable;
    List<Slots> slotsList;

    public  String toString() {
        String response = "";
        if (!isAvailable) {
            response = "User is not available at given time!";
        } else {
            response = "User is available at given time!";
        }
        if (slotsList != null) {
            response = response + " The occupied time slots for user on the day are ";
            for(Slots slots : slotsList) {
               response = response + "\n";
               response = response + slots.toString();
            }
        }
        return response;
    }


}

