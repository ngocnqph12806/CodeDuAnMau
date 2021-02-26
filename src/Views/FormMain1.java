package Views;

import DAO.DAOConnection;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.Timer;

/**
 *
 * @author NgocPJa
 */
public class FormMain1 extends javax.swing.JFrame {

    private FormDoiMatKhau1 _FormDoiMatKhau1 = new FormDoiMatKhau1();
    private FormQuanLyNguoiHoc1 _FormQuanLyNguoiHoc1 = new FormQuanLyNguoiHoc1();
    private FormQuanLyChuyenDe1 _FormQuanLyChuyenDe1 = new FormQuanLyChuyenDe1();
    private FormQuanLyHocVien1 _FormQuanLyHocVien1 = new FormQuanLyHocVien1();
    private FormQuanLyKhoaHoc1 _FormQuanLyKhoaHoc1 = new FormQuanLyKhoaHoc1();
    private FormQuanLyNhanVien1 _FormQuanLyNhanVien1 = new FormQuanLyNhanVien1();
    private FormThongKe1 _FormThongKe1 = new FormThongKe1();
    private JInternalFrame[] arrComponents = {_FormDoiMatKhau1, _FormQuanLyNguoiHoc1, _FormQuanLyChuyenDe1,
        _FormQuanLyHocVien1, _FormQuanLyKhoaHoc1, _FormQuanLyNhanVien1, _FormThongKe1};

    /**
     * Creates new form Main
     */
    public FormMain1() {
        setUpForm();
        deskPane.add(_FormDoiMatKhau1);
        if (Tags.Login._nhanVien == null) {
            Tags.MsgThongBao.alert(this, "Vui lòng đăng nhập");
            System.exit(0);
        }
        mnuThongKe.setVisible(Tags.Login._nhanVien.isVaiTro());
        menuNhanVien.setVisible(Tags.Login._nhanVien.isVaiTro());
        menuDangNhap.setVisible(Tags.Login._nhanVien == null);
    }

    private void setUpForm() {
        initComponents();
        try {
            setLocationRelativeTo(this);
            setResizable(false);
            this.setTitle("Phần mềm EduSys");
            setTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void setTime() {
        Timer time = new Timer(1000, new ActionListener() {
            int gio = Integer.parseInt(new SimpleDateFormat("hh").format(new Date()));
            int phut = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
            int giay = Integer.parseInt(new SimpleDateFormat("ss").format(new Date()));

            @Override
            public void actionPerformed(ActionEvent e) {
                lblTime.setText(String.format("%02d", gio) + ":" + String.format("%02d", phut) + ":" + String.format("%02d", giay++));
                if (giay == 60) {
                    phut++;
                    giay = 0;
                }
                if (phut == 60) {
                    gio++;
                    phut = 0;
                }
                if (gio == 12) {
                    gio = 0;
                }

            }
        });
        time.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnDangXuat = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        btnChuyenDe = new javax.swing.JButton();
        btnNguoiHoc = new javax.swing.JButton();
        btnKhoaHoc = new javax.swing.JButton();
        btnHocVien = new javax.swing.JButton();
        btnHuongDan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        deskPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuDangNhap = new javax.swing.JMenuItem();
        menuDangXuat = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuDoiMatKhau = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuKetThuc = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuChuyenDe = new javax.swing.JMenuItem();
        menuKhoaHoc = new javax.swing.JMenuItem();
        menuNguoiHoc = new javax.swing.JMenuItem();
        menuHocVien = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuNhanVien = new javax.swing.JMenuItem();
        mnuThongKe = new javax.swing.JMenu();
        menuBangDiem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuLuongNguoiHoc = new javax.swing.JMenuItem();
        menuDiemChuyenDe = new javax.swing.JMenuItem();
        menuDoanhThu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuHuongDanSuDung = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuGioiThieuSanPham = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(102, 102, 102));
        jToolBar1.setRollover(true);

        btnDangXuat.setBackground(new java.awt.Color(204, 204, 204));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Log Out/Log Out_24x24.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setFocusable(false);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDangXuat);

        btnKetThuc.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel/Cancel_24x24.png"))); // NOI18N
        btnKetThuc.setText("Kết thúc");
        btnKetThuc.setFocusable(false);
        btnKetThuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKetThuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKetThuc);

