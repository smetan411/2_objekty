package objekty;

public class TahovyBoj {
    public static void main(String[] args) {
        Kostka desetistenna = new Kostka(10);
        Kostka sestistenna = new Kostka();

        System.out.println(desetistenna.vratPocetSten());
        System.out.println(sestistenna.vratPocetSten());
        System.out.println(sestistenna);
        System.out.println(sestistenna.toString());
    }
}
