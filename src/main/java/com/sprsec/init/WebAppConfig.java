package com.sprsec.init;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.sprsec")
@PropertySource("classpath:application.properties")
@ImportResource("classpath:spring-security.xml")
public class WebAppConfig extends WebMvcConfigurerAdapter{
	 private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
		
	    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	    	
		@Autowired
		private Environment env;
		
		@Bean
		public DataSource dataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
			dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
			dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
			dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
			dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
			
			return dataSource;
		}
		
		@Bean
		public LocalSessionFactoryBean sessionFactory() {
			LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
			sessionFactoryBean.setDataSource(dataSource());
			sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
			sessionFactoryBean.setHibernateProperties(hibProperties());
			return sessionFactoryBean;
		}
		
		private Properties hibProperties() {
			Properties properties = new Properties();
			properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
			properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
			return properties;	
		}
		
		@Bean
		public HibernateTransactionManager transactionManager() {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager();
			transactionManager.setSessionFactory(sessionFactory().getObject());
			return transactionManager;
		}
		
		@Bean
		public UrlBasedViewResolver setupViewResolver() {
			UrlBasedViewResolver resolver = new UrlBasedViewResolver();
			//resolver.ser
			resolver.setPrefix("/WEB-INF/pages/");
			resolver.setSuffix(".jsp");
			resolver.setViewClass(JstlView.class);
			return resolver;
		}
		
		
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			    registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
			  }
		
		
}
