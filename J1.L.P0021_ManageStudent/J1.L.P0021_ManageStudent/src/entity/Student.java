package entity;

/**
 * Lớp Student lưu trữ thông tin của một sinh viên.
 */
public class Student implements Comparable<Student> {

    private String id;
    private String studentName;
    private String semester;
    private Course courseName;

    /**
     * Khởi tạo sinh viên với đầy đủ thông tin.
     *
     * @param id mã sinh viên
     * @param studentName tên sinh viên
     * @param semester học kỳ
     * @param courseName môn học
     */
    public Student(String id, String studentName, String semester, Course courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Course getCourseName() {
        return courseName;
    }

    public void setCourseName(Course courseName) {
        this.courseName = courseName;
    }

    /**
     * So sánh hai sinh viên theo tên để phục vụ sắp xếp.
     *
     * @param t sinh viên cần so sánh
     * @return giá trị so sánh theo tên
     */
    @Override
    public int compareTo(Student t) {
        return this.studentName.compareTo(t.studentName);
    }

    /**
     * Trả về chuỗi biểu diễn thông tin sinh viên.
     *
     * @return thông tin sinh viên dưới dạng chuỗi
     */
    @Override
    public String toString() {
        return "Student{" + id + ", " + studentName + ", " + semester + ", " + courseName.getLanguage() + '}';
    }

}
