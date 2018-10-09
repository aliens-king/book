package com.assignment.books.internationalizationconfig;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @author SUDHANSHU
 *  Internationalization setup .
 *
 */
@ComponentScan
public class BookConfig   extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("/login");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	/**
	 * Interceptor that allows for changing the current locale on every request,
	 * via a configurable request parameter (default parameter name: "locale").
	 * 
	 * @return
	 */

	/**
	 * LocaleResolver implementation that uses a locale attribute in the user's
	 * session in case of a custom setting, with a fallback to the specified
	 * default locale or the request's accept-header locale. This is most
	 * appropriate if the application needs user sessions anyway, i.e. when the
	 * HttpSession does not have to be created just for storing the user's
	 * locale. The session may optionally contain an associated time zone
	 * attribute as well; alternatively, you may specify a default time zone.
	 * Custom controllers can override the user's locale and time zone by
	 * calling #setLocale(Context) on the resolver, e.g. responding to a locale
	 * change request. As a more convenient alternative, consider using
	 * org.springframework.web.servlet.support.RequestContext.changeLocale. In
	 * contrast to CookieLocaleResolver, this strategy stores locally chosen
	 * locale settings in the Servlet container's HttpSession. As a consequence,
	 * those settings are just temporary for each session and therefore lost
	 * when each session terminates. Note that there is no direct relationship
	 * with external session management mechanisms such as the "Spring Session"
	 * project. This LocaleResolver will simply evaluate and modify
	 * corresponding HttpSession attributes against the current
	 * HttpServletRequest.
	 * 
	 * @return
	 */
	@Bean(name = "localeResolver")
	public LocaleResolver sessionLocaleResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setLocaleAttributeName("locale/");
		// localeResolver.setDefaultLocale(new Locale("en"));
		Locale localByReigon = Locale.getDefault();
		
		localeResolver.setDefaultLocale(localByReigon);
		//localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		return localeChangeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());

	}

	
}