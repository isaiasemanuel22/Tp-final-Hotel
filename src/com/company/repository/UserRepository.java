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
    private HashMap<Long, User> users;

    public HashMap<Long, User>getUsers(){ return users; }

    private UserRepository() throws IOException {
        users = getAll();
    }

    public static UserRepository getInstance() throws IOException {
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    public void save(User nuevoUsuario){
        ArrayList<User> listUsers = getUserArray();
        listUsers.add(nuevoUsuario);
        file.save(listUsers);
        users.put(nuevoUsuario.getID(), nuevoUsuario);
    }


    public HashMap<Long, User> getAll() throws IOException {
        HashMap<Long, User> usersMap = new HashMap<>();
        ArrayList<User> usersList = this.file.read(User.class);
        for (User aux: usersList)
            usersMap.put(aux.getID(), aux);
        return usersMap;
    }

    public ArrayList<User> getUserArray(){
        ArrayList<User> userList = new ArrayList<>();
        for (Long id: users.keySet()) {
            userList.add(users.get(id));
        }
        return userList;
    }

    public User getUser(String userId){
        User userSearch = null;
        for (Map.Entry<Long, User> user : users.entrySet()) {
            if(user.getValue().getUserId().equals(userId)){
                userSearch = user.getValue();
            }
        }
        return userSearch;
    }

    public User getByUserName(String userName){
        return users.get(new User(userName));
    }
}
