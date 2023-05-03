/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import gui.ChuyenDoi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BUS_ThongKe {

    public static void doBang(JTable tbl, String date1, String date2) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[6];
        ResultSet rs = dao.DAO_ThongKe.layTheoKhoangTG(date1, date2);
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaHoaDon");
                obj[1] = ChuyenDoi.dinhDangSo((rs.getDouble("TienPhong")));
                obj[2] = ChuyenDoi.dinhDangSo(rs.getDouble("TienDichVu"));
                obj[3] = ChuyenDoi.dinhDangSo(rs.getDouble("ThanhTien"));
                obj[4] = ChuyenDoi.dinhDangSo(rs.getDouble("phuthu"));
                obj[5] = rs.getString("NgayThanhToan");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi đổ bảng");
        }
    }

    public static void doBangTatCa(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[6];
        ResultSet rs = dao.DAO_ThongKe.layTatCa();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaHoaDon");
                obj[1] = ChuyenDoi.dinhDangSo((rs.getDouble("TienPhong")));
                obj[2] = ChuyenDoi.dinhDangSo(rs.getDouble("TienDichVu"));
                obj[3] = ChuyenDoi.dinhDangSo(rs.getDouble("ThanhTien"));
                obj[4] = ChuyenDoi.dinhDangSo(rs.getDouble("phuthu"));
                obj[5] = rs.getString("NgayThanhToan");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi đổ bảng");
        }

    }


    public static void doBangLuong(JTable tbl,ResultSet rs) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[5];
        try {
            while (rs.next()) {
                String MaNhanVien = rs.getString("MaNhanVien");
                ResultSet rsNV = dao.DAO_NhanVien.layNVTheoMa(MaNhanVien);
                if (rsNV.next()) {
                    obj[0] = rsNV.getString("TenNhanVien");
                }
                obj[1] = rs.getInt("SoNgayNghi");
                obj[2] = rs.getInt("SoNgayLam");
                obj[3] = ChuyenDoi.getDate2(rs.getDate("NgayNhanLuong"));
                obj[4] = ChuyenDoi.dinhDangSo(rs.getDouble("TongNhan"));
                tblModel.addRow(obj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BUS_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
