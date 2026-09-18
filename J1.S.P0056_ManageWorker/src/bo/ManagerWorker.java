/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.SalaryStatus;
import entity.Worker;
import java.util.ArrayList;
import java.util.List;

/**
 * Lop quan ly danh sach cong nhan.
 *
 * Chuc nang: - Them cong nhan moi. - Kiem tra cong nhan ton tai. - Tim cong
 * nhan theo ma. - Tang hoac giam luong cong nhan.
 *
 * @author win
 */
public class ManagerWorker {

    /**
     * Danh sach cong nhan.
     */
    private List<Worker> list;

    /**
     * Tra ve ban sao cua danh sach cong nhan.
     *
     * @return danh sach cong nhan
     */
    public List<Worker> getList() {
        return new ArrayList<>(list);
    }

    /**
     * Khoi tao danh sach cong nhan rong.
     */
    public ManagerWorker() {
        this.list = new ArrayList<>();
    }

    /**
     * Tim cong nhan theo ma.
     *
     * @param id ma cong nhan can tim
     * @return doi tuong Worker neu tim thay, nguoc lai tra ve null
     */
    private Worker getWorker(String id) {
        // yeu cau: Tim va tra ve doi tuong Worker co ma trung voi id can tim.
        // cach lam: Duyet qua tung phan tu trong danh sach, so sanh id khong phan biet
        // chu hoa/thuong bang equalsIgnoreCase(). Neu tim thay thi tra ve ngay, khong
        // tim thay thi tra ve null sau khi duyet het danh sach.
        
        // Duyet danh sach de tim cong nhan theo ma
        for (Worker workers : list) {
            // So sanh khong phan biet chu hoa chu thuong
            if (workers.getId().equalsIgnoreCase(id)) {
                return workers;
            }
        }
        return null;
    }

    /**
     * Kiem tra ma cong nhan da ton tai hay chua.
     *
     * @param id ma cong nhan can kiem tra
     * @return true neu ton tai, nguoc lai false
     */
    public boolean isExist(String id) {
    // yeu cau: Kiem tra xem mot ma cong nhan da ton tai trong danh sach hay chua.
    // cach lam: Duyet toan bo danh sach, so sanh id cua tung Worker (khong phan biet
    // hoa thuong) voi id can kiem tra. Tim thay thi tra ve true, het danh sach ma
    // khong thay thi tra ve false.
    
    for (Worker workers : list) {
        if (workers.getId().equalsIgnoreCase(id)) {
            return true;
        }
    }
    return false;
}

    /**
     * Them cong nhan moi vao danh sach.
     *
     * @param worker cong nhan can them
     * @return true neu them thanh cong
     * @throws Exception neu ma cong nhan da ton tai
     */
    public boolean add(Worker worker) throws Exception {
        // yeu cau: Them mot cong nhan moi vao danh sach, dam bao khong bi trung ma.
        // cach lam: Goi isExist() de kiem tra ma cong nhan da co chua. Neu da ton tai
        // thi nem Exception, nguoc lai them worker vao list va tra ve ket qua cua add().
        
        // Kiem tra ma cong nhan da ton tai
        if (isExist(worker.getId())) {
            throw new Exception("Worker with ID " + worker.getId() + " already exists.");
        }
        // Them cong nhan vao danh sach
        return list.add(worker);
    }

    /**
     * Thay doi luong cua cong nhan.
     *
     * Neu trang thai la UP thi cong them luong. Neu trang thai la DOWN thi tru
     * luong.
     *
     * @param status trang thai thay doi luong (UP hoac DOWN)
     * @param code ma cong nhan
     * @param amount so tien thay doi
     * @return cong nhan sau khi cap nhat luong
     * @throws Exception neu khong tim thay cong nhan, so tien khong hop le hoac
     * luong sau khi giam nho hon 0
     */
    public Worker changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        // yeu cau: Tang hoac giam luong cua mot cong nhan dua theo trang thai (UP/DOWN).
        // cach lam: Kiem tra ma cong nhan co ton tai khong, kiem tra so tien thay doi
        // phai > 0. Lay doi tuong Worker tuong ung, dung switch-case theo status:
        // UP thi cong them amount vao luong; DOWN thi tru amount nhung phai kiem tra
        // luong sau khi tru khong duoc am, neu am thi nem Exception. Cuoi cung tra ve
        // Worker sau khi da cap nhat.
        
        // Kiem tra ma cong nhan co ton tai hay khong

        if (!isExist(code)) {
            throw new Exception("Can not found code!");
        }
        // Kiem tra so tien thay doi phai lon hon 0
        if (amount <= 0) {
            throw new Exception("Amount of money must be > 0 ");
        }
        // Lay cong nhan can cap nhat luong
        Worker worker = getWorker(code);
        switch (status) {
            // Tang luong
            case UP:
                worker.setSalary(worker.getSalary() + amount);
                break;
            // Giam luong
            case DOWN:
                if (worker.getSalary() - amount < 0) {
                    throw new Exception("Can not down " + amount);
                }
                worker.setSalary(worker.getSalary() - amount);
                break;
        }
        // Tra ve cong nhan sau khi cap nhat
        return worker;
    }

}