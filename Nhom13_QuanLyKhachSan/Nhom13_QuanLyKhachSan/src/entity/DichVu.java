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
public class DichVu {
    private String maDV,tenDV,donVi,ghiChu;
    private double donGia;
	public DichVu(String maDV, String tenDV, String donVi, String ghiChu,
			double donGia) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donVi = donVi;
		this.ghiChu = ghiChu;
		this.donGia = donGia;
	}
	public DichVu() {
		super();
	}
	public DichVu(String maDV) {
		super();
		this.maDV = maDV;
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", tenDV=" + tenDV + ", donVi=" + donVi
				+ ", ghiChu=" + ghiChu + ", donGia=" + donGia + "]";
	}

   
	
	
}
