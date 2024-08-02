 package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;
import utilities.ReadExcelFile;

public class LoginTest extends BaseClass {
    String fileName = System.getProperty("user.dir")+"//TestData//ETestData.xlsx";

    @Test(dataProvider = "loginDataProvider")
    public void verity(String user, String pass){
        LoginPage lp = new LoginPage(driver);
        lp.portalLogin(user,pass);
    }

    @DataProvider
    public String[][] loginDataProvider(){
//        Below two lines help to know what are the row and column count.
        int row = ReadExcelFile.getRowCount(fileName,"Login");
        int col = ReadExcelFile.getColCount(fileName,"Login");

         String[][] data = new String[row-1][col];

        for (int i = 1; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                data [i-1][j]=ReadExcelFile.getCellValue(fileName,"Login", i, j);
            }
        }
        return data;
    }

}
