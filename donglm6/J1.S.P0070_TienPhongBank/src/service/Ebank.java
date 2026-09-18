package service;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Ebank {
    private static final String CAPTCHA_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String VALID = "";

    private final Scanner scanner;
    private ResourceBundle language;

    public Ebank(Locale locale) {
        this(locale, new Scanner(System.in));
    }

    public Ebank(Locale locale, Scanner scanner) {
        this.scanner = scanner;
        setLocate(locale);
    }

    public void setLocate(Locale locale) {
        language = ResourceBundle.getBundle("resources.Language", locale);
    }

    public String checkAccountNumber(String accountNumber) {
        if (accountNumber != null && accountNumber.matches("\\d{10}")) {
            return VALID;
        }
        return language.getString("accountInvalid");
    }

    public String checkPassword(String password) {
        if (password != null && password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z0-9]{8,31}$")) {
            return VALID;
        }
        return language.getString("passwordInvalid");
    }

    public String generateCaptcha() {
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            captcha.append(CAPTCHA_CHARS.charAt(new Random().nextInt(CAPTCHA_CHARS.length())));
        }
        return captcha.toString();
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaInput != null && !captchaInput.isEmpty()
                && captchaGenerate != null && captchaGenerate.contains(captchaInput)) {
            return VALID;
        }
        return language.getString("captchaInvalid");
    }

    public void login() {
        while (true) {
            System.out.print(language.getString("account") + " ");
            String message = checkAccountNumber(scanner.nextLine().trim());
            if (message.isEmpty()) {
                break;
            }
            System.out.println(message);
        }

        while (true) {
            System.out.print(language.getString("password") + " ");
            String message = checkPassword(scanner.nextLine().trim());
            if (message.isEmpty()) {
                break;
            }
            System.out.println(message);
        }

        String captchaGenerate = generateCaptcha();
        System.out.println(language.getString("captcha") + " " + captchaGenerate);
        while (true) {
            System.out.print(language.getString("inputCaptcha") + " ");
            String message = checkCaptcha(scanner.nextLine().trim(), captchaGenerate);
            if (message.isEmpty()) {
                break;
            }
            System.out.println(message);
        }
    }
}
