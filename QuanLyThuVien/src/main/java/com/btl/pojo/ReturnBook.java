/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojo;

import java.sql.Date;

/**
 *
 * @author DTS
 */
public class ReturnBook {
    public ReturnBook(){
        
    }
    private int returnBookId;
    private Date dateReturnBook;
    private int fine;
    private int callCardID;
    private int employeeId;

    public int getReturnBookId() {
        return returnBookId;
    }

    public void setReturnBookId(int returnBookId) {
        this.returnBookId = returnBookId;
    }

    public Date getDateReturnBook() {
        return dateReturnBook;
    }

    public void setDateReturnBook(Date dateReturnBook) {
        this.dateReturnBook = dateReturnBook;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public int getCallCardID() {
        return callCardID;
    }

    public void setCallCardID(int callCardID) {
        this.callCardID = callCardID;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
}
