/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class User {
	private String tenUser, mK;
	private Date ngayLap;
	private Quyen quyen;
	private String ghiChu;
	private NhanVien nhanVien;
	public String getTenUser() {
		return tenUser;
	}
	public void setTenUser(String tenUser) {
		this.tenUser = tenUser;
	}
	public String getmK() {
		return mK;
	}
	public void setmK(String mK) {
		this.mK = mK;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public Quyen getQuyen() {
		return quyen;
	}
	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public User(String tenUser, String mK, Date ngayLap, Quyen quyen,
			String ghiChu, NhanVien nhanVien) {
		super();
		this.tenUser = tenUser;
		this.mK = mK;
		this.ngayLap = ngayLap;
		this.quyen = quyen;
		this.ghiChu = ghiChu;
		this.nhanVien = nhanVien;
	}
	public User() {
		
	}
	public User(String tenUser) {
		
		this.tenUser = tenUser;
	}
	@Override
	public String toString() {
		return "User [tenUser=" + tenUser + ", mK=" + mK + ", ngayLap="
				+ ngayLap + ", quyen=" + quyen + ", ghiChu=" + ghiChu
				+ ", nhanVien=" + nhanVien + "]";
	}
    
  


}

