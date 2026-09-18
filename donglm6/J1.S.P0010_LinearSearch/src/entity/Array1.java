package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Array1 {
    // Practical limit for generating and displaying an array in the console.
    public static final int MAX_SIZE = 10_000;
    private final int[] array;

    public Array1(int number) {
        validateSize(number);
        array = new int[number];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(2 * number + 1) - number;
        }
    }

    public Array1(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        validateSize(numbers.length);
        array = numbers.clone();
    }

    private static void validateSize(int size) {
        if (size < 1 || size > MAX_SIZE) {
            throw new IllegalArgumentException(
                    "Array size must be between 1 and " + MAX_SIZE);
        }
    }

    public int[] getValues() {
        return array.clone();
    }

    public List<Integer> findAllIndex(int key) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                indices.add(i);
            }
        }
        return indices;
    }
}
