package iuh;

public class CD {
	private int id;
	private String title;
	private int numberOfSings;
	private double price;
	
	
	public CD(int id, String title, int numberOfSings, double price) {
		super();
		setId(id);
		setTitle(title);
		setNumberOfSings(numberOfSings);
		setPrice(price);
	}
	
	public CD() {
		// TODO Auto-generated constructor stub
		this(999999, "unknown", 1, 0.1);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id <=0 )
			throw new RuntimeException("Mã CD (là số nguyên >0, mặc định là 999999)");
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if (title == null || title.trim().isEmpty()) {
			throw new RuntimeException("Tựa CD (chuỗi không được rỗng, tên mặc định là \"chưa xác định\")");
		}
		this.title = title;
	}
	public int getNumberOfSings() {
		return numberOfSings;
	}
	public void setNumberOfSings(int numberOfSings) {
		if(numberOfSings <= 0)
			throw new RuntimeException("Số bài hát (số nguyên >0)");
		this.numberOfSings = numberOfSings;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price <= 0)
			throw new RuntimeException("Giá thành (số thực >0)");
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("%-8d| %-25s| %-10d| %10.2f", id, title, numberOfSings, price);
	}
	
	
}
