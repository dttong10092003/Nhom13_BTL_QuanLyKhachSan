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
public class HoaDon {
	private int maHoaDon;
	private DatPhong datPhong;
	private double tienPhong, tienDV, thanhTien,soNgayThue=0, soGioThue=0,phuThuCheckin=0,phuThuCheckout=0;
	private User user;
	KhachHang kh;
	private String ngayThanhToan,ghiChu ;
	private Phong phong;
	public HoaDon(int maHoaDon, DatPhong datPhong, double tienPhong,
			double tienDV, double thanhTien, double soNgayThue,
			double soGioThue, double phuThuCheckin, double phuThuCheckout,
			User tenUser, KhachHang tenKH, String ngayThanhToan, String ghiChu,
			Phong phong) {
		super();
		this.maHoaDon = maHoaDon;
		this.datPhong = datPhong;
		this.tienPhong = tienPhong;
		this.tienDV = tienDV;
		this.thanhTien = thanhTien;
		this.soNgayThue = soNgayThue;
		this.soGioThue = soGioThue;
		this.phuThuCheckin = phuThuCheckin;
		this.phuThuCheckout = phuThuCheckout;
		this.user = tenUser;
		this.kh= tenKH;
		this.ngayThanhToan = ngayThanhToan;
		this.ghiChu = ghiChu;
		this.phong = phong;
	}
	public HoaDon() {
		super();
	}
	public HoaDon(int maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public DatPhong getDatPhong() {
		return datPhong;
	}
	public void setDatPhong(DatPhong datPhong) {
		this.datPhong = datPhong;
	}
	public double getTienPhong() {
		return tienPhong;
	}
	public void setTienPhong(double tienPhong) {
		this.tienPhong = tienPhong;
	}
	public double getTienDV() {
		return tienDV;
	}
	public void setTienDV(double tienDV) {
		this.tienDV = tienDV;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public double getSoNgayThue() {
		return soNgayThue;
	}
	public void setSoNgayThue(double soNgayThue) {
		this.soNgayThue = soNgayThue;
	}
	public double getSoGioThue() {
		return soGioThue;
	}
	public void setSoGioThue(double soGioThue) {
		this.soGioThue = soGioThue;
	}
	public double getPhuThuCheckin() {
		return phuThuCheckin;
	}
	public void setPhuThuCheckin(double phuThuCheckin) {
		this.phuThuCheckin = phuThuCheckin;
	}
	public double getPhuThuCheckout() {
		return phuThuCheckout;
	}
	public void setPhuThuCheckout(double phuThuCheckout) {
		this.phuThuCheckout = phuThuCheckout;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public KhachHang getKh() {
		return kh;
	}
	public void setKh(KhachHang kh) {
		this.kh = kh;
	}
	public String getNgayThanhToan() {
		return ngayThanhToan;
	}
	public void setNgayThanhToan(String ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", datPhong=" + datPhong
				+ ", tienPhong=" + tienPhong + ", tienDV=" + tienDV
				+ ", thanhTien=" + thanhTien + ", soNgayThue=" + soNgayThue
				+ ", soGioThue=" + soGioThue + ", phuThuCheckin="
				+ phuThuCheckin + ", phuThuCheckout=" + phuThuCheckout
				+ ", tenUser=" + user + ", tenKH=" + kh
				+ ", ngayThanhToan=" + ngayThanhToan + ", ghiChu=" + ghiChu
				+ ", phong=" + phong + "]";
	}
	
   

}
