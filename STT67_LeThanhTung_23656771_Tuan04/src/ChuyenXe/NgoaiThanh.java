package ChuyenXe;

public class NgoaiThanh extends ChuyenXe {
	private String destination; // nơi đến
	private int days; // số ngày đi được

	public NgoaiThanh(String tripCode, String driverName, String busNumber, double revenue, String destination,
			int days) {
		super(tripCode, driverName, busNumber, revenue);
		setDestination(destination);
		setDays(days);
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		if (destination == null || destination.trim().isEmpty())
			throw new IllegalArgumentException("Nơi đến không được rỗng");
		this.destination = destination.trim();
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		if (days <= 0)
			throw new IllegalArgumentException("Số ngày phải > 0");
		this.days = days;
	}

	@Override
	public String toString() {
		String s = String.format(" %-20s | %10d ngày |", getDestination(), getDays());
		return super.toString() + s;
	}
}
