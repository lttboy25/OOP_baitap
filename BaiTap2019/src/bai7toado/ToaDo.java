package bai7toado;

public class ToaDo {
	private String ten;
	private float x;
	private float y;
	
	public ToaDo() {}

	public ToaDo(String ten, float x, float y) {
		setTen(ten);
		setX(x);
		setY(y);
	}
	
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	};
	
	
}
