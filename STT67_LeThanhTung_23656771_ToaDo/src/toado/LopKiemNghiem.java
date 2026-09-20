package toado;

import java.util.Scanner;

public class LopKiemNghiem {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DanhSachHinhTron dsHT = new DanhSachHinhTron(4);

		khoiTaoDuLieu(dsHT);

		int chon = 0;

		do {
			System.out.println("Moi ban chon:\n"
					+ "1. Them hinh tron\n"
					+ "2. Xoa hinh tron\n"
					+ "3. In danh sach hinh tron\n"
					+ "4. Tim hinh tron theo ten tam\n"
					+ "5. Sap xep theo dien tich\n"
					+ "6. Sap xep theo ten tam\n");

			chon = sc.nextInt();

			switch (chon) {
			case 1 -> {
				sc.nextLine();
				System.out.println("Nhap ten tam: ");
				String ten = sc.nextLine();

				System.out.println("Nhap x: ");
				float x = sc.nextFloat();

				System.out.println("Nhap y: ");
				float y = sc.nextFloat();

				System.out.println("Nhap ban kinh: ");
				double banKinh = sc.nextDouble();

				ToaDo tam = new ToaDo(ten, x, y);
				HinhTron ht = new HinhTron(tam, banKinh);

				dsHT.themHinhTron(ht);
			}
			case 2 -> {
				sc.nextLine();
				System.out.println("Nhap ten tam can xoa: ");
				String ten = sc.nextLine();
				dsHT.xoaHinhTron(ten);
			}
			case 3 -> {
				HinhTron[] temp = dsHT.getDSHT();
				for (HinhTron ht : temp)
					if (ht != null)
						System.out.println(ht);
			}
			case 4 -> {
				sc.nextLine();
				System.out.println("Nhap ten tam can tim: ");
				String ten = sc.nextLine();
				HinhTron ht = dsHT.timKiemHinhTron(ten);
				System.out.println(ht != null ? ht : "Khong tim thay hinh tron co tam ten " + ten);
			}
			case 5 -> {
				HinhTron[] temp = dsHT.sapXepDSHTTheoDienTich();
				for (HinhTron ht : temp)
					System.out.println(ht);
			}
			case 6 -> {
				HinhTron[] temp = dsHT.sapXepDSHTTheoTenTam();
				for (HinhTron ht : temp)
					System.out.println(ht);
			}
			}

		} while (chon > 0);

		sc.close();
	}

	private static void khoiTaoDuLieu(DanhSachHinhTron dsHT) {
		dsHT.themHinhTron(new HinhTron(new ToaDo("P", 5, 5), 10.5));
		dsHT.themHinhTron(new HinhTron(new ToaDo("Q", 2, 3), 4.0));
		dsHT.themHinhTron(new HinhTron(new ToaDo("R", 0, 0), 7.2));
		dsHT.themHinhTron(new HinhTron(new ToaDo("S", 1, 1), 6.0));
	}
}
