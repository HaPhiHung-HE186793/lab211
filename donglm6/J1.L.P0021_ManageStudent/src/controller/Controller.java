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
public class Controller {

    private ManageStudent managerStudent;
    private StudentInputer studentInputer;

    public Controller() {
        managerStudent = new ManageStudent();
    }

    public void createStudent() throws Exception {
        while (true) {
            studentInputer = new StudentInputer();
            studentInputer.inputID();

            Student student = studentInputer.getStudent();

            //nếu như student hiện tại đang trống, thực hiện nhập tên
            if (managerStudent.getListStudentById(student.getId()).isEmpty()) {
                studentInputer.inputStudentName();
            } else {
                String name = managerStudent.getListStudentById(student.getId()).get(0).getStudentName();
                student.setStudentName(name);
                System.out.println("Name: " + name);
            }

            studentInputer.inputSemester();
            studentInputer.inputCourseName();

            // Trường hợp không thể tạo được student
            if (!managerStudent.add(student)) {
                throw new Exception("Can not create student");
            }
            if (managerStudent.getList().size() > 10) {
                String choice = Validator.getString("Do you continue (Y or N)?", "Just Y or N", "[YNyn]");
                if (choice.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }
    }

    public void findAndSort() throws Exception {
        //Input đầu vào là tên học sinh để hiển thị
        String name = Validator.getString("Enter name student:", "Invalid!", "[A-Za-z\\s]+");

        //Tạo 1 danh sách để chứa các học sinh
        ArrayList<Student> list = managerStudent.getListStudentByName(name);

        //điều kiện nếu danh sách không có thì trả về không tìm thấy
        if (list.isEmpty()) {
            throw new Exception("Can not found name!");
        }

        //lưu lại danh sách
        ManageStudent result = new ManageStudent();
        result.setList(list);
        result.sortStudentsByName();
        System.out.println(result.toString());
    }

    public void updateOrDelete() throws Exception {
        studentInputer = new StudentInputer();

        String id = Validator.getString("Enter id: ", "Invalid!", "[Ss]\\d+");
        ArrayList<Student> list = managerStudent.getListStudentById(id);

        if (list.isEmpty()) {
            throw new Exception("Can not found ID");
        }

        ManageStudent result = new ManageStudent();
        result.setList(list);
        System.out.println(result.toString());

        int choice = Validator.getInt("Enter record your choice: ", "Just be 1 -> " + list.size(),
                "Invalid!", 1, list.size());

        Student student = list.get(choice - 1);
        System.out.println(student);

        String choose = Validator.getString("Do you want update(U) or delete(D): ", "Just U or D",
                "[UDud]");

        if (choose.equalsIgnoreCase("U")) {
            studentInputer.inputID();

            Student newStudent = studentInputer.getStudent();
            if (managerStudent.getListStudentById(newStudent.getId()).isEmpty()) {
                studentInputer.inputStudentName();
            } else {
                String name = managerStudent.getListStudentById(newStudent.getId()).get(0).getStudentName();
                newStudent.setStudentName(name);
                System.out.println("Name: " + name);
            }

            studentInputer.inputSemester();
            studentInputer.inputCourseName();
            managerStudent.update(student, newStudent);
        } else {
            managerStudent.delete(student);
        }
    }

    public void report() throws Exception {
        String result = managerStudent.report();
        if (result == null) {
            throw new Exception("List is empty");
        }
        System.out.println(result);
    }

    public void generateStudent() throws Exception {
        managerStudent.add(new Student("s1", "Nguyen Quan", "Fall2023", Course.JAVA));
        managerStudent.add(new Student("s1", "Nguyen Quan", "Fall2024", Course.JAVA));
        managerStudent.add(new Student("s1", "Nguyen Quan", "Fall2023", Course.C_CPP));
        managerStudent.add(new Student("s1", "Nguyen Quan", "Fall2023", Course.DOT_NET));
        managerStudent.add(new Student("s2", "Tran Linh", "Sum2024", Course.JAVA));
        managerStudent.add(new Student("s2", "Tran Linh", "Sum2024", Course.DOT_NET));
        managerStudent.add(new Student("s3", "Le Thu Thao", "Sum2024", Course.JAVA));
        managerStudent.add(new Student("s4", "Le Phuong Minh", "Sum2024", Course.DOT_NET));
        managerStudent.add(new Student("s5", "Minh Vu", "Spring2023", Course.JAVA));
        managerStudent.add(new Student("s6", "Tuan Minh", "Spring2023", Course.C_CPP));
    }

}
