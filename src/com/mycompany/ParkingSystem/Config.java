package com.mycompany.ParkingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
/**
 * @author Yulyano Thomas
 */
public class Config {
    
    private static Connection MySQLConfig;
    
    public static Connection configDB() throws SQLException{
        try{
            String url = "jdbc:mysql://localhost:3306/parking_db";
            String user = "root";
            String pw = "";
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pw);
        }catch(SQLException e){
            System.out.println("Koneksi GAGAL" + e.getMessage());
    }
     return MySQLConfig;   
    }
    
    public void hapus(String text) throws SQLException{
    String sql = "DELETE FROM parkir WHERE plat_nomor='" + text+"'";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.execute();
        JOptionPane.showMessageDialog(null, "Proses Hapus data berhasil") ;
    }
    
    public String getDate(){
        Date thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        String res = dateForm.format(thisDate);
    return res;
    }
}

//txtPlat.getText()