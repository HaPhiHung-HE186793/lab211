/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Fibonacci;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci: ");
        Fibonacci fibonacci = new Fibonacci(45);
        for (int i = 0; i < 45; i++) {
            System.out.print(fibonacci.getFibonacci(i));
            if (i == 44) {
                System.out.print(".");
            }
            else{
                System.out.print(", ");
            }
        }
        
        System.out.println("F[0] = " + fibonacci.getFibonacci(0));
        System.out.println("F[1] = " + fibonacci.getFibonacci(1));
        System.out.println("F[44] = " + fibonacci.getFibonacci(44));

    }

}
