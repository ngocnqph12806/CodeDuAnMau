/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.QuanLyNguoiHoc;
import Controllers.QuanLyNguoiHocImplement;
import Models.NguoiHoc;
import Tags.FormatDate;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NgocPJa
 */
public class FormQuanLyNguoiHoc1 extends javax.swing.JInternalFrame {

    private DefaultTableModel _modelTableDanhSach;
    private QuanLyNguoiHoc _iQuanLyNguoiHoc = new QuanLyNguoiHocImplement();

    /**
     * Creates new form FormQuanLyNguoiHoc
     */
    public FormQuanLyNguoiHoc1() {
        initComponents();
        this.setClosable(true);
        this.setTitle("Quản lý người học");
        setUpForm();
        if (Tags.Login._nhanVien == null) {
            Tags.MsgThongBao.alert(this, "Vui lòng đăng nhập");
            this.removeAll();
        }
    }

    protected void setUpForm() {
        try {
            _modelTableDanhSach = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; //To change body of generated methods, choose Tools | Templates.
                }
            };
            tbDanhSach.setModel(_modelTableDanhSach);
            setColTableDanhSachNguoiHoc();
            setRowTableDanhSachNguoiHoc();
            blockBtn();
            ButtonGroup bg = new ButtonGroup();
            bg.add(raNam);
            bg.add(raNu);
            raNam.setSelected(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void blockBtn() {
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnNext.setEnabled(!(_modelTableDanhSach.getRowCount() == 0));
        btnFirst.setEnabled(!(_modelTableDanhSach.getRowCount() == 0));
        btnLast.setEnabled(!(_modelTableDanhSach.getRowCount() == 0));
        btnPrev.setEnabled(!(_modelTableDanhSach.getRowCount() == 0));
    }

    private void setColTableDanhSachNguoiHoc() {
        String[] arrCol = {"Mã NH", "Họ và tên", "Giới tính", "Ngày sinh",
            "Điện thoại", "Email", "Mã NV", "Ngày đăng ký"};
        for (String x : arrCol) {
            _modelTableDanhSach.addColumn(x);
        }
    }

    private void setRowTableDanhSachNguoiHoc() {
        _modelTableDanhSach.setRowCount(0);
        for (NguoiHoc x : _iQuanLyNguoiHoc.getListNguoihoc()) {
            _modelTableDanhSach.addRow(new Object[]{
                x.getMaNguoiHoc(), x.getHoTen(), x.isGioiTinh() ? "Nam" : "Nữ",
                FormatDate.dinhDangNgayThangNam(x.getNgaySinh()),
                x.getSoDienThoai(), x.getEmail(), x.getMaNV(),
                FormatDate.dinhDangNgayThangNam(x.getNgayDangKy())
            });
        }
    }

    private void formatData() {
        blockBtn();
        txtMaNguoiHoc.setEditable(true);
        txtMaNguoiHoc.setText("");
        txtHoTen.setText("");
        raNam.setSelected(true);
        txtNgaySinh.setText("");
        txtSoDienThoai.setText("");
        txtEmail.setText("");
        txaGhiChu.setText("");
    }

    private void btnActionNguoiHoc(String type) {
        String getMaNguoiHoc = txtMaNguoiHoc.getText();
        String getHoTen = txtHoTen.getText();
        String getNgaySinh = txtNgaySinh.getText();
        String getDienThoai = txtSoDienThoai.getText();
        String getEmail = txtEmail.getText();
        String getGhiChu = txaGhiChu.getText();
        StringBuilder sp = new StringBuilder();
        sp.append(Tags.Pattern.checkMa(getMaNguoiHoc, "Mã người học"));
        sp.append(Tags.Pattern.checkTen(getHoTen, "Họ và tên"));
        sp.append(Tags.Pattern.checkNgay(getNgaySinh, "Ngày sinh"));
        sp.append(Tags.Pattern.checkSoDienThoai(getDienThoai));
        sp.append(Tags.Pattern.checkEmail(getEmail));
        if (_iQuanLyNguoiHoc.getNguoiHocById(getMaNguoiHoc) != null && type.equalsIgnoreCase("add")) {
            Tags.MsgThongBao.alert(this, "Mã người học đã tồn tai!");
            return;
        }
        if (sp.length() == 0) {
            NguoiHoc nguoiHoc = new NguoiHoc();
            nguoiHoc.setEmail(getEmail);
            nguoiHoc.setGhiChu(getGhiChu);
            nguoiHoc.setGioiTinh(raNam.isSelected());
            nguoiHoc.setHoTen(getHoTen);
            nguoiHoc.setMaNguoiHoc(getMaNguoiHoc);
            nguoiHoc.setNgaySinh(Tags.FormatDate.convertNgayThangNam(getNgaySinh));
            nguoiHoc.setSoDienThoai(getDienThoai);
            if (type.equalsIgnoreCase("add")) {
                nguoiHoc.setMaNV(Tags.Login._nhanVien.getMaNV());
                nguoiHoc.setNgayDangKy(new Date());
                if (_iQuanLyNguoiHoc.addNguoiHoc(nguoiHoc)) {
                    Tags.MsgThongBao.alert(this, "Thêm thành công!");
                    setRowTableDanhSachNguoiHoc();
                    formatData();
                } else {
                    Tags.MsgThongBao.alert(this, "Thêm thất bại!");
                }
            } else if (type.equalsIgnoreCase("edit")) {
                nguoiHoc.setMaNV(tbDanhSach.getValueAt(indexClickTable, 6).toString());
                nguoiHoc.setNgayDangKy(Tags.FormatDate.convertNgayThangNam(tbDanhSach.getValueAt(indexClickTable, 7).toString()));
                if (_iQuanLyNguoiHoc.editNguoiHoc(nguoiHoc)) {
                    Tags.MsgThongBao.alert(this, "Sửa thành công!");
                    setRowTableDanhSachNguoiHoc();
                } else {
                    Tags.MsgThongBao.alert(this, "Sửa thất bại!");
                }
            }
        } else {
            Tags.MsgThongBao.alert(this, sp.toString());
        }
    }

    private void btnXoaNguoiHoc() {
        String getMaNguoiHoc = txtMaNguoiHoc.getText();
        if (getMaNguoiHoc == null || getMaNguoiHoc.isBlank() || getMaNguoiHoc.isEmpty()) {
            getMaNguoiHoc = getMaNguoiHoc = Tags.MsgThongBao.prompt(this, "Nhập mã người học muỗn xóa:");
        }
        NguoiHoc nguoiHoc = _iQuanLyNguoiHoc.getNguoiHocById(getMaNguoiHoc);
        if (nguoiHoc != null) {
            if (_iQuanLyNguoiHoc.removeNguoiHoc(nguoiHoc.getMaNguoiHoc())) {
                Tags.MsgThongBao.alert(this, "Xóa thành công!");
            } else {
                Tags.MsgThongBao.alert(this, "Xóa thất bại!"
                        + "Mã người có thể đã được học tại một khóa học nào đó."
                        + "Vui lòng kiểm tra lại!");
                setRowTableDanhSachNguoiHoc();
                formatData();
            }
        } else {
            Tags.MsgThongBao.alert(this, "Người học không tồn tai!");
        }
    }

    private int indexClickTable = -1;

    private void evtBtnActionTable(int index) {
        if (index > -1) {
            NguoiHoc nguoiHoc = _iQuanLyNguoiHoc.getNguoiHocById((String) tbDanhSach.getValueAt(index, 0));
            setDataForm(nguoiHoc);
        }
    }

    private void setDataForm(NguoiHoc nguoiHoc) {
        blockBtn();
        if (nguoiHoc != null) {
            txtMaNguoiHoc.setText(nguoiHoc.getMaNguoiHoc());
            txtHoTen.setText(nguoiHoc.getHoTen());
            txtNgaySinh.setText(Tags.FormatDate.dinhDangNgayThangNam(nguoiHoc.getNgaySinh()));
            txtSoDienThoai.setText(nguoiHoc.getSoDienThoai());
            txtEmail.setText(nguoiHoc.getEmail());
            txaGhiChu.setText(nguoiHoc.getGhiChu());
            if (nguoiHoc.isGioiTinh()) {
                raNam.setSelected(true);
            } else {
                raNu.setSelected(true);
            }
            btnThem.setEnabled(false);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
            txtMaNguoiHoc.setEditable(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNguoiHoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        raNam = new javax.swing.JRadioButton();
        raNu = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDanhSach = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ NGƯỜI HỌC");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã người học");

        txtMaNguoiHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ và tên");

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Giới tính");

        raNam.setText("Nam");

        raNu.setText("Nữ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ngày sinh");

        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Điện thoại");

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Địa chỉ Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Ghi chú");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNguoiHoc)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(raNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(raNu)))
                        .addGap(236, 236, 236)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtNgaySinh)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtEmail)))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtMaNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(raNam)
                            .addComponent(raNu)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            btnActionNguoiHoc("add");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            btnActionNguoiHoc("edit");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            btnXoaNguoiHoc();
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton raNam;
    private javax.swing.JRadioButton raNu;
    private javax.swing.JTable tbDanhSach;
    private javax.swing.JTextArea txaGhiChu;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNguoiHoc;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
