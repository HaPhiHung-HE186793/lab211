package bo;

import entity.Worker1;

import java.util.ArrayList;
import java.util.List;

public class ManagerWorker1 {
    private List<Worker1> listWorker1   ;

    public ManagerWorker1() {
        this.listWorker1 = new ArrayList<>();
    }

    public boolean getExistWorker(String code) {
        for(Worker1 w : listWorker1) {
            if(w.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public Worker1 getWorker(String code) {
        for(Worker1 w : listWorker1) {
            if(w.getCode().equals(code)) {
                return w;
            }
        }
        return null;
    }

    public List<Worker1> getListWorker() {

        return listWorker1;
    }

    public boolean addWorker(Worker1 w) {
        return listWorker1.add(w);
    }

    public boolean updateWorker(String code, int salary) {
        for(Worker1 worker1 : listWorker1) {
            if(worker1.getCode().equals(code)) {
                worker1.setSalary(salary);
                return true;
            }
        }
        return false;
    }

}
