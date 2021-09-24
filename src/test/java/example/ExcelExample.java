package example;

import org.apache.poi.util.SystemOutLogger;

import com.utilities.ExcelReader;

public class ExcelExample {

	public static void main(String[] args) {

		ExcelReader excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TestData.xlsx");
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		// System.out.println("Number of row >> "+rows+" Number of columns >> "+cols);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

			}
		}


		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(data[i][j] +" ");
			}
			System.out.println(" ");
		}
	}
}
