package chuyenxe2.ChuyenXe;

import java.util.Arrays;

public class DanhSachChuyenXe {

	private ChuyenXe[] ds;
	private int soLuongHienTai;

	public DanhSachChuyenXe() {
		this(10);
	}

	public DanhSachChuyenXe(int capacity) {
		if (capacity <= 0) {
			capacity = 10;
		}
		this.soLuongHienTai = 0;
		this.ds = new ChuyenXe[capacity];
	}

	public int size() {
		for (int i = 0; i < ds.length; i++) {
			if (ds[i] == null) {
				return i;
			}
		}
		return ds.length;
	}

	public boolean isFull() {
		return size() == ds.length;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean them(ChuyenXe xe) {
		if (xe == null) {
			return false;
		}

		for (int i = 0; i < size(); i++) {
			if (ds[i].getMaSoChuyen().equalsIgnoreCase(xe.getMaSoChuyen())) {
				return false;
			}
		}

		if (size() == ds.length) {
			int newLength = (int) (size() * 1.5) + 1;
			ds = Arrays.copyOf(ds, newLength);
		}

		ds[soLuongHienTai++] = xe;
		return true;
	}

	public int timKiemViTri(String maCX) {
		if (maCX == null || maCX.trim().isEmpty()) {
			return -1;
		}
		for (int i = 0; i < size(); i++) {
			if (ds[i].getMaSoChuyen().equalsIgnoreCase(maCX)) {
				return i;
			}
		}
		return -1;
	}

	public ChuyenXe timKiem(String maCX) {
		int vt = timKiemViTri(maCX);
		return vt == -1 ? null : ds[vt];
	}

	public boolean xoa(String maCX) {
		int vt = timKiemViTri(maCX);
		if (vt == -1) {
			return false;
		}
		for (int i = vt; i < size() - 1; i++) {
			ds[i] = ds[i + 1];
		}
		ds[size() - 1] = null;
		soLuongHienTai--;
		return true;
	}

	public boolean sua(ChuyenXe xe) {
		if (xe == null) {
			return false;
		}
		int vt = timKiemViTri(xe.getMaSoChuyen());
		if (vt == -1) {
			return false;
		}
		ds[vt] = xe;
		return true;
	}

	public double tinhDoanhThu() {
		double tong = 0.0;
		for (int i = 0; i < size(); i++) {
			tong += ds[i].getDoanhThu();
		}
		return tong;
	}

	public ChuyenXe[] sortTheoTenTaiXe() {
		if (size() == 0) {
			return null;
		}
		ChuyenXe[] list2 = Arrays.copyOf(ds, size());
		for (int i = 0; i < list2.length - 1; i++) {
			for (int j = 0; j < list2.length - 1 - i; j++) {
				if (list2[j].getHoTenTaiXe().compareToIgnoreCase(list2[j + 1].getHoTenTaiXe()) > 0) {
					ChuyenXe temp = list2[j];
					list2[j] = list2[j + 1];
					list2[j + 1] = temp;
				}
			}
		}
		return list2;
	}

	public ChuyenXe[] sortTheoDoanhThu() {
		if (size() == 0) {
			return null;
		}
		ChuyenXe[] list2 = Arrays.copyOf(ds, size());
		for (int i = 0; i < list2.length - 1; i++) {
			for (int j = 0; j < list2.length - 1 - i; j++) {
				if (list2[j].getDoanhThu() > list2[j + 1].getDoanhThu()) {
					ChuyenXe temp = list2[j];
					list2[j] = list2[j + 1];
					list2[j + 1] = temp;
				}
			}
		}
		return list2;
	}

	public ChuyenXe[] sortTheo2TieuChi() {
		if (size() == 0) {
			return null;
		}
		ChuyenXe[] list2 = Arrays.copyOf(ds, size());
		for (int i = 0; i < list2.length - 1; i++) {
			for (int j = 0; j < list2.length - 1 - i; j++) {
				int comp = list2[j].getHoTenTaiXe().compareToIgnoreCase(list2[j + 1].getHoTenTaiXe());
				boolean swap = comp != 0 ? comp > 0 : list2[j].getDoanhThu() > list2[j + 1].getDoanhThu();
				if (swap) {
					ChuyenXe temp = list2[j];
					list2[j] = list2[j + 1];
					list2[j + 1] = temp;
				}
			}
		}
		return list2;
	}

	public ChuyenXeNoiThanh[] getDSXeNoiThanh() {
		int count = 0;
		for (int i = 0; i < size(); i++) {
			if (ds[i] instanceof ChuyenXeNoiThanh) {
				count++;
			}
		}
		ChuyenXeNoiThanh[] result = new ChuyenXeNoiThanh[count];
		int idx = 0;
		for (int i = 0; i < size(); i++) {
			if (ds[i] instanceof ChuyenXeNoiThanh) {
				result[idx++] = (ChuyenXeNoiThanh) ds[i];
			}
		}
		return result;
	}

	public ChuyenXeNgoaiThanh[] getDSXeNgoaiThanh() {
		int count = 0;
		for (int i = 0; i < size(); i++) {
			if (ds[i] instanceof ChuyenXeNgoaiThanh) {
				count++;
			}
		}
		ChuyenXeNgoaiThanh[] result = new ChuyenXeNgoaiThanh[count];
		int idx = 0;
		for (int i = 0; i < size(); i++) {
			if (ds[i] instanceof ChuyenXeNgoaiThanh) {
				result[idx++] = (ChuyenXeNgoaiThanh) ds[i];
			}
		}
		return result;
	}

	public ChuyenXe[] getDS() {
		if (size() == 0) {
			return null;
		}
		return Arrays.copyOf(ds, size());
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < size(); i++) {
			s += ds[i].toString() + "\n";
		}
		return s;
	}

}
