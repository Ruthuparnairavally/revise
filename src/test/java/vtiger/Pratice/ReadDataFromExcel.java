package vtiger.Pratice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public static void main(String[] args) throws IOException {
		
		//Step1:Load the file location into fileinput stream
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData1.xlsx");
		
		//Step2: Create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3: Get into sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step4: get row
		Row row = sh.getRow(4);
		
		//Step5:get cell
		Cell cell = row.getCell(2);
		
//		//Step4: get row
//				Row row = sh.getRow(1);
//				
//				//Step5:get cell
//				Cell cell = row.getCell(2);
		
		//Step5: get cell value
		String value = cell.getStringCellValue();
		System.out.println(value);		
	}
}
