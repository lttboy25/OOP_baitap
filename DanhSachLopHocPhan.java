package lophocphan;

import java.util.Arrays;
import java.util.Comparator;

public class DanhSachLopHocPhan {

	private LopHocPhan[] dsLHP;
	private int dem = 0;

	public DanhSachLopHocPhan(int n) {
		if (n < 0)
			throw new RuntimeException("Kích thước mảng phải > 0");
		dsLHP = new LopHocPhan[n];
	}

	public void themLopHocPhan(LopHocPhan lhp) {
		if (lhp == null)
			throw new RuntimeException("Lớp học phần phải khác null");

		// kiểm tra trùng mã LHP
		for (int i = 0; i < dem; i++) {
			LopHocPhan temp = dsLHP[i];
			if (lhp.getMaLHP().equals(temp.getMaLHP()))
				throw new RuntimeException("Trùng mã lớp học phần");
		}

		// kiểm tra mảng có đầy không
		if (dem == dsLHP.length) {
			// Tăng kích thước mảng lên 1.5 lần
			int newLength = (int) (dsLHP.length * 1.5);
			LopHocPhan[] temp = new LopHocPhan[newLength];
			for (int i = 0; i < dsLHP.length; i++) {
				temp[i] = dsLHP[i];
			}

			dsLHP = temp;
		}

		// thêm thành công
		dsLHP[dem++] = lhp;
	}

	public LopHocPhan[] getDSLHP() {
		return dsLHP;
	}

	public void xoaLopHocPhan(String maLHP) {
		int index = timLopHocPhan(maLHP);
		if (index >= 0) {
			for (int i = index; i < dem - 1; i++) {
				dsLHP[i] = dsLHP[i + 1];
			}

			dsLHP[dem - 1] = null;

			dem--;
		}
	}

	private int timLopHocPhan(String maLHP) {
		for (int i = 0; i < dem; i++) {
			LopHocPhan temp = dsLHP[i];
			if (temp.getMaLHP().equals(maLHP))
				return i;
		}
		return -1;
	}

	// Tìm và trả về LopHocPhan (dùng cho chức năng menu số 4)
	public LopHocPhan timKiemLopHocPhan(String maLHP) {
		int index = timLopHocPhan(maLHP);
		return index >= 0 ? dsLHP[index] : null;
	}

	public LopHocPhan[] sapXepDSLHPTheoTenLHP() {
		LopHocPhan[] temp = Arrays.copyOf(dsLHP, dem);

		Arrays.sort(temp, new Comparator<LopHocPhan>() {
			@Override
			public int compare(LopHocPhan o1, LopHocPhan o2) {
				return o1.getTenLHP().compareToIgnoreCase(o2.getTenLHP());
			}
		});

		return temp;
	}

	public LopHocPhan[] sapXepDSLHPTheoSoLuongSV() {
		LopHocPhan[] temp = Arrays.copyOf(dsLHP, dem);

		Arrays.sort(temp, new Comparator<LopHocPhan>() {
			@Override
			public int compare(LopHocPhan o1, LopHocPhan o2) {
				return Integer.compare(o2.getSoLuongSV(), o1.getSoLuongSV());
			}
		});

		return temp;
	}

}
