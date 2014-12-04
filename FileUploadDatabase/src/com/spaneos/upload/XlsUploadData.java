package com.spaneos.upload;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class XlsUploadData {
	private static String dbURL = "jdbc:mysql://localhost:3306/mattapalli";
	private static String dbUser = "root";
	private static String dbPass = "rama";
	static Connection conn;

	public static void main(String[] args) throws Exception {

		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
		conn.setAutoCommit (false);
		PreparedStatement sql_statement = null;
		String sql_read="select * from product where KEYWORD=?";
		String jdbc_insert_sql = "INSERT INTO Product"
				+ "(KEYWORD, TOTAL_COUNT) VALUES" + "(?,?)";

		sql_statement = conn.prepareStatement(jdbc_insert_sql);

		// load the xls data
		FileInputStream fileInputStream = new FileInputStream(new File(
				"C:/Users/Rk/Desktop/product.xls"));

		// loading workbook
		HSSFWorkbook my_xls_workbook = new HSSFWorkbook(fileInputStream);

		/* Load worksheet */
		HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);

		// we loop through and insert data

		Iterator<Row> rIterator = my_worksheet.iterator();
		while (rIterator.hasNext()) {
			// next row
			Row row = rIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				System.out.println("rama");
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:							
					sql_statement.setString(1, cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					sql_statement.setDouble(2, cell.getNumericCellValue());
					break;
				}
		}
		// we can execute the statement before reading the next row
			sql_statement.executeUpdate();
		}
		
		fileInputStream.close();
		/* Close prepared statement */
		sql_statement.close();
		/* COMMIT transaction */
		conn.commit();
		/* Close connection */
		conn.close();
		System.out.println("sucessfully...............");
	}
	
}

	

