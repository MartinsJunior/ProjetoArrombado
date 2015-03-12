/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.hanze.cdp;

/**
 *
 * @author juniorm10
 */
public class Teacher extends ObjectPersist{
    private String name;
    private String staffId;
    private String departmentName;
    private int booksThreshold;
    private int booksBorrowed;

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(int booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    public int getBooksThreshold() {
        return booksThreshold;
    }

    public void setBooksThreshold(int bookThreshold) {
        this.booksThreshold = bookThreshold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    
}
