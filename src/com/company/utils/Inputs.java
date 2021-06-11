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
         try {
             entrada = scan.nextLine();
         }catch (Exception e){
             scan.nextLine();
         }
         return entrada;
     }

    public static Integer inputInterger(){
        Integer entrada = null;
        try {
            entrada = scan.nextInt();;
            System.out.println(entrada);
        }catch (Exception e){
            scan.nextLine();
        }

        scan.nextLine();
        return entrada;
    }
}
