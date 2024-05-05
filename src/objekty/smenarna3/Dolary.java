package objekty.smenarna3;

import java.util.Scanner;

public class Dolary {

    Scanner sc = new Scanner(System.in);
    SmenarnaBezPoplatku dolaryLevna = new SmenarnaBezPoplatku(23);
    SmenarnaSPoplatkem dolaryDraha = new SmenarnaSPoplatkem(23,10);
    public void smenaKorunyNaDolar(){
        System.out.println("Kolik chces smenit korun?");
        double zadaniKorunaDolar = Double.parseDouble(sc.nextLine());
        double smenaBezPoplatkuKD = dolaryLevna.smenaKorunaCiziMena(zadaniKorunaDolar);
        double smenaSPoplatkemKD = dolaryDraha.smenaKorunaCiziMena(zadaniKorunaDolar);
        System.out.println("Za " + zadaniKorunaDolar + " korun dostanes bez poplatku " + smenaBezPoplatkuKD + " dolaru.");
        System.out.println("Za " + zadaniKorunaDolar + " korun dostanes s poplatkem " + smenaSPoplatkemKD + " dolaru.");
    }

    public void smenaDolarNaKoruny(){
        System.out.println("Kolik chces smenit dolaru?");
        double zadaniDolarKoruna = Double.parseDouble(sc.nextLine());
        double smenaBezPoplatkuDK = dolaryLevna.smenaCiziMenaKoruna(zadaniDolarKoruna);
        double smenaSPoplatkemDK = dolaryDraha.smenaCiziMenaKoruna(zadaniDolarKoruna);
        System.out.println("Za " + zadaniDolarKoruna + " dolaru dostanes bez poplatku " + smenaBezPoplatkuDK + " korun.");
        System.out.println("Za " + zadaniDolarKoruna + " dolaru dostanes s poplatkem " + smenaSPoplatkemDK + " korun.");
    }

}
