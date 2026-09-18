/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Tuandz
 */
/**
 * Lop ho tro kiem tra du lieu dau vao.
 *
 * Cung cap cac phuong thuc nhap va kiem tra: - So nguyen. - So thuc. - Chuoi
 * theo bieu thuc chinh quy. - Ngay thang theo dinh dang xac dinh.
 */
public class Validator {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Validator() {
    }

    /**
     * Nhap va kiem tra so nguyen trong khoang cho phep.
     *
     * @param messageInfo thong bao nhap du lieu
     * @param messageErrorOutOfRange thong bao khi ngoai pham vi
     * @param messageErrorInvalidNumber thong bao khi nhap sai dinh dang
     * @param min gia tri nho nhat
     * @param max gia tri lon nhat
     * @return so nguyen hop le
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {
        // yeu cau: Nhap va xac thuc mot so nguyen nam trong khoang [min, max].
        // cach lam: Dung vong lap do-while lap lai cho den khi nhap dung.
        // Dung try-catch de bat NumberFormatException khi nguoi dung nhap khong phai so.
        // Neu parse thanh cong thi kiem tra co nam trong khoang cho phep khong,
        // dung thi tra ve, sai thi in thong bao loi tuong ung roi lap lai.
        
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
     * Nhap va kiem tra so thuc trong khoang cho phep.
     *
     * @param messageInfo thong bao nhap du lieu
     * @param messageErrorOutOfRange thong bao khi ngoai pham vi
     * @param messageErrorInvalidNumber thong bao khi nhap sai dinh dang
     * @param min gia tri nho nhat
     * @param max gia tri lon nhat
     * @return so thuc hop le
     */
    public static double getDouble(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            double min, double max) {
        // yeu cau: Nhap va xac thuc mot so thuc nam trong khoang [min, max].
        // cach lam: Tuong tu getInt(), nhung dung Double.parseDouble() de chuyen doi
        // chuoi nhap thanh so thuc. Lap lai cho den khi nguoi dung nhap dung dinh dang
        // va gia tri nam trong khoang cho phep.
        
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
     * Nhap va kiem tra chuoi theo bieu thuc chinh quy.
     *
     * @param messageInfo thong bao nhap du lieu
     * @param messageError thong bao loi
     * @param REGEX bieu thuc chinh quy
     * @return chuoi hop le
     */
    public static String getString(String messageInfo, String messageError,
            final String REGEX) {
        // yeu cau: Nhap va xac thuc mot chuoi theo dinh dang REGEX cho truoc.
        // cach lam: Lap lai viec doc chuoi tu ban phim, dung ham matches(REGEX)
        // de kiem tra dinh dang. Neu hop le thi tra ve, sai thi in loi va nhap lai.
        
        do {
            System.out.print(messageInfo);
            String str = SCANNER.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }

    /**
     * Nhap va kiem tra ngay hop le trong khoang cho phep.
     *
     * @param messageInfo thong bao nhap du lieu
     * @param messageErrorOutOfRange thong bao khi ngoai pham vi
     * @param messageErrorInvalidDate thong bao khi sai dinh dang ngay
     * @param REGEX dinh dang ngay
     * @param min ngay nho nhat
     * @param max ngay lon nhat
     * @return ngay hop le
     */
    public static Date getDate(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidDate,
            final String REGEX,
            Date min, Date max) {
        // yeu cau: Nhap va xac thuc mot ngay hop le, dung dinh dang va nam trong khoang [min, max].
        // cach lam: Dung SimpleDateFormat voi pattern REGEX, set setLenient(false)
        // de ep nguoi dung nhap dung dinh dang ngay (khong tu dong "sua" ngay sai).
        // Dung try-catch de bat ParseException khi sai dinh dang, sau do dung
        // compareTo() de kiem tra ngay co nam trong khoang cho phep khong.
        
        //set format of date
        SimpleDateFormat dateFormat = new SimpleDateFormat(REGEX);
        dateFormat.setLenient(false);
        //force user input exectly a date
        while (true) {
            System.out.print(messageInfo);
            try {
                // Chuyen chuoi nhap thanh doi tuong Date
                Date date = dateFormat.parse(SCANNER.nextLine());
                // Kiem tra ngay nam trong khoang cho phep
                if (date.compareTo(min) >= 0 && date.compareTo(max) <= 0) {
                    return date;
                }
                System.err.println(messageErrorOutOfRange);
            } catch (ParseException e) {
                // Nguoi dung nhap sai dinh dang ngay
                System.err.println(messageErrorInvalidDate);
            }
        }
    }
}