package objekty.geometrie2;

//  napiste tridu pro obrazce, kde si obrazce date do pole
//  a jako pole je pro zadane hodnoty vytisknete

public class PoleObrazcuMain {

    public static void main(String[] args) {

        Obrazec[] poleObrazcu = new Obrazec[]{
                new Obdelnik(0, 0, 2, 5),
                new Ctverec(0, 0, 10),
                new Kruh(0, 0, 8)};

        for (int i = 0; i < poleObrazcu.length; i++) {
            System.out.print("pole[" + i + "]: " + poleObrazcu[i].getNazev() + " ");
            System.out.printf(" obvod = %.2f ", poleObrazcu[i].obvod());
            System.out.printf(" obsah = %.2f \n", poleObrazcu[i].obsah());
        }
    }
}