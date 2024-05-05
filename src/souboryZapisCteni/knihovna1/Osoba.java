package souboryZapisCteni.knihovna1;

import java.util.Objects;

public record Osoba(String jmeno,
                    String prijmeni,
                    int registracniCislo) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Osoba osobaP)) return false;
        return registracniCislo == osobaP.registracniCislo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(registracniCislo);
    }

    @Override
    public String toString() {
        return jmeno + " " + prijmeni + " (reg.cislo: " + registracniCislo + ")";
    }
}
