package demo;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Boot bootCredi7=new Boot(
            "DIGUTIERREZ",
            "DGC66818mgr",
            "https://credi7.ddns.net/",
            "noviembre"
            );
        bootCredi7.setUp();
        bootCredi7.login();
        
    }
}
