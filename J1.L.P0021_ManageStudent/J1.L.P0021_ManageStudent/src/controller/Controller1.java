package controller;

import bo.ManagerStudent1;
import entity.Course;
import entity.Student;
import utils.Validator;

import java.util.List;

public class Controller1 {
    private ManagerStudent1 managerStudent1;

    public Controller1() {
        this.managerStudent1 = new ManagerStudent1();
    }


    public void create() throws Exception {
       do{ String id = Validator.getString("id: ", "Invalid", ".*");
        Student student = managerStudent1.getStudentByID(id);
        String name;
        if (student == null) {
            name = Validator.getString("name: ", "Invalid", ".*");
        } else {
            name = student.getStudentName();
            System.out.println("Name: " + name);
        }
        String semester = Validator.getString("semester: ", "Invalid", ".*");
        int choice = Validator.getInt("Only three courses:\n"
                        + "1-Java\n"
                        + "2-.Net\n"
                        + "3-C/C++\n"
                        + "Enter your choice:",
                "Please enter number 1->3", "Invalid", 1, 3);
        Course course = Course.getCourse(choice);
        ;

         Student student1 =  new Student(id, name, semester, course) ;

        if ( managerStudent1.isExisted(student1)) {
            System.out.println("Student already exists!");
        }
        else if (!managerStudent1.addStudent(student1)) {
            throw new Exception("Can not create Student!");
        }

        if (managerStudent1.getStudents().size() > 10) {
            String option = Validator.getString("Do you continue ( Y or N)? ", "Just Y or N", "[YNyn]");
            if ( (option.equalsIgnoreCase("N"))) {
                break;
            }
        }
    }while (true);
    }

    public void findAndSort() throws Exception {
        String id = Validator.getString("name: ", "Invalid", ".*");
        List<Student> students = managerStudent1.getListStudentByName(id);
        if (students.isEmpty()) {
            throw new Exception("Can not update Student!");
        }
        ManagerStudent1 managerStudent2 = new ManagerStudent1();
        managerStudent2.setStudents(students);
        managerStudent2.sortStudentsByName();
        System.out.println(managerStudent2.toString());
    }

    public void update() throws Exception {
            String id = Validator.getString("id: ", "Invalid", ".*");
            List<Student> students = managerStudent1.getListStudentByID(id);
            if (students.isEmpty()) {
                throw new Exception("Can not update Student!");
            }

        ManagerStudent1 managerStudent2 = new ManagerStudent1();
        managerStudent2.setStudents(students);
        System.out.println(managerStudent2.toString());
            int choiceRecord = Validator.getInt("Enter record your choice: ", "Just be 1-> " + students.size(),
                    "Invalid!", 1, students.size());
            Student student = students.get(choiceRecord-1);

            System.out.println(student);
            String choose = Validator.getString("Do you want Update(U) or Delete(D): ",
                    "Just U or D", "[UDud]");
            if (choose.equalsIgnoreCase("U")) {
                String semester = Validator.getString("semester: ", "Invalid", ".*");
                int choice = Validator.getInt("Only three courses:\n"
                                + "1-Java\n"
                                + "2-.Net\n"
                                + "3-C/C++\n"
                                + "Enter your choice:",
                        "Please enter number 1->3", "Invalid", 1, 3);
                Course course = Course.getCourse(choice);

                Student student1 =  new Student(student.getId(), student.getStudentName(), semester, course) ;

                if ( managerStudent1.isExisted(student1)) {
                    System.out.println("Student already exists!");
                } else managerStudent1.updateStutent(student,student1);

            } else if (choose.equalsIgnoreCase("D")) {
                managerStudent1.removeStudent(student);
            }
    }

    public void report() throws Exception {
        String result = managerStudent1.report();
        if (result == null) {
            throw new Exception("List is empty!");
        }
        // Hiển thị báo cáo
        System.out.println(result);
    }




    public void generateStudent() {
        managerStudent1.addStudent(new Student("s1", "Nguyen Quan", "Fall2023", Course.JAVA));
        managerStudent1.addStudent(new Student("s9", "Nguyen Quan", "Fall2023", Course.JAVA)); // Cùng tên Nguyen Quan nhưng ID là s9 xen giữa!
        managerStudent1.addStudent(new Student("s1", "Nguyen Quan", "Fall2023", Course.C_CPP));
        managerStudent1.addStudent(new Student("s1", "Nguyen Quan", "Fall2023", Course.DOT_NET));
        managerStudent1.addStudent(new Student("s8", "Vu Quan", "Fall2023", Course.DOT_NET));
        managerStudent1.addStudent(new Student("s2", "Tran Linh", "Sum2024", Course.JAVA));
        managerStudent1.addStudent(new Student("s2", "Tran Linh", "Sum2024", Course.DOT_NET));
        managerStudent1.addStudent(new Student("s3", "Le Thu Thao", "Sum2024", Course.JAVA));
        managerStudent1.addStudent(new Student("s4", "Le Phuong Minh", "Sum2024", Course.DOT_NET));
        managerStudent1.addStudent(new Student("s5", "Minh Vu", "Spring2023", Course.JAVA));
        managerStudent1.addStudent(new Student("s1", "Nguyen Quan", "Fall2024", Course.JAVA)); // s1 học lại JAVA nằm tít bên dưới!
        managerStudent1.addStudent(new Student("s6", "Tuan Minh", "Spring2023", Course.C_CPP));
        managerStudent1.addStudent(new Student("s7", "Quang Vu", "Fall2023", Course.DOT_NET));
        managerStudent1.addStudent(new Student("s9", "Nguyen Quan", "Spring2024", Course.JAVA)); // s9 học lại JAVA nằm ở cuối!
        managerStudent1.addStudent(new Student("s8", "Vu Quan", "Fall2024", Course.DOT_NET));
    }
}
