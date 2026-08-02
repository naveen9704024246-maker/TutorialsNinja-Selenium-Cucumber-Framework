package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    @DataProvider(name="LoginData")
    public Object[][] getLoginData() throws IOException {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/TestData/LoginData.xlsx";

        ExcelUtility xl = new ExcelUtility(path);

        int totalRows = xl.getRowCount("Login");
        int totalCols = xl.getCellCount("Login", 0);

        Object data[][] = new Object[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {

            for (int j = 0; j < totalCols; j++) {

                data[i - 1][j] = xl.getCellData("Login", i, j);

            }

        }

        xl.closeWorkbook();

        return data;

    }

}