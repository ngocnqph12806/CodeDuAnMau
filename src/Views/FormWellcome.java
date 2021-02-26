package Views;

import Controllers.EntityList;
import DAO.DAOConnection;
import Models.InstallSQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author NgocPJa
 */
public class FormWellcome extends javax.swing.JFrame {

    static FormWellcome formWellcome = new FormWellcome();

    /**
     * Creates new form Welcome
     */
    public FormWellcome() {
        setForm();
    }

    private void setForm() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);
        this.setTitle("Wellcome!");
        getConnection();
        loadingForm();
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

    private void getConnection() {
        File file = new File("Install\\SQL\\InstallDB.dat");
        if (file.exists()) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                if (ois.hashCode() > -1) {
                    Tags.ConnectionSQL._InstallSQL = (InstallSQL) ois.readObject();
                }
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(Install.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Install.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void loadingForm() {
        try {
            proLoading.setValue(1);
            if (Tags.ConnectionSQL._InstallSQL == null) {
                new Install().setVisible(true);
            }
            int time = (int) (Math.random());
            if (time == 0) {
                time = 1;
            }
            Timer t = new Timer(time, new ActionListener() {
                int phanTram = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Tags.ConnectionSQL._InstallSQL != null) {
                        if (DAOConnection.getConnection() != null) {
                            proLoading.setValue(++phanTram);
                            if (phanTram == 100) {
                                new EntityList();
                                new FormDangNhap().setVisible(true);
                                formWellcome.setVisible(false);
                            }
                        }
                    }
                }
            });
            t.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        proLoading = new javax.swing.JProgressBar();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FPOLY.POLYBEEXDESIGN.jpg"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        proLoading.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(proLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proLoading, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(FormWellcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormWellcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormWellcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormWellcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                formWellcome.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JProgressBar proLoading;
    // End of variables declaration//GEN-END:variables
}
