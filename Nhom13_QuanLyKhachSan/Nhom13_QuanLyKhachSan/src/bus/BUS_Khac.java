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
public class BUS_Khac {
    public static boolean kt_Sua(entity.Khac a){
        if (a.getMoc2()>=a.getMoc1()) {
            thongbao.thongbao("Checkin 2 phải lớn hơn Checkin 1", "");
            return false;
        }
        if (a.getMoc4()>=a.getMoc3()) {
            thongbao.thongbao("Checkout 2 phải lớn hơn Checkout 1", "");
            return false;
        }
    return true;
    }
}
