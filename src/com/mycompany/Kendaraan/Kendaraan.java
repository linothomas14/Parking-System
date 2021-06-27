/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Kendaraan;

import java.util.Map;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahasiswa Gunadarma
 */

public class Kendaraan {
    Config con = new Config();
    public String id_kendaraan;
    public String plat;
    public String jenis_kendaraan;
    public String waktu_masuk;
    public String lama_parkir;
    public String waktu_keluar;
    public String tarif;
    Map<String, String> result = new HashMap<>();
    
    public Map<String, String> ambilData(String platTemp)throws SQLException{
        this.plat = platTemp;
         String sql = "SELECT * FROM parkir WHERE plat_nomor = '"+plat+"'";
            java.sql.Connection conn= (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            res.next();
            result.clear();   
            result.put("id_kendaraan", res.getString(1));
            result.put("plat_nomor", res.getString(2));
            result.put("jenis_kendaraan", res.getString(3));
            result.put("waktu_masuk", res.getString(4));

            return result;
    }
    
    public String parkirMasuk(String platTemp, String jenis_kendaraanTemp, String waktu_masukTemp) throws SQLException{
        this.plat = platTemp.toUpperCase();
        this.jenis_kendaraan = jenis_kendaraanTemp;
        this.waktu_masuk = waktu_masukTemp;
        String sql ="INSERT INTO parkir  (plat_nomor,jenis_kendaraan,waktu_masuk) VALUES ('"
                    +plat+"','"
                    +jenis_kendaraan+"','"
                    +waktu_masuk+"')";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            result = ambilData(platTemp);
            return result.get("id_kendaraan");
    }
    
    public String lamaParkir(String waktu_masukTemp){
        this.waktu_masuk = waktu_masukTemp;
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
        this.lama_parkir= hari+ " Hari, " +jam+ " Jam, " +menit+ " Menit, " +detik+ " Detik ";
        System.out.println(lama_parkir);
    return lama_parkir;
    
    }
    
    public String hitung(String jenis_kendaraanTemp,String waktu_masukTemp){
        tarif="0";
    return tarif;
    }
    
    public void hapusKendaraan(String platTemp) throws SQLException{
        this.plat = platTemp;
    String sql = "DELETE FROM parkir WHERE plat_nomor='" + plat+"'";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.execute();
        JOptionPane.showMessageDialog(null, "Proses Hapus data berhasil") ;
    }
    
    public void parkirKeluar(String id_kendaraanTemp, String jenis_kendaraanTemp, String platTemp, String waktu_masukTemp, String tarifTemp)throws SQLException{
        this.id_kendaraan = id_kendaraanTemp;
        this.jenis_kendaraan = jenis_kendaraanTemp;
        this.plat = platTemp;
        this.waktu_masuk = waktu_masukTemp;
        this.tarif = tarifTemp;
        this.waktu_keluar = con.getDate();
        java.sql.Connection conn= (Connection)Config.configDB();
        String sql1 = "INSERT INTO report  (id_kendaraan,jenis_kendaraan,plat_nomor,waktu_masuk,waktu_keluar,tarif) VALUES ('"
                    +id_kendaraan+"','"
                    +jenis_kendaraan+"','"
                    +plat+"','"
                    +waktu_masuk +"','"
                    +waktu_keluar+ "','"
                    +tarif+"')";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql1);
            pstm.execute();
            String sql2 = "DELETE FROM parkir WHERE plat_nomor = '"+plat+"'";
            pstm = conn.prepareStatement(sql2);
            pstm.execute();
}
    
}




