/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.collections4.Get;

import connectDB.connection;
import entity.Phong;
import gui.thongbao;

/**
 *
 * @author ADMIN
 */
public class DAO_Phong {

    public static ResultSet layPhong(int TrangThai) {
        String sql = null;
        if (TrangThai == 0) {
            sql = "select * from Phong";
        } else if (TrangThai == 1) {
            sql = "SELECT * FROM Phong where TinhTrang like N'trong'";
        } else if (TrangThai == 2) {
            sql = "SELECT * FROM Phong where TinhTrang like N'sudung'";
        } else if (TrangThai == 3) {
            sql = "SELECT * FROM Phong where TinhTrang like N'dondep'";
        } else if (TrangThai == 4) {
            sql = "SELECT * FROM Phong where TinhTrang like N'dattruoc'";
        } else {
        }

        return connectDB.connection.getdata(sql);
    }

    public static ResultSet layTang() {
        String sql = "select DISTINCT MaTang from Phong";
        return connection.getdata(sql);
    }

    public static void update(String MaPhong) {//cập nhật phòng thành 'sudung'
        String sql = "UPDATE [dbo].[Phong] "
                + " SET  "
                + "[TinhTrang] = N'sudung'   "
                + " WHERE MaPhong=N'" + MaPhong + "'";
        connection.executeTruyVan(sql);
    }

    public static void updateDatTruoc(String MaPhong) {//cập nhật trạng thái phòng thành 'dattruoc'
        String sql = "UPDATE [dbo].[Phong] SET [TinhTrang] =N'dattruoc' WHERE MaPhong=N'" + MaPhong + "'";
        connection.executeTruyVan(sql);
    }

    public static void updateTinhTrang(String MaPhong) {
        String sql = "UPDATE [dbo].[Phong] SET [TinhTrang] =N'dondep' WHERE MaPhong =N'" + MaPhong + "'";
        connection.executeTruyVan(sql);
    }

    public static void updateHoanThanhDonDep(String MaPhong) {
        String sql = "UPDATE [dbo].[Phong] SET [TinhTrang] =N'trong' WHERE MaPhong=N'" + MaPhong + "'";
        connection.executeTruyVan(sql);
    }

    public static void themPhong(entity.Phong P) {
        String sql = "INSERT INTO [dbo].[Phong] "
                + "           ([MaPhong] "
                + "           ,[MaLoaiPhong] "
                + "           ,[DienTich] "
                + ",[MaTang]"
                + ",[GiuongDon]"
                + "  ,[GiuongDoi]"
                + "           ,[Hinh] "
                + "           ,[TinhTrang] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           (N'" + P.getMaPhong() + "' "
                + "           ,N'" + P.getLoaiPhong().getMaLoaiPhong() + "' "
                + "           ," + P.getDienTich() + " "
                + "," + P.getTang() + " "
                + "," + P.getGiuongDon() + " "
                + "," + P.getGiuongDoi() + " "
                + "           ,N'" + P.getHinh() + "' "
                + "           ,N'trong' "
                + "           ,N'" + P.getGhiChu() + "')";
        int kq = connection.executeTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm không thành công", "");
        }
    }

    public static ResultSet layTheoMa(String MaPhong) {
        String sql = "SELECT * FROM [dbo].[Phong] where MaPhong=N'" + MaPhong + "'";
        return connection.getdata(sql);
    }

    public static void xoa(String MaPhong) {
        String sql = "DELETE FROM [dbo].[Phong]  WHERE MaPhong=N'" + MaPhong + "'";
        connection.executeTruyVan(sql);
    }

    public static void sua(entity.Phong P) {
        String sql = "UPDATE [dbo].[Phong] "
                + "   SET [MaPhong] = N'" + P.getMaPhong() + "' "
                + "      ,[MaLoaiPhong] = N'" + P.getLoaiPhong().getMaLoaiPhong() + "' "
                + "      ,[DienTich] =" + P.getDienTich() + " "
                + "      ,[Hinh] = N'" + P.getHinh() + "' "
                + ",[MaTang] = " + P.getTang() + " "
                + ",[GiuongDon] =" + P.getGiuongDon() + " "
                + ",[GiuongDoi] = " + P.getGiuongDoi() + " "
                //                + "      ,[TinhTrang] = N'"+P.getTinhTrang()+"' "
                + "      ,[GhiChu] = N'" + P.getGhiChu() + "' "
                + " WHERE MaPhong =N'" + P.getMaPhong() + "'";
        int kq = connection.executeTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Sửa thành công", "");
        } else {
            thongbao.thongbao("Sửa không thành công", "");
        }
    }

    public static ResultSet layPhongTheoTang(String tang) {
        String sql = "SELECT * FROM [dbo].[Phong] where MaTang=" + tang + "";
        return connection.getdata(sql);

    }

    public static ResultSet layTheoTangVaGiuongDon(String tang, int giuong) {
        String sql = "SELECT * FROM [dbo].[Phong] where GiuongDon=" + giuong + " and MaTang=" + tang + "";
        return connection.getdata(sql);
    }

    public static ResultSet layTheoTangVaGiuongDoi(String tang, int giuong) {
        String sql = "SELECT * FROM [dbo].[Phong] where GiuongDoi=" + giuong + " and MaTang=" + tang + "";
        return connection.getdata(sql);
    }
}
