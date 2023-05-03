/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class NhanVien {
    private String maNV,tenNV;
    private boolean gioiTinh;
    private String ngaySinh,ngayLam;
    private String sdt;
    private Luong luong;
    private String diaChi,hinh,ghiChu;
   
    
    
	public NhanVien(String maNV, String tenNV, boolean gioiTinh,
			String ngaySinh, String ngayLam, String sdt, Luong luong,
			String diaChi, String hinh, String ghiChu) {
		
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.ngayLam = ngayLam;
		this.sdt = sdt;
		this.luong = luong;
		this.diaChi = diaChi;
		this.hinh = hinh;
		this.ghiChu = ghiChu;
	}
	
	

	public NhanVien() {
		super();
	}



	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}



	public String getNgaySinh() {
		return  ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getNgayLam() {
		return ngayLam;
	}

	public void setNgayLam(String ngayLam) {
		this.ngayLam = ngayLam;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Luong getLuong() {
		return luong;
	}

	public void setLuong(Luong luong) {
		this.luong = luong;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}



	public String getMaNV() {
		return maNV;
	}



	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}



	public String getTenNV() {
		return tenNV;
	}



	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}



	public boolean isGioiTinh() {
		return gioiTinh;
	}



	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}



	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh="
				+ gioiTinh + ", ngaySinh=" + ngaySinh + ", ngayLam=" + ngayLam
				+ ", sdt=" + sdt + ", luong=" + luong + ", diaChi=" + diaChi
				+ ", hinh=" + hinh + ", ghiChu=" + ghiChu + "]";
	}


	
	

}
