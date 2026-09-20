package iuh;

import java.util.Arrays;
import java.util.Scanner;

public class Testing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CDList list = new CDList();
		int chon;

		do {
			System.out.println("\n===== MENU QUẢN LÝ CD =====");
			System.out.println("1. Thêm CD");
			System.out.println("2. Xem danh sách CD");
			System.out.println("3. Đếm số lượng CD");
			System.out.println("4. Tính tổng giá thành");
			System.out.println("5. Tìm CD theo mã");
			System.out.println("6. Sắp xếp giảm dần theo giá");
			System.out.println("7. Sắp xếp giảm dần theo số lượng bài hát");
			System.out.println("8. Sắp xếp tăng dần theo tựa");
			System.out.println("9. Thêm cứng 5 CD mẫu");
			System.out.println("10. Xóa 1 phần tử bằng id");
			System.out.println("11. Cập nhật 1 phần tử bằng id");
			System.out.println("0. Thoát");
			System.out.print("Chọn: ");
			chon = Integer.parseInt(sc.nextLine().trim());

			try {
				switch (chon) {
				case 1:
					System.out.print("Mã CD: ");
					int id = Integer.parseInt(sc.nextLine().trim());
					System.out.print("Tựa CD: ");
					String title = sc.nextLine();
					System.out.print("Số bài hát: ");
					int songs = Integer.parseInt(sc.nextLine().trim());
					System.out.print("Giá thành: ");
					double price = Double.parseDouble(sc.nextLine().trim());

					CD cd = new CD(id, title, songs, price);
					System.out.println(list.addCD(cd) ? "Thêm thành công!" : "Thêm thất bại (trùng mã)!");
					break;

				case 2:
					String s =String.format("%-8s| %-25s| %-10s| %10s%n", "Mã CD", "Tựa CD", "Số bài", "Giá");
					CD[] listPrint = Arrays.copyOf(list.getCDList(), list.countOfCD());
					System.out.println(s);
					for (int i = 0; i < list.countOfCD(); i++) {
						System.out.println(listPrint[i]);
					}
					break;

				case 3:
					System.out.println("Số lượng CD: " + list.countOfCD());
					break;

				case 4:
					System.out.println("Tổng giá thành: " + list.totalOfPrice());
					break;

				case 5:
					System.out.print("Nhập mã CD cần tìm: ");
					int idFind = Integer.parseInt(sc.nextLine().trim());
					CD found = list.findCDById(idFind);
					System.out.println(found != null ? found : "Không tìm thấy!");
					break;

				case 6:
					for (CD c : list.sortByPriceDesc())
						System.out.println(c);
					break;
					
				case 7:
					for (CD c : list.sortByCountOfMusicDesc())
						System.out.println(c);
					break;

				case 8:
					for (CD c : list.sortByTitle())
						System.out.println(c);
					break;

				case 9:
					list.addCD(new CD(1, "Nhat Ky Cua Me", 10, 50000));
					list.addCD(new CD(2, "Chuyen Tinh", 8, 45000));
					list.addCD(new CD(3, "Mua Xuan", 12, 60000));
					list.addCD(new CD(4, "Bien Nho", 9, 35000));
					list.addCD(new CD(5, "Hoang Hon", 11, 55000));
					System.out.println("Đã thêm 5 CD mẫu!");
					break;
					
				case 10: 
					System.out.println("Nhập vào id cần xóa");
					int idRemoved = Integer.parseInt(sc.nextLine().trim());
					if(list.findIndexCDById(idRemoved) == -1) {
						System.out.println("Mã id không tồn tại để cập nhật!");
						break;
					}
					boolean isRemoved = list.removeById(idRemoved);
					if(isRemoved) System.out.println("Bạn đã xóa thành công");
					else System.out.println("Bạn đã xóa thất bại");
				
				case 11:
					System.out.print("Nhập mã id cần sửa ");
					int idUpdated = Integer.parseInt(sc.nextLine().trim());
					if(list.findIndexCDById(idUpdated) == -1) {
						System.out.println("Mã id không tồn tại để cập nhật!");
						break;
					}
					
					System.out.print("Tựa CD: ");
					String titleNew = sc.nextLine();
					System.out.print("Số bài hát: ");
					int songsNew = Integer.parseInt(sc.nextLine().trim());
					System.out.print("Giá thành: ");
					double priceNew = Double.parseDouble(sc.nextLine().trim());

					CD cdNew = new CD(idUpdated, titleNew, songsNew, priceNew);
					System.out.println(list.updateById(cdNew) ? "Cập nhật thành công!" : "Cập nhật thất bại!");
					break;

				case 0:
					System.out.println("Tạm biệt!");
					break;

				default:
					System.out.println("Lựa chọn không hợp lệ!");
				}
			} catch (RuntimeException e) {
				System.out.println("Lỗi: " + e.getMessage());
			}
		} while (chon != 0);

		sc.close();
	}
	
}