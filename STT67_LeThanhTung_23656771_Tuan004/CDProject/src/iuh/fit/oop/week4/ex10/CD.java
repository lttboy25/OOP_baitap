package iuh.fit.oop.week4.ex10;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CD {
	
	private final int code;
	private String title;
	private int numSongs;
	private double price;
	private CDType type;
	
	public CD(int code) {
		this(code, "-", 0, 0.0, CDType.NORMAL);
	}
	
	public CD(int code, String title, int numSongs, double price, CDType type) {
		if(code <= 0) {
			throw new RuntimeException("Mã không hợp lệ");
		}
		this.code = code;
		
		setTitle(title);
		setNumSongs(numSongs);
		setType(type);
		setPrice(price);
	}

	public int getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public int getNumSongs() {
		return numSongs;
	}

	public double getPrice() {
		return price;
	}

	public CDType getType() {
		return type;
	}

	public void setTitle(String title) {
		if(title == null || title.isEmpty()) {
			title = "-";
		}
		this.title = title;
	}

	public void setNumSongs(int numSongs) {
		if(numSongs < 0) {
			numSongs = 0;
		}
		this.numSongs = numSongs;
	}

	public void setPrice(double price) {
		if(price < 0) {
			price = 0;
		}
		this.price = price;
	}

	public void setType(CDType type) {
		if(type == null || !(type instanceof CDType)) {
			type = CDType.NORMAL;
		}
		this.type = type;
	}
	
	public double calculateSalePrice() {
		double rate = 1;
		
		if(type == CDType.PREMIUM) {
			rate = 1.2;
		}
		else if(numSongs < 10) {
			rate = 1.1;
		}
		
		return rate * price;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0 VND");
		NumberFormat nf = NumberFormat.getCurrencyInstance(
				Locale.forLanguageTag("vi")
				);
		return String.format("%-6s | %-20s | %10s | %15s",
				code,
				title,
				numSongs,
				nf.format(calculateSalePrice()));
	}

}
