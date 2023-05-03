package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import entity.HoaDon;
import entity.KhachHang;
import entity.Phong;
import entity.DatPhong;
import entity.User;

/**
 *
 * @author ADMIN
 */
public class pnl_DSThuePhong extends javax.swing.JPanel {

	/**
	 * Creates new form frm_DSThuePhong
	 */
	public static pnl_DSThuePhong form;

	public pnl_DSThuePhong() {
		initComponents();
		form = this;
		bus.BUS_DichVu.doDuLieuBangDatPhong(tbl_DSThuePhong);
		btn_DichVu.setEnabled(false);

	}

	public static entity.HoaDon HD = new HoaDon();

	private void initComponents() {

		pnl_GD = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tbl_DSThuePhong = new javax.swing.JTable();
		lbl_DSThuePhong = new javax.swing.JLabel();
		pnl_DSTP = new javax.swing.JPanel();
		pnl_CTTP = new javax.swing.JPanel();
		lbl_ChiTiet = new javax.swing.JLabel();
		btn_ThanhToan = new javax.swing.JButton();
		btn_Sua = new javax.swing.JButton();
		lbl_MaDatPhong = new javax.swing.JLabel();
		lbl_MaDP = new javax.swing.JLabel();
		lbl_TenKhachHang = new javax.swing.JLabel();
		lbl_Phong = new javax.swing.JLabel();
		lbl_NgayThue = new javax.swing.JLabel();
		lbl_NgayRaDuKien = new javax.swing.JLabel();
		lbl_SoNguoi = new javax.swing.JLabel();
		lbl_NguoiTao = new javax.swing.JLabel();
		txt_TenKH = new javax.swing.JTextField(15);
		txt_Phong = new javax.swing.JTextField(15);
		txt_NgayThue = new javax.swing.JTextField(15);
		txt_NgayRa = new javax.swing.JTextField(15);
		txt_SoNguoi = new javax.swing.JTextField(7);
		txt_NguoiTao = new javax.swing.JTextField(15);
		btn_Tru = new javax.swing.JButton();
		btn_Cong = new javax.swing.JButton();
		btn_DichVu = new javax.swing.JButton();
		lbl_Vuot = new javax.swing.JLabel();
		lbl_NgayVuot = new javax.swing.JLabel();
		lbl_Ngay = new javax.swing.JLabel();
		lbl_TongCong = new javax.swing.JLabel();
		lbl_TienPhong = new javax.swing.JLabel();
		lbl_TienDV = new javax.swing.JLabel();
		txt_TienPhong = new javax.swing.JTextField(8);
		txt_TienDV = new javax.swing.JTextField(8);
		lbl_vnd = new javax.swing.JLabel();
		lbl_vnd2 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		txt_TongCong = new javax.swing.JTextField(8);
		lbl_vnd3 = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		lbl_PhuThuCheckIn = new javax.swing.JLabel();
		lbl_PhuThuCheckOut = new javax.swing.JLabel();
		txt_CheckIn = new javax.swing.JTextField(8);
		txt_checkout = new javax.swing.JTextField(8);
		lbl_Dau = new javax.swing.JLabel();
		lbl_Dau2 = new javax.swing.JLabel();
		lbl_Dau3 = new javax.swing.JLabel();
		lbl_TienCoc = new javax.swing.JLabel();
		txt_TienCoc = new javax.swing.JTextField(8);
		lbl_Dau4 = new javax.swing.JLabel();
		lbl_vnd4 = new javax.swing.JLabel();
		lbl_vnd5 = new javax.swing.JLabel();
		lbl_vnd6 = new javax.swing.JLabel();
		lbl_KM = new javax.swing.JLabel();
		txt_GiamGia = new javax.swing.JTextField(3);
		lbl_PhanTram = new javax.swing.JLabel();

		setBackground(new java.awt.Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(980, 660));
		setRequestFocusEnabled(false);

		pnl_GD.setBackground(new java.awt.Color(255, 255, 255));
		pnl_GD.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		tbl_DSThuePhong.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "Mã ĐP", "Tên KH", "Phòng", "Loại thuê",
						"Ngày thuê" }));
		tbl_DSThuePhong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_DSThuePhongMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tbl_DSThuePhong);
		if (tbl_DSThuePhong.getColumnModel().getColumnCount() > 0) {
			tbl_DSThuePhong.getColumnModel().getColumn(0).setMinWidth(50);
			tbl_DSThuePhong.getColumnModel().getColumn(0).setPreferredWidth(50);
		}

		lbl_DSThuePhong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lbl_DSThuePhong.setText("Danh sách thuê phòng");

		javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl_GD);
		pnl_GD.setLayout(pnlLayout);
		pnlLayout.setHorizontalGroup(pnlLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						pnlLayout
								.createSequentialGroup()
								.addComponent(lbl_DSThuePhong)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
				.addComponent(jScrollPane1));
		pnlLayout
				.setVerticalGroup(pnlLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlLayout
										.createSequentialGroup()
										.addComponent(lbl_DSThuePhong)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPane1)));

		pnl_DSTP.setBackground(new java.awt.Color(204, 204, 255));

		pnl_CTTP.setBackground(new java.awt.Color(255, 255, 255));
		pnl_CTTP.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));

		lbl_ChiTiet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lbl_ChiTiet.setText("Chi tiết");

		btn_ThanhToan.setBackground(new java.awt.Color(102, 255, 102));
		btn_ThanhToan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btn_ThanhToan.setText("Thanh toán");
		btn_ThanhToan.setEnabled(false);
		btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_ThanhToanActionPerformed(evt);
			}
		});

		btn_Sua.setBackground(new java.awt.Color(255, 255, 255));
		btn_Sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btn_Sua.setIcon(new javax.swing.ImageIcon("HinhAnh/icon_server.png")); // NOI18N
		btn_Sua.setText("Sửa");
		btn_Sua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_SuaActionPerformed(evt);
			}
		});

		lbl_MaDatPhong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lbl_MaDatPhong.setText("Mã đặt phòng");

		lbl_MaDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_MaDP.setOpaque(true);

		lbl_TenKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_TenKhachHang.setText("Tên khách hàng");

		lbl_Phong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_Phong.setText("Phòng");

		lbl_NgayThue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_NgayThue.setText("Ngày thuê");

		lbl_NgayRaDuKien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_NgayRaDuKien.setText("Ngày ra dự kiến");

		lbl_SoNguoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_SoNguoi.setText("Số người");

		lbl_NguoiTao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_NguoiTao.setText("Người tạo");

		txt_TenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		txt_Phong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		txt_NgayThue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		txt_NgayRa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		txt_SoNguoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		txt_SoNguoi.setText("0");

		txt_NguoiTao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		btn_Tru.setBackground(new java.awt.Color(255, 255, 255));
		btn_Tru.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		btn_Tru.setText("-");
		btn_Tru.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_TruActionPerformed(evt);
			}
		});

		btn_Cong.setBackground(new java.awt.Color(255, 255, 255));
		btn_Cong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		btn_Cong.setText("+");
		btn_Cong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		btn_Cong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_CongActionPerformed(evt);
			}
		});

		btn_DichVu.setBackground(new java.awt.Color(153, 255, 153));
		btn_DichVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btn_DichVu.setText("Mở dịch vụ");
		btn_DichVu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_DichVUActionPerformed(evt);
			}
		});

		lbl_Vuot.setText("vượt quá:");

		lbl_Ngay.setText("(ngày)");

		lbl_TongCong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lbl_TongCong.setText("Tổng cộng");

		lbl_TienPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_TienPhong.setText("Tiền phòng");

		lbl_TienDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_TienDV.setText("Tiền dịch vụ");

		txt_TienPhong.setBackground(new java.awt.Color(102, 255, 204));
		txt_TienPhong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_TienPhong.setText("0");
		txt_TienPhong.setOpaque(true);

		txt_TienDV.setBackground(new java.awt.Color(102, 255, 204));
		txt_TienDV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_TienDV.setText("0");
		txt_TienDV.setOpaque(true);

		lbl_vnd.setText("(VNĐ)");

		lbl_vnd2.setText("(VNĐ)");

		jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

		txt_TongCong.setBackground(new java.awt.Color(102, 255, 204));
		txt_TongCong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_TongCong.setText("0");
		txt_TongCong.setOpaque(true);

		lbl_vnd3.setText("(VNĐ)");

		lbl_PhuThuCheckIn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_PhuThuCheckIn.setText("Phụ thu check in sớm");

		lbl_PhuThuCheckOut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_PhuThuCheckOut.setText("Phụ thu check out muộn");

		txt_CheckIn.setBackground(new java.awt.Color(102, 255, 204));
		txt_CheckIn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_CheckIn.setText("0");
		txt_CheckIn.setFocusable(false);

		txt_checkout.setBackground(new java.awt.Color(102, 255, 204));
		txt_checkout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_checkout.setText("0");
		txt_checkout.setFocusable(false);

		lbl_Dau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_Dau.setText("-");

		lbl_Dau2.setText("+");

		lbl_Dau3.setText("+");

		lbl_TienCoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_TienCoc.setText("Tiền đặt cọc");

		txt_TienCoc.setBackground(new java.awt.Color(51, 255, 204));
		txt_TienCoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txt_TienCoc.setText("0");
		txt_TienCoc.setOpaque(true);

		lbl_Dau4.setText("+");

		lbl_vnd4.setText("(VNĐ)");

		lbl_vnd5.setText("(VNĐ)");

		lbl_vnd6.setText("(VNĐ)");

		lbl_KM.setText("Khuyễn mãi");

		txt_GiamGia.setBackground(new java.awt.Color(51, 255, 204));
		txt_GiamGia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		txt_GiamGia.setText("0");
		txt_GiamGia.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txt_GiamGiaKeyReleased(evt);
			}
		});

		lbl_PhanTram.setText("%");

		javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(
				pnl_DSTP);
		pnl_DSTP.setLayout(pnl2Layout);
		pnl2Layout.setHorizontalGroup(pnl2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pnl_CTTP, javax.swing.GroupLayout.PREFERRED_SIZE, 485,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		pnl2Layout.setVerticalGroup(pnl2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pnl_CTTP, javax.swing.GroupLayout.DEFAULT_SIZE, 667,
				Short.MAX_VALUE));

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
								.addComponent(pnl_DSTP,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pnl_GD, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pnl_DSTP, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		// Add vào pnl3
		pnl_CTTP.setLayout(new GridLayout(14, 1));

		JPanel pnl31 = new JPanel(new GridLayout(1, 2));
		pnl31.setBackground(new java.awt.Color(255, 255, 255));
		pnl_CTTP.add(pnl31);
		pnl31.add(lbl_ChiTiet);
		JPanel pnl311 = new JPanel();
		pnl31.add(pnl311);
		pnl311.add(lbl_MaDatPhong);
		pnl311.setBackground(new java.awt.Color(255, 255, 255));
		pnl311.add(lbl_MaDP);

		JPanel pnl32 = new JPanel();
		pnl32.setBackground(new java.awt.Color(255, 255, 255));
		pnl32.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl32);
		pnl32.add(lbl_TenKhachHang);
		lbl_TenKhachHang.setPreferredSize(new Dimension(130, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl32.add(txt_TenKH);

		JPanel pnl33 = new JPanel();
		pnl33.setBackground(new java.awt.Color(255, 255, 255));
		pnl33.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl33);
		pnl33.add(lbl_Phong);
		lbl_Phong.setPreferredSize(new Dimension(130, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl33.add(txt_Phong);

		JPanel pnl34 = new JPanel();
		pnl34.setBackground(new java.awt.Color(255, 255, 255));
		pnl34.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl34);
		pnl34.add(lbl_NgayThue);
		lbl_NgayThue.setPreferredSize(new Dimension(130, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl34.add(txt_NgayThue);

		JPanel pnl35 = new JPanel();
		pnl35.setBackground(new java.awt.Color(255, 255, 255));
		pnl35.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl35);
		pnl35.add(lbl_NgayRaDuKien);
		lbl_NgayRaDuKien.setPreferredSize(new Dimension(130, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl35.add(txt_NgayRa);
		pnl35.add(lbl_Vuot);
		pnl35.add(lbl_NgayVuot);
		pnl35.add(lbl_Ngay);

		JPanel pnl36 = new JPanel();
		pnl36.setBackground(new java.awt.Color(255, 255, 255));
		pnl36.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl36);
		pnl36.add(lbl_SoNguoi);
		lbl_SoNguoi.setPreferredSize(new Dimension(130, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl36.add(txt_SoNguoi);
		pnl36.add(btn_Tru);
		pnl36.add(btn_Cong);
		pnl36.add(btn_Sua);

		JPanel pnl37 = new JPanel();
		pnl37.setBackground(new java.awt.Color(255, 255, 255));
		pnl37.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl37);
		pnl37.add(lbl_NguoiTao);
		lbl_NguoiTao.setPreferredSize(new Dimension(130, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl37.add(txt_NguoiTao);

		JPanel pnl3a = new JPanel();
		pnl3a.setBackground(new java.awt.Color(255, 255, 255));
		pnl3a.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl3a);
		pnl3a.add(lbl_TienPhong);
		lbl_TienPhong.setPreferredSize(new Dimension(160, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl3a.add(txt_TienPhong);
		pnl3a.add(lbl_vnd);

		JPanel pnl3b = new JPanel();
		pnl3b.setBackground(new java.awt.Color(255, 255, 255));
		pnl3b.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl3b);
		pnl3b.add(lbl_PhuThuCheckIn);
		// pnl3b.add(lbl_Dau2);
		lbl_PhuThuCheckIn.setPreferredSize(new Dimension(160, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl3b.add(txt_CheckIn);
		pnl3b.add(lbl_vnd2);

		JPanel pnl3c = new JPanel();
		pnl3c.setBackground(new java.awt.Color(255, 255, 255));
		pnl3c.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl3c);
		pnl3c.add(lbl_PhuThuCheckOut);
		lbl_PhuThuCheckOut.setPreferredSize(new Dimension(160, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl3c.add(txt_checkout);
		pnl3c.add(lbl_vnd3);

		JPanel pnl3d = new JPanel();
		pnl3d.setBackground(new java.awt.Color(255, 255, 255));
		pnl3d.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl3d);
		pnl3d.add(lbl_TienDV);
		lbl_TienDV.setPreferredSize(new Dimension(160, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl3d.add(txt_TienDV);
		pnl3d.add(lbl_vnd4);

		JPanel pnl3e = new JPanel();
		pnl3e.setBackground(new java.awt.Color(255, 255, 255));
		pnl3e.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl3e);
		pnl3e.add(lbl_TienCoc);
		lbl_TienCoc.setPreferredSize(new Dimension(160, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl3e.add(txt_TienCoc);
		pnl3e.add(lbl_vnd5);

		JPanel pnl3f = new JPanel();
		pnl3f.setBackground(new java.awt.Color(255, 255, 255));
		pnl3f.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl3f);
		pnl3f.add(lbl_TongCong);
		lbl_TongCong.setPreferredSize(new Dimension(160, lbl_TenKhachHang
				.getPreferredSize().height));
		pnl3f.add(txt_TongCong);
		pnl3f.add(lbl_vnd6);
		lbl_vnd6.setPreferredSize(new Dimension(50,
				lbl_vnd6.getPreferredSize().height));
		pnl3f.add(lbl_KM);
		pnl3f.add(txt_GiamGia);
		pnl3f.add(lbl_PhanTram);

		JPanel pnl3g = new JPanel();
		pnl3g.setBackground(new java.awt.Color(255, 255, 255));
		pnl3g.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_CTTP.add(pnl3g);
		pnl3g.add(btn_DichVu);
		pnl3g.add(btn_ThanhToan);
		btn_ThanhToan.setPreferredSize(new Dimension(360, 35));

	}// </editor-fold>//GEN-END:initComponents

	private void btn_DichVUActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_DichVUActionPerformed
		frm_QuanLyChinh frm = frm_QuanLyChinh.b;

		try {
			frm.tab.setSelectedComponent(pnl_DichVuPhong.form);
			pnl_DichVuPhong.form.chonDatPhong((datPhong.getMaDatPhong() + ""));
		} catch (Exception e) {
			pnl_DichVuPhong pnl = new pnl_DichVuPhong();
			frm.tab.add("Dịch vụ của phòng", pnl);
			frm.tab.setSelectedComponent(pnl);
			pnl.form.chonDatPhong((datPhong.getMaDatPhong() + ""));
			bus.BUS_DichVu.doDuLieuDichVu(pnl.form.tbl_DV,
					datPhong.getMaDatPhong() + "");
		}

	}// GEN-LAST:event_btn_DichVUActionPerformed

	public static Date ngayRaDuKien, GioThue;

	public static int songuoi;

	public void dienDuLieuVaoField(String MaDP) {
		ResultSet rs = dao.DAO_DatPhong.layTheoMa(MaDP);
		SimpleDateFormat D = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat C = new SimpleDateFormat("dd/MM/yyyy");
		String tenKH = "";
		try {
			if (rs.next()) {
				lbl_MaDP.setText(String.valueOf(rs.getInt("MaDatPhong")));
				ResultSet kh = dao.DAO_KhachHang.layKHTheoMa(rs
						.getString("MaKhachHang"));
				if (kh.next()) {
					txt_TenKH.setText(kh.getString("TenKhachHang"));
					tenKH = kh.getString("TenKhachHang");
					ResultSet LoaiKH = dao.DAO_LoaiKH.layTheoMa(kh
							.getString("MaLoaiKH"));
					if (LoaiKH.next()) {
						txt_GiamGia.setText(String.valueOf(LoaiKH
								.getInt("TienGiam")));
					}
				}
				txt_Phong.setText(rs.getString("MaPhong"));
				txt_NgayThue.setText(D.format(rs.getTimestamp("NgayThue")));
				GioThue = rs.getTimestamp("NgayThue");

				txt_NgayRa.setText(C.format(rs.getDate("NgayRaDuKien")));
				ngayRaDuKien = rs.getDate("NgayRaDuKien");
				txt_SoNguoi.setText(String.valueOf(rs.getInt("SoNguoi")));
				songuoi = rs.getInt("SoNguoi");
				txt_NguoiTao.setText(rs.getString("TenUser"));
				txt_TienCoc.setText(ChuyenDoi.dinhDangSo(rs
						.getDouble("TienDatCoc")));
				if (rs.getBoolean("LoaiHinhThue")) {
					tinhTienTheoGio();
					tinhGioCheckOut(false);
					txt_CheckIn.setText("0");
				} else {
					tinhTienTheoNgay();
					tinhGioCheckOut(true);
					tinhGioCheckIn();
				}

			}
		} catch (SQLException ex) {
			Logger.getLogger(pnl_DSThuePhong.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		tinhNgay();

	}

	private void tinhNgay() {
		try {
			long soNgay;
			Date ngayRa = new Date();
			SimpleDateFormat D = new SimpleDateFormat("yyyy-MM-dd");

			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(ngayRaDuKien);
			c2.setTime(ngayRa);

			if (ngayRaDuKien.equals(ngayRa)) {
				soNgay = 0;
			} else if (ngayRaDuKien.before(ngayRa)) // Hoặc else if
													// (date1.after(date2)==
													// false)
			{
				soNgay = (c2.getTime().getTime() - c1.getTime().getTime())
						/ (24 * 3600 * 1000);
			} else {
				soNgay = 0;
			}

			lbl_NgayVuot.setText(String.valueOf(soNgay));
		} catch (Exception e) {
		}

	}

	private void tinhTienTheoGio() {

		Date NgayGioRa = new Date();
		SimpleDateFormat D = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		long soGio = ((NgayGioRa.getTime() - GioThue.getTime()) / (3600 * 1000));

		ResultSet rs = dao.DAO_DatPhong.layTienGio(datPhong.getMaDatPhong()
				+ "");
		double TienGio = 0;
		double Tien = 0;
		try {
			if (rs.next()) {
				TienGio = rs.getDouble("GiaTheoGio");
			}
		} catch (SQLException ex) {
			Logger.getLogger(pnl_DSThuePhong.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		if (soGio == 0) {
			soGio = 1;
		}
		Tien = TienGio * soGio;

		// Xuat hóa đơn
		HD.setSoGioThue(soGio);
		System.out.println("Giờ thuê HD" + HD.getSoGioThue());

		txt_TienPhong.setText(ChuyenDoi.dinhDangSo(Tien));
	}

	public long tinhGioCheckIn() {// tính giờ checkIn sơm
		Date GioCheckIn = null;
		int MocCheckIn1 = 0, MocCheckIn2 = 0, phantram = 0, phantram2 = 0;
		double phuthu = 0, TienNgay = 0;

		ResultSet rs = dao.DAO_Khac.layBangKhac(3);
		ResultSet rs2 = dao.DAO_Khac.layBangKhac(4);
		ResultSet rs3 = dao.DAO_DatPhong.layTienGio(datPhong.getMaDatPhong()
				+ "");
		ResultSet rs4 = dao.DAO_Khac.layBangKhac(7);
		ResultSet rs5 = dao.DAO_Khac.layBangKhac(8);
		try {

			if (rs.next()) {
				GioCheckIn = rs.getTime("GiaTriTG");
				// System.out.println("gio check in la " + GioCheckIn);
				MocCheckIn1 = rs.getInt("GiaTriSo");
			}
			if (rs2.next()) {
				MocCheckIn2 = rs2.getInt("GiaTriSo");
			}
			if (rs3.next()) {
				TienNgay = rs3.getDouble("GiaTheoNgay");

			}
			if (rs4.next()) {
				phantram = rs4.getInt("GiaTriSo");
				// System.out.println(phantram+"%");
			}
			if (rs5.next()) {
				phantram2 = rs5.getInt("GiaTriSo");
				// System.out.println(phantram2+"%");
			}
		} catch (SQLException ex) {

		}
		long sosanh = (GioCheckIn.getHours() - GioThue.getHours());
		System.out.println("ss checkin" + sosanh);
		if (sosanh > MocCheckIn1) {
			// txt_CheckIn.setText("có phụ thu checkin sớm 4 tiếng");
			// phantram = Integer.parseInt(lbl_checkIn.getText());
			phuthu = TienNgay * phantram2 / 100;
			txt_CheckIn.setText(ChuyenDoi.dinhDangSo(phuthu));
		} else if (sosanh > MocCheckIn2 && sosanh <= MocCheckIn1) {
			// txt_CheckIn.setText("có phụ thu checkin sớm 2 tiếng");
			// phantram = Integer.parseInt(lbl_checkIn1.getText());
			phuthu = TienNgay * phantram / 100;
			txt_CheckIn.setText(ChuyenDoi.dinhDangSo(phuthu));
		} else {
			txt_CheckIn.setText("0");
		}
		return sosanh;
	}

	public void tinhGioCheckOut(boolean kt) {
		if (kt) {

			Date d = new Date();
			Time t = new Time(d.getTime());

			Time GioCheckOut = null;
			int Moc1 = 0, Moc2 = 0, phantram = 0, phantram2 = 0;
			double phuthu = 0, TienNgay = 0;
			ResultSet rs = dao.DAO_Khac.layBangKhac(5);
			ResultSet rs2 = dao.DAO_Khac.layBangKhac(6);
			ResultSet rs3 = dao.DAO_DatPhong.layTienGio(datPhong
					.getMaDatPhong() + "");
			ResultSet rs4 = dao.DAO_Khac.layBangKhac(7);
			ResultSet rs5 = dao.DAO_Khac.layBangKhac(8);
			try {
				if (rs.next()) {
					GioCheckOut = rs.getTime("GiaTriTG");
					Moc2 = rs.getInt("GiaTriSo");
				}
				if (rs2.next()) {
					Moc1 = rs2.getInt("GiaTriSo");
				}
				if (rs3.next()) {
					TienNgay = rs3.getDouble("GiaTheoNgay");

				}
				if (rs4.next()) {
					phantram = rs4.getInt("GiaTriSo");
					// System.out.println(phantram+"%");
				}
				if (rs5.next()) {
					phantram2 = rs5.getInt("GiaTriSo");
					// System.out.println(phantram2+"%");
				}
			} catch (SQLException ex) {
				Logger.getLogger(pnl_DSThuePhong.class.getName()).log(
						Level.SEVERE, null, ex);
			}

			Time t2 = new Time(GioCheckOut.getTime());
			long sosanh = (t.getHours() - t2.getHours());
			if (sosanh > Moc1) {
				// txt_checkout.setText("checkout muộn từ 2 -4 giờ");
				phuthu = TienNgay * phantram / 100;
				txt_checkout.setText(ChuyenDoi.dinhDangSo(phuthu));
			} else if (sosanh <= Moc1 && sosanh > Moc2) {
				// txt_checkout.setText("checkout muộn từ 0-2 giờ");
				phuthu = TienNgay * phantram2 / 100;
				txt_checkout.setText(ChuyenDoi.dinhDangSo(phuthu));
			} else {

			}
		} else {
			txt_checkout.setText("0");
		}

	}

	private void tinhTienTheoNgay() {
		try {

			Date NgayGioRa = new Date();
			SimpleDateFormat D = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(GioThue);
			// System.out.println("Ngày ở" + GioThue);
			c2.setTime(NgayGioRa);
			// System.out.println("Ngày ra" + NgayGioRa);
			long soNgay = ((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000));

			// System.out.println("Ngày ở là " + soNgay);
			ResultSet rs = dao.DAO_DatPhong.layTienGio(datPhong
					.getMaDatPhong() + "");
			double TienNgay = 0;
			double Tien = 0;
			if (rs.next()) {
				TienNgay = rs.getDouble("GiaTheoNgay");

			}
			if (soNgay == 0) {
				soNgay = 1;
			}
			Tien = TienNgay * soNgay;

			txt_TienPhong.setText(ChuyenDoi.dinhDangSo(Tien));
			// DTO hóa đơn
			HD.setSoNgayThue(soNgay);
			System.out.println("số ngày HD" + HD.getSoNgayThue());
			//
		} catch (Exception e) {
		}

	}

	private void lamMoi() {
		frm_QuanLyChinh frm = frm_QuanLyChinh.b;
		frm.tab.remove(form);
		pnl_DSThuePhong pnl = new pnl_DSThuePhong();
		frm.tab.add("Danh sách thuê phòng", pnl);
		frm.tab.setSelectedComponent(pnl);
	}

	private void soNguoi(int giatri) {
		songuoi = songuoi + (giatri);
		txt_SoNguoi.setText(String.valueOf(songuoi));
	}

	public static DatPhong datPhong;
	public static Phong phong;

	private void tbl_DSThuePhongMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_DSThuePhongMouseClicked
		if (tbl_DSThuePhong.getSelectedRowCount() == 1) {
			int vitri = tbl_DSThuePhong.getSelectedRow();
			datPhong = new DatPhong(Integer.parseInt(tbl_DSThuePhong
					.getValueAt(vitri, 0).toString()));
			phong = new Phong(tbl_DSThuePhong.getValueAt(vitri, 2).toString());
			dienDuLieuVaoField(datPhong.getMaDatPhong() + "");
			txt_NgayThue.setFocusable(false);
			txt_NgayRa.setFocusable(false);
			txt_NguoiTao.setFocusable(false);
			txt_Phong.setFocusable(false);
			txt_TenKH.setFocusable(false);
			txt_SoNguoi.setFocusable(false);
			btn_DichVu.setEnabled(true);
			btn_ThanhToan.setEnabled(true);
			btn_Sua.setEnabled(true);
			tienDV(datPhong.getMaDatPhong() + "");
			tongTien();

			// Xuất hóa đơn
			Date ngaythanhtoan = new Date();
			SimpleDateFormat D = new SimpleDateFormat("dd/MM/yyyy");
			HD.setTienPhong(ChuyenDoi.chuyenSangSo(txt_TienPhong.getText()));
			HD.setTienDV(ChuyenDoi.chuyenSangSo(txt_TienDV.getText()));
			HD.setThanhTien(ChuyenDoi.chuyenSangSo(txt_TongCong.getText()));
			HD.setDatPhong(new DatPhong(datPhong.getMaDatPhong()));
			HD.setPhong(new Phong(phong.getMaPhong()));
			HD.setUser(new User(bus.BUS_DangNhap.TenUser));
			KhachHang a = new KhachHang();
			a.setTenKH(txt_TenKH.getText());
			HD.setKh(a);
			HD.setPhuThuCheckin(ChuyenDoi.chuyenSangSo(txt_CheckIn.getText()));
			HD.setPhuThuCheckout(ChuyenDoi.chuyenSangSo(txt_checkout.getText()));
			HD.setNgayThanhToan(D.format(ngaythanhtoan));
		}

	}// GEN-LAST:event_tbl_DSThuePhongMouseClicked

	private void btn_TruActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_TruActionPerformed
		if (songuoi > 1) {
			soNguoi(-1);
		}
	}// GEN-LAST:event_btn_TruActionPerformed

	private void btn_CongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_CongActionPerformed
		soNguoi(1);
	}// GEN-LAST:event_btn_CongActionPerformed

	private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_SuaActionPerformed
		int songuoi = Integer.parseInt(txt_SoNguoi.getText());
		dao.DAO_DatPhong.sua(songuoi, datPhong.getMaDatPhong() + "");
		bus.BUS_DichVu.doDuLieuBangDatPhong(tbl_DSThuePhong);
	}// GEN-LAST:event_btn_SuaActionPerformed

	private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_ThanhToanActionPerformed

		dao.DAO_Phong.updateTinhTrang(phong.getMaPhong() + "");
		dao.DAO_DatPhong.traPhong(datPhong.getMaDatPhong() + "");
		themHD();
		lamMoi();
		// xuất hóa đơn

		xuatHoaDon(Integer.parseInt(datPhong.getMaDatPhong() + ""));

		// tải lại form thuê phòng nếu có
	}// GEN-LAST:event_btn_ThanhToanActionPerformed

	private void txt_GiamGiaKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_GiamGiaKeyReleased
		try {
			int sl = Integer.parseInt(txt_GiamGia.getText());
			tongTien();
		} catch (Exception e) {
			txt_GiamGia.setText("0");

		}
	}// GEN-LAST:event_txt_GiamGiaKeyReleased

	public void xuatHoaDon(int idhd) {
		try {

			Hashtable map = new Hashtable();
			JasperReport report = JasperCompileManager
					.compileReport("src/gui/rpt_demo2.jrxml");

			map.put("MaDP", idhd);

			JasperPrint p = JasperFillManager.fillReport(report, map,
					connectDB.connection.conn);
			JasperViewer.viewReport(p, false);
			JasperExportManager.exportReportToPdfFile(p, "test.pdf");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void themHD() {

		dao.DAO_HoaDon.themHD(HD);

	}

	private void tienDV(String MaDP) {
		double TienDV = 0;
		ResultSet rs = dao.DAO_CTDV.layCTDV((MaDP));
		try {
			while (rs.next()) {
				TienDV = TienDV + (rs.getDouble("ThanhTien"));
			}
		} catch (SQLException ex) {
			Logger.getLogger(pnl_DSThuePhong.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		txt_TienDV.setText(ChuyenDoi.dinhDangSo(TienDV));

	}

	private void tongTien() {
		double TienP = ChuyenDoi.chuyenSangSo(txt_TienPhong.getText());
		double TienDV = ChuyenDoi.chuyenSangSo(txt_TienDV.getText());
		double phuthucheckin = ChuyenDoi.chuyenSangSo(txt_CheckIn.getText());
		double phuthucheckout = ChuyenDoi.chuyenSangSo(txt_checkout.getText());
		double tiencoc = ChuyenDoi.chuyenSangSo(txt_TienCoc.getText());
		int GiamGia = Integer.parseInt(txt_GiamGia.getText());
		double tong = TienP + TienDV + phuthucheckin + phuthucheckout - tiencoc;
		tong = tong - (tong * GiamGia / 100);
		txt_TongCong.setText(ChuyenDoi.dinhDangSo(tong));
	}

	public void selectedDP(String MaP) {

		for (int i = 0; i < tbl_DSThuePhong.getRowCount(); i++) {
			if (tbl_DSThuePhong.getValueAt(i, 2).equals(MaP)) {
				phong.setMaPhong(MaP);
				// System.out.println(MaP);
				tbl_DSThuePhong.setRowSelectionInterval(i, i);
				datPhong.setMaDatPhong(Integer.parseInt(tbl_DSThuePhong
						.getValueAt(i, 0).toString()));
				dienDuLieuVaoField(datPhong.getMaDatPhong() + "");
				txt_NgayThue.setFocusable(false);
				txt_NgayRa.setFocusable(false);
				txt_NguoiTao.setFocusable(false);
				txt_Phong.setFocusable(false);
				txt_TenKH.setFocusable(false);
				txt_SoNguoi.setFocusable(false);
				btn_DichVu.setEnabled(true);

				tienDV(datPhong.getMaDatPhong() + "");
				tongTien();
			}
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btn_Cong;
	private javax.swing.JButton btn_DichVu;
	private javax.swing.JButton btn_Sua;
	private javax.swing.JButton btn_ThanhToan;
	private javax.swing.JButton btn_Tru;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JLabel lbl_ChiTiet;
	private javax.swing.JLabel lbl_DSThuePhong;
	private javax.swing.JLabel lbl_Dau;
	private javax.swing.JLabel lbl_Dau2;
	private javax.swing.JLabel lbl_Dau3;
	private javax.swing.JLabel lbl_Dau4;
	private javax.swing.JLabel lbl_KM;
	private javax.swing.JLabel lbl_MaDP;
	private javax.swing.JLabel lbl_MaDatPhong;
	private javax.swing.JLabel lbl_Ngay;
	private javax.swing.JLabel lbl_NgayRaDuKien;
	private javax.swing.JLabel lbl_NgayThue;
	private javax.swing.JLabel lbl_NgayVuot;
	private javax.swing.JLabel lbl_NguoiTao;
	private javax.swing.JLabel lbl_PhanTram;
	private javax.swing.JLabel lbl_Phong;
	private javax.swing.JLabel lbl_PhuThuCheckIn;
	private javax.swing.JLabel lbl_PhuThuCheckOut;
	private javax.swing.JLabel lbl_SoNguoi;
	private javax.swing.JLabel lbl_TenKhachHang;
	private javax.swing.JTextField txt_TienCoc;
	private javax.swing.JLabel lbl_TienCoc;
	private javax.swing.JTextField txt_TienDV;
	private javax.swing.JLabel lbl_TienDV;
	private javax.swing.JTextField txt_TienPhong;
	private javax.swing.JLabel lbl_TienPhong;
	private javax.swing.JTextField txt_TongCong;
	private javax.swing.JLabel lbl_TongCong;
	private javax.swing.JLabel lbl_Vuot;
	private javax.swing.JLabel lbl_vnd;
	private javax.swing.JLabel lbl_vnd2;
	private javax.swing.JLabel lbl_vnd3;
	private javax.swing.JLabel lbl_vnd4;
	private javax.swing.JLabel lbl_vnd5;
	private javax.swing.JLabel lbl_vnd6;
	private javax.swing.JPanel pnl_GD;
	private javax.swing.JPanel pnl_DSTP;
	private javax.swing.JPanel pnl_CTTP;
	public javax.swing.JTable tbl_DSThuePhong;
	private javax.swing.JTextField txt_CheckIn;
	private javax.swing.JTextField txt_GiamGia;
	private javax.swing.JTextField txt_NgayRa;
	private javax.swing.JTextField txt_NgayThue;
	private javax.swing.JTextField txt_NguoiTao;
	private javax.swing.JTextField txt_Phong;
	private javax.swing.JTextField txt_SoNguoi;
	private javax.swing.JTextField txt_TenKH;
	private javax.swing.JTextField txt_checkout;
	// End of variables declaration//GEN-END:variables
}
