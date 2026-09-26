package iuh.fit.oop.week4.ex10;

public enum CDType {
	
	NORMAL("thường"),
	PREMIUM("sang");
	
	private String v;

	private CDType(String v) {
		this.v = v;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return v;
	}
}
