/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Kendaraan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.mycompany.ParkingSystem.Config;
/**
 *
 * @author ASUS
 */
public class Kendaraan {
    public String jenis_kendaraan;
    Config con = new Config();

    public String lamaParkir(String waktu_masuk){
        Config conn = new Config();
        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");  
        String dateStart = waktu_masuk;
        String dateStop = con.getDate();
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);
        } catch (ParseException e) {
            e.printStackTrace();
        }    
        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000 % 60;  
        long diffMinutes = diff / (60 * 1000) % 60; 
        long diffHours = diff / (60 * 60 * 1000) %24 ; 
        long diffDays = diff / (24 *60 * 60 * 1000); 

        String hari = String.valueOf(diffDays);
        String jam = String.valueOf(diffHours);
        String menit = String.valueOf(diffMinutes);
        String detik = String.valueOf(diffSeconds);
        String s= hari+ " Hari, " +jam+ " Jam, " +menit+ " Menit, " +detik+ " Detik ";
    return s ;
    }
    
    public String hitung(String waktu_masuk,String jenis_kendaraan){
        String dateStart = waktu_masuk;
        String dateStop = con.getDate();
        String s;
        long total,biaya = 0,biaya_inap = 0;
        
        switch(jenis_kendaraan){    
        case "Motor":    
            biaya = 1500;  
            biaya_inap = 5000;
            break;  
        case "Mobil":    
            biaya = 3000;  
            biaya_inap = 15000;
            break; 
         case "Truk":    
            biaya = 4000;
            biaya_inap = 15000;
         break; 
         case "Bis":    
            biaya = 4000;  
            biaya_inap = 15000;
            break;  
        }    
                
        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");  

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
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
        s=String.valueOf(total);
    return s;
    }
}
