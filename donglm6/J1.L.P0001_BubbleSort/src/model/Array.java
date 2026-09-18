/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.Random;

public class Array {

    private int array[] = null;

    /**
     * This construct a random array.
     *
     * @param number -length of array
     */
    public Array(int number) {
        Random rand = new Random();
        array = new int[number];
        // Loop to initialize each element of the array with a random number
        for (int i = 0; i < number; i++) {
            array[i] = rand.nextInt(number); // Assign a random number to each array element
        }
    }

    /**
     * This method is used to display Arrays on the screen.
     */
    public void printArray() {
        System.out.print(" [");
        // Loop through each element of the array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]); // Print the current element
            // Check if it's not the last element
            if (i < array.length - 1) {
                System.out.print(", "); // Print a comma after each element except the last
            } else {
                System.out.print("]"); // Close the bracket after the last element
            }
        }
        System.out.println(); // Print a newline at the end
    }

    /**
     * This method is used to sort array by bubble sort
     *
     */
    public void selectionSort() {
        for (int i = 0; i < array.length - 1; i++) {

            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min_idx]) {

                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = array[i];
            array[i] = array[min_idx];
            array[min_idx] = temp;
        }
    }

    public void selectionSort1() {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println("Pass " + (i + 1) + ":");
            System.out.println("Current position i: " + i);
            System.out.println("Assume minimum is array[" + i + "] = " + array[i]);

            int min_idx = i;
            for (int j = i + 1; j < array.length; j++) {
                System.out.println("Compare array [" + j + "] = " + array[j] + " with current minimum array[" + min_idx + "] = " + array[min_idx]);
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                    System.out.println("New minimum found: array[" + min_idx + "] = " + array[min_idx]);
                }
            }

            System.out.println("Minimum last is: array[" + min_idx + "] = " + array[min_idx]);
            if (min_idx != i) {
                System.out.println("Swap array[" + i + "] = " + array[i]
                        + " with array[" + min_idx + "] = " + array[min_idx]);
                int temp = array[i];
                array[i] = array[min_idx];
                array[min_idx] = temp;

            } else {
                System.out.println("No swap needed!");
            }
            
            System.out.println("Array after pass " + (i+1) + ": " + Arrays.toString(array));
            System.out.println("------------------------------");
        }
        
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
