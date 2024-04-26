package excelUtils;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public XSSFWorkbook wbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public FileOutputStream fo;
	public static String[] readData() throws IOException {
		
	// Opening the excel
		
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\ExcelData\\SearchForschoolData.xlsx");
	XSSFWorkbook book=new XSSFWorkbook(file);
	
	// Reading the excel data
	
	XSSFSheet sheet=book.getSheetAt(0);
	XSSFRow row=sheet.getRow(0);
	String[] val=new String[5];
	for(int c=0;c<5;c++) {
	DataFormatter format=new DataFormatter();
	XSSFCell cell=row.getCell(c);
	val[c]=format.formatCellValue(cell);
	}
	book.close();
	file.close();
	return val;
	}
	
	//Writing the output data ("List of schools")
	
	public void setCellData(String sheetName, int rownum, int column, String data) throws IOException {
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\ExcelData\\SearchForschoolData.xlsx");
	XSSFWorkbook wbook=new XSSFWorkbook(file); //Opening the excel file
	if(wbook.getSheetIndex(sheetName)==-1) {
	wbook.createSheet(sheetName);              //Creating the sheet if it does not exist
	}
	sheet=wbook.getSheet(sheetName);
	if(sheet.getRow(rownum)==null)
	sheet.createRow(rownum);
	row =sheet.getRow(rownum);                    
	cell=row.createCell(column);              // Creating cell
	cell.setCellValue(data);                  //Setting the data in the column
	
	// Writing the data by fileOutput
	
	fo=new FileOutputStream(System.getProperty("user.dir")+"\\ExcelData\\SearchForschoolData.xlsx");
	wbook.write(fo);
	wbook.close();
	file.close();
	fo.close();
	}

}
