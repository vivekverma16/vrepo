package apchePoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParserPoi {

	public static void main(String arg[]) throws IOException {
		FileInputStream fis = new FileInputStream(new File("E:\\sampleData.xlsx"));
		//HSSFWorkbook & HSSFSheet use for xls formate
		//XSSFWorkbook & HSSFSheet use for xlsx formate
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				if(cell.getCellType()==0) {
					System.out.print((int)cell.getNumericCellValue() + "\t\t");
				}
				else if(cell.getCellType()==1) {
					System.out.print(cell.getStringCellValue() + "\t\t");
				}
			}
			System.out.println();
		}
	}

}
