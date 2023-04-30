package objekty.knihovna;

import java.util.*;

public class Knihovna {
    private final Map<String, Kniha> knihyPodleNazvu = new HashMap<>();
    private final Map<String, Set<Kniha>> knihyPodleAutora = new HashMap<>();


    void pridejKnihu(Kniha kniha) {
        knihyPodleNazvu.put(kniha.nazev, kniha);
        var knihyAutora = knihyPodleAutora.get(kniha.autor);
        if (knihyAutora == null) {
            knihyAutora = new HashSet<>();
            knihyPodleAutora.put(kniha.autor, knihyAutora);
        }
        knihyAutora.add(kniha);
    }

    void smazKnihu(Kniha kniha) {
        knihyPodleNazvu.remove(kniha.nazev);
        knihyPodleAutora.remove(kniha.autor);
    }

    Kniha najdiKnihuPodleNazvu(String nazevKnihy) {
        return knihyPodleNazvu.get(nazevKnihy);
    }


    Set<Kniha> najdiKnihyPodleAutora(String jmenoAutora) {
        return knihyPodleAutora.get(jmenoAutora);
    }


    void vypisVsechKnih() {
        //varianta:  knihyPodleNazvu.values().forEach(kniha -> System.out.println(kniha));
        knihyPodleNazvu.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Knihovna knihovna = new Knihovna();
        knihovna.pridejKnihu(new Kniha("Vinetou","Karel May" ));
        knihovna.pridejKnihu(new Kniha("Svejk","Jaroslav Hasek" ));
        knihovna.pridejKnihu(new Kniha("Babicka","Bozena Nemcova" ));
        knihovna.pridejKnihu(new Kniha("Kral prstenu","John Ronald Tolkien"));
        knihovna.pridejKnihu(new Kniha("Povidky","Karel Capek" ));
        knihovna.pridejKnihu(new Kniha("Temno","Alois Jirasek" ));
        knihovna.pridejKnihu(new Kniha("Smrt na Nilu","Agatha Christie" ));
        knihovna.pridejKnihu(new Kniha("Deset malých černoušků","Agatha Christie" ));
        knihovna.pridejKnihu(new Kniha("Vraždy podle abecedy","Agatha Christie" ));
        knihovna.pridejKnihu(new Kniha("Saturnin","Zdeněk Jirotka" ));

        knihovna.vypisVsechKnih();
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej nazev knihy.");
        System.out.println( knihovna.najdiKnihuPodleNazvu(sc.nextLine()));
        System.out.println();
        System.out.println("Zadej autora.");
        System.out.println( knihovna.najdiKnihyPodleAutora(sc.nextLine()));
    }
}
