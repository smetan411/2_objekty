package objekty.tridy1;

public class Auto {

    private String typ;
    private int vek;
    private String barva;


    //konstruktor
   public Auto(String typ, int vek, String barva) {
        this.typ = typ;
        this.vek = vek;
        this.barva = barva;
    }


      public void tankuje() {

        System.out.println("Ja jsem auto " + typ + ". Ham mńam benzín!");
    }

    public void jede() {

        System.out.println("Ja jsem auto " + typ + " Bacha jedu, uhněte!!");
    }

    public static void main(String[] args) {
        Auto autoFord = new Auto("Ford", 5, "černá");
        Auto mojeAudi = new Auto("Audi", 7, "bílá");
        autoFord.tankuje();
        mojeAudi.jede();

    }
}
