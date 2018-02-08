package de.wp.mvcw.model.impl;

import de.wp.mvcw.model.Article;

public class ArticleImpl implements Article {

	private Integer articleId;
	private String articleName;
	private int articleNumber;
	private int articleCost;
	private int articlePrice;
	
	
	@Override
	public Integer getId() {
		return articleId;
	}

	@Override
	public int getNumber() {
		return articleNumber;
	}

	@Override
	public String getName() {
		return articleName;
	}

	@Override
	public int getCost() {
		return articleCost;
	}

	@Override
	public int getPrice() {
		return articlePrice;
	}

	@Override
	public void setId(Integer id) {
		this.articleId = id;
		
	}

	@Override
	public void setNumber(int number) {
		this.articleNumber = number;
	}

	@Override
	public void setName(String name) {
		this.articleName = name;
	}

	@Override
	public void setCost(int cost) {
		this.articleCost = cost;
	}

	@Override
	public void setPrice(int price) {
		this.articlePrice = price;
	}

}
