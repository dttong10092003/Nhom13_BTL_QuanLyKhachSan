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
public class DAO_CTDV {

    public static ResultSet layCTDV(String MaDP) {
        String sql = "SELECT * FROM [dbo].[ChiTietDichVu] where MaDatPhong =" + MaDP + "";
        return connection.getdata(sql);
    }

    public static void them(entity.ChiTietDichVu ctdv) {
        String sql = "INSERT INTO [dbo].[ChiTietDichVu] "
                + "           ([MaDatPhong] "
                + "           ,[MaDichVu] "
                + "           ,[DonGia] "
                + "           ,[SoLuong] "
                + "           ,[ThanhTien]) "
                + "     VALUES "
                + "           ("+ctdv.getDp().getMaDatPhong()+" "
                + "           ,N'"+ctdv.getDV().getMaDV()+"' "
                + "           ,"+ctdv.getDonGia()+" "
                + "           ,"+ctdv.getSoLuong()+" "
                + "           ,"+ctdv.getThanhTien()+")";
         int kq = connection.executeTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm không thành công", "");
        }
    }
    public static  void xoa(String MaCTDV){
    String sql="DELETE FROM [dbo].[ChiTietDichVu] WHERE MaCTDV="+MaCTDV+"";
    connection.executeTruyVan(sql);
    }
    public static ResultSet layTatCa(){
    String sql="SELECT * FROM [dbo].[ChiTietDichVu]";
    return connection.getdata(sql);
    }
}
