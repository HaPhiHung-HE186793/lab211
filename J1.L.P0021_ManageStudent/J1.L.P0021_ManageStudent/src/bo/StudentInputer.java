/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Course;
import entity.Student;
import utils.Validator;

/**
 * Lớp StudentInputer dùng để nhập thông tin sinh viên từ bàn phím.
 *
 * @author win
 */
public class StudentInputer {

    /**
     * Đối tượng sinh viên được sử dụng để lưu thông tin nhập vào.
     */
    private Student student;

    /**
     * Khởi tạo đối tượng StudentInputer với một sinh viên mới.
     */
    public StudentInputer() {
        student = new Student();
    }

    /**
     * Nhập mã sinh viên. ID phải bắt đầu bằng S hoặc s và theo sau là các chữ
     * số.
     */
    public void inputID() {
        student.setId(Validator.getString("Enter id: ", "Invalid!", "[Ss]\\d+"));
    }

    /**
     * Nhập tên sinh viên. Tên chỉ được chứa chữ cái và khoảng trắng.
     */
    public void inputStudentName() {
        student.setStudentName(Validator.getString("Enter name student: ", "Invalid!", "[A-Za-z\\s]+"));
    }

    /**
     * Nhập học kỳ của sinh viên.
     */
    //nếu chỉ muốn FALL2024 thì "[A-Za-z]+\\d+"

    public void inputSemester() {
        student.setSemester(Validator.getString("Enter Semester: ", "Invalid!", "[A-Za-z\\d]+"));
    }
    /**
     * Nhập môn học bằng cách chọn từ danh sách các môn được hỗ trợ.
     */
    public void inputCourseName() {
        int choice = Validator.getInt("Only three courses:\n"
                + "1-Java\n"
                + "2-.Net\n"
                + "3-C/C++\n"
                + "Enter your choice:",
                "Please enter number 1->3", "Invalid", 1, 3);
        student.setCourseName(Course.getCourse(choice));
    }

    /**
     * Trả về thông tin sinh viên đã được nhập.
     *
     * @return đối tượng sinh viên
     */

    public Student getStudent() {
        return student;
    }

}
