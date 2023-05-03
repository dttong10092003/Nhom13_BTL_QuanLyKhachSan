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
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BUS_Luong {

    public static void dodulieu(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[4];
        ResultSet rs = dao.DAO_Luong.layLuong();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaLuong");
                obj[1] = ChuyenDoi.dinhDangSo(rs.getDouble("LuongTheoGio"));
                obj[2] = rs.getInt("SoGioLam");
//                obj[3]=rs.getDate("NgayBatDauLam");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi đổ table");
        }
    }

    public static boolean kt_them(entity.Luong L) {
        String kt2 = "[0-9]{1,99}[.][0-9]{1,99}";
        ResultSet rs = dao.DAO_Luong.layLuong();
        try {
            while (rs.next()) {
                if (L.getMaLuong().matches(rs.getString("MaLuong"))) {
                    thongbao.thongbao("Mã lương đã dùng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUS_Luong.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (L.getLuongGio() == 0) {
			thongbao.thongbao("Không để trống dữ liệu", "");
			return false;
		}
        
        if (L.getMaLuong().trim().equals("")) {
            thongbao.thongbao("Không để trống dữ liệu", "");
            return false;
        }
        if (L.getMaLuong().length() < 1) {
            thongbao.thongbao("Mã lương có tối thiểu 2 ký tự ", "");
            return false;
        }
        if (!(L.getLuongGio()+"").matches(kt2)) {
            thongbao.thongbao("Nhập số vào lương", "");
            return false;
        }
        return true;
    }

    public static boolean kt_Sua(entity.Luong L) {
        String kt2 = "[0-9]{1,99}||[0-9]{1,99}[.][0-9]{1,99}";
        if (L.getMaLuong().trim().equals("") || (L.getLuongGio()+"").trim().equals("") || (L.getSoGioLam()+"").trim().equals("")) { 
            thongbao.thongbao("Không để trống dữ liệu", "");
            return false;
        }
        if (L.getMaLuong().length() < 1) {
            thongbao.thongbao("Mã lương có tối thiểu 2 ký tự ", "");
            return false;
        }
        if (!(L.getLuongGio()+"").matches(kt2)) {
            thongbao.thongbao("Nhập số vào lương", "");
            return false;
        }
        return true;
    }

    public static void doDuLieuBang(JTable tbl) {
        SimpleDateFormat D = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[4];
        ResultSet rs = dao.DAO_NhanVien.layNV();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaNhanVien");
                obj[1] = rs.getString("TenNhanVien");
                obj[2] = rs.getString("MaLuong");
                try {
                    obj[3] = ChuyenDoi.getDate2(rs.getDate("NgayBatDauLam"));
                } catch (Exception e) {
                    obj[3] = null;
                }

                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi đổ table");

        }
    }
    
    public static boolean kt_Xoa(String maluong){
    ResultSet rs=dao.DAO_NhanVien.layNV();// Kiểm tra mã lương khi xóa có đang tồn tại ở nhân viên hay không
        try {
            while(rs.next()){
                if (rs.getString("MaLuong").equals(maluong)) {
                    thongbao.thongbao("Mã lương này đang tồn tại ở ít nhất 1 nhân viên", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
           
        }
        return true;
    }
}
