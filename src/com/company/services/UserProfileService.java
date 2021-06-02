package com.company.services;

import com.company.models.UserProfile;

import java.util.ArrayList;

public class UserProfileService {
    private static UserProfileService instance;
    private ArrayList<UserProfile> userProfileArrayList;

    public UserProfileService() {
        if(instance == null) {
            this.userProfileArrayList = new ArrayList<>();
            userProfileArrayList.add(UserProfile.Administrador);
            userProfileArrayList.add(UserProfile.Recepcionista);
            userProfileArrayList.add(UserProfile.Pasajero);
        }
        instance = this;
    }

    public static UserProfileService getInstance() {
        return instance;
    }

    public void showUsersProfile(){
        int i=1;
        for (UserProfile aux: userProfileArrayList) {
            System.out.println("n"+i+" "+aux);
            i++;
        }
    }
}
