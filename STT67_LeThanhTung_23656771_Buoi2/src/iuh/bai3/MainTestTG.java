package iuh.bai3;

public class MainTestTG {
	public static void main(String[] args) {
		TamGiac tg1 = new TamGiac(-3, 4, 5);      
		TamGiac tg2 = new TamGiac(1, 2, 10);      

		TamGiac tg3 = new TamGiac(3, 4, 5);       
		TamGiac tg4 = new TamGiac(5, 5, 8);       
		TamGiac tg5 = new TamGiac(6, 6, 6);       

		TamGiac[] ds = {tg1, tg2, tg3, tg4, tg5};

		for (TamGiac tg : ds) {
			System.out.printf(tg.toString() + "\n");
		}


	}
}