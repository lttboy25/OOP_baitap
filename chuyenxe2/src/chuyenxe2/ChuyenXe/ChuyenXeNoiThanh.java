package chuyenxe2.ChuyenXe;

public class ChuyenXeNoiThanh extends ChuyenXe {

	private int soTuyen;
	private double soKm;

	public ChuyenXeNoiThanh(String maSoChuyen) {
		super(maSoChuyen);
		this.soTuyen = 0;
		this.soKm = 0;
	}

	public ChuyenXeNoiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu, int soTuyen,
			double soKm) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		setSoTuyen(soTuyen);
		setSoKm(soKm);
	}

	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		if (soTuyen < 0) {
			soTuyen = 0;
		}
		this.soTuyen = soTuyen;
	}

	public double getSoKm() {
		return soKm;
	}

	public void setSoKm(double soKm) {
		if (soKm < 0) {
			soKm = 0;
		}
		this.soKm = soKm;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" | Nội thành - Số tuyến: %-3d - Số km: %-6.1f", soTuyen, soKm);
	}

}
