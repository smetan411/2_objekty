package procvicovani;

import java.util.*;

public class ZavodDynamicky {
    public static void main(String[] args) {

        System.out.println("Vitam vas v dynamickem zavodu.");
        System.out.println("Pokracujte vzdy libovolnou klavesou, az budete chtit koncit, napiste konec.");

        Scanner scanner = new Scanner(System.in);
        Map<String, Double> zavodnici = new HashMap<>();
        String konec = " ";
        while (!(konec == "konec")) {
            pridatZavodnika(scanner, zavodnici);
            vypisPoradi(zavodnici);

            String odpoved = scanner.nextLine().toLowerCase();
            if (odpoved.equals("konec")) {
                break;
            }
        }
        System.out.println("Dekuji za pouziti dynamickeho zavodu.");
    }

    private static void vypisPoradi(Map<String, Double> zavodnici) {
        List<Map.Entry<String, Double>> serazeniZavodnici = new ArrayList<>(zavodnici.entrySet());
        serazeniZavodnici.sort((entry1, entry2) -> Double.compare(entry1.getValue(), entry2.getValue()));

        System.out.println("\nVýsledky závodu:");
        int poradi = 1;
        for (Map.Entry<String, Double> entry : serazeniZavodnici) {
            System.out.printf(poradi + ". %s: %.2f s%n", entry.getKey(), entry.getValue());
            poradi++;
        }
    }

    private static void pridatZavodnika(Scanner scanner, Map<String, Double> zavodnici) {
        System.out.println("Zadejte jméno závodníka:");
        String jmeno = scanner.nextLine();
        System.out.println("Zadejte čas závodníka:");
        double cas = Double.parseDouble(scanner.nextLine());
        zavodnici.put(jmeno, cas);
    }
}
