package objekty.smenarna3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dolary dolary = new Dolary();
        Euro euro = new Euro();
        Scanner sc = new Scanner(System.in);

        String pokracovani = "ano";

        while (pokracovani.equals("ano")) {
            System.out.println(" Zadej volbu 1 az 4:\n smenaKorunyNaEuro - 1 \n smenaEuroNaKoruny - 2" +
                    "  \n smenaKorunyNaDolar - 3 \n smenaDolarNaKoruny - 4");
            int volba = Integer.parseInt(sc.nextLine());
            switch (volba) {
                case 1:
                    euro.smenaKorunyNaEuro();
                    break;
                case 2:
                    euro.smenaEuroNaKoruny();
                    break;
                case 3:
                    dolary.smenaKorunyNaDolar();
                    break;
                case 4:
                    dolary.smenaDolarNaKoruny();
                    break;
            }
            System.out.println("Chces pokracovat? ano - ne");
            pokracovani = sc.nextLine();
        }
        System.out.println("Dekuji za pouziti smenarny.");
    }
}


