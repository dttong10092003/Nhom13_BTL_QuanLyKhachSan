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
public class Luong {
    private String maLuong;
    private double luongGio;
    private int soGioLam;
    private String ghiChu;
	public Luong(String maLuong, double luongGio, int soGioLam, String ghiChu) {
		super();
		this.maLuong = maLuong;
		this.luongGio = luongGio;
		this.soGioLam = soGioLam;
		this.ghiChu = ghiChu;
	}
	public Luong() {
		super();
	}
	public Luong(String maLuong) {
		super();
		this.maLuong = maLuong;
	}
	public String getMaLuong() {
		return maLuong;
	}
	public void setMaLuong(String maLuong) {
		this.maLuong = maLuong;
	}
	public double getLuongGio() {
		return luongGio;
	}
	public void setLuongGio(double luongGio) {
		this.luongGio = luongGio;
	}
	public int getSoGioLam() {
		return soGioLam;
	}
	public void setSoGioLam(int soGioLam) {
		this.soGioLam = soGioLam;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "Luong [maLuong=" + maLuong + ", luongGio=" + luongGio
				+ ", soGioLam=" + soGioLam + ", ghiChu=" + ghiChu + "]";
	}
	
  
}
