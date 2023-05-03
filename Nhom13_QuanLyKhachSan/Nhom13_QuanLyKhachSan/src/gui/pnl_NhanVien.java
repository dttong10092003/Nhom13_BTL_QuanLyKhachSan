
package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import entity.Luong;
import entity.NhanVien;
import entity.Quyen;
import entity.User;

/**
 *
 * @author ADMIN
 */
public class pnl_NhanVien extends javax.swing.JPanel {

    /**
     * Creates new form pnl_NhanVien
     */
    public static pnl_NhanVien form;

    public static String imageName = null;

    public pnl_NhanVien() {
        initComponents();
        form = this;
        bus.BUS_NhanVien.loadData_Luong(cbb_Luong);
        bus.BUS_NhanVien.doDuLieuBang(tbl_NhanVien);
        rab_Nam.setSelected(true);
        rab_NV.setSelected(true);
        btn_Sua.setEnabled(false);
        btn_Xoa.setEnabled(false);
        btn_SuaTK.setEnabled(false);
        btn_XoaTK.setEnabled(false);
 
        Date d = new Date();
        date_NgaySinh.setMaxSelectableDate(d);
    }


    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnl_GD = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanVien = new javax.swing.JTable();
        lbl_MaNV = new javax.swing.JLabel();
        txt_MaNV = new javax.swing.JTextField();
        lbl_TenNV = new javax.swing.JLabel();
        txt_TenNV = new javax.swing.JTextField();
        lbl_GioiTinh = new javax.swing.JLabel();
        rab_Nam = new javax.swing.JRadioButton();
        rab_Nu = new javax.swing.JRadioButton();
        lbl_NgaySinh = new javax.swing.JLabel();
        lbl_SDT = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        lbl_Luong = new javax.swing.JLabel();
        cbb_Luong = new javax.swing.JComboBox<>();
        btn_ThemLuong = new javax.swing.JButton();
        lbl_DiaChi = new javax.swing.JLabel();
        txt_DiaChi = new javax.swing.JTextField();
        lbl2_Hinh = new javax.swing.JLabel();
        lbl_Hinh = new javax.swing.JLabel();
        pnl_Nut = new javax.swing.JPanel();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        lbl_TimKiem = new javax.swing.JLabel();
        txt_TimKiem = new javax.swing.JTextField();
        btn_LamMoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_GhiChu = new javax.swing.JTextArea();
        date_NgaySinh = new com.toedter.calendar.JDateChooser();
        lbl_NgayBatDauLam = new javax.swing.JLabel();
        date_NgayLam = new com.toedter.calendar.JDateChooser();
        pnl_NV = new javax.swing.JPanel();
        lbl_TK = new javax.swing.JLabel();
        lbl_TenUser = new javax.swing.JLabel();
        txt_TenUser = new javax.swing.JTextField();
        lbl_MK = new javax.swing.JLabel();
        txt_MK = new javax.swing.JPasswordField();
        lbl_Quyen = new javax.swing.JLabel();
        rab_QL = new javax.swing.JRadioButton();
        rab_NV = new javax.swing.JRadioButton();
        lbl2_TK = new javax.swing.JLabel();
        pnl_CTNV = new javax.swing.JPanel();
        btn_SuaTK = new javax.swing.JButton();
        btn_XoaTK = new javax.swing.JButton();
        btn_ThemTK = new javax.swing.JButton();
        lbl_NhapLai = new javax.swing.JLabel();
        txt_NhapLai = new javax.swing.JPasswordField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_ThongTin = new javax.swing.JTextArea();
        lbl_ChuaCoTK = new javax.swing.JLabel();

