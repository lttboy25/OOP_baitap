import java.util.Arrays;

public class AccountList {
	private Account[] ds;
	private int soLuongHienTai;

	public AccountList() {
		ds = new Account[5];
		soLuongHienTai = 0;
	}

	public AccountList(int n) {
		ds = new Account[n];
		soLuongHienTai = 0;
	}

	private void tangKichThuoc() {
		Account[] temp = new Account[ds.length * 2];
		temp = Arrays.copyOf(ds, ds.length * 2);
		ds = temp;
	}

	public void TangKichThuocTruyenThong() {
		Account temp[] = new Account[ds.length * 2];
		for (int i = 0; i < ds.length; i++) {
			temp[i] = ds[i];
		}
		ds = temp;
	}

	public int timKiem(String accNum) {
		for (int i = 0; i < soLuongHienTai; i++) {
			if (accNum.equals(ds[i].getSoTaiKhoan()))
				return i;
		}
		return -1;
	}

	public Account timKiemTraVeobj(String accNum) {
		for (int i = 0; i < soLuongHienTai; i++) {
			if (accNum.equals(ds[i].getSoTaiKhoan()))
				return ds[i];
		}
		return null;
	}

	public boolean themTK(Account acc) {
		if (timKiem(acc.getSoTaiKhoan()) != -1)
			return false;
		if (soLuongHienTai == ds.length)
			tangKichThuoc();
		ds[soLuongHienTai++] = acc;
		return true;
	}

	public boolean xoaTK(String soTaiKhoan) {
		int viTri = timKiem(soTaiKhoan);
		if (viTri == -1)
			return false;
		for (int i = viTri; i < soLuongHienTai - 1; i++)
			ds[i] = ds[i + 1];
		soLuongHienTai--;
		return true;
	}

	public boolean suaTK(String soTaiKhoan, String tenMoi, Double soDuMoi) {
		int vt = timKiem(soTaiKhoan);
		if (vt == -1)
			return false;
		if (tenMoi != null && !tenMoi.trim().isEmpty())
			ds[vt].setTenTaiKhoan(tenMoi);
		if (soDuMoi != null && soDuMoi >= 0)
			ds[vt].setSoDu(soDuMoi);
		return true;
	}

	public Account[] getAllAcc() {
		return Arrays.copyOf(ds, soLuongHienTai);
	}

	public Account getAccByIndex(int i) {
		return ds[i];
	}

	public int getSoLuongHienTai() {
		return soLuongHienTai;
	}
}
