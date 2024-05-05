package objekty.smenarna3;

public class SmenarnaSPoplatkem extends SmenarnaBezPoplatku {

    double poplatekProcenta;

    public SmenarnaSPoplatkem(double kurz, double poplatekProcenta) {
        super(kurz);
        this.poplatekProcenta = poplatekProcenta;
    }
    @Override
    public double smenaKorunaCiziMena(double kolik) {
        double castkaBezPoplatku = super.smenaKorunaCiziMena(kolik);
        double poplatek = castkaBezPoplatku * (poplatekProcenta / 100);
        return castkaBezPoplatku - poplatek;
    }
    @Override
    public double smenaCiziMenaKoruna(double kolik) {
        double castkaBezPoplatku = super.smenaCiziMenaKoruna(kolik);
        double poplatek = castkaBezPoplatku * (poplatekProcenta / 100);
        return castkaBezPoplatku - poplatek;
    }
}
