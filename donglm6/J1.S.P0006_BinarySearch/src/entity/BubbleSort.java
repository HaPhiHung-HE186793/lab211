/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Tuan Tran
 */
public class BubbleSort {

    /**
     * Thuật toán Bubble Sort chuẩn
     * @param array mảng cần sắp xếp
     */
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) return;
        
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}