package com.company.repository;

import com.company.models.User;
import com.company.utils.Archivos;

import java.util.ArrayList;
import java.util.HashMap;

public class UserRepository{

    private Archivos<User> file ;
    private HashMap<Long, User> users;

    public UserRepository() {
        this.file = new Archivos<>("Users");
        this.users = getAll();
    }

    public HashMap<Long, User> getUsers(){ return users; }

    public HashMap<Long, User> getAll(){

        HashMap<Long, User> usersMap = new HashMap<>();
        ArrayList<User> usersList = this.file.read(User.class);

        for (User aux: usersList){
            usersMap.put(aux.getUserId(), aux);
        }

        return usersMap;
    }

    public void saveAll(){
        ArrayList<User> userList = new ArrayList<>();
        for (Long id: users.keySet()) {
            userList.add(users.get(id));
        }
        file.save(userList);
    }

    public User getByUserName(String userName){
        return users.get(new User(userName));
    }


    public void register(User user) {
        file.save(user);
    }
}
