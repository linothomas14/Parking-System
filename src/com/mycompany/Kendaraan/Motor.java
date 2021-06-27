/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Kendaraan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Motor extends Kendaraan{
    public String hitung(String waktu_masukTemp){
        this.waktu_masuk = waktu_masukTemp;
        String dateStop = con.getDate();
        long total,biaya = 1500,biaya_inap = 5000;
                
        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");  

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(waktu_masuk);
            d2 = format.parse(dateStop);
        } catch (ParseException e) {
            e.printStackTrace();
        }    
        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000 % 60;  
        long diffMinutes = diff / (60 * 1000) % 60; 
        long diffHours = diff / (60 * 60 * 1000); 
        long diffDays = diff / (24 *60 * 60 * 1000); 

        if(diffDays > 0){
        total = (diffDays) * biaya_inap;
        } else{
        total = (diffHours+1) * biaya;
            if(total > biaya_inap){
                total = biaya_inap;
            }
            if(diffDays == 0 && diffHours ==0 && diffMinutes < 10){
            total = 0;
            }
        }
        this.tarif = String.valueOf(total);
    return tarif;
    }
}
