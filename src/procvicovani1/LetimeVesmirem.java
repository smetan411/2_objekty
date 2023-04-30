package procvicovani1;

// nase Zeme se otaci a zpusobuje, ze letime vysokou rychlosti
// vesmirem jen na zaklade tohoto otaceni, vypoctete tuto rychlost
// vytvorte ve tride dva atributy tj. dve privatni promenne DOBA_OTACENI a POLOMER_ZEME
// polomer Zeme je 6378 km a jeji obvod se vypocita o = 2*PI*r

public class LetimeVesmirem {

    private final int DOBA_OTACENI = 24; //hodin
    private final int POLOMER_ZEMEKOULE = 6378; // kilometrů

    public LetimeVesmirem() {
    }

    public double rychlost() {
        double trasa = 2 * Math.PI * POLOMER_ZEMEKOULE;
        double rychlostLetime = trasa / DOBA_OTACENI;
        return rychlostLetime;  // km/hodinu
    }

    public static void main(String[] args) {
        LetimeVesmirem letime = new LetimeVesmirem();
        double rychlostLetu = letime.rychlost();
        System.out.printf("Vesmirem letime rychlosti %.2f km/hod jen diky otaceni Zeme.\n", rychlostLetu) ;
    }
}
