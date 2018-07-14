package com.shushi.spring.blog.supports;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.shushi.spring.blog.models.BlogDmTinhThanhEntity;
import com.shushi.spring.blog.models.Product;
import org.springframework.stereotype.Component;

/**
 * @author anhbt 7/13/2018
 * com.shushi.spring.blog.supports
 */
@Component("reportView")
public class ItextPdfView extends AbstractPdfView{
    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<Product> courses = new ArrayList<>();
        courses.add(new Product(1,"Phông Trơn1","BTA01",100,"Cái","lamp",0,"Đen;Đỏ","Chất hịn",10,79000));
        courses.add(new Product(2,"Phông Gió2","BTA02",100,"Cái","tulips",10,"Đen;Đỏ","Chất bình thường",10,129000));
        courses.add(new Product(3,"Khoác Trơn3","BTA03",100,"Cái","wheel",0,"Đen;Trắng","Chất hịn",130,79000));
        PdfPTable table = new PdfPTable(3);
        table.setWidths(new int[]{10, 60, 30});

        table.addCell("ID");
        table.addCell("Name");
        table.addCell("Date");

        for (Product course : courses){
            table.addCell(String.valueOf(course.getId()));
            table.addCell(course.getTenSanPham());
            table.addCell(DATE_FORMAT.format(new Date()));
        }
        document.add(table);
    }

}
