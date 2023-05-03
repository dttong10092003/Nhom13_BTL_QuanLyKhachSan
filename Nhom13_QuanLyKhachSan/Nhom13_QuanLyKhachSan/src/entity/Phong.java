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
public class Phong {
    private String maPhong,hinh,tinhTrang,ghiChu;;
    private LoaiPhong loaiPhong; 
    private int dienTich,tang,giuongDon,giuongDoi;

    
    
	public Phong(String maPhong, String hinh, String tinhTrang, String ghiChu,
			LoaiPhong loaiPhong, int dienTich, int tang, int giuongDon,
			int giuongDoi) {
		super();
		this.maPhong = maPhong;
		this.hinh = hinh;
		this.tinhTrang = tinhTrang;
		this.ghiChu = ghiChu;
		this.loaiPhong = loaiPhong;
		this.dienTich = dienTich;
		this.tang = tang;
		this.giuongDon = giuongDon;
		this.giuongDoi = giuongDoi;
	}
	public Phong() {
		
	}
	
	public Phong(String maPhong) {
		
		this.maPhong = maPhong;
	}
	
	
	public int getDienTich() {
		return dienTich;
	}
	public void setDienTich(int dienTich) {
		this.dienTich = dienTich;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public int getTang() {
		return tang;
	}
	public void setTang(int tang) {
		this.tang = tang;
	}
	public int getGiuongDon() {
		return giuongDon;
	}
	public void setGiuongDon(int giuongDon) {
		this.giuongDon = giuongDon;
	}
	public int getGiuongDoi() {
		return giuongDoi;
	}
	public void setGiuongDoi(int giuongDoi) {
		this.giuongDoi = giuongDoi;
	}
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", hinh=" + hinh + ", tinhTrang="
				+ tinhTrang + ", ghiChu=" + ghiChu + ", loaiPhong=" + loaiPhong
				+ ", dienTich=" + dienTich + ", tang=" + tang + ", giuongDon="
				+ giuongDon + ", giuongDoi=" + giuongDoi + "]";
	}

    
    
}
