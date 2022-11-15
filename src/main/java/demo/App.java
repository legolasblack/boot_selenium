package demo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        /*
         * Boot bootCredi7=new Boot(
         * "DIGUTIERREZ",
         * "DGC66818mgr",
         * "https://credi7.ddns.net/",
         * "noviembre"
         * );
         * bootCredi7.setUp();
         * bootCredi7.login_palace();
         */

        Boot boot_Nuovo = new Boot(
                "https://app.nuovopay.com/",
                "dgc@ivfinance.mx",
                "182hemw3q");

        boot_Nuovo.setUp();
        boot_Nuovo.login_nuovo();
    }
}
