
public abstract class ChuyenXe {
	protected String maSoChuyen;
    protected String hoTenTaiXe;
    protected String soXe;
    protected double doanhThu;

    public ChuyenXe(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu) {
        this.maSoChuyen = maSoChuyen;
        this.hoTenTaiXe = hoTenTaiXe;
        this.soXe = soXe;
        this.doanhThu = doanhThu;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void xuatThongTin() {
        System.out.println("Mã chuyến: " + maSoChuyen
                + " | Tài xế: " + hoTenTaiXe
                + " | Số xe: " + soXe
                + " | Doanh thu: " + doanhThu);
    }
}
