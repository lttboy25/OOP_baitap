package toado;
public class ToaDo {
    private String ten;
    private float x;
    private float y;

    public ToaDo(String ten, float x, float y) {
        this.ten = ten;
        this.x = x;
        this.y = y;
    }

    public ToaDo() {
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getTen() {
        return ten;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return ten+"(" + x + ", " + y + ")";
    }
}
