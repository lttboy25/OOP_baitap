package iuh.fit.oop.week4.ex10;

import java.util.Arrays;

public class CDList {
	
	private CD[] list;
	private int count;
	private int initialCapacity;
	
	public CDList() {
		this(10);
	}
	
	public CDList(int capacity) {
		if(capacity <= 0) {
			capacity = 10;
		}
		this.initialCapacity = capacity;
		this.count = 0;
		this.list = new CD[capacity];
	}
	
	public int size() {
		for (int i = 0; i < list.length; i++) {
			if(list[i] == null) {
				return i;
			}
		}
		return list.length;
	}
	
	public boolean isFull() {
		return size() == list.length;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	// CRUD - Add
	public boolean addCD(CD cd) { // aggregation
		if(cd == null) {
			return false;
		}
		
		for (int i = 0; i < size(); i++) {
			if(list[i].getCode() == cd.getCode()) {
				return false;
			}
		}
		
		if(size() == list.length) {
			int newLength = (int)(size() * 1.5);
			CD[] temp = new CD[newLength];
			for (int i = 0; i < size(); i++) {
				temp[i] = list[i];
			}
			this.list = temp;
			
//			this.list = Arrays.copyOf(list, newLength);
		}
		
		this.list[size()] = cd;
		
		this.list[count++] = cd;
		
		return true;
	}
	
	// CRUD - Remove
	public boolean removeCD(int code) {
		if(code <= 0) {
			return false;
		}
		
		for (int i = 0; i < size(); i++) {
			if(list[i].getCode() == code) {
				for (int j = i; j < size() - 1; j++) {
					list[j] = list[j + 1];
				}
				this.list[size() - 1] = null;
//				this.list[--count] = null;
				return true;
			}
		}
		
		return false;
	}
	
	public CD findCDByCode(int code) {
		if(code <= 0) {
			return null;
		}
		
		for (int i = 0; i < size(); i++) {
			if(list[i].getCode() == code) {
				return list[i];
			}
		}
		return null;
	}
	
	public int findIndexByCode(int code) {
		if(code <= 0) {
			return -1;
		}
		
		for (int i = 0; i < size(); i++) {
			if(list[i].getCode() == code) {
				return i;
			}
		}
		
		return -1;
	}
	
//	public boolean removeIf(String prefix) {
//		
//	}
	
	public boolean removeCDByTitle(String title) {
		if(title == null || title.trim().isEmpty()) {
			return false;
		}
		String key = title.trim();
		int n = size();
		int w = 0; 
		for (int r = 0; r < n; r++) {
			if(!list[r].getTitle().equalsIgnoreCase(key)) {
				list[w++] = list[r];
			}
		}
		for (int k = w; k < n; k++) {
			list[k] = null;
		}
		return w < n;
	}
	
	
	public CD[] findCDListByTitle(String keyword) {
		if(size() == 0 || keyword == null || keyword.isEmpty()) {
			return null;
		}
		CD[] temp = new CD[size()];
		int c = 0;
		for (int i = 0; i < size(); i++) {
			// Bắt đầu
			if(list[i].getTitle().startsWith(keyword)) {
				temp[c++] = list[i];
			}
			// Kết thúc
			if(list[i].getTitle().endsWith(keyword)) {
				temp[c++] = list[i];
			}
			// Chứa
			if(list[i].getTitle().toLowerCase()
					.contains(keyword.toLowerCase())) {
				temp[c++] = list[i];
			}	
		}
		if(c == 0) {
			return null;
		}
		CD[] result = new CD[c];
		for (int i = 0; i < result.length; i++) {
			result[i] = temp[i];
		}
		return result;
		
//		return c == 0 ? null : Arrays.copyOf(temp, c);
	}
	
	public double calculteSalePriceAverage() {
		double sum = 0;
		int c = 0;
		for (int i = 0; i < size(); i++) {
			if(list[i].getType() == CDType.NORMAL) {
				sum += list[i].calculateSalePrice();
				c++;
			}
		}
		return c == 0 ? 0 : sum/c;
	}
	
	public CD[] sortNumSongsAsc_TitleDesc() {
		if(size() == 0) {
			return null;
		}
		
		if(size() == 1) {
			CD[] t = new CD[1];
			t[0] = list[0];
			return t;
		}
		
		CD[] sorted = Arrays.copyOf(list, size());
		
		for (int i = 0; i < sorted.length - 1; i++) {
			for (int j = 0; j < sorted.length - 1 - i; j++) {
				// NumSongsAsc: sorted[j] > sorted[j + 1]
				if(sorted[j].getNumSongs() > sorted[j + 1].getNumSongs()) {
					// swap
					CD t = sorted[j];
					sorted[j] = sorted[j + 1];
					sorted[j + 1] = t;
				}
				else if(sorted[j].getNumSongs() == sorted[j + 1].getNumSongs()) {
					// TitleDesc: sorted[j] < sorted[j + 1]
					if(sorted[j].getTitle().compareTo(sorted[j + 1].getTitle()) < 0) {
						// swap
						CD t = sorted[j];
						sorted[j] = sorted[j + 1];
						sorted[j + 1] = t;						
					}
				}
				
			}
		}
		
		
		return sorted;
	}
	
	public CD[] findCDListByMaxPrice() {
		if(size() == 0) {
			return null;
		}
		
		double maxValue = list[0].getPrice();
		for (int i = 0; i < size(); i++) {
			if(list[i].getPrice() > maxValue) {
				maxValue = list[i].getPrice();
			}
		}
		
		CD[] temp = new CD[size()];
		int c = 0;
		for (int j = 0; j < temp.length; j++) {
			if(Math.abs(list[j].getPrice() - maxValue) <= 1e-15) {
				temp[c++] = list[j];
			}
		}
		
		CD[] result = new CD[c];
		for (int k = 0; k < result.length; k++) {
			result[k] = temp[k];
		}
		return result;		
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < size(); i++) {
			s += list[i].toString() + "\n";
		}
		return s;
	}
	
	public CD[] getList() {
		if (size() == 0) {
			return null;
		}
		CD[] t = new CD[size()];
		for (int i = 0; i < t.length; i++) {
			t[i] = list[i];
		}
		return t;
		
//		return size() == 0 ? null : Arrays.copyOf(list, size());
	}
	

}
