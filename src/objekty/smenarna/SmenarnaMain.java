package objekty.smenarna;

import java.util.Scanner;

public class SmenarnaMain {

//    Vytvořte třídu, která bude reprezentovat směnárnu poskytující prodej a výkup valut v zadaném kurzu.
//    Směnárnu můžeme v reprezentovat třídou Smenarna, jejíž proměnná kurz bude obsahovat kurz pro prodej a
//    výkup a metody vykup() (výkup valut od zákazníka) a prodej() (prodej valut zákazníkovi)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej, kolik chces prodat korun: ");
        double kolikProdavas = Double.parseDouble(sc.nextLine());
        System.out.println("Zadej, kolik chces koupit euro: ");
        double kolikKupujes = Double.parseDouble(sc.nextLine());

        SmenarnaBezPoplatku levna = new SmenarnaBezPoplatku(26);
        SmenarnaSPoplatkem draha = new SmenarnaSPoplatkem(26, 50, 2, 5);

        double primaKup = levna.vykup(kolikProdavas);
        double primaProdej = levna.prodej(kolikKupujes);
        double drahyKup = draha.vykup(kolikProdavas);
        double drahyProdej = draha.prodej(kolikKupujes);

        System.out.println("Ve smenarne bez poplatku koupis za " + kolikKupujes + " Kc " +  primaKup + " Euro.");
        System.out.println("Ve smenarne bez poplatku dostanes za " + kolikProdavas + " Euro " + primaProdej + " Kc.");
        System.out.println("Ve smenarne s poplatkem koupis za " + kolikKupujes + " Kc pouze " +  drahyKup + " Euro.");
        System.out.println("Ve smenarne s poplatkem dostanes za " + kolikProdavas + " Euro pouze " + drahyProdej + " Kc.");

    }


}

