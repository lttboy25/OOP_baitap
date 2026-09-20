package iuh;

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
	
	public int findIndexCDById(int id) {
		if(id > ds.length) {
			return -1;
		}
		
		for (int i = 0; i < soLuongHienTai; i++) {
			if(ds[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean removeById(int id) {
		int indexFinded = findIndexCDById(id);
		if(indexFinded <0) {
			return false;
		}
		
		for (int i = indexFinded; i < soLuongHienTai - 1; i++) {
			ds[i] = ds[i+1];
			
		}
		ds[soLuongHienTai] = null;
		soLuongHienTai--;
		return true;
	}
	
	public boolean updateById(CD newCd) {
		int indexFinded = findIndexCDById(newCd.getId());
		if(indexFinded <0) {
			return false;
		}
		
		ds[indexFinded] = newCd;
		return true;
		
		
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
	
	public CD[] sortByCountOfMusicDesc() {
		CD[] list2 = Arrays.copyOf(ds, soLuongHienTai);
		CD temp;
		
		for (int i = 0; i < list2.length; i++) {
			for (int j = i+1; j < list2.length; j++) {
				if(list2[j].getNumberOfSings() > list2[i].getNumberOfSings()) {
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
	

}
