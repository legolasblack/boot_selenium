package demo;

import java.util.List;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {
        public static void main(String[] args) throws Exception {

                Boot boot_Nuovo_credi7 = new Boot(
                                "https://app.nuovopay.com/",
                                "dgc@ivfinance.mx",
                                "182hemw3q",
                                "November",
                                "2021");// el año real es 2021

                Boot boot_Nuovo_crediwow = new Boot(
                                "https://app.nuovopay.com/",
                                "diegocrediwow@outlook.com",
                                "rjlhqcxw0",
                                "November",
                                "2021");

                Boot boot_Nuovo_wimopay = new Boot(
                                "https://app.nuovopay.com/",
                                "diegowimopay@outlook.com",
                                "53nlufxsg",
                                "March",
                                "2022");

                Boot boot_Nuovo_celufacil = new Boot(
                                "https://app.nuovopay.com/",
                                "diegocelufacil@outlook.com",
                                "xkgns35bl",
                                "January",
                                "2022");

                Boot boot_Nuovo_confiacel = new Boot(
                                "https://app.nuovopay.com/",
                                "diegoconfiacel@outlook.com",
                                "zfy8weibm",
                                "May",
                                "2022");

                Boot boot_Nuovo_fiacel = new Boot(
                                "https://app.nuovopay.com/",
                                "diegofiacel@outlook.com",
                                "ba0mdgl4p",
                                "July",
                                "2021");

                boot_Nuovo_credi7.setUp();
                boot_Nuovo_credi7.start_nuovo();
                boot_Nuovo_credi7.Download_nuovo(); 

                 boot_Nuovo_crediwow.setUp();
                boot_Nuovo_crediwow.start_nuovo();
                boot_Nuovo_crediwow.Download_nuovo(); 

                boot_Nuovo_wimopay.setUp();
                boot_Nuovo_wimopay.start_nuovo();
                boot_Nuovo_wimopay.Download_nuovo();

                boot_Nuovo_celufacil.setUp();
                boot_Nuovo_celufacil.start_nuovo();
                boot_Nuovo_celufacil.Download_nuovo(); 

                boot_Nuovo_confiacel.setUp();
                boot_Nuovo_confiacel.start_nuovo();
                boot_Nuovo_confiacel.Download_nuovo();
                
                boot_Nuovo_fiacel.setUp();
                boot_Nuovo_fiacel.start_nuovo();
                boot_Nuovo_fiacel.Download_nuovo();

        }

}
