package procvicovani1;


public class Zavodnici {

    public static void main(String[] args) {
        poradiZavodniku();
    }

    // na vstupu zadáte počet závodníků a časy, které dosáhli při závodu
    // na výstupu získáte pořadí závodníků i s časy, kterých dosáhli

    public static void poradiZavodniku() {


    }

    class Zavodnik {
        private final String jmeno;
        private final int cas;

        public Zavodnik(String jmeno, int cas) {
            this.jmeno = jmeno;
            this.cas = cas;
        }

        public String getJmeno() {
            return jmeno;
        }

        public int getCas() {
            return cas;
        }

        @Override
        public String toString() {
            return "Zavodnik{" +
                    "jmeno='" + jmeno + '\'' +
                    ", cas=" + cas +
                    '}';
        }
    }
}