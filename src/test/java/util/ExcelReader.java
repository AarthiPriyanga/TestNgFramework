package util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {


		
public static Object[][] getValueFromExcel(String dataExcelName) {
		
		Object[][] data = null ;

		try {
			String fileName = "./data/"+dataExcelName+".xlsx";
			System.out.println("File Path is : "+fileName);
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);	

			// get the number of rows
			int rowCount = sheet.getLastRowNum();

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];

			// loop through the rows
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ // loop through the columns
						try {
							String cellValue = "";
							try{
								cellValue = row.getCell(j).getStringCellValue();
							}catch(NullPointerException e){

							}

							data[i-1][j]  = cellValue; // add to the data array
						} catch (Exception e) {
 							e.printStackTrace();
						}				
					}

				} catch (Exception e) {
 					e.printStackTrace();
				}
			}
			fis.close();
			workbook.close();
		} catch (Exception e) {
 			e.printStackTrace();
		}

		return data;

	}

}
