package objekty.knihovna4;

import objekty.smenarna3.Dolary;
import objekty.smenarna3.Euro;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabazeOsob databazeOsob = new DatabazeOsob();
        DatabazeKnih databazeKnih = new DatabazeKnih();
        Knihovna knihovna = new Knihovna(databazeOsob, databazeKnih);

        Scanner sc = new Scanner(System.in);
        String pokracovani = "ano";
        while (pokracovani.equals("ano")) {
            System.out.println(" Zadej volbu 1 az 4:\n Registrace uzivatele - 1 \n Registrace knihy - 2" +
                    "  \n Vypujcka knihy - 3 \n Vraceni knihy - 4 \n Kdo ma tuto knihu  - 5\n Jake knihy ma uzivatel - 6" );
            int volba = Integer.parseInt(sc.nextLine());
            switch (volba) {
                case 1:
                    // registrace uzivatele
                    System.out.println("Zadej jmeno a prijmeni:");
                    String[] jmenoAPrijmneni = sc.nextLine().split(" ");
                    databazeOsob.registrujOsobu(jmenoAPrijmneni[0], jmenoAPrijmneni[1]);
                    System.out.println("Uzivatel " + jmenoAPrijmneni[0] + " " + jmenoAPrijmneni[1] + " byl zaregistrovan.");
                    System.out.println(databazeOsob.toString());
                    break;
                case 2:
                    // registrace knihy
                    System.out.println("Zadej jmeno a prijmeni autora:");
                    String[] jmenoAPrijmeniAutora = sc.nextLine().split(" ");
                    System.out.println("Zadej jmeno knihy:");
                    String jmenoKnihy = sc.nextLine();
                    databazeKnih.registrujKnihu(jmenoAPrijmeniAutora[0], jmenoAPrijmeniAutora[1], jmenoKnihy );
                    System.out.println("Kniha " + jmenoKnihy + " byla zaregistrovana.");
                    System.out.println(databazeKnih.toString());
                    break;
                case 3:
                    // vypujcka knihy
                    System.out.println("Zadej registracniCisloOsoby isbn knihy");
                    String[] registrVypujcka = sc.nextLine().split(" ");
                    int registrCisloOsobyVypujcka = Integer.parseInt(registrVypujcka[0]);
                    int isbnVypujcka = Integer.parseInt(registrVypujcka[1]);
                    knihovna.vypujckaKnihy(registrCisloOsobyVypujcka, isbnVypujcka);
                    System.out.println("Byla zaregistrovana vypujcka knihy " + databazeKnih.najdiKnihu(isbnVypujcka));
                    System.out.println(knihovna.pujceneKnihy(databazeOsob.najdiOsobu(registrCisloOsobyVypujcka)));
                    break;
                case 4:
                    // vraceni knihy
                    System.out.println("Zadej registracniCisloOsoby isbn knihy");
                    String[] registrVraceni = sc.nextLine().split(" ");
                    int registrCisloOsobyVraceni = Integer.parseInt(registrVraceni[0]);
                    int isbnVraceni = Integer.parseInt(registrVraceni[1]);
                    knihovna.vraceniKnihy(registrCisloOsobyVraceni, isbnVraceni);
                    System.out.println("Bylo zaregistrovano vraceni knihy " + databazeKnih.najdiKnihu(isbnVraceni));
                    System.out.println(knihovna.pujceneKnihy(databazeOsob.najdiOsobu(registrCisloOsobyVraceni)));
                    break;
                case 5:
                    // dotaz kdo ma knihu
                    System.out.println("Zadej isbn knihy.");
                    int cisloKnihy = Integer.parseInt(sc.nextLine());
                    System.out.println("Knihu s nazvem " + databazeKnih.najdiKnihu(cisloKnihy) + " ma:\n");
                    System.out.println(knihovna.kdoMaKnihu(databazeKnih.najdiKnihu(cisloKnihy)));
                    break;
                case 6:
                    // dotaz na uzivatele a jeho knihy
                    System.out.println("Zadej registracni cislo uzivatele.");
                    int registrUzivatele = Integer.parseInt(sc.nextLine());
                    System.out.println("Uzivatel " + databazeOsob.najdiOsobu(registrUzivatele) + " ma tyto knihy:\n");
                    System.out.println(knihovna.pujceneKnihy(databazeOsob.najdiOsobu(registrUzivatele)));
                    break;
            }
            System.out.println("Chces pokracovat? ano - ne");
            pokracovani = sc.nextLine();
        }
        System.out.println("Dekuji za pouziti knihovny.");
    }

}
