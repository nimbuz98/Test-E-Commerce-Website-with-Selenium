package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcelFile {

    public static FileInputStream inputStream;
    public static XSSFWorkbook workBook;
    public static XSSFSheet excelSheet;
    public static XSSFRow row;
    public static XSSFCell cell;


//    In below "getCellValue" method fileName and sheetName take as String inputs
//    And return a string include in the cell.

    public static String getCellValue(String fileName,String sheetName,int rowNo, int cellNo){

        try{

            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
            excelSheet = workBook.getSheet(sheetName);
            cell = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);

            workBook.close();
            return cell.getStringCellValue();

        }catch (Exception e){
            return "There is a Exception Error";
        }
    }

    public static int getRowCount(String fileName, String sheetName){
        try{

            inputStream = new FileInputStream(fileName);

            workBook = new XSSFWorkbook(inputStream);
            excelSheet = workBook.getSheet(sheetName);

            int ttlRows = excelSheet.getLastRowNum() + 1;

            workBook.close();
            return ttlRows;
        }catch (Exception e){
            return 0;
        }
    }

    public static int getColCount(String fileName, String sheetName){

        try{
            inputStream = new FileInputStream(fileName);

            workBook = new XSSFWorkbook(inputStream);
            excelSheet=workBook.getSheet(sheetName);

            int ttlCells = excelSheet.getRow(0).getLastCellNum();

            workBook.close();
            return ttlCells;
        }catch (Exception e){
            return 0;
        }
    }

    public String getStringData(int sheetIndex, int row, int column){
        return workBook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();

    }

    public String getStringData(String sheetName, int row, int column){
        return workBook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();

    }

    public double getNumericData(String sheetName, int row, int column){
        return workBook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();

    }
}