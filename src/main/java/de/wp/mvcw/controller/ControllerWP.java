package de.wp.mvcw.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import de.wp.mvcw.model.Article;
import de.wp.mvcw.model.impl.ArticleImpl;

public interface ControllerWP {

	
	ResponseEntity<List<Article>> getArticleList();
	void delete(ArticleImpl id, HttpServletResponse response);
	void update (ArticleImpl e, HttpServletResponse response);
	void add(ArticleImpl article, HttpServletResponse response);
	void spam();
}
