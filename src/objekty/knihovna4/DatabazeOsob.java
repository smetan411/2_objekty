package objekty.knihovna4;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;

public class DatabazeOsob {

    private final Map<Integer, Osoba> osoby = new HashMap<>();
    private Integer registracniCislo = 0 ;
    public DatabazeOsob() {
        registracniCislo++;
        osoby.put(registracniCislo, new Osoba("John", "Smith", registracniCislo));
        registracniCislo++;
        osoby.put(registracniCislo, new Osoba("Jan", "Novak", registracniCislo));
        registracniCislo++;
        osoby.put(registracniCislo, new Osoba("Jana", "Novakova", registracniCislo));
    }

    @Override
    public String toString() {
        return "DatabazeOsob{" +
                "osoby=" + osoby +
                ", registracniCislo=" + registracniCislo +
                '}';
    }

    public void registrujOsobu(String jmeno, String prijmeni)
    {
        registracniCislo++;
        osoby.put(registracniCislo, new Osoba(jmeno, prijmeni, registracniCislo));
    }

    public Osoba najdiOsobu(int registracniCisloOsoby) {
        return osoby.get(registracniCisloOsoby);
    }
}
