package objekty.tridy1;

public class Pes {
    // napiš třídu, která popisuje objekt, např. hračku, domácí spotřebič, zvíře, dopravní prostředek
    // objekt bude mít alespoň dvě proměnné jako popis vlastností, např. int, String, boolean
    // třída bude obsahovat konstruktor (alt + ins),
    // třída bude mít alespoň jednu metodu, ve které proměnné použije a něco vytiskne
    // spouštěcí metoda bude na konci třídy za metodami (psvm)
    // vytvoříme zde dvě různé instance třídy a zavoláme jejich metody

    private String barva;
    private String druh;
    private String jmeno;
    private int vek;
    private int zivoty;

    public Pes(String barva, String druh, String jmeno, int vek, int zivoty) {
        this.barva = barva;
        this.druh = druh;
        this.jmeno = jmeno;
        this.vek = vek;
        this.zivoty = zivoty;
    }

    private void kousni(Pes pokousanyPes, int damage) {
        pokousanyPes.obdrzeneKousnuti(damage);
        System.out.println(jmeno + " kousnul " + pokousanyPes.jmeno + " za " + damage + " zivotu ");
        if (pokousanyPes.jeMrtvy()) System.out.println("Pes " + pokousanyPes.jmeno + " je mrtvy.");
    }

    public void obdrzeneKousnuti(int damage) {
        zivoty -= damage;
        if (zivoty < 0) zivoty = 0;
    }

    public boolean jeMrtvy() {
        return zivoty == 0;
    }

    public static void main(String[] args) {
        Pes arnold = new Pes("hneda", "Čivava kabelková", "Arnold", 1, 100);
        Pes yeti = new Pes("bílá", "husky", "Yeti veliký", 5, 50);
        arnold.kousni(yeti, 1000);
    }
}
