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
     * Lấy từ cuối cùng (Tên chính) trong chuỗi Họ và Tên.
     *
     * @param fullName chuỗi họ tên đầy đủ
     * @return tên chính (từ cuối cùng)
     */
    private String getFirstName(String fullName) {
        String[] words = fullName.trim().split("\\s+");
        return words[words.length - 1];
    }

    /**
     * So sánh hai sinh viên theo thứ tự ưu tiên:
     * 1. Tên chính (từ cuối cùng).
     * 2. Cả chuỗi Họ + Đệm + Tên.
     * 3. Mã sinh viên (ID) để gom cùng 1 sinh viên lại với nhau.
     * 4. Môn học (CourseName) để gom các môn học giống nhau của cùng 1 sinh viên đứng sát nhau.
     *
     * @param t sinh viên cần so sánh
     * @return giá trị so sánh
     */
    @Override
    public int compareTo(Student t) {
        // 1. So sánh Tên chính (từ cuối cùng)
        int firstNameCompare = getFirstName(this.studentName)
                .compareToIgnoreCase(getFirstName(t.studentName));
        if (firstNameCompare != 0) {
            return firstNameCompare;
        }
        // 2. Nếu trùng Tên chính -> So sánh cả Họ + Đệm + Tên
        int fullNameCompare = this.studentName.compareToIgnoreCase(t.studentName);
        if (fullNameCompare != 0) {
            return fullNameCompare;
        }
        // 3. Nếu trùng cả Họ Tên -> Gom nhóm theo ID (S1 đi liền với S1)
        int idCompare = this.id.compareToIgnoreCase(t.id);
        if (idCompare != 0) {
            return idCompare;
        }
        // 4. Nếu cùng ID -> Gom các môn giống nhau của ID đó đứng sát nhau
        return this.courseName.compareTo(t.courseName);
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
