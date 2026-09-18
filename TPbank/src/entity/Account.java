package entity;

/**
 * Thuc the (entity) dai dien cho 1 tai khoan ngan hang.
 * Chi luu du lieu, khong chua logic nghiep vu.
 */
public class Account {
    private String account;
    private String password;

    public Account(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }
}
