/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author win
 */
public class BinarySearch {

    private int[] array;

    public BinarySearch(int number) throws Exception {
        if (number <= 0) {
            throw new Exception("Number of array must be >0");
        }
        array = new int[number];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(number);
        }
    }

    public BinarySearch(int[] array) throws Exception {
        if (array == null) {
            throw new Exception("Array can not null!");
        }
        this.array = array;
    }

    public void display() {
        BubbleSort.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public int binarySearch(int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < key) {
                left = mid + 1;
            } else if (array[mid] > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
    // NẾU THẦY YÊU CẦU Tìm TẤT CẢ vị trí của key thì code hàm dưới đây
    public int[] binarySearchAll(int key) {
        int index = binarySearch(key);
        if (index == -1) {
            return new int[0]; // không tìm thấy
        }

        // tìm biên trái
        int left = index;
        while (left - 1 >= 0 && array[left - 1] == key) {
            left--;
        }

        // tìm biên phải
        int right = index;
        while (right + 1 < array.length && array[right + 1] == key) {
            right++;
        }

        // lưu tất cả vị trí
        int[] result = new int[right - left + 1];
        int idx = 0;
        for (int i = left; i <= right; i++) {
            result[idx++] = i;
        }

        return result;
    }
}
