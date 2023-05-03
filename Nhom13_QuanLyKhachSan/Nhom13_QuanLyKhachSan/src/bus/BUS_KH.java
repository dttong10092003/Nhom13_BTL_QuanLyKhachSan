/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import gui.thongbao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BUS_KH {

	public static boolean kt_Them(entity.KhachHang KH) {
		ResultSet rs = dao.DAO_KhachHang.layKH();
		try {
			while (rs.next()) {
				if (rs.getString("MaKhachHang").matches(KH.getMaKH())) {
					thongbao.thongbao("Mã khách hàng đã dùng", "");
					return false;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(BUS_KH.class.getName())
					.log(Level.SEVERE, null, ex);
		}

		if (KH.getMaKH().trim().equals("") || KH.getTenKH().trim().equals("")
				|| KH.getCCCD().trim().equals("") || KH.getSDT().trim().equals("")) {
			thongbao.thongbao("Không để trống thông tin", "thông báo");
			return false;
		}
		
		if (!(KH.getSDT().matches("0(3|5|7|8|9)[0-9]{8}"))) {
			thongbao.thongbao("Nhập lại số điện thoại", "");
			return false;
		}
		
		/*
		 * Kiểm tra CCCD
		 * Gồm 12 số
		 * 3 số đầu thể hiện mã tỉnh
		 * số tiếp theo là giới tính (Thế kỉ 20 Nam: 0, Nữ: 1, Thế kỉ 21 Nam: 2, Nữ: 3)
		 * 2 số tiếp theo là 2 số cuối năm sinh
		 * 6 số cuối là dãy số ngẫu nhiên
		 */

		if (!(KH.getCCCD()
				.matches("0((?!0[3579]|1[368]|2[18]|3[29]|4[13]|5[037]|6[1359]|7[18]|8[15]|9[05])[0-9]{2})(0|1|2|3)[0-9]{8}"))) {
			thongbao.thongbao("Nhập lại số CCCD", "");
			return false;
		} else {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			System.out.println("Năm hiện tại: " + year);
			int namSinh = year - KH.getTuoi();
			if (namSinh >= 2000) {
				if (!(KH.getCCCD().substring(4, 6).equals((namSinh + "")
						.substring(2, 4)))) {
					thongbao.thongbao("Sai hai số thứ 4 và 6 là năm sinh", "");
					return false;
				} else {
					if (KH.isGioiTinh()) {
						if (!(KH.getCCCD().substring(3, 4).equals("2"))) {
							thongbao.thongbao("Sai số thứ 4 là giới tính", "");
							return false;
						}
					}else {
						if (!(KH.getCCCD().substring(3, 4).equals("3"))) {
							thongbao.thongbao("Sai số thứ 4 là giới tính", "");
							return false;
						}
					}
				}
			} else {
				if (!(KH.getCCCD().substring(4, 6).equals((namSinh + "")
						.substring(2, 4)))) {
					thongbao.thongbao("Sai hai số thứ 5 và 6 là năm sinh", "");
					return false;
				} else {
					if (KH.isGioiTinh()) {
						if (!(KH.getCCCD().substring(3, 4).equals("0"))) {
							thongbao.thongbao("Sai số thứ 4 là giới tính", "");
							return false;
						}
					}else {
						if (!(KH.getCCCD().substring(3, 4).equals("1"))) {
							thongbao.thongbao("Sai số thứ 4 là giới tính", "");
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	public static void dodulieu(JTable tbl) {
		DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
		tblModel.setRowCount(0);
		Object obj[] = new Object[2];
		ResultSet rs = dao.DAO_KhachHang.layKH();
		try {
			while (rs.next()) {
				obj[0] = rs.getString("MaKhachHang");
				obj[1] = rs.getString("TenKhachHang");
				tblModel.addRow(obj);
			}
		} catch (SQLException ex) {
			System.out.println("Lỗi đổ table");
		}
	}

	public static void timKiem(JTable tbl, String tukhoa) {
		DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
		tblModel.setRowCount(0);
		Object obj[] = new Object[2];
		ResultSet rs = dao.DAO_KhachHang.timKiem(tukhoa);
		try {
			while (rs.next()) {
				obj[0] = rs.getString("MaKhachHang");
				obj[1] = rs.getString("TenKhachHang");
				tblModel.addRow(obj);
			}
		} catch (SQLException ex) {
			System.out.println("Lỗi đổ table");
		}
	}

	public static boolean kt_Xoa(String MaKH) {
		//Lấy khách hàng đã thuê phòng
		ResultSet rs = dao.DAO_DatPhong.layTatCa();
		try {
			while (rs.next()) {
				if (rs.getString("MaKhachHang").matches(MaKH)) { 
					thongbao.thongbao("Khách hàng đã hoặc đang thuê phòng", "");
					return false;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(BUS_KH.class.getName())
					.log(Level.SEVERE, null, ex);
		}
		return true;
	}

	public static boolean kt_Sua(entity.KhachHang KH) {
		if (KH.getMaKH().trim().equals("") || KH.getTenKH().trim().equals("")
				|| KH.getCCCD().trim().equals("")) {
			thongbao.thongbao("Không để trống thông tin", "thông báo");
			return false;
		}
		
		if (!(KH.getSDT().matches("0(3|5|7|8|9)[0-9]{8}"))) {
			thongbao.thongbao("Nhập lại số điện thoại", "");
			return false;
		}
		/*
		 * Kiểm tra CCCD
		 * Gồm 12 số
		 * 3 số đầu thể hiện mã tỉnh
		 * số tiếp theo là giới tính (Thế kỉ 20 Nam: 0, Nữ: 1, Thế kỉ 21 Nam: 2, Nữ: 3)
		 * 2 số tiếp theo là 2 số cuối năm sinh
		 * 6 số cuối là dãy số ngẫu nhiên
		 */
		if (!(KH.getCCCD()
				.matches("0((?!0[3579]|1[368]|2[18]|3[29]|4[13]|5[037]|6[1359]|7[18]|8[15]|9[05])[0-9]{2})(0|1|2|3)[0-9]{8}"))) {
			thongbao.thongbao("Nhập lại số CCCD", "");
			return false;
		} else {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			System.out.println("Năm hiện tại: " + year);
			int namSinh = year - KH.getTuoi();
			if (namSinh >= 2000) {
				if (!(KH.getCCCD().substring(4, 6).equals((namSinh + "")
						.substring(2, 4)))) {
					thongbao.thongbao("Sai hai số thứ 4 và 6 là năm sinh", "");
					return false;
				} else {
					if (KH.isGioiTinh()) {
						if (!(KH.getCCCD().substring(3, 4).equals("2"))) {
							thongbao.thongbao("Sai số thứ 4 là giới tính", "");
							return false;
						}
					}else {
						if (!(KH.getCCCD().substring(3, 4).equals("3"))) {
							thongbao.thongbao("Sai số thứ 4 là giới tính", "");
							return false;
						}
					}
				}
			} else {
				if (!(KH.getCCCD().substring(4, 6).equals((namSinh + "")
						.substring(2, 4)))) {
					thongbao.thongbao("Sai hai số thứ 5 và 6 là năm sinh", "");
					return false;
				} else {
					if (KH.isGioiTinh()) {
						if (!(KH.getCCCD().substring(3, 4).equals("0"))) {
							thongbao.thongbao("Sai số thứ 4 là giới tính", "");
							return false;
						}
					}else {
						if (!(KH.getCCCD().substring(3, 4).equals("1"))) {
							thongbao.thongbao("Sai số thứ 4 là giới tính", "");
							return false;
						}
					}
				}
			}
		}
		
		
		return true;
	}

}
