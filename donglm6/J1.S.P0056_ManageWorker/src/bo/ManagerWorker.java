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
 *
 * @author win
 */
public class ManagerWorker {

    private List<Worker> list;

    public List<Worker> getList() {
        return new ArrayList<>(list);
    }

    public ManagerWorker() {
        this.list = new ArrayList<>();
    }

    private Worker getWorker(String id) {
        for (Worker workers : list) {
            if (workers.getId().equalsIgnoreCase(id)) {
                return workers;
            }
        }
        return null;
    }

    private boolean isExist(String id) {
        for (Worker workers : list) {
            if (workers.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Worker worker) throws Exception {
        if (isExist(worker.getId())) {
            throw new Exception("Worker with ID " + worker.getId() + " already exists.");
        }
        return list.add(worker);
    }

    public Worker changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        if (!isExist(code)) {
            throw new Exception("Can not found code!");
        }
        if (amount <= 0) {
            throw new Exception("Amount of money must be > 0 ");
        }
        Worker worker = getWorker(code);
        switch (status) {
            case UP:
                worker.setSalary(worker.getSalary() + amount);
                break;
            case DOWN:
                if (worker.getSalary() - amount < 0) {
                    throw new Exception("Can not down " + amount);
                }
                worker.setSalary(worker.getSalary() - amount);
                break;
        }
        return worker;
    }

}
