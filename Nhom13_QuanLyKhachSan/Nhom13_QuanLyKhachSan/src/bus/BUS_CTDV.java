/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import gui.thongbao;

/**
 *
 * @author ADMIN
 */
public class BUS_CTDV {
    public static boolean kt_Them(entity.ChiTietDichVu ctdv){
        if (ctdv.getDV().getMaDV().trim().equals("")) {
            thongbao.thongbao("Chưa chọn dịch vụ", "");
            return false;
        }
        return true;
    }
}
