/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author win
 */
public class ManageStudent {

    /**
     * Danh sách lưu trữ thông tin các sinh viên.
     */
    private List<Student> list;

    /**
     * Khởi tạo đối tượng ManageStudent với danh sách sinh viên rỗng.
     */
    public ManageStudent() {
        list = new ArrayList<>();
    }

    /**
     * Trả về danh sách sinh viên hiện tại.
     *
     * @return danh sách sinh viên
     */
    public List<Student> getList() {
        return list;
    }

    /**
     * Cập nhật danh sách sinh viên.
     *
     * @param list danh sách sinh viên mới
     */
    public void setList(List<Student> list) {
        this.list = list;
    }

    /**
     * Kiểm tra xem sinh viên đã tồn tại trong danh sách hay chưa. Một bản ghi
     * được xem là trùng khi có cùng ID, Semester và Course.
     *
     * @param student sinh viên cần kiểm tra
     * @return true nếu đã tồn tại, ngược lại false
     */
    public boolean isExisted(Student student) {
        // Duyệt toàn bộ danh sách sinh viên

        for (Student students : list) {
            // Kiểm tra trùng ID, Semester và Course
            if (students.getId().equals(student.getId())
                    && students.getSemester().equals(student.getSemester())
                    && students.getCourseName().equals(student.getCourseName())) {
                return true;
            }
        }
        // Không tìm thấy bản ghi trùng

        return false;
    }

    /**
     * Thêm sinh viên vào danh sách.
     *
     * @param student sinh viên cần thêm
     * @return true nếu thêm thành công
     * @throws Exception nếu bản ghi đã tồn tại
     */
    public boolean add(Student student) throws Exception {
        // Không cho phép thêm bản ghi trùng lặp
        if (isExisted(student)) {
            throw new Exception("This record is existed!");
        }
        // Thêm sinh viên vào danh sách
        return list.add(student);
    }

    /**
     * Xóa một sinh viên khỏi danh sách.
     *
     * @param student sinh viên cần xóa
     * @return true nếu xóa thành công
     * @throws Exception nếu danh sách rỗng hoặc không tìm thấy bản ghi
     */
    public boolean delete(Student student) throws Exception {
        // Kiểm tra danh sách rỗng
        if (list.isEmpty()) {
            throw new Exception("List is empty, can not delete");
        }
        // Kiểm tra bản ghi có tồn tại hay không
        if (!isExisted(student)) {
            throw new Exception("This record can not found!");
        }
        // Xóa sinh viên khỏi danh sách
        return list.remove(student);
    }

    /**
     * Tìm vị trí của một bản ghi trong danh sách.
     *
     * @param student sinh viên cần tìm
     * @return vị trí của bản ghi, -1 nếu không tìm thấy
     */

    private int getIndexRecord(Student student) {
        // Duyệt danh sách để tìm vị trí của bản ghi
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(student)) {
                return i;
            }
        }
        // Không tìm thấy bản ghi
        return -1;
    }

    /**
     * Cập nhật thông tin sinh viên.
     *
     * @param oldStudentRecord bản ghi cũ
     * @param newStudentRecord bản ghi mới
     * @throws Exception nếu danh sách rỗng, không tìm thấy bản ghi hoặc bản ghi
     * mới bị trùng lặp
     */

    public void update(Student oldStudentRecord, Student newStudentRecord) throws Exception {
        // Kiểm tra danh sách rỗng
        if (list.isEmpty()) {
            throw new Exception("List is empty can not update");
        }
        // Kiểm tra bản ghi cũ có tồn tại hay không
        if (!isExisted(oldStudentRecord)) {
            throw new Exception("This record can not found!");
        } else {
            // Kiểm tra bản ghi mới có bị trùng không
            if (isExisted(newStudentRecord)) {
                throw new Exception("New record be duplicate!!");
            }
            // Thay thế bản ghi cũ bằng bản ghi mới
            list.set(getIndexRecord(oldStudentRecord), newStudentRecord);
        }
    }

    /**
     * Lấy danh sách sinh viên theo ID.
     *
     * @param id mã sinh viên cần tìm
     * @return danh sách sinh viên có cùng ID
     */
    public ArrayList<Student> getListStudentById(String id) {
        ArrayList<Student> result = new ArrayList<>();
        // Tìm tất cả sinh viên có cùng ID
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    /**
     * Lấy danh sách sinh viên theo tên.
     *
     * @param name tên hoặc một phần tên sinh viên
     * @return danh sách sinh viên phù hợp
     */
    public ArrayList<Student> getListStudentByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        // Tìm sinh viên theo tên (không phân biệt hoa thường)
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentName().toLowerCase().contains(name.toLowerCase())) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    /**
     * Sắp xếp danh sách sinh viên theo tên tăng dần.
     */
    public void sortStudentsByName() {
        // Sử dụng compareTo() của lớp Student để sắp xếp
        Collections.sort(list);
    }

    /**
     * Trả về chuỗi biểu diễn danh sách sinh viên dưới dạng bảng.
     *
     * @return thông tin danh sách sinh viên
     */
    @Override
    public String toString() {
        // Kiểm tra danh sách rỗng
        if (list.isEmpty()) {
            return null;
        }
        // Tạo tiêu đề bảng (hiển thị cả cột ID)
        String str = String.format("|%-5s|%-10s|%-20s|%-10s|%-15s|\n",
                "No.", "ID", "Student Name", "Semester", "Course Name");
        for (int i = 0; i < list.size(); i++) {
            str += String.format("|%-5d|%-10s|%-20s|%-10s|%-15s|\n",
                    i + 1,
                    list.get(i).getId(),
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

        // Bước 1: Sắp xếp danh sách gốc theo: Tên chính -> Họ Đệm -> ID -> Môn học
        Collections.sort(list);

        // Bước 2: Build chuỗi hiển thị (có cột ID) và gộp trực tiếp các dòng trùng ID + trùng Môn nằm sát nhau
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("|%-5s|%-10s|%-20s|%-15s|%-10s|%-20s|\n",
                "No.", "ID", "Student Name", "Course", "Total", "Semesters"));
        sb.append("--------------------------------------------------------------------------------------\n");

        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            Student current = list.get(i);
            int total = 1;
            String semesters = current.getSemester();

            // Đếm và gộp luôn các dòng trùng ID + trùng Môn nằm ngay bên dưới
            while (i + 1 < list.size()
                    && list.get(i + 1).getId().equalsIgnoreCase(current.getId())
                    && list.get(i + 1).getCourseName() == current.getCourseName()) {
                total++;
                String nextSem = list.get(i + 1).getSemester();
                if (!semesters.contains(nextSem)) {
                    semesters += ", " + nextSem;
                }
                i++; // Nhảy qua dòng đã gộp
            }

            sb.append(String.format("|%-5d|%-10s|%-20s|%-15s|%-10d|%-20s|\n",
                    count++,
                    current.getId(),
                    current.getStudentName(),
                    current.getCourseName().getLanguage(),
                    total,
                    semesters));
        }
        return sb.toString();
    }
}
