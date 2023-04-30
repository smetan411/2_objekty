package objekty.geometrie;

public class GeometrieMain {

    public static void main(String[] args) {
        Ctverec ctverec = new Ctverec(0,0,10);
        Obdelnik obdelnik = new Obdelnik(0,0,12,8);
        KruhVypocet kruhVypocet = new KruhVypocet(20);

        System.out.println("Obsah kruhu je " + kruhVypocet.obsah() + " metru ctverecnich.");
        System.out.println("Obvod kruhu je " + kruhVypocet.obvod() + " metru.");


//        System.out.println(obdelnik.getNazev());
//        System.out.println("obvod: " + obdelnik.obvod());
//        System.out.println("obsah: " + obdelnik.obsah());
//        System.out.println("////////////////////");
//        System.out.println(ctverec.getNazev());
//        System.out.println("obvod: " + ctverec.obvod());
//        System.out.println("obsah: " + ctverec.obsah());
//        System.out.println("////////////////////");
    }
}
