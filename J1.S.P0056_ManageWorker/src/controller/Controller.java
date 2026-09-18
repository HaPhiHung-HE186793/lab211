/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.ManagerSalaryHistory;
import bo.ManagerWorker;
import entity.SalaryHistory;
import entity.SalaryStatus;
import entity.Worker;
import java.util.Date;
import utils.Validator;

/**
 * Lop dieu khien chinh cua chuong trinh.
 *
 * Chuc nang: - Them cong nhan. - Tang luong cong nhan. - Giam luong cong nhan.
 * - Hien thi lich su thay doi luong.
 *
 * @author win
 */
public class Controller {

    /**
     * Quan ly lich su thay doi luong.
     */
    private ManagerSalaryHistory salaryHistory;
    /**
     * Quan ly danh sach cong nhan.
     */
    private ManagerWorker workers;

    /**
     * Khoi tao cac doi tuong quan ly.
     */
    public Controller() {
        this.salaryHistory = new ManagerSalaryHistory();
        this.workers = new ManagerWorker();
    }

    /**
     * Nhap thong tin va them cong nhan moi.
     *
     * @return cong nhan vua duoc them
     * @throws Exception neu them that bai hoac du lieu khong hop le
     */
    public Worker addWorker() throws Exception {
        // yeu cau: Nhap thong tin tu ban phim va them mot cong nhan moi vao danh sach.
        // cach lam: Lap lai viec nhap id cho den khi id chua ton tai (dung regex de
        // xac thuc dinh dang, chuyen thanh chu hoa). Sau do nhap lan luot ten, tuoi
        // (18-50), luong (>0), noi lam viec, tao doi tuong Worker roi goi workers.add()
        // de them vao danh sach.
        
        // Nhap ma cong nhan va chuyen thanh chu hoa
        String id;
        do {
            id = Validator.getString(
                    "Enter id: ",
                    "Invalid!",
                    "[Ww]\\d+").toUpperCase();

            if (!workers.isExist(id)) {
                break;
            }
            System.out.println("Worker with ID " + id + " already exists. Please input again");
        } while (true);
        // Nhap ten cong nhan
        String name = Validator.getString("Enter Name: ", "Invalid!", "[A-Za-z\\s]+");
        // Nhap tuoi tu 18 den 50
        int age = Validator.getInt("Enter age: ", "age >= 18 and <=50 !", "Invalid!", 18, 50);
        // Nhap luong lon hon 0
        double salary = Validator.getDouble("Enter Salary: ", "salary must be > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
        // Nhap noi lam viec
        String workLocation = Validator.getString("Enter work location: ", "Invalid!", "[A-Za-z0-9\\s]+");
        // Tao doi tuong cong nhan
        Worker worker = new Worker(id, name, age, salary, workLocation);
        // Them cong nhan vao danh sach
        if (workers.add(worker)) {
            return worker;
        }
        throw new Exception("Add fail");
    }

    /**
     * Tang luong cho cong nhan.
     *
     * @return cong nhan sau khi tang luong
     * @throws Exception neu danh sach rong hoac du lieu khong hop le
     */
    public Worker upSalary() throws Exception {
        // yeu cau: Tang luong cho mot cong nhan va luu lai lich su thay doi.
        // cach lam: Kiem tra danh sach cong nhan co rong khong, nhap ma cong nhan va
        // so tien can tang, goi workers.changeSalary() voi trang thai UP de cap nhat
        // luong, sau do tao mot ban ghi SalaryHistory moi va luu vao salaryHistory.
        
        // Kiem tra danh sach cong nhan
        if (workers.getList().isEmpty()) {
            throw new Exception("List is empty!");
        }
        // Nhap ma cong nhan
        String code = Validator.getString("Enter id: ", "Invalid!", "[Ww]\\d+");
        // Nhap so tien tang
        double amount = Validator.getDouble("Enter Salary: ", "salary must be > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
        // Cap nhat luong
        Worker worker = workers.changeSalary(SalaryStatus.UP, code, amount);
        // Luu lich su tang luong
        if (salaryHistory.addSalaryHistory(new SalaryHistory(worker, worker.getSalary(), SalaryStatus.UP, new Date()))) {
            return worker;
        }
        throw new Exception("Can not up salary");
    }

    /**
     * Giam luong cho cong nhan.
     *
     * @return cong nhan sau khi giam luong
     * @throws Exception neu danh sach rong hoac du lieu khong hop le
     */
    public Worker downSalary() throws Exception {
        // yeu cau: Giam luong cho mot cong nhan, dam bao luong sau khi giam khong bi am,
        // va luu lai lich su thay doi.
        // cach lam: Kiem tra danh sach rong, nhap ma cong nhan va tim doi tuong Worker
        // hien tai de lay luong lam moc so sanh. Sau do lap lai viec nhap so tien giam
        // va goi workers.changeSalary() voi trang thai DOWN; neu so tien giam lon hon
        // luong hien tai (bat Exception "Can not down") thi bao loi va nhap lai, cac loi
        // khac thi nem tiep ra ngoai. Khi thanh cong, luu ban ghi SalaryHistory moi.
        
        // Kiem tra danh sach cong nhan
        if (workers.getList().isEmpty()) {
            throw new Exception("List is empty!");
        }
        // Nhap ma cong nhan
        String code = Validator.getString(
                "Enter id: ",
                "Invalid!",
                "[Ww]\\d+");

// Lay cong nhan hien tai de lay luong hien tai
        Worker currentWorker = null;

        for (Worker w : workers.getList()) {
            if (w.getId().equalsIgnoreCase(code)) {
                currentWorker = w;
                break;
            }
        }

        if (currentWorker == null) {
            throw new Exception("Can not found code!");
        }

// Khai bao worker de dung ben ngoai vong lap
        Worker worker;

        while (true) {

            // Nhap so tien giam
            double amount = Validator.getDouble(
                    "Enter Salary: ",
                    "salary must be > 0",
                    "Invalid!",
                    Double.MIN_VALUE,
                    Double.MAX_VALUE);

            try {
                // Cap nhat luong
                worker = workers.changeSalary(
                        SalaryStatus.DOWN,
                        code,
                        amount);
                break;
            } catch (Exception ex) {
                // Neu so tien giam lon hon luong hien tai thi nhap lai
                if (ex.getMessage().startsWith("Can not down")) {
                    System.out.println(
                            "Amount must be smaller than current salary ("
                            + currentWorker.getSalary() + ")!"
                    );
                } else {
                    throw ex;
                }
            }
        }
        // Luu lich su giam luong
        if (salaryHistory.addSalaryHistory(new SalaryHistory(worker, worker.getSalary(), SalaryStatus.DOWN, new Date()))) {
            return worker;
        }
        throw new Exception("Can not down salary");
    }

    /**
     * Hien thi lich su thay doi luong.
     */
    public void showHistorySalary() {
        // yeu cau: Hien thi toan bo lich su thay doi luong ra man hinh.
        // cach lam: Goi salaryHistory.toString() de lay chuoi da format, neu ket qua
        // null (danh sach rong) thi in thong bao "History Salary is empty", nguoc lai
        // in chuoi ket qua ra man hinh.
        
        // Lay chuoi lich su da duoc format

        String result = salaryHistory.toString();
        if (result == null) {
            // Kiem tra lich su co du lieu hay khong
            System.out.println("History Salary is empty");
        } else {
            System.out.println(result);
        }
    }
}