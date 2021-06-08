package com.company.services;

import com.company.models.User;
import com.company.repository.UserRepository;
import com.company.utils.Inputs;

import java.io.IOException;

public class UserService {

    UserRepository repository;

    public UserService() throws IOException {
        this.repository =  UserRepository.getInstance();
    }

    public void addUser(User toAdd) throws IOException {
        repository.save(toAdd);
    }

    public User getUserByID(Long id) throws IOException { return repository.getAll().get(id); }

    public void updateUser(User user, int option){
        switch (option){
            case 1:
                user.setName(Inputs.inputString());
                break;
            case 2:
                user.setLastName(Inputs.inputString());
                break;
            case 3:
                user.setDNI(Inputs.inputString());
                break;
            case 4:
                user.setAdress(Inputs.inputString());
                break;
            case 5:
                user.setPhone(Inputs.inputString());
                break;
            case 6:
                user.setEmail(Inputs.inputString());
                break;
            case 7:
                user.setGenre(Inputs.inputString());
                break;
            case 8:
                user.setUserId(Inputs.inputString());
                break;
            case 9:
                user.setPassword(Inputs.inputString());
                break;
        };
    }

    public void showUserDetails(User user){
        System.out.println("\n1. ID: "+user.getUserId()
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
    public Long searchUser(String userId){
        long exists = 0;
        Integer key = 1;
        while (key <= repository.getUsers().size() && exists == 0) {
            if (userId.equals(repository.getUsers().get(key.longValue()).getUserId()))
                exists = key.longValue();
            key++;
        }
        return exists;
    }

    public User searchByUserName(String userName) {
        return repository.getByUserName(userName);
    }

    public void register(User user) {
        repository.save(user);
    }
}
