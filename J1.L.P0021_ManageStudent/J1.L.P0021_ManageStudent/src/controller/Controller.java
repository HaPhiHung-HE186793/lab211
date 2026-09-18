/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.ManageStudent;
import bo.StudentInputer;
import entity.Course;
import entity.Student;
import java.util.ArrayList;
import utils.Validator;

/**
 *
 * @author win
 */
/**
 * Lớp Controller dùng để điều khiển các chức năng của chương trình như tạo sinh
 * viên, tìm kiếm, cập nhật, xóa và báo cáo.
 */
public class Controller {

    /**
     * Đối tượng quản lý danh sách sinh viên.
     */
    private ManageStudent studentManager;
    /**
     * Đối tượng hỗ trợ nhập dữ liệu sinh viên.
     */
    private StudentInputer inputer;

    /**
     * Khởi tạo Controller.
     */
    public Controller() {
        studentManager = new ManageStudent();
    }

    /**
     * Tạo mới sinh viên. Nếu ID đã tồn tại thì tự động sử dụng tên cũ.
     *
     * @throws Exception nếu thêm sinh viên thất bại
     */
    public void createStudent() throws Exception {
        while (true) {
            // Tạo đối tượng nhập dữ liệu mới
            inputer = new StudentInputer();
            // Nhập ID sinh viên
            inputer.inputID();
            Student student = inputer.getStudent();
            // Nếu ID chưa tồn tại thì nhập tên mới
            if (studentManager.getListStudentById(student.getId()).isEmpty()) {
                inputer.inputStudentName();
            } else {
                // Tự động lấy tên từ bản ghi đã có
                String name = studentManager.getListStudentById(student.getId()).get(0).getStudentName();
                student.setStudentName(name);
                System.out.println("Name: " + name);
            }
            // Nhập học kỳ và môn học 
            inputer.inputSemester();
            // Thêm sinh viên vào danh sách
            inputer.inputCourseName();
            // Khi số lượng sinh viên lớn hơn 5 thì hỏi tiếp tục hay không
            if (!studentManager.add(student)) {
                throw new Exception("Can not create Student!");
            }
            if (studentManager.getList().size() > 5) {
                String choice = Validator.getString("Do you continue ( Y or N)? ", "Just Y or N", "[YNyn]");
                if (choice.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }
    }

    /**
     * Tìm kiếm sinh viên theo tên và sắp xếp kết quả.
     *
     * @throws Exception nếu không tìm thấy sinh viên
     */
    public void findAndSort() throws Exception {
        // Nhập tên cần tìm
        String name = Validator.getString("Enter name student: ", "Invalid!", "[A-Za-z\\s]+");
        // Lấy danh sách sinh viên phù hợp
        ArrayList<Student> list = studentManager.getListStudentByName(name);
        // Kiểm tra kết quả tìm kiếm
        if (list.isEmpty()) {
            throw new Exception("Can not found name!");
        }
        // Sắp xếp danh sách theo tên
        ManageStudent result = new ManageStudent();
        result.setList(list);
        result.sortStudentsByName();
        // Hiển thị kết quả
        System.out.println(result.toString());
    }

    /**
     * Cập nhật hoặc xóa thông tin sinh viên.
     *
     * @throws Exception nếu không tìm thấy ID hoặc dữ liệu không hợp lệ
     */
    public void updateOrDelete() throws Exception {
        inputer = new StudentInputer();
        // Nhập ID cần tìm
        String id = Validator.getString("Enter id: ", "Invalid!", "[Ss]\\d+");
        // Tìm danh sách sinh viên có cùng ID
        ArrayList<Student> list = studentManager.getListStudentById(id);
        if (list.isEmpty()) {
            throw new Exception("Can not found id");
        }
        // Hiển thị các bản ghi tìm được
        ManageStudent result = new ManageStudent();
        result.setList(list);
        System.out.println(result.toString());
        // Chọn bản ghi cần xử lý
        int choice = Validator.getInt("Enter record your choice: ", "Just be 1-> " + list.size(),
                "Invalid!", 1, list.size());
        Student student = list.get(choice - 1);
        System.out.println(student);

        // Chọn cập nhật hoặc xóa
        String choose = Validator.getString("Do you want Update(U) or Delete(D): ",
                "Just U or D", "[UDud]");
        if (choose.equalsIgnoreCase("U")) {
            // Nhập thông tin mới
            inputer.inputID();
            Student newStudent = inputer.getStudent();
            // Nếu ID đã tồn tại thì sử dụng tên cũ
            if (studentManager.getListStudentById(newStudent.getId()).isEmpty()) {
                inputer.inputStudentName();
            } else {
                String name = studentManager.getListStudentById(newStudent.getId()).get(0).getStudentName();
                newStudent.setStudentName(name);
                System.out.println("Name: " + name);
            }
            // Nhập học kỳ và môn học mới
            inputer.inputSemester();
            inputer.inputCourseName();
            studentManager.update(student, newStudent);
            // Cập nhật dữ liệu
        } else {
            // Xóa bản ghi đã chọn
            studentManager.delete(student);
        }
    }

    /**
     * Hiển thị báo cáo thống kê số lần học của sinh viên.
     *
     * @throws Exception nếu danh sách rỗng
     */
    public void report() throws Exception {
        // Tạo báo cáo
        String result = studentManager.report();
        if (result == null) {
            throw new Exception("List is empty!");
        }
        // Hiển thị báo cáo
        System.out.println(result);
    }

    /**
     * Tạo dữ liệu mẫu để kiểm thử chương trình.
     *
     * @throws Exception nếu dữ liệu bị trùng
     */
    public void generateStudent() throws Exception {
        studentManager.add(new Student("s1", "Nguyen Quan", "Fall2023", Course.JAVA));
        studentManager.add(new Student("s1", "Nguyen Quan", "Fall2024", Course.JAVA));
        studentManager.add(new Student("s1", "Nguyen Quan", "Fall2023", Course.C_CPP));
        studentManager.add(new Student("s1", "Nguyen Quan", "Fall2023", Course.DOT_NET));
        studentManager.add(new Student("s8", "Vu Quan", "Fall2023", Course.DOT_NET));
        studentManager.add(new Student("s2", "Tran Linh", "Sum2024", Course.JAVA));
        studentManager.add(new Student("s2", "Tran Linh", "Sum2024", Course.DOT_NET));
        studentManager.add(new Student("s3", "Le Thu Thao", "Sum2024", Course.JAVA));
        studentManager.add(new Student("s4", "Le Phuong Minh", "Sum2024", Course.DOT_NET));
        studentManager.add(new Student("s5", "Minh Vu", "Spring2023", Course.JAVA));
        studentManager.add(new Student("s6", "Tuan Minh", "Spring2023", Course.C_CPP));
        studentManager.add(new Student("s7", "Quang Vu", "Fall2023", Course.DOT_NET));
        studentManager.add(new Student("s8", "Vu Quan", "Fall2024", Course.DOT_NET));
    }

}
