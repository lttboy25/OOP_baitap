package bai3giaodich;

public class DanhSachGiaoDich {
	private GiaoDich[] danhSachGiaoDichBanDau;
	private int soLuongHienTai;
	
	public DanhSachGiaoDich(int n) {
		// TODO Auto-generated constructor stub
		if(n <= 0) {
			danhSachGiaoDichBanDau = new GiaoDich[10];
		}
		danhSachGiaoDichBanDau = new GiaoDich[n];
	}
	
	public int getSoLuongHienTai() {
		return soLuongHienTai;
	}
	
	public GiaoDich[] getDanhSach() {
		return danhSachGiaoDichBanDau;
	}
	
	public int getIndexGiaoDich(int id) {
		for (int i = 0; i < soLuongHienTai; i++) {
			if(danhSachGiaoDichBanDau[i].getMaGiaoDich() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public GiaoDich[] tangKichThuocMang(int soLuongMoi, GiaoDich[] danhSachBanDau) {
		GiaoDich[] dsSau = new GiaoDich[soLuongMoi];
		for (int i = 0; i < soLuongHienTai; i++) {
			dsSau[i] = danhSachBanDau[i];
		}
		return dsSau;
	}
	
	public boolean themGiaoDich(GiaoDich giaoDich) {
		if(giaoDich == null) {
			return false;
		}
		
		if(getIndexGiaoDich(giaoDich.getMaGiaoDich()) > -1) {
			return false;
		}
		
		if(soLuongHienTai == danhSachGiaoDichBanDau.length) {
			
			int soLuongMoi = (int) (soLuongHienTai * 1.7);
			GiaoDich[] dsTam = tangKichThuocMang(soLuongMoi, danhSachGiaoDichBanDau);
			dsTam[soLuongHienTai] = giaoDich;
			soLuongHienTai++;
			
			danhSachGiaoDichBanDau = dsTam;
			return true;
		}
		danhSachGiaoDichBanDau[soLuongHienTai] = giaoDich;
		soLuongHienTai++;
		return true;
	}
	
	public int tinhSoLuongTheoLoai(String loai) {
		int dem = 0;	
		for (int i = 0; i < soLuongHienTai; i++) {
			if(danhSachGiaoDichBanDau[i] instanceof GiaoDichVang) {
				GiaoDichVang gdVang = (GiaoDichVang) danhSachGiaoDichBanDau[i];
				if(gdVang.getLoaiVang().equalsIgnoreCase(loai)) dem++;
			}
		}
		return dem;
	}
	
	public double thanhTienGDTienTe() {
		double tong = 0.0;
		for (int i = 0; i < soLuongHienTai; i++) {
			if(danhSachGiaoDichBanDau[i] instanceof GiaoDichTienTe) {
				GiaoDichTienTe tienTe = (GiaoDichTienTe) danhSachGiaoDichBanDau[i];
				tong += tienTe.thanhTien();
			}
		}
		return tong;
	}
	
	public void xuatTren1Ty() {
		for (int i = 0; i < soLuongHienTai; i++) {
			if(danhSachGiaoDichBanDau[i].thanhTien() > 1000000000) {
				System.out.println(danhSachGiaoDichBanDau[i]);
			}
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < soLuongHienTai; i++) {
			s+= danhSachGiaoDichBanDau[i].toString() + "\n";
		}
		return s;
	}

}
