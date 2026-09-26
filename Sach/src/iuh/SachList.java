package iuh;

import java.util.Arrays;

public class SachList {

	private Sach[] list;
	private int count;

	public SachList() {
		this(10);
	}

	public SachList(int capacity) {
		if (capacity <= 0) {
			capacity = 10;
		}
		this.count = 0;
		this.list = new Sach[capacity];
	}

	public int size() {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == null) {
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

	public boolean addSach(Sach sach) {
		if (sach == null) {
			return false;
		}

		for (int i = 0; i < size(); i++) {
			if (list[i].getIdBook().equalsIgnoreCase(sach.getIdBook())) {
				return false;
			}
		}

		if (size() == list.length) {
			int newLength = (int) (size() * 1.5) + 1;
			this.list = Arrays.copyOf(list, newLength);
		}

		this.list[count++] = sach;
		return true;
	}

	public boolean removeSach(String idBook) {
		if (idBook == null || idBook.trim().isEmpty()) {
			return false;
		}

		for (int i = 0; i < size(); i++) {
			if (list[i].getIdBook().equalsIgnoreCase(idBook)) {
				for (int j = i; j < size() - 1; j++) {
					list[j] = list[j + 1];
				}
				this.list[size() - 1] = null;
				count--;
				return true;
			}
		}
		return false;
	}

	public Sach findByIdBook(String idBook) {
		if (idBook == null || idBook.trim().isEmpty()) {
			return null;
		}
		for (int i = 0; i < size(); i++) {
			if (list[i].getIdBook().equalsIgnoreCase(idBook)) {
				return list[i];
			}
		}
		return null;
	}

	public double tongTienGiaoKhoa() {
		double sum = 0;
		for (int i = 0; i < size(); i++) {
			if (list[i] instanceof SachGiaoKhoa) {
				sum += list[i].thanhTien();
			}
		}
		return sum;
	}

	public double tongTienThamKhao() {
		double sum = 0;
		for (int i = 0; i < size(); i++) {
			if (list[i] instanceof SachThamKhao) {
				sum += list[i].thanhTien();
			}
		}
		return sum;
	}

	public double tongTienTatCa() {
		double sum = 0;
		for (int i = 0; i < size(); i++) {
			sum += list[i].thanhTien();
		}
		return sum;
	}

	public Sach[] getList() {
		if (size() == 0) {
			return null;
		}
		return Arrays.copyOf(list, size());
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < size(); i++) {
			s += list[i].toString() + "\n";
		}
		return s;
	}

}
