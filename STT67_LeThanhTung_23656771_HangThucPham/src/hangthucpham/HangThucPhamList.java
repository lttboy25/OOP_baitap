package hangthucpham;

import java.util.Arrays;

public class HangThucPhamList {
	private HangThucPham[] ds;
	private int soLuongHienTai;

	public HangThucPhamList() {
		ds = new HangThucPham[10];
	}

	public HangThucPhamList(int n) {
		if (n <= 0) {
			ds = new HangThucPham[10];
		} else {
			ds = new HangThucPham[n];
		}
	}

	private void tangKichThuoc() {
		int kichThuocMoi = (int) (ds.length * 1.5);
		ds = Arrays.copyOf(ds, kichThuocMoi);
	}

	public HangThucPham timKiemHang(String maHang) {
		for (int i = 0; i < soLuongHienTai; i++) {
			if (ds[i].getMaHang().equals(maHang)) {
				return ds[i];
			}
		}
		return null;
	}

	public boolean themHang(HangThucPham hangThucPham) {
		if (timKiemHang(hangThucPham.getMaHang()) != null) {
			return false;
		}
		if (soLuongHienTai == ds.length) {
			tangKichThuoc();
		}
		ds[soLuongHienTai++] = hangThucPham;
		return true;
	}

	public boolean xoaHang(String maHang) {
		for (int i = 0; i < soLuongHienTai; i++) {
			if (maHang.equals(ds[i].getMaHang())) {
				for (int j = i; j < soLuongHienTai - 1; j++) {
					ds[j] = ds[j + 1];
				}
				ds[soLuongHienTai - 1] = null;
				soLuongHienTai--;
				return true;
			}
		}
		return false;
	}

	public HangThucPham[] getToanBoHang() {
		return Arrays.copyOf(ds, soLuongHienTai);
	}
}