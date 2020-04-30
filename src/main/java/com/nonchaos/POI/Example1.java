package com.nonchaos.POI;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Example1 {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    XSSFWorkbook wb = new XSSFWorkbook();
    try (OutputStream os = new FileOutputStream("test.xlsx")) {
      Sheet sheet = wb.createSheet("工作表1");

      Row titleRow = sheet.createRow(0);      // 第一行
      titleRow.createCell(0).setCellValue("订单号");
      titleRow.createCell(1).setCellValue("订单状态");
      titleRow.createCell(2).setCellValue("缴费类型");
      titleRow.createCell(3).setCellValue("缴费金额");
      Row dataRow = sheet.createRow(1);
      dataRow.createCell(0).setCellValue("订单号订单号订单号订单号订单号订单号");
      dataRow.createCell(1).setCellValue("订单状态订单状态订单状态");
      dataRow.createCell(2).setCellValue("缴费类型缴费类型缴费类型缴费1323");
      dataRow.createCell(3).setCellValue("缴费金额缴费金额缴费金额缴费金额缴费金额");
      for (int i = 0; i < 4; i++) {
        int columnWidth =sheet.getColumnWidth(i) / 256;
        System.out.println(columnWidth);
        Row currentRow = sheet.getRow(1);
        Cell cell = currentRow.getCell(i);
        int length = cell.getStringCellValue().getBytes("UTF-8").length;
        System.out.println(length);
        sheet.setColumnWidth(i, length * 256);
//        sheet.autoSizeColumn(i,true);
//        sheet.setColumnWidth(i, 2*sheet.getColumnWidth(i)+184);
      }
      wb.write(os);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
