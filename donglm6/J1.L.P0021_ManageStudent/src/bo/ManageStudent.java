/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author win
 */
public class ManageStudent {

    private List<Student> list;

    public ManageStudent() {
        list = new ArrayList<>();
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public boolean isExisted(Student student) {
        for (Student students : list) {
            if (students.getId().equals(student.getId())
                    && students.getSemester().equals(student.getSemester())
                    && students.getCourseName().equals(student.getCourseName())) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Student student) throws Exception {
        if (isExisted(student)) {
            throw new Exception("This record is existed!");
        }
        return list.add(student);
    }

    public boolean delete(Student student) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List is empty, can not delete");
        }
        if (!isExisted(student)) {
            throw new Exception("This record can not found!");
        }
        return list.remove(student);
    }

    private int getIndexRecord(Student student) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(student)) {
                return i;
            }
        }
        return -1;
    }

    public void update(Student oldStudentRecord, Student newStudentRecord) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List is empty can not update");
        }
        if (!isExisted(oldStudentRecord)) {
            throw new Exception("This record can not found!");
        } else {
            if (isExisted(newStudentRecord)) {
                throw new Exception("New record be duplicate!!");
            }
            list.set(getIndexRecord(oldStudentRecord), newStudentRecord);
        }
    }

    public ArrayList<Student> getListStudentById(String id) {
        ArrayList<Student> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public ArrayList<Student> getListStudentByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentName().toLowerCase().contains(name.toLowerCase())) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public void sortStudentsByName() {
        Collections.sort(list);
    }

    @Override
    public String toString() {
        if (list.isEmpty()) {
            return null;
        }
        String str = String.format("|%5s|%15s|%10s|%15s|\n", "No.", "Student Name",
                "Semester", "Course Name");
        for (int i = 0; i < list.size(); i++) {
            str += String.format("|%5s|%15s|%10s|%15s|\n", i + 1,
                    list.get(i).getStudentName(),
                    list.get(i).getSemester(),
                    list.get(i).getCourseName().getLanguage());
        }
        return str;
    }

    //thay yeu cau sap xep theo ten, Xong xem môn đấy học lại bao nhiêu lần, vào kì nào?
    public String report() {
        if (list.isEmpty()) {
            return "List is empty!";
        }

        // Bước 1: Sắp xếp danh sách gốc theo tên trước khi làm report
        Collections.sort(list, (s1, s2) -> s1.getStudentName().compareToIgnoreCase(s2.getStudentName()));

        // Bước 2: Dùng một Map để lưu trữ kết quả thống kê
        // Key: ID + Course Name (để phân biệt cùng 1 người học nhiều môn khác nhau)
        // Value: Một đối tượng hoặc chuỗi chứa thông tin tổng hợp
        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, String> semesterMap = new HashMap<>();

        for (Student s : list) {
            String key = s.getId() + "|" + s.getCourseName().getLanguage();

            // Đếm số lần học
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);

            // Cộng dồn các kỳ học (ví dụ: "Spring, Summer")
            String sem = s.getSemester();
            if (semesterMap.containsKey(key)) {
                if (!semesterMap.get(key).contains(sem)) {
                    semesterMap.put(key, semesterMap.get(key) + ", " + sem);
                }
            } else {
                semesterMap.put(key, sem);
            }
        }

        // Bước 3: Build chuỗi hiển thị
        String str = String.format("|%-5s|%-20s|%-15s|%-10s|%-20s|\n",
                "No.", "Student Name", "Course", "Total", "Semesters");
        str += "--------------------------------------------------------------------------\n";

        int count = 1;
        // Để in đúng thứ tự đã sắp xếp, ta nên duyệt qua list đã sort thay vì duyệt qua Map
        // Nhưng để tránh trùng lặp dòng khi in, ta dùng một Set để đánh dấu
        List<String> printedKeys = new ArrayList<>();

        for (Student s : list) {
            String key = s.getId() + "|" + s.getCourseName().getLanguage();
            if (!printedKeys.contains(key)) {
                str += String.format("|%-5d|%-20s|%-15s|%-10d|%-20s|\n",
                        count++,
                        s.getStudentName(),
                        s.getCourseName().getLanguage(),
                        countMap.get(key),
                        semesterMap.get(key));
                printedKeys.add(key);
            }
        }
        return str;
    }
}
