/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class DatPhong {
	private int maDatPhong;
	private String ngayThue,ngayRaDuKien,tinhTrang;
	private User user;
	private boolean loaiHinhThue;
	private double tienCoc;
	private int soNguoi;
	private KhachHang khachHang;
	private Phong phong;
	public DatPhong(int maDatPhong, String ngayThue, String ngayRaDuKien,
			User tenUser, String tinhTrang, boolean loaiHinhThue,
			double tienCoc, int soNguoi, KhachHang khachHang, Phong phong) {
		super();
		this.maDatPhong = maDatPhong;
		this.ngayThue = ngayThue;
		this.ngayRaDuKien = ngayRaDuKien;
		this.user = tenUser;
		this.tinhTrang = tinhTrang;
		this.loaiHinhThue = loaiHinhThue;
		this.tienCoc = tienCoc;
		this.soNguoi = soNguoi;
		this.khachHang = khachHang;
		this.phong = phong;
	}
	public DatPhong() {
		super();
	}
	public DatPhong(int maDatPhong) {
		super();
		this.maDatPhong = maDatPhong;
	}
	public int getMaDatPhong() {
		return maDatPhong;
	}
	public void setMaDatPhong(int maDatPhong) {
		this.maDatPhong = maDatPhong;
	}
	public String getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(String ngayThue) {
		this.ngayThue = ngayThue;
	}
	public String getNgayRaDuKien() {
		return ngayRaDuKien;
	}
	public void setNgayRaDuKien(String ngayRaDuKien) {
		this.ngayRaDuKien = ngayRaDuKien;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public boolean isLoaiHinhThue() {
		return loaiHinhThue;
	}
	public void setLoaiHinhThue(boolean loaiHinhThue) {
		this.loaiHinhThue = loaiHinhThue;
	}
	public double getTienCoc() {
		return tienCoc;
	}
	public void setTienCoc(double tienCoc) {
		this.tienCoc = tienCoc;
	}
	public int getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	@Override
	public String toString() {
		return "DatPhong [maDatPhong=" + maDatPhong + ", ngayThue=" + ngayThue
				+ ", ngayRaDuKien=" + ngayRaDuKien + ", tenUser=" + user
				+ ", tinhTrang=" + tinhTrang + ", loaiHinhThue=" + loaiHinhThue
				+ ", tienCoc=" + tienCoc + ", soNguoi=" + soNguoi
				+ ", khachHang=" + khachHang + ", phong=" + phong + "]";
	}
	
}
