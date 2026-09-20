package iuh;

public class SinhVienTesting {
    public static void main(String[] args) {
    	SinhVien sv1 = new SinhVien();
        sv1.setMssv(1);
        sv1.setTen("Nguyen Van A");
        sv1.setDiemLT(8.5f);
        sv1.setDiemTH(7.0f);
        System.out.println(sv1);

        SinhVien sv2 = new SinhVien(2, "Tran Thi B", 9.0f, 8.5f);
        System.out.println(sv2);
        
//        SinhVien sv3 = new SinhVien();
//        sv3.setMssv(-3);
//        
//        SinhVien sv4 = new SinhVien();
//        sv4.setTen("");
//        
//        SinhVien sv5 = new SinhVien();
//        sv5.setDiemTH(15.0f);
    }
}