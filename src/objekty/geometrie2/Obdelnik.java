package objekty.geometrie2;

public class Obdelnik extends Obrazec {

    public double sirka;
    public double delka;

    public Obdelnik(double x, double y, double sirka, double delka) {
        super(x, y);
        this.sirka = sirka;
        this.delka = delka;
    }

    @Override
    public String getNazev() {
        return "obdelnik";
    }

    public double vypocitejObvod() {
        return 2 * (sirka + delka);
    }

    public double vypocitejObsah() {
        return sirka * delka;
    }


}
