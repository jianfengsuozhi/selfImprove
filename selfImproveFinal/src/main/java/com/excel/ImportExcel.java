package com.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.Region;


/**
 * 导出excel
 * @author Edward
 *
 */
public class ImportExcel {
	public static Integer startRow = 1;
	
	public static void importE(){
		//工作簿(sheet(row(cell)，列),单元格样式) 
		//row,column 从0开始
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("成绩sheet1");
		//设置列宽
		sheet.setColumnWidth(0, 20*256);
		//设置单元格样式
		HSSFCellStyle cellStyle= workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//合并单元格
		HSSFRow row0 = sheet.createRow(0);
		sheet.addMergedRegion(new Region(0, (short)0, 0, (short)2));
		HSSFCell cell00 = row0.createCell(0);
		cell00.setCellStyle(cellStyle);
		cell00.setCellValue("数学成绩统计");
		
		HSSFRow row	 = sheet.createRow(startRow);
		HSSFCell cell0 = row.createCell(0);
		cell0.setCellStyle(cellStyle);
		cell0.setCellValue("学号");
		HSSFCell cell1 = row.createCell(1);
		cell1.setCellStyle(cellStyle);
		cell1.setCellValue("姓名");
		HSSFCell cell2 = row.createCell(2);
		cell2.setCellStyle(cellStyle);
		cell2.setCellValue("成绩");
		
		List<Mark> markList = ImportExcel.getMarkList();
		for (int i = 0; i < markList.size(); i++) {
			Mark mark = markList.get(i);
			
			HSSFRow createRow = sheet.createRow(i+(startRow+1));
			cell0 = createRow.createCell(0);
			cell0.setCellStyle(cellStyle);
			cell0.setCellValue(mark.getCode());
		    cell1 = createRow.createCell(1);
			cell1.setCellStyle(cellStyle);
			cell1.setCellValue(mark.getName());
			cell2 = createRow.createCell(2);
			cell2.setCellStyle(cellStyle);
			cell2.setCellValue(mark.getScore());
		}
		
		//统计
		HSSFRow rowt = sheet.createRow(startRow+markList.size()+1);
		cell1 = rowt.createCell(1);
		cell1.setCellStyle(cellStyle);
		cell1.setCellValue("总分数");
		cell2 = rowt.createCell(2);
		cell2.setCellStyle(cellStyle);
		cell2.setCellValue(ImportExcel.sumScore(markList));
		//平均分
		HSSFRow rowp = sheet.createRow(startRow+markList.size()+1+1);
		cell1 = rowp.createCell(1);
		cell1.setCellStyle(cellStyle);
		cell1.setCellValue("平均分");
		cell2 = rowp.createCell(2);
		cell2.setCellStyle(cellStyle);
		cell2.setCellValue(ImportExcel.sumScore(markList)*1.0/markList.size());
		
		//最高分
		HSSFRow rowg = sheet.createRow(startRow+markList.size()+1+1+1);
		cell1 = rowg.createCell(1);
		cell1.setCellStyle(cellStyle);
		cell1.setCellValue("最高分");
		cell2 = rowg.createCell(2);
		cell2.setCellStyle(cellStyle);
		cell2.setCellValue(ImportExcel.gaoScore(markList));
		
		//最低分
		HSSFRow rowd = sheet.createRow(startRow+markList.size()+1+1+1+1);
		cell1 = rowd.createCell(1);
		cell1.setCellStyle(cellStyle);
		cell1.setCellValue("最低分");
		cell2 = rowd.createCell(2);
		cell2.setCellStyle(cellStyle);
		cell2.setCellValue(ImportExcel.diScore(markList));
		try {
			FileOutputStream fout = new FileOutputStream("F:\\mark.xls");
			workbook.write(fout);
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static List<Mark> getMarkList(){
		List<Mark> list = new ArrayList<Mark>();
		list.add(new Mark("129074111", "刘峰", "100"));
		list.add(new Mark("129074112", "文祥", "90"));
		list.add(new Mark("129074113", "魏德亮", "100"));
		list.add(new Mark("129074114", "吴奇伟", "80"));
		return list;
	}
	/**
	 * 总分
	 * @param list
	 * @return
	 */
	public static Double sumScore(List<Mark> list){
		Double sum = 0.0;
		for (Mark mark : list) {
			sum += Double.parseDouble(mark.getScore().trim());
		}
		return sum;
	}
	
	/**
	 * 最高分
	 * @param list
	 * @return
	 */
	public static Double gaoScore(List<Mark> list){
		Double gaoScore = 0.0;
		for (Mark mark : list) {
			Double score = Double.parseDouble(mark.getScore().trim());
			if(gaoScore<score){
				gaoScore = score;
			}
		}
		return gaoScore;
	}
	/**
	 * 最低分
	 * @param list
	 * @return
	 */
	public static Double diScore(List<Mark> list){
		Double diScore = Double.parseDouble(list.get(0).getScore());
		for (int i = 1; i <list.size(); i++) {
			Mark mark = list.get(i);
			Double score = Double.parseDouble(mark.getScore().trim());
			if(score<diScore){
				diScore = score;
			}
		}
		return diScore;
	}
}
