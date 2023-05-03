/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import gui.mycombobox;
import gui.thongbao;

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
public class BUS_Phong {
//   public static void loadData_Luong(JComboBox cbb) {
//        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
//        cbbModel.removeAllElements();
//        
//        
//   }
    public static void load_cbbTang(JComboBox cbb) {
        ResultSet rs=dao.DAO_Phong.layTang();
      DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
        try {
            while(rs.next()){
                cbbModel.addElement(rs.getString("MaTang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUS_Phong.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public static void doDuLieuBang(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[6];
        ResultSet rs = dao.DAO_Phong.layPhong(0);
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaPhong");
                String MaLoaiPhong = rs.getString("MaLoaiPhong");
                ResultSet rsLoaiPhong = dao.DAO_LoaiPhong.layLoaiTheoMa(MaLoaiPhong);
                if (rsLoaiPhong.next()) {
                    obj[1] = rsLoaiPhong.getString("TenLoaiPhong");
                }
                obj[2] = rs.getInt("DienTich");
                obj[3] = rs.getString("Hinh");
                obj[4] = rs.getString("TinhTrang");
                obj[5] = rs.getString("MaTang");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("");
        }
    }

    public static void loadData_LoaiPhong(JComboBox cbb) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
        cbbModel.removeAllElements();
        ResultSet rs = dao.DAO_LoaiPhong.layTatCa();
        try {
            while (rs.next()) {
                Object MaLoaiPhong = rs.getString("MaLoaiPhong");
                Object TenLoai = rs.getString("TenLoaiPhong");
                mycombobox mb = new mycombobox(MaLoaiPhong, TenLoai);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUS_Phong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean them(entity.Phong P) {
        String kt2 = "[0-9]{1,99}";
        ResultSet rs = dao.DAO_Phong.layPhong(0);
        try {
            while (rs.next()) {
                if (rs.getString("MaPhong").matches(P.getMaPhong())) {
                    thongbao.thongbao("Mã phòng bị trùng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUS_Phong.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ((P.getTang()+"").trim().equals("")) {
            thongbao.thongbao("Tầng không được trống", "");
            return false;
        }
        if (!((P.getDienTich()+"")).matches(kt2)) {
            thongbao.thongbao("Diện tích sai", "");
            return false;
        }
        if ((P.getDienTich()+"").trim().equals("") || P.getMaPhong().trim().equals("") || P.getDienTich() == 0) {
            thongbao.thongbao("Không để trống dữ liệu", "");
            return false;
        }
        if ((P.getGiuongDoi()+"").trim().equals("")) {
            thongbao.thongbao("Nhập số lượng giường đôi", "");
            return false;
        }
        if ((P.getGiuongDon()+"").trim().equals("")) {
            thongbao.thongbao("Nhập số lượng giường đơn", "");
            return false;
        }
        return true;
    }

    public static boolean kt_Xoa(String MaPhong) {
        ResultSet rs = dao.DAO_Phong.layTheoMa(MaPhong);
        try {
            if (rs.next()) {
                if (rs.getString("TinhTrang").equals("sudung") || rs.getString("TinhTrang").equals("dondep")) {
                    thongbao.thongbao("Phòng đang sử dụng hoặc đang dọn dẹp", "");
                    return false;
                }
            }
        } catch (SQLException ex) {

        }
        ResultSet rs2=dao.DAO_DatPhong.layTatCa();
        try {
            while(rs2.next()){
                if (rs2.getString("MaPhong").equals(MaPhong)) {
                    thongbao.thongbao("Phòng này đã tồn tại trong hóa đơn", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
           
        }
        return true;
    }

    public static boolean kt_Sua(entity.Phong P) {
        String kt2 = "[0-9]{1,99}";
        if (!(P.getDienTich()+"").matches(kt2)) {
            thongbao.thongbao("Diện tích sai", "");
            return false;
        }
        if ((P.getTang()+"").trim().equals("")) {
            thongbao.thongbao("Tầng không được trống", "");
            return false;
        }
        if ((P.getDienTich()+"").trim().equals("") || P.getMaPhong().trim().equals("")) {
            thongbao.thongbao("Không để trống dữ liệu", "");
            return false;
        }
        return true;
    }
}
