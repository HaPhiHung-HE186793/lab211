package main;

import java.util.Locale;
import java.util.Scanner;
import service.Ebank;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------Login Program-------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            System.out.print("Please choice one option: ");
            System.out.flush();

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    new Ebank(Locale.forLanguageTag("vi-VN"), scanner).login();
                    return;
                case "2":
                    new Ebank(Locale.forLanguageTag("en-US"), scanner).login();
                    return;
                case "3":
                    return;
                default:
                    System.out.println("Please choice one option from 1 to 3");
                    break;
            }
        }
    }
}
