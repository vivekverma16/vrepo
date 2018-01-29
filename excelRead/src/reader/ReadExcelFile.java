package reader;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
//read only .xls file for xlsx file read need POI apache api
public class ReadExcelFile {

	private String inputFile;

	private void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	private void read() throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook wb;
		try {
			wb = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = wb.getSheet(0);
			for (int i = 0; i <= sheet.getRows()-1; i++) {
				for (int j = 0; j <= sheet.getColumns()-1; j++) {
					Cell cell = sheet.getCell(i, j);
					CellType type = cell.getType();
					if (type == CellType.LABEL) {
						System.out.print("Label=\t" + cell.getContents());
					}
					if (type == CellType.NUMBER) {
						System.out.print("Number=\t" + cell.getContents());
					}
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}

	}

	public static void main(String arg[]) throws IOException {
		ReadExcelFile ref = new ReadExcelFile();
		ref.setInputFile("E:\\test.xls");
		ref.read();
	}
}
