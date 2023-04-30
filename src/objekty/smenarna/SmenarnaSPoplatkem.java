package objekty.smenarna;

public class SmenarnaSPoplatkem extends SmenarnaBezPoplatku {

    double poplatekMinimalniKc;
    double poplatekMinimalniEuro;
    double poplatekProcenta;

    public SmenarnaSPoplatkem(double kurz, double poplatekMinimalniKc, double poplatekMinimalniEuro, double poplatekProcenta) {
        super(kurz);
        this.poplatekMinimalniKc = poplatekMinimalniKc;
        this.poplatekMinimalniEuro = poplatekMinimalniEuro;
        this.poplatekProcenta = poplatekProcenta;
    }

    public double vykup(double kolik) {
        double castkaBezPoplatku = kolik / kurz;
        double poplatek = castkaBezPoplatku * poplatekProcenta / 100;
        if (poplatek < poplatekMinimalniEuro) {
            poplatek = poplatekMinimalniEuro;
        }
        return castkaBezPoplatku - poplatek;
    }

    public double prodej(double kolik) {
        double castkaBezPoplatku = kolik * kurz;
        double poplatek = castkaBezPoplatku * poplatekProcenta / 100;
        if (poplatek < poplatekMinimalniKc) {
            poplatek = poplatekMinimalniKc;
        }
        return castkaBezPoplatku - poplatek;
    }
}
