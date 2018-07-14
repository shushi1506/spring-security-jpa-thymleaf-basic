package com.shushi.spring.blog.supports;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author anhbt 7/5/2018
 * com.shushi.spring.blog.supports
 */
public class ExcelViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {

        return new MyExcelView();
    }
}