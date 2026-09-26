package iuh.fit.oop.week4.ex10;

import java.util.Scanner;

public class CDTesting {

	private static void printList(CD[] arr) {
		if (arr == null || arr.length == 0) {
			System.out.println("(Danh sách trống)");
			return;
		}
		System.out.println(String.format("%-6s | %-20s | %10s | %15s", "Mã", "Tựa CD", "Số bài", "Giá bán"));
		for (CD cd : arr) {
			System.out.println(cd);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CDList list = new CDList();
		int chon = -1;

		do {
			System.out.println("\n===== MENU QUẢN LÝ CD =====");
			System.out.println("1. Thêm CD");
			System.out.println("2. Xem danh sách CD");
			System.out.println("3. Đếm số lượng CD");
			System.out.println("4. Tính giá bán trung bình (CD thường)");
			System.out.println("5. Tìm CD theo mã");
			System.out.println("6. Sắp xếp tăng theo số bài hát, giảm theo tựa");
			System.out.println("7. Tìm CD theo tựa (từ khóa)");
			System.out.println("8. Tìm CD có giá cao nhất");
			System.out.println("9. Thêm cứng 6 CD mẫu");
			System.out.println("10. Xóa CD theo mã");
			System.out.println("11. Cập nhật CD theo mã");
			System.out.println("12. Xóa CD theo tựa (xóa tất cả CD cùng tựa)");
			System.out.println("0. Thoát");
			System.out.print("Chọn: ");

			try {
				chon = Integer.parseInt(sc.nextLine().trim());

				switch (chon) {
				case 1: {
					System.out.print("Mã CD: ");
					int code = Integer.parseInt(sc.nextLine().trim());
					System.out.print("Tựa CD: ");
					String title = sc.nextLine();
					System.out.print("Số bài hát: ");
					int songs = Integer.parseInt(sc.nextLine().trim());
					System.out.print("Giá thành: ");
					double price = Double.parseDouble(sc.nextLine().trim());
					System.out.print("Loại (1. Thường, 2. Sang): ");
					CDType type = sc.nextLine().trim().equals("2") ? CDType.PREMIUM : CDType.NORMAL;

					CD cd = new CD(code, title, songs, price, type);
					System.out.println(list.addCD(cd) ? "Thêm thành công!" : "Thêm thất bại (trùng mã)!");
					break;
				}

				case 2:
					printList(list.getList());
					break;

				case 3:
					System.out.println("Số lượng CD: " + list.size());
					break;

				case 4:
					System.out.printf("Giá bán trung bình (CD thường): %,.2f VND%n", list.calculteSalePriceAverage());
					break;

				case 5: {
					System.out.print("Nhập mã CD cần tìm: ");
					int code = Integer.parseInt(sc.nextLine().trim());
					CD found = list.findCDByCode(code);
					System.out.println(found != null ? found : "Không tìm thấy!");
					break;
				}

				case 6:
					printList(list.sortNumSongsAsc_TitleDesc());
					break;

				case 7:
					System.out.print("Nhập từ khóa tựa: ");
					printList(list.findCDListByTitle(sc.nextLine().trim()));
					break;

				case 8:
					printList(list.findCDListByMaxPrice());
					break;

				case 9:
					list.addCD(new CD(1, "Nhat Ky Cua Me", 10, 50000, CDType.NORMAL));
					list.addCD(new CD(2, "Chuyen Tinh", 8, 45000, CDType.NORMAL));
					list.addCD(new CD(3, "Mua Xuan", 12, 60000, CDType.PREMIUM));
					list.addCD(new CD(4, "Chuyen Tinh", 9, 35000, CDType.NORMAL)); // trùng tựa với mã 2
					list.addCD(new CD(5, "Hoang Hon", 11, 55000, CDType.NORMAL));
					list.addCD(new CD(6, "Chuyen Tinh", 15, 70000, CDType.PREMIUM)); // trùng tựa với mã 2, 4
					System.out.println("Đã thêm 6 CD mẫu (mã 2, 4, 6 cùng tựa \"Chuyen Tinh\")!");
					break;

				case 10: {
					System.out.print("Nhập mã CD cần xóa: ");
					int code = Integer.parseInt(sc.nextLine().trim());
					System.out.println(list.removeCD(code) ? "Xóa thành công!" : "Mã không tồn tại!");
					break;
				}

				case 11: {
					System.out.print("Nhập mã CD cần sửa: ");
					int code = Integer.parseInt(sc.nextLine().trim());
					CD target = list.findCDByCode(code);
					if (target == null) {
						System.out.println("Mã không tồn tại để cập nhật!");
						break;
					}
					System.out.print("Tựa CD mới: ");
					String titleNew = sc.nextLine();
					System.out.print("Số bài hát mới: ");
					int songsNew = Integer.parseInt(sc.nextLine().trim());
					System.out.print("Giá thành mới: ");
					double priceNew = Double.parseDouble(sc.nextLine().trim());
					System.out.print("Loại mới (1. Thường, 2. Sang): ");
					CDType typeNew = sc.nextLine().trim().equals("2") ? CDType.PREMIUM : CDType.NORMAL;

					// CDList lưu tham chiếu nên sửa trực tiếp qua setter (mã là final nên giữ nguyên)
					target.setTitle(titleNew);
					target.setNumSongs(songsNew);
					target.setPrice(priceNew);
					target.setType(typeNew);
					System.out.println("Cập nhật thành công!");
					break;
				}

				case 12: {
					System.out.print("Nhập tựa CD cần xóa: ");
					String title = sc.nextLine();
					System.out.println(list.removeCDByTitle(title) ? "Xóa thành công!"
							: "Không có CD nào có tựa này!");
					break;
				}

				case 0:
					System.out.println("Tạm biệt!");
					break;

				default:
					System.out.println("Lựa chọn không hợp lệ!");
				}
			} catch (RuntimeException e) {
				chon = -1; // tránh thoát nhầm khi nhập sai
				System.out.println("Lỗi: " + e.getMessage());
			}
		} while (chon != 0);

		sc.close();
	}
}