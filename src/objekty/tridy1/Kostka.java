package objekty.tridy1;

import java.util.Random;

public class Kostka {

    private Random random;
    private int pocetSten;

    public Kostka() {
        pocetSten = 6;
        random = new Random();
    }

    public Kostka(int pocetSten) {
        this.pocetSten = pocetSten;
        random = new Random();
    }

    public int hodKostkou(){
        int hozeneCislo = (int)Math.round(Math.random() * (pocetSten - 1) +1 );
        return hozeneCislo;
    }

    public static void main(String[] args) {
        Kostka sestistrannaKostka = new Kostka();
        Kostka desetistrannaKostka = new Kostka(10);

        System.out.println("Hod šestistrannou kostkou: " + sestistrannaKostka.hodKostkou());
        System.out.println("Hod desetistrannou kostkou: " + desetistrannaKostka.hodKostkou());
    }

}
