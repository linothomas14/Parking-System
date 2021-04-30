import java.awt.HeadlessException;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author Yulyano Thomas
 */
public class ParkingOut extends javax.swing.JFrame {
    private void kosongkan_form(){
        txtPlat.setText(null);
        lbWaktuMasuk.setText(null);
        lbTotal.setText(null);
    }
    
    public String getDate(){
        Date thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        String res = dateForm.format(thisDate);
    return res;
    }
    
    public String lamaParkir(String waktu_masuk){
        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");  
        String dateStart = waktu_masuk;
        String dateStop = getDate();
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
        String dateStop = getDate();
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
//        System.out.println("Time in seconds: " + diffSeconds + " seconds.");         
//        System.out.println("Time in minutes: " + diffMinutes + " minutes.");         
//        System.out.println("Time in hours: " + diffHours + " hours."); 
        
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
    
    private void tampilkan_data(){
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
                String formatMasuk =  res.getString(4);
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),formatMasuk});
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPlat, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(49, 49, 49)
                                    .addComponent(btCekBiaya)
                                    .addGap(18, 18, 18)
                                    .addComponent(btBayar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbWaktuMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(btKeluar)))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCekBiaya)
                            .addComponent(btBayar)
                            .addComponent(btHapus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lbWaktuMasuk))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(22, 22, 22)
                .addComponent(btKeluar)
                .addGap(41, 41, 41)
                .addComponent(lblBiaya)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        try{
        String sql = "DELETE FROM parkir WHERE plat_nomor='" + txtPlat.getText()+"'";
        java.sql.Connection conn = (Connection)Config.configDB();
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.execute();
        JOptionPane.showMessageDialog(null, "Proses Hapus data berhasil") ;
        tampilkan_data();
        kosongkan_form();
        }catch(HeadlessException | SQLException e){
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
            String sql = "SELECT waktu_masuk,jenis_kendaraan FROM parkir WHERE plat_nomor = '"+txtPlat.getText()+"'";
            java.sql.Connection conn= (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            res.next();
            String waktu_masuk = res.getString(1);
            String jenis_kendaraan = res.getString(2);
            System.out.println(waktu_masuk+"    "+jenis_kendaraan);
            lbWaktuMasuk.setText(lamaParkir(waktu_masuk));
            lbTotal.setText(hitung(waktu_masuk,jenis_kendaraan));
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
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btBayarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbWaktuMasuk;
    private javax.swing.JLabel lblBiaya;
    private javax.swing.JLabel lblNoParkir;
    private javax.swing.JTable tabelParkir;
    private javax.swing.JTextField txtPlat;
    // End of variables declaration//GEN-END:variables
}
