package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtility(String excelPath) throws IOException {

        fis = new FileInputStream(excelPath);
        workbook = new XSSFWorkbook(fis);
    }

    public int getRowCount(String sheetName) {

        sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum();

    }

    public int getCellCount(String sheetName, int rowNum) {

        sheet = workbook.getSheet(sheetName);
        return sheet.getRow(rowNum).getLastCellNum();

    }

    public String getCellData(String sheetName, int rowNum, int colNum) {

        sheet = workbook.getSheet(sheetName);

        return sheet.getRow(rowNum).getCell(colNum).toString();

    }

    public void closeWorkbook() throws IOException {

        workbook.close();
        fis.close();

    }

}