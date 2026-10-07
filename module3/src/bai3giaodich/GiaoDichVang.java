package bai3giaodich;

import java.time.LocalDate;

public class GiaoDichVang extends GiaoDich{
	
	private String loaiVang;
	
	public GiaoDichVang(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loaiVang) {
		super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
		this.loaiVang = loaiVang;
	}



	@Override
	public double thanhTien() {
		// TODO Auto-generated method stub
		return getSoLuong() * getDonGia();
	}



	public String getLoaiVang() {
		return loaiVang;
	}



	public void setLoaiVang(String loaiVang) {
		this.loaiVang = loaiVang;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + String.format("%-20s", loaiVang);
	}
	
	
	
}
