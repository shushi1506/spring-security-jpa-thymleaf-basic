package com.shushi.spring.blog.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shushi.spring.blog.models.GooglePojo;
import com.shushi.spring.blog.models.UserSSO;
import com.shushi.spring.blog.models.sso.Attributes;
import com.shushi.spring.blog.models.sso.AuthenticationSuccess;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @author anhbt 8/30/2018
 * com.shushi.spring.blog.common
 */
@Component
public class SSOUtils {
    Logger logger= LogManager.getLogger(SSOUtils.class);
    @Autowired
    private Environment env;
    public AuthenticationSuccess getUserInfo(final String code) throws ClientProtocolException, IOException {
        AuthenticationSuccess t=new AuthenticationSuccess();
        String link = env.getProperty("sso.link.get.user_info")+code;
        String response = Request.Get(link).execute().returnContent().asString();
        String xml=response.replace("cas:","");
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("authenticationSuccess");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                t=getUserInfo(nNode);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }
    public UserDetails buildUser(AuthenticationSuccess userSSO) {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserDetails userDetail = new User(userSSO.getUser(),
                "", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        return userDetail;
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
    public String getTicketLogout(String messageLogout){
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
}
