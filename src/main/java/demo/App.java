package demo;

import java.util.List;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {
        public static void main(String[] args) throws Exception {

                Boot boot_Nuovo_fiacel = new Boot(
                                "https://app.nuovopay.com/",
                                "diegofiacel@outlook.com",
                                "ba0mdgl4p",
                                "July",
                                "2021");

                boot_Nuovo_fiacel.setUp();
                boot_Nuovo_fiacel.start_nuovo_fiacel();
                boot_Nuovo_fiacel.Download_nuovo();


              
                
        }


}
