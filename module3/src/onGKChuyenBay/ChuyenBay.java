package onGKChuyenBay;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ChuyenBay {
	private Ve[] dsVe;
	private String maChuyenBay;
	private LocalDate ngayKhoiHanh;
	private String tuyenBay;
	private int soLuongHienTai;
	
	public ChuyenBay(int soVeToiDa) {
		// TODO Auto-generated constructor stub
		if(soVeToiDa <=0) {
			throw new RuntimeException("soVeToiDa > 0");
		}
		this.dsVe = new Ve[soVeToiDa];
	}

	public ChuyenBay(Ve[] dsVe, String maChuyenBay, LocalDate ngayKhoiHanh, String tuyenBay, int soLuongHienTai) {
		super();
		this.dsVe = dsVe;
		this.maChuyenBay = maChuyenBay;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.tuyenBay = tuyenBay;
		this.soLuongHienTai = soLuongHienTai;
	}	
	
	public int getIndexVe(String maVe) {
		for (int i = 0; i < soLuongHienTai; i++) {
			if(maVe.trim().equalsIgnoreCase(dsVe[i].getMaVe().trim()))
				return i;
		}
		return -1;
	}
	
	public Ve[] saoChepMang(int soLuongMoi) {
		Ve[] mangMoi = new Ve[soLuongMoi];
		for (int i = 0; i < soLuongHienTai; i++) {
			mangMoi[i] = dsVe[i];
			
		}
		return mangMoi;
	}
	
	public boolean themVe(Ve ve) {
		if(ve == null) {
			return false;
		}
		
		if(getIndexVe(ve.getMaVe()) > -1) {
			return false;
		}
		
		if(dsVe.length == soLuongHienTai) {
			int soLuongMoi = (int) (soLuongHienTai * 1.7);
			Ve[] mangTam = saoChepMang(soLuongMoi);
			
			mangTam[soLuongHienTai] = ve;
			soLuongHienTai++;
			dsVe = mangTam;
			return true;
		}
		
		dsVe[soLuongHienTai] = ve;
		soLuongHienTai++;
		return true;
	}
	
	public double tinhTongDoanhThu() {
		double tong = 0.0;
		for (int i = 0; i < soLuongHienTai; i++) {
			tong += dsVe[i].tinhTongTienVe();
			
		}
		return tong;
	}
	
	public Ve[] getDSVeTheoHangGhe(String hangGhe ) {
		Ve[] dsKetQua = new Ve[soLuongHienTai];
		int soLuongPhanTuKetQua = 0;
		for (int i = 0; i < soLuongHienTai; i++) {
			if(dsVe[i].getHangGhe().trim().equalsIgnoreCase(hangGhe.trim())) {
				dsKetQua[soLuongPhanTuKetQua] = dsVe[i];
				soLuongPhanTuKetQua++;
			}
		}
		return dsKetQua;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < soLuongHienTai; i++) {
			s += dsVe[i].toString();
			
		}
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String s2 = String.format("%-10s | %-10s | %-30s | %5d ", maChuyenBay, df.format(ngayKhoiHanh), tuyenBay, soLuongHienTai);
		
		return s + s2;
	}
	
}
