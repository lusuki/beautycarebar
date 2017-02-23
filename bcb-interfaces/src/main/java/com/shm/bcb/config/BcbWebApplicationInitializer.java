package com.shm.bcb.config;

import cn.fanciers.sth.infrastructure.config.web.AbstractSthWebApplicationInitializer;
import cn.fanciers.sth.infrastructure.web.filter.Base64EncodeRequestParamsFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.Map;

public class BcbWebApplicationInitializer extends AbstractSthWebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		loadRootApplicationContext(servletContext, BcbCoreApplicationContextConfig.class);

		loadDefaultFilters(servletContext);
		addBase64EncodeRequestParamsFilter(servletContext);

		addDispatcherServlet(servletContext, "webServlet", BcbWebServletApplicationContextConfig.class, "/");
		addDispatcherServlet(servletContext, "apiServlet", BcbApiServletApplicationContextConfig.class, "/api/*");
	}

	private void addBase64EncodeRequestParamsFilter(ServletContext servletContext) {
		Map<String, String> initParams = new HashMap<>();
		initParams.put("forceEncodingParamValue", "true");
		initParams.put("excludeURIPatters", "/api/*,/export/*,/login,/messageSources,/error");
		addFilter(servletContext, Base64EncodeRequestParamsFilter.class, "base64RequestParamsFilter", initParams, "/*");
	}
}