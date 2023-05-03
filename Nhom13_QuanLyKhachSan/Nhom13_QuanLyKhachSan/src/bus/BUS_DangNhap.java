/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import gui.frm_QuanLyChinh;
import gui.thongbao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BUS_DangNhap {

    public static String TenUser, MatKhau, quyen;
     

    public static boolean kt_DangNhap(String TK, String MK) {
        if (TK.trim().equals("") || MK.trim().equals("")) {
            thongbao.thongbao("Không bỏ trống dữ liệu", "Thông báo");
            return false;
        }
        ResultSet rs = dao.DAO_DangNhap.layTKTheoMa(TK);
        try {
            if (rs.next()) {
                if (rs.getString("TenUser").matches(TK)) {
                    if (rs.getString("MatKhau").matches(MK)) {
                        System.out.println("Đăng nhập thành công");
                        TenUser=rs.getString("TenUser");
                        quyen=rs.getString("MaQuyen");
                        MatKhau=rs.getString("MatKhau");
                        return true;
                    }
                    thongbao.thongbao("Tài khoản hoặc mật khẩu sai", "Thông báo");
                    return false;

                }
                thongbao.thongbao("Tài khoản hoặc mật khẩu sai", "Thông báo");
                return false;

            }
        } catch (SQLException ex) {

        }
        thongbao.thongbao("Tài khoản hoặc mật khẩu sai", "Thông báo");
        return false;
    }
    public static boolean kt_DoiMK(String mkcu,String mkmoi,String nhaplai){
        if (!mkcu.equals(MatKhau)) {
            thongbao.thongbao("Mật khẩu cũ sai", "");
            return false;
        }
        if (mkmoi.length()<5) {
            thongbao.thongbao("Mật khẩu dài hơn 5 ký tự", "");
            return false;
        }
        if (!mkmoi.equals(nhaplai)) {
            thongbao.thongbao("Nhập lại mật khẩu", "");
            return false;
        }
    return true;
    }
}