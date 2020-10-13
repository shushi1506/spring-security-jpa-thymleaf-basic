package com.shushi.spring.blog.supports;

import java.io.*;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
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
    public static final String HTML = "data/app/webapp/blogapp/filetest.html";
    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<Product> courses = (List<Product>) model.get("courses");

        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int month =cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

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

        StringBuilder sb = new StringBuilder();
        sb.append("<div>\n<p align=\"center\">");
        sb.append("<font size=\"5\">");
        sb.append("<b>&nbsp;<font color=\"#32cd32\">My centered Para</font></b>");
        sb.append("</font>");
        sb.append("<font color=\"#32cd32\">&nbsp;</font>");
        sb.append("</p>\n</div>");

        String str = "<html><head></head><body style=\"font-size:12.0pt; font-family:Times New Roman\">"+
                "<a href='http://www.rgagnon.com/howto.html'><b>Real's HowTo</b></a>" +
                "<h1>Show your support</h1>" +
                "<p>It DOES cost a lot to produce this site - in ISP storage and transfer fees</p>" +
                "<p>TEST POLSKICH ZNAKÓW: \u0104\u0105\u0106\u0107\u00d3\u00f3\u0141\u0142\u0179\u017a\u017b\u017c\u017d\u017e\u0118\u0119</p>" +
                "<hr/>" +
                "<p>the huge amounts of time it takes for one person to design and write the actual content.</p>" +
                "<p>If you feel that effort has been useful to you, perhaps you will consider giving something back?</p>" +
                "<p>Donate using PayPal\u017d</p>" +
                "<p>Contributions via PayPal are accepted in any amount ăn cơm</p>" +
                "<p><br/><table border='1'><tr><td>Java HowTo</td></tr><tr>" +
                "<td style='background-color:red;'>Javascript HowTo</td></tr>" +
                "<tr><td>Powerbuilder HowTo</td></tr></table></p>" +
                "</body></html>";
