package bai3giaodich;

import java.time.LocalDate;
import java.util.Objects;

public abstract class GiaoDich {
	private final int maGiaoDich;
	private LocalDate ngayGiaoDich;
	private double donGia;
	private int soLuong;
	
	public abstract double thanhTien();

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

	public int getMaGiaoDich() {
		return maGiaoDich;
	}
	
	

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}



	public GiaoDich(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong) {
		super();
		if(maGiaoDich < 0) {
			throw new RuntimeException("Ma giao dich phai lon hon hoac bang 0");
		}
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(donGia, maGiaoDich, ngayGiaoDich);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaoDich other = (GiaoDich) obj;
		return Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& maGiaoDich == other.maGiaoDich && Objects.equals(ngayGiaoDich, other.ngayGiaoDich);
	}

	@Override
	public String toString() {
		return String.format("%5d %-15s %20.2f", maGiaoDich, ngayGiaoDich, donGia);
	}
	
	
	
	
}
