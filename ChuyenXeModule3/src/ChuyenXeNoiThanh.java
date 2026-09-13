
public class ChuyenXeNoiThanh extends ChuyenXe{
	private int soTuyen;
    private double soKm;

    public ChuyenXeNoiThanh(String maSoChuyen, String hoTenTaiXe, String soXe,
                             double doanhThu, int soTuyen, double soKm) {
        super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
        this.soTuyen = soTuyen;
        this.soKm = soKm;
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("   -> Nội thành | Số tuyến: " + soTuyen + " | Số km: " + soKm);
    }
}
