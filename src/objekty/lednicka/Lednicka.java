package objekty.lednicka;

public class Lednicka {

    // napiš třídu, která popisuje objekt, např. hračku, domácí spotřebič, zvíře, dopravní prostředek
    // objekt bude mít alespoň dvě proměnné jako popis vlastností, např. int, String, boolean
    // třída bude obsahovat konstruktor (alt + ins)
    // třída bude mít alespoň jednu metodu, ve které proměnné použije a něco vytiskne
    // spouštěcí metoda bude na konci třídy za metodami
    // vytvoříme zde dvě různé instance třídy a zavoláme jejich metody

    private final String jmenoLednicky;
    private final int maxTeplota;
    private final int minTeplota;
    private int aktualniTeplota;

    public Lednicka(String jmenoLednicky, int maxTeplota, int minTeplota) {
        this.jmenoLednicky = jmenoLednicky;
        this.maxTeplota = maxTeplota;
        this.minTeplota = minTeplota;
    }

    public void regulaceChlazeni() {
        System.out.println("Jmenuji se lednicka " + jmenoLednicky);
        if (aktualniTeplota >= maxTeplota) {
            System.out.println("Spoustim chlazeni, protoze teplota je +" + aktualniTeplota + " oC");
        } else if (aktualniTeplota < minTeplota) {
            System.out.println("Vypinam chlazeni, protoze teplota je " + aktualniTeplota + " oC");
        } else System.out.println("Teplota je v poradku, je mezi " + maxTeplota + " a " + minTeplota + " oC.");
    }

    public static void main(String[] args) {
        Lednicka lednickaKuchyn = new Lednicka("Siemens", 5, -6);
        Lednicka mrazak = new Lednicka("Samsung", -5, -12);
        lednickaKuchyn.aktualniTeplota = 10;
        lednickaKuchyn.regulaceChlazeni();
        System.out.println();
        mrazak.aktualniTeplota = -12;
        mrazak.regulaceChlazeni();
    }
}
