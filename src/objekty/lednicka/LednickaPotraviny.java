package objekty.lednicka;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LednickaPotraviny {
    // napiš třídu, která popisuje objekt, např. hračku, domácí spotřebič, zvíře, dopravní prostředek
    // objekt bude mít alespoň dvě proměnné jako popis vlastností, např. int, String, boolean
    // třída bude obsahovat konstruktor (alt + ins)
    // třída bude mít alespoň jednu metodu, ve které proměnné použije a něco vytiskne
    // spouštěcí metoda bude na konci třídy za metodami
    // vytvoříme zde dvě různé instance třídy a zavoláme jejich metody

    private final List<Potravina> seznamPotravin = new ArrayList<>();

    public void pridejPotravinu(Potravina pridavanaPotravina) {
        if (seznamPotravin.contains(pridavanaPotravina)) {
            int i = seznamPotravin.indexOf(pridavanaPotravina);
            Potravina potravinaVLednicce = seznamPotravin.get(i);
            seznamPotravin.set(i,
                    new Potravina(pridavanaPotravina.nazevPotraviny, potravinaVLednicce.mnozstvi + pridavanaPotravina.mnozstvi));
            System.out.println("Pridali jsme " + pridavanaPotravina.nazevPotraviny + " v mnozstvi " + pridavanaPotravina.mnozstvi);
        } else {
            seznamPotravin.add(pridavanaPotravina);
            System.out.println("Pridali jsme " + pridavanaPotravina.nazevPotraviny + " v mnozstvi " + pridavanaPotravina.mnozstvi);
        }
    }

    public void odeberPotravinu(Potravina odebiranaPotravina) {
        if (seznamPotravin.contains(odebiranaPotravina)) {
            int i = seznamPotravin.indexOf(odebiranaPotravina);
            Potravina potravinaVLednicce = seznamPotravin.get(i);
            if (potravinaVLednicce.mnozstvi == 0) {
                System.out.println("Chces odebrat " + odebiranaPotravina.nazevPotraviny + ", ale v lednicce vubec neni.");
            } else if (potravinaVLednicce.mnozstvi >= odebiranaPotravina.mnozstvi) {
                seznamPotravin.set(i,
                        new Potravina(odebiranaPotravina.nazevPotraviny, potravinaVLednicce.mnozstvi - odebiranaPotravina.mnozstvi));
                System.out.println("Odebrali jsme " + odebiranaPotravina.nazevPotraviny + " v mnozstvi " + odebiranaPotravina.mnozstvi);
            } else if (potravinaVLednicce.mnozstvi < odebiranaPotravina.mnozstvi) {
                System.out.println("Tolik tam toho " + odebiranaPotravina.nazevPotraviny + " neni.");
            }
        }
    }

    public void vytiskniLednicku() {
        System.out.println("Tisknu obsah lednicky:");
        seznamPotravin.forEach(potravina -> System.out.println(potravina));
        //seznamPotravin.forEach(System.out::println);
    }

    private final static class Potravina {
        private final String nazevPotraviny;
        private final int mnozstvi;

        public Potravina(String nazevPotraviny, int mnozstvi) {
            this.nazevPotraviny = nazevPotraviny;
            this.mnozstvi = mnozstvi;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Potravina potravina = (Potravina) o;
            return nazevPotraviny.equals(potravina.nazevPotraviny);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nazevPotraviny);
        }

        @Override
        public String toString() {
            return "Potravina : " + "nazevPotraviny='" + nazevPotraviny + '\'' +  "' , mnozstvi=" + mnozstvi;
        }

    }


    public static void main(String[] args) {
        LednickaPotraviny lednickaPotraviny = new LednickaPotraviny();
        lednickaPotraviny.pridejPotravinu(new Potravina("mleko", 1));
        lednickaPotraviny.pridejPotravinu(new Potravina("mleko", 2));
        lednickaPotraviny.pridejPotravinu(new Potravina("rohlik", 2));
        lednickaPotraviny.pridejPotravinu(new Potravina("chleba", 2));
        lednickaPotraviny.vytiskniLednicku();
        lednickaPotraviny.odeberPotravinu(new Potravina("rohlik", 2));
        lednickaPotraviny.odeberPotravinu(new Potravina("rohlik", 2));
    }
}
