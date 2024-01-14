package objekty.smenarna3;

public class SmenarnaBezPoplatku implements Smenarna {

    // jedna se o kurz vyjadrujici, kolik korun ziskame za 1 euro, 1 dolar apod.
    // tj. např. 25 korun za 1 euro, 23 korun za 1 dolar
    protected double kurz;
    public SmenarnaBezPoplatku(double kurz) {
        this.kurz = kurz;
    }

    @Override
    public double smenaKorunaCiziMena(double kolik) {
        return kolik/kurz;
    }

    public double smenaCiziMenaKoruna(double kolik){
        return kolik*kurz;
    }
}
