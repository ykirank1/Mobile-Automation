package com.auto.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;

/**
 * Utility to interact with excel files
 * 
 * @author naini.ghai
 * 
 */
public class ExcelReader {

	private XSSFSheet xssfSheet;
	private List<String> headerList;
	private XSSFWorkbook workBook;

	/**
	 * Creates a new ExcelReader. Loads the excel File given by the path
	 * "workBookPath" and then loads the workSheet of given name "workSheetName"
	 * Takes the relative path of workBook For example if the excel file is in
	 * resources folder of your code directory then the relative path will be
	 * "resources" + File.separator + "ExcelName"
	 * 
	 * @param String path of the workBook
	 * @param String Name of WorkSheet
	 * @throws MalformedFileException
	 * @throws Exception              IOExceptions
	 */

	public ExcelReader() {

	}

	public ExcelReader(String workBookPath, String workSheetName) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(workBookPath);
		workBook = new XSSFWorkbook(fileInputStream);
		xssfSheet = workBook.getSheet(workSheetName);
		if (xssfSheet == null) {
			System.out.println("Worksheet: " + workSheetName + ", not found");
		}
		List<String> headerList = getHeader();
		this.headerList = headerList;
	}

	/**
	 * Creates a new ExcelReader. Loads the excel File given by the path
	 * "workBookPath" and then loads the very first workSheet of workBook. Takes the
	 * relative path of workBook For example if the excel file is in resources
	 * folder of your code directory then the relative path will be "resources" +
	 * File.separator + "ExcelName"
	 * 
	 * @param String path of the workBook
	 * @throws MalformedFileException
	 * @throws Exception              IOExceptions
	 */
	public ExcelReader(String workBookPath) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(workBookPath);
		workBook = new XSSFWorkbook(fileInputStream);
		xssfSheet = workBook.getSheetAt(0);
		List<String> headerList = getHeader();
		this.headerList = headerList;
	}

	/**
	 * Creates a new ExcelReader. Loads the excel File given by the path
	 * "workBookPath" and then loads the workSheet at index. Takes the relative path
	 * of workBook For example if the excel file is in resources folder of your code
	 * directory then the relative path will be "resources" + File.separator +
	 * "ExcelName"
	 * 
	 * @param String path of the workBook
	 * @param int    Index of WorkSheet
	 * @throws MalformedFileException
	 * @throws Exception              IOExceptions
	 */

	public ExcelReader(String workBookPath, int index) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(workBookPath);
		workBook = new XSSFWorkbook(fileInputStream);
		xssfSheet = workBook.getSheetAt(index);
		if (xssfSheet == null) {
			throw new IOException("Worksheet with index: " + index + ", not found");
		}
		List<String> headerList = getHeader();
		this.headerList = headerList;
	}

	/**
	 * Returns the number of Rows in the workSheet
	 */

	public int getRowCount() {

		return (xssfSheet.getLastRowNum() - xssfSheet.getFirstRowNum());
	}

	/**
	 * Returns the number of Columns in the workSheet
	 */

	public int getColumnCount() {
		int columnCount = 0;
		if (xssfSheet.getRow(0) != null) {
			columnCount = xssfSheet.getRow(0).getLastCellNum() - xssfSheet.getRow(0).getFirstCellNum();
		}
		return columnCount;
	}

	/**
	 * Returns the value at rowIndex and ColumnIndex in the workSheet
	 * 
	 * @param int index of the row starting with 1. First Row means index 1 .
	 * @param int Index of column starting with 1 . First Column means index 1.
	 * @return String value at rowIndex and columnIndex
	 */
	public String getValue(int rowIndex, int columnIndex) throws IOException {
		String strCellValue = "";
		if (xssfSheet.getRow(rowIndex) != null && xssfSheet.getRow(rowIndex).getCell(columnIndex - 1) != null) {
			strCellValue = xssfSheet.getRow(rowIndex).getCell(columnIndex - 1).toString();
		}
		if (columnIndex > getColumnCount()) {
			throw new IOException("Column Index: " + columnIndex + ", not found");
		}
		if (rowIndex > getRowCount()) {
			throw new IOException("Row Index: " + rowIndex + ", not found");
		}
		return strCellValue.trim();
	}

	/**
	 * Returns the List of headers of the workSheet
	 * 
	 * @return List list of headers
	 * @throws MalformedFileException
	 */
	public List<String> getHeader() throws IOException {
		List<String> headerList = new ArrayList<String>();
		XSSFRow xssfRow = xssfSheet.getRow(0);
		if (xssfRow != null) {
			Iterator<Cell> iterator = xssfRow.cellIterator();

			while (iterator.hasNext()) {
				XSSFCell xssfCell = (XSSFCell) iterator.next();
				if (xssfCell != null) {
					if (headerList.contains(xssfCell.toString())) {
						throw new IOException("Duplicate header name found: " + xssfCell.toString());
					} else
						headerList.add(xssfCell.toString());
				} else {
					headerList.add("");
				}
			}
		}
		return headerList;
	}

	/**
	 * Returns the value at rowIndex and ColumnName in the workSheet
	 * 
	 * @param int    index of the row starting with 1. First Row means index 1 .
	 * @param String Name of the Column
	 * @return String value at rowIndex and columnName
	 */
	public String getValue(int rowIndex, String columnName) throws IOException {
		String returnValue = "";
		int columnIndex = -1;
		List<String> headerList = getHeader();
		Iterator<String> iterator = headerList.iterator();
		while (iterator.hasNext()) {
			String value = (String) iterator.next();
			if (value.equals(columnName)) {
				columnIndex = headerList.indexOf(columnName);
				break;
			}
		}
		if (rowIndex > getRowCount()) {
			throw new IOException("Row at Index: " + rowIndex + ", not found");
		}
		if (columnIndex != -1) {
			if (xssfSheet.getRow(rowIndex) != null && xssfSheet.getRow(rowIndex).getCell(columnIndex) != null)
				returnValue = xssfSheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
		} else if (columnIndex == -1) {
			throw new IOException("Column Name: " + columnName + ", not found");
		}
		return returnValue;
	}

	/**
	 * Returns a Row at index
	 * 
	 * @param int index of the row starting with 1. First Row means index 1 .
	 * @return a Map with key as column header and value as row value
	 */

	public Map<String, String> getRow(int index) throws IOException {
		Map<String, String> hashMap = new LinkedHashMap<String, String>();
		XSSFRow hssfRow = xssfSheet.getRow(index);
		if (hssfRow != null) {
			for (int i = 0; i < getColumnCount(); i++) {
				@SuppressWarnings("deprecation")
				XSSFCell hssfCell = hssfRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				hashMap.put(headerList.get(i), hssfCell.toString());
			}
		} else
			throw new IOException("Row at Index: " + index + ", not found");

		return hashMap;
	}

	/**
	 * Returns values in a column.
	 * 
	 * @param String name of the column header .
	 * @return a list of column values
	 */

	public List<String> getValues(String columnName) throws IOException {
		List<String> list = new ArrayList<String>();
		int columnIndex = -1, i = 0;
		Iterator<String> iterator = headerList.iterator();
		while (iterator.hasNext()) {
			String value = (String) iterator.next();
			if (value.equals(columnName)) {
				columnIndex = headerList.indexOf(columnName);
				break;
			}
		}
		Iterator<Row> rowIterator = xssfSheet.rowIterator();

		while (rowIterator.hasNext()) {
			HSSFRow hssfRow = (HSSFRow) rowIterator.next();
			if (columnIndex != -1) {
				@SuppressWarnings("deprecation")
				HSSFCell columnValue = hssfRow.getCell(columnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				if (i != 0)
					list.add(columnValue.toString());
				i++;
			} else {
				throw new IOException("Column Name: " + columnName + ", not found");
			}
		}
		return list;

	}

	/**
	 * Returns all the data stored in excel sheet in Object[][]
	 * 
	 * @param FilePath
	 * @param SheetName
	 * @return
	 * @throws Exception
	 */
	public Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
		String[][] tabArray = null;
		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			// Access the required test data sheet
			workBook = new XSSFWorkbook(ExcelFile);
			xssfSheet = workBook.getSheet(SheetName);
			int startRow = 1;
			int startCol = 1;
			int ci, cj;
			int totalRows = xssfSheet.getLastRowNum();
			// you can write a function as well to get Column count
			int totalCols = getColumnCount();
			int nExecutableRows = 0;
			String strTestRunType = System.getProperty("TEST_RUN_TYPE");
			ci = 0;
			for (int i = startRow; i <= totalRows; i++) {
				String strTestRunFlag = getValue(i, "TEST_RUN");

				if (strTestRunFlag != null && strTestRunFlag.equalsIgnoreCase("Y") == true) {
					nExecutableRows = ++ci;
				}
			}
			tabArray = new String[nExecutableRows][totalCols];

			ci = 0;
			for (int i = startRow; i <= totalRows; i++) {
				cj = 0;
				String strTestRunFlag = getValue(i, "TEST_RUN");

				if (strTestRunFlag != null && strTestRunFlag.equalsIgnoreCase("Y") == true) {
					for (int j = startCol; j <= totalCols; j++, cj++) {
						tabArray[ci][cj] = (getValue(i, j) == null) ? "" : getValue(i, j);
						List al = Arrays.asList(tabArray[ci][cj]);
						System.out.println("test " + al);
						System.out.println(tabArray[ci][cj]);
					}
					ci++;
				}
			}
			// - To uncomment when debugging
			/*
			 * for (int i = 0; i < nExecutableRows; i++) { for (int j = 0; j < totalCols;
			 * j++) { System.out.println(tabArray[i][j]); } }
			 */
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		List al = Arrays.asList(tabArray[0]);
		System.out.println("test " + al);
		return (tabArray);
	}

	public void closeWorkBook() throws Exception {
		workBook.close();
	}

	public Object[][] getTabArray(String FilePath, String SheetName) throws Exception {

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);
			// Access the required test data sheet
			workBook = new XSSFWorkbook(ExcelFile);
			xssfSheet = workBook.getSheet(SheetName);
			int startRow = 1;
			int startCol = 1;

			int ci, cj;

			int totalRows = xssfSheet.getLastRowNum();

			// you can write a function as well to get Column count
			int totalCols = getColumnCount();

			tabArray = new String[totalRows][totalCols];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {

				cj = 0;

				for (int j = startCol; j <= totalCols; j++, cj++) {

					tabArray[ci][cj] = (getValue(i, j) == null) ? "" : getValue(i, j);

					System.out.println(tabArray[ci][cj]);

				}

			}

		}

		catch (FileNotFoundException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}
		System.out.println(tabArray);
		return (tabArray);

	}

	public void writeExcel(String FilePath, String sheetName, int rowNum, int colNum, String setCellValue)
			throws IOException {

		FileInputStream ExcelFile = new FileInputStream(FilePath);
		workBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet Sheet = workBook.getSheet(sheetName);

		if (Sheet.getRow(rowNum) == null) {
			System.out.println("Row Created");
			Sheet.createRow(rowNum);
		}

		Cell bankNameCell = null;
		bankNameCell = Sheet.getRow(rowNum).createCell(colNum);
		bankNameCell.setCellValue(setCellValue);

		FileOutputStream output_file = new FileOutputStream(FilePath); // Open FileOutputStream to write updates

		workBook.write(output_file); // write changes
		// workBook.close();}

	}

	public static String getTestCaseName(String sTestCase) throws Exception {

		String value = sTestCase;

		try {

			int posi = value.indexOf("@");

			value = value.substring(0, posi);

			posi = value.lastIndexOf(".");

			value = value.substring(posi + 1);

			return value;

		} catch (Exception e) {

			throw (e);

		}

	}
}