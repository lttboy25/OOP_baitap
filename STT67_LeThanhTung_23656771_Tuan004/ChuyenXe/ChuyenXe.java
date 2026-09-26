package ChuyenXe;

import java.text.DecimalFormat;
import java.util.Objects;

public abstract class ChuyenXe {
	private String tripCode;
	private String driverName;
	private String busNumber;
	private double revenue;

	public ChuyenXe(String tripCode, String driverName, String busNumber, double revenue) {
		setTripCode(tripCode);
		setDriverName(driverName);
		setBusNumber(busNumber);
		setRevenue(revenue);
	}

	public String getTripCode() {
		return tripCode;
	}

	public void setTripCode(String tripCode) {
		if (tripCode == null || tripCode.trim().isEmpty())
			throw new IllegalArgumentException("Mã chuyến không được rỗng");
		this.tripCode = tripCode.trim();
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		if (driverName == null || driverName.trim().isEmpty())
			throw new IllegalArgumentException("Tên tài xế không được rỗng");
		this.driverName = driverName.trim();
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		if (busNumber == null || busNumber.trim().isEmpty())
			throw new IllegalArgumentException("Số xe không được rỗng");
		this.busNumber = busNumber.trim();
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		if (revenue < 0)
			throw new IllegalArgumentException("Doanh thu không được âm");
		this.revenue = revenue;
	}

	// Trùng mã chuyến (không phân biệt hoa thường) => cùng 1 chuyến xe
	@Override
	public int hashCode() {
		return Objects.hash(tripCode.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		ChuyenXe other = (ChuyenXe) obj;
		return tripCode.equalsIgnoreCase(other.tripCode);
	}

	@Override
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("#,##0.00' VND'");
		return String.format("| %-10s | %-15s | %10s | %22s |", getTripCode(), getDriverName(), getBusNumber(),
				formatter.format(getRevenue()));
	}
}
