package Views;

import DAO.DAOConnection;
import Models.InstallSQL;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NgocPJa
 */
public class Install extends javax.swing.JFrame {

    List<String> sqlInsertTable = new ArrayList<>();
    List<String> sqlInsertProc = new ArrayList<>();

    /**
     * Creates new form Install
     */
    public Install() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        closingForm();
    }

    private void closingForm() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DAOConnection.closeConnection();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDatabaseName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUserDB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPasswordDB = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtLocalhost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Database name:");

        txtDatabaseName.setText("testing");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Userdatabase:");

        txtUserDB.setText("ngoc1");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Passworddatabase:");

        txtPasswordDB.setText("123456");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Localhost:");

        txtLocalhost.setText("localhost");
        txtLocalhost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalhostActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Port:");

        txtPort.setText("1433");

        btnConnect.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConnect.setText("Connect");
        btnConnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConnectMouseClicked(evt);
            }
        });
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(82, 82, 82)
                        .addComponent(txtDatabaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserDB, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(txtPasswordDB)
                            .addComponent(txtLocalhost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(txtPort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDatabaseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPasswordDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLocalhost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        String getDatabaseName = txtDatabaseName.getText();
        String getUserDB = txtUserDB.getText();
        String getPassDB = new String(txtPasswordDB.getText());
        String getLocalhost = txtLocalhost.getText();
        String getPort = txtPort.getText();
        getInsertTable();
        getInsertProc();
        if (DAOConnection.createDatabase(getDatabaseName, getLocalhost, getPort, getUserDB, getPassDB)) {
            if (connectDB(getDatabaseName, getUserDB, getPassDB, getLocalhost, getPort)) {
                for (String x : sqlInsertTable) {
                    DAOConnection.creataTableDB(x);
                }
                for (String x : sqlInsertProc) {
                    DAOConnection.creataTableDB(x);
                }
                this.dispose();
            } else {
                Tags.MsgThongBao.alert(this, "Không thể kết nối!");
            }
        } else {
            Tags.MsgThongBao.alert(this, "Tạo database thất bại!");
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private boolean connectDB(String getDatabaseName, String getUserDB, String getPassDB, String getLocalhost, String getPort) throws NumberFormatException {
        ObjectOutputStream oos = null;
        try {
            InstallSQL installSQL = new InstallSQL(getDatabaseName, getUserDB, getPassDB, getLocalhost, Integer.parseInt(getPort));
            Tags.ConnectionSQL._InstallSQL = installSQL;
            if (DAOConnection.getConnection() != null) {
                File file = new File("Install", "SQL");
                if (!file.getParentFile().exists()) {
                    file.mkdirs();
                }
                file = new File("Install\\SQL\\InstallDB.dat");
                if (!file.exists()) {
                    file.createNewFile();
                }
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(installSQL);
                oos.close();
                return true;
            } else {
                Tags.ConnectionSQL._InstallSQL = null;
                Tags.MsgThongBao.alert(this, "Kết nối thất bại!");
            }
        } catch (IOException ex) {
            Logger.getLogger(Install.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void getInsertTable() {
        try {
            File file = new File("SQL\\SQLTable.sql");
            Scanner r = new Scanner(file);
            String sql = "";
            while (r.hasNextLine()) {
                sql += r.nextLine() + "\n";
            }
            String[] arr = sql.split("---TABLE");
            for (String x : arr) {
                if (x.contains("CREATE")) {
                    System.out.println(x);
                    sqlInsertTable.add(x);
                }
            }
            r.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Install.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getInsertProc() {
        try {
            File file = new File("SQL\\SQLProc.sql");
            Scanner r = new Scanner(file);
            String sql = "";
            while (r.hasNextLine()) {
                sql += r.nextLine() + "\n";
            }
            String[] arr = sql.split("---PROC");
            for (String x : arr) {
                if (x.contains("CREATE")) {
                    System.out.println(x);
                    sqlInsertProc.add(x);
                }
            }
            r.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Install.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnConnectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConnectMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConnectMouseClicked

    private void txtLocalhostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalhostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalhostActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Install.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Install.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Install.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Install.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Install().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDatabaseName;
    private javax.swing.JTextField txtLocalhost;
    private javax.swing.JPasswordField txtPasswordDB;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtUserDB;
    // End of variables declaration//GEN-END:variables
}
