package utilities;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;

import testCases.ReusableComponents;

public class ExcelUtility extends ReusableComponents {

	public static XSSFRow row;
	public static XSSFCell cell;
	
	public void setData(int rowNum, int colNum, String data) {
		
		if(sheet.getRow(rowNum)==null) {
			row=sheet.createRow(rowNum);
		}else {	
			row=super.sheet.getRow(rowNum);
		}
		if(row.getCell(colNum)==null) {
			cell=row.createCell(colNum);
		}else {
			cell=row.getCell(colNum);	
		}
		cell.setCellValue(data);
		
		if(colNum==0) {
			XSSFCellStyle style=super.wbook.createCellStyle();
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
			XSSFCellStyle style=super.wbook.createCellStyle();
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
