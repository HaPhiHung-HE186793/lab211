package bo;

import entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManagerStudent1 {
    private List<Student> students;

    public ManagerStudent1() {
        this.students = new ArrayList<Student>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean addStudent(Student student) {
        return this.students.add(student);
    }

    public boolean removeStudent(Student student) {
        return this.students.remove(student);
    }

    public List<Student> getListStudentByID(String id) {
        List<Student> result = new ArrayList<>();
        for(Student student : students) {
            if(student.getId().equals(id)){
                result.add(student);
            }
        }
        return result;
    }

    public int getIndexStudent(Student student) {
        for(int i = 0; i < students.size(); i++) {
            if(students.get(i).equals(student)){
                return i;
            }
        }
        return -1;
    }

    public Student getStudentByID(String id) {
        for(Student student : students) {
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    public List<Student> getListStudentByName(String id) {
        List<Student> result = new ArrayList<>();
        for(Student student : students) {
            if(student.getStudentName().toLowerCase().contains(id.toLowerCase())){
                result.add(student);
            }
        }
        return result;
    }

    public void sortStudentsByName() {
        // Sử dụng compareTo() của lớp Student để sắp xếp
        Collections.sort(students);
    }

    public void updateStutent(Student studentOld, Student studentNew) {
        students.set(getIndexStudent(studentOld), studentNew);
    }

    public boolean isExisted(Student student) {
        // Duyệt toàn bộ danh sách sinh viên

        for (Student students : students) {
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

    public String toString() {
        if(students.isEmpty()){
            return "No students found";
        }

        sortStudentsByName();

        String str = String.format("|%-10s|%-15s|%-10s|%-20s|\n","ID","Student Name","Course","Semester");
        str += "------------------------------------------------------------\n";

        for(int i =0 ; i < students.size() ; i++){
            str += String.format("|%-10s|%-15s|%-10s|%-20s|\n",students.get(i).getId(),students.get(i).getStudentName(),students.get(i).getCourseName().getLanguage(), students.get(i).getSemester());
        }

        return str;
    }


    public String report(){
        if(students.isEmpty()){
            return "No students found";
        }

        sortStudentsByName();

        String str = String.format("|%-10s|%-15s|%-10s|%-10s|%-20s|\n","ID","Student Name","Course","Total","Semester");
        str += "------------------------------------------------------------\n";

        for(int i =0 ; i < students.size() ; i++){
            int total = 1;
            String semester = students.get(i).getSemester();
            while (i < students.size()){
                if(i+1 < students.size() && students.get(i).getId().equals(students.get(i+1).getId())
                && students.get(i).getCourseName().equals(students.get(i+1).getCourseName())){
                    semester +=", " + students.get(i+1).getCourseName();
                    total++;
                    i++;
                } else break;
            }
            str += String.format("|%-10s|%-15s|%-10s|%-10s|%-20s|\n",students.get(i).getId(),students.get(i).getStudentName(),students.get(i).getCourseName().getLanguage(),total,semester);
        }

        return str;
    }
}
