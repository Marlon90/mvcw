package de.wp.mvcw.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import de.wp.mvcw.model.Article;

public interface ControllerWP {

	
	ResponseEntity<List<Article>> getArticleList();
	Article findById(Integer id);
	Article findByName(String name);
	void addOrUpdate(Article e);
	void delete(Integer id);
	
}
