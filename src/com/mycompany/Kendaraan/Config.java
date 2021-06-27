package com.mycompany.Kendaraan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author Mahasiswa Gunadarma
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
    public String getDate(){
        Date thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        String res = dateForm.format(thisDate);
    return res;
    }
}

//txtPlat.getText()