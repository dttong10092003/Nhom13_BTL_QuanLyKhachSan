package gui;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entity.KhachHang;
import entity.LoaiKH;

/**
 *
 * @author ADMIN
 */
public class pnl_KhachHang extends javax.swing.JPanel {

	/**
	 * Creates new form pnl_KhachHang
	 */
	public static pnl_KhachHang form;
	public static int moform;

	public pnl_KhachHang() {
		initComponents();

		btn_Chon.setVisible(false);

		bus.BUS_KH.dodulieu(tbl_KH);

		loadData_LoaiKH();
		form = this;
		btn_Chon.setEnabled(false);
		pnl_CTKH.setVisible(false);

	}

	private void loadData_LoaiKH() {
		DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb_LoaiKH
				.getModel();
		cbbModel.removeAllElements();
		ResultSet rs = dao.DAO_LoaiKH.layLoaiKH();
		try {
			while (rs.next()) {
				Object MaLoaiKH = rs.getString("MaLoaiKH");
				Object TenLoaiKH = rs.getString("TenLoaiKH");
				mycombobox mb = new mycombobox(MaLoaiKH, TenLoaiKH);
				cbbModel.addElement(mb);
			}
		} catch (SQLException ex) {
			System.out.println("lỗi đổ cbb_LoaiKhachHang");
		}
	}

	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		pnl_GD = new javax.swing.JPanel();
		pnl_ThemSuaXoa = new javax.swing.JPanel();
		btn_Sua = new javax.swing.JButton();
		btn_Xoa = new javax.swing.JButton();
		btn_Them = new javax.swing.JButton();
		btn_LamMoi = new javax.swing.JButton();
		pnl_KH = new javax.swing.JPanel();
		lbl_MaKH = new javax.swing.JLabel();
		txt_MaKH = new javax.swing.JTextField();
		lbl_LoaiKH = new javax.swing.JLabel();
		cbb_LoaiKH = new javax.swing.JComboBox<>();
		lbl_TenKH = new javax.swing.JLabel();
		txt_TenKH = new javax.swing.JTextField();
		lbl_Tuoi = new javax.swing.JLabel();
		txt_Tuoi = new javax.swing.JTextField();
		btn_ThemLoai = new javax.swing.JButton();
		lbl_GioiTinh = new javax.swing.JLabel();
		rab_Nam = new javax.swing.JRadioButton();
		rab_Nu = new javax.swing.JRadioButton();
		lbl_SDT = new javax.swing.JLabel();
		txt_SDT = new javax.swing.JTextField();
		lbl_CCCD = new javax.swing.JLabel();
		txt_CCCD = new javax.swing.JTextField();
		btn_Tru = new javax.swing.JButton();
		btn_Cong = new javax.swing.JButton();
		pnl_TimKiem = new javax.swing.JPanel();
		lbl_TimKiem = new javax.swing.JLabel();
		txt_TimKiem = new javax.swing.JTextField();
		btn_TimKiem = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		tbl_KH = new javax.swing.JTable();
		btn_Chon = new javax.swing.JButton();
		pnl_CTKH = new javax.swing.JPanel();
		lbl_LoaiKH2 = new javax.swing.JLabel();
		lbl_MaLoai = new javax.swing.JLabel();
		lbl_TenLoai = new javax.swing.JLabel();
		lbl_TienGiam = new javax.swing.JLabel();
		lbl_MoTa = new javax.swing.JLabel();
		txt_MaLoai = new javax.swing.JTextField();
		txt_TenLoaiKH = new javax.swing.JTextField();
		txt_TiemGiam = new javax.swing.JTextField();
		lbl_PhanTram = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		txt_MoTa = new javax.swing.JTextArea();
		btn_Them2 = new javax.swing.JButton();
		btn_SuaLoai = new javax.swing.JButton();
		btn_XoaLoai = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		tbl_LoaiKH = new javax.swing.JTable();

		setBackground(new java.awt.Color(255, 255, 255));

		pnl_GD.setBackground(new java.awt.Color(255, 255, 255));
		pnl_GD.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		pnl_ThemSuaXoa.setBackground(new java.awt.Color(153, 153, 255));

