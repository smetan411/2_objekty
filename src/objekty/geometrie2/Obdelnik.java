package objekty.geometrie2;

public class Obdelnik extends Obrazec {

    public double sirka;
    public double delka;

    public Obdelnik(double x, double y, double sirka, double delka) {

        super(x, y);
        this.sirka = sirka;
        this.delka = delka;
    }

    public double getSirka() {
        return sirka;
    }

    public void setSirka(double sirka) {
        this.sirka = sirka;
    }

    public double getDelka() {
        return delka;
    }

    public void setDelka(double delka) {
        this.delka = delka;
    }

    @Override
    public String getNazev() {
        return "obdelnik";
    }

    public double obvod() {
        return 2 * (sirka + delka);
    }

    public double obsah() {
        return sirka * delka;
    }


}
