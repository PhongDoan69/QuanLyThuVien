/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojo;

/**
 *
 * @author DTS
 */
public class CallCardDetail {
    
    public CallCardDetail(){
        
    }
    private int callCardDetailId;
    private int quantity;
    private int bookId;
    private int callCardId;

    public int getCallCardDetailId() {
        return callCardDetailId;
    }

    public void setCallCardDetailId(int callCardDetailId) {
        this.callCardDetailId = callCardDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCallCardId() {
        return callCardId;
    }

    public void setCallCardId(int callCardId) {
        this.callCardId = callCardId;
    }
}
