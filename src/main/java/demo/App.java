package demo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

       /*  Boot bootCredi7 = new Boot("https://credi7.ddns.net/",
                "DIGUTIERREZ",
                "DGC66818mgr",
                "noviembre");
        bootCredi7.setUp();
        bootCredi7.login_palace(); */

        Boot boot_Nuovo = new Boot(
                "https://app.nuovopay.com/",
                "dgc@ivfinance.mx",
                "182hemw3q",
                "November 2021");

        boot_Nuovo.setUp();
        boot_Nuovo.login_nuovo();
    }
}
