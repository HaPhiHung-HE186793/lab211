package entity;

public class Worker1 {
    private String code;
    private String name;
    private int age;
    private int salary;
    private String workLocal;

    public Worker1(String code, String name, int age, int salary, String workLocal) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocal = workLocal;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorkLocal() {
        return workLocal;
    }

    public void setWorkLocal(String workLocal) {
        this.workLocal = workLocal;
    }
}
