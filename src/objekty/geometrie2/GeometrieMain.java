package objekty.geometrie2;

public class GeometrieMain {

    public static void main(String[] args) {

        System.out.println("////////////////////");
        Ctverec ctverec = new Ctverec(0,0,10);
        Obdelnik obdelnik = new Obdelnik(0,0,12,8);
        Kruh kruh = new Kruh(0,0,10);

        System.out.println(kruh.getNazev());
        System.out.println("obvod: " + kruh.obvod());
        System.out.println("obsah: " + kruh.obsah());
        System.out.println("////////////////////");

        System.out.println(obdelnik.getNazev());
        System.out.println("obvod: " + obdelnik.obvod());
        System.out.println("obsah: " + obdelnik.obsah());
        System.out.println("////////////////////");


        System.out.println(ctverec.getNazev());
        System.out.println("obvod: " + ctverec.obvod());
        System.out.println("obsah: " + ctverec.obsah());
        System.out.println("////////////////////");
    }
}
