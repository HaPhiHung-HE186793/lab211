/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.Controller;
import utils.Validator;

/**
 *
 * @author win
 */
/**
 * Lớp Main dùng để chạy chương trình quản lý sinh viên. Hiển thị menu và xử lý
 * các lựa chọn của người dùng.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Tạo đối tượng điều khiển chương trình
        Controller control = new Controller();
        try {
            control.generateStudent();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        // Hiển thị menu cho đến khi người dùng chọn Exit    
        while (true) {
            // Nhận lựa chọn từ menu
            int choice = Validator.getInt("WELCOME TO STUDENT MANAGEMENT\n"
                    + "1.	Create\n"
                    + "2.	Find and Sort\n"
                    + "3.	Update/Delete\n"
                    + "4.	Report\n"
                    + "5.	Exit\n"
                    + "Enter your choice: ", "Just be 1->5", "Invalid!", 1, 5);
            switch (choice) {
                case 1:
                    try {
                    // Thực hiện chức năng tạo sinh viên
                    control.createStudent();
                    System.out.println("Add success!");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case 2:
                    try {
                    // Thực hiện chức năng tìm kiếm và sắp xếp
                    control.findAndSort();
                    System.out.println("Find and sort success!");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case 3:
                    try {
                    // Thực hiện chức năng cập nhật hoặc xóa sinh viên
                    control.updateOrDelete();
                    System.out.println("Update or Delete success!");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case 4:
                    try {
                    // Thực hiện chức năng báo cáo thống kê
                    control.report();
                    System.out.println("Report success!");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case 5:
                    // Kết thúc chương trình
                    System.exit(0);
            }
        }
    }

}
