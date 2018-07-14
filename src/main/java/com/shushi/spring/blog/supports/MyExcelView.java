package com.shushi.spring.blog.supports;

import com.shushi.spring.blog.models.BlogDmTinhThanhEntity;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author anhbt 7/5/2018
 * com.shushi.spring.blog.supports
 */
@Component("forexView")
public class MyExcelView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
                                      HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<BlogDmTinhThanhEntity> blogDmTinhThanhEntities = (List<BlogDmTinhThanhEntity>) model.get("dmTinhThanhs");
        Sheet sheet = workbook.createSheet("tt");
        sheet.setFitToPage(true);

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(headerFont);

        sheet.addMergedRegion(new CellRangeAddress(0,1,1,1));
        int rowCount = 0;
        Row header = sheet.createRow(rowCount++);
        String[]colums=new String[]{"Id","Mã Tỉnh Thành","Tên Tỉnh Thành"};
        for(int i = 0; i < colums.length; i++) {
            sheet.autoSizeColumn(i);
            Cell cell = header.createCell(i);
            cell.setCellValue(colums[i]);
            cell.setCellStyle(style);

        }
        rowCount++;
        for (BlogDmTinhThanhEntity blog : blogDmTinhThanhEntities) {
            Row currencyRow = sheet.createRow(rowCount++);
            currencyRow.createCell(0).setCellValue(blog.getId());
            currencyRow.createCell(1).setCellValue(blog.getMaTinhThanh());
            currencyRow.createCell(2).setCellValue(blog.getTenTinhThanh());
        }
        Row currencyRow = sheet.createRow(rowCount++);
        currencyRow.createCell(1).setCellValue("Total : ");
        currencyRow.createCell(2).setCellFormula("1+1");
        CellReference cellRefRelevant50First = new CellReference(2, 0);
        CellReference cellRefRelevant50end = new CellReference(10, 0);
        currencyRow=sheet.createRow(rowCount++);
        currencyRow.createCell(2).setCellFormula("SUM("+cellRefRelevant50First.formatAsString()+":"+cellRefRelevant50end.formatAsString()+")");
        response.setHeader("Content-Disposition", "attachment; filename=forex-rates.xlsx");
    }
}
