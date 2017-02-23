package com.shm.bcb.config;

import java.util.List;

import cn.fanciers.sth.infrastructure.web.argumentresovler.JsonParamArgumentResolver;
import cn.fanciers.sth.infrastructure.config.web.AbstractSthWebMvcConfig;
import cn.fanciers.sth.infrastructure.config.web.LocaleConfiger;
import cn.fanciers.sth.infrastructure.web.handlebars.EnableSthHandlebars;
import cn.fanciers.sth.infrastructure.web.interceptor.LocaleInterceptor;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import com.shm.bcb.interfaces.web.BcbWebs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableSthHandlebars
@ComponentScan(basePackageClasses = { BcbWebs.class})
public class BcbWebServletApplicationContextConfig extends AbstractSthWebMvcConfig {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private HandlebarsViewResolver handlebarsViewResolver;

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		addApiTrackingInterceptor(registry);
		addOpenEntityManagerInViewInterceptor(registry, entityManagerFactory);
		addHandlerInfoMDCInterceptor(registry);
		registry.addInterceptor(localeChangeInterceptor());
		registry.addInterceptor(localeInterceptor());
	}

    @Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new JsonParamArgumentResolver());

//		Handlebars handlebars = handlebarsViewResolver.getHandlebars();
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		return localeChangeInterceptor;
	}

	@Bean
	public LocaleInterceptor localeInterceptor() {
		return new LocaleInterceptor();
	}

	@Bean
    public LocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(LocaleConfiger.DEFAULT_LOCALE);
        return cookieLocaleResolver;
    }

	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver viewResolver = new BeanNameViewResolver();
		viewResolver.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return viewResolver;
	}
}

