package souboryZapisCteni.knihovna1;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DatabazeOsob {

    private static String DB_FILE = "C:\\Users\\annas\\Documents\\Krouzky\\JavaZac\\2_objekty\\res\\osoby_db.json";
    private final Gson gson = new Gson();
    private final Map<Integer, Osoba> osoby = new HashMap<>();
    private Integer registracniCislo = 0 ;
    public DatabazeOsob() {
        try (FileReader fr = new FileReader(DB_FILE)) {
            Osoba[] osobyArr = gson.fromJson(fr, Osoba[].class);
            if (osobyArr == null) return;
            for (Osoba osoba : osobyArr)
            {
                osoby.put(osoba.registracniCislo(), osoba);
                if (registracniCislo < osoba.registracniCislo()) registracniCislo = osoba.registracniCislo();
            }
        } catch (Exception e) {
            throw new RuntimeException("Nemohu nacist soubor " + DB_FILE , e);
        }

    }

    @Override
    public String toString() {
        String text =  "Databaze osob:\n";
        for (Osoba osoba : osoby.values()) {
            text += "  " + osoba + "\n";
        }
        return text;
    }

    public void registrujOsobu(String jmeno, String prijmeni)
    {
        save(new Osoba(jmeno, prijmeni, ++registracniCislo));
    }

    public Osoba najdiOsobu(int registracniCisloOsoby) {
        return osoby.get(registracniCisloOsoby);
    }

    private void save(Osoba osoba)
    {
        osoby.put(osoba.registracniCislo(), osoba);
        StringBuilder osobyJson = new StringBuilder();
            for (Osoba osobaSave : osoby.values()) {
                osobyJson.append(gson.toJson(osobaSave));
                osobyJson.append(",\n");
            }
            osobyJson.deleteCharAt(osobyJson.length() - 2);
        try (FileWriter fw = new FileWriter(DB_FILE)) {
            fw.write("[\n");
            fw.write(osobyJson.toString());
            fw.write("]");
        } catch (IOException e) {
            throw new RuntimeException("Nemuzu zapsat do souboru", e);
        }
    }
}
