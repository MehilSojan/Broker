package org.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	// Return Tpye is String(Read)
		public static String excelRead(String path, String sheetName, int rowIndex, int cellIndex) throws IOException {
			File file = new File(path);

			FileInputStream read = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(read);
			String value = "";
			Sheet sheet = wb.getSheet(sheetName);
			Row row = sheet.getRow(rowIndex);
			Cell cell = row.getCell(cellIndex);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				value = cell.getStringCellValue();
			} else if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat simpledate = new SimpleDateFormat("dd, MMMM, yyyy");
				value = simpledate.format(date);
			} else {
				double d = cell.getNumericCellValue();
				long num = (long) d;
				value = String.valueOf(num);
			}
			return value;
		}

		// Return Tpye is int (Read)
		public static int excelReading(String path, String sheetName, int rowIndex, int cellIndex) throws IOException {
			File file = new File(path);

			FileInputStream read = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(read);
			int lg = 0;
			String value = "";
			Sheet sheet = wb.getSheet(sheetName);
			Row row = sheet.getRow(rowIndex);
			Cell cell = row.getCell(cellIndex);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				value = cell.getStringCellValue();
			} else if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat simpledate = new SimpleDateFormat("dd, MMMM, yyyy");
				value = simpledate.format(date);
			} else {
				double d = cell.getNumericCellValue();
				long num = (long) d;
				int lg1 = (int) num;
				// value = String.valueOf(num);
				lg = lg1;
			}
			return lg;

		}

		// Create excel file
		public static void excelWrite(String path, String sheetName, int rowNo, int cellNo, String value)
				throws IOException {

			File file = new File(path);
			boolean createNewFile = file.createNewFile();

			Workbook wb = new XSSFWorkbook();
			Sheet createSheet = wb.createSheet(sheetName);
			Row createRow = createSheet.createRow(rowNo);
			Cell createCell = createRow.createCell(cellNo);

			createCell.setCellValue(value);
			FileOutputStream fileoutput = new FileOutputStream(file);
			wb.write(fileoutput);
		}
}
