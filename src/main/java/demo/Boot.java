package demo;

import java.time.LocalDate;
import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Boot {

    private WebDriver driver;
    private String user;
    private String pass;
    private String url;
    private String mes_inicio;
    private String año_inicio;
    // private String mes_final;

    public Boot(String url, String user, String pass) {
        this.user = user;
        this.pass = pass;
        this.url = url;
    }

    public Boot(String url, String user, String pass, String mes, String año) {
        this.user = user;
        this.pass = pass;
        this.url = url;
        this.mes_inicio = mes;
        this.año_inicio = año;
    }

    public void setUp() {

        try {
            // con esta funcion se deve de abrir la direccion de donde se guarde google
            // driver
            System.setProperty("webdriver.chrome.driver", "./src/test/sources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(this.url);

        } catch (Exception e) {
            System.out.println("Error_trycath1_funcion_setUp: " + e);
        }
    }

    public void login_palace() {
        // con el tipo de dato web element podemos instaciar elementos del la pagina:
        WebElement userbox = driver.findElement(By.name("ingUsuario"));
        WebElement passbox = driver.findElement(By.name("ingPassword"));
        WebElement label_autorizacion;
        WebElement boton_autorizacion;
        WebElement registro_ventas;
        WebElement financiamientos;
        // WebElement first_input_date;
        // String frasedeautorizacion = "¡ Acceso autorizado !";

        // utilizamos clear para limpiar lo que pueda ver en los inputs
        // utilizamos sendkeys para escribir un string dentro de los inputs
        userbox.clear();
        userbox.sendKeys(this.user);
        passbox.clear();
        passbox.sendKeys(this.pass);
        try {
            passbox.submit();
            label_autorizacion = driver.findElement(By.id("swal2-title"));
            boton_autorizacion = driver.findElement(By.xpath("/html/body/div[1]/div/div[10]/button[1]"));
            System.out.println(label_autorizacion.getText());
            boton_autorizacion.click();
            Thread.sleep(5000);
            registro_ventas = driver.findElement(By.xpath("/html/body/div/div[16]/div[4]/div[1]/a"));
            registro_ventas.click();
            financiamientos = driver.findElement(By.xpath("/html/body/div/aside[1]/div/nav/ul/li[2]/ul[3]/li/a"));
            financiamientos.click();
            System.out.println("hasta aqui llegamos");
        } catch (Exception e) {
            System.out.println("erros: " + e);
        }
    }

    public void ataqueFuerzaBruta() {
    }

    public void start_nuovo() {
        WebElement userbox = driver.findElement(By.id("outlined-email-input"));
        WebElement passbox = driver.findElement(By.id("outlined-adornment-password"));
        WebElement button_sigin = driver
                .findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div/div/div[2]/div/div/button"));

        // declaracion de variables a utilizar una vez ya logeado
        WebElement label_devices;
        WebElement button_csv;
        WebElement label_AllDivices;
        WebElement first_input_date;
        WebElement dia_inicio_mes;
        WebElement button_dia_inicio;
        WebElement button_dia_final;
        WebElement text_month;
        WebElement button_last_mounth;
        WebElement second_input_date;
        // WebElement button_generate_csv;

        userbox.clear();
        userbox.sendKeys(this.user);
        passbox.clear();
        passbox.sendKeys(this.pass);
        button_sigin.click();

        // apartir de aqui hace la autentificacion
        try {
            Thread.sleep(5000);
            // System.out.println("Entramos arriba del divace");
            label_devices = driver
                    .findElement(By.xpath("//*[@id=" + "'root'" + "]/div/div[1]/div/ul/div[2]/div[2]/div/div/ul/a[2]"));
            label_devices.click();
            Thread.sleep(2000);
            // System.out.println("aqui terminamos el click de device");
            // seleccionamos el button de csv a partir de aqui tenemos que cambiar a un
            // ciclo
            // para generar los reportes desde el primer mes de venta de la empresa hasta la
            // fecha actual.

            button_csv = driver
                    .findElement(
                            By.xpath("//*[@id=" + "'root'" + "]/div/main/div[1]/div[2]/div[1]/div[2]/div/div/button"));
            button_csv.click();

            label_AllDivices = driver.findElement(By.xpath("//*[@id=" + "'csv-download-menu'" + "]/div[3]/ul/li[1]"));
            label_AllDivices.click();

            // a partir de aqui vamos a seleccionar la primer fecha para bajar el reporte
            // tenemos que verificar si es el ultimo mes o es un mes corriente
            Thread.sleep(2000);
            first_input_date=driver.findElement(By.xpath("/html/body/div[15]/div[3]/div/div[2]/div[2]/div[3]/div[1]/div[2]/div/div/button"));
            first_input_date.click();

            String dia_inicio="15";
            String dia_final="1";
            int fila_bandera=0;
            int columna_bandera=0;
            int fila=1;
            int columna=1;
            boolean bandera_salida=false;
            while(true){
                while(true){
                    button_dia_inicio=driver.findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[2]/div/div["+fila+"]/div["+columna+"]/button"));
                    if(button_dia_inicio.getText().equals(dia_inicio)){
                         fila_bandera=fila;
                         columna_bandera=columna;
                         bandera_salida=true;
                         break;
                    }else if(columna==7){
                        fila++;
                        columna=1;
                        break;
                    }else{
                        columna++;
                    } 
                }
                if(bandera_salida){
                    break;
                }
            }
            button_dia_inicio=driver.findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[2]/div/div["+fila_bandera+"]/div["+columna_bandera+"]/button"));
            button_dia_inicio.click();


            //vamos a llenar el segundo calendario 
            bandera_salida=false;
            fila=1;
            columna=1;

            second_input_date=driver.findElement(By.xpath("/html/body/div[15]/div[3]/div/div[2]/div[2]/div[3]/div[2]/div[2]/div/div/button"));
            second_input_date.click();
            while(true){
                while(true){
                    button_dia_final=driver.findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[2]/div/div["+fila+"]/div["+columna+"]/button"));
                    if(button_dia_final.getText().equals(dia_final)){
                         fila_bandera=fila;
                         columna_bandera=columna;
                         bandera_salida=true;
                         break;
                    }else if(columna==7){
                        fila++;
                        columna=1;
                        break;
                    }else{
                        columna++;
                    } 
                }
                if(bandera_salida){
                    break;
                }
            }
            button_dia_final=driver.findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[2]/div/div["+fila_bandera+"]/div["+columna_bandera+"]/button"));
            button_dia_final.click();
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("Fin del juego");
    }

    public void generadorPeriodos() {
        LocalDate fecha = LocalDate.now();
        Month mes = fecha.getMonth();
        System.out.println(mes);
    }
}

// tipos de localizadores para elemntos del dom
/*
 * By.id();
 * By.name();
 * By.className();
 * By.tagName();
 * By.linkText();
 * By.partialLinkText();
 * By.cssSelector();
 * By.xpath();
 * javascript
 */

// date-picker-inline-from-date
// date-picker-inline-to-date

/*
 * Sintaxis de XPath:
 * 
 * 
 * XPath contiene la ruta del elemento situado en la página web. La sintaxis
 * estándar para crear XPath es:
 * 
 * Xpath=//nombreEtiqueta[@atributo='valor']
 * //: Selecciona el nodo actual
 * Nombre Etiqueta: Nombre de la etiqueta del nodo en particular
 * 
 * @: Seleccionar atributo.
 * atributo: nombre de atributo del nodo.
 * valor: valor del atributo.
 */


/* /html/body/div[15]/div[3]/div/div[2]/div[2]/div[3]/div[1]/div[2]/div/div/button

/html/body/div[16]/div[3]/div/div[2]/div[2]/div/div[1]/div[7]/button

/html/body/div[16]/div[3]/div/div[2]/div[2]/div/div[2]/div[7]/button

/html/body/div[16]/div[3]/div/div[2]/div[2]/div/div[2]/div[7]/button/span[1]/p */