package com.company.utils;


import com.company.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Archivos <T>{

    private String url;


    public Archivos (String url){

        this.url = "src\\main\\java\\Ejercicio4\\" + url;
    }

    public void save(ArrayList<T> c ){
        File file = new File(new File(this.url).getAbsolutePath());
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file , c);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<T> read(Object obj) throws IOException {

        ArrayList<T> list = new ArrayList<T>();
        File file = new File(new File(this.url).getAbsolutePath());
        if (file.exists()) {
            if (obj.getClass().equals(User.class)) {
                ObjectMapper mapper = new ObjectMapper();
                list = (mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class)));

            }
        }
        return list;
    }

}
