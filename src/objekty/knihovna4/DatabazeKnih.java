package objekty.knihovna4;

import java.util.HashMap;
import java.util.Map;

public class DatabazeKnih {

    private final Map<Integer, Kniha> knihy = new HashMap<>();
    private Integer isbn = 0;
    public DatabazeKnih() {
        isbn++;
        knihy.put(isbn, new Kniha("Tomas", "Pruzny", "Joga", isbn));
        isbn++;
        knihy.put(isbn, new Kniha("Josef", "Uspesny", "Java", isbn));
        isbn++;
        knihy.put(isbn, new Kniha("Jana", "Sporiva", "Finance", isbn));
        isbn++;
        knihy.put(isbn, new Kniha("Alena", "Stihla", "Polevky", isbn));
        isbn++;
        knihy.put(isbn, new Kniha("Adam", "Rambo", "Cviceni", isbn));
    }

    @Override
    public String toString() {
        return "DatabazeKnih{" +
                "knihy=" + knihy +
                ", isbn=" + isbn + "\n" +
                "}\n";
    }

    public void registrujKnihu(String jmenoAutora, String prijmeniAutora, String nazevKnihy)
    {
        isbn++;
        knihy.put(isbn, new Kniha(jmenoAutora, prijmeniAutora, nazevKnihy, isbn));
    }

    public Kniha najdiKnihu(int isbn) {
        return knihy.get(isbn);
    }

}
