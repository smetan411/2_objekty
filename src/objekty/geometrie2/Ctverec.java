package objekty.geometrie2;

public class Ctverec extends Obdelnik {

    public Ctverec(double x, double y, double delkaStrany) {
        super(x, y, delkaStrany, delkaStrany);
    }

    @Override
    public String getNazev() {

        return "ctverec";
    }
}


