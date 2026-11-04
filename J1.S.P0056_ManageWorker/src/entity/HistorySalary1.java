package entity;

import java.util.Date;

public class HistorySalary1 implements Comparable<HistorySalary1> {
    private Worker1 worker;
    private int salary;
    private String status;
    private Date date;

    public HistorySalary1(Worker1 worker, int salary, String status, Date date) {
        this.worker = worker;
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    public Worker1 getWorker() {
        return worker;
    }

    public void setWorker(Worker1 worker) {
        this.worker = worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(HistorySalary1 o) {
        return this.worker.getCode().compareTo(o.worker.getCode());
    }
}
