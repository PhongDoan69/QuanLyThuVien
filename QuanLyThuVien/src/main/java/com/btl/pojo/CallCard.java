/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojo;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class CallCard {
    private int callCardId;
    private Date dateGetBook;
    private Date returnDate;
    private int employeeId;
    private int readerId;
    
    public CallCard(){
        
    }

    public int getCallCardId() {
        return callCardId;
    }

    public void setCallCardId(int callCardId) {
        this.callCardId = callCardId;
    }

    public Date getDateGetBook() {
        return dateGetBook;
    }

    public void setDateGetBook(Date dateGetBook) {
        this.dateGetBook = dateGetBook;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    
    
}
