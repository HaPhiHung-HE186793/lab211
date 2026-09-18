/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 * Enum bieu dien trang thai thay doi luong cua cong nhan.
 *
 * UP : Tang luong. DOWN : Giam luong.
 *
 * @author win
 */
public enum SalaryStatus {
    /**
     * Trang thai tang luong. Trang thai giam luong.
     */
    UP, DOWN;
    /**
     * Tra ve trang thai UP.
     *
     * @return UP
     */
    public static SalaryStatus getUP() {
        // yeu cau: Cung cap mot cach lay hang so UP thong qua phuong thuc static,
        // thay vi truy cap truc tiep SalaryStatus.UP.
        // cach lam: Don gian tra ve gia tri hang so UP cua enum.
        
        return UP;
    }
    /**
     * Tra ve trang thai DOWN.
     *
     * @return DOWN
     */
    public static SalaryStatus getDOWN() {
        // yeu cau: Cung cap mot cach lay hang so DOWN thong qua phuong thuc static,
        // thay vi truy cap truc tiep SalaryStatus.DOWN.
        // cach lam: Don gian tra ve gia tri hang so DOWN cua enum.
        
        return DOWN;
    }
}