package com.shm.bcb.config;

import cn.fanciers.sth.infrastructure.web.argumentresovler.JsonParamArgumentResolver;
import cn.fanciers.sth.infrastructure.config.web.AbstractSthWebMvcConfig;
import com.shm.bcb.interfaces.api.BcbApis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Configuration
@ComponentScan(basePackageClasses = { BcbApis.class })
public class BcbApiServletApplicationContextConfig extends AbstractSthWebMvcConfig {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		addApiTrackingInterceptor(registry);
		addOpenEntityManagerInViewInterceptor(registry, entityManagerFactory);
		addHandlerInfoMDCInterceptor(registry);
	}

	@Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new JsonParamArgumentResolver());
	}
}