		btn_Sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btn_Sua.setIcon(new javax.swing.ImageIcon("HinhAnh/icon_server.png")); // NOI18N
		btn_Sua.setText("Sửa");
		btn_Sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btn_Sua.setEnabled(false);
		btn_Sua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_SuaActionPerformed(evt);
			}
		});

		btn_Xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btn_Xoa.setIcon(new javax.swing.ImageIcon("HinhAnh/Icon_Tru.png")); // NOI18N
		btn_Xoa.setText("Xóa");
		btn_Xoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btn_Xoa.setEnabled(false);
		btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_XoaActionPerformed(evt);
			}
		});

		btn_Them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btn_Them.setIcon(new javax.swing.ImageIcon("HinhAnh/Icon_Cong.png")); // NOI18N
		btn_Them.setText("Thêm");
		btn_Them.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btn_Them.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_ThemActionPerformed(evt);
			}
		});

		btn_LamMoi
				.setIcon(new javax.swing.ImageIcon("HinhAnh/Icon_Reload.png")); // NOI18N
		btn_LamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_LamMoiActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnl_ThemSuaXoaLayout = new javax.swing.GroupLayout(
				pnl_ThemSuaXoa);
		pnl_ThemSuaXoa.setLayout(pnl_ThemSuaXoaLayout);
		pnl_ThemSuaXoaLayout
				.setHorizontalGroup(pnl_ThemSuaXoaLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								pnl_ThemSuaXoaLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(btn_Them)
										.addGap(18, 18, 18)
										.addComponent(btn_Xoa)
										.addGap(18, 18, 18)
										.addComponent(btn_Sua)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												14, Short.MAX_VALUE)
										.addComponent(btn_LamMoi)));
		pnl_ThemSuaXoaLayout
				.setVerticalGroup(pnl_ThemSuaXoaLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								pnl_ThemSuaXoaLayout
										.createSequentialGroup()
										.addGap(18, 18, 18)
										.addGroup(
												pnl_ThemSuaXoaLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																btn_LamMoi,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																pnl_ThemSuaXoaLayout
																		.createSequentialGroup()
																		.addGroup(
																				pnl_ThemSuaXoaLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								btn_Xoa)
																						.addComponent(
																								btn_Them)
																						.addComponent(
																								btn_Sua,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(0,
																				1,
																				Short.MAX_VALUE)))
										.addContainerGap()));

		pnl_KH.setBackground(new java.awt.Color(255, 255, 255));
		pnl_KH.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		lbl_MaKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_MaKH.setText("Mã khách hàng");

		txt_MaKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txt_MaKH.setEditable(false);

		lbl_LoaiKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_LoaiKH.setText("Loại khách hàng");

		cbb_LoaiKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		lbl_TenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_TenKH.setText("Tên khách hàng");

		txt_TenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		lbl_Tuoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_Tuoi.setText("Tuổi");

		txt_Tuoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txt_Tuoi.setText("01");
		txt_Tuoi.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_TuoiKeyReleased(evt);
			}
		});

		btn_ThemLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btn_ThemLoai.setText("Thêm mới");
		btn_ThemLoai
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btn_ThemLoai.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_ThemLoaiActionPerformed(evt);
			}
		});

		lbl_GioiTinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_GioiTinh.setText("Giới tính");

		buttonGroup1.add(rab_Nam);
		rab_Nam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		rab_Nam.setText("Nam");

		buttonGroup1.add(rab_Nu);
		rab_Nu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		rab_Nu.setText("Nữ");

		lbl_SDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_SDT.setText("Số điện thoại");

		txt_SDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		lbl_CCCD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_CCCD.setText("Số CCCD");

		txt_CCCD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		btn_Tru.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		btn_Tru.setText("-");
		btn_Tru.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_TruActionPerformed(evt);
			}
		});

		btn_Cong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		btn_Cong.setText("+");
		btn_Cong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_CongActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl_KH);
		pnl_KH.setLayout(pnl2Layout);
		pnl2Layout
				.setHorizontalGroup(pnl2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnl2Layout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lbl_MaKH)
														.addComponent(
																lbl_LoaiKH)
														.addComponent(lbl_TenKH)
														.addComponent(lbl_Tuoi)
														.addComponent(
																lbl_GioiTinh)
														.addComponent(lbl_SDT)
														.addComponent(lbl_CCCD))
										.addGap(23, 23, 23)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																pnl2Layout
																		.createSequentialGroup()
																		.addComponent(
																				rab_Nam)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				rab_Nu))
														.addGroup(
																pnl2Layout
																		.createSequentialGroup()
																		.addComponent(
																				txt_Tuoi,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				128,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				btn_Tru)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				btn_Cong))
														.addGroup(
																pnl2Layout
																		.createSequentialGroup()
																		.addGroup(
																				pnl2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								pnl2Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												txt_TenKH,
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												cbb_LoaiKH,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												0,
																												149,
																												Short.MAX_VALUE)
																										.addComponent(
																												txt_MaKH,
																												javax.swing.GroupLayout.Alignment.LEADING))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								pnl2Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												txt_CCCD,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												148,
																												Short.MAX_VALUE)
																										.addComponent(
																												txt_SDT,
																												javax.swing.GroupLayout.Alignment.LEADING)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				btn_ThemLoai)))));
		pnl2Layout
				.setVerticalGroup(pnl2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnl2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_MaKH)
														.addComponent(
																txt_MaKH,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lbl_LoaiKH)
														.addComponent(
																cbb_LoaiKH,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btn_ThemLoai))
										.addGap(18, 18, 18)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_TenKH)
														.addComponent(
																txt_TenKH,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_Tuoi)
														.addComponent(
																txt_Tuoi,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(btn_Tru)
														.addComponent(btn_Cong))
										.addGap(18, 18, 18)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lbl_GioiTinh)
														.addComponent(rab_Nam)
														.addComponent(rab_Nu))
										.addGap(18, 18, 18)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_SDT)
														.addComponent(
																txt_SDT,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												pnl2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_CCCD)
														.addComponent(
																txt_CCCD,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(110, Short.MAX_VALUE)));

		javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl_GD);
		pnl_GD.setLayout(pnlLayout);
		pnlLayout
				.setHorizontalGroup(pnlLayout
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
																pnl_ThemSuaXoa,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																pnl_KH,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(0, 0, Short.MAX_VALUE)));
		pnlLayout
				.setVerticalGroup(pnlLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												pnl_KH,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												pnl_ThemSuaXoa,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)));

		pnl_TimKiem.setBackground(new java.awt.Color(255, 255, 255));
		pnl_TimKiem.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		lbl_TimKiem.setBackground(new java.awt.Color(204, 255, 204));
		lbl_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lbl_TimKiem.setText("Tìm kiếm");
		lbl_TimKiem.setOpaque(true);

		txt_TimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_TimKiemKeyReleased(evt);
			}
		});

		btn_TimKiem.setBackground(new java.awt.Color(255, 255, 255));
		btn_TimKiem
				.setIcon(new javax.swing.ImageIcon("HinhAnh/Icon_Search.png")); // NOI18N

		tbl_KH.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Mã KH", "Tên KH" }));
		tbl_KH.setPreferredScrollableViewportSize(new Dimension(0, 370));
		tbl_KH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		tbl_KH.setGridColor(new java.awt.Color(255, 255, 255));
		tbl_KH.setSelectionBackground(new java.awt.Color(255, 204, 102));
		tbl_KH.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_KHMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tbl_KH);

		btn_Chon.setBackground(new java.awt.Color(153, 255, 153));
		btn_Chon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btn_Chon.setText("Chọn");
		btn_Chon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btn_Chon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_ChonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnl_TimKiemLayout = new javax.swing.GroupLayout(
				pnl_TimKiem);
		pnl_TimKiem.setLayout(pnl_TimKiemLayout);
		pnl_TimKiemLayout
				.setHorizontalGroup(pnl_TimKiemLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnl_TimKiemLayout
										.createSequentialGroup()
										.addGroup(
												pnl_TimKiemLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																btn_Chon,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																0,
																Short.MAX_VALUE)
														.addComponent(
																lbl_TimKiem,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																pnl_TimKiemLayout
																		.createSequentialGroup()
																		.addComponent(
																				txt_TimKiem,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				188,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				btn_TimKiem,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				65,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(0, 0, Short.MAX_VALUE)));
		pnl_TimKiemLayout
				.setVerticalGroup(pnl_TimKiemLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnl_TimKiemLayout
										.createSequentialGroup()
										.addComponent(
												lbl_TimKiem,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												41,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												pnl_TimKiemLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																txt_TimKiem,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																46,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btn_TimKiem,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																46,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(9, 9, 9)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												btn_Chon,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												56,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		pnl_CTKH.setBackground(new java.awt.Color(255, 255, 255));
		pnl_CTKH.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		lbl_LoaiKH2.setBackground(new java.awt.Color(102, 255, 255));
		lbl_LoaiKH2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_LoaiKH2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbl_LoaiKH2.setText("Loại khách hàng");
		lbl_LoaiKH2.setToolTipText("");
		lbl_LoaiKH2.setOpaque(true);

		lbl_MaLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_MaLoai.setText("Mã loại KH");

		lbl_TenLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_TenLoai.setText("Tên loại KH");

		lbl_TienGiam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_TienGiam.setText("Tiền giảm");

		lbl_MoTa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_MoTa.setText("Mô tả");

		txt_MaLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txt_MaLoai.setEditable(false);

		txt_TenLoaiKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		txt_TiemGiam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txt_TiemGiam.setText("0");
		txt_TiemGiam.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_TiemGiamKeyReleased(evt);
			}
		});

		lbl_PhanTram.setText("%");

		txt_MoTa.setColumns(20);
		txt_MoTa.setRows(5);
		jScrollPane2.setViewportView(txt_MoTa);

		btn_Them2.setIcon(new javax.swing.ImageIcon("HinhAnh/Icon_Cong.png")); // NOI18N
		btn_Them2.setText("Thêm");
		btn_Them2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btn_Them2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_Them2ActionPerformed(evt);
			}
		});

		btn_SuaLoai
				.setIcon(new javax.swing.ImageIcon("HinhAnh/icon_server.png")); // NOI18N
		btn_SuaLoai.setText("Sửa");
		btn_SuaLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btn_SuaLoai.setEnabled(false);
		btn_SuaLoai.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_SuaLoaiActionPerformed(evt);
			}
		});

		btn_XoaLoai.setIcon(new javax.swing.ImageIcon("HinhAnh/Icon_Tru.png")); // NOI18N
		btn_XoaLoai.setText("Xóa");
		btn_XoaLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btn_XoaLoai.setEnabled(false);
		btn_XoaLoai.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_XoaLoaiActionPerformed(evt);
			}
		});

		tbl_LoaiKH.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "MaLoaiKH", "TenLoaiKH", "TienGiam" }));
		tbl_LoaiKH.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_LoaiKHMouseClicked(evt);
			}
		});
		jScrollPane3.setViewportView(tbl_LoaiKH);

		javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(
				pnl_CTKH);
		pnl_CTKH.setLayout(pnl3Layout);
		pnl3Layout
				.setHorizontalGroup(pnl3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnl3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												pnl3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lbl_MoTa)
														.addGroup(
																pnl3Layout
																		.createSequentialGroup()
																		.addGroup(
																				pnl3Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								lbl_MaLoai)
																						.addComponent(
																								lbl_TenLoai)
																						.addComponent(
																								lbl_TienGiam))
																		.addGroup(
																				pnl3Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								pnl3Layout
																										.createSequentialGroup()
																										.addGap(31,
																												31,
																												31)
																										.addComponent(
																												txt_TiemGiam,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												94,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												lbl_PhanTram)
																										.addGap(0,
																												0,
																												Short.MAX_VALUE))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								pnl3Layout
																										.createSequentialGroup()
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addGroup(
																												pnl3Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																txt_MaLoai,
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																201,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																txt_TenLoaiKH,
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																201,
																																javax.swing.GroupLayout.PREFERRED_SIZE)))))
														.addGroup(
																pnl3Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				pnl3Layout
																						.createSequentialGroup()
																						.addComponent(
																								btn_Them2)
																						.addGap(18,
																								18,
																								18)
																						.addComponent(
																								btn_SuaLoai)
																						.addGap(18,
																								18,
																								18)
																						.addComponent(
																								btn_XoaLoai))))
										.addContainerGap())
						.addComponent(lbl_LoaiKH2,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jScrollPane3,
								javax.swing.GroupLayout.PREFERRED_SIZE, 0,
								Short.MAX_VALUE));
		pnl3Layout
				.setVerticalGroup(pnl3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnl3Layout
										.createSequentialGroup()
										.addComponent(
												lbl_LoaiKH2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												42,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addGroup(
												pnl3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lbl_MaLoai)
														.addComponent(
																txt_MaLoai,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												pnl3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lbl_TenLoai)
														.addComponent(
																txt_TenLoaiKH,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												pnl3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																lbl_TienGiam)
														.addGroup(
																pnl3Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				txt_TiemGiam,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lbl_PhanTram)))
										.addGap(18, 18, 18)
										.addComponent(lbl_MoTa)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addGroup(
												pnl3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																btn_SuaLoai,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																39,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																pnl3Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				btn_XoaLoai)
																		.addComponent(
																				btn_Them2)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane3,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												329, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(pnl_TimKiem,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(pnl_GD,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(25, 25, 25)
								.addComponent(pnl_CTKH,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addComponent(pnl_CTKH,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(pnl_GD,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pnl_TimKiem,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	}// </editor-fold>//GEN-END:initComponents

	private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_SuaActionPerformed
		ganThongTinSua();
		if (bus.BUS_KH.kt_Sua(KH)) {
			dao.DAO_KhachHang.sua(KH);
			bus.BUS_KH.dodulieu(tbl_KH);
		}
	}// GEN-LAST:event_btn_SuaActionPerformed

	public static entity.KhachHang KH = new KhachHang();
	public static entity.LoaiKH Loai = new entity.LoaiKH();

	private void ganThongTin() {
		ResultSet rs = dao.DAO_KhachHang.layKH();
		String maKH_MoiNhat = null;
		System.out.println(rs);// Xem có dữ liệu hay không
		try {
			while (rs.next()) {
				maKH_MoiNhat = rs.getString("MaKhachHang");
			}
		} catch (Exception e) {
			Logger.getLogger(pnl_NhanVien.class.getName()).log(Level.SEVERE,
					null, e);
		}
		int nextMaKH = Integer.parseInt(maKH_MoiNhat.substring(2));
		String newMaKH = "KH" + String.format("%03d", nextMaKH + 1);
		txt_MaKH.setText(newMaKH);
		KH.setMaKH(txt_MaKH.getText());
		gui.mycombobox mb = (gui.mycombobox) cbb_LoaiKH.getSelectedItem();

		KH.setLoaiKH(new LoaiKH(mb.value.toString()));

		KH.setTenKH(txt_TenKH.getText());

		KH.setTuoi(Integer.parseInt(txt_Tuoi.getText()));
		if (rab_Nam.isSelected()) {
			KH.setGioiTinh(true);
		} else {
			KH.setGioiTinh(false);
		}

		KH.setSDT(txt_SDT.getText());
		KH.setCCCD(txt_CCCD.getText());
	}

	private void ganThongTinSua() {
		KH.setMaKH(txt_MaKH.getText());
		gui.mycombobox mb = (gui.mycombobox) cbb_LoaiKH.getSelectedItem();

		KH.setLoaiKH(new LoaiKH(mb.value.toString()));

		KH.setTenKH(txt_TenKH.getText());

		KH.setTuoi(Integer.parseInt(txt_Tuoi.getText()));
		if (rab_Nam.isSelected()) {
			KH.setGioiTinh(true);
		} else {
			KH.setGioiTinh(false);
		}

		KH.setSDT(txt_SDT.getText());
		KH.setCCCD(txt_CCCD.getText());
	}

	private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_ThemActionPerformed

		ganThongTin();
		boolean kt = bus.BUS_KH.kt_Them(KH);
		if (kt) {
			dao.DAO_KhachHang.them(KH);
			bus.BUS_KH.dodulieu(tbl_KH);
		}
	}// GEN-LAST:event_btn_ThemActionPerformed

	public static int vitri;
	public static String MaKH;

	private void tbl_KHMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_KHMouseClicked
		if (tbl_KH.getSelectedRowCount() == 1) {
			vitri = tbl_KH.getSelectedRow();
			MaKH = tbl_KH.getValueAt(vitri, 0).toString();
			thongTinChiTiet(MaKH);
			ResultSet rs = dao.DAO_KhachHang.layKHTheoMa(MaKH);
			btn_Chon.setEnabled(true);
			btn_Xoa.setEnabled(true);
			btn_Sua.setEnabled(true);
		}

	}// GEN-LAST:event_tbl_KHMouseClicked

	private void btn_ChonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_ChonActionPerformed
		frm_ThuePhong frm = frm_ThuePhong.form;
		frm.setVisible(true);
		frm.loadData_KH();
		DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) frm.cbb_KhachHang
				.getModel();
		for (int i = 0; i < frm.cbb_KhachHang.getItemCount(); i++) {
			mycombobox mb = (mycombobox) cbbModel.getElementAt(i);
			if (MaKH.equals(mb.value)) {
				frm.cbb_KhachHang.setSelectedIndex(i);
			} else {
			}
		}
	}// GEN-LAST:event_btn_ChonActionPerformed

	private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_XoaActionPerformed
		int nutbam = JOptionPane.showConfirmDialog(new JFrame(),
				"bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
		if (nutbam == JOptionPane.YES_OPTION) {
			int cacdong[] = tbl_KH.getSelectedRows();
			for (int i = 0; i < cacdong.length; i++) {
				String MaKH = tbl_KH.getValueAt(cacdong[i], 0).toString();
				if (bus.BUS_KH.kt_Xoa(MaKH)) {
					dao.DAO_KhachHang.xoa(MaKH);
				}
			}
			bus.BUS_KH.dodulieu(tbl_KH);
		}
	}// GEN-LAST:event_btn_XoaActionPerformed

	private void txt_TuoiKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_TuoiKeyReleased
		try {
			int sl = Integer.parseInt(txt_Tuoi.getText());
		} catch (Exception e) {
			txt_Tuoi.setText("01");
		}
	}// GEN-LAST:event_txt_TuoiKeyReleased

	private void btn_TruActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_TruActionPerformed
		if (!txt_Tuoi.getText().equals("1")) {
			tuoi(-1);
		}
	}// GEN-LAST:event_btn_TruActionPerformed

	private void btn_CongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_CongActionPerformed
		tuoi(1);
	}// GEN-LAST:event_btn_CongActionPerformed

	private void btn_ThemLoaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_ThemLoaiActionPerformed

		pnl_CTKH.setVisible(true);
		bus.BUS_LoaiKH.doDuLieuBang(tbl_LoaiKH);
	}// GEN-LAST:event_btn_ThemLoaiActionPerformed

	private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_LamMoiActionPerformed
		lamMoi();

	}// GEN-LAST:event_btn_LamMoiActionPerformed

	private void ganDuLieuLoai() {
		ResultSet rs = dao.DAO_LoaiKH.layLoaiKH();
		String maLoaiKH_MoiNhat = null;
		System.out.println(rs);// Xem có dữ liệu hay không
		try {
			while (rs.next()) {
				maLoaiKH_MoiNhat = rs.getString("MaLoaiKH");
			}
		} catch (Exception e) {
			Logger.getLogger(pnl_NhanVien.class.getName()).log(Level.SEVERE,
					null, e);
		}
		int nextMaLoaiKH = Integer.parseInt(maLoaiKH_MoiNhat);
		String newMaLoaiKH = String.format("%d", nextMaLoaiKH + 1);
		txt_MaLoai.setText(newMaLoaiKH);

		Loai.setMaLoaiKH(txt_MaLoai.getText());
		Loai.setTenLoaiKH(txt_TenLoaiKH.getText());
		Loai.setTienGiam(Integer.parseInt(txt_TiemGiam.getText()));
		Loai.setMoTa(txt_MoTa.getText());
	}

	private void ganDuLieuLoaiSua() {
		Loai.setMaLoaiKH(txt_MaLoai.getText());
		Loai.setTenLoaiKH(txt_TenLoaiKH.getText());
		Loai.setTienGiam(Integer.parseInt(txt_TiemGiam.getText()));
		Loai.setMoTa(txt_MoTa.getText());
	}

	private void dienDuLieuVaoField(String MaLoai) {
		ResultSet rs = dao.DAO_LoaiKH.layTheoMa(MaLoai);
		try {
			if (rs.next()) {
				txt_MaLoai.setText(rs.getString("MaLoaiKH"));
				txt_TenLoaiKH.setText(rs.getString("TenLoaiKH"));
				txt_TiemGiam.setText(rs.getString("TienGiam"));
				txt_MoTa.setText(rs.getString("MoTa"));
			}
		} catch (SQLException ex) {
			Logger.getLogger(pnl_KhachHang.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	private void btn_Them2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_Them2ActionPerformed
		ganDuLieuLoai();
		if (bus.BUS_LoaiKH.kt_Them(Loai)) {
			dao.DAO_LoaiKH.them(Loai);
			bus.BUS_LoaiKH.doDuLieuBang(tbl_LoaiKH);
			// LamMoi(); //Hàm có thể xóa
		}
	}// GEN-LAST:event_btn_Them2ActionPerformed

	private void tbl_LoaiKHMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_LoaiKHMouseClicked
		if (tbl_LoaiKH.getSelectedRowCount() == 1) {
			btn_SuaLoai.setEnabled(true);
			btn_XoaLoai.setEnabled(true);
			int vitri = tbl_LoaiKH.getSelectedRow();
			String MaLoaiKH = tbl_LoaiKH.getValueAt(vitri, 0).toString();
			dienDuLieuVaoField(MaLoaiKH);
			txt_MaLoai.setFocusable(false);
		}
	}// GEN-LAST:event_tbl_LoaiKHMouseClicked

	private void btn_SuaLoaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_SuaLoaiActionPerformed
		ganDuLieuLoaiSua();
		if (bus.BUS_LoaiKH.kt_Sua(Loai)) {
			dao.DAO_LoaiKH.sua(Loai);
			bus.BUS_LoaiKH.doDuLieuBang(tbl_LoaiKH);
			lamMoiLoai();

		}

	}// GEN-LAST:event_btn_SuaLoaiActionPerformed

	private void btn_XoaLoaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_XoaLoaiActionPerformed
		int nutbam = JOptionPane.showConfirmDialog(new JFrame(),
				"bạn chắc chắn xóa?", "xóA", JOptionPane.YES_NO_OPTION);
		if (nutbam == JOptionPane.YES_OPTION) {
			int cacdong[] = tbl_LoaiKH.getSelectedRows();
			for (int i = 0; i < cacdong.length; i++) {
				String MaLoaiKH = tbl_LoaiKH.getValueAt(cacdong[i], 0)
						.toString();
				if (bus.BUS_LoaiKH.kt_Xoa(MaLoaiKH)) {
					dao.DAO_LoaiKH.xoa(MaLoaiKH);
					bus.BUS_LoaiKH.doDuLieuBang(tbl_LoaiKH);

					lamMoiLoai();
				}
			}
		}
	}// GEN-LAST:event_btn_XoaLoaiActionPerformed

	private void txt_TiemGiamKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_TiemGiamKeyReleased
		try {
			int sl = Integer.parseInt(txt_TiemGiam.getText());

		} catch (Exception e) {
			txt_TiemGiam.setText("0");

		}
	}// GEN-LAST:event_txt_TiemGiamKeyReleased

	private void txt_TimKiemKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_TimKiemKeyReleased
		String tukhoa = txt_TimKiem.getText();
		bus.BUS_KH.timKiem(tbl_KH, tukhoa);
	}// GEN-LAST:event_txt_TimKiemKeyReleased

	private void lamMoiLoai() {
		txt_TenLoaiKH.setText("");
		txt_MaLoai.setText("");
		txt_TiemGiam.setText("");
		txt_MoTa.setText("");
		txt_MaLoai.setFocusable(true);

	}

	private void thongTinChiTiet(String MaKH) {
		ResultSet rs = dao.DAO_KhachHang.layKHTheoMa(MaKH);
		try {
			if (rs.next()) {
				txt_MaKH.setText(rs.getString("MaKhachHang"));
				String MaLoai = rs.getString("MaloaiKH");
				DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb_LoaiKH
						.getModel();
				for (int i = 0; i < cbb_LoaiKH.getItemCount(); i++) {
					mycombobox mb = (mycombobox) cbbModel.getElementAt(i);
					if (MaLoai.equals(mb.value)) {
						cbb_LoaiKH.setSelectedIndex(i);
					} else {
					}
				}
				txt_TenKH.setText(rs.getString("TenKhachHang"));
				txt_Tuoi.setText(String.valueOf(rs.getInt("Tuoi")));
				if (rs.getBoolean("GioiTinh") == true) {
					rab_Nam.setSelected(true);
				} else {
					rab_Nu.setSelected(true);
				}
				txt_SDT.setText(rs.getString("SoDienThoai"));
				txt_CCCD.setText(rs.getString("SoCCCD"));
			}
		} catch (SQLException ex) {

		}
	}

	public void moform() {
		btn_Chon.setVisible(true);
		loadData_LoaiKH();
	}

	private void tuoi(int giatri) {
		int sl = Integer.parseInt(txt_Tuoi.getText());
		sl = sl + (giatri);
		txt_Tuoi.setText(String.valueOf(sl));
	}

	private void lamMoi() {
		frm_QuanLyChinh frm = frm_QuanLyChinh.b;
		frm.tab.remove(form);
		pnl_KhachHang pnl = new pnl_KhachHang();
		frm.tab.add("Khách hàng", pnl);
		frm.tab.setSelectedComponent(pnl);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btn_Chon;
	private javax.swing.JButton btn_Cong;
	private javax.swing.JButton btn_LamMoi;
	private javax.swing.JButton btn_Sua;
	private javax.swing.JButton btn_SuaLoai;
	private javax.swing.JButton btn_Them;
	private javax.swing.JButton btn_Them2;
	private javax.swing.JButton btn_ThemLoai;
	private javax.swing.JButton btn_TimKiem;
	private javax.swing.JButton btn_Tru;
	private javax.swing.JButton btn_Xoa;
	private javax.swing.JButton btn_XoaLoai;
	private javax.swing.ButtonGroup buttonGroup1;
	public javax.swing.JComboBox<String> cbb_LoaiKH;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JLabel lbl_CCCD;
	private javax.swing.JLabel lbl_GioiTinh;
	private javax.swing.JLabel lbl_LoaiKH;
	private javax.swing.JLabel lbl_LoaiKH2;
	private javax.swing.JLabel lbl_MaKH;
	private javax.swing.JLabel lbl_MaLoai;
	private javax.swing.JLabel lbl_MoTa;
	private javax.swing.JLabel lbl_PhanTram;
	private javax.swing.JLabel lbl_SDT;
	private javax.swing.JLabel lbl_TenKH;
	private javax.swing.JLabel lbl_TenLoai;
	private javax.swing.JLabel lbl_TienGiam;
	private javax.swing.JLabel lbl_TimKiem;
	private javax.swing.JLabel lbl_Tuoi;
	private javax.swing.JPanel pnl_GD;
	private javax.swing.JPanel pnl_KH;
	private javax.swing.JPanel pnl_CTKH;
	private javax.swing.JPanel pnl_ThemSuaXoa;
	private javax.swing.JPanel pnl_TimKiem;
	private javax.swing.JRadioButton rab_Nam;
	private javax.swing.JRadioButton rab_Nu;
	private javax.swing.JTable tbl_KH;
	public javax.swing.JTable tbl_LoaiKH;
	private javax.swing.JTextField txt_CCCD;
	private javax.swing.JTextField txt_MaKH;
	private javax.swing.JTextField txt_MaLoai;
	private javax.swing.JTextArea txt_MoTa;
	private javax.swing.JTextField txt_SDT;
	private javax.swing.JTextField txt_TenKH;
	private javax.swing.JTextField txt_TenLoaiKH;
	private javax.swing.JTextField txt_TiemGiam;
	private javax.swing.JTextField txt_TimKiem;
	private javax.swing.JTextField txt_Tuoi;
	// End of variables declaration//GEN-END:variables
}
