/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gui.thongbao;

import java.sql.ResultSet;

import connectDB.connection;

/**
 *
 * @author ADMIN
 */
public class DAO_LoaiKH {

    public static ResultSet layLoaiKH() {
        String sql = "SELECT * FROM [dbo].[LoaiKhachHang]";
        return connection.getdata(sql);
    }

    public static ResultSet layTheoMa(String MaLoai) {
        String sql = "SELECT * FROM [dbo].[LoaiKhachHang] where MaLoaiKH=N'" + MaLoai + "'";
        return connection.getdata(sql);
    }

    public static void them(entity.LoaiKH Loai) {
        String sql = "INSERT INTO [dbo].[LoaiKhachHang] "
                + "           ([MaLoaiKH] "
                + "           ,[TenLoaiKH] "
                + "           ,[TienGiam] "
                + "           ,[MoTa]) "
                + "     VALUES "
                + "           (N'" + Loai.getMaLoaiKH() + "' "
                + "           ,N'" + Loai.getTenLoaiKH() + "' "
                + "           ," + Loai.getTienGiam() + " "
                + "           ,N'" + Loai.getMoTa() + "')";
        int kq = connection.executeTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm không thành công", "");
        }
    }

    public static void sua(entity.LoaiKH Loai) {
        String sql = "UPDATE [dbo].[LoaiKhachHang] "
                + "   SET [MaLoaiKH] = N'" + Loai.getMaLoaiKH() + "' "
                + "      ,[TenLoaiKH] = N'" + Loai.getTenLoaiKH() + "' "
                + "      ,[TienGiam] = " + Loai.getTienGiam() + " "
                + "      ,[MoTa] = N'" + Loai.getMoTa() + "' "
                + " WHERE MaLoaiKH=N'" + Loai.getMaLoaiKH() + "'";
        int kq = connection.executeTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Sửa thành công", "");
        } else {
            thongbao.thongbao("Sửa không thành công", "");
        }
    }

    public static void xoa(String MaLoaiKH) {
        String sql = "DELETE FROM [dbo].[LoaiKhachHang] WHERE MaLoaiKH =N'" + MaLoaiKH + "'";
        connection.executeTruyVan(sql);
    }

}
