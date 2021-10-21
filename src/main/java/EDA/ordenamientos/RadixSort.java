/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDA.ordenamientos;

/**
 *
 * @author diegoandres
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RadixSort {
    
    public static void radixExterno(String nombreArchivo){
        int restriction = 1;    
        for(int k = 0; k < 7; k ++){
            System.out.println("\n********* Iteración " + (k+1) + " *********");
            Scanner sc;
            try{
                sc = new Scanner(new FileReader(nombreArchivo));
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    System.out.println("\n" + line);
                    int cuenta = fragmentador(line);
                    radix(cuenta,restriction,line,nombreArchivo);
                }
                sc.close();
                impresionTotal();
                // System.out.println("Pasé");
            }catch(FileNotFoundException e){
                System.out.println("Error: "+e.getMessage());
            } catch (IOException ex) {
                System.out.println("IO Exception: " + ex);
            }
    
            restriction *= 10;
            try {
                regresion(nombreArchivo);
                sc = new Scanner(new FileReader(nombreArchivo));
                System.out.println("\n------------------------------");
                System.out.println("       Archivo Original");
                System.out.println("------------------------------");
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
                sc.close();
            } catch (IOException ex) {
                System.out.println("IO Exception: " + ex);
            }
        }
    }
    
    public static int fragmentador(String dataTotal){
        // System.out.println("dataTotal: " + dataTotal);
        int cuenta = 0;
        try {
            String[] split = dataTotal.split(", ");
            // System.out.println("Split: " + split[2]);
            cuenta = Integer.parseInt(split[2]);
            System.out.println("cuenta: " + cuenta);
        
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
       return cuenta; 
    }
    
    public static void radix(int numero,int restriction, String totalData,String origin) throws FileNotFoundException, IOException{
        PrintWriter archivo;       
        for(int j = 0; j < 10; j++){

            int data = (numero/restriction) % 10;
            //System.out.println("Data : " + data + "->" + j);
            if(j == data){
                String fileName = "Archivo" + j + ".txt";
                try {
                    archivo = new PrintWriter(new FileWriter(fileName,true));
                    archivo.println(totalData);
                    archivo.close();
                } catch (IOException e) {
                    System.out.println("IOException: " + e.getMessage());
                }
                j = 10;
            }
        }
    }
    
    public static void regresion (String origin) throws IOException{
        PrintWriter archivoOrigen;
        limpieza(origin);
        String line;
        Scanner sc, ver;
            
        try {
        ver = new Scanner(new FileReader(origin));
            while (ver.hasNextLine()) {
                System.out.println(ver);
            }
            //System.out.println("Lista Original Vaciada");
            ver.close();
        }catch(IOException e){
           System.out.println("IOException: " + e.getMessage());
        }
        
        for(int i = 0; i < 10; i++){
            String fileName = "Archivo" + i + ".txt";
            try {
                archivoOrigen = new PrintWriter(new FileWriter(origin,true));
                try {
                   sc = new Scanner(new FileReader(fileName));
                    while (sc.hasNextLine()) {
                        line = sc.nextLine();
                        archivoOrigen.println(line);
                    }
                    sc.close();
                } catch (IOException e) {
                    System.out.println("IOException" + e.getMessage());
                }
                archivoOrigen.close();
            } catch (IOException e) {
                System.out.println("IOException" + e.getMessage());
            }
        }
        limpiezaTotal();
    }
    
    private static void limpieza(String lista){
        try {
            PrintWriter limp = new PrintWriter(new FileWriter(lista));
            limp.write("");
            limp.close();
            } catch (IOException ex) {
            System.out.println("IO Exception: " + ex.getMessage());
        }
    }

    private static void limpiezaTotal(){
        try {
            for (int i = 0; i < 10; i++) {
                String archivo = "Archivo" + i + ".txt";
                PrintWriter pw = new PrintWriter(archivo);
                pw.write("");
                pw.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    private static void impresionTotal(){
        try {
            for(int i = 0; i < 10; i++){
                String archivo = "Archivo" + i + ".txt";
                System.out.println("------------------------------");
                System.out.println(          "Archivo " + i);
                System.out.println("------------------------------");
                Scanner sc = new Scanner(new FileReader(archivo));
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
                sc.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
}