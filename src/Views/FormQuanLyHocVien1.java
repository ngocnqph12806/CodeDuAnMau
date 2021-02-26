/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.QuanLyChuyenDe;
import Controllers.QuanLyChuyenDeImplement;
import Controllers.QuanLyHocVien;
import Controllers.QuanLyHocVienImplement;
import Controllers.QuanLyKhoaHoc;
import Controllers.QuanLyKhoaHocImplement;
import Controllers.QuanLyNguoiHoc;
import Controllers.QuanLyNguoiHocImplement;
import Models.ChuyenDe;
import Models.HocVien;
import Models.KhoaHoc;
import Models.NguoiHoc;
import Tags.FormatDate;
import Tags.SaveExcel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NgocPJa
 */
public class FormQuanLyHocVien1 extends javax.swing.JInternalFrame {

    private QuanLyChuyenDe _iQuanLyChuyenDe = new QuanLyChuyenDeImplement();
    private QuanLyKhoaHoc _iQuanLyKhoaHoc = new QuanLyKhoaHocImplement();
    private QuanLyNguoiHoc _iQuanLyNguoiHoc = new QuanLyNguoiHocImplement();
    private QuanLyHocVien _iQuanLyHocVien = new QuanLyHocVienImplement();
    private DefaultTableModel _modelDanhSachHocVien;
    private DefaultTableModel _modelDanhSachNguoiHoc;
    private List<ChuyenDe> _lstChuyenDe = null;
    private List<KhoaHoc> _lstKhoaHoc = null;

    public FormQuanLyHocVien1() {
        initComponents();
        this.setClosable(true);
        this.setTitle("Quản lý học viên");
        setUpForm();
        if (Tags.Login._nhanVien == null) {
            Tags.MsgThongBao.alert(this, "Vui lòng đăng nhập");
            this.removeAll();
        }
    }

