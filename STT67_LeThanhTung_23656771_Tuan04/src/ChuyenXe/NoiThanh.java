package ChuyenXe;

public class NoiThanh extends ChuyenXe {
	private int routeNumber; // số tuyến
	private double km; // số km

	public NoiThanh(String tripCode, String driverName, String busNumber, double revenue, int routeNumber,
			double km) {
		super(tripCode, driverName, busNumber, revenue);
		setRouteNumber(routeNumber);
		setKm(km);
	}

	public int getRouteNumber() {
		return routeNumber;
	}

	public void setRouteNumber(int routeNumber) {
		if (routeNumber <= 0)
			throw new IllegalArgumentException("Số tuyến phải > 0");
		this.routeNumber = routeNumber;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		if (km <= 0)
			throw new IllegalArgumentException("Số km phải > 0");
		this.km = km;
	}

	@Override
	public String toString() {
		String s = String.format(" %10d | %8.1fKm |", getRouteNumber(), getKm());
		return super.toString() + s;
	}
}
