package demo;

public class Fechas_Reporte{
    private String Mes;
    private String dia_inicio;
    private String dia_fin;
    private String Año;

    public Fechas_Reporte(String mes_comienzo, String inicio, String fin, String año) {

        this.Mes=mes_comienzo;
        this.dia_inicio=inicio;
        this.dia_fin=fin;
        this.Año=año;
        
    }

    public void setAño(String año) {
        this.Año = año;
    }
    public String getAño() {
        return Año;
    }
    public void setDia_fin(String dia_fin) {
        this.dia_fin = dia_fin;
    }
    public void setDia_inicio(String dia_inicio) {
        this.dia_inicio = dia_inicio;
    }
    public void setMes(String mes) {
        Mes = mes;
    }
    public String getDia_fin() {
        return dia_fin;
    }
    public String getDia_inicio() {
        return dia_inicio;
    }
    public String getMes() {
        return Mes;
    }
}
