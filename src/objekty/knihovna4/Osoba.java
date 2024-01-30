package objekty.knihovna4;

public record Osoba(String jmeno,
                    String prijmeni,
                    int registracniCislo) {
    @Override
    public String toString() {
        return jmeno + " " + prijmeni + " (reg.cislo: " + registracniCislo + ")";
    }
}
