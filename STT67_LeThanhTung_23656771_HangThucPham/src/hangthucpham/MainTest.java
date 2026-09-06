package hangthucpham;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainTest {
	public static void main(String[] args) throws Exception {
		HangThucPham[] ds = {
	            new HangThucPham("001", "Gạo", 100000, LocalDate.of(2018,7,10), LocalDate.of(2018,7,10)),
	            new HangThucPham("002", "Mì", 5000, LocalDate.of(2018,3,1), LocalDate.of(2018,9,1)),
	            new HangThucPham("003", "Nước", 10000, LocalDate.of(2017,3,1), LocalDate.of(2018,3,1))
	        };
		System.out.printf("%8s %20s %18s %18s %18s %28s\n", "Mã_Hàng", "Tên_Hàng", "Đơn_Giá", "Ngày_Sản_Xuất", "Ngày_Hết_Hạn", "Ghi_Chú");

	        for (HangThucPham h : ds) {
	            System.out.println(h);
	        }
	        
	        try {
	            HangThucPham loi1 = new HangThucPham("", "Gạo", 100000, LocalDate.of(2026,1,1), LocalDate.of(2026,6,1));
	        } catch (Exception e) {
	            System.out.println("Lỗi 1: " + e.getMessage());
	        }

	        try {
	            HangThucPham loi2 = new HangThucPham("002", "", 100000, LocalDate.of(2026,1,1), LocalDate.of(2026,6,1));
	        } catch (Exception e) {
	            System.out.println("Lỗi 2: " + e.getMessage());
	        }

	        try {
	            HangThucPham loi3 = new HangThucPham("003", "Mì", -5000, LocalDate.of(2026,1,1), LocalDate.of(2026,6,1));
	        } catch (Exception e) {
	            System.out.println("Lỗi 3: " + e.getMessage());
	        }

	        try {
	            HangThucPham loi4 = new HangThucPham("004", "Trứng", 3000, LocalDate.of(2030,1,1), LocalDate.of(2030,6,1));
	        } catch (Exception e) {
	            System.out.println("Lỗi 4: " + e.getMessage());
	        }

	        try {
	            HangThucPham loi5 = new HangThucPham("005", "Nước", 10000, LocalDate.of(2026,6,1), LocalDate.of(2026,1,1));
	        } catch (Exception e) {
	            System.out.println("Lỗi 5: " + e.getMessage());
	        }  
	        
	        int s = 0;
	        Integer[] A = {5,7,9,2};
	        for(int i:A) {
	        	s +=i;
	        }
	        System.out.println(s);
	}
}
