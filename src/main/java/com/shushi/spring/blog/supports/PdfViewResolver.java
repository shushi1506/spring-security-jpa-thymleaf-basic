package com.shushi.spring.blog.supports;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author anhbt 7/13/2018
 * com.shushi.spring.blog.supports
 */
public class PdfViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {

        return new ItextPdfView();
    }
}
