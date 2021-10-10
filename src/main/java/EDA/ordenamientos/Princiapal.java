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
        boolean salir = false;
        int opcion;
        String cadena;
        String line;
 
        cadena = JOptionPane.showInputDialog("Escriba el nombre del archivo con terminación .txt: ");
        try{
            Scanner sc = new Scanner(new FileReader(cadena));
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                System.out.println(line.toString());
            }
            sc.close();
            
        }catch(FileNotFoundException e){
            
            System.out.println("Error: "+e.getMessage());
        }

        while (!salir) {
            System.out.println("");
            System.out.println("");
            System.out.println("                  Proyecto 1                   ");
            System.out.println("");
            System.out.println("");
            
            System.out.println("1. Polifase");
            System.out.println("2. Mezcla Equilibrada");
            System.out.println("3. Radix");
            System.out.println("4. Salir");
 
            try {
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
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (Exception e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        } 
    } 
}
