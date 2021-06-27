package com.mycompany.GUI;

import com.mycompany.Kendaraan.Config;
import java.awt.HeadlessException;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;
import com.mycompany.Kendaraan.*;
import java.util.Map;
import java.util.HashMap;

/**
 * @author Mahasiswa Gunadarma
 */
public class ParkingOut extends javax.swing.JFrame implements Interface1 {
    Config con = new Config();
    Kendaraan ken = new Kendaraan();
    Map<String, String> result = new HashMap<>();; 
    @Override
    public void kosongkan_form(){
        txtPlat.setText(null);
        lbWaktuMasuk.setText(null);
        lbTotal.setText(null);
        lbJenis.setText(null);
        lbIdParkir.setText(null);
    }

    public void tampilkan_data(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No. Parking");
        model.addColumn("Plat Nomor");
        model.addColumn("Jenis kendaraan");
        model.addColumn("Waktu masuk");
        
        try{
            int no = 1;
            String sql = "SELECT * FROM parkir";
            java.sql.Connection conn= (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }
            tabelParkir.setModel(model);
        }catch(SQLException e){
            System.out.println("Error : "+ e.getMessage());
        }
    }
    public ParkingOut() {
        initComponents();
        tampilkan_data();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelParkir = new javax.swing.JTable();
        btHapus = new javax.swing.JButton();
        btKeluar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPlat = new javax.swing.JTextField();
        btCekBiaya = new javax.swing.JButton();
        btBayar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblBiaya = new javax.swing.JLabel();
        lblNoParkir = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbWaktuMasuk = new javax.swing.JLabel();
        btKembali = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbIdParkir = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        lbJenis = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parking System");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("PARKING");

        tabelParkir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        });
        tabelParkir.setEnabled(false);
        tabelParkir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelParkirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelParkir);

        btHapus.setText("Hapus");
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });

        btKeluar.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        btKeluar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btKeluar.setForeground(new java.awt.Color(255, 51, 51));
        btKeluar.setText("Keluar");
        btKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeluarActionPerformed(evt);
            }
        });

        jLabel8.setText("Plat Nomor");

        txtPlat.setDoubleBuffered(true);
        txtPlat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlatActionPerformed(evt);
            }
        });

        btCekBiaya.setText("Cek Biaya");
        btCekBiaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCekBiayaActionPerformed(evt);
            }
        });

        btBayar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btBayar.setText("Bayar");
        btBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBayarActionPerformed(evt);
            }
        });

        jLabel9.setText("Total Biaya = ");

        lbTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTotal.setText("TOTAL BIAYA           ");

        jLabel12.setText("Waktu Masuk");

        lbWaktuMasuk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbWaktuMasuk.setText("WAKTU MASUK");

        btKembali.setText("Kembali");
        btKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKembaliActionPerformed(evt);
            }
        });

        jLabel4.setText("No. Parkir");

        lbIdParkir.setText("00");

        jLabel5.setText("Jenis Kendaraan");

        lbJenis.setText("                     ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIdParkir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbWaktuMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49)
                            .addComponent(btCekBiaya)
                            .addGap(18, 18, 18)
                            .addComponent(btBayar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblNoParkir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(122, 122, 122))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(lblBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btHapus)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btKembali)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btKeluar))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNoParkir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btCekBiaya)
                        .addComponent(btBayar)
                        .addComponent(btHapus)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btKeluar)
                            .addComponent(btKembali)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIdParkir)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(lbJenis)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lbWaktuMasuk))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(lblBiaya)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        try{
        ken.hapusKendaraan(txtPlat.getText());
        tampilkan_data();
        kosongkan_form();
        }catch(HeadlessException |SQLException e){
           JOptionPane.showMessageDialog(this, e.getMessage()) ;
        }
    }//GEN-LAST:event_btHapusActionPerformed

    private void btKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btKeluarActionPerformed

    private void tabelParkirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelParkirMouseClicked
        // TODO add your handling code here:
        
        int baris = tabelParkir.rowAtPoint(evt.getPoint());
        String plat = tabelParkir.getValueAt(baris, 1).toString();
        txtPlat.setText(plat);
    }//GEN-LAST:event_tabelParkirMouseClicked

    private void txtPlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlatActionPerformed

    private void btCekBiayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCekBiayaActionPerformed
        // TODO add your handling code here:
        if(!txtPlat.getText().isEmpty()){
        try{
            
            result= ken.ambilData(txtPlat.getText());
            lbIdParkir.setText(result.get("id_kendaraan"));
            lbJenis.setText(result.get("jenis_kendaraan"));
            lbWaktuMasuk.setText(ken.lamaParkir(result.get("waktu_masuk")));
            
        switch(result.get("jenis_kendaraan")){    
        case "Motor":    
            Motor mtr = new Motor();
            lbTotal.setText(mtr.hitung(result.get("waktu_masuk")));
            break; 
        case "Mobil":    
            Mobil mbl = new Mobil();
            lbTotal.setText(mbl.hitung(result.get("waktu_masuk")));
            break; 
         case "Truk":    
            Truk truk = new Truk();
            lbTotal.setText(truk.hitung(result.get("waktu_masuk")));
            break;
         case "Bis":    
            Bis m = new Bis();
            lbTotal.setText(m.hitung(result.get("waktu_masuk")));
            break; 
        }    
            //perhitungan
        tampilkan_data();
        }catch(HeadlessException | SQLException e){
           JOptionPane.showMessageDialog(this, "Data tidak ditemukan "+e.getMessage()) ;
        }
        }
        else{
            JOptionPane.showMessageDialog(this, "Isi plat nomor") ;
       }
        
    }//GEN-LAST:event_btCekBiayaActionPerformed

    private void btBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBayarActionPerformed

        try{
            //Mengambil data kendaraan
            result = ken.ambilData(txtPlat.getText());
            String id_kendaraan = result.get("id_kendaraan");
            String jenis_kendaraan = result.get("jenis_kendaraan");
            String plat_nomor = result.get("plat_nomor");
            String waktu_masuk = result.get("waktu_masuk");
            lbIdParkir.setText(id_kendaraan);
            lbJenis.setText(jenis_kendaraan);
            lbWaktuMasuk.setText(ken.lamaParkir(waktu_masuk));
            lbTotal.setText(ken.hitung(jenis_kendaraan,waktu_masuk));
           
            String tarif = lbTotal.getText();
            
            //Kendaraan Keluar & masuk ke Report tabel
            ken.parkirKeluar(id_kendaraan, jenis_kendaraan, plat_nomor, waktu_masuk, tarif);
            
        JOptionPane.showMessageDialog(this, "Selamat jalan") ;
        tampilkan_data();
        kosongkan_form();
        }catch(HeadlessException | SQLException e){
           JOptionPane.showMessageDialog(this, "Data tidak ditemukan "+e.getMessage()) ;
        }
        
        
        
    }//GEN-LAST:event_btBayarActionPerformed

    private void btKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKembaliActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Menu().setVisible(true);
    }//GEN-LAST:event_btKembaliActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBayar;
    private javax.swing.JButton btCekBiaya;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btKeluar;
    private javax.swing.JButton btKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIdParkir;
    private javax.swing.JLabel lbJenis;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbWaktuMasuk;
    private javax.swing.JLabel lblBiaya;
    private javax.swing.JLabel lblNoParkir;
    private javax.swing.JTable tabelParkir;
    private javax.swing.JTextField txtPlat;
    // End of variables declaration//GEN-END:variables
}
