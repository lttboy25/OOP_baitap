package baicd;

import java.util.ArrayList;
import java.util.Arrays;

public class CDList {
	private CD[] ds;
	private int soLuongHienTai;
	
	public CDList() {
		// TODO Auto-generated constructor stub
		ds = new CD[10];
	}
	
	public CD[] getCDList() {
		return ds;
	}
	
	public boolean addCD(CD cd) {
		if(cd == null) {
			return false;
		}
		CD cdFinded = findCDById(cd.getId());
		if(cdFinded != null) {
			return false;
		}
		
		if(soLuongHienTai == ds.length) {
			int oldLength = ds.length;
			int newLength = (int) (oldLength * 1.5);
			CD[] newList = Arrays.copyOf(ds, newLength);
			newList[soLuongHienTai++] = cd;
			ds = newList;
			return true;
		}
		
		ds[soLuongHienTai++] = cd;
		return true;
		
	}
	
	public CDList(int capacity) {
		if(capacity<= 0) {
			ds = new CD[10];
		}
		else {
			ds = new CD[capacity];
		}
	}
	
	public int countOfCD() {
		return soLuongHienTai;
	}
	
	public double totalOfPrice() {
		double total = 0.0;
		for (int i = 0; i < soLuongHienTai; i++) {
			total += ds[i].getPrice();
			
		}
		return total;
	}
	
	public CD findCDById(int id) {
		for (int i = 0; i < soLuongHienTai; i++) {
			if(ds[i].getId() == id) {
				return ds[i];
			}
			
		}
		return null;
	}
	
	public CD[] sortByPriceDesc() {
		CD[] list2 = Arrays.copyOf(ds, soLuongHienTai);
		CD temp;
		
		for (int i = 0; i < list2.length; i++) {
			for (int j = i+1; j < list2.length; j++) {
				if(list2[j].getPrice() > list2[i].getPrice()) {
					temp = list2[j];
					list2[j] = list2[i];
					list2[i] = temp;
				}
			}
		}
		return list2;
	}
	
	public CD[] sortByTitle() {
		CD[] list2 = Arrays.copyOf(ds, soLuongHienTai);
		CD temp;
		
		for (int i = 0; i < list2.length; i++) {
			for (int j = i+1; j < list2.length; j++) {
				if(list2[j].getTitle().compareTo(list2[i].getTitle()) <0) {
					temp = list2[j];
					list2[j] = list2[i];
					list2[i] = temp;
				}
			}
		}
		return list2;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-8s| %-25s| %-10s| %10s%n", "Mã CD", "Tựa CD", "Số bài", "Giá"));
		sb.append("-".repeat(60)).append("\n");
		for (int i = 0; i < soLuongHienTai; i++) {
			sb.append(ds[i].toString()).append("\n");
		}
		return sb.toString();
	}

}
