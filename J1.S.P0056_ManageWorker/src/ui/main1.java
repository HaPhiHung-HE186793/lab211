package ui;

import controller.Controller1;
import utils.Validator;

public class main1 {
    public static void main(String[] args) {
        Controller1 controller = new Controller1();

        do{
            int choice = Validator.getInt("======== Worker Management =========\n"
                    + "1.	Add Worker\n"
                    + "2.	Up salary\n"
                    + "3.	Down salary\n"
                    + "4.	Display Information salary\n"
                    + "5.	Exit\nEnter your choice: ", "Just be 1-> 5", "Invalid!", 1, 5);
            switch (choice) {
                case 1:
                    if(controller.addWorker())
                        System.out.println("Worker Added Successfully");
                    else System.out.println("Worker Not Added Successfully");
                    break;
                case 2:
                    if(controller.upSalary())
                        System.out.println("Salary Up Successfully");
                    else System.out.println("Salary Not Up Successfully");
                    break;
                case 3:
                    if (controller.downSalary())
                        System.out.println("Salary Down Successfully");
                    else System.out.println("Salary Not Down Successfully");
                    break;
                case 4:
                    controller.showHistorySalary();
                    break;
                case 5:
                    System.exit(0);
            }
        }while (true);
    }
}
