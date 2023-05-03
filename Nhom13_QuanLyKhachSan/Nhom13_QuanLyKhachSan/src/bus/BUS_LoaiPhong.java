/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import gui.ChuyenDoi;
import gui.thongbao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

/**
 *
 * @author ADMIN
 */
public class BUS_LoaiPhong {

	public static void doDuLieuBang(JTable tbl) {
		DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
		tblModel.setRowCount(0);
		Object obj[] = new Object[4];
		ResultSet rs = dao.DAO_LoaiPhong.layTatCa();
		try {
			while (rs.next()) {
				obj[0] = rs.getString("MaLoaiPhong");
				obj[1] = rs.getString("TenLoaiPhong");
				obj[2] = ChuyenDoi.dinhDangSo(rs.getDouble("GiaTheoGio"));
				obj[3] = ChuyenDoi.dinhDangSo(rs.getDouble("GiaTheoNgay"));
				tblModel.addRow(obj);
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	public static boolean kt_Them(entity.LoaiPhong LP) {
		String kt2 = "[0-9]{1,99}[.][0-9]{1,99}";
		ResultSet rs = dao.DAO_LoaiPhong.layTatCa();
		try {
			while (rs.next()) {
				if (rs.getString("MaLoaiPhong").matches(
						LP.getMaLoaiPhong())) {
					thongbao.thongbao("Mã phòng đã có", "");
					return false;
				}
			}
		} catch (SQLException ex) {

		}

		if (LP.getGiaTheoGio()==0 || LP.getGiaTheoNgay()==0) {
			thongbao.thongbao("Không được bỏ trống dữ liệu", "");
			return false;
		}
		
		if (LP.getMaLoaiPhong().trim().equals("")
				|| LP.getTenLoaiPhong().trim().equals("")) {
			thongbao.thongbao("Không bỏ trống dữ liệu", "");
			return false;
		}
		 if ((LP.getGiaTheoGio()+"").equals(kt2) ||
		 (LP.getGiaTheoNgay()+"").equals(kt2)) {
		 thongbao.thongbao("Nhập số vào giá", "");
		 return false;
		 }
		return true;
	}

	public static boolean kt_Sua(entity.LoaiPhong LP) {
		String kt2 = "[0-9]{1,99}[.][0-9]{1,99}";
		if (LP.getMaLoaiPhong().trim().equals("")
				|| LP.getTenLoaiPhong().trim().equals("")

		) {
			thongbao.thongbao("Không bỏ trống dữ liệu", "");
			return false;
		}
		if ((LP.getGiaTheoGio()+"").equals(kt2) || (LP.getGiaTheoNgay()+"").equals(kt2)) {
			thongbao.thongbao("Nhập số vào giá", "");
			return false;
		}
		return true;
	}

	public static boolean kt_Xoa(String MaLP) {
		ResultSet rs = dao.DAO_Phong.layPhong(0);
		try {
			while (rs.next()) {
				if (rs.getString("MaLoaiPhong").equals(MaLP)) {
					thongbao.thongbao("Loại phòng này có Phòng đang sử dụng",
							"");
					return false;
				}

			}
		} catch (SQLException ex) {

		}
		return true;
	}
}