        btnChuyenDe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Copy/Copy_24x24.png"))); // NOI18N
        btnChuyenDe.setText("Chuyên đề");
        btnChuyenDe.setFocusable(false);
        btnChuyenDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenDe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenDeActionPerformed(evt);
            }
        });
        jToolBar1.add(btnChuyenDe);

        btnNguoiHoc.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Properties/Properties_24x24.png"))); // NOI18N
        btnNguoiHoc.setText("Người học");
        btnNguoiHoc.setFocusable(false);
        btnNguoiHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNguoiHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNguoiHocActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNguoiHoc);

        btnKhoaHoc.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Paste/Paste_24x24.png"))); // NOI18N
        btnKhoaHoc.setText("Khóa học");
        btnKhoaHoc.setFocusable(false);
        btnKhoaHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoaHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaHocActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKhoaHoc);

        btnHocVien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User/User_24x24.png"))); // NOI18N
        btnHocVien.setText("Học viên");
        btnHocVien.setFocusable(false);
        btnHocVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHocVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHocVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHocVienActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHocVien);

        btnHuongDan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Globe/Globe_24x24.png"))); // NOI18N
        btnHuongDan.setText("Hướng dẫn");
        btnHuongDan.setFocusable(false);
        btnHuongDan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuongDanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHuongDan);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Information/Information_16x16.png"))); // NOI18N
        jLabel3.setText("Hệ thống quản lý đào tạo");
        jPanel1.add(jLabel3);

        lblTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Calendar/Calendar_16x16.png"))); // NOI18N
        lblTime.setText("Time");
        jPanel1.add(lblTime);

        javax.swing.GroupLayout deskPaneLayout = new javax.swing.GroupLayout(deskPane);
        deskPane.setLayout(deskPaneLayout);
        deskPaneLayout.setHorizontalGroup(
            deskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        deskPaneLayout.setVerticalGroup(
            deskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        jMenu1.setText("Hệ thống");

        menuDangNhap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Key/Key_16x16.png"))); // NOI18N
        menuDangNhap.setText("Đăng nhập");
        menuDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDangNhapActionPerformed(evt);
            }
        });
        jMenu1.add(menuDangNhap);

        menuDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Log Out/Log Out_16x16.png"))); // NOI18N
        menuDangXuat.setText("Đăng xuất");
        menuDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDangXuatActionPerformed(evt);
            }
        });
        jMenu1.add(menuDangXuat);
        jMenu1.add(jSeparator1);

        menuDoiMatKhau.setText("Đổi mật khẩu");
        menuDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDoiMatKhauActionPerformed(evt);
            }
        });
        jMenu1.add(menuDoiMatKhau);
        jMenu1.add(jSeparator2);

        menuKetThuc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel/Cancel_16x16.png"))); // NOI18N
        menuKetThuc.setText("Kết thúc");
        menuKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKetThucActionPerformed(evt);
            }
        });
        jMenu1.add(menuKetThuc);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Quản lý");

        menuChuyenDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Copy/Copy_16x16.png"))); // NOI18N
        menuChuyenDe.setText("Chuyên đề");
        menuChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChuyenDeActionPerformed(evt);
            }
        });
        jMenu2.add(menuChuyenDe);

        menuKhoaHoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Paste/Paste_16x16.png"))); // NOI18N
        menuKhoaHoc.setText("Khóa học");
        menuKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKhoaHocActionPerformed(evt);
            }
        });
        jMenu2.add(menuKhoaHoc);

        menuNguoiHoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Properties/Properties_16x16.png"))); // NOI18N
        menuNguoiHoc.setText("Người học");
        menuNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNguoiHocActionPerformed(evt);
            }
        });
        jMenu2.add(menuNguoiHoc);

        menuHocVien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User/User_16x16.png"))); // NOI18N
        menuHocVien.setText("Học viên");
        menuHocVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHocVienActionPerformed(evt);
            }
        });
        jMenu2.add(menuHocVien);
        jMenu2.add(jSeparator3);

        menuNhanVien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User/User_16x16.png"))); // NOI18N
        menuNhanVien.setText("Nhân viên");
        menuNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNhanVienActionPerformed(evt);
            }
        });
        jMenu2.add(menuNhanVien);

        jMenuBar1.add(jMenu2);

        mnuThongKe.setText("Thống kê");

        menuBangDiem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuBangDiem.setText("Bảng điểm");
        menuBangDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBangDiemActionPerformed(evt);
            }
        });
        mnuThongKe.add(menuBangDiem);
        mnuThongKe.add(jSeparator4);

        menuLuongNguoiHoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuLuongNguoiHoc.setText("Lượng người học");
        menuLuongNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLuongNguoiHocActionPerformed(evt);
            }
        });
        mnuThongKe.add(menuLuongNguoiHoc);

        menuDiemChuyenDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuDiemChuyenDe.setText("Điểm chuyên đề");
        menuDiemChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDiemChuyenDeActionPerformed(evt);
            }
        });
        mnuThongKe.add(menuDiemChuyenDe);

        menuDoanhThu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuDoanhThu.setText("Doanh thu");
        menuDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDoanhThuActionPerformed(evt);
            }
        });
        mnuThongKe.add(menuDoanhThu);

        jMenuBar1.add(mnuThongKe);

        jMenu4.setText("Trợ giúp");

        menuHuongDanSuDung.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuHuongDanSuDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Help/Help_16x16.png"))); // NOI18N
        menuHuongDanSuDung.setText("Hướng dẫn sử dụng");
        menuHuongDanSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHuongDanSuDungActionPerformed(evt);
            }
        });
        jMenu4.add(menuHuongDanSuDung);
        jMenu4.add(jSeparator5);

        menuGioiThieuSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Presentation/Presentation_16x16.png"))); // NOI18N
        menuGioiThieuSanPham.setText("Giới thiệu sản phẩm");
        menuGioiThieuSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGioiThieuSanPhamActionPerformed(evt);
            }
        });
        jMenu4.add(menuGioiThieuSanPham);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(deskPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deskPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKhoaHocActionPerformed
        _FormQuanLyKhoaHoc1.setUpForm();
        openTab(_FormQuanLyKhoaHoc1);
    }//GEN-LAST:event_menuKhoaHocActionPerformed

    private void menuKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKetThucActionPerformed
        try {
            evtKetThuc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuKetThucActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        try {
            evtKetThuc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        try {
            evtDangXuat();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void menuDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDangXuatActionPerformed
        try {
            evtDangXuat();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuDangXuatActionPerformed

    private void menuDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDangNhapActionPerformed
        try {
            if (Tags.Login._nhanVien != null) {
                Tags.MsgThongBao.alert(this, "Bạn đã đăng nhập rồi.\nĐể đăng nhập tài khoản khác vui lòng chọn \"Đăng xuất\"");
            } else {
                this.dispose();
                new FormDangNhap().setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuDangNhapActionPerformed

    private void menuDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDoiMatKhauActionPerformed
        openTab(_FormDoiMatKhau1);
    }//GEN-LAST:event_menuDoiMatKhauActionPerformed

    private void btnChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenDeActionPerformed
        _FormQuanLyChuyenDe1.setUpForm();
        openTab(_FormQuanLyChuyenDe1);
    }//GEN-LAST:event_btnChuyenDeActionPerformed

    private void menuChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChuyenDeActionPerformed
        _FormQuanLyChuyenDe1.setUpForm();
        openTab(_FormQuanLyChuyenDe1);
    }//GEN-LAST:event_menuChuyenDeActionPerformed

    private void btnNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNguoiHocActionPerformed
        _FormQuanLyNguoiHoc1.setUpForm();
        openTab(_FormQuanLyNguoiHoc1);
    }//GEN-LAST:event_btnNguoiHocActionPerformed

    private void menuNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNguoiHocActionPerformed
        _FormQuanLyNguoiHoc1.setUpForm();
        openTab(_FormQuanLyNguoiHoc1);
    }//GEN-LAST:event_menuNguoiHocActionPerformed

    private void btnKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaHocActionPerformed
        _FormQuanLyKhoaHoc1.setUpForm();
        openTab(_FormQuanLyKhoaHoc1);
    }//GEN-LAST:event_btnKhoaHocActionPerformed

    private void btnHocVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHocVienActionPerformed
        _FormQuanLyHocVien1.setUpForm();
        openTab(_FormQuanLyHocVien1);
    }//GEN-LAST:event_btnHocVienActionPerformed

    private void menuHocVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHocVienActionPerformed
        _FormQuanLyHocVien1.setUpForm();
        openTab(_FormQuanLyHocVien1);
    }//GEN-LAST:event_menuHocVienActionPerformed

    private void menuNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNhanVienActionPerformed
        _FormQuanLyNhanVien1.setUpForm();
        openTab(_FormQuanLyNhanVien1);
    }//GEN-LAST:event_menuNhanVienActionPerformed

    private void menuBangDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBangDiemActionPerformed
        try {
            evtThongKe(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuBangDiemActionPerformed

    private void menuLuongNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLuongNguoiHocActionPerformed
        try {
            evtThongKe(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuLuongNguoiHocActionPerformed

    private void menuDiemChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDiemChuyenDeActionPerformed
        try {
            evtThongKe(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuDiemChuyenDeActionPerformed

    private void menuDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDoanhThuActionPerformed
        try {
            evtThongKe(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_menuDoanhThuActionPerformed

    private void btnHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDanActionPerformed
        openBrowse("https://www.facebook.com/coding97");
    }//GEN-LAST:event_btnHuongDanActionPerformed

    private void menuGioiThieuSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGioiThieuSanPhamActionPerformed
        openBrowse("https://vi.wikipedia.org/wiki/Wikipedia");
    }//GEN-LAST:event_menuGioiThieuSanPhamActionPerformed

    private void menuHuongDanSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHuongDanSuDungActionPerformed
        openBrowse("http://google.com");
    }//GEN-LAST:event_menuHuongDanSuDungActionPerformed

    private void openTab(JInternalFrame jif) {
        for (JInternalFrame x : arrComponents) {
            if (x.isVisible()) {
                x.setVisible(false);
            } else {
                if (x.equals(jif)) {
                    x.setVisible(true);
                    x.setSize(deskPane.getSize());
                    deskPane.removeAll();
                    deskPane.add(x);
                }
            }
        }
    }

    private void openBrowse(String url) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(new URI(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    int indexFormThongKe = -1;

    private void evtThongKe(int x) {
        if (_FormThongKe1.isVisible() && indexFormThongKe == x) {
            _FormThongKe1.setVisible(false);
        } else if (indexFormThongKe != x) {
            _FormThongKe1.setVisible(false);
            _FormThongKe1 = new FormThongKe1(x);
            indexFormThongKe = x;
            _FormThongKe1.setVisible(true);
            _FormThongKe1.setSize(deskPane.getSize());
            deskPane.removeAll();
            deskPane.add(_FormThongKe1);
            openTab(_FormThongKe1);
        } else {
            _FormThongKe1 = new FormThongKe1(x);
            indexFormThongKe = x;
            _FormThongKe1.setVisible(true);
            _FormThongKe1.setSize(deskPane.getSize());
            deskPane.removeAll();
            deskPane.add(_FormThongKe1);
        }
    }

    private void evtDangXuat() {
        if (Tags.MsgThongBao.confirm(this, "Đăng xuất tài khoản?")) {
            Tags.Tab.closeAllTab();
            this.dispose();
            new FormDangNhap().setVisible(true);
        }
    }

    private void evtKetThuc() {
        if (Tags.MsgThongBao.confirm(this, "Đóng chương trình?")) {
            System.exit(0);
            DAO.DAOConnection.closeConnection();
        }
    }

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
            java.util.logging.Logger.getLogger(FormMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenDe;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnHocVien;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhoaHoc;
    private javax.swing.JButton btnNguoiHoc;
    private javax.swing.JDesktopPane deskPane;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JMenuItem menuBangDiem;
    private javax.swing.JMenuItem menuChuyenDe;
    private javax.swing.JMenuItem menuDangNhap;
    private javax.swing.JMenuItem menuDangXuat;
    private javax.swing.JMenuItem menuDiemChuyenDe;
    private javax.swing.JMenuItem menuDoanhThu;
    private javax.swing.JMenuItem menuDoiMatKhau;
    private javax.swing.JMenuItem menuGioiThieuSanPham;
    private javax.swing.JMenuItem menuHocVien;
    private javax.swing.JMenuItem menuHuongDanSuDung;
    private javax.swing.JMenuItem menuKetThuc;
    private javax.swing.JMenuItem menuKhoaHoc;
    private javax.swing.JMenuItem menuLuongNguoiHoc;
    private javax.swing.JMenuItem menuNguoiHoc;
    private javax.swing.JMenuItem menuNhanVien;
    private javax.swing.JMenu mnuThongKe;
    // End of variables declaration//GEN-END:variables
}
