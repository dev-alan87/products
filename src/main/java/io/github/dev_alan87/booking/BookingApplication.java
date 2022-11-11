package io.github.dev_alan87.booking;

import java.util.Arrays;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

	@Bean
	ServletRegistrationBean<Servlet> jsfServletRegistration(ServletContext context) {
		String[] formats = { "*.xhtml", "*.jsf", "/faces/*", "*.faces" };

		context.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		ServletRegistrationBean<Servlet> srb = new ServletRegistrationBean<>();
		srb.setServlet(new FacesServlet());
		srb.setUrlMappings(Arrays.asList(formats));
		srb.setLoadOnStartup(1);

		return srb;
	}

	@Bean
	FilterRegistrationBean<Filter> rewriteFilter() {
		FilterRegistrationBean<Filter> rwFilter = new FilterRegistrationBean<>(new RewriteFilter());
		rwFilter.setDispatcherTypes(DispatcherType.FORWARD, 
										DispatcherType.REQUEST, 
										DispatcherType.ASYNC, 
										DispatcherType.ERROR);
		rwFilter.addUrlPatterns("/*");
		return rwFilter;
	}

}
