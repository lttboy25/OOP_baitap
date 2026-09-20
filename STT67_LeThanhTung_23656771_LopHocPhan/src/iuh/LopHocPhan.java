package iuh;
public class LopHocPhan {
    private String maLHP;
    private String tenLHP;
    private String tenGV;
    private String thongTinLopHoc;
    private SinhVien[] dsSV;

    public LopHocPhan(String maLHP, String tenLHP, String tenGV,
                      String thongTinLopHoc, SinhVien[] dsSV) {
        this.maLHP = maLHP;
        this.tenLHP = tenLHP;
        this.tenGV = tenGV;
        this.thongTinLopHoc = thongTinLopHoc;
        this.dsSV = dsSV;
    }

    public LopHocPhan() {
    }

    public String getMaLHP() {
        return maLHP;
    }

    public String getTenLHP() {
        return tenLHP;
    }

    public String getTenGV() {
        return tenGV;
    }

    public String getThongTinLopHoc() {
        return thongTinLopHoc;
    }

    public SinhVien[] getDsSV() {
        return dsSV;
    }

    public void setMaLHP(String maLHP) {
        this.maLHP = maLHP;
    }

    public void setTenLHP(String tenLHP) {
        this.tenLHP = tenLHP;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public void setThongTinLopHoc(String thongTinLopHoc) {
        this.thongTinLopHoc = thongTinLopHoc;
    }

    public void setDsSV(SinhVien[] dsSV) {
        this.dsSV = dsSV;
    }

    public int getSoLuongSV() {
        if (dsSV == null) {
            return 0;
        }
        return dsSV.length;
    }

    @Override
    public String toString() {
        return "Mã LHP: " + maLHP +
               "\nTên LHP: " + tenLHP +
               "\nGV giảng dạy: " + tenGV +
               "\nThông tin buổi học: " + thongTinLopHoc;
    }
}
