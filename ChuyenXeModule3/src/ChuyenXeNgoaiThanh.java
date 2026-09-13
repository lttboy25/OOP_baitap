
public class ChuyenXeNgoaiThanh extends ChuyenXe{
	private String noiDen;
    private int soNgay;

    public ChuyenXeNgoaiThanh(String maSoChuyen, String hoTenTaiXe, String soXe,
                               double doanhThu, String noiDen, int soNgay) {
        super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
        this.noiDen = noiDen;
        this.soNgay = soNgay;
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("   -> Ngoại thành | Nơi đến: " + noiDen + " | Số ngày: " + soNgay);
    }
}
