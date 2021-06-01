package com.company.utils;

import com.company.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.company.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Archivos <T>{
    private String url;

    public Archivos (String fileName){//Makes a directory if it doesn't exists and gives to url the file's url
        File directory = new File(System.getProperty("user.dir") + "\\src\\", fileName);

        if(!directory.exists() || !directory.isDirectory())
            directory.mkdir();

        url = directory.getAbsolutePath() + "\\" + fileName;
    }

    public String getUrl(){ return url; }

    public void save(ArrayList<T> c){
        File file = new File(url);
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file , c);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<T> read(Class<T> clase ) throws IOException {
        ArrayList<T> list = new ArrayList<>();
        File file = new File(url);
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            list = (mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class,clase )));
        }
        return list;
    }

    public boolean existFile(){
        File file = new File(url);
        boolean exist = false;
        if(file.exists()){
            exist = true;
        }
        return exist;
    }
}
