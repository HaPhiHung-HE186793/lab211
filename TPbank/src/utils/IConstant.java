package utils;

/**
 * Cac hang so dung chung: do dai captcha va cac mau Regex kiem tra du lieu.
 * Tach rieng de tranh lap lai chuoi Regex nhieu noi (nhu ban goc).
 */
public class IConstant {

    public static final int CAPTCHA_LENGTH = 5;

    // So tai khoan: dung 10 chu so
    public static final String ACCOUNT_NUMBER = "^\\d{10}$";

    // Mat khau: 8-31 ky tu, bat buoc co ca chu va so
    public static final String PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$";
}
