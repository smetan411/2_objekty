package objekty.geometrie2;

public class Ctverec extends Obdelnik {

    public Ctverec(double x, double y, double delka) {
        super(x, y, delka, delka);
    }

    @Override
    public String getNazev() {
        return "ctverec";
    }
}


