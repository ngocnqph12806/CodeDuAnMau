/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.QuanLyNhanVien;
import Controllers.QuanLyNhanVienImplement;
import Models.NhanVien;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NgocPJa
 */
public class FormQuanLyNhanVien1 extends javax.swing.JInternalFrame {
    
    private DefaultTableModel _modelDanhSachNhanVien;
    private QuanLyNhanVien _iQuanLyNhanVien = new QuanLyNhanVienImplement();

    /**
     * Creates new form EmployeeManager
     */
    public FormQuanLyNhanVien1() {
        initComponents();
        this.setClosable(true);
        this.setTitle("Quản lý nhân viên");
        setUpForm();
        if (Tags.Login._nhanVien == null) {
            Tags.MsgThongBao.alert(this, "Vui lòng đăng nhập");
            this.removeAll();
        }
    }
    
    protected void setUpForm() {
        try {
            _modelDanhSachNhanVien = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; //To change body of generated methods, choose Tools | Templates.
                }
            };
            tbDanhSach.setModel(_modelDanhSachNhanVien);
            setColTableDanhSachNhanVien();
            setRowTableDanhSachNhanVien();
            ButtonGroup bg = new ButtonGroup();
            bg.add(raNhanVien);
            bg.add(raTruongPhong);
            raNhanVien.setSelected(true);
            blockBtn();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void blockBtn() {
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnNext.setEnabled(!(_modelDanhSachNhanVien.getRowCount() == 0));
        btnFirst.setEnabled(!(_modelDanhSachNhanVien.getRowCount() == 0));
        btnLast.setEnabled(!(_modelDanhSachNhanVien.getRowCount() == 0));
        btnPrev.setEnabled(!(_modelDanhSachNhanVien.getRowCount() == 0));
    }
    
    private void setColTableDanhSachNhanVien() {
        String[] arrCol = {"Mã NV", "Mật khẩu", "Họ và tên", "Vai trò"};
        for (String x : arrCol) {
            _modelDanhSachNhanVien.addColumn(x);
        }
    }
    
    private void setRowTableDanhSachNhanVien() {
        _modelDanhSachNhanVien.setRowCount(0);
        for (NhanVien x : _iQuanLyNhanVien.getListNhanVien()) {
            if (Tags.Login._nhanVien == null || !Tags.Login._nhanVien.getMaNV().equalsIgnoreCase(x.getMaNV())) {
                _modelDanhSachNhanVien.addRow(new Object[]{
                    x.getMaNV(), convertPassword(x.getMatKhau()), x.getHoTen(), x.isVaiTro() ? "Trưởng phòng" : "Nhân viên"
                });
            }
        }
    }
    
    private String convertPassword(String password) {
        if (password != null) {
            String pass = "";
            for (char c : password.toCharArray()) {
                pass += "*";
            }
            return pass;
        }
        return "null";
    }
    
    private void formatData() {
        blockBtn();
        txtMaNhanVien.setEditable(true);
        txtMaNhanVien.setText("");
        txtMatKhau.setText("");
        txtXacNhanMatKhau.setText("");
        txtHoVaTen.setText("");
        raNhanVien.setSelected(true);
    }
    
