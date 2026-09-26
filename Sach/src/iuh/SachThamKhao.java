package iuh;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class SachThamKhao extends Sach {

	private double taxRate;

	public SachThamKhao() {
		super();
		this.taxRate = 0;
	}

	public SachThamKhao(String idBook, LocalDate dateAdded, double unitPrice, int quantity, String publisher) {
		this(idBook, dateAdded, unitPrice, quantity, publisher, 0);
	}

	public SachThamKhao(String idBook, LocalDate dateAdded, double unitPrice, int quantity, String publisher,
			double taxRate) {
		super(idBook, dateAdded, unitPrice, quantity, publisher);
		setTaxRate(taxRate);
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		if (taxRate < 0) {
			taxRate = 0;
		}
		this.taxRate = taxRate;
	}

	@Override
	double thanhTien() {
		return quantity * unitPrice + taxRate;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi"));
		return super.toString() + String.format(" | %12s", nf.format(taxRate));
	}

}
