package objekty.smenarna3;

import java.util.Scanner;

public class Euro {
    Scanner sc = new Scanner(System.in);
    SmenarnaBezPoplatku euroLevna = new SmenarnaBezPoplatku(25);
    SmenarnaSPoplatkem euroDraha  = new SmenarnaSPoplatkem(25,10);
    public void smenaKorunyNaEuro(){
        System.out.println("Kolik chces smenit korun?");
        double zadaniKorunyEuro = Double.parseDouble(sc.nextLine());
        double smenaBezPoplatkuKE = euroLevna.smenaKorunaCiziMena(zadaniKorunyEuro);
        double smenaSPoplatkemKE = euroDraha.smenaKorunaCiziMena(zadaniKorunyEuro);
        System.out.println("Za " + zadaniKorunyEuro + " korun dostanes bez poplatku " + smenaBezPoplatkuKE + " euro.");
        System.out.println("Za " + zadaniKorunyEuro + " korun dostanes s poplatkem " + smenaSPoplatkemKE + " euro.");
    }

    public void smenaEuroNaKoruny(){
        System.out.println("Kolik chces smenit euro?");
        double zadaniEuroKoruny = Double.parseDouble(sc.nextLine());
        double smenaBezPoplatkuEK = euroLevna.smenaCiziMenaKoruna(zadaniEuroKoruny);
        double smenaSPoplatkemEK = euroDraha.smenaCiziMenaKoruna(zadaniEuroKoruny);
        System.out.println("Za " + zadaniEuroKoruny + " eur dostanes bez poplatku " + smenaBezPoplatkuEK + " korun.");
        System.out.println("Za " + zadaniEuroKoruny + " eur dostanes s poplatkem " + smenaSPoplatkemEK + " korun.");
    }
}
