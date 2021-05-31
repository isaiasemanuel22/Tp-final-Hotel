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
    private Archivos file;

    public UserRepository() {
        this.file = this.file = new Archivos("Users");
    }

    public HashMap<Long, User> getAll() throws IOException {
        HashMap<Long, User> usersMap = new HashMap<>();
        File file = new File(this.file.getUrl());
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<User> usersList = this.file.read(User.class);
            for (User aux: usersList) {
                usersMap.put(aux.getID(), aux);
            }
        }
        return usersMap;
    }
}
