package datoveStruktury;

import java.util.*;

public class ZavodMap {

    // vytvorte kod v Jave, kde na vstupu zadate jmena zavodniku a jejich casy
    // na vystupu ziskate poradi zavodniku podle casu, jak dobehli v zavode

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> zavodnici = new HashMap<>();

        System.out.println("Zadejte počet závodníků: ");
        int pocetZavodniku = Integer.parseInt(scanner.nextLine());

        // získáme Map
        for (int i = 0; i < pocetZavodniku; i++) {
            pridatZavodnika(scanner, zavodnici);
        }
        System.out.println("Děkuji za zadání závodníků.");
        // Seřazení závodníků podle času
        List<Map.Entry<String, Double>> serazeniZavodnici = new ArrayList<>(zavodnici.entrySet());
        serazeniZavodnici.sort((entry1, entry2) -> Double.compare(entry1.getValue(), entry2.getValue()));

        // Výpis výsledků
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
        System.out.println("Zadejte čas závodníka: ");
        double cas = Double.parseDouble(scanner.nextLine());
        zavodnici.put(jmeno, cas);
    }
}




