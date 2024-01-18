package objekty.knihovna4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Knihovna {
    private final DatabazeOsob databazeOsob;
    private final DatabazeKnih databazeKnih;

    // vlastnik je knihy je jen jeden, ale je zvykem psat nazvy kolekci v mnoznem cisle
    private final Map<Kniha, Osoba> vlastniciKnih = new HashMap<>();
    private final Map<Osoba, Set<Kniha>> vsechnyPujceneKnihy = new HashMap<>();

    public Knihovna(DatabazeOsob databazeOsob, DatabazeKnih databazeKnih) {
        this.databazeOsob = databazeOsob;
        this.databazeKnih = databazeKnih;
    }

    public Set<Kniha> pujceneKnihy(Osoba osoba) {
        return vsechnyPujceneKnihy.get(osoba);
    }

    public Osoba kdoMaKnihu(Kniha kniha) {
        return vlastniciKnih.get(kniha);
    }

    public void vypujckaKnihy(int registracniCisloOsoby, int  isbn) {
        Kniha kniha = databazeKnih.najdiKnihu(isbn);
        Osoba osoba = databazeOsob.najdiOsobu(registracniCisloOsoby);
        vlastniciKnih.put(kniha, osoba);
        Set<Kniha> pujceneKnihyUzivatelem;
        if (vsechnyPujceneKnihy.containsKey(osoba)) {
            //nacteme, ktere knihy ma uz uzivatel pujcene
            pujceneKnihyUzivatelem = vsechnyPujceneKnihy.get(osoba);
        } else {
            //zalozime uzivateli novou sadu pro vypujcovani knih
            pujceneKnihyUzivatelem = new HashSet<>();
        }
        pujceneKnihyUzivatelem.add(kniha); //pridame knihu
        vsechnyPujceneKnihy.put(osoba, pujceneKnihyUzivatelem); //ulozime zaznam
    }

    public void vraceniKnihy(int registracniCisloOsoby, int  isbn) {
        Kniha kniha = databazeKnih.najdiKnihu(isbn);
        Osoba osoba = databazeOsob.najdiOsobu(registracniCisloOsoby);
        vlastniciKnih.remove(kniha);
        Set<Kniha> pujceneKnihyUzivatelem = vsechnyPujceneKnihy.get(osoba);
        if (pujceneKnihyUzivatelem == null) return;
        pujceneKnihyUzivatelem.remove(kniha); // odstranime knihu
        vsechnyPujceneKnihy.put(osoba, pujceneKnihyUzivatelem);//ulozime zaznam
    }
}
