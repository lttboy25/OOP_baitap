package iuh;

public class SinhVien {
	private int mssv;
	private String ten;
	private float diemLT;
	private float diemTH;
	public int getMssv() {
		return mssv;
	}
	public void setMssv(int mssv) {
		if(mssv <= 0) {
			throw new RuntimeException("Mssv phai la so nguyen");
		}
		this.mssv = mssv;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		if(ten.equals("") || ten == null) {
			throw new RuntimeException("Ho ten la chuoi khong duoc rong");
		}
		this.ten = ten;
	}
	public float getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(float diemLT) {
		if(diemLT <0.0 || diemLT >10.0) {
			throw new RuntimeException("Diem phai la so thuc va nam trong khoang 0.0 den 10.0");
		}
		this.diemLT = diemLT;
	}
	public float getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(float diemTH) {
		if(diemTH <0.0 || diemTH >10.0) {
			throw new RuntimeException("Diem phai la so thuc va nam trong khoang 0.0 den 10.0");
		}
		this.diemTH = diemTH;
	}
	public SinhVien(int mssv, String ten, float diemLT, float diemTH) {
		super();
		this.mssv = mssv;
		this.ten = ten;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
	
	public SinhVien() {
		
	}
	
	@Override
	public String toString() {
	    return "SinhVien [Mssv=" + mssv + ", Ten=" + ten 
	            + ", DiemLT=" + diemLT + ", DiemTH=" + diemTH + "]";
	}
	
	
	
}
