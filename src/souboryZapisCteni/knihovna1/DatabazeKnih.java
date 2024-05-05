package souboryZapisCteni.knihovna1;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DatabazeKnih {

    private static String DB_FILE = "C:\\Users\\annas\\Documents\\krouzky23\\JavaZac\\2_objekty\\res\\knihy_db.json";
    private final Gson gson = new Gson();
    private final Map<Integer, Kniha> knihy = new HashMap<>();
    private Integer isbn = 0 ;
    public DatabazeKnih() {
        try (FileReader fr = new FileReader(DB_FILE)) {
            Kniha[] knihyArr = gson.fromJson(fr, Kniha[].class);
            if (knihyArr == null) return;
            for (Kniha kniha : knihyArr)
            {
                knihy.put(kniha.isbn(), kniha);
                if (isbn < kniha.isbn()) isbn = kniha.isbn();
            }
        } catch (Exception e) {
            throw new RuntimeException("Nemohu nacist soubor " + DB_FILE , e);
        }
    }

    @Override
    public String toString() {
        String text =  "Databaze knih:\n";
        for (Kniha kniha : knihy.values()) {
            text += "  " + kniha + "\n";
        }
        return text;
    }

    public void registrujKnihu(String jmenoAutora, String prijmeniAutora, String nazevKnihy)
    {
        save(new Kniha(jmenoAutora, prijmeniAutora, nazevKnihy, ++isbn));
    }

    public Kniha najdiKnihu(int isbn) {
        return knihy.get(isbn);
    }

    private void save(Kniha kniha) {
        knihy.put(kniha.isbn(), kniha);
        StringBuilder knihyJson = new StringBuilder();
        for (Kniha knihaSave : knihy.values()) {
            knihyJson.append(gson.toJson(knihaSave));
            knihyJson.append(",\n");
        }
        knihyJson.deleteCharAt(knihyJson.length() - 2);
        try (FileWriter fw = new FileWriter(DB_FILE)) {
            fw.write("[\n");
            fw.write(knihyJson.toString());
            fw.write("]");
        } catch (IOException e) {
            System.out.println("Chyba zapisu do databaze.");
        }
    }
}
