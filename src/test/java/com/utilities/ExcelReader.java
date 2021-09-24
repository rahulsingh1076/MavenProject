package com.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String path;
	public FileInputStream fileIn = null;
	public FileOutputStream fileOut = null;

	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public ExcelReader(String path) {

		this.path = path;

		try {
			fileIn = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileIn);
			sheet = workbook.getSheetAt(0);
			fileIn.close();
		} catch (Exception e) {

		}
	}

	public int getRowCount(String sheetName) {
		// TODO Auto-generated method stub

		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			//System.out.println("NUmber in getRowCount "+ number);
			return number;
		}

	}

	public int getColumnCount(String sheetName) {
		// TODO Auto-generated method stub
		if (!isSheetExit(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum() ;

	}

	private boolean isSheetExit(String sheetName) {
		// TODO Auto-generated method stub

		int index = workbook.getSheetIndex(sheetName);

		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	public Object getCellData(String sheetName, int colNum, int rowNum) {
		// TODO Auto-generated method stub

		try {
			if (rowNum <= 0)
				return "";
			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());

				return cellText;
				
			} else if (cell.getCellType() == CellType.BLANK)
				return "";
			
			else
				return String.valueOf(cell.getBooleanCellValue());
			
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}

}
