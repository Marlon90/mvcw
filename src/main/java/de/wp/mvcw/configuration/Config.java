package de.wp.mvcw.configuration;

import java.io.File;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import de.wp.mvcw.dao.ArticleDao;
import de.wp.mvcw.dao.impl.ArticleDaoImpl;
import de.wp.mvcw.model.Article;

@Configuration
public class Config extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".html");
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:sqlite:" + new File("").getAbsolutePath() + "\\articleDB.db");
		return dataSource;
	}

	@Bean
	public ArticleDao<Article, Integer> getArticleDao() {
		return new ArticleDaoImpl(getDataSource());
	}
}