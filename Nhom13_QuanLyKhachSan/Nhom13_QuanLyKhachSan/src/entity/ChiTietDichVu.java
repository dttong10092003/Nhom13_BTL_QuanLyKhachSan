
package entity;


public class ChiTietDichVu {
	private int maCTDV;
	private DichVu dv;
	private DatPhong dp;
	private int soLuong;
	private double thanhTien, donGia;

	public int getMaCTDV() {
		return maCTDV;
	}

	public void setMaCTDV(int maCTDV) {
		this.maCTDV = maCTDV;
	}

	public DichVu getDV() {
		return dv;
	}

	public void setDV(DichVu dV) {
		dv = dV;
	}


	public DatPhong getDp() {
		return dp;
	}

	public void setDp(DatPhong dp) {
		this.dp = dp;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public ChiTietDichVu(int maCTDV, DichVu dV, DatPhong maDP, int soLuong,
			double thanhTien, double donGia) {
		super();
		this.maCTDV = maCTDV;
		dv = dV;
		this.dp = maDP;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
		this.donGia = donGia;
	}

	public ChiTietDichVu() {
		super();
	}

	public ChiTietDichVu(int maCTDV) {
		super();
		this.maCTDV = maCTDV;
	}

	@Override
	public String toString() {
		return "ChiTietDichVu [maCTDV=" + maCTDV + ", DV=" + dv + ", maDP="
				+ dp + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien
				+ ", donGia=" + donGia + "]";
	}

}
