package objekty.smenarna;

public class SmenarnaBezPoplatku implements Smenarna {

    protected double kurz;
    public SmenarnaBezPoplatku(double kurz) {
        this.kurz = kurz;
    }

    @Override
    public double vykup(double kolik) {
        return kolik/kurz;
    }

    public double prodej(double kolik){
        return kolik*kurz;
    }


}
