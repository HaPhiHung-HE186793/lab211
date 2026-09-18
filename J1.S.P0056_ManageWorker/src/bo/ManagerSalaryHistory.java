/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;
import entity.SalaryHistory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Lop quan ly danh sach lich su thay doi luong cua cong nhan.
 *
 * Chuc nang: - Them lich su tang/giam luong. - Kiem tra lich su da ton tai. -
 * Sap xep lich su theo ma cong nhan. - Hien thi danh sach lich su luong.
 *
 * @author win
 */
public class ManagerSalaryHistory {
    /**
     * Danh sach luu lich su thay doi luong.
     */
    private List<SalaryHistory> list;
    /**
     * Khoi tao danh sach lich su rong.
     */
    public ManagerSalaryHistory() {
        this.list = new ArrayList<>();
    }
    /**
     * Kiem tra mot ban ghi lich su da ton tai hay chua.
     *
     * Hai ban ghi duoc xem la trung nhau khi: - Cung ma cong nhan. - Cung trang
     * thai (UP/DOWN). - Cung ngay cap nhat. - Cung muc luong sau cap nhat.
     *
     * @param history ban ghi can kiem tra
     * @return true neu ban ghi da ton tai, nguoc lai false
     */
    private boolean isExisted(SalaryHistory history) {
        // yeu cau: Kiem tra xem mot ban ghi lich su luong da ton tai trong danh sach chua,
        // de tranh them trung lap.
        // cach lam: Duyet toan bo danh sach, so sanh tung ban ghi voi ban ghi can kiem tra
        // dua tren 4 tieu chi: ma cong nhan, trang thai (UP/DOWN), ngay cap nhat va
        // muc luong sau cap nhat. Neu tim thay ban ghi khop ca 4 tieu chi thi tra ve true.
        
        // Duyet danh sach lich su hien co
        for (SalaryHistory salaryHistory : list) {
            // Kiem tra ban ghi trung hoan toan
            if (salaryHistory.getWorker().getId().equalsIgnoreCase(history.getWorker().getId())
                    && salaryHistory.getStatus().equals(history.getStatus())
                    && salaryHistory.getDate().equals(history.getDate())
                    && salaryHistory.getSalaryUpdate() == history.getSalaryUpdate()) {
                return true;
            }
        }
        return false;
    }
    /**
     * Them mot ban ghi lich su luong vao danh sach.
     *
     * @param history ban ghi lich su can them
     * @return true neu them thanh cong
     * @throws Exception neu ban ghi da ton tai
     */
    public boolean addSalaryHistory(SalaryHistory history) throws Exception {
        // yeu cau: Them mot ban ghi lich su luong moi vao danh sach.
        // cach lam: Goi isExisted() de kiem tra trung lap truoc. Neu da ton tai
        // thi nem Exception, nguoc lai them ban ghi vao list va tra ve ket qua cua add().
        
        if (isExisted(history)) {
            throw new Exception("This record history is existed!!!");
        }
        return list.add(history);
    }
    /**
     * Sap xep danh sach lich su theo ma cong nhan.
     */
    private void sortByID() {
        // yeu cau: Sap xep danh sach lich su luong theo ma cong nhan.
        // cach lam: Dung Collections.sort(), dua vao Comparable da duoc
        // cai dat trong lop SalaryHistory (hoac Worker) de xac dinh thu tu sap xep.
        
        Collections.sort(list);
    }
    /**
     * Tra ve chuoi chua toan bo lich su thay doi luong.
     *
     * Danh sach se duoc sap xep theo ma cong nhan truoc khi hien thi.
     *
     * @return chuoi lich su luong hoac null neu danh sach rong
     */
    @Override
    public String toString() {
        // yeu cau: Tao chuoi hien thi toan bo lich su thay doi luong duoi dang bang.
        // cach lam: Neu danh sach rong tra ve null. Nguoc lai, goi sortByID() de sap xep
        // truoc, dung SimpleDateFormat de format ngay thang, sau do dung String.format()
        // de can chinh cac cot (ma, ten, tuoi, luong, trang thai, ngay) va noi chuoi lai.
        
        if (list.isEmpty()) {
            return null;
        }
        sortByID();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str = String.format("%7s%10s%10s%10s%10s%15s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (int i = 0; i < list.size(); i++) {
            String formattedDate = dateFormat.format(list.get(i).getDate());
            str += String.format("%7s%10s%10d%10.0f%10s%15s\n", list.get(i).getWorker().getId(),
                    list.get(i).getWorker().getName(), list.get(i).getWorker().getAge(),
                    list.get(i).getSalaryUpdate(), list.get(i).getStatus(), formattedDate);
        }
        return str;
    }
}