package presenter;

import entity.Array1;
import view.LinearSearchView;

public class LinearSearchPresenter {
    private final LinearSearchView view;

    public LinearSearchPresenter(LinearSearchView view) {
        this.view = view;
    }

    public void run() {
        Array1 array;
        while (true) {
            int size = view.readArraySize(Array1.MAX_SIZE);
            try {
                array = new Array1(size);
                break;
            } catch (IllegalArgumentException e) {
                view.showError(e.getMessage());
            }
        }

        view.showArray(array.getValues());
        int key = view.readSearchValue();
        view.showSearchResult(key, array.findAllIndex(key));
    }
}
