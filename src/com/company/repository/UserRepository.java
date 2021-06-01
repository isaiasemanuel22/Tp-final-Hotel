package com.company.repository;

import com.company.models.User;
import com.company.models.UserProfile;
import com.company.utils.Archivos;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserRepository{
    private Archivos<User> file = new Archivos<>("Users");
    private HashMap<Long, User> users;

    public HashMap<Long, User>getUsers(){ return users; }

    public UserRepository() throws IOException {
        this.users = getAll();
    }

    public HashMap<Long, User> getAll() throws IOException {
        HashMap<Long, User> usersMap = new HashMap<>();
        ArrayList<User> usersList = this.file.read(User.class);
        for (User aux: usersList)
            usersMap.put(aux.getID(), aux);
        return usersMap;
    }

    public void saveAll(HashMap<Long, User> users){
        ArrayList<User> userList = new ArrayList<>();
        for (Long id: users.keySet()) {
            userList.add(users.get(id));
        }
        file.save(userList);
    }
}
