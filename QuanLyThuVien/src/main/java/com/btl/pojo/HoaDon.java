/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojo;

import java.math.BigDecimal;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class HoaDon {
    private int maHD;
    private int maSach;
    private BigDecimal thanhTien;
    private String tinhTrang;
    private Date NgayLap;

    public HoaDon(){
        
    }
        
    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public int getMaHD() {
        return maHD;
    }

    public int getMaSach() {
        return maSach;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public Date getNgayLap() {
        return NgayLap;
    }
    

}
