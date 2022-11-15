package demo;

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
    private String mes_final;

    public Boot(String url, String user, String pass) {
        this.user = user;
        this.pass = pass;
        this.url = url;
    }

    public Boot(String url, String user, String pass, String mes) {
        this.user = user;
        this.pass = pass;
        this.url = url;
        this.mes_inicio = mes;
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
            System.out.println("existe el siguiente error: " + e);
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
        WebElement first_input_date;
        String frasedeautorizacion = "¡ Acceso autorizado !";

        // utilizamos clear para limpiar lo que pueda ver en los inputs
        // utilizamos sendkeys para escribir un string dentro de los inputs
        userbox.clear();
        userbox.sendKeys(this.user);
        passbox.clear();
        passbox.sendKeys(this.pass);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        passbox.submit();
        label_autorizacion = driver.findElement(By.id("swal2-title"));
        boton_autorizacion = driver.findElement(By.xpath("/html/body/div[1]/div/div[10]/button[1]"));
        System.out.println(label_autorizacion.getText());
        boton_autorizacion.click();
        registro_ventas = driver.findElement(By.xpath("/html/body/div/div[15]/div[4]/div[1]/a"));
        registro_ventas.click();
        financiamientos = driver.findElement(By.xpath("/html/body/div/aside[1]/div/nav/ul/li[2]/ul[3]/li/a"));
        financiamientos.click();
        System.out.println("hasta aqui llegamos");
    }

    public void ataqueFuerzaBruta() {
    }

    public void login_nuovo() {
        WebElement userbox = driver.findElement(By.id("outlined-email-input"));
        WebElement passbox = driver.findElement(By.id("outlined-adornment-password"));
        WebElement button_sigin = driver
                .findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div/div/div[2]/div/div/button"));
        WebElement label_devices;
        WebElement button_csv;
        WebElement label_AllDivices;
        WebElement first_input_date;
        WebElement second_input_date;

        userbox.clear();
        userbox.sendKeys(this.user);
        passbox.clear();
        passbox.sendKeys(this.pass);
        button_sigin.click();

        // apartir de aqui hace la autentificacion
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            System.out.println("Entramos arriba del divace");
            label_devices = driver
                    .findElement(By.xpath("//*[@id=" + "'root'" + "]/div/div[1]/div/ul/div[2]/div[2]/div/div/ul/a[2]"));
            label_devices.click();
            Thread.sleep(5000);
            System.out.println("aqui terminamos el click de device");
        } catch (Exception e) {
            // TODO: handle exception
        }
        button_csv = driver
                .findElement(By.xpath("//*[@id=" + "'root'" + "]/div/main/div[1]/div[2]/div[1]/div[2]/div/div/button"));
        button_csv.click();
        label_AllDivices = driver.findElement(By.xpath("//*[@id=" + "'csv-download-menu'" + "]/div[3]/ul/li[1]"));
        label_AllDivices.click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        first_input_date = driver.findElement(By.id("date-picker-inline-from-date"));
        first_input_date.clear();
        first_input_date.sendKeys("01112021");
        second_input_date = driver.findElement(By.id("date-picker-inline-to-date"));
        second_input_date.clear();
        second_input_date.sendKeys("30112021");

        System.out.println("Fin del juego");
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