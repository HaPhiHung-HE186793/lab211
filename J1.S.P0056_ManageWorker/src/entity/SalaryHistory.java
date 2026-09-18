/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.Date;
/**
 * Lop luu thong tin lich su thay doi luong cua cong nhan.
 *
 * Moi ban ghi lich su gom: - Cong nhan duoc cap nhat luong. - Muc luong sau khi
 * cap nhat. - Trang thai thay doi (UP hoac DOWN). - Thoi gian thuc hien thay
 * doi.
 *
 * @author win
 */
public class SalaryHistory implements Comparable<SalaryHistory>, Serializable {
    /**
     * Cong nhan duoc thay doi luong. Muc luong sau khi cap nhat. Trang thai
     * thay doi luong (UP/DOWN). Ngay thuc hien thay doi luong.
     */
    private Worker worker;
    private double salaryUpdate;
    private SalaryStatus status;
    private Date date;
    /**
     * Khoi tao mot ban ghi lich su luong.
     *
     * @param worker cong nhan duoc cap nhat
     * @param salaryUpdate muc luong sau khi cap nhat
     * @param status trang thai UP hoac DOWN
     * @param date ngay thuc hien
     * @throws Exception neu du lieu khong hop le
     */
    public SalaryHistory(Worker worker, double salaryUpdate, SalaryStatus status, Date date) throws Exception {
        // yeu cau: Khoi tao mot ban ghi lich su luong voi day du thong tin can thiet.
        // cach lam: Goi lan luot cac setter (setWorker, setSalaryUpdate, setStatus,
        // setDate) de gan gia tri, dong thoi tan dung viec xac thuc du lieu da co san
        // trong tung setter (nem Exception neu du lieu khong hop le).
        
        setWorker(worker);
        setSalaryUpdate(salaryUpdate);
        setStatus(status);
        setDate(date);
    }
    public Worker getWorker() {
        return worker;
    }
    /**
     * Thiet lap cong nhan cho ban ghi lich su.
     *
     * @param worker cong nhan can luu
     * @throws Exception neu worker bang null
     */
    public void setWorker(Worker worker) throws Exception {
        // yeu cau: Gan cong nhan cho ban ghi lich su, dam bao khong duoc null.
        // cach lam: Kiem tra worker khac null thi gan gia tri, nguoc lai nem Exception.
        
        if (worker != null) {
            this.worker = worker;
        } else {
            throw new Exception("Worker can not null!");
        }
    }
    public SalaryStatus getStatus() {
        return status;
    }
    /**
     * Thiet lap trang thai thay doi luong.
     *
     * @param status trang thai UP hoac DOWN
     * @throws Exception neu status bang null
     */
    public void setStatus(SalaryStatus status) throws Exception {
        // yeu cau: Gan trang thai thay doi luong (UP/DOWN), dam bao khong duoc null.
        // cach lam: Kiem tra status khac null thi gan gia tri, nguoc lai nem Exception.
        
        if (status != null) {
            this.status = status;
        } else {
            throw new Exception("Status can not null!");
        }
    }
    public Date getDate() {
        return date;
    }
    /**
     * Thiet lap ngay thay doi luong.
     *
     * @param date ngay thuc hien
     * @throws Exception neu date bang null
     */
    public void setDate(Date date) throws Exception {
        // yeu cau: Gan ngay thuc hien thay doi luong, dam bao khong duoc null.
        // cach lam: Kiem tra date khac null thi gan gia tri, nguoc lai nem Exception.
        
        if (date != null) {
            this.date = date;
        } else {
            throw new Exception("Date can not null!");
        }
    }
    public double getSalaryUpdate() {
        return salaryUpdate;
    }
    /**
     * Thiet lap muc luong sau khi cap nhat.
     *
     * @param salaryUpdate muc luong moi
     * @throws Exception neu luong nho hon 0
     */
    public void setSalaryUpdate(double salaryUpdate) throws Exception {
        // yeu cau: Gan muc luong sau khi cap nhat, dam bao gia tri khong am.
        // cach lam: Kiem tra salaryUpdate >= 0 thi gan gia tri, nguoc lai nem Exception.
        
        if (salaryUpdate >= 0) {
            this.salaryUpdate = salaryUpdate;
        } else {
            throw new Exception("salaryUpdate must be >=0");
        }
    }
    /**
     * So sanh hai ban ghi lich su theo ma cong nhan. Dung de sap xep danh sach
     * lich su.
     *
     * @param o ban ghi lich su can so sanh
     * @return gia tri so sanh theo ma cong nhan
     */
    @Override
    public String toString() {
        // yeu cau: Tra ve chuoi mo ta ngan gon noi dung cua ban ghi lich su luong,
        // phuc vu cho viec in/debug.
        // cach lam: Noi cac truong du lieu (ma cong nhan, muc luong, trang thai, ngay)
        // thanh mot chuoi co dinh dang "SalaryHistory{...}".
        
        return "SalaryHistory{" + worker.getId() + ", " + salaryUpdate + ", " + status + ", " + date + '}';
    }
    @Override
    public int compareTo(SalaryHistory o) {
        // yeu cau: So sanh hai ban ghi lich su de phuc vu sap xep (Collections.sort).
        // cach lam: Dung String.compareTo() de so sanh ma cong nhan (id) cua hai
        // ban ghi theo thu tu tu dien (alphabet).
        
        return worker.getId().compareTo(o.worker.getId());
    }
}