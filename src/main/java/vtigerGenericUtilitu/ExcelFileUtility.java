package vtigerGenericUtilitu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
/**
 */
public class ExcelFileUtility {

	/**
	 * This method will read data from excel sheetname
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		String value = c.getStringCellValue();
		return value;
	}
	/**
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataFromExcel(String sheet, int row, int cell, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantUtility.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * this method will read all the data present in sheet and return 2 dimensional object array which can be fed to data provider
	 * @param sheet
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	@DataProvider
	public Object[][] readMultipleFromExcel(String sheet) throws EncryptedDocumentException, IOException  
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("MultipleOrg");
		int rownum = sh.getLastRowNum();
		short cellnum = sh.getRow(1).getLastCellNum(); 
			
		System.out.println(rownum);
		System.out.println(cellnum);
		
		Object data[] [] = new Object[rownum] [cellnum];
		
		for(int i=0; i<rownum;i++)
		{
			for(int j=0; j<cellnum; j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
}
