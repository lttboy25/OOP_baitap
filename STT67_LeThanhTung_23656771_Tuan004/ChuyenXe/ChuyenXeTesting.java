package ChuyenXe;

public class ChuyenXeTesting {
	private static void print(String title, Iterable<ChuyenXe> list) {
		System.out.println("\n=== " + title + " ===");
		for (ChuyenXe c : list)
			System.out.println(c);
	}

	public static void main(String[] args) {
		DSCX ds = new DSCX();

		try {
			ds.addTrip(new NoiThanh("NT01", "Nguyen Van A", "51A-111", 2000000, 5, 30));
			ds.addTrip(new NoiThanh("NT02", "Tran Van B", "51A-222", 2500000, 7, 40));
			ds.addTrip(new NgoaiThanh("NgT01", "Le Van C", "51B-333", 5000000, "Vũng Tàu", 2));
			ds.addTrip(new NgoaiThanh("NgT02", "Pham Van D", "51B-444", 6000000, "Đà Lạt", 3));
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
		}

		// Thêm trùng mã
		try {
			ds.addTrip(new NoiThanh("nt01", "Hoang Van E", "51A-555", 1000000, 3, 10));
		} catch (Exception e) {
			System.out.println("Thêm trùng: " + e.getMessage());
		}

		print("DANH SÁCH CHUYẾN XE", ds.getList());

		System.out.println("\nTổng số chuyến: " + ds.countTrip());
		System.out.println("Số chuyến nội thành: " + ds.countTripNT());
		System.out.println("Số chuyến ngoại thành: " + ds.countTripNGT());
		System.out.printf("Tổng doanh thu: %,.2f VND%n", ds.totalRevenue());

		print("CHUYẾN NỘI THÀNH", ds.getListNoiThanh());
		print("CHUYẾN NGOẠI THÀNH", ds.getListNgoaiThanh());

		ds.sortByRevenue();
		print("SẮP XẾP THEO DOANH THU GIẢM DẦN", ds.getList());

		ds.sortByDriverName();
		print("SẮP XẾP THEO TÊN TÀI XẾ", ds.getList());

		ds.sortByTwoFieds();
		print("SẮP XẾP THEO TÊN TÀI XẾ, DOANH THU GIẢM DẦN", ds.getList());

		// Tìm kiếm
		ChuyenXe found = ds.search("ngt02");
		System.out.println("\nTìm NgT02: " + (found != null ? found : "Không tìm thấy"));
		System.out.println("Vị trí NgT02: " + ds.searchPosition("NgT02"));

		// Sửa
		ds.modify(new NgoaiThanh("NgT02", "Pham Van D", "51B-444", 7500000, "Nha Trang", 4));
		System.out.println("\nSau khi sửa NgT02: " + ds.search("NgT02"));

		// Xóa
		ds.deleteTrip(ds.search("NT01"));
		print("SAU KHI XÓA NT01", ds.getList());
	}
}