    private void evtAcctionNhanVien(String type) {
        String getMaNhanVien = txtMaNhanVien.getText();
        String getMatKhau = new String(txtMatKhau.getText());
        String getXacNhanMatKhau = new String(txtXacNhanMatKhau.getText());
        String getHoTen = txtHoVaTen.getText();
        StringBuilder sp = new StringBuilder();
        sp.append(Tags.Pattern.checkMa(getMaNhanVien, "Mã nhân viên"));
        if (getMatKhau.isBlank() || getMatKhau.isEmpty()) {
            sp.append("Mật khẩu không được để trống!\n");
        } else if (getMatKhau.length() < 8) {
            sp.append("Mật khẩu phải có độ dài từ 8 ký tự!\n");
        } else if (!getMatKhau.equals(getXacNhanMatKhau)) {
            sp.append("Mật khẩu không khớp nhau!\n");
        }
        sp.append(Tags.Pattern.checkTen(getHoTen, "Họ và tên"));
        if (_iQuanLyNhanVien.getNhanVienById(getMaNhanVien) != null && type.equalsIgnoreCase("add")) {
            Tags.MsgThongBao.alert(this, "Mã nhân viên đã tồn tại!");
            return;
        }
        if (sp.length() == 0) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setHoTen(getHoTen);
            nhanVien.setMaNV(getMaNhanVien);
            nhanVien.setMatKhau(getMatKhau);
            nhanVien.setVaiTro(raTruongPhong.isSelected());
            if (type.equalsIgnoreCase("add")) {
                if (_iQuanLyNhanVien.addNhanVien(nhanVien)) {
                    Tags.MsgThongBao.alert(this, "Thêm thành công!");
                    setRowTableDanhSachNhanVien();
                    formatData();
                } else {
                    Tags.MsgThongBao.alert(this, "Thêm thất bại!");
                }
            } else if (type.equalsIgnoreCase("edit")) {
                if (_iQuanLyNhanVien.editNhanVien(nhanVien)) {
                    Tags.MsgThongBao.alert(this, "Sửa thành công!");
                    setRowTableDanhSachNhanVien();
                } else {
                    Tags.MsgThongBao.alert(this, "Sửa thất bại!");
                }
            }
        } else {
            Tags.MsgThongBao.alert(this, sp.toString());
        }
    }
    
    private void evtXoaNhanVien() {
        if (Tags.Login._nhanVien != null) {
            if (Tags.Login._nhanVien.isVaiTro()) {
                String getMaNhanVien = txtMaNhanVien.getText();
                if (getMaNhanVien == null || getMaNhanVien.isBlank() || getMaNhanVien.isEmpty()) {
                    getMaNhanVien = Tags.MsgThongBao.prompt(this, "Nhập mã nhân viên muốn xóa:");
                }
                NhanVien nhanVien = _iQuanLyNhanVien.getNhanVienById(getMaNhanVien);
                if (nhanVien != null) {
                    if (nhanVien.isVaiTro() != Tags.Login.checkNhanVien()) {
                        if (Tags.MsgThongBao.confirm(this, "Đồng ý xóa nhân viên " + getMaNhanVien.toUpperCase())) {
                            if (_iQuanLyNhanVien.removeNhanVien(nhanVien)) {
                                Tags.MsgThongBao.alert(this, "Xóa nhân viên thành công!");
                                setRowTableDanhSachNhanVien();
                                formatData();
                            } else {
                                Tags.MsgThongBao.alert(this, "Xóa thất bại!"
                                        + "\nNhân viên này đã được sử dụng trong bảng người học!");
                            }
                        }
                    } else {
                        Tags.MsgThongBao.alert(this, "Bạn không được phép xóa nhân viên có chức vụ như bạn!");
                    }
                } else {
                    Tags.MsgThongBao.alert(this, "Nhân viên không tồn tại!");
                }
            } else {
                Tags.MsgThongBao.alert(this, "Bạn không có quyên xóa nhân vien!");
            }
        } else {
            Tags.MsgThongBao.alert(this, "Vui lòng đăng nhập!");
        }
    }
    
    private int indexClickTable = -1;
    
    private void evtBtnActionTable(int index) {
        if (index > -1) {
            NhanVien nhanVien = _iQuanLyNhanVien.getNhanVienById((String) tbDanhSach.getValueAt(index, 0));
            setDataForm(nhanVien);
        }
    }
    
    private void setDataForm(NhanVien nhanVien) {
        blockBtn();
        if (nhanVien != null) {
            txtMaNhanVien.setText(nhanVien.getMaNV());
            txtMatKhau.setText(nhanVien.getMatKhau());
            txtXacNhanMatKhau.setText("");
            txtHoVaTen.setText(nhanVien.getHoTen());
            if (nhanVien.isVaiTro()) {
                raTruongPhong.setSelected(true);
            } else {
                raNhanVien.setSelected(true);
            }
            btnThem.setEnabled(false);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(Tags.Login._nhanVien.isVaiTro());
            txtMaNhanVien.setEditable(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        raTruongPhong = new javax.swing.JRadioButton();
        raNhanVien = new javax.swing.JRadioButton();
        txtMatKhau = new javax.swing.JPasswordField();
        txtXacNhanMatKhau = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDanhSach = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN QUẢN TRỊ");

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        txtMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Xác nhận mật khẩu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Họ và tên");

        txtHoVaTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã nhân viên");

        raTruongPhong.setText("Trưởng phòng");

        raNhanVien.setText("Nhân viên");

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtXacNhanMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(raTruongPhong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(raNhanVien))
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addComponent(txtMaNhanVien)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raTruongPhong)
                    .addComponent(raNhanVien))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi)
                    .addComponent(btnLast)
                    .addComponent(btnNext)
                    .addComponent(btnPrev)
                    .addComponent(btnFirst))
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

        jTabbedPane1.addTab("Danh sách", jScrollPane1);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
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

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            evtAcctionNhanVien("add");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            evtAcctionNhanVien("edit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            evtXoaNhanVien();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        try {
            formatData();
            btnThem.setEnabled(true);
            btnXoa.setEnabled(false);
            btnSua.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        try {
            indexClickTable = 0;
            tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
            evtBtnActionTable(indexClickTable);
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
            tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
            evtBtnActionTable(indexClickTable);
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
            tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
            evtBtnActionTable(indexClickTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        try {
            indexClickTable = tbDanhSach.getRowCount() - 1;
            tbDanhSach.setRowSelectionInterval(indexClickTable, indexClickTable);
            evtBtnActionTable(indexClickTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void tbDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhSachMouseClicked
        try {
            indexClickTable = tbDanhSach.getSelectedRow();
            evtBtnActionTable(indexClickTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbDanhSachMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton raNhanVien;
    private javax.swing.JRadioButton raTruongPhong;
    private javax.swing.JTable tbDanhSach;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtXacNhanMatKhau;
    // End of variables declaration//GEN-END:variables
}
