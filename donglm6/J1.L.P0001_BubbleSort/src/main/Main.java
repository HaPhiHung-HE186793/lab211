/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import model.Array;
import until.Validator;

/**
 *
 * @author anhho
 */
public class Main {
    public static void main(String[] args) {
        int number = Validator.getInt("Enter number of array: ", "Number must be > 0", "Invalid!", 0, Integer.MAX_VALUE);
        Array array = new Array(number);
        System.out.print("Before array:");
        array.printArray();
        array.selectionSort1();
        System.out.print("After array:");
        array.printArray();
        
        
        
    }
}
