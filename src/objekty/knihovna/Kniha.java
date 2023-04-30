package objekty.knihovna;

import java.util.Objects;

public final class Kniha {

    final String nazev;
    final String autor;

    public Kniha( String jmeno, String autor) {

        this.nazev = jmeno;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return nazev + " " + autor ;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Kniha kniha = (Kniha) object;
        return Objects.equals(nazev, kniha.nazev) && Objects.equals(autor, kniha.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazev, autor);
    }
}


