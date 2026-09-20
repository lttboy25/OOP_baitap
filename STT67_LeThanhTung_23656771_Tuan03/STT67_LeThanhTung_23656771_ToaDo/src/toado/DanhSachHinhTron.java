package toado;

import java.util.Arrays;
import java.util.Comparator;

public class DanhSachHinhTron {

	private HinhTron[] dsHT;
	private int dem = 0;

	public DanhSachHinhTron(int n) {
		if (n < 0)
			throw new RuntimeException("Kích thước mảng phải > 0");
		dsHT = new HinhTron[n];
	}

	public void themHinhTron(HinhTron ht) {
		if (ht == null)
			throw new RuntimeException("Hình tròn phải khác null");

		// kiểm tra trùng tên tâm
		for (int i = 0; i < dem; i++) {
			HinhTron temp = dsHT[i];
			if (ht.getTam().getTen().equals(temp.getTam().getTen()))
				throw new RuntimeException("Trùng tên tâm hình tròn");
		}

		// kiểm tra mảng có đầy không
		if (dem == dsHT.length) {
			// Tăng kích thước mảng lên 1.5 lần
			int newLength = (int) (dsHT.length * 1.5);
			HinhTron[] temp = new HinhTron[newLength];
			for (int i = 0; i < dsHT.length; i++) {
				temp[i] = dsHT[i];
			}

			dsHT = temp;
		}

		// thêm thành công
		dsHT[dem++] = ht;
	}

	public HinhTron[] getDSHT() {
		return dsHT;
	}

	public void xoaHinhTron(String tenTam) {
		int index = timHinhTron(tenTam);
		if (index >= 0) {
			for (int i = index; i < dem - 1; i++) {
				dsHT[i] = dsHT[i + 1];
			}

			dsHT[dem - 1] = null;

			dem--;
		}
	}

	private int timHinhTron(String tenTam) {
		for (int i = 0; i < dem; i++) {
			HinhTron temp = dsHT[i];
			if (temp.getTam().getTen().equals(tenTam))
				return i;
		}
		return -1;
	}

	// Tìm và trả về HinhTron (dùng cho chức năng menu số 4)
	public HinhTron timKiemHinhTron(String tenTam) {
		int index = timHinhTron(tenTam);
		return index >= 0 ? dsHT[index] : null;
	}

	public HinhTron[] sapXepDSHTTheoDienTich() {
		HinhTron[] temp = Arrays.copyOf(dsHT, dem);

		Arrays.sort(temp, new Comparator<HinhTron>() {
			@Override
			public int compare(HinhTron o1, HinhTron o2) {
				return Double.compare(o2.tinhDienTich(), o1.tinhDienTich());
			}
		});

		return temp;
	}

	public HinhTron[] sapXepDSHTTheoTenTam() {
		HinhTron[] temp = Arrays.copyOf(dsHT, dem);

		Arrays.sort(temp, new Comparator<HinhTron>() {
			@Override
			public int compare(HinhTron o1, HinhTron o2) {
				return o1.getTam().getTen().compareToIgnoreCase(o2.getTam().getTen());
			}
		});

		return temp;
	}

}
