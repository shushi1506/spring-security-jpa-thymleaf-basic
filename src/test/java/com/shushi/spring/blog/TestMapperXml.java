package com.shushi.spring.blog;

import com.shushi.spring.blog.models.sso.Attributes;
import com.shushi.spring.blog.models.sso.AuthenticationSuccess;
import com.shushi.spring.blog.models.sso.ServiceResponse;
import org.apache.http.client.fluent.Request;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author anhbt 8/30/2018
 * com.shushi.spring.blog
 */
public class TestMapperXml implements CommandLineRunner {
    @Autowired
    private Environment env;
    public static void main(String[] args) throws IOException {
        String xml="\n" +
                "<cas:serviceResponse xmlns:cas='http://www.yale.edu/tp/cas'>\n" +
                "    <cas:authenticationSuccess>\n" +
                "        <cas:user>anhdn@vss.gov.vn</cas:user>\n" +
                "        <cas:attributes>\n" +
                "            <cas:sysMail>TRUE</cas:sysMail>\n" +
                "            <cas:firstLogin>FALSE</cas:firstLogin>\n" +
                "            <cas:sysGddt>TRUE</cas:sysGddt>\n" +
                "            <cas:sysGd>TRUE</cas:sysGd>\n" +
                "            <cas:type>personal</cas:type>\n" +
                "            <cas:chucVu>Phó Tổng Biên tập</cas:chucVu>\n" +
                "            <cas:phongBanBoPhan>Tạp chí Bảo hiểm xã hội</cas:phongBanBoPhan>\n" +
                "            <cas:tinhTrangHoatDong>active</cas:tinhTrangHoatDong>\n" +
                "            <cas:sysQltb>TRUE</cas:sysQltb>\n" +
                "            <cas:credential>Cccmj7Ia6fuHUE2UahMbc0HS+OzR8fpwBHTNoxL/q79RRm4HlZJw4iGH1i/c4V53E9TuBWwEriPDlC8agaXr1WR79JKfnN7Z8znMtXUTbtHFb/5iVjX24cIJBtndlAG2YQFJ0WhT5brNlOA8TVeQbBb8b8OFBUaCO/8KldDQbG1AUdjw50bYtp3SBdLh60fXsu25KcNek5TVdWQUpcKWMfYetr0zURr0Li0V0jA/hZA0YT6r2tBhJzn19et19WoA2y7cly4fVF465VsqbePuuvB/fk4374T/8L+VNY02AS12uyIrwtfO6xJ5lSs+Ir8u3eGPGhOf3TP04g0amKHK6Q==</cas:credential>\n" +
                "            <cas:longTermAuthenticationRequestTokenUsed>false</cas:longTermAuthenticationRequestTokenUsed>\n" +
                "            <cas:ten>Dương Ngọc Ánh</cas:ten>\n" +
                "            <cas:email>anhdn@vss.gov.vn</cas:email>\n" +
                "            <cas:sysElearning>TRUE</cas:sysElearning>\n" +
                "            <cas:isFromNewLogin>true</cas:isFromNewLogin>\n" +
                "            <cas:authenticationDate>2018-08-30T15:59:26.969+07:00[Asia/Bangkok]</cas:authenticationDate>\n" +
                "            <cas:successfulAuthenticationHandlers>BhxhUserAuthenticationHandler</cas:successfulAuthenticationHandlers>\n" +
                "            <cas:sysReport>TRUE</cas:sysReport>\n" +
                "            <cas:sysSync>FALSE</cas:sysSync>\n" +
                "            <cas:maCqBhxh>0003</cas:maCqBhxh>\n" +
                "            <cas:tenCqBhxh>BHXH Việt Nam</cas:tenCqBhxh>\n" +
                "            <cas:sysSelfService>TRUE</cas:sysSelfService>\n" +
                "            <cas:authenticationMethod>BhxhUserAuthenticationHandler</cas:authenticationMethod>\n" +
                "            <cas:sysVbdh>TRUE</cas:sysVbdh>\n" +
                "            </cas:attributes>\n" +
                "    </cas:authenticationSuccess>\n" +
                "</cas:serviceResponse>\n";
        xml=xml.replace("cas:","");
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("authenticationSuccess");

            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                AuthenticationSuccess t=getUserInfo(nNode);
                System.out.println(t.toString());
//                System.out.println("\nCurrent Element :" + nNode.getNodeName());
//
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                    Element eElement = (Element) nNode;
//                    System.out.println("First Name : " + eElement.getElementsByTagName("user").item(0).getTextContent());
//                }
            }
            String ticket="<samlp:LogoutRequest xmlns:samlp=\"urn:oasis:names:tc:SAML:2.0:protocol\" ID=\"LR-566-TDvnZx03WjejOiaJKHztb4DqrVpvcjVgzLZ\" Version=\"2.0\" IssueInstant=\"2018-04-14T08:28:48Z\">\n" +
                    "\t<saml:NameID xmlns:saml=\"urn:oasis:names:tc:SAML:2.0:assertion\">@NOT_USED@</saml:NameID>\n" +
                    "\t<samlp:SessionIndex>ST-455-mQd39FbYjp2rHfu4idrp9ebddn5deiaRf2j</samlp:SessionIndex>\n" +
                    "</samlp:LogoutRequest>";
            System.out.println(getTicketLogout(ticket));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static AuthenticationSuccess getUserInfo(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        AuthenticationSuccess emp = new AuthenticationSuccess();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            emp.setUser(getTagValue("user", element));
            NodeList nList = ((Element) node).getElementsByTagName("attributes");
            Attributes x=new Attributes();
            Node nNode = nList.item(0);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                x.setTen(getTagValue("ten",element));
                x.setEmail(getTagValue("email",element));
            }
            emp.setAttributes(x);
        }

        return emp;
    }


    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    /**
     *
     * @param messageLogout
     * @return
     * <samlp:LogoutRequest xmlns:samlp="urn:oasis:names:tc:SAML:2.0:protocol" ID="LR-566-TDvnZx03WjejOiaJKHztb4DqrVpvcjVgzLZ" Version="2.0" IssueInstant="2018-04-14T08:28:48Z">
    <saml:NameID xmlns:saml="urn:oasis:names:tc:SAML:2.0:assertion">@NOT_USED@</saml:NameID>
    <samlp:SessionIndex>ST-455-mQd39FbYjp2rHfu4idrp9ebddn5deiaRf2j</samlp:SessionIndex>
    </samlp:LogoutRequest>
     */
    private static String getTicketLogout(String messageLogout){
        String xml=messageLogout.replace("samlp:","").replace("saml:","");
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();
            NodeList nodeList= doc.getElementsByTagName("SessionIndex").item(0).getChildNodes();
            Node node= nodeList.item(0);
            return node.getNodeValue();
        }catch (Exception e){
            return null;
        }
    }
    @Override
    public void run(String... args) throws Exception {

    }
}
