package iuh;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public abstract class Sach {

	protected LocalDate dateAdded;
	protected String idBook;
	protected String publisher;
	protected int quantity;
	protected double unitPrice;

	public Sach() {
		this("-", LocalDate.now(), 0.0, 0, "-");
	}

	public Sach(String idBook, LocalDate dateAdded, double unitPrice, int quantity, String publisher) {
		setIdBook(idBook);
		setDateAdded(dateAdded);
		setUnitPrice(unitPrice);
		setQuantity(quantity);
		setPublisher(publisher);
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public String getIdBook() {
		return idBook;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setDateAdded(LocalDate dateAdded) {
		if (dateAdded == null) {
			dateAdded = LocalDate.now();
		}
		this.dateAdded = dateAdded;
	}

	public void setIdBook(String idBook) {
		if (idBook == null || idBook.trim().isEmpty()) {
			throw new RuntimeException("Mã sách không hợp lệ");
		}
		this.idBook = idBook;
	}

	public void setPublisher(String publisher) {
		if (publisher == null || publisher.isEmpty()) {
			publisher = "-";
		}
		this.publisher = publisher;
	}

	public void setQuantity(int quantity) {
		if (quantity < 0) {
			quantity = 0;
		}
		this.quantity = quantity;
	}

	public void setUnitPrice(double unitPrice) {
		if (unitPrice < 0) {
			unitPrice = 0;
		}
		this.unitPrice = unitPrice;
	}

	abstract double thanhTien();

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sach)) {
			return false;
		}
		Sach other = (Sach) obj;
		return this.idBook.equalsIgnoreCase(other.idBook);
	}

	@Override
	public int hashCode() {
		return idBook.toLowerCase().hashCode();
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi"));
		return String.format("%-8s | %-15s | %10s | %5d | %12s | %15s",
				idBook,
				publisher,
				dateAdded,
				quantity,
				nf.format(unitPrice),
				nf.format(thanhTien()));
	}

}
