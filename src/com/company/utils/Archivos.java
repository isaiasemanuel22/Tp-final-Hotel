package com.company.utils;


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
            if(obj.getClass().equals(Cliente.class)){
                ObjectMapper mapper = new ObjectMapper();
                list = (mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, ClienteEmpresa.class)));

                ArrayList<T> aux = list;
                for (int i = 0; i < aux.size(); i++) {
                    ClienteEmpresa search = (ClienteEmpresa) aux.get(i);
                    if(search.getCuit() == null){
                        Cliente nuevo =  (Cliente) list.remove(i);
                        list.add(i , (T) create(nuevo));
                    }

                }
            }else if(obj.getClass().equals(Product.class)){

                ObjectMapper mapper = new ObjectMapper();
                list = (mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Product.class)));

            }else if(obj.getClass().equals(Order.class)){

                ObjectMapper mapper = new ObjectMapper();
                list = (mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Order.class)));
            }

        }

        return list;
    }

    private Cliente create (Cliente c){
        Cliente nuevo = new Cliente();
        nuevo.setName(c.getName());
        nuevo.setLastname(c.getLastname());
        nuevo.setBirth(c.getBirth());
        nuevo.setDNI(c.getDNI());
        nuevo.setPhoneNumber(c.getPhoneNumber());
        return nuevo;

    }
}
