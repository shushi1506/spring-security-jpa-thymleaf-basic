package com.shushi.spring.blog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shushi.spring.blog.common.CommonUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author anhbt 7/13/2018
 * com.shushi.spring.blog
 */
public class Test {
    public static void main(String[] args) {

//        System.out.println(StringUtils.defaultIfEmpty(null,"anh"));
//        System.out.println(RandomStringUtils.randomAlphabetic(25));
//        System.out.println(RandomStringUtils.randomNumeric(25));
//        System.out.println(RandomStringUtils.randomAscii(25));
        try {
//            String response = Request.Get("http://api.population.io/1.0/population/2017/Vietnam/18/").execute().returnContent().asString();
//            System.out.println(response);
//            ObjectMapper mapper = new ObjectMapper();
//            PeopleInfo[] u=mapper.readValue(Request.Get("http://api.population.io/1.0/population/2017/Vietnam/18/").execute().returnContent().asStream(),PeopleInfo[].class);
//            Arrays.stream(u).forEach(x -> System.out.println(x.toString()));
//            System.out.println(u.toString());
//            String str="hello";
//            StringBuilder sb=new StringBuilder();
//            for(int i=0;i<str.length();i++){
//                char c = str.charAt(i);
//                int ascii = (int) c;
//                sb.append(Character.toString((char) (ascii+1)).matches("^[auoie]") ? Character.toUpperCase(Integer.parseInt(Character.toString((char) (ascii+1)))) : Character.toString((char) (ascii+1)));
//            }
            Pattern pattern = Pattern.compile("/status(/)*$");
            String requestPath = "/status/ssosessions";
            String service ="https://usertest.baohiemxahoi.gov.vn:1118/cas.php?action=login&server_id=";
//            if (service.matches()) {
//                System.out.println(true);
//            }
            System.out.println(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
