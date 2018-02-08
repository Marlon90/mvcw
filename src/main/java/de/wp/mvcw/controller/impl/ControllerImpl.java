package de.wp.mvcw.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.wp.mvcw.controller.ControllerWP;
import de.wp.mvcw.dao.ArticleDao;
import de.wp.mvcw.model.Article;
import de.wp.mvcw.model.Simple;
import de.wp.mvcw.model.impl.ArticleImpl;

@Controller
public class ControllerImpl implements ControllerWP {

	@Autowired
	ArticleDao<Article, Integer> dataDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public ResponseEntity<List<Article>> getArticleList() {
		return new ResponseEntity<List<Article>>(dataDao.list(), HttpStatus.OK);
	}

	@RequestMapping(path="/simple", method=RequestMethod.POST)
	public void testsimple(@RequestBody Simple simple, HttpServletResponse response) {
		System.out.println("jhfdjhfjhgf -> " + simple.getName());
		if (simple.getName() == null) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
		} else {
			response.setStatus(HttpStatus.OK.value());
		}
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST, consumes="application/json" )
	public void saveOrUpdate(@RequestBody ArticleImpl article, HttpServletResponse response) {
		
		dataDao.saveOrUpdate(article);

	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST, consumes="application/json" )
	public void delete(@RequestBody ArticleImpl article, HttpServletResponse response) {
		
		dataDao.delete(article.getId());

	}
	
	@Override
	public Article findById(Integer id) {
		return null;
	}

	@Override
	public Article findByName(String name) {
		return null;
	}

	@Override
	public void addOrUpdate(Article e) {

	}

	@Override
	public void delete(Integer id) {

	}
}