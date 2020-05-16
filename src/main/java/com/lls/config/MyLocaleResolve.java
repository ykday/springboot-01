package com.lls.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Locale;

/**
 * @author lls
 * @date 2020/4/6 -7:27 PM
 */
public class MyLocaleResolve implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getParameter("l");

        Locale locale = Locale.getDefault();

        if (!StringUtils.isEmpty(language)){
            String[] split = language.split("_");

           locale = new Locale(split[0], split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
