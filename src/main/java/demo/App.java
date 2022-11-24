package demo;

/**
 * Hello world!
 *
 */
public class App {
        public static void main(String[] args) {

                /*
                 * Boot bootCredi7 = new Boot("https://credi7.ddns.net/",
                 * "DIGUTIERREZ",
                 * "DGC66818mgr",
                 * "noviembre");
                 * bootCredi7.setUp();
                 * bootCredi7.login_palace();
                 */

                Boot boot_Nuovo_credi7 = new Boot(
                                "https://app.nuovopay.com/",
                                "dgc@ivfinance.mx",
                                "182hemw3q",
                                "November",
                                "2021");

                boot_Nuovo_credi7.setUp();
                boot_Nuovo_credi7.start_nuovo();


                Boot boot_Nuovo_crediwow = new Boot(
                                "https://app.nuovopay.com/",
                                "diegocrediwow@outlook.com",
                                "rjlhqcxw0",
                                "November",
                                "2021");

                boot_Nuovo_crediwow.setUp();
                boot_Nuovo_crediwow.start_nuovo();


                Boot boot_Nuovo_wimopay = new Boot(
                                "https://app.nuovopay.com/",
                                "diegowimopay@outlook.com",
                                "53nlufxsg",
                                "March",
                                "2022");

                boot_Nuovo_wimopay.setUp();
                boot_Nuovo_wimopay.start_nuovo();


                Boot boot_Nuovo_confiacel = new Boot(
                                "https://app.nuovopay.com/",
                                "diegoconfiacel@outlook.com",
                                "zfy8weibm",
                                "May",
                                "2022");

                boot_Nuovo_confiacel.setUp();
                boot_Nuovo_confiacel.start_nuovo();


                Boot boot_Nuovo_celufacil = new Boot(
                                "https://app.nuovopay.com/",
                                "dgc@ivfinance.mx",
                                "182hemw3q",
                                "January",
                                "2022");

                boot_Nuovo_celufacil.setUp();
                boot_Nuovo_celufacil.start_nuovo();


                System.out.println("Exito...............................Ready");


        }

}