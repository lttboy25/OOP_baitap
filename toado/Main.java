package toado;
public class Main {
    public static void main(String[] args) {

        ToaDo p = new ToaDo("P", 5, 5);

        HinhTron ht = new HinhTron(p, 10.5);

        System.out.println(ht);
    }
}
