/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.conf;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class HashPassword {

    public static String Hash_Password(String passWord) {
        String maHash = "";
        char[] chuoi = passWord.toCharArray();
        Map<Character, Integer> myMap = new HashMap<>();
        // Character la gia tri cua phan tu trong mang. Integer la so lan xuat hien cua phan tu do
        for (char i : chuoi) {
            if (myMap.containsKey(i)== false) {
                myMap.put(i, 1);
            } else {
                // i da xuat hien truoc do
                int soLanXuatHien = myMap.get(1);
                soLanXuatHien++;
                myMap.put(i, soLanXuatHien);
            }
        }
        for (Map.Entry entry : myMap.entrySet()) {
            maHash += entry.getKey() + String.valueOf(entry.getValue());
            if (maHash.charAt(maHash.length() - 1) == '1') {
                maHash = maHash.replace(maHash.charAt(maHash.length() - 1), '!');
                maHash += "&*#";
            }
            if (maHash.charAt(maHash.length() - 1) == '2') {
                maHash = maHash.replace(maHash.charAt(maHash.length() - 1), '&');
                maHash += "@#$";
            }
            if (maHash.charAt(maHash.length() - 1) == '3') {
                maHash = maHash.replace(maHash.charAt(maHash.length() - 1), '@');
                maHash += "$@@";
            }
            if (maHash.charAt(maHash.length() - 1) == '4') {
                maHash = maHash.replace(maHash.charAt(maHash.length() - 1), '(');
                maHash += "@$";
            }
            if (maHash.charAt(maHash.length() - 1) == '5') {
                maHash = maHash.replace(maHash.charAt(maHash.length() - 1), ')');
                maHash += "($@";
            }
            if (maHash.charAt(maHash.length() - 1) == '6') {
                maHash = maHash.replace(maHash.charAt(maHash.length() - 1), '^');
                maHash += "#$*";
            }
            if (maHash.charAt(maHash.length() - 1) == '7') {
                maHash = maHash.replace(maHash.charAt(maHash.length() - 1), '#');
                maHash += "!#*";
            }
        }
        return maHash;
    }
}
