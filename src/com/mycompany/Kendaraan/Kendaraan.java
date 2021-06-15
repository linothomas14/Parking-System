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
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Mahasiswa Gunadarma
 */
public class Kendaraan {
    String result[] = new String[5];
    Config con = new Config();
    public void parkirMasuk(String plat, String jenis_kendaraan, String waktu) throws SQLException{
        String sql ="INSERT INTO parkir  (plat_nomor,jenis_kendaraan,waktu_masuk) VALUES ('"
                    +plat+"','"
                    +jenis_kendaraan+"','"
                    +waktu+"')";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Proses simpan data berhasil") ;
    }
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
    public String hitung(String jenis_kendaraan,String waktu_masuk){
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
    public void hapusKendaraan(String plat) throws SQLException{
    String sql = "DELETE FROM parkir WHERE plat_nomor='" + plat+"'";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.execute();
        JOptionPane.showMessageDialog(null, "Proses Hapus data berhasil") ;
    }
    public String[] cekBiaya(String plat)throws SQLException{
        String sql = "SELECT id_kendaraan,jenis_kendaraan,waktu_masuk FROM parkir WHERE plat_nomor = '"+plat+"'";
            java.sql.Connection conn= (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            res.next();
            result[0] = res.getString(1);
            result[1] = res.getString(2);
            result[2] = res.getString(3);
            return result;
    }
    public String[] ambilData(String plat)throws SQLException{
        
         String sql = "SELECT id_kendaraan,jenis_kendaraan,plat_nomor,waktu_masuk FROM parkir WHERE plat_nomor = '"+plat+"'";
            java.sql.Connection conn= (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            res.next();
            result[0] = res.getString(1);
            result[1] = res.getString(2);
            result[2] = res.getString(3);
            result[3] = res.getString(4);
            
            System.out.println(result[0]);
            System.out.println(result[1]);
            System.out.println(result[2]);
            System.out.println(result[3]);
            return result;
    }
    public void parkirKeluar(String no_parkir, String jenis_kendaraan, String plat_nomor, String waktu_masuk, String tarif)throws SQLException{
        java.sql.Connection conn= (Connection)Config.configDB();
        String sql1 = "INSERT INTO report  (id_kendaraan,jenis_kendaraan,plat_nomor,waktu_masuk,waktu_keluar,tarif) VALUES ('"
                    +no_parkir+"','"
                    +jenis_kendaraan+"','"
                    +plat_nomor+"','"
                    +waktu_masuk +"','"
                    +con.getDate()+ "','"
                    +tarif+"')";
            java.sql.PreparedStatement pstm1 = conn.prepareStatement(sql1);
            pstm1.execute();
            String sql2 = "DELETE FROM parkir WHERE plat_nomor = '"+plat_nomor+"'";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql2);
            pstm.execute();
}
}




