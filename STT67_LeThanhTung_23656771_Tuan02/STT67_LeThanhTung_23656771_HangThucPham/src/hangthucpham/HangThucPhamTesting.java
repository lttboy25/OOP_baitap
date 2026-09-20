package hangthucpham;

import java.time.LocalDate;

public class HangThucPhamTesting {
	public static void main(String[] args) throws Exception {
		HangThucPhamList ds = new HangThucPhamList();

		ds.themHang(new HangThucPham("001", "Gạo", 100000, LocalDate.of(2018,7,10), LocalDate.of(2018,7,10)));
		ds.themHang(new HangThucPham("002", "Mì", 5000, LocalDate.of(2018,3,1), LocalDate.of(2018,9,1)));
		ds.themHang(new HangThucPham("003", "Nước", 10000, LocalDate.of(2017,3,1), LocalDate.of(2018,3,1)));

		System.out.println("=== Danh sách ban đầu ===");
		System.out.printf("%8s %20s %18s %18s %18s %28s\n",
				"Mã_Hàng", "Tên_Hàng", "Đơn_Giá", "Ngày_Sản_Xuất", "Ngày_Hết_Hạn", "Ghi_Chú");
		for (HangThucPham h : ds.getToanBoHang()) {
			System.out.println(h);
		}

		System.out.println("\n=== Test thêm hàng trùng mã (phải false) ===");
		boolean themTrung = ds.themHang(new HangThucPham("001", "Gạo 2", 90000, LocalDate.now(), LocalDate.now().plusDays(10)));
		System.out.println("Kết quả thêm trùng: " + themTrung);

		System.out.println("\n=== Test tìm kiếm ===");
		HangThucPham timThay = ds.timKiemHang("002");
		System.out.println(timThay != null ? "Tìm thấy: " + timThay : "Không tìm thấy");

		HangThucPham khongThay = ds.timKiemHang("999");
		System.out.println(khongThay != null ? "Tìm thấy: " + khongThay : "Không tìm thấy mã 999");

		System.out.println("\n=== Test xóa hàng ===");
		boolean xoaOk = ds.xoaHang("002");
		System.out.println("Xóa 002: " + xoaOk);
		System.out.printf("%8s %20s %18s %18s %18s %28s\n",
				"Mã_Hàng", "Tên_Hàng", "Đơn_Giá", "Ngày_Sản_Xuất", "Ngày_Hết_Hạn", "Ghi_Chú");
		for (HangThucPham h : ds.getToanBoHang()) {
			System.out.println(h);
		}

		boolean xoaThatBai = ds.xoaHang("999");
		System.out.println("Xóa mã không tồn tại 999: " + xoaThatBai);

		System.out.println("\n=== Test tự động tăng kích thước (thêm nhiều hơn 10 phần tử) ===");
		for (int i = 4; i <= 15; i++) {
			ds.themHang(new HangThucPham(String.format("%03d", i), "Hàng " + i, 1000 * i,
					LocalDate.now().minusDays(i), LocalDate.now().plusDays(i)));
		}
		System.out.printf("%8s %20s %18s %18s %18s %28s\n",
				"Mã_Hàng", "Tên_Hàng", "Đơn_Giá", "Ngày_Sản_Xuất", "Ngày_Hết_Hạn", "Ghi_Chú");
		for (HangThucPham h : ds.getToanBoHang()) {
			System.out.println(h);
		}

		System.out.println("\n=== Test các trường hợp lỗi dữ liệu đầu vào ===");
		try {
			new HangThucPham("", "Gạo", 100000, LocalDate.of(2026,1,1), LocalDate.of(2026,6,1));
		} catch (Exception e) {
			System.out.println("Lỗi 1: " + e.getMessage());
		}
		try {
			new HangThucPham("002", "", 100000, LocalDate.of(2026,1,1), LocalDate.of(2026,6,1));
		} catch (Exception e) {
			System.out.println("Lỗi 2: " + e.getMessage());
		}
		try {
			new HangThucPham("003", "Mì", -5000, LocalDate.of(2026,1,1), LocalDate.of(2026,6,1));
		} catch (Exception e) {
			System.out.println("Lỗi 3: " + e.getMessage());
		}
		try {
			new HangThucPham("004", "Trứng", 3000, LocalDate.of(2030,1,1), LocalDate.of(2030,6,1));
		} catch (Exception e) {
			System.out.println("Lỗi 4: " + e.getMessage());
		}
		try {
			new HangThucPham("005", "Nước", 10000, LocalDate.of(2026,6,1), LocalDate.of(2026,1,1));
		} catch (Exception e) {
			System.out.println("Lỗi 5: " + e.getMessage());
		}
	}

}