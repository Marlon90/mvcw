package de.wp.mvcw.model;

import java.io.Serializable;

public interface Article extends Serializable {

	void setId(Integer id);

	void setNummer(int number);

	void setDescription(String description);

	void setCost(int cost);

	void setPrice(int price);

	Integer getId();

	int getNummer();

	String getDescription();

	int getCost();

	int getPrice();
}
