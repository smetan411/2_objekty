package objekty.smenarna3;

public class SmenarnaBezPoplatku implements Smenarna {

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
