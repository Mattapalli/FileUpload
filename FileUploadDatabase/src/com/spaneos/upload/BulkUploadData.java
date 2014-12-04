package com.spaneos.upload;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.spaneos.dao.ProductDao;
import com.spaneos.pojo.Product;

@WebServlet("/bulkupload")
public class BulkUploadData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao pDao = new ProductDao();
	private int rowcount;
	private int colcount;
	ArrayList[] list;

	private ArrayList[] inputDataArray;
	private Cell valCellContents;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uri = req.getRequestURI();

		if (uri.endsWith("bulkupload.do")) {

			String filePart = req.getParameter("file");
			FileInputStream fStream = new FileInputStream(filePart);

			// HSSFWorkbook hssfWorkbook=new HSSFWorkbook(fStream);
			try {
				Workbook workbook = Workbook.getWorkbook(fStream);
				Sheet sheet = workbook.getSheet(0);
				rowcount = sheet.getRows();
				colcount = sheet.getColumns();
				// list = new ArrayList[colcount];
				inputDataArray = new ArrayList[colcount];
				// Set<Product>products=new HashSet<>(colcount);
				for (int i = 1; i < rowcount; i++) {
					for (int j = 0; j < colcount; j++) {
						valCellContents = sheet.getCell(j, i);
						String value = valCellContents.getContents();
						// inputDataArray[j]= value.;

					}
				}

			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			List<Product> sheetData = new ArrayList<>();

			Set<Product> products = new HashSet<>();
			List<Product> pList = new ArrayList<>();
			Product objectProduct = new Product();
			// products=pDao.getAllProduct();

		}
	}
}
