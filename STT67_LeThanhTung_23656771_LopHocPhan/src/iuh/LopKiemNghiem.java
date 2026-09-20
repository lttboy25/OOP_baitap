package iuh;

import java.util.Scanner;

public class LopKiemNghiem {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DanhSachLopHocPhan dsLHP = new DanhSachLopHocPhan(4);

		khoiTaoDuLieu(dsLHP);

		int chon = 0;

		do {
			System.out.println("Moi ban chon:\n"
					+ "1. Them lop hoc phan\n"
					+ "2. Xoa lop hoc phan\n"
					+ "3. In danh sach lop hoc phan\n"
					+ "4. Tim lop hoc phan theo ma LHP\n"
					+ "5. Sap xep theo ten LHP\n"
					+ "6. Sap xep theo so luong sinh vien\n");

			chon = sc.nextInt();

			switch (chon) {
			case 1 -> {
				sc.nextLine();
				System.out.println("Nhap ma LHP: ");
				String maLHP = sc.nextLine();

				System.out.println("Nhap ten LHP: ");
				String tenLHP = sc.nextLine();

				System.out.println("Nhap ten giao vien: ");
				String tenGV = sc.nextLine();

				System.out.println("Nhap thong tin lop hoc: ");
				String thongTin = sc.nextLine();

				System.out.println("Nhap so luong sinh vien: ");
				int soLuongSV = sc.nextInt();
				sc.nextLine();

				SinhVien[] dsSV = new SinhVien[soLuongSV];
				for (int i = 0; i < soLuongSV; i++) {
					System.out.println("Nhap ma SV thu " + (i + 1) + ": ");
					String maSV = sc.nextLine();

					System.out.println("Nhap ho ten SV thu " + (i + 1) + ": ");
					String hoTen = sc.nextLine();

					dsSV[i] = new SinhVien(maSV, hoTen);
				}

				LopHocPhan lhp = new LopHocPhan(maLHP, tenLHP, tenGV, thongTin, dsSV);
				dsLHP.themLopHocPhan(lhp);
			}
			case 2 -> {
				sc.nextLine();
				System.out.println("Nhap ma LHP can xoa: ");
				String maLHP = sc.nextLine();
				dsLHP.xoaLopHocPhan(maLHP);
			}
			case 3 -> {
				LopHocPhan[] temp = dsLHP.getDSLHP();
				for (LopHocPhan lhp : temp)
					if (lhp != null) {
						System.out.println(lhp);
						System.out.println("Tong so sinh vien: " + lhp.getSoLuongSV());
						System.out.println("---------------------------");
					}
			}
			case 4 -> {
				sc.nextLine();
				System.out.println("Nhap ma LHP can tim: ");
				String maLHP = sc.nextLine();
				LopHocPhan lhp = dsLHP.timKiemLopHocPhan(maLHP);
				System.out.println(lhp != null ? lhp : "Khong tim thay lop hoc phan co ma " + maLHP);
			}
			case 5 -> {
				LopHocPhan[] temp = dsLHP.sapXepDSLHPTheoTenLHP();
				for (LopHocPhan lhp : temp)
					System.out.println(lhp);
			}
			case 6 -> {
				LopHocPhan[] temp = dsLHP.sapXepDSLHPTheoSoLuongSV();
				for (LopHocPhan lhp : temp)
					System.out.println(lhp + "\nTong so sinh vien: " + lhp.getSoLuongSV());
			}
			}

		} while (chon > 0);

		sc.close();
	}

	private static void khoiTaoDuLieu(DanhSachLopHocPhan dsLHP) {
		SinhVien[] dsSV1 = {
				new SinhVien("123", "Nguyen Van A"),
				new SinhVien("543", "Le Thi B"),
				new SinhVien("321", "Luong Van C")
		};
		dsLHP.themLopHocPhan(new LopHocPhan("123456", "LT Huong doi tuong", "Co Ha",
				"Thu 7, tiet 4-6, phong A1.1", dsSV1));

		SinhVien[] dsSV2 = {
				new SinhVien("111", "Tran Van D"),
				new SinhVien("222", "Pham Thi E")
		};
		dsLHP.themLopHocPhan(new LopHocPhan("789012", "Cau truc du lieu", "Thay Nam",
				"Thu 3, tiet 1-3, phong B2.2", dsSV2));

		SinhVien[] dsSV3 = {
				new SinhVien("333", "Vo Van F"),
				new SinhVien("444", "Ngo Thi G"),
				new SinhVien("555", "Bui Van H"),
				new SinhVien("666", "Ly Thi I")
		};
		dsLHP.themLopHocPhan(new LopHocPhan("345678", "Java co ban", "Co Lan",
				"Thu 5, tiet 7-9, phong C3.3", dsSV3));
	}
}
