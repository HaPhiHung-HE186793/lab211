/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author win
 */

/**
 * Enum lưu trữ các môn học được hỗ trợ trong chương trình.
 */
public enum Course {
    JAVA("JAVA"),
    DOT_NET(".NET"),
    C_CPP("C/C++");
    private String language;

    /**
     * Khởi tạo môn học với tên tương ứng.
     *
     * @param language tên môn học
     */
    Course(String language) {
        this.language = language;
    }

    /**
     * Trả về môn học tương ứng với lựa chọn của người dùng.
     *
     * @param type lựa chọn môn học
     * @return môn học tương ứng
     */
    public static Course getCourse(int type) {
        switch (type) {
            case 1:
                return JAVA;
            case 2:
                return DOT_NET;
            case 3:
                return C_CPP;
            default:
                throw new AssertionError();

        }
    }

    /**
     * Trả về tên môn học.
     *
     * @return tên môn học
     */
    public String getLanguage() {
        return language;
    }
}
