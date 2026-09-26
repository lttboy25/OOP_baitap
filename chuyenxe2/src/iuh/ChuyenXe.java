package chuyenxe2.ChuyenXe;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class ChuyenXe {

	protected final String maSoChuyen;
	protected String hoTenTaiXe;
	protected String soXe;
	protected double doanhThu;

	public ChuyenXe(String maSoChuyen) {
		this(maSoChuyen, "-", "-", 0.0);
	}

	public ChuyenXe(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu) {
		if (maSoChuyen == null || maSoChuyen.trim().isEmpty()) {
			throw new RuntimeException("Mã số chuyến không hợp lệ");
		}
		this.maSoChuyen = maSoChuyen;
		setHoTenTaiXe(hoTenTaiXe);
		setSoXe(soXe);
		setDoanhThu(doanhThu);
	}

	public String getMaSoChuyen() {
		return maSoChuyen;
	}

	public String getHoTenTaiXe() {
		return hoTenTaiXe;
	}

	public void setHoTenTaiXe(String hoTenTaiXe) {
		if (hoTenTaiXe == null || hoTenTaiXe.trim().isEmpty()) {
			hoTenTaiXe = "-";
		}
		this.hoTenTaiXe = hoTenTaiXe;
	}

	public String getSoXe() {
		return soXe;
	}

	public void setSoXe(String soXe) {
		if (soXe == null || soXe.trim().isEmpty()) {
			soXe = "-";
		}
		this.soXe = soXe;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		if (doanhThu < 0) {
			doanhThu = 0;
		}
		this.doanhThu = doanhThu;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi"));
		return String.format("%-8s| %-20s| %-12s| %15s",
				maSoChuyen,
				hoTenTaiXe,
				soXe,
				nf.format(doanhThu));
	}

}
