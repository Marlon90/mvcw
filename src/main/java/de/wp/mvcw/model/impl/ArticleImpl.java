package de.wp.mvcw.model.impl;

import de.wp.mvcw.model.Article;

public class ArticleImpl implements Article {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String description;
	private int nummer;
	private int cost;
	private int price;
	
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public int getNummer() {
		return nummer;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}

	@Override
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}

}
