/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.QuanLyChuyenDe;
import Controllers.QuanLyChuyenDeImplement;
import Models.ChuyenDe;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NgocPJa
 */
public class FormQuanLyChuyenDe1 extends javax.swing.JInternalFrame {

    private DefaultTableModel _modelDanhSach;
    private QuanLyChuyenDe _iQuanLyChuyenDe = new QuanLyChuyenDeImplement();

    public FormQuanLyChuyenDe1() {
        initComponents();
        this.setClosable(true);
        this.setTitle("Quản lý chuyên đề");
        setUpForm();
        if (Tags.Login._nhanVien == null) {
            Tags.MsgThongBao.alert(this, "Vui lòng đăng nhập");
            this.removeAll();
        }
    }

    protected void setUpForm() {
        try {
            _modelDanhSach = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; //To change body of generated methods, choose Tools | Templates.
                }

            };
            tbDanhSach.setModel(_modelDanhSach);
            setColTableDanhSach();
            setRowTableDanhSach();
            blockBtn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void blockBtn() {
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnNext.setEnabled(!(_modelDanhSach.getRowCount() == 0));
        btnFirst.setEnabled(!(_modelDanhSach.getRowCount() == 0));
        btnLast.setEnabled(!(_modelDanhSach.getRowCount() == 0));
        btnPrev.setEnabled(!(_modelDanhSach.getRowCount() == 0));
    }

    private void setColTableDanhSach() {
        String[] arrCol = {"Mã CĐ", "Tên CĐ", "Học phí", "Thời lượng", "Hình"};
        for (String x : arrCol) {
            _modelDanhSach.addColumn(x);
        }
    }

    private void setRowTableDanhSach() {
        _modelDanhSach.setRowCount(0);
        for (ChuyenDe x : _iQuanLyChuyenDe.getListChuyenDe()) {
            _modelDanhSach.addRow(new Object[]{
                x.getMaChuyenDe(), x.getTenChuyenDe(), x.getHocPhi(), x.getThoiLuong(), x.getHinhAnh()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaChuyenDe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenChuyenDe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaMoTaChuyenDe = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDanhSach = new javax.swing.JTable();
        btnXuatExcel = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ CHUYÊN ĐỀ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Hình logo");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        lblHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinh.setText("Hinh");
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã chuyên đề");

        txtMaChuyenDe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên chuyên đề");

        txtTenChuyenDe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Thời lượng (giờ)");

        txtThoiLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Học phí");

        txtHocPhi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Mô tả chuyên đề");

        txaMoTaChuyenDe.setColumns(20);
        txaMoTaChuyenDe.setRows(5);
        jScrollPane2.setViewportView(txaMoTaChuyenDe);

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLast.setText("|>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnFirst.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFirst.setText("<|");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(50, 50, 50)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(txtTenChuyenDe, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtThoiLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtHocPhi)
                                        .addComponent(txtMaChuyenDe)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLast)
                        .addComponent(btnNext)
                        .addComponent(btnPrev)
                        .addComponent(btnFirst))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addComponent(btnMoi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cập nhật", jPanel1);

        tbDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDanhSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDanhSach);

        btnXuatExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(600, Short.MAX_VALUE)
                .addComponent(btnXuatExcel)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(464, Short.MAX_VALUE)
                .addComponent(btnXuatExcel)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGap(37, 37, 37)))
        );

