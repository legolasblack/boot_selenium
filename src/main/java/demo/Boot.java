package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Boot {

    private WebDriver driver;
    private String user_palace;
    private String pass_palace;
    private String url_palace;
    private String frasedeautorizacion="¡ Acceso autorizado !";
    private String mes_inicio;
    private String mes_final;

    public Boot(String user, String pass, String url, String mes){
        this.user_palace=user;
        this.pass_palace=pass;
        this.url_palace=url;
        this.mes_inicio=mes;
    }

    public void setUp() {

        try {
            // con esta funcion se deve de abrir la direccion de donde se guarde google
            // driver
            System.setProperty("webdriver.chrome.driver", "./src/test/sources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(this.url_palace);
        } catch (Exception e) {
            System.out.println("existe el siguiente error: " + e);
        }
    }

    public void login() {
        // con el tipo de dato web element podemos instaciar elementos del la pagina:
        WebElement userbox = driver.findElement(By.name("ingUsuario"));
        WebElement passbox = driver.findElement(By.name("ingPassword"));
        WebElement label_autorizacion;
        WebElement boton_autorizacion;
        WebElement registro_ventas;
        WebElement financiamientos;
        WebElement first_input_date;


        // utilizamos clear para limpiar lo que pueda ver en los inputs
        // utilizamos sendkeys para escribir un string dentro de los inputs
        userbox.clear();
        userbox.sendKeys(this.user_palace);
        passbox.clear();
        passbox.sendKeys(this.pass_palace);
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
        registro_ventas =driver.findElement(By.xpath("/html/body/div/div[15]/div[4]/div[1]/a"));
        registro_ventas.click();
        financiamientos= driver.findElement(By.xpath("/html/body/div/aside[1]/div/nav/ul/li[2]/ul[3]/li/a"));
        financiamientos.click();
        System.out.println("hasta aqui llegamos");
    }
    

    public void ataqueFuerzaBruta(){
    }


}


//tipos de localizadores para elemntos del dom 
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