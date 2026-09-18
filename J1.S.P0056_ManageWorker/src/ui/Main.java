/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import controller.Controller;
import entity.Worker;
import utils.Validator;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // yeu cau: Hien thi menu chinh va dieu huong nguoi dung den cac chuc nang quan ly cong nhan.
        // cach lam: Dung vong lap do-while de lap lai menu cho den khi nguoi dung chon Exit.
        // Dung Validator.getInt de lay lua chon hop le (1-5), sau do dung switch-case
        // de goi ham tuong ung tu Controller. Moi chuc nang duoc bao trong try-catch
        // de bat va hien thi loi neu co ngoai le xay ra.
        
        Controller control = new Controller();
        do {
            int choice = Validator.getInt("======== Worker Management =========\n"
                    + "1.	Add Worker\n"
                    + "2.	Up salary\n"
                    + "3.	Down salary\n"
                    + "4.	Display Information salary\n"
                    + "5.	Exit\nEnter your choice: ", "Just be 1-> 5", "Invalid!", 1, 5);
            switch (choice) {
                // them cong nhan moi
                case 1:
                    try {
                    System.out.println("--------- Add Worker ----------");
                    Worker worker = control.addWorker();
                    System.out.println("Add success: " + worker);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                // tang luong cong nhan
                case 2:
                    try {
                    System.out.println("------- Up/Down Salary --------");
                    Worker workerUp = control.upSalary();
                    System.out.println("Up salary success:");
                    System.out.println(workerUp);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                // giam luong cong nhan
                case 3:
                    try {
                    System.out.println("------- Up/Down Salary --------");
                    Worker workerDown = control.downSalary();
                    System.out.println("Down salary success:");
                    System.out.println(workerDown);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                // hien thi lich su thay doi luong
                case 4:
                    control.showHistorySalary();
                    break;
                // thoat chuong trinh
                case 5:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}