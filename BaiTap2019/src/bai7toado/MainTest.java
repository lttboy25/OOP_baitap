package bai7toado;

import java.util.Scanner;

public class MainTest {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String ten;
	float x, y, bk;
	System.out.println("Vui lòng nhập tọa độ: ");
	System.out.println("Tên: ");
	ten = sc.next();
	System.out.println("X: ");
	x = sc.nextFloat();
	System.out.println("Y: ");
	y = sc.nextFloat();
	System.out.println("Bán kính: ");
	bk = sc.nextFloat();
	
	ToaDo td = new ToaDo(ten, x, y);
	HinhTron ht = new HinhTron(td, bk);
	
	System.out.printf("Diện tích và chu vi hình tròn tâm P(%.1f, %.1f) có bán kính %.1fm là %.2 và %.2.", x, y, bk, ht.tinhDienTich(), ht.tinhChuVi());
}
}
