package com.company.repository;

import com.company.models.User;
import com.company.utils.Archivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserRepository{
    private static UserRepository instance;
    private Archivos<User> file = new Archivos<>("users");
    private ArrayList<User> users;

    public ArrayList<User> getUsers(){ return users; }

    private UserRepository() throws IOException {
        users = getAll();
    }

    public static UserRepository getInstance() throws IOException {
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }


    public void save(User nuevoUsuario) throws IOException {
        ArrayList<User> listUsers = file.read(User.class);
        listUsers.add(nuevoUsuario);
        file.save(listUsers);
        users.add(nuevoUsuario);
    }

    public void saveAll(){
        file.save(users);
     }

    public ArrayList<User> getAll() throws IOException {
        this.users = file.read(User.class);
        return this.users;
    }


    public User getByUserName(String userName){
        User userSearch = null;
        for (User user : users)
            if(user.getUserName().equals(userName))
                userSearch = user;
        return userSearch;
    }
}
