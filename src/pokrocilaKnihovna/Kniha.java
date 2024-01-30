package pokrocilaKnihovna;

public record Kniha(String jmenoAutora,
                    String prijmeniAutora,
                    String nazevKnihy,
                    int isbn) {
    @Override
    public String toString() {
        return "kniha: " + nazevKnihy + "\n" +
               "autor: " + jmenoAutora + " " + prijmeniAutora + "\n" +
               "isbn: " + isbn;
    }
}
