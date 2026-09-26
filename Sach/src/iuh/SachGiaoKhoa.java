package iuh;

import java.time.LocalDate;

public class SachGiaoKhoa extends Sach {

	private boolean status;

	public SachGiaoKhoa() {
		super();
		this.status = true;
	}

	public SachGiaoKhoa(String idBook, LocalDate dateAdded, double unitPrice, int quantity, String publisher) {
		this(idBook, dateAdded, unitPrice, quantity, publisher, true);
	}

	public SachGiaoKhoa(String idBook, LocalDate dateAdded, double unitPrice, int quantity, String publisher,
			boolean status) {
		super(idBook, dateAdded, unitPrice, quantity, publisher);
		setStatus(status);
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	double thanhTien() {
		if (status) {
			return quantity * unitPrice;
		}
		return quantity * unitPrice * 0.5;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" | %-4s", status ? "Mới" : "Cũ");
	}

}
