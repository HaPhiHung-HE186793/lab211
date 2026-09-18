/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 * @author Tuandz
 */
public class Validator {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Validator() {
    }

    /**
     * Nhập và trả về một số nguyên hợp lệ trong khoảng cho phép.
     *
     * @param messageInfo thông báo yêu cầu nhập dữ liệu
     * @param messageErrorOutOfRange thông báo lỗi khi giá trị ngoài phạm vi
     * @param messageErrorInvalidNumber thông báo lỗi khi dữ liệu không phải số
     * nguyên
     * @param min giá trị nhỏ nhất
     * @param max giá trị lớn nhất
     * @return số nguyên hợp lệ
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    /**
     * Nhập và trả về một số thực hợp lệ trong khoảng cho phép.
     *
     * @param messageInfo thông báo yêu cầu nhập dữ liệu
     * @param messageErrorOutOfRange thông báo lỗi khi giá trị ngoài phạm vi
     * @param messageErrorInvalidNumber thông báo lỗi khi dữ liệu không phải số
     * thực
     * @param min giá trị nhỏ nhất
     * @param max giá trị lớn nhất
     * @return số thực hợp lệ
     */
    public static double getDouble(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            double min, double max) {
        do {
            try {
                System.out.println(messageInfo);
                double number = Double.parseDouble(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    /**
     * Nhập và trả về một chuỗi hợp lệ theo định dạng yêu cầu.
     *
     * @param messageInfo thông báo yêu cầu nhập dữ liệu
     * @param messageError thông báo lỗi khi dữ liệu không hợp lệ
     * @param REGEX biểu thức chính quy dùng để kiểm tra dữ liệu
     * @return chuỗi hợp lệ
     */
    public static String getString(String messageInfo, String messageError,
            final String REGEX) {
        do {
            System.out.print(messageInfo);
            String str = SCANNER.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }
}
