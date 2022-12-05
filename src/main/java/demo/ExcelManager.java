package demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
    private String path;
    private String sheetFocus;

    public ExcelManager(String path, String sheet) throws Exception{
        this.path=path;
        this.sheetFocus=sheet;

    }
    
    
    public List CreateList() throws Exception{
        List <String> columnaOne=new ArrayList();
        int rowCount=0;
        String cellValueString;


        try {
            File file= new File(this.path);
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook workBook= new XSSFWorkbook(inputStream);
            XSSFSheet newsheet= workBook.getSheet(this.sheetFocus);
            rowCount=newsheet.getLastRowNum();
            System.out.println("este es el numero de filas en el archivo: "+ rowCount);

            for(int i=0;i<rowCount; i++){
                XSSFRow row= newsheet.getRow(i);
                cellValueString=row.getCell(0).getStringCellValue();
                columnaOne.add(cellValueString);
            }
        } catch (Exception e) {
            System.out.println("Error en Createlist, ExcelManager: "+e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error path", JOptionPane.ERROR_MESSAGE);
        }
        
        
        return columnaOne;
    }
    
}
