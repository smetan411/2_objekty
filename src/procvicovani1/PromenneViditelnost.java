package procvicovani1;

public class PromenneViditelnost {
   private final int a;
   private final int b;
   private final int c;

    public PromenneViditelnost(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int scitani(int a, int b) {
        int c = a + b;
        return c;
    }

    public int odcitani(int a, int b) {
        int c = a - b;
        return c;
    }

    public int nasobeni(int a, int b) {
        int c = a * b;
        return c;
    }

    public int deleni(int a, int b) {
        int c = a / b;
        return c;
    }

    public static void main(String[] args) {
    }
}
