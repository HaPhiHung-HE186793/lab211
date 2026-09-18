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
 *
 * @author win
 */
public class ManagerSalaryHistory {

    private List<SalaryHistory> list;

    public ManagerSalaryHistory() {
        this.list = new ArrayList<>();
    }

    private boolean isExisted(SalaryHistory history) {
        for (SalaryHistory salaryHistory : list) {
            if(salaryHistory.getWorker().getId().equalsIgnoreCase(history.getWorker().getId())&&
                    salaryHistory.getStatus().equals(history.getStatus())&&
                    salaryHistory.getDate().equals(history.getDate())&&
                    salaryHistory.getSalaryUpdate()==history.getSalaryUpdate()){
                return true;
            }
        }
        return false;
    }

    public boolean addSalaryHistory(SalaryHistory history) throws Exception {
        if (isExisted(history)) {
            throw new Exception("This record history is existed!!!");
        }
       return list.add(history);
    }

    private void sortByID() {
        Collections.sort(list);
    }

    @Override
    public String toString() {
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
