package chuyenxe2.ChuyenXe;

public class ChuyenXeNgoaiThanh extends ChuyenXe {

	private String noiDen;
	private int soNgay;

	public ChuyenXeNgoaiThanh(String maSoChuyen) {
		super(maSoChuyen);
		this.noiDen = "-";
		this.soNgay = 0;
	}

	public ChuyenXeNgoaiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu, String noiDen,
			int soNgay) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		setNoiDen(noiDen);
		setSoNgay(soNgay);
	}

	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		if (noiDen == null || noiDen.trim().isEmpty()) {
			noiDen = "-";
		}
		this.noiDen = noiDen;
	}

	public int getSoNgay() {
		return soNgay;
	}

	public void setSoNgay(int soNgay) {
		if (soNgay < 0) {
			soNgay = 0;
		}
		this.soNgay = soNgay;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" | Ngoại thành - Nơi đến: %-10s - Số ngày: %-3d", noiDen, soNgay);
	}

}
