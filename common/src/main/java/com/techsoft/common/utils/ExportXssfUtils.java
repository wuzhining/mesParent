package com.techsoft.common.utils;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

import javax.servlet.http.HttpServletResponse;

public class ExportXssfUtils {

    /**
     * 生成Excel
     */
    public String zxExprotExcelXLSX(HttpServletResponse res,String fileName,String[] title,String[][] content) throws IOException{
        String returnUrl="";
    	
    	XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("0");
        for (int i = 0; i < title.length; i++) {
            sheet.setColumnWidth(i, 4300);
        }

        /**
         * 单元格 样式
         */
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        // 竖向居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 横向居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        /**
         * 标题样式 样式
         */
        XSSFFont titleFont = wb.createFont();
        titleFont.setFontHeight(24);
        titleFont.setBold(true);
        CellStyle titleCellStyle = wb.createCellStyle();
        titleCellStyle.setBorderTop(BorderStyle.THIN);
        titleCellStyle.setBorderBottom(BorderStyle.THIN);
        titleCellStyle.setBorderLeft(BorderStyle.THIN);
        titleCellStyle.setBorderRight(BorderStyle.THIN);
        titleCellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setFont(titleFont);
        // 竖向居中
        titleCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 横向居中
        titleCellStyle.setAlignment(HorizontalAlignment.CENTER);

        /**
         * 主 标题 在这里插入主标题
         */
        Row titleRow;
        Cell titleCell;
        sheet.addMergedRegion(new CellRangeAddress((short) 0, (short) 2, (short) 0, (short) 8));
        for (int i = 0; i <= 2; i++) {
            titleRow = sheet.createRow(i);
            for (int j = 0; j < title.length; j++) {
                titleCell = titleRow.createCell(j);
                titleCell.setCellType(CellType.STRING);
                titleCell.setCellStyle(titleCellStyle);
                titleCell.setCellValue(fileName);
            }
        }

        /**
         * 列 标题 在这里插入标题
         */
        Row rowLabel;
        Cell cellLabel;
        for (int i = 3; i < 4; i++) {
            rowLabel = sheet.createRow(i);
            for (int j = 0; j < title.length; j++) {
                cellLabel = rowLabel.createCell(j);
                cellLabel.setCellType(CellType.STRING);
                cellLabel.setCellStyle(cellStyle);
                cellLabel.setCellValue(title[j]);
            }
        }

        /**
         * 列 数据 在这里插入数据
         */
        Row rowCheck;
        Cell cellCheck;
        for (int i = 3; i < content.length+3; i++) {
        	rowCheck = sheet.createRow((i + 1));
            for (int j = 0; j < title.length; j++) {
                cellCheck = rowCheck.createCell(j);
                cellCheck.setCellType(CellType.STRING);
                cellCheck.setCellStyle(cellStyle);
                cellCheck.setCellValue(content[i-3][j]);
            }
        }

        /**
         * 页脚
         */
        setExcelFooterName(fileName, 0, wb);

        /**
         * 进行导出
         */
        String excelName =fileName+System.currentTimeMillis()+".xlsx";
        
        
        exportOutPutExcel("D:/java/admin/apache-tomcat-8.5.39/wtpwebapps/dubbo-admin/upload/"+excelName, wb);
        returnUrl=excelName;
      //将excel的数据写入文件
//      		ByteArrayOutputStream fos = null;
//      		byte[] retArr = null;
//      		try {
//      			fos = new ByteArrayOutputStream();
//      			wb.write(fos);
//      			retArr = fos.toByteArray();
//      		} catch (FileNotFoundException e) {
//      			// TODO Auto-generated catch block
//      			e.printStackTrace();
//      		} catch (IOException e) {
//      			// TODO Auto-generated catch block
//      			e.printStackTrace();
//      		} finally {
//      			try {
//      				fos.close();
//      			} catch (IOException e) {
//      				// TODO Auto-generated catch block
//      				e.printStackTrace();
//      			}
//      		}
//      		OutputStream os = res.getOutputStream();
//      		try {
//      			res.reset();
//      			res.setHeader("Content-Disposition", "attachment; filename=agent_book.xls");//要保存的文件名
//      			res.setContentType("application/octet-stream; charset=utf-8");
//      			os.write(retArr);
//      			os.flush();
//      		} finally {
//      			if (os != null) {
//      				os.close();
//      			}
//      		}
        return returnUrl;

    }

    /**
     * 设置Excel页脚
     */
    public void setExcelFooterName(String customExcelFooterName, int setExcelFooterNumber, XSSFWorkbook wb) {
        wb.setSheetName(setExcelFooterNumber, customExcelFooterName);
    }

    /**
     * 输出流 导出Excel到桌面
     */
    public void exportOutPutExcel(String exportPositionPath, XSSFWorkbook wb) {
        try {
            File file = new File(exportPositionPath);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            wb.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String main(HttpServletResponse res,String fileName,String[] title,String[][] content) throws IOException{
        String url=new ExportXssfUtils().zxExprotExcelXLSX(res, fileName,title,content);
    	return url;
    }

}