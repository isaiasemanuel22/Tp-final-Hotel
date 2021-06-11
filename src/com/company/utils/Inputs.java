package com.company.utils;


import java.util.InputMismatchException;
import java.util.Scanner;


public class Inputs <T>  {

    private static Scanner scan = new Scanner(System.in);

     public Inputs(){

     }

     public T input(String mensaje, Object obj) throws InputMismatchException{
         T entrada = null;
         do {
             System.out.println(mensaje);
             if (obj.equals(String.class)) {
                 try {
                     String input = this.scan.nextLine();
                     entrada = (T) input;
                 }catch (Exception e){
                     this.scan.nextLine();
                 }

             }else
                 if(obj.equals(Integer.class)){
                 Integer  input = null;
                 try {
                     input = this.scan.nextInt();
                 }
                 catch (InputMismatchException ex){
                     System.out.println("Ingrese una entrada valida");
                     this.scan.nextLine();
                 }

                 entrada = (T) input;
             }else{
                     Float  input = null;
                     try {
                         input = this.scan.nextFloat();
                     }
                     catch (InputMismatchException ex){
                         System.out.println("Ingrese una entrada valida");
                         this.scan.nextLine();
                     }

                     entrada = (T) input;
                 }

         }while (entrada == null || entrada == "");

         return entrada;
     }

     public static String inputString(){
         String entrada = null;
         boolean repeat = true;
        do{
            try {
                entrada = scan.nextLine();
                repeat = false;
            }catch (InputMismatchException e){
                System.out.println("Ingrese una cadena de texto");
                scan.nextLine();
            }
        }while (repeat);

         return entrada;
     }

    public static Integer inputInterger(){
        Integer entrada = null;
        boolean repeat = true;
        do{
            try {
                entrada = scan.nextInt();
                repeat = false;
            }catch (InputMismatchException e){
                System.out.println("Ingrese el valor numerico");
                scan.nextLine();

            }
        }while (repeat);
        scan.nextLine();
        return entrada;
    }
}
