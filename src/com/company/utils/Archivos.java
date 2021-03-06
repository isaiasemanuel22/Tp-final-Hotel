package com.company.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Archivos<T> {
    private String url;

    public Archivos(String fileName) {//Makes a directory if it doesn't exists and gives to url the file's url
        File directory = new File(System.getProperty("user.dir") + "\\src\\", fileName);

        if (!directory.exists() || !directory.isDirectory())
            directory.mkdirs();

        url = directory.getAbsolutePath() + "\\" + fileName;
    }

    public Archivos() {

    }

    public void save(ArrayList<T> c) {
        File file = new File(url);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, c);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<T> read(Class<T> obj) throws IOException {
        ArrayList<T> list = new ArrayList<>();
        File file = new File(url);
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            list = (mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, obj)));
        }
        return list;
    }

    public boolean exists() {
        return new File(url).exists();
    }
}
