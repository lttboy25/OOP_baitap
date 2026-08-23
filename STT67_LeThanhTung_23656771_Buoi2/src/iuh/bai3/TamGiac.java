package iuh.bai3;

public class TamGiac {
	private float ma, mb, mc;

	private boolean isHopLe(float a, float b, float c) {
		return a > 0 && b > 0 && c > 0
				&& a + b > c && a + c > b && b + c > a;
	}

	public float getMa() {
		return ma;
	}

	public void setMa(float ma) {
		if (ma < 0 || !isHopLe(ma, mb, mc)) {
			return;
		}
		this.ma = ma;
	}

	public float getMb() {
		return mb;
	}

	public void setMb(float mb) {
		if (mb < 0 || !isHopLe(ma, mb, mc)) {
			return;
		}
		this.mb = mb;
	}

	public float getMc() {
		return mc;
	}

	public void setMc(float mc) {
		if (mc < 0 || !isHopLe(ma, mb, mc)) {
			return;
		}
		this.mc = mc;
	}

	public TamGiac(float ma, float mb, float mc) {
		super();
		if (ma < 0 || mb < 0 || mc < 0 || !isHopLe(ma, mb, mc)) {
			this.ma = 0;
			this.mb = 0;
			this.mc = 0;
		} else {
			this.ma = ma;
			this.mb = mb;
			this.mc = mc;
		}
	}

	public TamGiac() {

	}

	public float tinhChuVi() {
		return ma + mb + mc;
	}

	public double tinhDienTich() {
		double p = tinhChuVi() / 2.0;
		return Math.sqrt(p * (p - ma) * (p - mb) * (p - mc));
	}

	public String loaiTamGiac() {
		if (!isHopLe(ma, mb, mc)) {
			return "Khong phai tam giac";
		}
		if (ma == mb && mb == mc) {
			return "Tam giac deu";
		}
		if (ma == mb || mb == mc || ma == mc) {
			return "Tam giac can";
		}
		return "Tam giac thuong";
	}
	

	@Override
	public String toString() {
		return "TamGiac [ma=" + ma + ", mb=" + mb + ", mc=" + mc
				+ ", loai=" + loaiTamGiac()
				+ ", chuVi=" + tinhChuVi()
				+ ", dienTich=" + tinhDienTich() + "]";
	}
}