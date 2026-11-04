package bo;

import entity.HistorySalary1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManagerHistorySalary1 {
    private List<HistorySalary1> historySalary1;

    public ManagerHistorySalary1() {
        this.historySalary1 = new ArrayList<>();
    }

    public boolean addHistorySalary(HistorySalary1 hs) {
        return this.historySalary1.add(hs);
    }



    private void sortByID() {
        // yeu cau: Sap xep danh sach lich su luong theo ma cong nhan.
        // cach lam: Dung Collections.sort(), dua vao Comparable da duoc
        // cai dat trong lop SalaryHistory (hoac Worker) de xac dinh thu tu sap xep.

        Collections.sort(historySalary1);
    }

    @Override
    public String toString() {
        if (historySalary1.isEmpty()) {
            return null;
        }
        sortByID();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str = String.format("%-7s%-10s%-10s%-10s%-10s%-15s\n",
                "Code", "Name", "Age", "Salary", "Status", "Date");
        for (HistorySalary1 h : historySalary1) {
            String formattedDate = dateFormat.format(h.getDate());
            str += String.format("%-7s%-10s%-10d%-10d%-10s%-15s\n",
                    h.getWorker().getCode(),
                    h.getWorker().getName(),
                    h.getWorker().getAge(),
                    h.getSalary(),
                    h.getStatus(),
                    formattedDate);
        }
        return str;
    }
}
