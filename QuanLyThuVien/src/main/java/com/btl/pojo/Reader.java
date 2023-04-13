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


public class Reader {

    private int readerId;
    private String readerName;
    private String gender;
    private Date dob;
    private String role;
    private String position;
    private Date dateOfCallCard;
    private String email;
    private String address;
    private String phone;
    private int borrowingAvailability;
    //Khoa ngoại 
    private int AccountId_Reader;

    
    public  Reader(){
        
    }
    public Reader(int readerId, String readerName, String gender, Date dob, String role, String position, Date dateOfCallCard, String email, String address, String phone, int borrowingAvailability) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.gender = gender;
        this.dob = dob;
        this.role = role;
        this.position = position;
        this.dateOfCallCard = dateOfCallCard;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.borrowingAvailability = borrowingAvailability;
        this.AccountId_Reader = AccountId_Reader;
    }

  

    public String toString() {
        return this.readerId + this.readerName + this.gender + this.dob
                + this.role + this.position + this.dateOfCallCard + this.email + this.address + this.phone + this.borrowingAvailability
                + this.AccountId_Reader;

    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDateOfCallCard(Date dateOfCallCard) {
        this.dateOfCallCard = dateOfCallCard;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBorrowingAvailability(int borrowingAvailability) {
        this.borrowingAvailability = borrowingAvailability;
    }

    public void setAccountId_Reader(int AccountId_Reader) {
        this.AccountId_Reader = AccountId_Reader;
    }

    public int getReaderId() {
        return readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public String getRole() {
        return role;
    }

    public String getPosition() {
        return position;
    }

    public Date getDateOfCallCard() {
        return dateOfCallCard;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getBorrowingAvailability() {
        return borrowingAvailability;
    }

    public int getAccountId_Reader() {
        return AccountId_Reader;
    }

}
