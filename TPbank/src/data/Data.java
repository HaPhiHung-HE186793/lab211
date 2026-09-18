package data;

import entity.Account;
import java.util.ArrayList;
import java.util.List;

/**
 * Noi luu tru du lieu (gia lap database) cho danh sach tai khoan hop le
 * dung de doi chieu khi dang nhap.
 */
public class Data {

    public static List<Account> listAccount = new ArrayList<Account>() {
        {
            add(new Account("1029817261", "tuan26062002"));
            add(new Account("1234567890", "qwert12345"));
            add(new Account("1039817261", "minh12345677"));
            add(new Account("1049817261", "chung3245677"));
            add(new Account("1059817261", "dhdi129YIUQWIE"));
        }
    };
}
