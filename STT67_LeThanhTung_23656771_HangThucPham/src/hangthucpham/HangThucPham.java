	package hangthucpham;
	
	import java.text.Format;
	import java.text.NumberFormat;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.util.Locale;
	
	import javax.swing.text.DateFormatter;
	
	public class HangThucPham {
	
	
		private String maHang;
		private String tenHang;
		private double donGia;
		private LocalDate ngaySanXuat;
		private LocalDate ngayHetHan;
	
		public HangThucPham() throws Exception {
			// TODO Auto-generated constructor stub
			this("Mac Dinh", "xxx", 0, LocalDate.now(), LocalDate.now());
		}
	
	
	
		public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) throws Exception {
			if (maHang == null || maHang.trim().isEmpty()) {
				throw new Exception("Mã hàng không được để rỗng");
			}
			this.maHang = maHang;
			setTenHang(tenHang);
			setDonGia(donGia);
			setNgaySanXuat(ngaySanXuat);
			setNgayHetHan(ngayHetHan);
		}
	
	
	
		public String getMaHang() {
			return maHang;
		}
	
		public String getTenHang() {
			return tenHang;
		}
	
	
	
		public void setTenHang(String tenHang) throws Exception {
			if(tenHang == null || tenHang.trim().isEmpty()) {
				throw new Exception("Tên hàng không được để rỗng");
			}
			this.tenHang = tenHang;
		}
	
		public double getDonGia() {
			return donGia;
		}
	
		public void setDonGia(double donGia) throws Exception {
			if(donGia < 0) {
				throw new Exception("đơn giá >=0");
			}
			this.donGia = donGia;
		}
	
	
	
		public LocalDate getNgaySanXuat() {
			return ngaySanXuat;
		}
	
		public void setNgaySanXuat(LocalDate ngaySanXuat) throws Exception {
			if(ngaySanXuat.isAfter(LocalDate.now())) {
				throw new Exception("Ngày sản xuất phải trước ngày hiện tại");
			}
			this.ngaySanXuat = ngaySanXuat;
		}
	
	
	
		public LocalDate getNgayHetHan() {
			return ngayHetHan;
		}
	
	
	
		public void setNgayHetHan(LocalDate ngayHetHan) throws Exception {
			if(ngayHetHan.isBefore(ngaySanXuat)){
				throw new Exception("Ngày hết hạn phải sau ngày sản xuất");
			}
			this.ngayHetHan = ngayHetHan;
		}
	
		public boolean isExpired() {
			return this.ngayHetHan.isBefore(LocalDate.now());
		}
	
		@Override
		public String toString() {
			Locale local = new Locale( "vi","VN");
			NumberFormat nf = NumberFormat.getCurrencyInstance(local);
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String txt = "";
			if (isExpired()) {
				txt = "Hàng hết hạn";
			}
			return String.format("%8s %20s %18s %18s %18s %28s", maHang, tenHang, nf.format(donGia), df.format(ngaySanXuat), df.format(ngayHetHan), txt);
		}
	
	
	
	}
