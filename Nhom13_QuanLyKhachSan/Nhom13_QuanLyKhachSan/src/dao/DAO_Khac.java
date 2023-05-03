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
public class DAO_Khac {

    public static ResultSet layBangKhac(int ID) {
        String sql = "SELECT *FROM [dbo].[Khac] where ID=" + ID + "";
        return connection.getdata(sql);
    }

    public static void update(entity.Khac a) {
        String sql = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getMoc1() + " "
                + "      ,[GiaTriTG] = '" + a.getCheckIn() + "' "
                + "       "
                + " WHERE ID=3";
        String sql1 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getMoc2() + " "
                + "WHERE ID=4";
        String sql2 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getMoc3() + " "
                + "   ,[GiaTriTG]='" + a.getCheckOut() + "' "
                + "WHERE ID=6";
        String sql3 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getMoc4() + " "
                + "   ,[GiaTriTG]='" + a.getCheckOut() + "' "
                + "WHERE ID=5";
        String sql4 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getPhuThu2() + " "
                + "   WHERE ID=7";
        String sql5 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getPhuThu1() + " "
                + "   WHERE ID=8";
        String sql6 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getPhuThu4() + " "
                + "   WHERE ID=9";
        String sql7 = "UPDATE [dbo].[Khac] "
                + "   SET [GiaTriSo] = " + a.getPhuThu3() + " "
                + "   WHERE ID=10";
        connection.executeTruyVan(sql);
        connection.executeTruyVan(sql1);
        connection.executeTruyVan(sql2);
        connection.executeTruyVan(sql3);
        connection.executeTruyVan(sql4);
        connection.executeTruyVan(sql5);
        connection.executeTruyVan(sql6);
        connection.executeTruyVan(sql7);
        
    }
}
