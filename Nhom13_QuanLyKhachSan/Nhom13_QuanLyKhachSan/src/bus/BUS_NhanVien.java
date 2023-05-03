/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import gui.ChuyenDoi;
import gui.mycombobox;
import gui.thongbao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.connection;

/**
 *
 * @author ADMIN
 */
public class BUS_NhanVien {

	public static void loadData_Luong(JComboBox cbb) {
		DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
		cbbModel.removeAllElements();
		ResultSet rs = dao.DAO_Luong.layLuong();
		try {
			while (rs.next()) {
				Object MaLuong = rs.getString("MaLuong");
				Object LuongTheoGio = ChuyenDoi.dinhDangSo(rs
						.getDouble("LuongTheoGio"));
				mycombobox mb = new mycombobox(MaLuong, LuongTheoGio);
				cbbModel.addElement(mb);
			}
		} catch (SQLException ex) {
			System.out.println("lỗi đổ cbb_LoaiKhachHang");
		}
	}

	public static void doDuLieuBang(JTable tbl) {
		DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
		tblModel.setRowCount(0);
		Object obj[] = new Object[7];
		ResultSet rs = dao.DAO_NhanVien.layNV();
		try {
			while (rs.next()) {
				obj[0] = rs.getString("MaNhanVien");
				obj[1] = rs.getString("TenNhanVien");
				boolean gt = rs.getBoolean("GioiTinh");
				if (gt) {
					obj[2] = "Nam";
				} else {
					obj[2] = "Nữ";
				}
				obj[3] = rs.getDate("NgaySinh");
				obj[4] = rs.getString("SoDienThoai");
				obj[5] = rs.getString("DiaChi");
				tblModel.addRow(obj);
			}
		} catch (SQLException ex) {
			System.out.println("lỗi đổ table");

		}
	}

	public static void doDuLieuTimKiem(JTable tbl, String TuKhoa) {
		DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
		tblModel.setRowCount(0);
		Object obj[] = new Object[7];
		ResultSet rs = dao.DAO_NhanVien.timKiem(TuKhoa);
		try {
			while (rs.next()) {
				obj[0] = rs.getString("MaNhanVien");
				obj[1] = rs.getString("TenNhanVien");
				boolean gt = rs.getBoolean("GioiTinh");
				if (gt) {
					obj[2] = "Nam";
				} else {
					obj[2] = "Nữ";
				}
				obj[3] = rs.getDate("NgaySinh");
				obj[4] = rs.getString("SoDienThoai");
				obj[5] = rs.getString("DiaChi");
				tblModel.addRow(obj);
			}
		} catch (SQLException ex) {
			System.out.println("Lỗi đổ table");

		}
	}

	public static boolean kt_Them(entity.NhanVien nv) {
		ResultSet rs = dao.DAO_NhanVien.layNV();
		try {
			while (rs.next()) {
				if (nv.getMaNV().equals(rs.getString("MaNhanVien"))) {
					thongbao.thongbao("Mã nhân viên đã dùng", "");
					return false;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(BUS_NhanVien.class.getName()).log(Level.SEVERE,
					null, ex);

		}

		if (nv.getNgaySinh() == null || nv.getNgayLam() == null) {
			thongbao.thongbao("Chưa nhập ngày", "");
			return false;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ngaySinh = LocalDate.parse(nv.getNgaySinh(), formatter);
		LocalDate ngayLam = LocalDate.parse(nv.getNgayLam(), formatter);
		int trenLech = ngayLam.getYear() - ngaySinh.getYear();

		if (ngayLam.isBefore(ngaySinh) || trenLech < 18) {
			thongbao.thongbao("Nhân viên phải đủ 18 tuổi", "");
			return false;
		}

		if (nv.getMaNV().trim().equals("") || nv.getTenNV().trim().equals("")
				|| nv.getSdt().trim().equals("")
				|| nv.getDiaChi().trim().equals("")) {
			thongbao.thongbao("Không bỏ trống thông tin", "");
			return false;
		}
		if (!(nv.getSdt().matches("0(3|5|7|8|9)[0-9]{8}"))) {
			thongbao.thongbao("Nhập lại số điện thoại", "");
			return false;
		}

		return true;
	}

	public static boolean kt_Sua(entity.NhanVien nv) {
		if (nv.getNgaySinh() == null || nv.getNgayLam() == null) {
			thongbao.thongbao("Chưa nhập ngày", "");
			return false;
		}
		
		if (nv.getMaNV().trim().equals("") || nv.getTenNV().trim().equals("")
				|| nv.getSdt().trim().equals("")
				|| nv.getDiaChi().trim().equals("")) {
			thongbao.thongbao("Không bỏ trống thông tin", "");
			return false;
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ngaySinh = LocalDate.parse(nv.getNgaySinh(), formatter);
		LocalDate ngayLam = LocalDate.parse(nv.getNgayLam(), formatter);
		int trenLech = ngayLam.getYear() - ngaySinh.getYear();

		if (ngayLam.isBefore(ngaySinh) || trenLech < 18) {
			thongbao.thongbao("Nhân viên phải đủ 18 tuổi", "");
			return false;
		}

		if (!(nv.getSdt().matches("0(3|5|7|8|9)[0-9]{8}"))) {
			thongbao.thongbao("Nhập lại số điện thoại", "");
			return false;
		}

		return true;
	}

	public static boolean xemTK(String MaNV) {
		ResultSet rs = dao.DAO_User.layTKTheoMaNV(MaNV);
		try {
			if (rs.next()) {
				if (rs.getString("MaNhanVien").equals(MaNV)) {
					return true;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(BUS_NhanVien.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	public static boolean kt_Xoa(String manhanvien) {
		ResultSet rs = dao.DAO_User.layTatCa();
		ResultSet rs1 = dao.DAO_ChiTietLuong.lay();

		try {
			while (rs.next()) {
				if (rs.getString("MaNhanVien").equals(manhanvien)) {
					thongbao.thongbao("Nhân viên đang có tài khoản", "");
					return false;
				}
			}
			// Nếu không có hàm này thị sẽ bị lỗi khóa chính khóa ngoại bên sql
			while (rs1.next()) {
				if (rs1.getString("MaNhanVien").equals(manhanvien)) {
					dao.DAO_ChiTietLuong.xoaTheoMaNV(manhanvien);
				}
			}
		} catch (SQLException ex) {

		}
		return true;
	}

}
