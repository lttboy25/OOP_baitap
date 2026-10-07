package bai4giaodichdat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class GiaoDich {
	private final int maGiaoDich;
	private LocalDate ngayGiaoDich;
	private double donGia;
	private double dienTich;
	
	
	
	public GiaoDich(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich) {
		super();
		if(maGiaoDich <= 0) {
			throw new RuntimeException("Ma giao dich la so va phai lon hon 0");
		}
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}
	
	



	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}





	public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}





	public double getDonGia() {
		return donGia;
	}





	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}





	public double getDienTich() {
		return dienTich;
	}





	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}





	public int getMaGiaoDich() {
		return maGiaoDich;
	}


@Override
public String toString() {
	// TODO Auto-generated method stub
	DateTimeFormatter df = DateTimeFor
	return String.format("%4d | %-20s | %15.2f | %15.2f", maGiaoDich, ngayGiaoDich, donGia, dienTich);
}


	public abstract double thanhTien();

}
