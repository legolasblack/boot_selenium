package demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;

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
    private int reportCount;
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

    public void setUp() throws Exception {

        try {
            // con esta funcion se deve de abrir la direccion de donde se guarde google
            // driver
            System.setProperty("webdriver.chrome.driver", "./src/test/sources/drivers/chromedriver_latest.exe");
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

    public void start_nuovo() throws Exception {
        WebElement userbox = driver.findElement(By.id("outlined-email-input"));
        WebElement passbox = driver.findElement(By.id("outlined-adornment-password"));
        WebElement button_sigin = driver
                .findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div/div/div[2]/div/div/button"));

        // declaracion de variables a utilizar una vez ya logeado
        WebElement label_devices;
        WebElement button_csv;
        WebElement label_AllDivices;
        WebElement first_input_date;
        WebElement button_dia_inicio;
        WebElement button_dia_final;
        WebElement second_input_date;
        WebElement button_generate_csv;
        WebElement button_last_month_2;
        WebElement button_last_month;
        WebElement button_next_month;
        WebElement label_month;
        WebElement label_month_2 = null;
        List<Fechas_Reporte> listaReportes = generadorPeriodos();
        Fechas_Reporte Reporte;
        String mes_y_año;
        int verificardorprimerreporte = 0;

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
            Thread.sleep(1000);
            // System.out.println("aqui terminamos el click de device");
            // seleccionamos el button de csv a partir de aqui tenemos que cambiar a un
            // ciclo
            // para generar los reportes desde el primer mes de venta de la empresa hasta la
            // fecha actual.
            for (int z = listaReportes.size() - 1; z >= 0; z--) {
                Reporte = listaReportes.get(z);
                System.out.println(Reporte.getMes());
                button_csv = driver
                        .findElement(
                                By.xpath("//*[@id=" + "'root'"
                                        + "]/div/main/div[1]/div[2]/div[1]/div[2]/div/div/button"));
                //// *[@id="root"]/div/main/div[1]/div[2]/div[1]/div[2]/div/div/button
                button_csv.click();

                label_AllDivices = driver
                        .findElement(By.xpath("//*[@id=" + "'csv-download-menu'" + "]/div[3]/ul/li[1]"));
                label_AllDivices.click();

                // a partir de aqui vamos a seleccionar la primer fecha para bajar el reporte
                // tenemos que verificar si es el ultimo mes o es un mes corriente
                Thread.sleep(300);
                first_input_date = driver.findElement(
                        By.xpath("/html/body/ div[15]/div[3]/div/div[2]/div[2]/div[3]/div[1]/div[2]/div/div/button"));
                /// html/body
                /// /div[3]/div[3]/div/div[2]/div[2]/div[3]/div[1]/div[2]/div/div/button
                first_input_date.click();
                // aqui encontramos un problema ya que la pagina de nuovo no abre en el mes
                // actual abre un mes asia atras
                // y para no hacer la lectura de ajuste de mes se harcodeo a avanzar uno asia
                // adelante por el momento
                // de querer remplazarlo hacer un algoritmo que avance el mes o atrace segun lo
                // que se necesite
                if (verificardorprimerreporte == 0) {
                    button_next_month = driver
                            .findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[1]/div[1]/button[2]"));
                    button_next_month.click();
                    verificardorprimerreporte++;
                }
                Thread.sleep(200);
                label_month = driver.findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[1]/div[1]/div"));
                mes_y_año = (Reporte.getMes() + " " + Reporte.getAño());
                // mes_y_año="October 2022";
                button_last_month = driver
                        .findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[1]/div[1]/button[1]"));
                // corregir esta seccion de variables(redireccionar a zona de variables)
                String dia_inicio = Reporte.getDia_inicio();
                String dia_final = Reporte.getDia_fin();
                int fila_bandera = 0;
                int columna_bandera = 0;
                int fila = 1;
                int columna = 1;
                boolean bandera_salida = false;
                while (true) {
                    while (true) {
                        while (true) {
                            if (!(label_month.getText().equals(mes_y_año))) {
                                button_last_month.click();
                                Thread.sleep(200);
                            } else {
                                break;
                            }
                        }
                        button_dia_inicio = driver
                                .findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[2]/div/div[" + fila
                                        + "]/div[" + columna + "]/button"));
                        if (button_dia_inicio.getText().equals(dia_inicio)) {
                            fila_bandera = fila;
                            columna_bandera = columna;
                            bandera_salida = true;
                            break;
                        } else if (columna == 7) {
                            fila++;
                            columna = 1;
                            break;
                        } else {
                            columna++;
                        }
                    }
                    if (bandera_salida) {
                        break;
                    }
                }
                button_dia_inicio = driver.findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[2]/div/div["
                        + fila_bandera + "]/div[" + columna_bandera + "]/button"));
                button_dia_inicio.click();

                // vamos a llenar el segundo calendario
                bandera_salida = false;
                fila = 1;
                columna = 1;
                second_input_date = driver.findElement(
                        By.xpath("/html/body/div[15]/div[3]/div/div[2]/div[2]/div[3]/div[2]/div[2]/div/div/button"));
                second_input_date.click();
                Thread.sleep(200);
                button_last_month_2 = driver
                        .findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[1]/div[1]/button[1]"));
                label_month_2 = driver.findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[1]/div[1]/div"));
                /*
                 * if(label_month_2!=null){
                 * System.out.println("si se relleno");
                 * }else{
                 * System.out.println("no se relleno");
                 * }
                 * System.out.println(label_month_2.getText());
                 */
                while (true) {
                    while (true) {
                        // System.out.println(label_month_2.getText());
                        while (true) {
                            if (!(label_month_2.getText().equals(mes_y_año))) {
                                button_last_month_2.click();
                                Thread.sleep(100);
                            } else {
                                break;
                            }
                        }
                        button_dia_final = driver
                                .findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[2]/div/div[" + fila
                                        + "]/div[" + columna + "]/button"));
                        if (button_dia_final.getText().equals(dia_final)) {
                            fila_bandera = fila;
                            columna_bandera = columna;
                            bandera_salida = true;
                            break;
                        } else if (columna == 7) {
                            fila++;
                            columna = 1;
                            break;
                        } else {
                            columna++;
                        }
                    }
                    if (bandera_salida) {
                        break;
                    }
                }
                button_dia_final = driver.findElement(By.xpath("/html/body/div[16]/div[3]/div/div[2]/div[2]/div/div["
                        + fila_bandera + "]/div[" + columna_bandera + "]/button"));
                button_dia_final.click();

                // boton cancelar
                //button_generate_csv = driver.findElement(By.xpath("/html/body/div[15]/div[3]/div/div[3]/button[1]"));

                // boton generador
                button_generate_csv=driver.findElement(By.xpath("/html/body/div[15]/div[3]/div/div[3]/button[2]"));

                button_generate_csv.click();
                reportCount++;

            }
            // hasta aqui termina el ciclo
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("Fin del juego");
    }

    public void Download_nuovo() throws Exception{
        WebElement label_reports;
        WebElement button_divices_report;
        WebElement tableBody;
        WebElement table;
        WebElement linkDownload;
        WebElement buttonNextReports;
        WebElement buttonsChangePage;
        List <WebElement>rowList=new ArrayList<>();
        List <WebElement>columnlList=new ArrayList<>();
        List <WebElement>buttonsList=new ArrayList<>();
        int rowindex=0;

        try {
            Thread.sleep(60000);
            label_reports = driver
                    .findElement(By.xpath("//*[@id=" + "'root'" + "]/div/div[1]/div/ul/div[3]/div[2]/div/div/ul/a[1]"));
            label_reports.click();
            Thread.sleep(500);
            button_divices_report = driver
                    .findElement(By.xpath("//*[@id=" + "'root'" + "]/div/main/div[1]/div[2]/div[2]/a"));
            button_divices_report.click();
            Thread.sleep(500);
            tableBody=driver.findElement(By.xpath("//*[@id="+"'root'"+"]/div/main/div[1]/div[3]/div/div/div/div/table/tbody"));
            System.out.println(tableBody.isDisplayed());
            rowList=tableBody.findElements(By.tagName("tr"));
            for(int i=0;i<this.reportCount;i++){
           // for(int i=0;i<=14;i++){
                if(rowindex<10){
                    columnlList=rowList.get(rowindex).findElements(By.tagName("td"));
                    linkDownload=columnlList.get(columnlList.size()-1).findElement(By.tagName("a"));
                    linkDownload.click();
                    System.out.println("Idreport: "+columnlList.get(0).getText());
                    rowindex++;
                }else{
                    //En sta seccion se implementa una lista para leer de manera dinamica el ultimo boton ya que se autogeneran 
                    //dependiendo de la cantidad de reportes y se mueve el xpath si lo dejamos fijo 
                    //se opto por hacer una lectura dinamica de los botnos y acceder a la ultima posicion del mismo
                    buttonsChangePage=driver.findElement(By.xpath("//*[@id="+"'root'"+"]/div/main/div[1]/div[3]/div/div[2]/nav/ul"));
                    buttonsList=buttonsChangePage.findElements(By.tagName("button")); 
                    buttonNextReports=buttonsList.get(buttonsList.size()-1);
                    buttonNextReports.click();
                    Thread.sleep(500);
                    rowindex=0;
                    table=driver.findElement(By.xpath("//*[@id="+"'root'"+"]/div/main/div[1]/div[3]/div/div[1]/div/div/table"));
                    tableBody=table.findElement(By.tagName("tbody"));
                    rowList=tableBody.findElements(By.tagName("tr")) ;
                    i--;//bajamos en una vuelta el contador porque al entrar en el else se desperdicia una vuelta del for y baja un reporte menos de lo que deberia
                }

            }





            
           /*  System.out.println("tamaño de la tabla: "+ rowList.size());
            System.out.println("numero de columnas: "+columnlList.size());
            System.out.println("si esta el link: "+linkDownload.isDisplayed());
            System.out.println("Numero de reportes generados: "+ this.reportCount);
            if(linkDownload.isDisplayed()&&linkDownload!=null){
                System.out.println("clickDownload");
            }else{
                System.out.println("algo fallo");
            } */
        } catch (Exception e) {
            System.out.println("Error en el metodo download: "+ e.getMessage());
        }

    }

    public void start_payjoy(String direccionExcel) throws Exception {
        String merchant = "Wimo Tecnicolor";
        String passwordMerchant = "IKFMOU";
        WebElement inputMerchant;
        WebElement inputMerchantPass;
        WebElement inputUser;
        WebElement inputPass;
        WebElement buttonMerchant;
        WebElement buttonLogin;
        WebElement buttonAceptarPago;
        WebElement inputIdTelefono;
        WebElement buttonIngresar;
        WebElement labelNumTelefono;
        List listaIdDivaces;
        // realizamos un limppiado ya que al pegar la direccion en el joption pane se
        // ingresa con comillas y las queremos eliminar
        // para obterner el path y no genere un error de no encuentra el archivo
        String direccionExcelLimpia = direccionExcel.replace("\"", "");
        ExcelManager excelManager = new ExcelManager(direccionExcelLimpia, "Hoja1");
        try {

            listaIdDivaces = excelManager.CreateList();
            inputMerchant = driver.findElement(By.xpath("//*[@id=" + "'login-merchant'" + "]"));
            inputMerchantPass = driver.findElement(By.xpath("//*[@id=" + "'login-password'" + "]"));
            buttonMerchant = driver.findElement(By.xpath("//*[@id=" + "'login-button'" + "]"));
            inputMerchant.clear();
            inputMerchant.sendKeys(merchant);
            inputMerchantPass.clear();
            inputMerchantPass.sendKeys(passwordMerchant);
            buttonMerchant.click();
            Thread.sleep(3000);
            // dormimos hilo para esperar recarga ventana de chrome
            inputUser = driver.findElement(By.xpath("//*[@id=" + "'email'" + "]"));
            inputPass = driver.findElement(By.xpath("//*[@id=" + "'password'" + "]"));
            buttonLogin = driver.findElement(
                    By.xpath("//*[@id=" + "'app'" + "]/main/div[2]/div/div/div/div[3]/div/form/div/div[2]/button"));
            inputUser.clear();
            inputUser.sendKeys(this.user);
            inputPass.clear();
            inputPass.sendKeys(this.pass);
            buttonLogin.click();
            Thread.sleep(4000);
            // buttonAceptarPago=driver.findElement(By.xpath("//*[@id="+"'accept'"+"]"));
            for (int i = 0; i < listaIdDivaces.size(); i++) {
                buttonAceptarPago = driver.findElement(By.id("accept"));
                Thread.sleep(2000);
                buttonAceptarPago.click();
                Thread.sleep(2000);
                inputIdTelefono = driver.findElement(By.id("deviceTagOrPhoneNumberInput"));
                buttonIngresar = driver.findElement(By.id("enterDeviceTagOrPhoneNumber"));

                inputIdTelefono.clear();
                inputIdTelefono.sendKeys(listaIdDivaces.get(i).toString());
                // inputIdTelefono.sendKeys(listaDivaces[i]); //tag muerto
                // inputIdTelefono.sendKeys("DDQDSFP");
                // inputIdTelefono.sendKeys("DWRNNXJ");
                buttonIngresar.click();
                Thread.sleep(1000);
                labelNumTelefono = driver
                        .findElement(By.xpath("//*[@id=" + "'deviceInfo'" + "]/div[1]/table/tbody/tr[3]/td[2]"));
                // System.out.println("esta desplegado? " + labelNumTelefono.isDisplayed());

                // validacion para saber si el elemnto esta desplegado o no;
                if (labelNumTelefono.isDisplayed()) {
                    System.out.println("Numero de telefono a copiar: " + labelNumTelefono.getText());
                } else {
                    System.out.println(
                            "El numero telefono no esta disponible para el Id: " + listaIdDivaces.get(i).toString());
                }
                driver.navigate().back();
            }

            driver.quit();
            /*
             * if(buttonCancelar==null){
             * System.out.println("la variable no esta ");
             * }else{
             * System.out.println("la variable si tiene contenido");
             * }
             */

        } catch (Exception e) {

            System.out.println("Error en boot payjoy: " + e);
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error path", JOptionPane.ERROR_MESSAGE);
        }

    }

    // funcione utilitarias para las principales funciones

    public static String numeroDeDiasMes(int mes, int año) {

        int numeroDias = -1;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias = 30;
                break;
            case 2:
                if (esBisiesto(1900 + año)) {
                    numeroDias = 29;
                } else {
                    numeroDias = 28;
                }
                break;

        }

        return String.valueOf(numeroDias);
    }

    public static boolean esBisiesto(int anio) {

        GregorianCalendar calendar = new GregorianCalendar();
        boolean esBisiesto = false;
        if (calendar.isLeapYear(anio)) {
            esBisiesto = true;
        }
        return esBisiesto;

    }

    public List generadorPeriodos() {
        // Este metodo genera una lista de los meses con años que se designa con los
        // parametros dentro de la clase.
        //
        String meses[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String años[] = { "2021", "2022" };
        int index_mes = 0;
        int index_año = 0;
        String dia_inicio = "1";
        String dia_final;
        LocalDate fecha = LocalDate.now();
        int año_actual = fecha.getYear();
        int mes_actual = fecha.getMonthValue();
        List<Fechas_Reporte> Lista_de_reportes = new ArrayList<>();

        try {
            // definimos el mes inicial y año inicial en el arreglo
            for (int i = 0; i < años.length; i++) {
                for (int j = 0; j < meses.length; j++) {
                    if (this.mes_inicio.equals(meses[j]) && (this.año_inicio.equals(años[i]))) {
                        index_mes = j;
                        index_año = i;
                    }
                }
            }

            // System.out.print("El mes inicial es: "+meses[index_mes]+" y el año inicial
            // es: "+años[index_año]);
            while (true) {
                if (!(mes_actual == index_mes + 1 && año_actual == Integer.parseInt(años[index_año]))) {
                    dia_final = numeroDeDiasMes(index_mes + 1, Integer.parseInt(años[index_año]));
                    Fechas_Reporte reporte = new Fechas_Reporte(meses[index_mes], dia_inicio, dia_final,
                            años[index_año]);
                    // System.out.println("vamos a ingresar a la lista a: " + meses[index_mes]);
                    Lista_de_reportes.add(reporte);
                    if (index_mes == 11) {
                        index_mes = 0;
                        index_año++;
                    } else {
                        index_mes++;
                    }

                } else {
                    dia_final = String.valueOf(fecha.getDayOfMonth());
                    Fechas_Reporte reporte = new Fechas_Reporte(meses[index_mes], dia_inicio, dia_final,
                            años[index_año]);
                    // System.out.println("vamos a ingresar a la lista a: " + meses[index_mes]);
                    Lista_de_reportes.add(reporte);
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error en el try generar periodos: " + e);
        }

        return Lista_de_reportes;
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
