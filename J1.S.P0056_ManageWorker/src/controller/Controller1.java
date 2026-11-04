package controller;

import bo.ManagerHistorySalary1;
import bo.ManagerWorker1;
import entity.HistorySalary1;
import entity.Worker1;
import utils.Validator;

import java.util.Date;
import java.util.List;

public class Controller1 {
    private ManagerHistorySalary1 managerHistorySalary1;
    private ManagerWorker1 managerWorker1;

    public Controller1() {
        this.managerHistorySalary1 = new ManagerHistorySalary1();
        this.managerWorker1 = new ManagerWorker1();
    }

    public boolean addWorker(){
        System.out.println("-----------Add Worker----------");
        String code;
        do{
        code = Validator.getString("Enter code: ", "Invalid!",".+");
        if(!managerWorker1.getExistWorker(code)) break;
            System.out.println("Code exist");
        }while(true);

        String name = Validator.getString("Enter name: ", "Invalid","[A-Za-z0-9\\s@._-]*");
        int age = Validator.getInt("Enter age: ","Must 18 <= age <= 50","Invalid!", 18,50);
        int salary = Validator.getInt("Enter salary: ","Must salary > 0","Invalid!", 1,Integer.MAX_VALUE);
        String workLocation = Validator.getString("Enter work location: ", "Invalid",".*");

        if(managerWorker1.addWorker(new Worker1(code,name,age,salary,workLocation)))
            return true;
        return false;
    }

    public boolean upSalary(){
        System.out.println("-----------Up/Down Salary----------");
        String code;
        do{
            code = Validator.getString("Enter code: ", "Invalid!","[A-Za-z0-9\\s]*");
            if(managerWorker1.getExistWorker(code)) break;
            System.out.println("Worker not exist");
        }while(true);
        int salary = Validator.getInt("Enter salary: ","Must salary > 0","Invalid!", 1,Integer.MAX_VALUE);

        managerWorker1.updateWorker(code,salary);
        Worker1 worker = managerWorker1.getWorker(code);
        if(managerHistorySalary1.addHistorySalary(new HistorySalary1(worker,salary,"UP", new Date()))) return true;
        return false;
    }

    public boolean downSalary(){
        System.out.println("-----------Up/Down Salary----------");
        String code;
        do{
            code = Validator.getString("Enter code: ", "Invalid!","[A-Za-z0-9\\s]*");
            if(managerWorker1.getExistWorker(code)) break;
            System.out.println("Worker not exist");
        }while(true);
        int salary;
        do{
            salary = Validator.getInt("Enter salary: ","Must salary > 0","Invalid!", 1,Integer.MAX_VALUE);
            if(managerWorker1.getWorker(code).getSalary() > salary) break;
            System.out.println("Salary down must < salary worker");
        }while(true);

        managerWorker1.updateWorker(code,salary);
        Worker1 worker = managerWorker1.getWorker(code);
        if(managerHistorySalary1.addHistorySalary(new HistorySalary1(worker,salary,"DOWN", new Date()))) return true;
        return false;
    }

    public void showHistorySalary() {
        String result = managerHistorySalary1.toString();
        if (result == null) {
            System.out.println("History Salary is empty");
        } else {
            System.out.println("--------------------Display Information Salary-----------------------");
            System.out.print(result);
        }
    }
}
