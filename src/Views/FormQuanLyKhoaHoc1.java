/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.QuanLyChuyenDe;
import Controllers.QuanLyChuyenDeImplement;
import Controllers.QuanLyKhoaHoc;
import Controllers.QuanLyKhoaHocImplement;
import Models.ChuyenDe;
import Models.KhoaHoc;
import Tags.FormatDate;
import Tags.SaveExcel;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NgocPJa
 */
public class FormQuanLyKhoaHoc1 extends javax.swing.JInternalFrame {

    private DefaultTableModel _modelDanhSachKhoaHoc;
    private QuanLyKhoaHoc _iQuanLyKhoaHoc = new QuanLyKhoaHocImplement();
    private QuanLyChuyenDe _iQuanLyChuyenDe = new QuanLyChuyenDeImplement();
    private KhoaHoc _khoaHoc = null;

    /**
     * Creates new form FormQuanLyKhoaHoc
     */
    public FormQuanLyKhoaHoc1() {
        initComponents();
        this.setClosable(true);
        this.setTitle("Quản lý khóa học");
        setUpForm();
        if (Tags.Login._nhanVien == null) {
            Tags.MsgThongBao.alert(this, "Vui lòng đăng nhập");
            this.removeAll();
        }
    }

    protected void setUpForm() {
        try {
            setCbcChuyenDe();
            txtNguoiTao.setText(Tags.Login._nhanVien.getMaNV());
            txtNguoiTao.setEnabled(false);
            txtChuyenDe.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtNgayTao.setText(Tags.FormatDate.dinhDangNgayThangNam(new Date()));
            _modelDanhSachKhoaHoc = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tbDanhSach.setModel(_modelDanhSachKhoaHoc);
            setColTableDanhSachKhoaHoc();
            setRowTableKhoaHoc();
            blockBtn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setRowTableKhoaHoc() {
        _modelDanhSachKhoaHoc.setRowCount(0);
        for (KhoaHoc x : _iQuanLyKhoaHoc.getListKhoaHoc()) {
            _modelDanhSachKhoaHoc.addRow(new Object[]{
                x.getMaKhoaHoc(), x.getThoiLuong(), x.getHocPhi(),
                FormatDate.dinhDangNgayThangNam(x.getNgayKhaiGiang()),
                x.getMaNV(), FormatDate.dinhDangNgayThangNam(x.getNgayTao())
            });
        }
    }

    private void setColTableDanhSachKhoaHoc() {
        String[] arrCol = {"Mã KH", "Thời lượng", "Học phí", "Khai giảng", "Tạo bởi", "Ngày tạo"};
        for (String x : arrCol) {
            _modelDanhSachKhoaHoc.addColumn(x);
        }
    }

    private void setCbcChuyenDe() {
        cbcChuyenDe.removeAllItems();
        for (ChuyenDe x : _iQuanLyChuyenDe.getListChuyenDe()) {
            cbcChuyenDe.addItem(x.getTenChuyenDe());
        }
    }

    private void blockBtn() {
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnNext.setEnabled(!(_modelDanhSachKhoaHoc.getRowCount() == 0));
        btnFirst.setEnabled(!(_modelDanhSachKhoaHoc.getRowCount() == 0));
        btnLast.setEnabled(!(_modelDanhSachKhoaHoc.getRowCount() == 0));
        btnPrev.setEnabled(!(_modelDanhSachKhoaHoc.getRowCount() == 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbcChuyenDe = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtChuyenDe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNguoiTao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKhaiGiang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaGhiChu = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDanhSach = new javax.swing.JTable();
        btnLuuExcel = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("CHUYÊN ĐỀ"));

        cbcChuyenDe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbcChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcChuyenDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbcChuyenDe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbcChuyenDe, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Chuyên đề");

        txtChuyenDe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtChuyenDe.setForeground(new java.awt.Color(255, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Học phí");

        txtHocPhi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Người tạo");

        txtNguoiTao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Khai giảng");

        txtKhaiGiang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Thời lượng (giờ)");

        txtThoiLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ngày tạo");

        txtNgayTao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ghi chú");

        txaGhiChu.setColumns(20);
        txaGhiChu.setRows(5);
        jScrollPane2.setViewportView(txaGhiChu);

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

        btnFirst.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFirst.setText("<|");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLast.setText("|>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFirst)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPrev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLast))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtKhaiGiang, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(22, 22, 22))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKhaiGiang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLast)
                        .addComponent(btnNext)
                        .addComponent(btnPrev)
                        .addComponent(btnFirst))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addComponent(btnMoi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cập nhật", jPanel2);

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

        btnLuuExcel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLuuExcel.setText("Lưu Excel");
        btnLuuExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLuuExcel)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuuExcel)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbcChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcChuyenDeActionPerformed
        try {
            if (cbcChuyenDe.getSelectedIndex() > -1) {
                txtChuyenDe.setText(cbcChuyenDe.getSelectedItem().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbcChuyenDeActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            btnActionKhoaHoc("add");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            btnActionKhoaHoc("edit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            btnXoaKhoaHoc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        try {
            btnThem.setEnabled(true);
            btnXoa.setEnabled(false);
            btnSua.setEnabled(false);
            formatData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        try {
            indexClickTable = 0;
            if (indexClickTable < tbDanhSach.getRowCount() && indexClickTable > -1) {
                tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
                evtBtnActionTable(indexClickTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        try {
            switch (indexClickTable) {
                case -1:
                    indexClickTable = 0;
                    break;
                case 0:
                    indexClickTable = tbDanhSach.getRowCount() - 1;
                    break;
                default:
                    indexClickTable--;
                    break;
            }
            if (indexClickTable < tbDanhSach.getRowCount() && indexClickTable > -1) {
                tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
                evtBtnActionTable(indexClickTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        try {
            if (indexClickTable == -1 || indexClickTable == tbDanhSach.getRowCount() - 1) {
                indexClickTable = 0;
            } else {
                indexClickTable++;
            }
            if (indexClickTable < tbDanhSach.getRowCount() && indexClickTable > -1) {
                tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
                evtBtnActionTable(indexClickTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        try {
            indexClickTable = tbDanhSach.getRowCount() - 1;
            if (indexClickTable < tbDanhSach.getRowCount() && indexClickTable > -1) {
                tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
                evtBtnActionTable(indexClickTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void tbDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhSachMouseClicked
        try {
            indexClickTable = tbDanhSach.getSelectedRow();
            if (indexClickTable < tbDanhSach.getRowCount() && indexClickTable > -1) {
                tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
                evtBtnActionTable(indexClickTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbDanhSachMouseClicked

    private void btnLuuExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuExcelActionPerformed
       SaveExcel.exportExcel(tbDanhSach, _modelDanhSachKhoaHoc, this.getTitle());
    }//GEN-LAST:event_btnLuuExcelActionPerformed

    private void btnActionKhoaHoc(String type) {
        String getNgayKhaiGiang = txtKhaiGiang.getText();
        String getHocPhi = txtHocPhi.getText();
        String getThoiLuong = txtThoiLuong.getText();
        String getNgayTao = txtNgayTao.getText();
        String getGhiChu = txaGhiChu.getText();
        StringBuilder sp = new StringBuilder();
        sp.append(Tags.Pattern.checkNgay(getNgayKhaiGiang, "Ngày khai giảng"));
        sp.append(Tags.Pattern.checkHocPhi(getHocPhi, "Học phí"));
        sp.append(Tags.Pattern.checkThoiLuong(getThoiLuong, "Thời lượng"));
        sp.append(Tags.Pattern.checkNgay(getNgayTao, "Ngày tạo"));
        if (sp.length() == 0) {
            KhoaHoc khoaHoc = new KhoaHoc((_iQuanLyKhoaHoc.getIdKhoaHoc() + 1) + "",
                    _iQuanLyChuyenDe.getListChuyenDe().get(cbcChuyenDe.getSelectedIndex()).getMaChuyenDe(),
                    Double.parseDouble(getHocPhi),
                    Integer.parseInt(getThoiLuong),
                    Tags.FormatDate.convertNgayThangNam(getNgayKhaiGiang), getGhiChu,
                    Tags.Login._nhanVien.getMaNV(),
                    Tags.FormatDate.convertNgayThangNam(getNgayTao)
            );
            if (type.equalsIgnoreCase("add")) {
                if (_iQuanLyKhoaHoc.addKhoaHoc(khoaHoc)) {
                    Tags.MsgThongBao.alert(this, "Thêm khóa học thành công!");
                    setRowTableKhoaHoc();
                    formatData();
                } else {
                    Tags.MsgThongBao.alert(this, "Thêm thất bại!");
                }
            } else if (type.equalsIgnoreCase("edit")) {
                khoaHoc.setMaKhoaHoc(_khoaHoc.getMaKhoaHoc());
                if (_iQuanLyKhoaHoc.editKhoaHoc(khoaHoc)) {
                    Tags.MsgThongBao.alert(this, "Sửa thành công!");
                    setRowTableKhoaHoc();
                } else {
                    Tags.MsgThongBao.alert(this, "Sửa thất bại!");
                }
            }
        } else {
            Tags.MsgThongBao.alert(this, sp.toString());
        }
    }

    private void btnXoaKhoaHoc() {
        if (getMaKhoaHoc.isBlank() || getMaKhoaHoc.isEmpty()) {
            getMaKhoaHoc = Tags.MsgThongBao.prompt(this, "Nhập mã khóa học muốn xóa:");
        }
        KhoaHoc khoaHoc = _iQuanLyKhoaHoc.getKhoaHocById(getMaKhoaHoc);
        if (khoaHoc != null) {
            if (Tags.MsgThongBao.confirm(this, "Đồng ý xóa khóa học " + getMaKhoaHoc)) {
                if (_iQuanLyKhoaHoc.removeKhoaHoc(khoaHoc)) {
                    Tags.MsgThongBao.alert(this, "Xóa thành công!");
                    formatData();
                    setRowTableKhoaHoc();
                } else {
                    Tags.MsgThongBao.alert(this, "Xóa thất bại!"
                            + "\nCó thể khóa học đã được sử dụng."
                            + "\nVui lòng kiểm tra lại!");
                }
            }
        } else {
            Tags.MsgThongBao.alert(this, "Khóa học không tồn tại!");
        }
    }

    private String getMaKhoaHoc = "";
    private int indexClickTable = -1;

    private void evtBtnActionTable(int index) {
        if (index > -1) {
            _khoaHoc = _iQuanLyKhoaHoc.getKhoaHocById((String) tbDanhSach.getValueAt(index, 0));
            setDataForm(_khoaHoc);
        }
    }

    private void setDataForm(KhoaHoc khoaHoc) {
        blockBtn();
        if (khoaHoc != null) {
            getMaKhoaHoc = khoaHoc.getMaKhoaHoc();
            txtChuyenDe.setText(_iQuanLyChuyenDe.getChuyenDeById(khoaHoc.getMaChuyenDe()).getTenChuyenDe());
            txtHocPhi.setText(khoaHoc.getHocPhi() + "");
            txtNguoiTao.setText(khoaHoc.getMaNV());
            txaGhiChu.setText(khoaHoc.getGhiChu());
            txtKhaiGiang.setText(Tags.FormatDate.dinhDangNgayThangNam(khoaHoc.getNgayKhaiGiang()));
            txtThoiLuong.setText(khoaHoc.getThoiLuong() + "");
            txtNgayTao.setText(Tags.FormatDate.dinhDangNgayThangNam(khoaHoc.getNgayTao()));
            btnThem.setEnabled(false);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }
    }

    private void formatData() {
        blockBtn();
        txtChuyenDe.setText(cbcChuyenDe.getSelectedItem().toString());
        txtHocPhi.setText("");
        txaGhiChu.setText("");
        txtKhaiGiang.setText("");
        txtThoiLuong.setText("");
        txtNgayTao.setText(Tags.FormatDate.dinhDangNgayThangNam(new Date()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLuuExcel;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbcChuyenDe;
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
    private javax.swing.JTable tbDanhSach;
    private javax.swing.JTextArea txaGhiChu;
    private javax.swing.JTextField txtChuyenDe;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtKhaiGiang;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
