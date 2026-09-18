package main;

import java.util.Locale;
import java.util.Scanner;
import service.EbankService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EbankService ebank = new EbankService();

        // vong lap chuong trinh chinh
        while (true) {

            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            System.out.print("Please choice one option: ");

            String choice = sc.nextLine().trim();
            Locale locale;

            // Xet lua chon ngon ngu tu nguoi dung
            if (choice.equals("1")) {
                locale = new Locale("vi", "VN");
                ebank.setLocate(locale);
            } else if (choice.equals("2")) {
                locale = new Locale("en", "US");
                ebank.setLocate(locale);
            } else if (choice.equals("3")) {
                break; // Thoat chuong trinh
            } else {
                continue; // Nhap sai menu thi nhap lai
            }

            //B1: Vong lap Nhap va Xac thuc Account
            String accountNumber;
            while (true) {
                System.out.print(ebank.getMessage("label.account"));
                accountNumber = sc.nextLine().trim();

                String errorAccount = ebank.checkAccountNumber(accountNumber);
                if (errorAccount.isEmpty()) {
                    break; // Chuoi rong tuc la khong co loi -> Dung, thoat vong lap de di tiep.
                } else {
                    System.out.println(errorAccount); // In ra loi roi cho vong lap chay lai buoc nay.
                }
            }

            // B2: Vong lap Nhap va Xac thuc Password
            String password;
            while (true) {
                System.out.print(ebank.getMessage("label.password"));
                password = sc.nextLine().trim();

                String errorPassword = ebank.checkPassword(password);
                if (errorPassword.isEmpty()) {
                    break;
                } else {
                    System.out.println(errorPassword);
                }
            }

            // B3: Vong lap Nhap va Xac thuc Captcha
            while (true) {
                // Sinh ma roi in ra man hinh
                String generatedCaptcha = ebank.generateCaptcha();
                System.out.println(ebank.getMessage("label.captcha") + generatedCaptcha);
                System.out.print(ebank.getMessage("label.captcha.input"));

                // Nguoi dung nhap ma kiem tra
                String inputCaptcha = sc.nextLine().trim();

                String errorCaptcha = ebank.checkCaptcha(inputCaptcha, generatedCaptcha);
                if (errorCaptcha.isEmpty()) {
                    break; // Dung captcha, thoat vong lap de di tiep buoc xac thuc tai khoan.
                } else {
                    System.out.println(errorCaptcha);
                    // Neu nhap sai, vong lap se quay tro lai sinh ma Captcha moi toanh.
                }
            }

            // B4: Xac thuc tai khoan + mat khau voi du lieu he thong (entity Account / data.Data)
            if (ebank.authentication(accountNumber, password)) {
                System.out.println(ebank.getMessage("msg.login.success"));
            } else {
                System.out.println(ebank.getMessage("msg.login.failed"));
            }
            System.out.println(); // Cach mot dong cho dep
        }
    }
}
