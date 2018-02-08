package de.wp.mvcw.model;

public interface Article {

	void setId(Integer id);

	void setNumber(int number);

	void setName(String name);

	void setCost(int cost);

	void setPrice(int price);

	Integer getId();

	int getNumber();

	String getName();

	int getCost();

	int getPrice();
}
