import java.util.ArrayList;
import java.util.List;

public class ChuyenXeTesting {
	public static void main(String[] args) {
		ChuyenXeNoiThanh xe1 = new ChuyenXeNoiThanh("NT01", "Nguyen Van A", "51A-111", 2000000, 5, 30);
        ChuyenXeNoiThanh xe2 = new ChuyenXeNoiThanh("NT02", "Tran Van B", "51A-222", 2500000, 7, 40);

        ChuyenXeNgoaiThanh xe3 = new ChuyenXeNgoaiThanh("NgT01", "Le Van C", "51B-333", 5000000, "Vũng Tàu", 2);
        ChuyenXeNgoaiThanh xe4 = new ChuyenXeNgoaiThanh("NgT02", "Pham Van D", "51B-444", 6000000, "Đà Lạt", 3);

        double tongDoanhThu = 0;
        double tongNoiThanh = 0;
        double tongNgoaiThanh = 0;

        System.out.println("=== DANH SÁCH CHUYẾN XE ===");

        xe1.xuatThongTin();
        xe2.xuatThongTin();
        xe3.xuatThongTin();
        xe4.xuatThongTin();

        tongNoiThanh = xe1.getDoanhThu() + xe2.getDoanhThu();
        tongNgoaiThanh = xe3.getDoanhThu() + xe4.getDoanhThu();
        tongDoanhThu = tongNoiThanh + tongNgoaiThanh;

        System.out.println("\n=== TỔNG KẾT ===");
        System.out.println("Tổng doanh thu tất cả chuyến xe: " + tongDoanhThu);
        System.out.println("Tổng doanh thu chuyến nội thành: " + tongNoiThanh);
        System.out.println("Tổng doanh thu chuyến ngoại thành: " + tongNgoaiThanh);
    }
}
