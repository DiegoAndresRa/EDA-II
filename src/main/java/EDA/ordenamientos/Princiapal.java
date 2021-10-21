/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDA.ordenamientos;

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;
 
public class Princiapal{
 
    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        int salir = 0;
        int opcion;
        String cadena;
 
        cadena = JOptionPane.showInputDialog("Escriba el nombre del archivo con terminación .txt: ");
        
        

        while (salir == 0) {
            System.out.println("");
            System.out.println("");
            System.out.println("******************** Proyecto 1 ********************");
            System.out.println("");
            System.out.println("");
            
            System.out.println("1. Polifase");
            System.out.println("2. Mezcla Equilibrada");
            System.out.println("3. Radix");
            System.out.println("4. Salir");
 
                System.out.print("Escribe una de las opciones: ");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("\n\nHas seleccionado Polifase ");
                        break;
                    case 2:
                        System.out.println("\n\nHas seleccionado Mezcla Equilibrada  ");
                        break;
                    case 3:
                        System.out.println("\n\nHas seleccionado Radix");
                        RadixSort.radixExterno(cadena);
                        break;
                    case 4:
                        salir = 1;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            
        } 
    } 
    
    public static void LeerArchivo(String cadena){
        String line;
        try{
            Scanner sc = new Scanner(new FileReader(cadena));
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
            
        }catch(FileNotFoundException e){
            
            System.out.println("Error: "+e.getMessage());
        }
        
    }
   
}
