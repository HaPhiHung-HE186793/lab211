package main;

import model.Array1;
import until.Validater1;

public class Main1 {
        public static void main(String[] args) {
            Array1 arr;
            try {
                int number = Validater1.getInt("input", "out oh range", "invalid", 1, Integer.MAX_VALUE);
                 arr = new Array1(number);
            }catch (Exception e){
                System.out.println(e);
            }
             arr.bubbleSort();
        }
}