    protected void setUpForm() {
        btnXoaKhoiKhoaHoc.setEnabled(Tags.Login._nhanVien.isVaiTro());
        _modelDanhSachHocVien = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                switch (column) {
                    case 4:
                        return true;
                    default:
                        return false;
                }
            }

        };
        _modelDanhSachNguoiHoc = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        tbDanhSachHocVien.setModel(_modelDanhSachHocVien);
        tbDanhSachNguoiHoc.setModel(_modelDanhSachNguoiHoc);
        setColTableDanhSachHocVien();
        setColTableDanhSachNguoiHoc();
        txtTimKiemNguoiHoc("");
        setCbcChuyenDe();
        String maChuyenDe = null;
        if (cbcChuyenDe.getSelectedIndex() > -1) {
            maChuyenDe = _lstChuyenDe.get(cbcChuyenDe.getSelectedIndex()).getMaChuyenDe();
            setCbcKhoaHoc(maChuyenDe);
        }
        if (cbcKhoaHoc.getSelectedIndex() > -1) {
            loadDataTableHocVien(_lstKhoaHoc.get(cbcKhoaHoc.getSelectedIndex()).getMaKhoaHoc());
        }
    }

    private void setCbcChuyenDe() {
        _lstChuyenDe = new ArrayList<>();
        _lstChuyenDe = _iQuanLyChuyenDe.getListChuyenDe();
        cbcChuyenDe.removeAllItems();
        for (ChuyenDe x : _lstChuyenDe) {
            cbcChuyenDe.addItem(x.getTenChuyenDe());
        }
    }

    private void setCbcKhoaHoc(String maChuyenDe) {
        _lstKhoaHoc = new ArrayList<>();
        _lstKhoaHoc = _iQuanLyKhoaHoc.getListKhoaHocByIdChuyenDe(maChuyenDe);
        cbcKhoaHoc.removeAllItems();
        for (KhoaHoc x : _lstKhoaHoc) {
            cbcKhoaHoc.addItem(x.getMaKhoaHoc() + "(" + x.getNgayKhaiGiang() + ")");
        }
    }

    private void loadDataTableHocVien(String maKhoaHoc) {
        int stt = 0;
        _modelDanhSachHocVien.setRowCount(0);
        for (HocVien x : _iQuanLyHocVien.getListHocVien()) {
            if (x.getMaKhoaHoc().equals(maKhoaHoc)) {
                _modelDanhSachHocVien.addRow(new Object[]{
                    ++stt, x.getMaHocVien(), x.getMaNguoiHoc(),
                    _iQuanLyNguoiHoc.getTenNguoiHoc(x.getMaNguoiHoc()), x.getDiem()
                });
            }
        }
    }

    private void setColTableDanhSachHocVien() {
        String[] arrCol = {"TT", "Mã HV", "Mã NH", "Họ và tên", "Điểm"};
        for (String x : arrCol) {
            _modelDanhSachHocVien.addColumn(x);
        }
    }

    private void setColTableDanhSachNguoiHoc() {
        String[] arrCol = {"Mã NH", "Họ và tên", "Giới tính", "Ngày sinh", "Điện thoại", "Email"};
        for (String x : arrCol) {
            _modelDanhSachNguoiHoc.addColumn(x);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbcChuyenDe = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cbcKhoaHoc = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDanhSachHocVien = new javax.swing.JTable();
        btnCapNhatDiem = new javax.swing.JButton();
        btnXoaKhoiKhoaHoc = new javax.swing.JButton();
        btnXoaKhoiKhoaHoc1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDanhSachNguoiHoc = new javax.swing.JTable();
        btnThemVaoKhoaHoc = new javax.swing.JButton();
        btnThemVaoKhoaHoc1 = new javax.swing.JButton();

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
                .addComponent(cbcChuyenDe, 0, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbcChuyenDe, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("KHÓA HỌC"));

        cbcKhoaHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbcKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcKhoaHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbcKhoaHoc, 0, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbcKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbDanhSachHocVien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbDanhSachHocVien);

        btnCapNhatDiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCapNhatDiem.setText("Cập nhật điểm");
        btnCapNhatDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatDiemActionPerformed(evt);
            }
        });

        btnXoaKhoiKhoaHoc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaKhoiKhoaHoc.setText("Xóa khỏi khóa học");
        btnXoaKhoiKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiKhoaHocActionPerformed(evt);
            }
        });

        btnXoaKhoiKhoaHoc1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaKhoiKhoaHoc1.setText("Lưu Excel");
        btnXoaKhoiKhoaHoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiKhoaHoc1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoaKhoiKhoaHoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaKhoiKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhatDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhatDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaKhoiKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaKhoiKhoaHoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Học viên", jPanel3);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbDanhSachNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbDanhSachNguoiHoc);

        btnThemVaoKhoaHoc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemVaoKhoaHoc.setText("Thêm vào khóa học");
        btnThemVaoKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoKhoaHocActionPerformed(evt);
            }
        });

        btnThemVaoKhoaHoc1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemVaoKhoaHoc1.setText("Lưu Excel");
        btnThemVaoKhoaHoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoKhoaHoc1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemVaoKhoaHoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemVaoKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemVaoKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemVaoKhoaHoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Người học", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbcChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcChuyenDeActionPerformed
        try {
            if (cbcChuyenDe.getSelectedIndex() > -1) {
                String maChuyenDe = _lstChuyenDe.get(cbcChuyenDe.getSelectedIndex()).getMaChuyenDe();
                setCbcKhoaHoc(maChuyenDe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbcChuyenDeActionPerformed

    private void cbcKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcKhoaHocActionPerformed
        try {
            int index = cbcKhoaHoc.getSelectedIndex();
            if (index > -1) {
                loadDataTableHocVien(_lstKhoaHoc.get(index).getMaKhoaHoc());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbcKhoaHocActionPerformed

    private void btnCapNhatDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatDiemActionPerformed
        int count = 0;
        for (int i = 0; i < tbDanhSachHocVien.getRowCount(); i++) {
            String maHocVien = tbDanhSachHocVien.getValueAt(i, 1).toString();
            HocVien hocVien = _iQuanLyHocVien.getHocVienById(maHocVien);
            if (hocVien != null) {
                double diemMoi = Double.parseDouble(tbDanhSachHocVien.getValueAt(i, 4).toString());
                if (diemMoi < 0 || diemMoi > 10) {
                    //                    Tags.MsgThongBao.alert(this, "Điểm của sinh viên " + hocVien.getMaHocVien() + " phải nằm trong khoảng 0 - 10.");
                } else {
                    if (diemMoi != hocVien.getDiem()) {
                        hocVien.setDiem(diemMoi);
                        if (_iQuanLyHocVien.editHocVien(hocVien)) {
                            count++;
                        }
                    }
                }
            }
        }
        if (count > 0) {
            Tags.MsgThongBao.alert(this, "Đã có " + count + " học viên được cập nhật điểm!");
        } else {
            Tags.MsgThongBao.alert(this, "Không có học viên nào được cập nhật điểm!");
        }

        int index = tbDanhSachHocVien.getSelectedRow();
        if (index > -1) {
            String maHocVien = tbDanhSachHocVien.getValueAt(index, 1).toString();
            HocVien hocVien = _iQuanLyHocVien.getHocVienById(maHocVien);
            if (hocVien != null) {
                hocVien.setDiem(Double.parseDouble(tbDanhSachHocVien.getValueAt(index, 4).toString()));

            }
        }
    }//GEN-LAST:event_btnCapNhatDiemActionPerformed

    private void btnXoaKhoiKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiKhoaHocActionPerformed
        int[] arrSelectRowTableHocVien = tbDanhSachHocVien.getSelectedRows();
        if (arrSelectRowTableHocVien.length > 0) {
            if (Tags.MsgThongBao.confirm(this, "Đồng ý xóa " + arrSelectRowTableHocVien.length + " học viên ra khỏi khóa học?")) {
                int count = 0;
                for (int i : arrSelectRowTableHocVien) {
                    String getMaHocVien = tbDanhSachHocVien.getValueAt(i, 1).toString();
                    if (_iQuanLyHocVien.removeHocVien(getMaHocVien)) {
                        count++;
                    }
                }
                if (count > 0) {
                    Tags.MsgThongBao.alert(this, "Đã xóa " + count + " học viên!");
                    int index = cbcKhoaHoc.getSelectedIndex();
                    if (index > -1) {
                        loadDataTableHocVien(_lstKhoaHoc.get(index).getMaKhoaHoc());
                    }
                } else {
                    Tags.MsgThongBao.alert(this, "Xóa thất bại!");
                }
            }
        } else {
            Tags.MsgThongBao.alert(this, "Vui lòng chọn học viên muốn xóa khỏi khóa học!");
        }
    }//GEN-LAST:event_btnXoaKhoiKhoaHocActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        try {
            String getInput = txtTimKiem.getText();
            txtTimKiemNguoiHoc(getInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnThemVaoKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoKhoaHocActionPerformed
        int[] arrSelectRowTableNguoiHoc = tbDanhSachNguoiHoc.getSelectedRows();
        if (arrSelectRowTableNguoiHoc.length > 0) {
            if (Tags.MsgThongBao.confirm(this, "Đồng ý thêm " + arrSelectRowTableNguoiHoc.length + " vào khóa học?")) {
                int count = 0;
                for (int i : arrSelectRowTableNguoiHoc) {
                    HocVien hocVien = new HocVien((_iQuanLyHocVien.getIdHocVien() + 1) + "",
                            _lstKhoaHoc.get(cbcKhoaHoc.getSelectedIndex()).getMaKhoaHoc(),
                            tbDanhSachNguoiHoc.getValueAt(i, 0).toString(), 0);
                    if (_iQuanLyHocVien.addHocVien(hocVien)) {
                        count++;
                    }
                }
                if (count > 0) {
                    Tags.MsgThongBao.alert(this, "Đã thêm " + count + " học viên!");
                    int index = cbcKhoaHoc.getSelectedIndex();
                    if (index > -1) {
                        loadDataTableHocVien(_lstKhoaHoc.get(index).getMaKhoaHoc());
                    }
                } else {
                    Tags.MsgThongBao.alert(this, "Thêm thất bại!");
                }
            }
        } else {
            Tags.MsgThongBao.alert(this, "Vui lòng chọn người học muốn thêm!");
        }
    }//GEN-LAST:event_btnThemVaoKhoaHocActionPerformed

    private void btnXoaKhoiKhoaHoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiKhoaHoc1ActionPerformed
        SaveExcel.exportExcel(tbDanhSachHocVien, _modelDanhSachHocVien, this.getTitle() + " Học viên");
    }//GEN-LAST:event_btnXoaKhoiKhoaHoc1ActionPerformed

    private void btnThemVaoKhoaHoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoKhoaHoc1ActionPerformed
        SaveExcel.exportExcel(tbDanhSachNguoiHoc, _modelDanhSachNguoiHoc, this.getTitle() + " Người học");
    }//GEN-LAST:event_btnThemVaoKhoaHoc1ActionPerformed

    private void txtTimKiemNguoiHoc(String maNguoiHoc) {
        List<NguoiHoc> lstTimKiem = _iQuanLyNguoiHoc.getListTimKiem(maNguoiHoc);
        _modelDanhSachNguoiHoc.setRowCount(0);
        for (NguoiHoc x : lstTimKiem) {
            _modelDanhSachNguoiHoc.addRow(new Object[]{
                x.getMaNguoiHoc(), x.getHoTen(), x.isGioiTinh() ? "Nam" : "Nữ",
                FormatDate.dinhDangNgayThangNam(x.getNgaySinh()),
                x.getSoDienThoai(), x.getEmail()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatDiem;
    private javax.swing.JButton btnThemVaoKhoaHoc;
    private javax.swing.JButton btnThemVaoKhoaHoc1;
    private javax.swing.JButton btnXoaKhoiKhoaHoc;
    private javax.swing.JButton btnXoaKhoiKhoaHoc1;
    private javax.swing.JComboBox<String> cbcChuyenDe;
    private javax.swing.JComboBox<String> cbcKhoaHoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbDanhSachHocVien;
    private javax.swing.JTable tbDanhSachNguoiHoc;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
