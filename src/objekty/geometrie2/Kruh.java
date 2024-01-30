package objekty.geometrie2;

public class Kruh extends Obrazec {

    protected double polomer;

    public Kruh(double x, double y, double polomer) {
        super(x, y);
        this.polomer = polomer;
    }

    public String getNazev(){
        return "kruh";
    }

    public double vypocitejObvod() {
        return 2 * 3.14159 * polomer;
    }

    public double vypocitejObsah() {
        return 3.14159 * polomer * polomer;
    }
}

