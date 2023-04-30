package objekty.geometrie;

public abstract class Obrazec {
    /**
     * x, y jsou souradnice stredu obrazce
     */
    public double x;
    public double y;


    public Obrazec(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract String getNazev() ;


    public abstract double obvod();

    public abstract double obsah();
}
