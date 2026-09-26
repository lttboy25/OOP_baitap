package chuyenxe2.ChuyenXe;

import java.util.Scanner;

public class DanhSachChuyenXeTesting {

	private static void printList(ChuyenXe[] arr) {
		if (arr == null || arr.length == 0) {
			System.out.println("(Danh sách trống)");
			return;
		}
		System.out.println(String.format("%-8s| %-20s| %-12s| %15s", "Mã CX", "Tài xế", "Số xe", "Doanh thu"));
		for (ChuyenXe xe : arr) {
			System.out.println(xe);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DanhSachChuyenXe list = new DanhSachChuyenXe();
		int chon = -1;

		do {
			System.out.println("\n===== MENU QUẢN LÝ CHUYẾN XE =====");
			System.out.println("1. Thêm chuyến xe nội thành");
			System.out.println("2. Thêm chuyến xe ngoại thành");
			System.out.println("3. Xem danh sách chuyến xe");
			System.out.println("4. Đếm số lượng chuyến xe");
			System.out.println("5. Tính tổng doanh thu");
			System.out.println("6. Tìm chuyến xe theo mã");
			System.out.println("7. Xóa chuyến xe theo mã");
			System.out.println("8. Sắp xếp theo tên tài xế");
			System.out.println("9. Sắp xếp theo doanh thu");
			System.out.println("10. Sắp xếp theo 2 tiêu chí (tên + doanh thu)");
			System.out.println("11. Xem danh sách xe nội thành");
			System.out.println("12. Xem danh sách xe ngoại thành");
			System.out.println("13. Thêm cứng dữ liệu mẫu");
			System.out.println("0. Thoát");
			System.out.print("Chọn: ");

			try {
				chon = Integer.parseInt(sc.nextLine().trim());

				switch (chon) {
				case 1: {
					System.out.print("Mã chuyến xe: ");
					String ma = sc.nextLine().trim();
					System.out.print("Tên tài xế: ");
					String ten = sc.nextLine();
					System.out.print("Số xe: ");
					String soXe = sc.nextLine();
					System.out.print("Doanh thu: ");
					double doanhThu = Double.parseDouble(sc.nextLine().trim());
					System.out.print("Số tuyến: ");
					int st = Integer.parseInt(sc.nextLine().trim());
					System.out.print("Số km: ");
					double km = Double.parseDouble(sc.nextLine().trim());

					ChuyenXe xe = new ChuyenXeNoiThanh(ma, ten, soXe, doanhThu, st, km);
					System.out.println(list.them(xe) ? "Thêm thành công!" : "Thêm thất bại (trùng mã)!");
					break;
				}

				case 2: {
					System.out.print("Mã chuyến xe: ");
					String ma = sc.nextLine().trim();
					System.out.print("Tên tài xế: ");
					String ten = sc.nextLine();
					System.out.print("Số xe: ");
					String soXe = sc.nextLine();
					System.out.print("Doanh thu: ");
					double doanhThu = Double.parseDouble(sc.nextLine().trim());
					System.out.print("Nơi đến: ");
					String noiDen = sc.nextLine();
					System.out.print("Số ngày: ");
					int soNgay = Integer.parseInt(sc.nextLine().trim());

					ChuyenXe xe = new ChuyenXeNgoaiThanh(ma, ten, soXe, doanhThu, noiDen, soNgay);
					System.out.println(list.them(xe) ? "Thêm thành công!" : "Thêm thất bại (trùng mã)!");
					break;
				}

				case 3:
					printList(list.getDS());
					break;

				case 4:
					System.out.println("Số lượng chuyến xe: " + list.size());
					break;

				case 5:
					System.out.printf("Tổng doanh thu: %,.0f VND%n", list.tinhDoanhThu());
					break;

				case 6: {
					System.out.print("Nhập mã chuyến xe cần tìm: ");
					String ma = sc.nextLine().trim();
					ChuyenXe found = list.timKiem(ma);
					System.out.println(found != null ? found : "Không tìm thấy!");
					break;
				}

				case 7: {
					System.out.print("Nhập mã chuyến xe cần xóa: ");
					String ma = sc.nextLine().trim();
					System.out.println(list.xoa(ma) ? "Xóa thành công!" : "Không tìm thấy để xóa!");
					break;
				}

				case 8:
					printList(list.sortTheoTenTaiXe());
					break;

				case 9:
					printList(list.sortTheoDoanhThu());
					break;

				case 10:
					printList(list.sortTheo2TieuChi());
					break;

				case 11:
					printList(list.getDSXeNoiThanh());
					break;

				case 12:
					printList(list.getDSXeNgoaiThanh());
					break;

				case 13:
					list.them(new ChuyenXeNoiThanh("CX01", "Nguyen Van A", "51A-12345", 500000, 5, 20));
					list.them(new ChuyenXeNoiThanh("CX02", "Tran Thi B", "51A-54321", 450000, 3, 15));
					list.them(new ChuyenXeNgoaiThanh("CX03", "Le Van C", "51B-11111", 1200000, "Vung Tau", 2));
					list.them(new ChuyenXeNgoaiThanh("CX04", "Pham Thi D", "51B-22222", 1500000, "Da Lat", 3));
					list.them(new ChuyenXeNoiThanh("CX05", "Hoang Van E", "51A-99999", 300000, 2, 10));
					System.out.println("Đã thêm dữ liệu mẫu!");
					break;

				case 0:
					System.out.println("Tạm biệt!");
					break;

				default:
					System.out.println("Lựa chọn không hợp lệ!");
				}
			} catch (RuntimeException e) {
				chon = -1;
				System.out.println("Lỗi: " + e.getMessage());
			}
		} while (chon != 0);

		sc.close();
	}
}
