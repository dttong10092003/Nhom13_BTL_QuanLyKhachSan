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
public class LoaiKH {
	private String maLoaiKH,tenLoaiKH,moTa;
	private int tienGiam;
	public LoaiKH(String maLoaiKH, String tenLoaiKH, String moTa, int tienGiam) {
		super();
		this.maLoaiKH = maLoaiKH;
		this.tenLoaiKH = tenLoaiKH;
		this.moTa = moTa;
		this.tienGiam = tienGiam;
	}
	public LoaiKH() {
		super();
	}
	public LoaiKH(String maLoaiKH) {
		super();
		this.maLoaiKH = maLoaiKH;
	}
	public String getMaLoaiKH() {
		return maLoaiKH;
	}
	public void setMaLoaiKH(String maLoaiKH) {
		this.maLoaiKH = maLoaiKH;
	}
	public String getTenLoaiKH() {
		return tenLoaiKH;
	}
	public void setTenLoaiKH(String tenLoaiKH) {
		this.tenLoaiKH = tenLoaiKH;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getTienGiam() {
		return tienGiam;
	}
	public void setTienGiam(int tienGiam) {
		this.tienGiam = tienGiam;
	}
	@Override
	public String toString() {
		return "LoaiKH [maLoaiKH=" + maLoaiKH + ", tenLoaiKH=" + tenLoaiKH
				+ ", moTa=" + moTa + ", tienGiam=" + tienGiam + "]";
	}

    
    
  
}