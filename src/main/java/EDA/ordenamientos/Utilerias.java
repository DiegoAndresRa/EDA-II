/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDA.ordenamientos;

import java.util.LinkedList;
/**
 *
 * @author diegoandres
 */
public class Utilerias {
    
    public static void printCharArr(char arr[]){
        for (char i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    public static void printIntArr(int[] arreglo){

        for(int i:arreglo){
            System.out.print(i + " ");  
        }
        System.out.println(" ");
    }
    
    public static void printQueue(LinkedList generic){
        while(generic.peek() != null){
            System.out.print(generic.poll() + " ");
        }
        System.out.println(" ");
    }

}