        pnl_GD.setBackground(new java.awt.Color(204, 255, 204));
        pnl_GD.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        
        tbl_NhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbl_NhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ"
            }
        ));
        tbl_NhanVien.setFocusable(false);
        tbl_NhanVien.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_NhanVien.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_NhanVien.setRowHeight(20);
        tbl_NhanVien.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tbl_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_NhanVien);

        lbl_MaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_MaNV.setText("Mã nhân viên");

        txt_MaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_MaNV.setEditable(false);
        txt_MaNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_MaNVMouseClicked(evt);
            }
        });

        lbl_TenNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_TenNV.setText("Tên nhân viên");

        txt_TenNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_GioiTinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_GioiTinh.setText("Giới tính");

        buttonGroup1.add(rab_Nam);
        rab_Nam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rab_Nam.setText("Nam");

        buttonGroup1.add(rab_Nu);
        rab_Nu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rab_Nu.setText("Nữ");

        lbl_NgaySinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_NgaySinh.setText("Ngày sinh");

        lbl_SDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_SDT.setText("Số điện thoại");

        txt_SDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_SDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SDTKeyReleased(evt);
            }
        });

        lbl_Luong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Luong.setText("Lương");

        cbb_Luong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_ThemLuong.setBackground(new java.awt.Color(255, 255, 255));
        btn_ThemLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_ThemLuong.setText("Thêm");
        btn_ThemLuong.setToolTipText("Thêm lương mới");
        btn_ThemLuong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ThemLuong.setDoubleBuffered(true);
        btn_ThemLuong.setName(""); // NOI18N
        btn_ThemLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemLuongActionPerformed(evt);
            }
        });

        lbl_DiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_DiaChi.setText("Địa chỉ");

        txt_DiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl2_Hinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl2_Hinh.setText("Hình");

        lbl_Hinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Hinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_HinhMouseClicked(evt);
            }
        });

        pnl_Nut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_Them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        btn_Xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        lbl_TimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_TimKiem.setText("Tìm kiếm");

        txt_TimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_TimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TimKiemKeyReleased(evt);
            }
        });

        btn_LamMoi.setIcon(new javax.swing.ImageIcon("HinhAnh/Icon_Reload.png")); // NOI18N
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_NutLayout = new javax.swing.GroupLayout(pnl_Nut);
        pnl_Nut.setLayout(pnl_NutLayout);
        pnl_NutLayout.setHorizontalGroup(
            pnl_NutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_NutLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btn_Them)
                .addGap(18, 18, 18)
                .addComponent(btn_Sua)
                .addGap(18, 18, 18)
                .addComponent(btn_Xoa)
                .addGap(18, 18, 18)
                .addComponent(lbl_TimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_LamMoi))
        );
        pnl_NutLayout.setVerticalGroup(
            pnl_NutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_NutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_NutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_LamMoi)
                    .addGroup(pnl_NutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Them)
                        .addComponent(btn_Sua)
                        .addComponent(btn_Xoa)
                        .addComponent(lbl_TimKiem)
                        .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        txt_GhiChu.setColumns(20);
        txt_GhiChu.setRows(5);
        jScrollPane2.setViewportView(txt_GhiChu);

        date_NgaySinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_NgayBatDauLam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_NgayBatDauLam.setText("Ngày bắt đầu làm");

        date_NgayLam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl_GD);
        pnl_GD.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_Nut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl1Layout.createSequentialGroup()
                                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_MaNV)
                                    .addComponent(lbl_TenNV)
                                    .addComponent(lbl_GioiTinh)
                                    .addComponent(lbl_NgaySinh)
                                    .addComponent(lbl_SDT))
                                .addGap(33, 33, 33)
                                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnl1Layout.createSequentialGroup()
                                            .addComponent(rab_Nam)
                                            .addGap(18, 18, 18)
                                            .addComponent(rab_Nu))
                                        .addComponent(txt_MaNV)
                                        .addComponent(txt_TenNV)
                                        .addComponent(txt_SDT, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                    .addComponent(date_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2)
                            .addGroup(pnl1Layout.createSequentialGroup()
                                .addComponent(lbl_NgayBatDauLam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(date_NgayLam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(26, 26, 26)
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl1Layout.createSequentialGroup()
                                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_Luong)
                                    .addComponent(lbl_DiaChi))
                                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(cbb_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnl1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_DiaChi)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ThemLuong))
                            .addComponent(lbl_Hinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl2_Hinh, javax.swing.GroupLayout.Alignment.LEADING)))))
            .addComponent(jScrollPane1)
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_MaNV)
                    .addComponent(txt_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Luong)
                    .addComponent(cbb_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ThemLuong))
                .addGap(18, 18, 18)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TenNV)
                    .addComponent(txt_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_DiaChi)
                    .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_GioiTinh)
                    .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rab_Nam)
                        .addComponent(rab_Nu)
                        .addComponent(lbl2_Hinh)))
                .addGap(10, 10, 10)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_NgaySinh)
                            .addComponent(date_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_SDT)
                            .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_NgayBatDauLam)
                            .addComponent(date_NgayLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_Nut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addComponent(lbl_Hinh, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnl_NV.setBackground(new java.awt.Color(204, 255, 204));
        pnl_NV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl_TK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_TK.setText("Tài khoản của nhân viên");

        lbl_TenUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_TenUser.setText("Tên User");

        txt_TenUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_MK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_MK.setText("Mật khẩu");

        txt_MK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_Quyen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Quyen.setText("Quyền");

        buttonGroup2.add(rab_QL);
        rab_QL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rab_QL.setText("Quản lý");

        buttonGroup2.add(rab_NV);
        rab_NV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rab_NV.setText("Nhân viên");

        lbl2_TK.setBackground(new java.awt.Color(255, 255, 255));
        lbl2_TK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl2_TK.setOpaque(true);

        pnl_CTNV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_SuaTK.setBackground(new java.awt.Color(255, 255, 255));
        btn_SuaTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_SuaTK.setText("Sửa");
        btn_SuaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaTKActionPerformed(evt);
            }
        });

        btn_XoaTK.setBackground(new java.awt.Color(255, 255, 255));
        btn_XoaTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_XoaTK.setText("Xóa");
        btn_XoaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaTKActionPerformed(evt);
            }
        });

        btn_ThemTK.setBackground(new java.awt.Color(255, 255, 255));
        btn_ThemTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_ThemTK.setText("Thêm");
        btn_ThemTK.setEnabled(false);
        btn_ThemTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl_CTNV);
        pnl_CTNV.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_SuaTK, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_XoaTK, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(pnl3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_ThemTK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_SuaTK)
                .addGap(18, 18, 18)
                .addComponent(btn_XoaTK)
                .addGap(18, 18, 18)
                .addComponent(btn_ThemTK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_NhapLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_NhapLai.setText("Nhập lại");

        txt_NhapLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_ThongTin.setColumns(20);
        txt_ThongTin.setRows(5);
        txt_ThongTin.setText("Tạo tài khoản giúp cho nhân viên đó có thể \nđăng nhập vào phần mềm");
        txt_ThongTin.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_ThongTin.setEnabled(false);
        jScrollPane3.setViewportView(txt_ThongTin);

        lbl_ChuaCoTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl_NV);
        pnl_NV.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_MK)
                            .addComponent(lbl_TenUser)
                            .addComponent(lbl_Quyen)
                            .addComponent(lbl_NhapLai))
                        .addGap(51, 51, 51)
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_MK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(txt_TenUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_NhapLai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnl_CTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(rab_QL)
                        .addGap(18, 18, 18)
                        .addComponent(rab_NV))
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addComponent(lbl_TK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl2_TK, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_ChuaCoTK, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl2_TK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_TK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_ChuaCoTK, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl2Layout.createSequentialGroup()
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_TenUser)
                            .addComponent(txt_TenUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_MK)
                            .addComponent(txt_MK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_NhapLai)
                            .addComponent(txt_NhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnl_CTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Quyen)
                    .addComponent(rab_QL)
                    .addComponent(rab_NV))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_GD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_GD, javax.swing.GroupLayout.PREFERRED_SIZE, 709, Short.MAX_VALUE)
            .addComponent(pnl_NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
public static String MaNV;
    private void btn_ThemLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemLuongActionPerformed
        frm_QuanLyChinh frm = frm_QuanLyChinh.b;
        try {
            frm.tab.setSelectedComponent(pnl_LoaiLuong.form);
        } catch (Exception e) {
            pnl_LoaiLuong pnl = new pnl_LoaiLuong();
            frm.tab.add("Lương", pnl);
            frm.tab.setSelectedComponent(pnl);
        }
    }//GEN-LAST:event_btn_ThemLuongActionPerformed

    private void btn_SuaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaTKActionPerformed
        entity.User sua = new User();
        sua.setTenUser(txt_TenUser.getText());
        sua.setmK(String.valueOf(txt_MK.getPassword()));
        if (rab_QL.isSelected()) {
            sua.setQuyen(new Quyen("QuanLy"));
        } else {
            sua.setQuyen(new Quyen("NhanVien"));
        }
        String NhapLai = String.valueOf(txt_NhapLai.getPassword());
        if (bus.BUS_User.kt_Sua(sua, NhapLai)) {
            dao.DAO_User.sua(sua);
            lamMoi();
        }else{}
    }//GEN-LAST:event_btn_SuaTKActionPerformed
    File f;
    private void lbl_HinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_HinhMouseClicked
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int resuft = file.showOpenDialog(null);
        if (resuft == JFileChooser.APPROVE_OPTION) {
            f = file.getSelectedFile();
            imageName = f.getAbsolutePath();
            ImageIcon ii = new ImageIcon(new ImageIcon(imageName).getImage().getScaledInstance(lbl_Hinh.getWidth(), lbl_Hinh.getHeight(), Image.SCALE_SMOOTH));
            lbl_Hinh.setIcon(ii);
            imageName = f.getName();
        }
        System.out.println(imageName);
    }//GEN-LAST:event_lbl_HinhMouseClicked
    public static entity.NhanVien nv = new NhanVien();
    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        ganDuLieu();
        boolean kt = bus.BUS_NhanVien.kt_Them(nv);
        if (kt) {
            dao.DAO_NhanVien.them(nv);
            save_IMG(f);
            bus.BUS_NhanVien.doDuLieuBang(tbl_NhanVien);
        }
    }//GEN-LAST:event_btn_ThemActionPerformed


    
    
    private void ganDuLieu() {
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		ResultSet rs = dao.DAO_NhanVien.layNV();
		String maNV_MoiNhat = null;
		System.out.println(rs);// Xem có dữ liệu hay không
		try {
			while (rs.next()) {
				maNV_MoiNhat = rs.getString("MaNhanVien");// Lấy mã nhân viên
															// cuối cùng ( mã
															// nhân viên vừa
															// thêm)
			}
		} catch (SQLException e) {
			Logger.getLogger(pnl_NhanVien.class.getName()).log(Level.SEVERE,
					null, e);
		}
		int nextMaNV = Integer.parseInt(maNV_MoiNhat.substring(2));
		String newMaNV = "NV" + String.format("%03d", nextMaNV + 1);
		txt_MaNV.setText(newMaNV);
		nv.setMaNV(txt_MaNV.getText());
		nv.setTenNV(txt_TenNV.getText());
		if (rab_Nam.isSelected()) {
			nv.setGioiTinh(true);

		} else {
			nv.setGioiTinh(false);
		}
		try {
			nv.setNgaySinh(s.format(date_NgaySinh.getDate()));
			nv.setNgayLam(s.format(date_NgayLam.getDate()));
		} catch (Exception e) {
			thongbao.thongbao("Ngày sai", "");
			return;
		}

		nv.setSdt(txt_SDT.getText());
		gui.mycombobox mb = (gui.mycombobox) cbb_Luong.getSelectedItem();
		nv.setLuong(new Luong(mb.value.toString()));
		nv.setDiaChi(txt_DiaChi.getText());
		nv.setGhiChu(txt_GhiChu.getText());
		nv.setHinh(imageName);
	}

    
    
    
    
    
    
    
    
    private void ganDuLieuSua() {
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		nv.setMaNV(txt_MaNV.getText());
		nv.setTenNV(txt_TenNV.getText());
		if (rab_Nam.isSelected()) {
			nv.setGioiTinh(true);

		} else {
			nv.setGioiTinh(false);
		}
		try {
			nv.setNgaySinh(s.format(date_NgaySinh.getDate()));
			nv.setNgayLam(s.format(date_NgayLam.getDate()));
		} catch (Exception e) {
			thongbao.thongbao("Ngày sai", "");
			return;
		}

		nv.setSdt(txt_SDT.getText());
		gui.mycombobox mb = (gui.mycombobox) cbb_Luong.getSelectedItem();
		nv.setLuong(new Luong(mb.value.toString()));
		nv.setDiaChi(txt_DiaChi.getText());
		nv.setGhiChu(txt_GhiChu.getText());
		nv.setHinh(imageName);
	}
    
    
    
    
    
    
    
    
 
    
    
   
    
    
    
    
    
    private void dienDuLieu() {
        ResultSet rs = dao.DAO_User.layTKTheoMaNV(MaNV);
        try {
            if (rs.next()) {
                txt_TenUser.setText(rs.getString("TenUser"));
                txt_MK.setText(rs.getString("MatKhau"));
                if (rs.getString("MaQuyen").equals("QuanLy")) {
                    rab_QL.setSelected(true);
                } else {
                    rab_NV.setSelected(true);
                }
            } else {
                txt_TenUser.setText("");
                txt_MK.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnl_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tbl_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanVienMouseClicked
        if (tbl_NhanVien.getSelectedRowCount() == 1) {
            txt_MaNV.setFocusable(false);
            btn_Sua.setEnabled(true);
            btn_Xoa.setEnabled(true);
            btn_SuaTK.setEnabled(true);
            btn_XoaTK.setEnabled(true);
        }
        int vitri = tbl_NhanVien.getSelectedRow();
        MaNV = tbl_NhanVien.getValueAt(vitri, 0).toString();
        if (bus.BUS_NhanVien.xemTK(MaNV)) {

            dienDuLieu();
            lbl_ChuaCoTK.setText("");
            btn_ThemTK.setEnabled(false);
            txt_TenUser.setFocusable(false);
            btn_SuaTK.setEnabled(true);
            btn_XoaTK.setEnabled(true);
        } else {

            dienDuLieu();
            lbl_ChuaCoTK.setText("( chưa có tài khoản )");
            btn_ThemTK.setEnabled(true);
            txt_TenUser.setFocusable(true);
            btn_SuaTK.setEnabled(false);
            btn_XoaTK.setEnabled(false);
        }
        ResultSet rs = dao.DAO_NhanVien.layNVTheoMa(MaNV);
        try {
            if (rs.next()) {
                txt_MaNV.setText(rs.getString("MaNhanVien"));
                txt_TenNV.setText(rs.getString("TenNhanVien"));
                lbl2_TK.setText(rs.getString("TenNhanVien"));
                boolean gt = rs.getBoolean("GioiTinh");
                if (gt) {
                    rab_Nam.setSelected(true);
                } else {
                    rab_Nu.setSelected(true);
                }
                date_NgaySinh.setDate(rs.getDate("NgaySinh"));
                date_NgayLam.setDate(rs.getDate("NgayBatDauLam"));
                txt_SDT.setText(rs.getString("SoDienThoai"));
                String MaLuong = rs.getString("MaLuong");
                DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb_Luong.getModel();
                for (int i = 0; i < cbb_Luong.getItemCount(); i++) {
                    mycombobox mb = (mycombobox) cbbModel.getElementAt(i);
                    if (MaLuong.equals(mb.value)) {
                        cbb_Luong.setSelectedIndex(i);
                    } else {
                    }
                }
                txt_DiaChi.setText(rs.getString("DiaChi"));
                txt_GhiChu.setText(rs.getString("GhiChu"));
                imageName = rs.getString("Hinh");
//                ImageIcon ii = new ImageIcon(new ImageIcon(imageName).getImage().getScaledInstance(lbl_Hinh.getWidth(), lbl_Hinh.getHeight(), Image.SCALE_SMOOTH));
//                lbl_Hinh.setIcon(ii);
                lbl_ImageNV(imageName);
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_tbl_NhanVienMouseClicked

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        ganDuLieuSua();
        boolean kt = bus.BUS_NhanVien.kt_Sua(nv);
        if (kt) {
            dao.DAO_NhanVien.sua(nv);
            save_IMG(f);
            bus.BUS_NhanVien.doDuLieuBang(tbl_NhanVien);
            pnl_NhanVien.MaNV = null;
            lamMoi();
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        int nutbam = JOptionPane.showConfirmDialog(new JFrame(), "Bạn chắc chắn xóa?", "Xóa", JOptionPane.YES_NO_OPTION);
        if (nutbam == JOptionPane.YES_OPTION) {
            int cacdong[] = tbl_NhanVien.getSelectedRows();
            for (int i = 0; i < cacdong.length; i++) {
                String MaNV = tbl_NhanVien.getValueAt(cacdong[i], 0).toString();
                if (bus.BUS_NhanVien.kt_Xoa(MaNV)) {// kiểm tra nhân viên đang có tài khoản hay không
                     dao.DAO_NhanVien.xoa(MaNV);    
                }
               
            }
            lamMoi();
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void txt_TimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TimKiemKeyReleased
        String TuKhoa = txt_TimKiem.getText();
        if (TuKhoa.equals("")) {
            bus.BUS_NhanVien.doDuLieuBang(tbl_NhanVien);
        } else {
            bus.BUS_NhanVien.doDuLieuTimKiem(tbl_NhanVien, TuKhoa);
        }
    }//GEN-LAST:event_txt_TimKiemKeyReleased

    private void txt_MaNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MaNVMouseClicked

    }//GEN-LAST:event_txt_MaNVMouseClicked

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        lamMoi();

    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void btn_ThemTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemTKActionPerformed
        entity.User u = new User();
        u.setTenUser(txt_TenUser.getText());
        u.setmK(String.valueOf(txt_MK.getPassword()));
        if (rab_QL.isSelected()) {
            u.setQuyen(new Quyen("QuanLy"));
        } else {
            u.setQuyen(new Quyen("NhanVien"));
        }
        String NhapLai = String.valueOf(txt_NhapLai.getPassword());
        if (bus.BUS_User.kt_Them(u, NhapLai)) {
            dao.DAO_User.them(u);
            lamMoi();

        }
    }//GEN-LAST:event_btn_ThemTKActionPerformed

    private void btn_XoaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaTKActionPerformed
        int nutbam = JOptionPane.showConfirmDialog(new JFrame(), "bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
        if (nutbam == JOptionPane.YES_OPTION) {//xóa theo MaNV đã chọn
            if (bus.BUS_User.kt_Xoa(MaNV)) {
                 dao.DAO_User.xoa();
            }           
            lamMoi();
        }

    }//GEN-LAST:event_btn_XoaTKActionPerformed

    private void txt_SDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SDTKeyReleased
       
    }//GEN-LAST:event_txt_SDTKeyReleased
    private void lamMoi() {
        frm_QuanLyChinh frm = frm_QuanLyChinh.b;
        pnl_NhanVien pnl = new pnl_NhanVien();
        frm.tab.remove(this);
        frm.tab.add("Nhân viên", pnl);
        frm.tab.setSelectedComponent(pnl);
    }

    public static boolean save_IMG(File file) {
        File dir = new File("IMG_NhanVien");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            File newfile = new File(dir, file.getName());
            Path source = Paths.get(file.getAbsolutePath());
            Path ok = Paths.get(newfile.getAbsolutePath());
            Files.copy(source, ok, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void lbl_ImageNV(String ImagePath) {
        ImageIcon icon = new ImageIcon("IMG_NhanVien\\" + ImagePath);
        Image image = icon.getImage();
        ImageIcon icon1 = new ImageIcon(image.getScaledInstance(lbl_Hinh.getWidth(), lbl_Hinh.getHeight(), image.SCALE_SMOOTH));
        lbl_Hinh.setIcon(icon1);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_SuaTK;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_ThemLuong;
    private javax.swing.JButton btn_ThemTK;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_XoaTK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbb_Luong;
    private com.toedter.calendar.JDateChooser date_NgayLam;
    private com.toedter.calendar.JDateChooser date_NgaySinh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl2_Hinh;
    private javax.swing.JLabel lbl2_TK;
    private javax.swing.JLabel lbl_ChuaCoTK;
    private javax.swing.JLabel lbl_DiaChi;
    private javax.swing.JLabel lbl_GioiTinh;
    private javax.swing.JLabel lbl_Hinh;
    private javax.swing.JLabel lbl_Luong;
    private javax.swing.JLabel lbl_MK;
    private javax.swing.JLabel lbl_MaNV;
    private javax.swing.JLabel lbl_NgayBatDauLam;
    private javax.swing.JLabel lbl_NgaySinh;
    private javax.swing.JLabel lbl_NhapLai;
    private javax.swing.JLabel lbl_Quyen;
    private javax.swing.JLabel lbl_SDT;
    private javax.swing.JLabel lbl_TK;
    private javax.swing.JLabel lbl_TenNV;
    private javax.swing.JLabel lbl_TenUser;
    private javax.swing.JLabel lbl_TimKiem;
    private javax.swing.JPanel pnl_GD;
    private javax.swing.JPanel pnl_NV;
    private javax.swing.JPanel pnl_CTNV;
    private javax.swing.JPanel pnl_Nut;
    private javax.swing.JRadioButton rab_NV;
    private javax.swing.JRadioButton rab_Nam;
    private javax.swing.JRadioButton rab_Nu;
    private javax.swing.JRadioButton rab_QL;
    private javax.swing.JTable tbl_NhanVien;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextArea txt_GhiChu;
    private javax.swing.JPasswordField txt_MK;
    private javax.swing.JTextField txt_MaNV;
    private javax.swing.JPasswordField txt_NhapLai;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_TenNV;
    private javax.swing.JTextField txt_TenUser;
    private javax.swing.JTextArea txt_ThongTin;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
}
