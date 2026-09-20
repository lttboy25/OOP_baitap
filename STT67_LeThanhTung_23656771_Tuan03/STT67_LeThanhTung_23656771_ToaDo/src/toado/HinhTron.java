package toado;
public class HinhTron {
    private ToaDo tam;
    private double banKinh;

    public HinhTron(ToaDo tam, double banKinh) {
        this.tam = tam;
        this.banKinh = banKinh;
    }

    public HinhTron() {
    }

    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }

    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }

    public ToaDo getTam() {
        return tam;
    }

    public double getBanKinh() {
        return banKinh;
    }

    public void setTam(ToaDo tam) {
        this.tam = tam;
    }

    public void setBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }

    @Override
    public String toString() {
        return "Diện tích và chu vi hình tròn tâm " 
                + tam.toString()
                + " có bán kính " + banKinh
                + "m là "
                + String.format("%.2f", tinhDienTich())
                + " và "
                + String.format("%.2f", tinhChuVi());
    }
}
