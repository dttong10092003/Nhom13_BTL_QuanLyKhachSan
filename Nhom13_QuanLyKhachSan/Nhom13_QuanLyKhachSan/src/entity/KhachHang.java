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
public class KhachHang {
	private String maKH, tenKH, sdt, cccd;
	private LoaiKH loaiKH;
	private int tuoi;
	private boolean gioiTinh;
	public KhachHang(String maKH, String tenKH, String sDT, String cCCD,
			LoaiKH loaiKH, int tuoi, boolean gioiTinh) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		sdt = sDT;
		cccd = cCCD;
		this.loaiKH = loaiKH;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
	}
	public KhachHang() {
		super();
	}
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSDT() {
		return sdt;
	}
	public void setSDT(String sDT) {
		sdt = sDT;
	}
	public String getCCCD() {
		return cccd;
	}
	public void setCCCD(String cCCD) {
		cccd = cCCD;
	}
	public LoaiKH getLoaiKH() {
		return loaiKH;
	}
	public void setLoaiKH(LoaiKH loaiKH) {
		this.loaiKH = loaiKH;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", SDT=" + sdt
				+ ", CCCD=" + cccd + ", loaiKH=" + loaiKH + ", tuoi=" + tuoi
				+ ", gioiTinh=" + gioiTinh + "]";
	}
	
	
}
