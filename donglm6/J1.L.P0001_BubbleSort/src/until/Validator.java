/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package until;

import java.util.Scanner;

/**
 *
 * @author Tuandz
 */
public class Validator {
    private Validator() {
    }

    /**
     *Return the valid integer value scanned from the input
     * 
     * @param messageInfo               the message to be printed instructing 
     * the user to input
     * @param messageErrorOutOfRange    the message to be printed if the String 
     * parse value is out of range
     * @param messageErrorInvalidNumber the message to be printed if the String
     * does not contain a parable integer
     * @param min                       minimum Limit value
     * @param max                       maximum Limit value
     * @return the valid integer value scanned from the input
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {
        Scanner scanner = new Scanner(System.in);
        do {
        try {
            // Display the prompt message for input
            System.out.println(messageInfo);
            // Attempt to parse the input as an integer
            int number = Integer.parseInt(scanner.nextLine());
            // Check if the number is within the specified range
            if (number >= min && number <= max) {
                return number; // Return the valid number
            }
            // Display error message if number is out of range
            System.out.println(messageErrorOutOfRange);
        } catch (NumberFormatException e) {
            // Display error message if input is not a valid integer
            System.out.println(messageErrorInvalidNumber);
        }   
        } while (true); // Repeat until a valid number is entered
    }
}

