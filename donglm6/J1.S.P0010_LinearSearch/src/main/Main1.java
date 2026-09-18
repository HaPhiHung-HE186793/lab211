package main;

import presenter.LinearSearchPresenter;
import view.ConsoleLinearSearchView;

public class Main1 {
    public static void main(String[] args) {
        new LinearSearchPresenter(new ConsoleLinearSearchView()).run();
    }
}
