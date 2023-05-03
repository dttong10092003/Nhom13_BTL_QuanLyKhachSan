/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;

import connectDB.connection;

/**
 *
 * @author ADMIN
 */
public class DAO_ThongKe {

    public static ResultSet layTheoKhoangTG(String date1, String date2) {
        String sql = " set dateformat dmy "
                + " select MaHoaDon,TienPhong,TienDichVu,ThanhTien,NgayThanhToan,(PhuThuCheckin+PhuThuCheckout) as phuthu from hoadon where NgayThanhToan  between '" + date1 + "' and '" + date2 + "'";
        return connection.getdata(sql);
    }

    public static ResultSet layTheoKhoangTG2(String date1, String date2) {
        String sql = " select count(MaHoaDon) as SoHD, sum(thanhtien) as doanhthu,sum(TienDichVu) as dichvu, sum(TienPhong) as tienphong from hoadon where NgayThanhToan  between '" + date1 + "' and '" + date2 + "'";
        return connection.getdata(sql);
    }

    public static ResultSet layTatCa() {
        String sql = " select MaHoaDon,TienPhong,TienDichVu,ThanhTien,NgayThanhToan,(PhuThuCheckin+PhuThuCheckout) as phuthu from hoadon";
        return connection.getdata(sql);
    }

    public static ResultSet layTatCa2() {
        String sql = "select count(MaHoaDon) as SoHD, sum(thanhtien) as doanhthu,sum(TienDichVu) as dichvu, sum(TienPhong) as tienphong from hoadon";
        return connection.getdata(sql);
    }

    //thống kê lương
    public static ResultSet layTatCaLuong() {
        String sql = "SELECT * FROM [dbo].[ChiTietLuong]";
        return connection.getdata(sql);
    }

    public static ResultSet layTatCaLuong2() {
        String sql = "SELECT sum(TongNhan) as tongnhan FROM [dbo].[ChiTietLuong]";
        return connection.getdata(sql);
    }

    public static ResultSet layLuongTheoTG(String date1, String date2) {
        String sql = "set dateformat dmy "
                + "SELECT * FROM [dbo].[ChiTietLuong] where NgayNhanLuong between '" + date1 + "' and '" + date2 + "'";
        return connection.getdata(sql);
    }

    public static ResultSet layLuongTheoTG2(String date1, String date2) {
        String sql = "set dateformat dmy "
                + "SELECT sum(TongNhan) as tongnhan FROM [dbo].[ChiTietLuong] where NgayNhanLuong between '" + date1 + "' and '" + date2 + "'";
        return connection.getdata(sql);
    }
}
