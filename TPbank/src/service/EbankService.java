package service;

import data.Data;
import entity.Account;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import utils.IConstant;

/**
 * Chua toan bo logic nghiep vu (xac thuc dinh dang, sinh captcha,
 * xac thuc tai khoan trong du lieu he thong).
 * Thuat toan va comment "yeu cau / cach lam" duoc giu nguyen tu ban goc.
 */
public class EbankService {
    // bien bundle de luu tru bo tu dien hien tai sau khi nguoi dung chon ngon ngu
    private ResourceBundle bundle;

    public void setLocate(Locale locate) {
        // yeu cau: Chuyen doi ngon ngu toan he thong.
        // cach lam: Lay ma ngon ngu tu Locale (vi hoac en).
        // Sau do dung ResourceBundle.getBundle() de nap file Language_vi.properties hoac Language_en.properties tuong ung.

        String baseName = locate.getLanguage().equals("vi") ? "resources/Language_vi" : "resources/Language_en";
        bundle = ResourceBundle.getBundle(baseName, locate);
    }

    public String checkAccountNumber(String accountNumber) {
        // yeu cau: Xac thuc so tai khoan phai la 10 chu so.
        // cach lam: Dung Regex "^\\d{10}$". Neu matches() tra ve true thi hop le (tra ve chuoi rong).
        // Neu sai thi vao bundle lay cau (thong bao loi) tuong ung.

        if (accountNumber.matches(IConstant.ACCOUNT_NUMBER)) {
            return "";
        }
        return bundle.getString("error.account");
    }

    public String checkPassword(String password) {
        // yeu cau: Xac thuc mat khau tu 8-31 ky tu, bat buoc chua ca chu va so.
        // cach lam: Dung Regex voi Lookahead (?=.*[A-Za-z]) de ep co chu, (?=.*\\d) de ep co so.

        if (password.matches(IConstant.PASSWORD)) {
            return "";
        }
        return bundle.getString("error.password");
    }

    public String generateCaptcha() { 
        // yeu cau: Tao ma Captcha ngau nhien.
        // cach lam: Tao mot chuoi chua tat ca chu va so.
        // Dung Random de lay ngau nhien 5 ky tu ghep lai voi nhau.

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();
        int length = IConstant.CAPTCHA_LENGTH;

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            captcha.append(chars.charAt(index));
        }
        return captcha.toString();
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        // yeu cau: Kiem tra ky tu nhap vao co nam trong chuoi Captcha khong.
        // cach lam: Su dung ham contains().

        if (captchaGenerate.contains(captchaInput)) {
            return "";
        }
        return bundle.getString("error.captcha.incorrect");
    }

    public boolean authentication(String account, String password) {
        // yeu cau: Xac thuc tai khoan + mat khau nguoi dung nhap co ton tai
        // trong du lieu he thong (Data.listAccount) hay khong.
        // cach lam: Duyet qua danh sach Account trong Data, so sanh account
        // va password bang equals(). Neu tim thay tai khoan trung khop thi tra ve true.

        for (Account a : Data.listAccount) {
            if (account.equals(a.getAccount()) && password.equals(a.getPassword())) {
                return true;
            }
        }
        return false;
    }

    // Ham ho tro (Utility): Lay chuoi tu file properties de hien thi UI trong ham Main
    public String getMessage(String key) {
        return bundle.getString(key);
    }
}
