package entity;

public class Quyen {
	private String maQuyen, tenQuyen, mota;

	public Quyen(String maQuyen, String tenQuyen, String mota) {
		super();
		this.maQuyen = maQuyen;
		this.tenQuyen = tenQuyen;
		this.mota = mota;
	}

	public Quyen() {
		super();
	}

	public Quyen(String maQuyen) {
		super();
		this.maQuyen = maQuyen;
	}

	public String getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@Override
	public String toString() {
		return "Quyen [maQuyen=" + maQuyen + ", tenQuyen=" + tenQuyen
				+ ", mota=" + mota + "]";
	}



}
