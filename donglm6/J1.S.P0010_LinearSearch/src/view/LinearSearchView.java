package view;

import java.util.List;

public interface LinearSearchView {
    int readArraySize(int maxSize);
    int readSearchValue();
    void showArray(int[] values);
    void showError(String message);
    void showSearchResult(int key, List<Integer> indices);
}
