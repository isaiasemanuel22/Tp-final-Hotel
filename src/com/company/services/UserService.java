package com.company.services;

import com.company.models.User;
import com.company.repository.UserRepository;
import com.company.utils.Inputs;

import java.io.IOException;

public class UserService {

    UserRepository repository;
    Inputs inputs;

    public UserService() throws IOException {
        this.repository =  UserRepository.getInstance();
        this.inputs = new Inputs();
    }

    public void addUser(User toAdd) throws IOException {
        repository.save(toAdd);
    }

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
        System.out.println("\n ID: "+ user.getID()
                +"\n Name: "+ user.getName()
                +"\n Last Name: "+ user.getLastName()
                +"\n DNI: "+ user.getDNI()
        );
    }

    public void showUsers(){
        for (Long key: repository.getUsers().keySet())
            showUsersOnSearch(repository.getUsers().get(key));
    }

    public User searchUser(String userId){
        return  repository.getUser(userId);
    }

    public User searchByUserName(String userName) {
        return repository.getByUserName(userName);
    }
}
