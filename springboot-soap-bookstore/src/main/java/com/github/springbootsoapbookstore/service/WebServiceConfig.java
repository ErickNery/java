package com.github.springbootsoapbookstore.service;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

	@Bean
	public ServletRegistrationBean messageDispacherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispacherServlet = new MessageDispatcherServlet();
		messageDispacherServlet.setApplicationContext(context);
		messageDispacherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispacherServlet, "/ws/*");
	}

	@Bean(name = "bookStore")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema bookStoreSchema) {
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("BookStorePort");
		defaultWsdl11Definition.setTargetNamespace("https://github.com/ErickNery/java");
		defaultWsdl11Definition.setLocationUri("http://localhost/ws");
		defaultWsdl11Definition.setSchema(bookStoreSchema);
		return defaultWsdl11Definition;
	};

	@Bean
	public XsdSchema bookStoreSchema() {
		return new SimpleXsdSchema(new ClassPathResource("BookStore.xsd"));
	}
}
