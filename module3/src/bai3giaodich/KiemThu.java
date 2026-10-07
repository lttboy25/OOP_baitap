package bai3giaodich;

import java.time.LocalDate;

public class KiemThu {
	public static void main(String[] args) {
		GiaoDichTienTe tien1 = new GiaoDichTienTe(1, LocalDate.now(), 10000, 10, 5.0, LoaiTienTe.EURO);
		GiaoDichTienTe tien2 = new GiaoDichTienTe(2, LocalDate.now(), 200000, 5, 0, LoaiTienTe.VIET_NAM);
		GiaoDichVang vang1 = new GiaoDichVang(3, LocalDate.now(), 300000, 10, "Vang 9999");
		GiaoDichVang vang2 = new GiaoDichVang(4, LocalDate.now(), 800000000, 10, "Vang 9999 9999");
		
		DanhSachGiaoDich ds = new DanhSachGiaoDich(3);
		ds.themGiaoDich(tien1);
		ds.themGiaoDich(tien2);
		ds.themGiaoDich(vang1);
		ds.themGiaoDich(vang2);
		
		System.out.println(ds);

		
		System.out.println("So luong theo loai Vang 999 la: " + ds.tinhSoLuongTheoLoai("Vang 9999"));
		
		System.out.println("Thanh tien giao dich tien te: " + ds.thanhTienGDTienTe());
		
		ds.xuatTren1Ty();
		
	}

}
