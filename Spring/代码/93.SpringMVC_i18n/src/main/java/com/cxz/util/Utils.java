package com.cxz.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
public class Utils {

	public Locale getLocale(HttpServletRequest request, String localKey) {
		String localeStr = request.getParameter(localKey);
		if (localeStr == null || "".equals(localeStr)) {
			return request.getLocale();	
		}
		return new Locale(localeStr.split("_")[0], localeStr.split("_")[1]);
	}
	public void setLocale(HttpServletRequest request, String localKey) {
		HttpSession session = request.getSession();
		session.setAttribute(SessionLocaleResolver.class.getName() + ".LOCALE", getLocale(request, localKey));
	}
}
