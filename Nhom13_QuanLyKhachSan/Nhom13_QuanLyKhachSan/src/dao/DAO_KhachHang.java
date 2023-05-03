/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gui.thongbao;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import connectDB.connection;

/**
 *
 * @author ADMIN
 */
public class DAO_KhachHang {

    public static ResultSet layKH() {
        String sql = "SELECT * FROM [dbo].[KhachHang]";
        return connection.getdata(sql);
    }

    public static ResultSet layKHTheoMa(String MaKH) {
        String sql = "SELECT * FROM [dbo].[KhachHang] where MaKhachHang =N'" + MaKH + "'";
        return connection.getdata(sql);
    }

    public static void them(entity.KhachHang KH) {
        String sql = "INSERT INTO [dbo].[KhachHang] "
                + "           ([MaKhachHang] "
                + "           ,[MaLoaiKH] "
                + "           ,[TenKhachHang] "
                + "           ,[Tuoi] "
                + "           ,[GioiTinh] "
                + "           ,[SoDienThoai] "
                + "           ,[SoCCCD]) "
                + "     VALUES "
                + "           (N'" + KH.getMaKH() + "' "
                + "           ,N'" + KH.getLoaiKH().getMaLoaiKH() + "' "
                + "           ,N'" + KH.getTenKH() + "' "
                + "           ," + KH.getTuoi() + " "
                + "           ,'" + KH.isGioiTinh() + "' "
                + "           ,N'" + KH.getSDT() + "' "
                + "           ,N'" + KH.getCCCD() + "')";
        int kq = connection.executeTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm không thành công", "");
        }
    }

    public static void xoa(String MaKH) {
        String sql = "DELETE FROM [dbo].[KhachHang] WHERE MaKhachHang=N'" + MaKH + "'";
        connection.executeTruyVan(sql);
    }

    public static void sua(entity.KhachHang KH) {
        String sql = "UPDATE [dbo].[KhachHang] "
                + "   SET [MaKhachHang] = N'"+KH.getMaKH()+"' "
                + "      ,[MaLoaiKH] ="+KH.getLoaiKH().getMaLoaiKH()+" "
                + "      ,[TenKhachHang] =N'"+KH.getTenKH()+"' "
                + "      ,[Tuoi] = "+KH.getTuoi()+" "
                + "      ,[GioiTinh] = '"+KH.isGioiTinh()+"' "
                + "      ,[SoDienThoai] = '"+KH.getSDT()+"' "
                + "      ,[SoCCCD] = '"+KH.getCCCD()+"' "
                + " WHERE MaKhachHang=N'"+KH.getMaKH()+"'";
        int kq = connection.executeTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Sửa thành công", "");
        } else {
            thongbao.thongbao("Sửa không thành công", "");
        }
    }
    public static ResultSet timKiem(String tukhoa){
    String sql="select *from KhachHang where TenKhachHang like N'%"+tukhoa+"%' or SoDienThoai like N'%"+tukhoa+"%' or SoCCCD like N'%"+tukhoa+"%'";
    return connection.getdata(sql);
    }
}
