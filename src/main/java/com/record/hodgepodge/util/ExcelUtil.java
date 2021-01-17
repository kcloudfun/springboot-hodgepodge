package com.record.hodgepodge.util;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ExcelUtil {

    public static <T> List<T> readExcelOfXls(InputStream inputStream) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet hssfSheet = workbook.getSheetAt(0);
        //从第二行开始获取，跳过表头
        for (int i = 1; i < hssfSheet.getPhysicalNumberOfRows(); i++) {
            Row sheetRow = hssfSheet.getRow(i);
        }
        return null;
    }

    public static List<?> readExcelOfXlsx(InputStream inputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet xssfSheet = workbook.getSheetAt(0);
        //从第二行开始获取，跳过表头
        for (int i = 1; i < xssfSheet.getPhysicalNumberOfRows(); i++) {
            Row sheetRow = xssfSheet.getRow(i);
        }
        return null;
    }

    public static <T> T readRow() {

        return null;
    }
}
