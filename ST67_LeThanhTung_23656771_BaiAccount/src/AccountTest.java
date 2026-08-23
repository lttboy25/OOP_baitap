import java.util.Scanner;

public class AccountTest {
	static AccountList ds = new AccountList();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int chon;
		do {
			menu();
			System.out.print("Nhập lựa chọn: ");
			chon = sc.nextInt();
			sc.nextLine();
			switch (chon) {
				case 1 -> themCung();
				case 2 -> themTaiKhoan();
				case 3 -> xoaTaiKhoan();
				case 4 -> giaoDich();
				case 5 -> timKiem();
				case 6 -> xuatDanhSach();
				case 7 -> suaThongTin();
				case 8 -> System.out.println("Đã thoát chương trình.");
				default -> System.out.println("Lựa chọn không hợp lệ!");
			}
		} while (chon != 8);
		sc.close();
	}

	static void menu() {
		System.out.println("\n===== CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN =====");
		System.out.println("1. Nhập cứng");
		System.out.println("2. Thêm tài khoản");
		System.out.println("3. Xóa tài khoản");
		System.out.println("4. Giao dịch");
		System.out.println("5. Tìm kiếm");
		System.out.println("6. Xuất danh sách");
		System.out.println("7. Sửa thông tin tài khoản");
		System.out.println("8. Thoát");
	}

	static void themCung() {
		ds.themTK(new Account("1234", "A", 100000));
		ds.themTK(new Account("1235", "B", 150000));
		ds.themTK(new Account("1236", "C", 200000));
		System.out.println("Đã thêm 3 tài khoản mẫu.");
	}

	static Account taoDoiTuong() {
		Account acc;
		System.out.print("Nhập số tài khoản: ");
		String stk = sc.nextLine();
		System.out.print("Nhập tên tài khoản: ");
		String ttk = sc.nextLine();
		System.out.print("Nhập số dư ban đầu: ");
		double sd = sc.nextDouble();
		sc.nextLine();
		acc = new Account(stk, ttk, sd);
		return acc;
	}

	static void themTaiKhoan() {
		Account acc = taoDoiTuong();
		if (ds.themTK(acc))
			System.out.println("Thêm tài khoản thành công.");
		else
			System.out.println("Số tài khoản đã tồn tại!");
	}

	static void xoaTaiKhoan() {
		System.out.print("Nhập số tài khoản cần xóa: ");
		String stk = sc.nextLine();
		if (ds.xoaTK(stk))
			System.out.println("Xóa thành công.");
		else
			System.out.println("Không tìm thấy tài khoản!");
	}

	static void timKiem() {
		System.out.print("Nhập số tài khoản cần tìm: ");
		String stk = sc.nextLine();
		Account acc = ds.timKiemTraVeobj(stk);
		if (acc != null)
			System.out.println(acc);
		else
			System.out.println("Không tìm thấy tài khoản!");
	}

	static void xuatDanhSach() {
		Account[] all = ds.getAllAcc();
		if (all.length == 0) {
			System.out.println("Danh sách trống.");
			return;
		}
		System.out.println(String.format("%-13s %-20s %-15s", "Số TK", "Tên TK", "Số dư"));
		for (Account acc : all)
			System.out.println(acc);
	}

	static void suaThongTin() {
		System.out.print("Nhập số tài khoản cần sửa: ");
		String stk = sc.nextLine();
		if (ds.timKiem(stk) == -1) {
			System.out.println("Không tìm thấy tài khoản!");
			return;
		}
		System.out.print("Nhập tên mới (Enter để bỏ qua): ");
		String tenMoi = sc.nextLine();
		System.out.print("Nhập số dư mới (nhập -1 để bỏ qua): ");
		double sdInput = sc.nextDouble();
		sc.nextLine();
		Double soDuMoi = (sdInput < 0) ? null : sdInput;
		if (ds.suaTK(stk, tenMoi.isEmpty() ? null : tenMoi, soDuMoi))
			System.out.println("Cập nhật thành công.");
		else
			System.out.println("Cập nhật thất bại.");
	}

	static void giaoDich() {
		System.out.println("1. Nạp tiền");
		System.out.println("2. Rút tiền");
		System.out.println("3. Chuyển khoản");
		System.out.println("4. Đáo hạn (tính lãi)");
		System.out.print("Chọn loại giao dịch: ");
		int loai = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhập số tài khoản: ");
		String stk = sc.nextLine();
		Account acc = ds.timKiemTraVeobj(stk);
		if (acc == null) {
			System.out.println("Không tìm thấy tài khoản!");
			return;
		}
		try {
			switch (loai) {
				case 1 -> {
					System.out.print("Nhập số tiền nạp: ");
					double tien = sc.nextDouble();
					sc.nextLine();
					acc.napTien(tien);
					System.out.println("Nạp tiền thành công. Số dư mới: " + acc.getSoDu());
				}
				case 2 -> {
					System.out.print("Nhập số tiền rút: ");
					double tien = sc.nextDouble();
					sc.nextLine();
					acc.rutTien(tien);
					System.out.println("Rút tiền thành công. Số dư mới: " + acc.getSoDu());
				}
				case 3 -> {
					System.out.print("Nhập số tài khoản nhận: ");
					String stkNhan = sc.nextLine();
					Account accNhan = ds.timKiemTraVeobj(stkNhan);
					if (accNhan == null) {
						System.out.println("Không tìm thấy tài khoản nhận!");
						return;
					}
					System.out.print("Nhập số tiền chuyển: ");
					double tien = sc.nextDouble();
					sc.nextLine();
					acc.chuyenKhoan(accNhan, tien);
					System.out.println("Chuyển khoản thành công.");
				}
				case 4 -> {
					double moi = acc.daoHan();
					System.out.println("Đáo hạn thành công. Số dư mới: " + moi);
				}
				default -> System.out.println("Lựa chọn không hợp lệ!");
			}
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
		}
	}
}
