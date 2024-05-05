package souboryZapisCteni.knihovna1;

import java.util.Objects;

public record Kniha(String jmenoAutora,
                    String prijmeniAutora,
                    String nazevKnihy,
                    int isbn) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kniha knihaP)) return false;
        return isbn == knihaP.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "kniha: " + nazevKnihy + "\n" +
               "autor: " + jmenoAutora + " " + prijmeniAutora + "\n" +
               "isbn: " + isbn;
    }
}
