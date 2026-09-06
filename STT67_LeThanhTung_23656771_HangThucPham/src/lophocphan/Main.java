package lophocphan;
public class Main {
    public static void main(String[] args) {

        SinhVien[] dsSV = {
            new SinhVien("123", "Nguyen Van A"),
            new SinhVien("543", "Le Thi B"),
            new SinhVien("321", "Luong Van C")
        };

        LopHocPhan lhp = new LopHocPhan(
            "123456",
            "LT Hướng đối tượng",
            "Cô Hà",
            "Thứ 7, tiết 4-6, phòng A1.1",
            dsSV
        );

        System.out.println(lhp);

        System.out.println("\nDanh sách sinh viên");

        for (SinhVien sv : lhp.getDsSV()) {
            System.out.println("    " + sv);
        }

        System.out.println("Tổng số sinh viên: " + lhp.getSoLuongSV());
    }
}
