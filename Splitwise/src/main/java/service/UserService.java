package service;

import entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    Map<String, User> nameUserMap;

    public UserService(){
        nameUserMap = new HashMap<>();
    }

    public void addUser(User user){

        nameUserMap.put(user.getName(), user);
    }

}
