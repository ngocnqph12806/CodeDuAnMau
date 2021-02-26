/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.QuanLyKhoaHoc;
import Controllers.QuanLyKhoaHocImplement;
import Controllers.QuanLyThongKe;
import Controllers.QuanLyThongKeImplement;
import Models.KhoaHoc;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NgocPJa
 */
public class FormThongKe1 extends javax.swing.JInternalFrame {

    private DefaultTableModel _modelBangDiem;
    private DefaultTableModel _modelNguoiHoc;
    private DefaultTableModel _modelDiemChuyenDe;
    private DefaultTableModel _modelDoanhThu;
    private QuanLyThongKe _iQuanLyThongKe = new QuanLyThongKeImplement();
    private QuanLyKhoaHoc _iQuanLyKhoaHoc = new QuanLyKhoaHocImplement();

    /**
     * Creates new form FormThongKe
     */
    public FormThongKe1() {
        initComponents();
        this.setClosable(true);
        this.setTitle("Tổng học & thống kê");
        setUpForm();
        if (Tags.Login._nhanVien == null) {
            Tags.MsgThongBao.alert(this, "Vui lòng đăng nhập");
            this.removeAll();
        }
    }

    public FormThongKe1(int indexTab) {
        initComponents();
        this.setClosable(true);
        this.setTitle("Tổng học & thống kê");
        setUpForm();
        jTabbedPane1.setSelectedIndex(indexTab);
    }

    protected void setUpForm() {
        try {
            _modelBangDiem = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            _modelDiemChuyenDe = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            _modelDoanhThu = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            _modelNguoiHoc = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tbBangDiem.setModel(_modelBangDiem);
            tbDiemChuyenDe.setModel(_modelDiemChuyenDe);
            tbDoanhThu.setModel(_modelDoanhThu);
            tbNguoiHoc.setModel(_modelNguoiHoc);
            setColTableBangDiem();
            setColTableDiemChuyenDe();
            setColTableDoanhThu();
            setColTableNguoiHoc();
            setRowTableNguoiHoc();
            setRowTableDiemChuyenDe();
            setCbcNamHoc();
            setCbcKhoaHoc();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCbcKhoaHoc() {
        cbcKhoaHoc.removeAllItems();
        for (KhoaHoc x : _iQuanLyKhoaHoc.getListKhoaHoc()) {
            cbcKhoaHoc.addItem(x.getMaKhoaHoc());
        }
    }

    private void setCbcNamHoc() {
        cbcNam.removeAllItems();
        for (Integer x : _iQuanLyThongKe.getListNamHoc()) {
            cbcNam.addItem(x.toString());
        }
    }

    private void setColTableBangDiem() {
        String[] arrCol = {"Mã NH", "Họ và tên", "Điểm", "Xếp loại"};
        for (String x : arrCol) {
            _modelBangDiem.addColumn(x);
        }
    }

    private void setRowTableBangDiem(String khoaHoc) {
        _modelBangDiem.setRowCount(0);
        for (Object[] x : _iQuanLyThongKe.getListThongKeBangDiem(khoaHoc)) {
            _modelBangDiem.addRow(new Object[]{
                x[0], x[1], x[2], xepLoai(Double.parseDouble(x[2] + ""))
            });
        }
    }

    private String xepLoai(Double diem) {
        if (diem < 5) {
            return "Chưa đạt";
        }
        if (diem < 6.5) {
            return "Trung bình";
        }
        if (diem < 7.5) {
            return "Khá";
        }
        if (diem < 9) {
            return "Giỏi";
        }
        if (diem <= 10) {
            return "Xuất sắc";
        }
        return "";
    }

    private void setColTableDiemChuyenDe() {
        String[] arrCol = {"Chuyên đề", "SL HV", "Điểm TN", "Điểm CN", "Điểm TB"};
        for (String x : arrCol) {
            _modelDiemChuyenDe.addColumn(x);
        }
    }

    private void setRowTableDiemChuyenDe() {
        _modelDiemChuyenDe.setRowCount(0);
        for (Object[] x : _iQuanLyThongKe.getListThongKeDiemChuyenDe()) {
            _modelDiemChuyenDe.addRow(x);
        }
    }

    private void setRowTableDoanhThu(int namHoc) {
        _modelDoanhThu.setRowCount(0);
        for (Object[] x : _iQuanLyThongKe.getListThongKeDoanhThu(namHoc)) {
            _modelDoanhThu.addRow(x);
        }
    }

    private void setColTableDoanhThu() {
        String[] arrCol = {"Chuyên đề", "Số KH", "Số HV", "Doanh thu", "Thấp nhất", "Cao nhất", "Trung bình"};
        for (String x : arrCol) {
            _modelDoanhThu.addColumn(x);
        }
    }

    private void setColTableNguoiHoc() {
        String[] arrCol = {"Năm", "Số NH", "ĐK sớm nhất", "ĐK muộn nhất"};
        for (String x : arrCol) {
            _modelNguoiHoc.addColumn(x);
        }
    }

    private void setRowTableNguoiHoc() {
        _modelNguoiHoc.setRowCount(0);
        for (Object[] x : _iQuanLyThongKe.getListThongKeSoLuongNguoiHoc()) {
            _modelNguoiHoc.addRow(x);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbcKhoaHoc = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbBangDiem = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNguoiHoc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDiemChuyenDe = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbcNam = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDoanhThu = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ CHUYÊN ĐỀ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Khóa học:");

        cbcKhoaHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbcKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcKhoaHocActionPerformed(evt);
            }
        });

        tbBangDiem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbBangDiem);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbcKhoaHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbcKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bảng điểm", jPanel1);

        tbNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbNguoiHoc);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Người học", jPanel2);

        tbDiemChuyenDe.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbDiemChuyenDe);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Điểm chuyên đề", jPanel3);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Năm:");

        cbcNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbcNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcNamActionPerformed(evt);
            }
        });

        tbDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbDoanhThu);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbcNam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbcNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Doanh thu", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbcKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcKhoaHocActionPerformed
        try {
            String khoaHoc = cbcKhoaHoc.getSelectedItem().toString();
            if (khoaHoc != null) {
                setRowTableBangDiem(khoaHoc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbcKhoaHocActionPerformed

    private void cbcNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcNamActionPerformed
        try {
            String namHoc = cbcNam.getSelectedItem().toString();
            if (namHoc != null) {
                setRowTableDoanhThu(Integer.parseInt(namHoc));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbcNamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbcKhoaHoc;
    private javax.swing.JComboBox<String> cbcNam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbBangDiem;
    private javax.swing.JTable tbDiemChuyenDe;
    private javax.swing.JTable tbDoanhThu;
    private javax.swing.JTable tbNguoiHoc;
    // End of variables declaration//GEN-END:variables
}
