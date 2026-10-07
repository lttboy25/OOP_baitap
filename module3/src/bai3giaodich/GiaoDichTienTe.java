package bai3giaodich;

import java.time.LocalDate;

public class GiaoDichTienTe extends GiaoDich{
	
	private double tiGia;
	private LoaiTienTe loaiTienTe;
		
	public GiaoDichTienTe(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, double tiGia,
			LoaiTienTe loaiTienTe) {
		super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
		this.tiGia = tiGia;
		this.loaiTienTe = loaiTienTe;
	}

	public double getTiGia() {
		return tiGia;
	}

	public void setTiGia(double tiGia) {
		this.tiGia = tiGia;
	}

	public LoaiTienTe getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(LoaiTienTe loaiTienTe) {
		this.loaiTienTe = loaiTienTe;
	}


	@Override
	public double thanhTien() {
		if(loaiTienTe != null || loaiTienTe.equals(LoaiTienTe.USD) || loaiTienTe.equals(LoaiTienTe.EURO))
			return getSoLuong() * getDonGia() * tiGia;
		return getSoLuong() * getDonGia();
	}

}
