package onGKChuyenBay;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Ve {
	private double giaVe;
	private String hangGhe;
	private String maVe;
	private int soKGHanhLy;
	private String tenHanhKhach;
	
	
	public Ve(double giaVe, String hangGhe, String maVe, int soKGHanhLy, String tenHanhKhach) {
		super();
		setMaVe(maVe);
		setTenHanhKhach(tenHanhKhach);
		setHangGhe(hangGhe);
		setSoKGHanhLy(soKGHanhLy);
		setGiaVe(giaVe);
	}

	public double getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(double giaVe) {
		if(giaVe <= 0) {
			throw new RuntimeException(" Giá vé gốc > 0");
		}
		this.giaVe = giaVe;
	}

	public String getHangGhe() {
		return hangGhe;
	}

	public void setHangGhe(String hangGhe) {
		if(!hangGhe.equalsIgnoreCase("Phổ thông") || !hangGhe.equalsIgnoreCase("Thương gia")) {
			throw new RuntimeException("Hạng ghế chỉ nhận một trong hai giá trị \"Phổ thông\" hoặc \"Thương gia\"");
		}
		this.hangGhe = hangGhe;
	}

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		if(maVe == null || maVe.trim().length() <= 0) {
			throw new RuntimeException(" Mã vé không được rỗng");
		}
		this.maVe = maVe;
	}

	public int getSoKGHanhLy() {
		return soKGHanhLy;
	}

	public void setSoKGHanhLy(int soKGHanhLy) {
		if(soKGHanhLy < 0) {
			throw new RuntimeException(" Số kg hành lý ký gửi >= 0");
		}
		this.soKGHanhLy = soKGHanhLy;
	}

	public String getTenHanhKhach() {
		return tenHanhKhach;
	}

	public void setTenHanhKhach(String tenHanhKhach) {
		this.tenHanhKhach = tenHanhKhach;
	}

	public double tinhPhiHanhLy() {
		if(soKGHanhLy > 20) {
			return 250000.0;
		}else if (soKGHanhLy > 10) {
			return 200000.0;
		}else if (soKGHanhLy > 1) {
			return 150000.0;
		}else {
			return 0;
		}
	};
	
	public double tinhTongTienVe() {
		return giaVe + tinhPhiHanhLy();
	};
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// TODO Auto-generated method stub
		return String.format("%-10s | %-30s | $-7s | %10d | %10.2f", maVe, tenHanhKhach, hangGhe, soKGHanhLy, nf.format(tinhTongTienVe()));
		
		
	}
}
