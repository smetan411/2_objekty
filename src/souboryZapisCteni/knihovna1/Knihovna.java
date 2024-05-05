package souboryZapisCteni.knihovna1;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Knihovna {
    private final DatabazeOsob databazeOsob;
    private final DatabazeKnih databazeKnih;
    private final Gson gson = new Gson();

    private static String DB_FILE = "C:\\Users\\annas\\Documents\\krouzky23\\JavaZac\\2_objekty\\res\\vypujcky_db.json";

    // vlastnik je knihy je jen jeden, ale je zvykem psat nazvy kolekci v mnoznem cisle
    private final Map<Kniha, Vypujcka> vlastniciKnih = new HashMap<>();
    private final Map<Osoba, Set<Vypujcka>> vsechnyPujceneKnihy = new HashMap<>();

    public Knihovna(DatabazeOsob databazeOsob, DatabazeKnih databazeKnih) {
        this.databazeOsob = databazeOsob;
        this.databazeKnih = databazeKnih;
        // načtení informací o výpůjčkách ze souboru
        try (FileReader fr = new FileReader(DB_FILE)) {
            Vypujcka[] vypujckyArr = gson.fromJson(fr, Vypujcka[].class);
            if (vypujckyArr == null) return;
            for (Vypujcka vypujcka : vypujckyArr) {
                pridejVypujcku(vypujcka);
            }
        } catch (Exception e) {
            throw new RuntimeException("Nemohu načíst soubor " + DB_FILE, e);
        }
    }

    public List<Kniha> pujceneKnihy(Osoba osoba) {
        Set<Vypujcka> vypujcky = vsechnyPujceneKnihy.get(osoba);
        return vypujcky.stream().map(vypujcka -> vypujcka.kniha).toList();
    }

    public Osoba kdoMaKnihu(Kniha kniha) {
        Vypujcka vypujcky = vlastniciKnih.get(kniha);
        return vypujcky.osoba;
    }

    public void vypujckaKnihy(int registracniCisloOsoby, int isbn) {
        Kniha kniha = databazeKnih.najdiKnihu(isbn);
        Osoba osoba = databazeOsob.najdiOsobu(registracniCisloOsoby);
        pridejVypujcku(new Vypujcka(kniha, osoba, new Date()));
        //uložení výpůjček do souboru
        saveVypujcky();
    }

    private void pridejVypujcku(Vypujcka vypujcka) {
        Osoba osoba = vypujcka.osoba();
        vlastniciKnih.put(vypujcka.kniha, vypujcka);
        Set<Vypujcka> pujceneKnihyUzivatelem;
        if (vsechnyPujceneKnihy.containsKey(osoba)) {
            //nacteme, ktere knihy ma uz uzivatel pujcene
            pujceneKnihyUzivatelem = vsechnyPujceneKnihy.get(osoba);
        } else {
            //zalozime uzivateli novou sadu pro vypujcovani knih
            pujceneKnihyUzivatelem = new HashSet<>();
        }
        pujceneKnihyUzivatelem.add(vypujcka); //pridame knihu
        vsechnyPujceneKnihy.put(osoba, pujceneKnihyUzivatelem); //ulozime zaznam
    }

    public void vraceniKnihy(int registracniCisloOsoby, int isbn) {
        Kniha kniha = databazeKnih.najdiKnihu(isbn);
        Osoba osoba = databazeOsob.najdiOsobu(registracniCisloOsoby);
        vlastniciKnih.remove(kniha);
        Set<Vypujcka> pujceneKnihyUzivatelem = vsechnyPujceneKnihy.get(osoba);
        if (pujceneKnihyUzivatelem == null || pujceneKnihyUzivatelem.isEmpty()) return;
        pujceneKnihyUzivatelem.remove(vypujcka(kniha, osoba));  // odstranime knihu
        vsechnyPujceneKnihy.put(osoba, pujceneKnihyUzivatelem); //ulozime zaznam
        //uložení výpůjček do souboru
        saveVypujcky();
    }

    private void saveVypujcky() {
        //uložení výpůjček do souboru vypujcky_db.json
        StringBuilder vypujckyJson = new StringBuilder();
        for (Vypujcka vypujcka : vlastniciKnih.values()) {
            vypujckyJson.append(gson.toJson(vypujcka)).append(",").append("\n");
        }
        vypujckyJson.deleteCharAt(vypujckyJson.length() -2);
        try (FileWriter fw = new FileWriter(DB_FILE)) {
            fw.write("[\n");
            fw.write(vypujckyJson.toString());
            fw.write("]");
        } catch (IOException e) {
            throw new RuntimeException("Nemohu zapsat do souboru", e);
        }
    }

    // vnitřní třída pro reprezentaci výpůjčky
    private record Vypujcka(Kniha kniha, Osoba osoba, Date datumVypujcky) {

        /**
         * Vypujcka je jedinecna pro dvojici isbn a id osoby
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vypujcka vypujcka)) return false;
            return Objects.equals(kniha.isbn(), vypujcka.kniha.isbn()) &&
                    Objects.equals(osoba.registracniCislo(), vypujcka.osoba.registracniCislo());
        }

        /**
         * Vypujcka je jedinecna pro dvojici isbn a id osoby
         */
        @Override
        public int hashCode() {
            return Objects.hash(kniha.isbn(), osoba.registracniCislo());
        }
    }

    /**
     * Slouzi pro vyhladavani vypujcky kde datum nehraje roli
     */
    private Vypujcka vypujcka(Kniha kniha, Osoba osoba) {
        return new Vypujcka(kniha, osoba, null);
    }
}
