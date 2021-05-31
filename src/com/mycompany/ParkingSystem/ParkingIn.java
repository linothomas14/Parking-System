package com.mycompany.ParkingSystem;


import com.mysql.cj.xdevapi.Statement;
import java.awt.HeadlessException;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * @author Yulyano Thomas
 */
public class ParkingIn extends javax.swing.JFrame {
int waktumulai;
Config conn = new Config();
    public ParkingIn() {
        initComponents();
        new Thread(){
            @Override
            public void run(){
                String detik = "";
              while(waktumulai == 0){
                Calendar kalender = new GregorianCalendar();
                int tahun = kalender.get(Calendar.YEAR);
                int bulan = kalender.get(Calendar.MONTH);
                int tanggal = kalender.get(Calendar.DAY_OF_MONTH);
                int jam = kalender.get(Calendar.HOUR_OF_DAY);
                int menit = kalender.get(Calendar.MINUTE);
                int temp_detik = kalender.get(Calendar.SECOND);
             
                if(temp_detik<10){
                 detik = "0"+temp_detik;
                } else{
                    detik = Integer.toString(temp_detik);
                }
             String time = tahun +"/"+bulan+"/"+ tanggal +"   "+jam + ":" + menit + ":" + detik + " ";
             lbJam.setText(time);               
              }
            }
        }.start();
    }
    private void kosongkan_form(){
        txtPlat.setText(null);
        cbJenis.setSelectedItem(this);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btMenu = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPlat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbJenis = new javax.swing.JComboBox<>();
        btSimpan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbJam = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btMenu.setText("Menu");
        btMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuActionPerformed(evt);
            }
        });

        jLabel4.setText("Plat Nomor");

        txtPlat.setDoubleBuffered(true);
        txtPlat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlatActionPerformed(evt);
            }
        });

        jLabel5.setText("Jenis Kendaraan");

        cbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mobil", "Motor", "Truk", "Bis" }));

        btSimpan.setText("Simpan");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Parking In");

        lbJam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbJam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbJam, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 86, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbJam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btMenu)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Menu().setVisible(true);
    }//GEN-LAST:event_btMenuActionPerformed

    private void txtPlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlatActionPerformed

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        if(!txtPlat.getText().isEmpty()){
        try{

            String sql ="INSERT INTO parkir  (plat_nomor,jenis_kendaraan,waktu_masuk) VALUES ('"
                    +txtPlat.getText()+"','"
                    +cbJenis.getSelectedItem()+"','"
                    +conn.getDate()+"')";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();

            JOptionPane.showMessageDialog(null, "Proses simpan data berhasil") ;
            kosongkan_form();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage()) ;
        }
        }
        else {
        JOptionPane.showMessageDialog(null, "Isi plat nomor") ;
        }
    }//GEN-LAST:event_btSimpanActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParkingIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMenu;
    private javax.swing.JButton btSimpan;
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbJam;
    private javax.swing.JTextField txtPlat;
    // End of variables declaration//GEN-END:variables
}
