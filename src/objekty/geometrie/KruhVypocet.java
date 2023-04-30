package objekty.geometrie;

public class KruhVypocet {

//    Definujte jednoduchou třídu, která bude popisovat kruh se zadaným poloměrem
//    a která umožní výpočet jeho obvodu a plochy.
//    Doplnte konstruktor, getter a setter pro poloměr - v Idei alt+ins

    private double polomer;      // poloměr

    public KruhVypocet(double polomer) {
        this.polomer = polomer;
    }

    public double getPolomer() {
        return polomer;
    }

    public void setPolomer(double polomer) {
        this.polomer = polomer;
    }

    public double obvod() {
        return 2 * 3.14159 * polomer;
    }

    public double obsah() {
        return 3.14159 * polomer * polomer;
    }
}