String str2="\uFEFF<html>\n" +
        "<head>\n" +
        "    <meta http-equiv=\"content-type\" content=\"application/xhtml+xml; charset=UTF-8\"/>\n" +
        "</head>\n" +
        "<body style=\"font-family: Arial Unicode MS, FreeSans; font-size:16px; font-weight: normal; \">\n" +
        "<div class=\"text_center margin-t0\">\n" +
        "    <div class=\"margin-10 margin-t20 fontbig text_bold\">Biên bản thẩm tra</div>\n" +
        "</div>\n" +
        "<div>\n" +
        "    <div class=\"right\">.............., ngày "+dayOfMonth+"  tháng "+month+"   năm "+year+" </div>\n" +
        "    <div>Tên khách hàng: .......................................................................................................................</div>\n" +
        "    <div>Địa chỉ: .....................................................................................................................................</div>\n" +
        "    <div>Đại diện: .............................................................. Chức vụ: .....................................................</div>\n" +
        "    <div>Điện thoại: ........................................................... Mobile: .......................................................</div>\n" +
        "    <div>\n" +
        "        <table class=\"table margin-10\">\n" +
        "            <tr>\n" +
        "                <th class=\"text_center\">STT</th>\n" +
        "                <th class=\"text_center\">Mô tả kỹ thuật</th>\n" +
        "                <th class=\"text_center\">Số Serial number</th>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "                <td class=\"text_center\">1</td>\n" +
        "                <td></td>\n" +
        "                <td></td>\n" +
        "            </tr>\n" +
        "        </table>\n" +
        "    </div>\n" +
        "\n" +
        "    <div class=\"italic under text_bold\">Thời gian bảo hành: </div>\n" +
        "    <div class=\"italic under text_bold margin\">GHI CHÚ:</div>\n" +
        "\n" +
        "\n" +
        "    <div>1. Trong thời gian bảo hành mọi trục trặc kỹ thuật do lỗi của nhà sản xuất sẽ được sửa chữa, khắc phục miễn phí.</div>\n" +
        "    <div>2. Không bảo hành các vật tư tiêu hao: Cụm trống, mực, catridge mực, film sấy...</div>\n" +
        "    <div>3 Việc bảo hành không được áp dụng nếu sản phẩm bị hư hỏng do những nguyên nhân sau:</div>\n" +
        "    <div class=\"margin-l10 italic small\">- Không giữ gìn cẩn thận: va chạm mạnh, rơi vỡ, móp méo, để bụi bẩn hoặc chất lỏng lọt vào thiết bị...</div>\n" +
        "    <div class=\"margin-l10 italic small\">- Các lỗi do virus máy tính gây ra hoặc do sử dụng phần mềm không được cung cấp chính thức  từ bên bán</div>\n" +
        "    <div class=\"margin-l10 italic small\">- Sản phẩm đã bị tháo rời hoặc sửa chữa bởi một dịch vụ, đơn vị khác, không phải của bên cung cấp hoặc khi tem bảo hành rách hoặc tẩy xóa</div>\n" +
        "    <div class=\"margin-l10 italic small\">- Thiết bị hỏng do nguyên nhân ngoài kỹ thuật: hỏa hoạn, sét đánh, côn trùng cắn phá, điện áp không đảm bảo, hóa chất xâm hại...</div>\n" +
        "    <div>4. Thiết bị được bảo hành tại địa điểm quy định trong hợp đồng hoặc tại địa chỉ bên bán ghi trên phiếu bảo hành</div>\n" +
        "    <div>5. Khi bảo hành sản phẩm cần xuất trình biên bản bàn giao kiểm phiếu bảo hành này</div>\n" +
        "    <table class=\"mid margin-t20\">\n" +
        "        <tr>\n" +
        "            <td><div class=\"text_bold margin-t20\">ĐẠI DIỆN BÊN BÀN GIAO</div></td>\n" +
        "            <td></td>\n" +
        "            <td><div class=\"text_bold margin-t20\">ĐẠI DIỆN BÊN NHẬN </div></td>\n" +
        "        </tr>\n" +
        "        <tr>\n" +
        "            <td class=\"italic\">(Ký, ghi rõ họ tên)</td>\n" +
        "            <td></td>\n" +
        "            <td class=\"italic\">(Ký, ghi rõ họ tên)</td>\n" +
        "        </tr>\n" +
        "    </table>\n" +
        "\n" +
        "    <table class=\"margin-t150\"><tr><td><div class=\"italic\">DM 13-04 Ban hành 1/7/2011</div></td><td> <div class=\"right\">số trang 1/1</div></td></tr></table>\n" +
        "\n" +
        "</div>\n" +
        "</body>\n" +
        "</html>";
//        InputStream is = new ByteArrayInputStream(html.getBytes());
//        InputStream iss = new ByteArrayInputStream(css.getBytes());
        PdfPTable table2 = new PdfPTable(1);
        PdfPCell cell = new PdfPCell();
//        XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
//        fontProvider.register("data/app/webapp/blogapp/FreeSans.ttf");
//        fontProvider.setUseUnicode(true);
//
//        XMLWorkerHelper.getInstance().parseXHtml(writer,document,new FileInputStream(HTML),null,null,fontProvider);
        XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
        InputStream is = new ByteArrayInputStream(str2.getBytes("UTF-8"));
//        worker.parseXHtml(writer, document, new FileInputStream("data/app/webapp/blogapp/filetest.html"),new FileInputStream("data/app/webapp/blogapp/test.css"), Charset.forName("UTF-8"), new XMLWorkerFontProvider("data/app/webapp/blogapp/"));
        worker.parseXHtml(writer, document,is,new FileInputStream("data/app/webapp/blogapp/test.css"), Charset.forName("UTF-8"), new XMLWorkerFontProvider("data/app/webapp/blogapp/"));


//        ElementList list = XMLWorkerHelper.parseToElementList(html,css);
//        for (Element element : list) {
//            cell.addElement(element);
//        }
//        table2.addCell(cell);
//        document.add(table2);
    }
    private String readCSS() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        InputStream is = XMLWorkerHelper.class.getResourceAsStream("C:\\Users\\PC-DELL55\\IdeaProjects\\blog-thymeleaf-springboot\\src\\main\\resources\\static\\css\\test.css");
        while ((length = is.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        return new String(baos.toByteArray());
    }

}
