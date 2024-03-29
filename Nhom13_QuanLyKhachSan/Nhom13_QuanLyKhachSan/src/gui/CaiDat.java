package gui;

import entity.Khac;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CaiDat extends javax.swing.JFrame {

	int x, y;

	/**
	 * Creates new form CaiDat
	 */
	public CaiDat() {
		initComponents();
		dienDuLieu();
	}

	public void dienDuLieu() {
		SimpleDateFormat D = new SimpleDateFormat("HH:mm:ss");
		Date t = null;
		Date t2 = null;
		int moc1 = 0, moc2 = 0, phuThu1 = 0, phuThu2 = 0, moc3 = 0, moc4 = 0, phuThu3 = 0, phuThu4 = 0;

		ResultSet rs = dao.DAO_Khac.layBangKhac(3);
		ResultSet rs2 = dao.DAO_Khac.layBangKhac(4);
		ResultSet rs3 = dao.DAO_Khac.layBangKhac(7);
		ResultSet rs4 = dao.DAO_Khac.layBangKhac(8);
		ResultSet rs5 = dao.DAO_Khac.layBangKhac(5);
		ResultSet rs6 = dao.DAO_Khac.layBangKhac(6);
		ResultSet rs7 = dao.DAO_Khac.layBangKhac(9);
		ResultSet rs8 = dao.DAO_Khac.layBangKhac(10);
		try {
			if (rs.next()) {
				t = rs.getTime("GiaTriTG");
				moc1 = rs.getInt("GiaTriSo");
			}
			if (rs2.next()) {
				moc2 = rs2.getInt("GiaTriSo");
			}
			if (rs3.next()) {
				phuThu1 = rs3.getInt("GiaTriSo");

			}
			if (rs4.next()) {
				phuThu2 = rs4.getInt("GiaTriSo");
			}
			if (rs5.next()) {
				t2 = rs5.getTime("GiaTriTG");
				moc3 = rs5.getInt("GiaTriSo");
			}
			if (rs6.next()) {
				moc4 = rs6.getInt("GiaTriSo");
			}
			if (rs7.next()) {// phu thu checkout1
				phuThu3 = rs7.getInt("GiaTriSo");
			}
			if (rs8.next()) {// phu thu checkout2
				phuThu4 = rs8.getInt("GiaTriSo");
			}

		} catch (SQLException ex) {
			Logger.getLogger(CaiDat.class.getName())
					.log(Level.SEVERE, null, ex);
		}
		txt_CheckIn.setText(D.format(t));
		txt_CheckInSom.setText(String.valueOf(moc1));
		txt_PhuThu.setText(String.valueOf(phuThu2));
		txt_CheckInSom3.setText(String.valueOf(moc2));
		txt_PhuThu2.setText(String.valueOf(phuThu1));
		txt_TimeCheckOut.setText(D.format(t2));
		txt_CheckOut.setText(String.valueOf(moc4));
		txt_PhuThu3.setText(String.valueOf(phuThu4));
		txt_CheckOut2.setText(String.valueOf(moc3));
		txt_PhuPhu4.setText(String.valueOf(phuThu3));

	}

	private void initComponents() {

		pnl_Nen = new javax.swing.JPanel();
		jSeparator1 = new javax.swing.JSeparator();
		pnl_Nen2 = new javax.swing.JPanel();
		lbl_TimeCheckout = new javax.swing.JLabel();
		lbl_PhanTram5 = new javax.swing.JLabel();
		lbl_PhuThuCheckOut2 = new javax.swing.JLabel();
		txt_PhuPhu4 = new javax.swing.JTextField();
		lbl_PhanTram4 = new javax.swing.JLabel();
		lbl_TimeCheckIn = new javax.swing.JLabel();
		txt_TimeCheckOut = new javax.swing.JTextField();
		lbl_PhuThuCheckIn = new javax.swing.JLabel();
		lbl_PhuThuCheckOut = new javax.swing.JLabel();
		txt_PhuThu3 = new javax.swing.JTextField();
		lbl_PhanTram3 = new javax.swing.JLabel();
		lbl_PhanTram2 = new javax.swing.JLabel();
		txt_CheckOut2 = new javax.swing.JTextField();
		txt_CheckOut = new javax.swing.JTextField();
		lbl_Tieng = new javax.swing.JLabel();
		lbl_Tieng2 = new javax.swing.JLabel();
		lbl_PhuThuCheckIn2 = new javax.swing.JLabel();
		txt_CheckIn = new javax.swing.JTextField();
		txt_CheckInSom = new javax.swing.JTextField();
		txt_PhuThu = new javax.swing.JTextField();
		txt_CheckInSom3 = new javax.swing.JTextField();
		txt_PhuThu2 = new javax.swing.JTextField();
		lbl_Tieng3 = new javax.swing.JLabel();
		lbl_Tieng4 = new javax.swing.JLabel();
		lbl_Luu = new javax.swing.JLabel();
		lbl_CaiDat = new javax.swing.JLabel();
		lbl_Exit = new javax.swing.JLabel();
		lbl_Nen = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(412, 620));
		setUndecorated(true);

		pnl_Nen.setBackground(new java.awt.Color(255, 255, 255));
		pnl_Nen.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		pnl_Nen.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				pnl_NenMouseMoved(evt);
			}
		});

		pnl_Nen2.setBackground(new java.awt.Color(255, 255, 255));
		pnl_Nen2.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		pnl_Nen2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				pnl_Nen2MouseMoved(evt);
			}
		});
		pnl_Nen2.setLayout(null);

		lbl_TimeCheckout.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lbl_TimeCheckout.setText("Thời gian checkout");
		pnl_Nen2.add(lbl_TimeCheckout);
		lbl_TimeCheckout.setBounds(40, 370, 111, 30);

		lbl_PhanTram5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_PhanTram5.setText("% giá phòng");
		lbl_PhanTram5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		pnl_Nen2.add(lbl_PhanTram5);
		lbl_PhanTram5.setBounds(270, 300, 79, 20);

		lbl_PhuThuCheckOut2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lbl_PhuThuCheckOut2.setText("Phụ thu checkout muộn 2");
		lbl_PhuThuCheckOut2
				.setToolTipText("phụ thu khi checkin sớm trước giờ checkin mốc 1 ");
		pnl_Nen2.add(lbl_PhuThuCheckOut2);
		lbl_PhuThuCheckOut2.setBounds(40, 510, 149, 30);

		txt_PhuPhu4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_PhuPhu4ActionPerformed(evt);
			}
		});
		pnl_Nen2.add(txt_PhuPhu4);
		txt_PhuPhu4.setBounds(220, 550, 40, 30);

		lbl_PhanTram4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_PhanTram4.setText("% giá phòng");
		lbl_PhanTram4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		pnl_Nen2.add(lbl_PhanTram4);
		lbl_PhanTram4.setBounds(270, 560, 79, 20);

		lbl_TimeCheckIn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lbl_TimeCheckIn.setText("Thời gian check in");
		pnl_Nen2.add(lbl_TimeCheckIn);
		lbl_TimeCheckIn.setBounds(40, 115, 107, 30);
		pnl_Nen2.add(txt_TimeCheckOut);
		txt_TimeCheckOut.setBounds(220, 360, 130, 30);

		lbl_PhuThuCheckIn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lbl_PhuThuCheckIn.setText("Phụ thu check in sớm");
		lbl_PhuThuCheckIn
				.setToolTipText("phụ thu khi checkin sớm trước giờ checkin mốc 1 ");
		pnl_Nen2.add(lbl_PhuThuCheckIn);
		lbl_PhuThuCheckIn.setBounds(40, 160, 129, 30);

		lbl_PhuThuCheckOut.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lbl_PhuThuCheckOut.setText("Phụ thu checkout muộn");
		lbl_PhuThuCheckOut
				.setToolTipText("phụ thu khi checkin sớm trước giờ checkin mốc 1 ");
		pnl_Nen2.add(lbl_PhuThuCheckOut);
		lbl_PhuThuCheckOut.setBounds(40, 420, 138, 30);

		txt_PhuThu3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_PhuThu3ActionPerformed(evt);
			}
		});
		pnl_Nen2.add(txt_PhuThu3);
		txt_PhuThu3.setBounds(220, 450, 40, 30);

		lbl_PhanTram3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_PhanTram3.setText("% giá phòng");
		lbl_PhanTram3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		pnl_Nen2.add(lbl_PhanTram3);
		lbl_PhanTram3.setBounds(270, 200, 79, 20);

		lbl_PhanTram2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_PhanTram2.setText("% giá phòng");
		lbl_PhanTram2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		pnl_Nen2.add(lbl_PhanTram2);
		lbl_PhanTram2.setBounds(270, 460, 79, 20);

		txt_CheckOut2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_CheckOut2ActionPerformed(evt);
			}
		});
		pnl_Nen2.add(txt_CheckOut2);
		txt_CheckOut2.setBounds(220, 510, 80, 30);

		txt_CheckOut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_CheckOutActionPerformed(evt);
			}
		});
		pnl_Nen2.add(txt_CheckOut);
		txt_CheckOut.setBounds(220, 410, 80, 30);

		lbl_Tieng.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_Tieng.setText("(tiếng)");
		pnl_Nen2.add(lbl_Tieng);
		lbl_Tieng.setBounds(310, 260, 40, 17);

		lbl_Tieng2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_Tieng2.setText("(tiếng)");
		pnl_Nen2.add(lbl_Tieng2);
		lbl_Tieng2.setBounds(310, 520, 40, 17);

		lbl_PhuThuCheckIn2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lbl_PhuThuCheckIn2.setText("Phụ thu check in sớm 2");
		lbl_PhuThuCheckIn2
				.setToolTipText("Phụ thu khi checkin sớm trước giờ checkin mốc 1 ");
		pnl_Nen2.add(lbl_PhuThuCheckIn2);
		lbl_PhuThuCheckIn2.setBounds(40, 250, 140, 30);

		txt_CheckIn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_CheckInActionPerformed(evt);
			}
		});
		pnl_Nen2.add(txt_CheckIn);
		txt_CheckIn.setBounds(220, 110, 130, 30);

		txt_CheckInSom.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_CheckInSomActionPerformed(evt);
			}
		});
		pnl_Nen2.add(txt_CheckInSom);
		txt_CheckInSom.setBounds(220, 150, 80, 30);
		pnl_Nen2.add(txt_PhuThu);
		txt_PhuThu.setBounds(220, 190, 40, 30);

		txt_CheckInSom3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_CheckInSom3ActionPerformed(evt);
			}
		});
		pnl_Nen2.add(txt_CheckInSom3);
		txt_CheckInSom3.setBounds(220, 250, 80, 30);

		txt_PhuThu2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_PhuThu2ActionPerformed(evt);
			}
		});
		pnl_Nen2.add(txt_PhuThu2);
		txt_PhuThu2.setBounds(220, 290, 40, 30);

		lbl_Tieng3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_Tieng3.setText("(tiếng)");
		pnl_Nen2.add(lbl_Tieng3);
		lbl_Tieng3.setBounds(310, 160, 40, 17);

		lbl_Tieng4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lbl_Tieng4.setText("(tiếng)");
		pnl_Nen2.add(lbl_Tieng4);
		lbl_Tieng4.setBounds(310, 420, 40, 17);

		lbl_Luu.setBackground(new java.awt.Color(255, 255, 255));
		lbl_Luu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		lbl_Luu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbl_Luu.setText("Lưu");
		lbl_Luu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lbl_Luu.setOpaque(true);
		lbl_Luu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				lbl_LuuMouseMoved(evt);
			}
		});
		lbl_Luu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lbl_LuuMouseClicked(evt);
			}
		});
		pnl_Nen2.add(lbl_Luu);
		lbl_Luu.setBounds(90, 580, 80, 30);

		lbl_CaiDat.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
		lbl_CaiDat.setText("Cài đặt");
		pnl_Nen2.add(lbl_CaiDat);
		lbl_CaiDat.setBounds(150, 10, 113, 40);

		lbl_Exit.setBackground(new java.awt.Color(255, 255, 255));
		lbl_Exit.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
		lbl_Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbl_Exit.setText("X");
		lbl_Exit.setOpaque(true);
		lbl_Exit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				lbl_ExitMouseMoved(evt);
			}
		});
		lbl_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lbl_ExitMouseClicked(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lbl_ExitMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lbl_ExitMouseReleased(evt);
			}
		});
		pnl_Nen2.add(lbl_Exit);
		lbl_Exit.setBounds(350, 10, 50, 27);

		lbl_Nen.setIcon(new javax.swing.ImageIcon("HinhAnh/1.jpg")); // NOI18N
		pnl_Nen2.add(lbl_Nen);
		lbl_Nen.setBounds(0, 0, 420, 630);

		javax.swing.GroupLayout pnl_NenLayout = new javax.swing.GroupLayout(
				pnl_Nen);
		pnl_Nen.setLayout(pnl_NenLayout);
		pnl_NenLayout
				.setHorizontalGroup(pnl_NenLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnl_NenLayout
										.createSequentialGroup()
										.addGap(40, 40, 40)
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												330,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(pnl_Nen2,
								javax.swing.GroupLayout.PREFERRED_SIZE, 410,
								javax.swing.GroupLayout.PREFERRED_SIZE));
		pnl_NenLayout
				.setVerticalGroup(pnl_NenLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnl_NenLayout
										.createSequentialGroup()
										.addGap(330, 330, 330)
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												10,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(pnl_Nen2,
								javax.swing.GroupLayout.PREFERRED_SIZE, 620,
								javax.swing.GroupLayout.PREFERRED_SIZE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pnl_Nen, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pnl_Nen, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>

	private void pnl_NenMouseMoved(java.awt.event.MouseEvent evt) {
		lbl_Exit.setBackground(Color.white);
		lbl_Luu.setBackground(Color.white);
	}

	private void pnl_Nen2MouseMoved(java.awt.event.MouseEvent evt) {
		lbl_Exit.setBackground(Color.white);
		lbl_Luu.setBackground(Color.white);
	}

	private void lbl_ExitMouseReleased(java.awt.event.MouseEvent evt) {

	}

	private void lbl_ExitMousePressed(java.awt.event.MouseEvent evt) {

	}

	private void lbl_ExitMouseClicked(java.awt.event.MouseEvent evt) {
		this.dispose();
	}

	private void lbl_ExitMouseMoved(java.awt.event.MouseEvent evt) {
		lbl_Exit.setBackground(Color.red); // TODO add your handling code here:
	}

	private void lbl_LuuMouseClicked(java.awt.event.MouseEvent evt) {
		entity.Khac a = new Khac();
		try {

			a.setCheckIn(Time.valueOf(txt_CheckIn.getText()));
			System.out.println("thời gian checkin là :" + a.getCheckIn());
			txt_CheckInSom.getText();
			a.setMoc1(Integer.parseInt(txt_CheckInSom.getText()));
			System.out.println("mốc 1  là: " + a.getMoc1());
			txt_PhuThu.getText();
			a.setPhuThu1(Integer.parseInt(txt_PhuThu.getText()));
			System.out.println(" phụ thu 1 " + a.getPhuThu1());
			txt_CheckInSom3.getText();
			a.setMoc2(Integer.parseInt(txt_CheckInSom3.getText()));
			System.out.println(" mốc 2 là " + a.getMoc2());
			txt_PhuThu2.getText();
			a.setPhuThu2(Integer.parseInt(txt_PhuThu2.getText()));
			System.out.println(" phụ thu 2 là" + a.getPhuThu2());
			txt_TimeCheckOut.getText();
			a.setCheckOut(Time.valueOf(txt_TimeCheckOut.getText()));
			System.out.println(a.getCheckOut());
			txt_CheckOut.getText();
			a.setMoc3(Integer.parseInt(txt_CheckOut.getText()));
			System.out.println(a.getMoc3());
			txt_PhuThu3.getText();
			a.setPhuThu3(Integer.parseInt(txt_PhuThu3.getText()));
			System.out.println(a.getPhuThu3());
			txt_CheckOut2.getText();
			a.setMoc4(Integer.parseInt(txt_CheckOut2.getText()));
			System.out.println(a.getMoc4());
			txt_PhuPhu4.getText();
			a.setPhuThu4(Integer.parseInt(txt_PhuPhu4.getText()));
			System.out.println(a.getPhuThu4());
		} catch (Exception e) {
			thongbao.thongbao("Giá trị sai", "");
		}

		if (bus.BUS_Khac.kt_Sua(a)) {
			dao.DAO_Khac.update(a);
			this.dispose();
		} else {
		}

	}

	private void lbl_LuuMouseMoved(java.awt.event.MouseEvent evt) {
		lbl_Luu.setBackground(Color.decode("#819FF7"));
	}

	private void txt_PhuThu2ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void txt_CheckInSom3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txt_CheckInSomActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txt_CheckInActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txt_CheckOutActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txt_CheckOut2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txt_PhuThu3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void txt_PhuPhu4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(CaiDat.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CaiDat.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CaiDat.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CaiDat.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CaiDat().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JLabel lbl_CaiDat;
	private javax.swing.JLabel lbl_Exit;
	private javax.swing.JLabel lbl_Luu;
	private javax.swing.JLabel lbl_Nen;
	private javax.swing.JLabel lbl_PhanTram2;
	private javax.swing.JLabel lbl_PhanTram3;
	private javax.swing.JLabel lbl_PhanTram4;
	private javax.swing.JLabel lbl_PhanTram5;
	private javax.swing.JLabel lbl_PhuThuCheckIn;
	private javax.swing.JLabel lbl_PhuThuCheckIn2;
	private javax.swing.JLabel lbl_PhuThuCheckOut;
	private javax.swing.JLabel lbl_PhuThuCheckOut2;
	private javax.swing.JLabel lbl_Tieng;
	private javax.swing.JLabel lbl_Tieng2;
	private javax.swing.JLabel lbl_Tieng3;
	private javax.swing.JLabel lbl_Tieng4;
	private javax.swing.JLabel lbl_TimeCheckIn;
	private javax.swing.JLabel lbl_TimeCheckout;
	private javax.swing.JPanel pnl_Nen;
	private javax.swing.JPanel pnl_Nen2;
	private javax.swing.JTextField txt_CheckIn;
	private javax.swing.JTextField txt_CheckInSom;
	private javax.swing.JTextField txt_CheckInSom3;
	private javax.swing.JTextField txt_CheckOut;
	private javax.swing.JTextField txt_CheckOut2;
	private javax.swing.JTextField txt_PhuPhu4;
	private javax.swing.JTextField txt_PhuThu;
	private javax.swing.JTextField txt_PhuThu2;
	private javax.swing.JTextField txt_PhuThu3;
	private javax.swing.JTextField txt_TimeCheckOut;
	// End of variables declaration
}
