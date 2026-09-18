/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 * Lop luu thong tin cua mot cong nhan.
 *
 * Moi cong nhan gom: - Ma cong nhan. - Ho ten. - Tuoi. - Luong hien tai. - Noi
 * lam viec.
 *
 * @author win
 */
public class Worker implements Serializable {

    /**
     * Ma cong nhan. Ten cong nhan. Tuoi cong nhan. Luong hien tai. Noi lam
     * viec.
     */
    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLocation;

    /**
     * Khoi tao mot cong nhan moi.
     *
     * @param id ma cong nhan
     * @param name ten cong nhan
     * @param age tuoi cong nhan
     * @param salary luong hien tai
     * @param workLocation noi lam viec
     * @throws Exception neu du lieu khong hop le
     */
    public Worker(String id, String name, int age,
            double salary, String workLocation) throws Exception {
        // yeu cau: Khoi tao mot doi tuong Worker moi voi day du thong tin.
        // cach lam: Goi lan luot cac setter (setId, setName, setAge, setSalary,
        // setWorkLocation) de gan gia tri, tan dung viec xac thuc du lieu da co san
        // trong tung setter (nem Exception neu du lieu khong hop le).
        
        setId(id);
        setName(name);
        setAge(age);
        setSalary(salary);
        setWorkLocation(workLocation);
    }

    public String getId() {
        return id;
    }

    /**
     * Thiet lap ma cong nhan.
     *
     * Ma phai co dang W theo sau la cac chu so.
     *
     * @param id ma cong nhan
     * @throws Exception neu ma khong dung dinh dang
     */
    private void setId(String id) throws Exception {
        // yeu cau: Gan ma cong nhan, dam bao dung dinh dang "W" theo sau la cac chu so.
        // cach lam: Dung Regex "W\\d+" de kiem tra dinh dang, hop le thi gan gia tri,
        // sai thi nem Exception.
        
        if (id.matches("W\\d+")) {
            this.id = id;
        } else {
            throw new Exception("ID must be Wx (x is digit)");
        }
    }

    public String getName() {
        return name;
    }

    /**
     * Thiet lap ten cong nhan.
     *
     * @param name ten cong nhan
     * @throws Exception neu ten chua ky tu khong hop le
     */
    public void setName(String name) throws Exception {
        // yeu cau: Gan ten cong nhan, chi cho phep chu cai va khoang trang.
        // cach lam: Dung Regex "[A-Za-z\\s]+" de kiem tra dinh dang, hop le thi gan
        // gia tri, sai thi nem Exception.
        
        if (name.matches("[A-Za-z\\s]+")) {
            this.name = name;
        } else {
            throw new Exception("Name must be alphabetic and space!");
        }
    }

    public int getAge() {
        return age;
    }

    /**
     * Thiet lap tuoi cong nhan.
     *
     * Tuoi phai nam trong khoang tu 18 den 50.
     *
     * @param age tuoi cong nhan
     * @throws Exception neu tuoi khong hop le
     */
    public void setAge(int age) throws Exception {
        // yeu cau: Gan tuoi cong nhan, dam bao nam trong khoang [18, 50].
        // cach lam: Kiem tra dieu kien age >= 18 va age <= 50, hop le thi gan gia tri,
        // sai thi nem Exception.
        
        if (age >= 18 && age <= 50) {
            this.age = age;
        } else {
            throw new Exception("Age must be 18->50");
        }
    }

    public double getSalary() {
        return salary;
    }

    /**
     * Thiet lap luong cong nhan.
     *
     * @param salary luong hien tai
     * @throws Exception neu luong nho hon 0
     */
    public void setSalary(double salary) throws Exception {
        // yeu cau: Gan luong cong nhan, dam bao gia tri khong am.
        // cach lam: Kiem tra salary >= 0, hop le thi gan gia tri, sai thi nem Exception.
        
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new Exception("Salary must be >=0");
        }
    }

    public String getWorkLocation() {
        return workLocation;
    }

    /**
     * Thiet lap noi lam viec.
     *
     * Chi cho phep chu cai, chu so va khoang trang.
     *
     * @param workLocation noi lam viec
     * @throws Exception neu du lieu khong hop le
     */
    public void setWorkLocation(String workLocation) throws Exception {
        // yeu cau: Gan noi lam viec, chi cho phep chu cai, chu so va khoang trang.
        // cach lam: Dung Regex "[A-Za-z0-9\\s]+" de kiem tra dinh dang, hop le thi
        // gan gia tri, sai thi nem Exception.
        
        if (workLocation.matches("[A-Za-z0-9\\s]+")) {
            this.workLocation = workLocation;
        } else {
            throw new Exception("Location must be alphabet,digit or space!");
        }
    }

    /**
     * Tra ve thong tin cong nhan duoi dang chuoi.
     *
     * @return thong tin cong nhan
     */
    @Override
    public String toString() {
        // yeu cau: Tra ve chuoi mo ta ngan gon toan bo thong tin cua cong nhan,
        // phuc vu cho viec in/debug.
        // cach lam: Noi cac truong du lieu (id, ten, tuoi, luong, noi lam viec)
        // thanh mot chuoi co dinh dang "Worker{...}".
        
        return "Worker{" + id + ", " + name + ", " + age + ", " + salary + ", " + workLocation + '}';
    }

}