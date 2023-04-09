/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojo;

/**
 *
 * @author Admin
 */
public class KhachHang {
     private int MaKH;
    private String TenKH;
    private String CMND;
    private String DiaChi;
    private String GioiTinh;
    private int MaAcc;
    private String SDT;

    public KhachHang(){
        
    }
    
    public KhachHang(int maKH, String TenKH, String CMND, String DiaChi, String GioiTinh, int MaAcc, String SDT) {
        this.MaKH = maKH;
        this.TenKH = TenKH;
        this.CMND = CMND;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.MaAcc = MaAcc;
        this.SDT = SDT;
    }
    public int getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public String getCMND() {
        return CMND;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public int getMaAcc() {
        return MaAcc;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setMaAcc(int MaAcc) {
        this.MaAcc = MaAcc;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    public String ToString()
    {
        return this.MaKH +this.TenKH +this.CMND +this.DiaChi +this.GioiTinh + this.MaAcc + this.SDT; 
    }
}
