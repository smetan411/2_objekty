package objekty.tridy1;

public class Kocka {

    private final int vek;
    private final String jmeno;

    //konstruktor
    public Kocka(int vek, String jmeno) {
        this.vek = vek;
        this.jmeno = jmeno;
    }

    public void mnouka() {

        System.out.println("Mnau, jsem kocka " + jmeno + " a mam " + vek + " roku.");
    }

    public static void main(String[] args) {
        Kocka kockaLiza = new Kocka(5, "Liza");
        Kocka mourek = new Kocka(7, "Mourek");
        kockaLiza.mnouka();
        mourek.mnouka();
    }
}