        jTabbedPane1.addTab("Danh sách", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        try {
            evtChonHinhAnh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lblHinhMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            btnActionChuyenDe("add");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            btnActionChuyenDe("edit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            btnXoaChuyenDe();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        try {
            btnThem.setEnabled(true);
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
            formatData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        try {
            indexClickTable = tbDanhSach.getRowCount() - 1;
            tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
            evtBtnActionTable(indexClickTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        try {
            if (indexClickTable == -1 || indexClickTable == tbDanhSach.getRowCount() - 1) {
                indexClickTable = 0;
            } else {
                indexClickTable++;
            }
            tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
            evtBtnActionTable(indexClickTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        try {
            switch (indexClickTable) {
                case 0:
                    indexClickTable = tbDanhSach.getRowCount() - 1;
                    break;
                case -1:
                    indexClickTable = 0;
                    break;
                default:
                    indexClickTable--;
                    break;
            }
            tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
            evtBtnActionTable(indexClickTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        try {
            indexClickTable = 0;
            tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
            evtBtnActionTable(indexClickTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void tbDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhSachMouseClicked
        try {
            evtClickTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbDanhSachMouseClicked

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        exportExcel(tbDanhSach);
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    public void exportExcel(JTable table) {
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                String nameFile = file.getAbsolutePath();
                if (!nameFile.endsWith(".xls")) {
                    nameFile += ".xls";
                }
                Writer bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameFile), "UTF8"));
                // ten Cot
                for (int j = 0; j < table.getColumnCount(); j++) {
                    bf.append(_modelDanhSach.getColumnName(j) + "\t");
                }
                bf.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < table.getRowCount(); j++) {
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        bf.write(_modelDanhSach.getValueAt(j, k) + "\t");
                    }
                    bf.write("\n");
                }
                bf.close();
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
        }
    }

    private void formatData() {
        blockBtn();
        txtMaChuyenDe.setText("");
        txtTenChuyenDe.setText("");
        txtThoiLuong.setText("");
        txtHocPhi.setText("");
        txaMoTaChuyenDe.setText("");
        lblHinh.setText("");
        txtMaChuyenDe.setEditable(true);
        lblHinh.setIcon(null);
    }

    private Path pathForm = null;
    private File dst = null;
    private String tenHinhAnh = "";

    private void evtChonHinhAnh() throws HeadlessException {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File srcFile = chooser.getSelectedFile();
            while (true) {
                tenHinhAnh = Math.random() * 10000000 + srcFile.getName();
                dst = new File("logos", tenHinhAnh);
                if (!dst.exists()) {
                    break;
                }
            }
            if (!dst.getParentFile().exists()) {
                dst.getParentFile().mkdirs();
            }
            pathForm = Paths.get(srcFile.getAbsolutePath());
            ImageIcon imageIcon = new ImageIcon(pathForm.toString()); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(167, 222, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);  // transform it back
            lblHinh.setIcon(imageIcon);
            lblHinh.setSize(167, 222);
            lblHinh.setText("");
        }
    }

    private void btnXoaChuyenDe() {
        String getMaChuyenDe = txtMaChuyenDe.getText();
        if (getMaChuyenDe == null || getMaChuyenDe.isBlank() || getMaChuyenDe.isEmpty()) {
            getMaChuyenDe = Tags.MsgThongBao.prompt(this, "Nhập mã chuyên đề muốn xóa:");
        }
        ChuyenDe chuyenDe = _iQuanLyChuyenDe.getChuyenDeById(getMaChuyenDe);
        if (chuyenDe != null) {
            if (Tags.MsgThongBao.confirm(this, "Đồng ý xóa chuyên đề " + getMaChuyenDe)) {
                if (_iQuanLyChuyenDe.removeChuyenDe(chuyenDe)) {
                    Tags.MsgThongBao.alert(this, "Xóa chuyên đề thành công!");
                    setRowTableDanhSach();
                    formatData();
                } else {
                    Tags.MsgThongBao.alert(this, "Xóa chuyên đề thất bại!"
                            + "\nRất có thể mã chuyên đề này đang liên kết tới một khóa học đã tồn tại."
                            + "\nVui lòng kiểm tra lại!");
                }
            }
        } else {
            Tags.MsgThongBao.alert(this, "Mã chuyên đề không tồn tại!");
        }
    }

    private void btnActionChuyenDe(String type) {
        String getMaChuyenDe = txtMaChuyenDe.getText();
        String getTenChuyenDe = txtTenChuyenDe.getText();
        String getThoiLuong = txtThoiLuong.getText();
        String getHocPhi = txtHocPhi.getText();
        String getMoTa = txaMoTaChuyenDe.getText();
        StringBuilder sp = new StringBuilder();
        sp.append(Tags.Pattern.checkMa(getMaChuyenDe, "Mã chuyên đề"));
        sp.append(Tags.Pattern.checkTen(getTenChuyenDe, "Tên chuyên đề"));
        sp.append(Tags.Pattern.checkThoiLuong(getThoiLuong, "Thời lượng"));
        sp.append(Tags.Pattern.checkHocPhi(getHocPhi, "Học phí"));
        sp.append(Tags.Pattern.checkHinhAnh(tenHinhAnh, "Logo"));
        if (_iQuanLyChuyenDe.getChuyenDeById(getMaChuyenDe) != null && type.equalsIgnoreCase("add")) {
            Tags.MsgThongBao.alert(this, "Mã chuyên đề đã tồn tại!");
            return;
        }
        if (sp.length() == 0) {
            ChuyenDe chuyenDe = new ChuyenDe();
            chuyenDe.setHinhAnh(tenHinhAnh);
            chuyenDe.setHocPhi(Double.parseDouble(getHocPhi));
            chuyenDe.setMaChuyenDe(getMaChuyenDe);
            chuyenDe.setMoTa(getMoTa);
            chuyenDe.setTenChuyenDe(getTenChuyenDe);
            chuyenDe.setThoiLuong(Integer.parseInt(getThoiLuong));
            if (type.equalsIgnoreCase("add")) {
                if (_iQuanLyChuyenDe.addChuyenDe(chuyenDe)) {
                    try {
                        Path patchTo = Paths.get(dst.getAbsolutePath());
                        Files.copy(pathForm, patchTo, StandardCopyOption.REPLACE_EXISTING);
                        Tags.MsgThongBao.alert(this, "Thêm chuyên đề thành công!");
                        formatData();
                        setRowTableDanhSach();
                    } catch (IOException ex) {
                        Logger.getLogger(FormQuanLyChuyenDe1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Tags.MsgThongBao.alert(this, "Thêm chuyên đề thất bại!");
                }
            } else if (type.equalsIgnoreCase("edit")) {
                if (_iQuanLyChuyenDe.editChuyenDe(chuyenDe)) {
                    Tags.MsgThongBao.alert(this, "Sửa thành công!");
                    setRowTableDanhSach();
                } else {
                    Tags.MsgThongBao.alert(this, "Sửa thất bại!");
                }
            }
        } else {
            Tags.MsgThongBao.alert(this, sp.toString());
        }
    }

    int indexClickTable = -1;

    private void evtBtnActionTable(int index) {
        if (index > -1) {
            ChuyenDe chuyenDe = _iQuanLyChuyenDe.getChuyenDeById((String) tbDanhSach.getValueAt(index, 0));
            setDataForm(chuyenDe);
        }
    }

    private void evtClickTable() {
        indexClickTable = tbDanhSach.getSelectedRow();
        if (indexClickTable > -1) {
            ChuyenDe chuyenDe = _iQuanLyChuyenDe.getChuyenDeById((String) tbDanhSach.getValueAt(indexClickTable, 0));
            setDataForm(chuyenDe);
        }
    }

    private void setDataForm(ChuyenDe chuyenDe) {
        blockBtn();
        if (chuyenDe != null) {
            txtMaChuyenDe.setText(chuyenDe.getMaChuyenDe());
            txtTenChuyenDe.setText(chuyenDe.getTenChuyenDe());
            txtThoiLuong.setText(chuyenDe.getThoiLuong() + "");
            txtHocPhi.setText(chuyenDe.getHocPhi() + "");
            txaMoTaChuyenDe.setText(chuyenDe.getMoTa());
            lblHinh.setText("Hình ảnh");
            btnSua.setEnabled(true);
            btnXoa.setEnabled(Tags.Login._nhanVien.isVaiTro());
            btnThem.setEnabled(false);
            txtMaChuyenDe.setEditable(false);
            File dst = new File("logos", chuyenDe.getHinhAnh());
            if (dst.exists()) {
                lblHinh.setText("");
            }
            Path patchTo = Paths.get(dst.getAbsolutePath());
            ImageIcon imageIcon = new ImageIcon(patchTo.toString()); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(167, 222, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg);  // transform it back
            lblHinh.setIcon(imageIcon);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JTable tbDanhSach;
    private javax.swing.JTextArea txaMoTaChuyenDe;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtMaChuyenDe;
    private javax.swing.JTextField txtTenChuyenDe;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
