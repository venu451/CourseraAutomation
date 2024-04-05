package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import stepDefinations.Hooks;
import testCases.ReusableComponents;

public class ExcelUtility extends Hooks {
	
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
	public static FileOutputStream fos;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public ExcelUtility(String text) throws FileNotFoundException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date d=new Date();
		String stamp=sdf.format(d);
		fos=new FileOutputStream(System.getProperty("user.dir")+"//cucumberExcel//"+text+stamp+".xlsx");
		wbook=new XSSFWorkbook();
		sheet=wbook.createSheet("testing");
	}
	public void closeExcel() throws IOException {
		wbook.write(fos);
		wbook.close();
		fos.close();
	}
	
public void setCucumberData(int rowNum, int colNum,List<Map<String,String>> data) {
	for(Map<String,String> map:data) {
		for(Map.Entry m:map.entrySet())  
	     {  
			if(sheet.getRow(rowNum)==null) {
				row=sheet.createRow(rowNum);
			}else {	
				row=sheet.getRow(rowNum);
			}
			rowNum+=1;
			if(row.getCell(0)==null) {
				cell=row.createCell(0);
			}else {
				cell=row.getCell(0);	
			}
			cell.setCellValue(String.valueOf(m.getKey()));
			XSSFCellStyle style=wbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.SKY_BLUE.index);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            sheet.setColumnWidth(0, 50 * 256);
            style.setWrapText(true);
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
		    cell.setCellStyle(style); 
			if(row.getCell(1)==null) {
				cell=row.createCell(1);
			}else {
				cell=row.getCell(1);	
			}
			cell.setCellValue(String.valueOf(m.getValue()));  
			XSSFCellStyle style1=wbook.createCellStyle();
            style1.setFillForegroundColor(IndexedColors.YELLOW.index);
            style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            sheet.setColumnWidth(1, 50 * 256);
            style1.setWrapText(true);
            style1.setBorderTop(BorderStyle.THIN);
            style1.setBorderBottom(BorderStyle.THIN);
            style1.setBorderLeft(BorderStyle.THIN);
            style1.setBorderRight(BorderStyle.THIN);
		    cell.setCellStyle(style1);  
	     }  
	}
		
	}	
	public void setData(int rowNum, int colNum, String data) {
		
		if(sheet.getRow(rowNum)==null) {
			row=sheet.createRow(rowNum);
		}else {	
			row=sheet.getRow(rowNum);
		}
		if(row.getCell(colNum)==null) {
			cell=row.createCell(colNum);
		}else {
			cell=row.getCell(colNum);	
		}
		cell.setCellValue(data);
		
		if(colNum==0) {
			XSSFCellStyle style=wbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.SKY_BLUE.index);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            sheet.setColumnWidth(colNum, 50 * 256);
            style.setWrapText(true);
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
		    cell.setCellStyle(style);      
		}else{
			XSSFCellStyle style=wbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.YELLOW.index);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            sheet.setColumnWidth(colNum, 50 * 256);
            style.setWrapText(true);
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
		    cell.setCellStyle(style);      
		} 
	
	}	
}
