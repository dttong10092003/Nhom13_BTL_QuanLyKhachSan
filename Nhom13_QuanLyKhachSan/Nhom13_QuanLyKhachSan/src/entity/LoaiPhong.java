package entity;

public class LoaiPhong {
	private String maLoaiPhong,tenLoaiPhong;
	private int giuongDon,giuongDoi;
	private double giaTheoGio,giaTheoNgay;
	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, int giuongDon,
			int giuongDoi, double giaTheoGio, double giaTheoNgay) {
		
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		this.giuongDon = giuongDon;
		this.giuongDoi = giuongDoi;
		this.giaTheoGio = giaTheoGio;
		this.giaTheoNgay = giaTheoNgay;
	}
	public LoaiPhong() {
		
	}
	public LoaiPhong(String maLoaiPhong) {
		
		this.maLoaiPhong = maLoaiPhong;
	}
	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}
	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
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
	public double getGiaTheoGio() {
		return giaTheoGio;
	}
	public void setGiaTheoGio(double giaTheoGio) {
		this.giaTheoGio = giaTheoGio;
	}
	public double getGiaTheoNgay() {
		return giaTheoNgay;
	}
	public void setGiaTheoNgay(double giaTheoNgay) {
		this.giaTheoNgay = giaTheoNgay;
	}
	@Override
	public String toString() {
		return "LoaiPhong [maLoaiPhong=" + maLoaiPhong + ", tenLoaiPhong="
				+ tenLoaiPhong + ", giuongDon=" + giuongDon + ", giuongDoi="
				+ giuongDoi + ", giaTheoGio=" + giaTheoGio + ", giaTheoNgay="
				+ giaTheoNgay + "]";
	}
	
	
	
}
