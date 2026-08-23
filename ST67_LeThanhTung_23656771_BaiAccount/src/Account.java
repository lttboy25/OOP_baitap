import java.text.NumberFormat;
import java.util.Locale;

public class Account {
	private String soTaiKhoan;
	private String tenTaiKhoan;
	private double soDu;
	private final double RATE = 0.035;
	private final double FEE = 1000;

	public Account(String soTaiKhoan, String tenTaiKhoan, double soDu) {
		super();
		this.soTaiKhoan = soTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.soDu = soDu;
	}

	public Account() {
	}

	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}

	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public double getSoDu() {
		return soDu;
	}

	public void setSoDu(double soDu) {
		this.soDu = soDu;
	}

	public double getRATE() {
		return RATE;
	}

	public double getFEE() {
		return FEE;
	}

	public void napTien(double tienNap) throws Exception {
		if (tienNap <= 0) {
			throw new Exception("So tien phai > 0");
		}
		soDu += tienNap;
	}

	public void rutTien(double tienRut) throws Exception {
		// Sua loi: dieu kien cu "soDu + FEE > soDu - 50000" luon dung -> khong bao gio rut duoc.
		// Dieu kien dung: so tien rut phai > 0 va sau khi rut + phi, so du con lai >= 50000
		if (tienRut <= 0 || tienRut + FEE > soDu - 50000) {
			throw new Exception("So tien rut khong hop le (vuot han muc hoac so du toi thieu 50,000)");
		}
		soDu -= tienRut;
	}

	public double daoHan() {
		soDu += soDu * RATE;
		return soDu;
	}

	public void chuyenKhoan(Account tkNhan, double tienChuyen) throws Exception {
		if (tienChuyen <= 0 || tienChuyen + FEE > soDu - 50000) {
			throw new Exception("So tien chuyen khoan khong hop le");
		}
		this.rutTien(tienChuyen);
		tkNhan.napTien(tienChuyen);
	}

	@Override
	public String toString() {
		Locale local = new Locale("vi", "VN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(local);
		return String.format("%-13s %-20s %-15s", soTaiKhoan, tenTaiKhoan, nf.format(soDu));
	}

}