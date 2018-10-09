package com.assignment.books.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.assignment.books.model.Book;
import com.assignment.books.serviceImpl.BookServiceImpl;

/**
 * @author SUDHANSHU
 *
 */
public class ReadWriteExcelUtils {

	//private static String FILE_PATH = "D:/Report";
	
	/**
	 * @param listOfBooks
	 * @param fileName
	 */
	public static String writeExcelFileFromList(List<Book> listOfBooks, String fileName) {
		
		String excelFileName = null;
		String finalPathOfExcelFile = null;
		try {
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("book");// creating a blank sheet
			int rownum = 0;
			Row headingRow = sheet.createRow(rownum++);
			createBookExcelFileHeading(headingRow);
			for (Book book : listOfBooks) {
				Row row = sheet.createRow(rownum++);
				createList(book, row);
			}
			DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss"); // add S if you need milliseconds
			 
			excelFileName =IConstants.File_Path+ fileName+ df.format(new Date())+ IConstants.FILE_EXTENSION;
			String workingDirectory = System.getProperty("user.dir");
			/*File file = new File(excelFileName,workingDirectory);
			System.out.println("Final filepath : " + file.getAbsolutePath());*/
			/*if(file.createNewFile()){
	            System.out.println(excelFileName+" File Created");
	        }else
	        	System.out.println("File "+excelFileName+" already exists");*/
			finalPathOfExcelFile = workingDirectory+File.separator+excelFileName;
			FileOutputStream out = new FileOutputStream(new File(finalPathOfExcelFile)); // file name with path
			workbook.write(out);
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return finalPathOfExcelFile;

	}
	
	public static void createBookExcelFileHeading(Row row) {
		Cell cell = row.createCell(0);
		cell.setCellValue("ID");
		cell = row.createCell(1);
		cell.setCellValue("AUTHOR");
		cell = row.createCell(2);
		cell.setCellValue("CATEGORY");
		cell = row.createCell(3);
		cell.setCellValue("ISBN");
		cell = row.createCell(4);
		cell.setCellValue("LANGUAGE");
		cell = row.createCell(5);
		cell.setCellValue("NO_OF_PAGES");
		cell = row.createCell(6);
		cell.setCellValue("PRICE");
		cell = row.createCell(7);
		cell.setCellValue("PUBLISHER");
		cell = row.createCell(8);
		cell.setCellValue("TITLE");
		cell = row.createCell(9);
		cell.setCellValue("YEAR");

	}

	private static void createList(Book book, Row row) // creating cells for each row
	{
		Cell cell = row.createCell(0);
		cell.setCellValue(book.getId());
		cell = row.createCell(1);
		cell.setCellValue(book.getAuther());
		cell = row.createCell(2);
		cell.setCellValue(book.getCategory());
		cell = row.createCell(3);
		cell.setCellValue(book.getIsbn());
		cell = row.createCell(4);
		cell.setCellValue(book.getLanguage());
		cell = row.createCell(5);
		cell.setCellValue(book.getNumberOfPages());
		cell = row.createCell(6);
		cell.setCellValue(book.getPrice());
		cell = row.createCell(7);
		cell.setCellValue(book.getPublisher());
		cell = row.createCell(8);
		cell.setCellValue(book.getTitle());
		cell = row.createCell(9);
		cell.setCellValue(book.getYear());

	}

}
