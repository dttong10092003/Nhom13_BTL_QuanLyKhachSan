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
public class ChiTietLuong {

	private String maChiTietLuong,ngayNhanLuong;
    private NhanVien nhanVien;
    private int soNgayNghi, soNgayLam;
	private double tongNhan;
	public String getMaChiTietLuong() {
		return maChiTietLuong;
	}
	public void setMaChiTietLuong(String maChiTietLuong) {
		this.maChiTietLuong = maChiTietLuong;
	}
	public String getNgayNhanLuong() {
		return ngayNhanLuong;
	}
	public void setNgayNhanLuong(String ngayNhanLuong) {
		this.ngayNhanLuong = ngayNhanLuong;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public int getSoNgayNghi() {
		return soNgayNghi;
	}
	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}
	public int getSoNgayLam() {
		return soNgayLam;
	}
	public void setSoNgayLam(int soNgayLam) {
		this.soNgayLam = soNgayLam;
	}
	public double getTongNhan() {
		return tongNhan;
	}
	public void setTongNhan(double tongNhan) {
		this.tongNhan = tongNhan;
	}
	public ChiTietLuong(String maChiTietLuong, String ngayNhanLuong,
			NhanVien nhanVien, int soNgayNghi, int soNgayLam, double tongNhan) {
		super();
		this.maChiTietLuong = maChiTietLuong;
		this.ngayNhanLuong = ngayNhanLuong;
		this.nhanVien = nhanVien;
		this.soNgayNghi = soNgayNghi;
		this.soNgayLam = soNgayLam;
		this.tongNhan = tongNhan;
	}
	public ChiTietLuong(String maChiTietLuong) {
		super();
		this.maChiTietLuong = maChiTietLuong;
	}
	public ChiTietLuong() {
		super();
	}
	@Override
	public String toString() {
		return "NhanLuong [maChiTietLuong=" + maChiTietLuong
				+ ", ngayNhanLuong=" + ngayNhanLuong + ", nhanVien=" + nhanVien
				+ ", soNgayNghi=" + soNgayNghi + ", soNgayLam=" + soNgayLam
				+ ", tongNhan=" + tongNhan + "]";
	}
	
   

}
