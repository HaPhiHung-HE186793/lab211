package view;

import java.util.Arrays;
import java.util.List;
import utils.Validator1;

public class ConsoleLinearSearchView implements LinearSearchView {
    @Override
    public int readArraySize(int maxSize) {
        return Validator1.getInt("Enter number of array: ",
                "Number must be between 1 and " + maxSize,
                "Please enter an integer", 1, maxSize);
    }

    @Override
    public int readSearchValue() {
        return Validator1.getInt("Enter search value: ",
                "Value is out of range", "Please enter an integer",
                Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public void showArray(int[] values) {
        System.out.println("The array: " + Arrays.toString(values));
    }

    @Override
    public void showError(String message) {
        System.out.println(message);
    }

    @Override
    public void showSearchResult(int key, List<Integer> indices) {
        if (indices.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.println("Found " + key + " at indices: " + indices);
        }
    }
}
