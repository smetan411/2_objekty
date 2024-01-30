package objekty.geometrie2;

public class GeometrieMain {

    public static void main(String[] args) {
        Obdelnik obdelnik = new Obdelnik(0,0,12,8);
        Kruh kruh = new Kruh(0,0,10);
        Ctverec ctverec = new Ctverec(0,0,10);

        System.out.println("////////////////////");

        System.out.println(obdelnik.getNazev());
        System.out.println("obvod: " + obdelnik.vypocitejObvod());
        System.out.println("obsah: " + obdelnik.vypocitejObsah());
        System.out.println("////////////////////");

        System.out.println(kruh.getNazev());
        System.out.println("obvod: " + kruh.vypocitejObvod());
        System.out.println("obsah: " + kruh.vypocitejObsah());
        System.out.println("////////////////////");

        System.out.println(ctverec.getNazev());
        System.out.println("obvod: " + ctverec.vypocitejObvod());
        System.out.println("obsah: " + ctverec.vypocitejObsah());
        System.out.println("////////////////////");
    }
}
