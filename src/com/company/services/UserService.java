package com.company.services;

import com.company.models.User;
import com.company.repository.UserRepository;
import com.company.utils.Archivos;
import com.company.utils.Inputs;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserService {
    UserRepository repository;
    Inputs inputs;

    public UserService() throws IOException {
        this.repository =  new UserRepository();
        this.inputs = new Inputs();
    }

    public void addUser(User toAdd) throws IOException { repository.getAll().put(toAdd.getID(), toAdd); }

    public User getUserByID(Long id) throws IOException { return repository.getAll().get(id); }

    public void updateUser(User user, int option){
        switch (option){
            case 1:
                user.setName(inputs.inputString());
                break;
            case 2:
                user.setLastName(inputs.inputString());
                break;
            case 3:
                user.setDNI(inputs.inputString());
                break;
            case 4:
                user.setAdress(inputs.inputString());
                break;
            case 5:
                user.setPhone(inputs.inputString());
                break;
            case 6:
                user.setEmail(inputs.inputString());
                break;
            case 7:
                user.setGenre(inputs.inputString());
                break;
            case 8:
                user.setUserId(inputs.inputString());
                break;
            case 9:
                user.setPassword(inputs.inputString());
                break;
        };
    }

    public void showUserDetails(User user){
        System.out.println("\n1. ID: "+user.getID()
                +"\n2. Name: "+user.getName()
                +"\n3. Last Name: "+user.getLastName()
                +"\n4. DNI: "+user.getDNI()
                +"\n5. Adress: "+user.getAdress()
                +"\n6. Phone: "+user.getPhone()
                +"\n7. Email: "+user.getEmail()
                +"\n8. Genre: "+user.getGenre()
                +"\n9. UserID: "+user.getUserId()
                +"\n10. Password: "+user.getPassword()
        );
    }

    private void showUsersOnSearch(User user){
        for (Long key: repository.getUsers().keySet()) {
            System.out.println("\n ID: "+ repository.getUsers().get(key).getID()
                    +"\n Name: "+ repository.getUsers().get(key).getName()
                    +"\n Last Name: "+ repository.getUsers().get(key).getLastName()
                    +"\n DNI: "+ repository.getUsers().get(key).getDNI()
            );
        }
    }

    public void showUsers(){
        for (Long key: repository.getUsers().keySet())
            showUsersOnSearch(repository.getUsers().get(key));
    }
}
