package gui;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entity.Luong;
import entity.ChiTietLuong;
import entity.NhanVien;

import java.util.Date;
import java.util.Hashtable;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ADMIN
 */
public class pnl_LoaiLuong extends javax.swing.JPanel {

	/**
	 * Creates new form pnl_Luong
	 */
	public static pnl_LoaiLuong form;

	public pnl_LoaiLuong() {
		initComponents();

		form = this;
		bus.BUS_Luong.dodulieu(tbl_Luong);
		tbl_Luong.getTableHeader().setOpaque(false);
		tbl_Luong.getTableHeader().setBackground(new Color(255, 102, 102));
		bus.BUS_Luong.doDuLieuBang(tbl_NV);

	}

	private void initComponents() {

		pnl_GD = new javax.swing.JPanel();
		lbl_MaLuong = new javax.swing.JLabel();
		txt_maluong = new javax.swing.JTextField();
		lbl_LuongTheoGio = new javax.swing.JLabel();
		txt_LuongTheoGio = new javax.swing.JTextField();
		lbl_SoGioLam = new javax.swing.JLabel();
		txt_SoGioLam = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		tbl_Luong = new javax.swing.JTable();
		pnl_Nut = new javax.swing.JPanel();
		btn_Xoa = new javax.swing.JButton();
		btn_Sua = new javax.swing.JButton();
		btn_Them = new javax.swing.JButton();
		btn_Tru = new javax.swing.JButton();
		btn_Cong = new javax.swing.JButton();
		btn_LamMoi = new javax.swing.JButton();
		lbl_GhiChu = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		txt_GhiChu = new javax.swing.JTextArea();
		lbl_LoaiLuong = new javax.swing.JLabel();
		pnl_Luong = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		tbl_NV = new javax.swing.JTable();
		lbl_TraLuong = new javax.swing.JLabel();
		lbl_TenNV = new javax.swing.JLabel();
		txt_TenNV = new javax.swing.JTextField();
		lbl_SoNGayNghi = new javax.swing.JLabel();
		txt_SoNgayNghi = new javax.swing.JTextField();
		lbl_SoNgayLam = new javax.swing.JLabel();
		txt_SoNgayLam = new javax.swing.JTextField();
		lbl_LuongTheoGio2 = new javax.swing.JLabel();
		txt_LuongTheoGio2 = new javax.swing.JTextField();
		lbl_SoGioLam2 = new javax.swing.JLabel();
		txt_SoGioLam2 = new javax.swing.JTextField();
		jSeparator1 = new javax.swing.JSeparator();
		lbl_TongNhan = new javax.swing.JLabel();
		txt_TongLuong = new javax.swing.JTextField();
		btn_XuatPhieu = new javax.swing.JButton();
		lbl_MaNhanLuong2 = new javax.swing.JLabel();
		lbl_MaNhanLuong = new javax.swing.JLabel();

		setBackground(new java.awt.Color(255, 255, 255));

		pnl_GD.setBackground(new java.awt.Color(204, 255, 204));
		pnl_GD.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		lbl_MaLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_MaLuong.setText("Mã lương");

		txt_maluong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		lbl_LuongTheoGio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_LuongTheoGio.setText("Lương theo giờ");

		txt_LuongTheoGio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txt_LuongTheoGio.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_LuongTheoGioKeyReleased(evt);
			}
		});

		lbl_SoGioLam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_SoGioLam.setText("Số giờ làm");

		txt_SoGioLam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txt_SoGioLam.setText("01");
		txt_SoGioLam.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_SoGioLamKeyReleased(evt);
			}
		});

		tbl_Luong
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] {

						}, new String[] { "Mã lương", "Lương theo giờ",
								"Số giờ làm" }));
		tbl_Luong.setFocusable(false);
		tbl_Luong.setIntercellSpacing(new java.awt.Dimension(0, 0));
		tbl_Luong.setRowHeight(25);
		tbl_Luong.setSelectionBackground(new java.awt.Color(255, 102, 102));
		tbl_Luong.setShowVerticalLines(false);
		tbl_Luong.getTableHeader().setReorderingAllowed(false);
		tbl_Luong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_LuongMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tbl_Luong);

		pnl_Nut.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		btn_Xoa.setBackground(new java.awt.Color(255, 255, 255));
		btn_Xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btn_Xoa.setIcon(new javax.swing.ImageIcon("HinhAnh/Icon_Tru.png")); // NOI18N
		btn_Xoa.setText("Xóa");
		btn_Xoa.setEnabled(false);
		btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_XoaActionPerformed(evt);
			}
		});

		btn_Sua.setBackground(new java.awt.Color(255, 255, 255));
		btn_Sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btn_Sua.setIcon(new javax.swing.ImageIcon("HinhAnh/icon_server.png")); // NOI18N
		btn_Sua.setText("Sửa");
		btn_Sua.setEnabled(false);
		btn_Sua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_SuaActionPerformed(evt);
			}
		});

		btn_Them.setBackground(new java.awt.Color(255, 255, 255));
		btn_Them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btn_Them.setIcon(new javax.swing.ImageIcon("HinhAnh/Icon_Cong.png")); // NOI18N
		btn_Them.setText("Thêm");
		btn_Them.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_ThemActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnl_NutLayout = new javax.swing.GroupLayout(
				pnl_Nut);
		pnl_Nut.setLayout(pnl_NutLayout);
		pnl_NutLayout
				.setHorizontalGroup(pnl_NutLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								pnl_NutLayout
										.createSequentialGroup()
										.addComponent(btn_Them)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btn_Sua)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btn_Xoa)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		pnl_NutLayout
				.setVerticalGroup(pnl_NutLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								pnl_NutLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												pnl_NutLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																btn_Sua,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btn_Xoa)
														.addComponent(btn_Them))
										.addGap(24, 24, 24)));

		btn_Tru.setText("-");
		btn_Tru.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_TruActionPerformed(evt);
			}
		});

		btn_Cong.setText("+");
		btn_Cong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_CongActionPerformed(evt);
			}
		});

		btn_LamMoi
				.setIcon(new javax.swing.ImageIcon("HinhAnh/Icon_Reload.png")); // NOI18N
		btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_LamMoiActionPerformed(evt);
			}
		});

		lbl_GhiChu.setText("Ghi chú");

		txt_GhiChu.setColumns(20);
		txt_GhiChu.setRows(5);
		jScrollPane2.setViewportView(txt_GhiChu);

		lbl_LoaiLuong.setText("Loại lương");

		javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl_GD);
		pnl_GD.setLayout(pnlLayout);
		pnlLayout
				.setHorizontalGroup(pnlLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 0,
								Short.MAX_VALUE)
						.addGroup(
								pnlLayout
										.createSequentialGroup()
										.addGroup(
												pnlLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																pnlLayout
																		.createSequentialGroup()
																		.addGroup(
																				pnlLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								pnlLayout
																										.createSequentialGroup()
																										.addGap(13,
																												13,
																												13)
																										.addGroup(
																												pnlLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																lbl_MaLuong)
																														.addComponent(
																																lbl_LuongTheoGio)
																														.addComponent(
																																lbl_SoGioLam)))
																						.addGroup(
																								pnlLayout
																										.createSequentialGroup()
																										.addContainerGap()
																										.addComponent(
																												lbl_GhiChu)))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				pnlLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								pnlLayout
																										.createSequentialGroup()
																										.addGroup(
																												pnlLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																false)
																														.addComponent(
																																txt_SoGioLam,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																128,
																																Short.MAX_VALUE)
																														.addComponent(
																																txt_maluong)
																														.addComponent(
																																txt_LuongTheoGio))
																										.addGap(2,
																												2,
																												2)
																										.addGroup(
																												pnlLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addGroup(
																																pnlLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				btn_Tru)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				btn_Cong))
																														.addComponent(
																																lbl_LoaiLuong)))
																						.addComponent(
																								jScrollPane2)))
														.addGroup(
																pnlLayout
																		.createSequentialGroup()
																		.addComponent(
																				pnl_Nut,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				btn_LamMoi,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				57,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(0, 0, Short.MAX_VALUE)));
		pnlLayout
				.setVerticalGroup(pnlLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlLayout
										.createSequentialGroup()
										.addGroup(
												pnlLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																pnlLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				pnlLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								lbl_MaLuong)
																						.addComponent(
																								txt_maluong,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																lbl_LoaiLuong))
										.addGap(18, 18, 18)
										.addGroup(
												pnlLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lbl_LuongTheoGio)
														.addComponent(
																txt_LuongTheoGio,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												pnlLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lbl_SoGioLam)
														.addComponent(
																txt_SoGioLam,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(btn_Tru)
														.addComponent(btn_Cong))
										.addGroup(
												pnlLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																pnlLayout
																		.createSequentialGroup()
																		.addGap(20,
																				20,
																				20)
																		.addComponent(
																				lbl_GhiChu))
														.addGroup(
																pnlLayout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(18, 18, 18)
										.addGroup(
												pnlLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																btn_LamMoi,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																pnl_Nut,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																67,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												23, Short.MAX_VALUE)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												364,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

		pnl_Luong.setBackground(new java.awt.Color(204, 255, 204));
		pnl_Luong.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

		tbl_NV.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Mã nhân viên", "Tên nhân viên", "Mã lương",
				"Ngày  làm" }));
		tbl_NV.setRowHeight(25);
		tbl_NV.setSelectionBackground(new java.awt.Color(255, 102, 102));
		tbl_NV.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_NVMouseClicked(evt);
			}
		});
		jScrollPane3.setViewportView(tbl_NV);

		lbl_TraLuong.setText("Trả lương");

		lbl_TenNV.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbl_TenNV.setText("Tên nhân viên");

		txt_TenNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_TenNV.setFocusable(false);

		lbl_SoNGayNghi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbl_SoNGayNghi.setText("Số ngày nghỉ");

		txt_SoNgayNghi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_SoNgayNghi.setText("0");
		txt_SoNgayNghi.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_SoNgayNghiKeyReleased(evt);
			}

			public void keyTyped(java.awt.event.KeyEvent evt) {
				txt_SoNgayNghiKeyTyped(evt);
			}
		});

		lbl_SoNgayLam.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbl_SoNgayLam.setText("Số ngày làm");

		txt_SoNgayLam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_SoNgayLam.setText("0");
		txt_SoNgayLam.setFocusable(false);

		lbl_LuongTheoGio2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbl_LuongTheoGio2.setText("Lương theo giờ");

		txt_LuongTheoGio2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_LuongTheoGio2.setText("0");
		txt_LuongTheoGio2.setFocusable(false);

		lbl_SoGioLam2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbl_SoGioLam2.setText("Số giờ làm trong ngày");

		txt_SoGioLam2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_SoGioLam2.setText("0");
		txt_SoGioLam2.setFocusable(false);

		lbl_TongNhan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbl_TongNhan.setText("Tổng nhận:");

		txt_TongLuong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_TongLuong.setText("0");
		txt_TongLuong.setFocusable(false);

		btn_XuatPhieu.setBackground(new java.awt.Color(255, 255, 255));
		btn_XuatPhieu.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
		btn_XuatPhieu.setText(" Xuất phiếu");
		btn_XuatPhieu.setEnabled(false);
		btn_XuatPhieu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_XuatPhieuActionPerformed(evt);
			}
		});

		lbl_MaNhanLuong2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbl_MaNhanLuong2.setText("Mã nhận lương:");

		javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(
				pnl_Luong);
		pnl_Luong.setLayout(pnl2Layout);
		pnl2Layout
				.setHorizontalGroup(pnl2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane3)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								pnl2Layout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btn_XuatPhieu)
										.addGap(111, 111, 111))
						.addGroup(
								pnl2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																pnl2Layout
																		.createSequentialGroup()
																		.addGroup(
																				pnl2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								lbl_LuongTheoGio2)
																						.addComponent(
																								lbl_SoGioLam2)
																						.addComponent(
																								lbl_TongNhan)
																						.addGroup(
																								pnl2Layout
																										.createSequentialGroup()
																										.addComponent(
																												lbl_TenNV)
																										.addGap(18,
																												18,
																												18)
																										.addComponent(
																												txt_TenNV,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												150,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												lbl_SoNgayLam))
																						.addGroup(
																								pnl2Layout
																										.createSequentialGroup()
																										.addComponent(
																												lbl_MaNhanLuong2)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												8,
																												Short.MAX_VALUE)
																										.addComponent(
																												lbl_MaNhanLuong,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												175,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(18,
																												18,
																												18)
																										.addComponent(
																												lbl_SoNGayNghi)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				78,
																				Short.MAX_VALUE)
																		.addGroup(
																				pnl2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								txt_SoNgayNghi,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								150,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txt_SoNgayLam,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								150,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																pnl2Layout
																		.createSequentialGroup()
																		.addGap(289,
																				289,
																				289)
																		.addComponent(
																				lbl_TraLuong)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																pnl2Layout
																		.createSequentialGroup()
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)
																		.addGroup(
																				pnl2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								pnl2Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												txt_LuongTheoGio2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												150,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												txt_TongLuong,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												151,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								jSeparator1,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								282,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txt_SoGioLam2,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								151,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))));
		pnl2Layout
				.setVerticalGroup(pnl2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnl2Layout
										.createSequentialGroup()
										.addComponent(lbl_TraLuong)
										.addGap(25, 25, 25)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																pnl2Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				lbl_SoNGayNghi)
																		.addComponent(
																				txt_SoNgayNghi,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lbl_MaNhanLuong2))
														.addComponent(
																lbl_MaNhanLuong,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																21,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																pnl2Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				lbl_SoNgayLam)
																		.addComponent(
																				txt_SoNgayLam,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																pnl2Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				lbl_TenNV)
																		.addComponent(
																				txt_TenNV,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(18, 18, 18)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																txt_LuongTheoGio2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lbl_LuongTheoGio2))
										.addGap(19, 19, 19)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lbl_SoGioLam2)
														.addComponent(
																txt_SoGioLam2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												10,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																txt_TongLuong,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lbl_TongNhan))
										.addGap(18, 18, 18)
										.addComponent(btn_XuatPhieu)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(
												jScrollPane3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												363,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(pnl_GD,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pnl_Luong,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pnl_GD, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pnl_Luong, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	}// </editor-fold>//GEN-END:initComponents

	public static entity.Luong L = new Luong();

	private void ganDuLieu() {
		L.setMaLuong(txt_maluong.getText());
		if (txt_LuongTheoGio.getText().trim().equals("")) {
			txt_LuongTheoGio.setText("0");
		}
		L.setLuongGio(Double.parseDouble(txt_LuongTheoGio.getText()));
		L.setSoGioLam(Integer.parseInt(txt_SoGioLam.getText()));
		L.setGhiChu(txt_GhiChu.getText());
	}

	private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_ThemActionPerformed
		ganDuLieu();
		if (bus.BUS_Luong.kt_them(L)) {
			dao.DAO_Luong.them(L);
			bus.BUS_Luong.dodulieu(tbl_Luong);
		}
	}// GEN-LAST:event_btn_ThemActionPerformed

	private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_XoaActionPerformed
		int nutbam = JOptionPane.showConfirmDialog(new JFrame(),
				"bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
		if (nutbam == JOptionPane.YES_OPTION) {
			int cacdong[] = tbl_Luong.getSelectedRows();
			for (int i = 0; i < cacdong.length; i++) {

				String maluong = tbl_Luong.getValueAt(cacdong[i], 0).toString();
				if (bus.BUS_Luong.kt_Xoa(maluong)) {// Kiểm tra mã lương khi xóa
													// có đang tồn tại ở nhân
													// viên hay không
					dao.DAO_Luong.xoa(maluong);
				}

			}
			lamMoi();
		}
	}// GEN-LAST:event_btn_XoaActionPerformed

	private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_SuaActionPerformed
		ganDuLieu();
		if (bus.BUS_Luong.kt_Sua(L)) {
			dao.DAO_Luong.sua(L);
			lamMoi();
		}
	}// GEN-LAST:event_btn_SuaActionPerformed

	private void tbl_LuongMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_LuongMouseClicked

		if (tbl_Luong.getSelectedRowCount() == 1) {
			int vitri = tbl_Luong.getSelectedRow();
			String maluong = tbl_Luong.getValueAt(vitri, 0).toString();
			dienDuLieuVaoField(maluong);
//			txt_maluong.setFocusable(false);
			btn_Sua.setEnabled(true);
			btn_Xoa.setEnabled(true);
		}
	}// GEN-LAST:event_tbl_LuongMouseClicked

	private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_LamMoiActionPerformed
		lamMoi();
	}// GEN-LAST:event_btn_LamMoiActionPerformed

	private void txt_SoGioLamKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_SoGioLamKeyReleased
		try {
			int sl = Integer.parseInt(txt_SoGioLam.getText());

		} catch (Exception e) {
			txt_SoGioLam.setText("0");

		}
	}// GEN-LAST:event_txt_SoGioLamKeyReleased

	private void btn_TruActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_TruActionPerformed
		if (Double.parseDouble(txt_SoGioLam.getText()) > 0) {
			soLuong(-1);

		}
	}// GEN-LAST:event_btn_TruActionPerformed

	private void btn_CongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_CongActionPerformed
		soLuong(1);
	}// GEN-LAST:event_btn_CongActionPerformed

	private void tbl_NVMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_NVMouseClicked
		if (tbl_NV.getSelectedRowCount() == 1) {
			ganField();

			//
			btn_XuatPhieu.setEnabled(true);
		}
	}// GEN-LAST:event_tbl_NVMouseClicked

	private void txt_SoNgayNghiKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_SoNgayNghiKeyReleased

		try {
			int sl = Integer.parseInt(txt_SoNgayNghi.getText());

		} catch (Exception e) {
			txt_SoNgayNghi.setText("0");
		}
		ganField();
	}// GEN-LAST:event_txt_SoNgayNghiKeyReleased

	private void txt_SoNgayNghiKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_SoNgayNghiKeyTyped

	}// GEN-LAST:event_txt_SoNgayNghiKeyTyped

	entity.ChiTietLuong nl = new ChiTietLuong();
	String ngayhientai;

	private void btn_XuatPhieuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_XuatPhieuActionPerformed
		// gắn doi tuong nl
		nl.setMaChiTietLuong(lbl_MaNhanLuong.getText());
		nl.setSoNgayNghi(Integer.parseInt(txt_SoNgayNghi.getText()));
		nl.setSoNgayLam(Integer.parseInt(txt_SoNgayLam.getText()));
		nl.setTongNhan(ChuyenDoi.chuyenSangSo(txt_TongLuong.getText()));
		nl.setNgayNhanLuong(ngayhientai);
		
			// cập nhật ngày làm của nhân viên vừa trả lương thành hiện tại
			dao.DAO_ChiTietLuong.capNhatNgayLam(nl, ngayhientai);
			//
			dao.DAO_ChiTietLuong.them(nl);
			// xuất phiếu
			xuatLuong(nl.getMaChiTietLuong());
			lamMoi();

	}// GEN-LAST:event_btn_XuatPhieuActionPerformed

	public void xuatLuong(String MaCTLuong) {
		try {

			Hashtable map = new Hashtable();
			JasperReport report = JasperCompileManager
					.compileReport("src/gui/rpt_Luong.jrxml");

			map.put("MaChiTietLuong2", MaCTLuong);

			JasperPrint p = JasperFillManager.fillReport(report, map,
					connectDB.connection.conn);
			JasperViewer.viewReport(p, false);
			JasperExportManager.exportReportToPdfFile(p, "test.pdf");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void txt_LuongTheoGioKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_LuongTheoGioKeyReleased
		try {
			// vi chuyen qua double bi loi field (không nhập , được nên đổi sang int)
			int so = Integer.parseInt(txt_LuongTheoGio.getText());
			String sotien = so+"";
			txt_LuongTheoGio.setText(sotien);

		} catch (Exception e) {

			txt_LuongTheoGio.setText("0");
		}
	}// GEN-LAST:event_txt_LuongTheoGioKeyReleased

	private void dienDuLieuVaoField(String maluong) {
		ResultSet rs = dao.DAO_Luong.layLuongTheoMa(maluong);
		try {
			if (rs.next()) {
				txt_maluong.setText(rs.getString("MaLuong"));
				txt_LuongTheoGio.setText(rs.getDouble("LuongTheoGio")+"");
				txt_SoGioLam.setText(rs.getString("SoGioLam"));
				txt_GhiChu.setText(rs.getString("GhiChu"));
			}
		} catch (SQLException ex) {

		}
	}

	private void soLuong(int giatri) {
		int sl = Integer.parseInt(txt_SoGioLam.getText());
		sl = sl + (giatri);
		txt_SoGioLam.setText(String.valueOf(sl));
	}

	private void lamMoi() {

		frm_QuanLyChinh frm = frm_QuanLyChinh.b;
		frm.tab.remove(form);
		pnl_LoaiLuong pnl = new pnl_LoaiLuong();
		frm.tab.add("Lương", pnl);
		frm.tab.setSelectedComponent(pnl);
	}

	private void ganField() {
		int vitri = tbl_NV.getSelectedRow();
		txt_TenNV.setText(tbl_NV.getValueAt(vitri, 1).toString());
		String maluong = tbl_NV.getValueAt(vitri, 2).toString();
		String maNhanVien = tbl_NV.getValueAt(vitri, 0).toString();
		// gắn mã nhận lương
		Date d = new Date();
		SimpleDateFormat D = new SimpleDateFormat("ddMMyyyy");
		lbl_MaNhanLuong.setText(D.format(d) + maNhanVien);
		//
		ResultSet rs = dao.DAO_Luong.layLuongTheoMa(maluong);
		try {
			if (rs.next()) {
				txt_LuongTheoGio2.setText(ChuyenDoi.dinhDangSo(rs
						.getDouble("LuongTheoGio")));
				txt_SoGioLam2.setText(rs.getString("SoGioLam"));
			}

		} catch (SQLException ex) {
			Logger.getLogger(pnl_LoaiLuong.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		try {
			tinhNgayLam(ChuyenDoi.getDate(tbl_NV.getValueAt(vitri, 3)
					.toString()));
		} catch (Exception e) {
			tinhNgayLam(d);
		}
		// gắn DTO nl
		nl.setNhanVien(new NhanVien(maNhanVien));
	}

	private void tinhNgayLam(Date ngaylam) {

		try {
			Date d = new Date();
			SimpleDateFormat D = new SimpleDateFormat("dd/MM/yyyy");
			ngayhientai = D.format(d);// gắn ngày hiện tại

			long ngay = (d.getTime() - ngaylam.getTime()) / (24 * 3600 * 1000);
			int songaynghi = Integer.parseInt(txt_SoNgayNghi.getText());
			int songaylam = (int) (ngay - songaynghi);
			System.out.println("so ngay lam" + songaylam);
			txt_SoNgayLam.setText(String.valueOf(songaylam));

			// tinh tien
			double luongtheogio = ChuyenDoi.chuyenSangSo(txt_LuongTheoGio2
					.getText());
			int sogiolam = Integer.parseInt(txt_SoGioLam2.getText());
			double tongluong = sogiolam * luongtheogio * songaylam;

			txt_TongLuong.setText(ChuyenDoi.dinhDangSo(tongluong));
		} catch (Exception e) {
		}

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btn_Cong;
	private javax.swing.JButton btn_LamMoi;
	private javax.swing.JButton btn_Sua;
	private javax.swing.JButton btn_Them;
	private javax.swing.JButton btn_Tru;
	private javax.swing.JButton btn_Xoa;
	private javax.swing.JButton btn_XuatPhieu;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JLabel lbl_GhiChu;
	private javax.swing.JLabel lbl_LoaiLuong;
	private javax.swing.JLabel lbl_LuongTheoGio;
	private javax.swing.JLabel lbl_LuongTheoGio2;
	private javax.swing.JLabel lbl_MaLuong;
	private javax.swing.JLabel lbl_MaNhanLuong;
	private javax.swing.JLabel lbl_MaNhanLuong2;
	private javax.swing.JLabel lbl_SoGioLam;
	private javax.swing.JLabel lbl_SoGioLam2;
	private javax.swing.JLabel lbl_SoNGayNghi;
	private javax.swing.JLabel lbl_SoNgayLam;
	private javax.swing.JLabel lbl_TenNV;
	private javax.swing.JLabel lbl_TongNhan;
	private javax.swing.JLabel lbl_TraLuong;
	private javax.swing.JPanel pnl_GD;
	private javax.swing.JPanel pnl_Luong;
	private javax.swing.JPanel pnl_Nut;
	private javax.swing.JTable tbl_Luong;
	private javax.swing.JTable tbl_NV;
	private javax.swing.JTextArea txt_GhiChu;
	private javax.swing.JTextField txt_LuongTheoGio;
	private javax.swing.JTextField txt_LuongTheoGio2;
	private javax.swing.JTextField txt_SoGioLam;
	private javax.swing.JTextField txt_SoGioLam2;
	private javax.swing.JTextField txt_SoNgayLam;
	private javax.swing.JTextField txt_SoNgayNghi;
	private javax.swing.JTextField txt_TenNV;
	private javax.swing.JTextField txt_TongLuong;
	private javax.swing.JTextField txt_maluong;
	// End of variables declaration//GEN-END:variables
}
