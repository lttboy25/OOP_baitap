package iuh;

import java.time.LocalDate;

public class KiemThu {

	private static void inDanhSach(Sach[] arr) {
		if (arr == null || arr.length == 0) {
			System.out.println("(Danh sách trống)");
			return;
		}
		for (Sach s : arr) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		SachList list = new SachList();

		list.addSach(new SachGiaoKhoa("GK001", LocalDate.of(2024, 1, 10), 50000, 20, "NXB Giáo Dục", true));
		list.addSach(new SachGiaoKhoa("GK002", LocalDate.of(2024, 2, 15), 45000, 15, "NXB Giáo Dục", false));
		list.addSach(new SachGiaoKhoa("GK003", LocalDate.of(2024, 3, 20), 60000, 10, "NXB Giáo Dục", true));

		list.addSach(new SachThamKhao("TK001", LocalDate.of(2024, 1, 5), 80000, 5, "NXB Trẻ", 5000));
		list.addSach(new SachThamKhao("TK002", LocalDate.of(2024, 2, 8), 95000, 8, "NXB Trẻ", 8000));
		list.addSach(new SachThamKhao("TK003", LocalDate.of(2024, 3, 12), 70000, 12, "NXB Kim Đồng", 6000));

		System.out.println("===== DANH SÁCH SÁCH =====");
		inDanhSach(list.getList());

		System.out.println("\n===== TỔNG TIỀN =====");
		System.out.printf("Tổng tiền sách giáo khoa: %,.0f VND%n", list.tongTienGiaoKhoa());
		System.out.printf("Tổng tiền sách tham khảo: %,.0f VND%n", list.tongTienThamKhao());
		System.out.printf("Tổng tiền tất cả: %,.0f VND%n", list.tongTienTatCa());

		System.out.println("\n===== TÌM SÁCH THEO MÃ (GK002) =====");
		Sach timThay = list.findByIdBook("GK002");
		System.out.println(timThay != null ? timThay : "Không tìm thấy!");

		System.out.println("\n===== XÓA SÁCH THEO MÃ (TK001) =====");
		System.out.println(list.removeSach("TK001") ? "Xóa thành công!" : "Không tìm thấy để xóa!");
		inDanhSach(list.getList());

		System.out.println("\n===== THÊM SÁCH TRÙNG MÃ (KIỂM TRA) =====");
		boolean ketQua = list.addSach(new SachGiaoKhoa("GK001", LocalDate.now(), 10000, 1, "Test"));
		System.out.println(ketQua ? "Thêm thành công!" : "Thêm thất bại (trùng mã)!");
	}

}
